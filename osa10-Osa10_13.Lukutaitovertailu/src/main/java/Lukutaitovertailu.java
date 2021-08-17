
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lukutaitovertailu {
    
    public static void main(String[] args) {
        ArrayList<Valtio> valtiot = new ArrayList<Valtio>();
        String tiedosto = "lukutaito.csv";
        
        try {
            Files.lines(Paths.get(tiedosto))
                    // [0]                  [1]                   [2]
                    // Adult literacy rate, population 15+ years, female (%),
                    // [3]                         [4]  [5]
                    // United Republic of Tanzania,2015,76.08978
                    .map(rivi -> rivi.split(","))
                    // Valtio(String nimi, int vuosi, String sukupuoli, double lukutaito)
                    .map(palat -> new Valtio(palat[3].trim(), 
                            Integer.valueOf(palat[4]), 
                            palat[2].substring(0, palat[2].indexOf("(%)")).trim(), 
                            Double.valueOf(palat[5])))
                    .forEach(valtio -> valtiot.add(valtio));
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
        }
        
        //valtiot.stream().sorted().forEach(valtio -> System.out.println(valtio));
        
        Collections.sort(valtiot);
        
        for (Valtio valtio : valtiot) {
            System.out.println(valtio);
        }
    }
}
