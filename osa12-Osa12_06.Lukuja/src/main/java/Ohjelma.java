
import java.util.Random;
import java.util.Scanner;

public class Ohjelma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Random arpoja = new Random();
        System.out.println("Montako satunnaislukua tulostetaan?");
        int maara = Integer.parseInt(lukija.nextLine());
        
        for (int i = 0; i < maara; i++) {
            int luku = arpoja.nextInt(11);
            System.out.println(luku);
        }
    }
}
