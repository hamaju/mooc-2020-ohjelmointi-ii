
import java.util.ArrayList;
import java.util.Scanner;

public class LukujenKeskiarvo {

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
        
        double keskiarvo = luvut.stream()
                .mapToInt(s -> s)
                .average()
                .getAsDouble();
        
        System.out.println("Lukujen keskiarvo: " + keskiarvo);
    }
}
