
import java.util.Scanner;

public class PositiivistenLukujenKeskiarvo {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        int summa = 0;
        int lukuja = 0;

        while (true) {
            int luku = Integer.valueOf(lukija.nextLine());

            if (luku < 0) {
                continue;
            }

            if (luku == 0) {
                break;
            }

            summa += luku;
            lukuja++;
        }
        
        if (lukuja == 0) {
            System.out.println("keskiarvon laskeminen ei ole mahdollista");
        } else {
            System.out.println(1.0 * summa / lukuja);
        }
    }
}
