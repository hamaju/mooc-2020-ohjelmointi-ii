
import java.util.Scanner;

public class Kuutiot {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        
        while (true) {
            String syote = lukija.nextLine();
            
            if (syote.equals("loppu")) {
                break;
            }
            
            System.out.println(Integer.valueOf(syote) * Integer.valueOf(syote) * Integer.valueOf(syote));
        }
    }
}
