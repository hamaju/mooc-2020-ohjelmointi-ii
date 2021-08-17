
import java.util.Scanner;

public class Paaohjelma {

    public static void main(String[] args) {
        // tee tänne testikoodia josta kutsut ohjelmoitavia metodeja   
        Scanner lukija = new Scanner(System.in);
        System.out.print("Anna merkkijono: ");
        String mjono = lukija.nextLine();
        
        if (new Tarkistin().onViikonpaiva(mjono)) {
            System.out.println("Muoto on oikea.");
        } else {
            System.out.println("Muoto ei ole oikea.");
        }
        
        if (new Tarkistin().kaikkiVokaaleja(mjono)) {
            System.out.println("Muoto on oikea.");
        } else {
            System.out.println("Muoto ei ole oikea.");
        }
        
        if (new Tarkistin().kellonaika(mjono)) {
            System.out.println("Muoto on oikea.");
        } else {
            System.out.println("Muoto ei ole oikea.");
        }
    }
}
