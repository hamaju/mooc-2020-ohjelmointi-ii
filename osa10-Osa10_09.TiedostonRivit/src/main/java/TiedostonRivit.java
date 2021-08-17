
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TiedostonRivit {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        // testaa metodia täällä
        System.out.println(lue("tiedosto.txt"));
    }

    public static List<String> lue(String tiedosto) {
        List<String> rivit = new ArrayList<>();

        try {
            Files.lines(Paths.get(tiedosto)).forEach(rivi -> rivit.add(rivi));
            //return Files.lines(Paths.get(tiedosto)).collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
        }
        
        return rivit;
        //return new ArrayList<>();
    }
}
