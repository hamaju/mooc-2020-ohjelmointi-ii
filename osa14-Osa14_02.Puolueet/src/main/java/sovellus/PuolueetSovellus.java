package sovellus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PuolueetSovellus extends Application {

    @Override
    public void start(Stage ikkuna) {
        NumberAxis xAkseli = new NumberAxis(1968, 2008, 4);
        NumberAxis yAkseli = new NumberAxis(0, 30, 5);
        
        LineChart<Number, Number> viivakaavio = new LineChart<>(xAkseli, yAkseli);
        viivakaavio.setTitle("Puolueiden suhteellinen kannatus");

        List<String> rivit = new ArrayList<>();
        try {
            //Files.lines(Paths.get("puoluedata.tsv")).map(line -> line.split("\t")).forEach(rivi -> rivit.add(rivi));
            Files.lines(Paths.get("puoluedata.tsv")).map(line -> line).forEach(rivi -> rivit.add(rivi));
        } catch (IOException e) {
            System.out.println("Tiedostoa ei voitu lukea");
            return;
        }
        
        // luodaan hajautustaulu, joka sisältää puolueen puolueiden nimet
        // ja toisen hajautustaulun jossa on kannatus eri vuosina
        Map<String, Map<Integer, Double>> puolueet = new HashMap<>();
        String[] vuodet = rivit.get(0).split("\t");
        
        // käydään rivit läpi
        // aloitetaan rivistä 1, koska ekalla rivillä on selitteet
        for (int i = 1; i < rivit.size(); i++) {
            String[] palat = rivit.get(i).split("\t");
            String puolue = palat[0];
            Map<Integer, Double> kannatus = new HashMap<>();
            // käydään rivien paloitellut arvot (sarakkeet) läpi
            // aloitetaan palasta (sarakkeesta) 1, koska eka pala on selite
            for (int j = 1; j < vuodet.length; j++) {
                if (!palat[j].equals("-")) {
                    kannatus.put(Integer.parseInt(vuodet[j]), Double.parseDouble(palat[j]));
                }
            }
            
            puolueet.put(puolue, kannatus);
        }
        
        puolueet.keySet().stream().forEach(puolue -> {
            // jokaiselle puolueelle luodaan oma datajoukko
            XYChart.Series data = new XYChart.Series();
            data.setName(puolue);

            // datajoukkoon lisätään puolueen pisteet
            puolueet.get(puolue).entrySet().stream().forEach(pari -> {
                data.getData().add(new XYChart.Data(pari.getKey(), pari.getValue()));
            });

            // datajoukko lisätään kaavioon
            viivakaavio.getData().add(data);
        });
        
        Scene nakyma = new Scene(viivakaavio);
        ikkuna.setScene(nakyma);
        ikkuna.show();
    }    
    
    public static void main(String[] args) {
        launch();
    }
}
