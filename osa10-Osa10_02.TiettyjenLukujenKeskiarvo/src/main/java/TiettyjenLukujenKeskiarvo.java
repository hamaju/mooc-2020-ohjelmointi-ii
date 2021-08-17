
import java.util.ArrayList;
import java.util.Scanner;

public class TiettyjenLukujenKeskiarvo {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        // toteuta ohjelmasi tänne
        ArrayList<Integer> luvut = new ArrayList<>();
        
        System.out.println("Kirjoita syötteitä, \"loppu\" lopettaa.");
        
        while (true) {
            String syote = lukija.nextLine();
            
            if (syote.equals("loppu")) {
                break;
            }
            
            luvut.add(Integer.valueOf(syote));
        }
                
        System.out.println("Tulostetaanko negatiivisten vai positiivisten lukujen keskiarvo? (n/p)");
        String komento = lukija.nextLine();
        
        if (komento.equals("n")) {
            double keskiarvo = luvut.stream()
                    .mapToInt(s -> s)
                    .filter(luku -> luku < 0)
                    .average()
                    .getAsDouble();
            
            System.out.println("Negatiivisten lukujen keskiarvo: " + keskiarvo);
        }
        
        if (komento.equals("p")) {
            double keskiarvo = luvut.stream()
                    .mapToInt(s -> s)
                    .filter(luku -> luku > 0)
                    .average()
                    .getAsDouble();
            
            System.out.println("Positiivisten lukujen keskiarvo: " + keskiarvo);
        }
    }
}
