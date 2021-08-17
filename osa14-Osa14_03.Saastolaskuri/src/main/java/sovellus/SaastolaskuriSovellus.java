package sovellus;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SaastolaskuriSovellus extends Application {
    
    @Override
    public void start(Stage ikkuna) {
        BorderPane asettelu = new BorderPane();
        
        Label tallennusTeksti = new Label("Kuukausittainen tallennus");
        Label tallennusArvo = new Label("25");
        Label korkoTeksti = new Label("Vuosittainen korko");
        Label korkoArvo = new Label("0"); 
        
        Slider tallennusLiukuri = new Slider(25, 250, 25);
        tallennusLiukuri.setShowTickMarks(true);
        tallennusLiukuri.setShowTickLabels(true);
        
        Slider korkoLiukuri = new Slider(0, 10, 0);
        korkoLiukuri.setShowTickMarks(true);
        korkoLiukuri.setShowTickLabels(true);
        
        BorderPane tallennusBP = new BorderPane();
        tallennusBP.setLeft(tallennusTeksti);
        tallennusBP.setCenter(tallennusLiukuri);
        tallennusBP.setRight(tallennusArvo);
        
        BorderPane korkoBP = new BorderPane();
        korkoBP.setLeft(korkoTeksti);
        korkoBP.setCenter(korkoLiukuri);
        korkoBP.setRight(korkoArvo);
        
        VBox vb = new VBox();
        vb.getChildren().addAll(tallennusBP, korkoBP);
        
        NumberAxis xAkseli = new NumberAxis(0, 30, 1);
        NumberAxis yAkseli = new NumberAxis();
        LineChart viivakaavio = new LineChart(xAkseli, yAkseli);
        viivakaavio.setTitle("Säästölaskuri");
        viivakaavio.setLegendVisible(false);
        viivakaavio.setAnimated(false);
        
        XYChart.Series saastot = new XYChart.Series();
        saastot.setName("Tallennukset");
        XYChart.Series saastotKoroilla = new XYChart.Series();
        saastotKoroilla.setName("Tallennukset korkoineen");
        
        asettelu.setTop(vb);
        asettelu.setCenter(viivakaavio);
        asettelu.setPadding(new Insets(10, 10, 10, 10));
        
        // alkutilanne (minimitallennus)
        piirraKuvaajat(Double.parseDouble(tallennusArvo.getText()),
                Double.parseDouble(korkoArvo.getText()), 
                saastot, saastotKoroilla);
        
        tallennusLiukuri.valueProperty().addListener((muutos, vanhaArvo, uusiArvo) -> {
        // tai: tallennusLiukuri.setOnMouseReleased(e -> {
            tallennusArvo.setText(String.format("%.2f", uusiArvo));
            piirraKuvaajat(Double.parseDouble(tallennusArvo.getText()), 
                    Double.parseDouble(korkoArvo.getText()), 
                    saastot, saastotKoroilla);
        });
        
        korkoLiukuri.valueProperty().addListener((muutos, vanhaArvo, uusiArvo) -> {
            korkoArvo.setText(String.format("%.2f", uusiArvo));
            piirraKuvaajat(Double.parseDouble(tallennusArvo.getText()), 
                    Double.parseDouble(korkoArvo.getText()), 
                    saastot, saastotKoroilla);
        });

        viivakaavio.getData().add(saastot);
        viivakaavio.getData().add(saastotKoroilla);
        
        Scene nakyma = new Scene(asettelu, 640, 480);
        ikkuna.setScene(nakyma);
        ikkuna.show();
    }
    
    public static void piirraKuvaajat(double tallennus, double korko, XYChart.Series saastot, XYChart.Series saastotKoroilla) {
        saastot.getData().clear();
        saastotKoroilla.getData().clear();
        
        korko = 1 + korko / 100;
        
        double summa = 0;
        double saastotKoroillaSumma = 0;
        for (int i = 0; i <= 30; i++) {
            saastot.getData().add(new XYChart.Data(i, summa));
            summa += tallennus * 12;
            saastotKoroilla.getData().add(new XYChart.Data(i, saastotKoroillaSumma));
            saastotKoroillaSumma = (saastotKoroillaSumma + (tallennus * 12)) * korko;
        }
    }
    
    public static void main(String[] args) {
        launch(SaastolaskuriSovellus.class);
    }
}
