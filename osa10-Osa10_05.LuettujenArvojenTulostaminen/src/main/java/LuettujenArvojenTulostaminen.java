
import java.util.ArrayList;
import java.util.Scanner;

public class LuettujenArvojenTulostaminen {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        ArrayList<String> rivit = new ArrayList<>();
        
        while (true) {
            String syote = lukija.nextLine();
            
            if (syote.equals("")) {
                break;
            }
            
            rivit.add(syote);
        }
        
        rivit.stream()
                .forEach(rivi -> System.out.println(rivi));
    }
}
