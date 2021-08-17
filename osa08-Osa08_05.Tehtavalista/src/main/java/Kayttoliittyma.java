
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author haha
 */
public class Kayttoliittyma {
    
    private Tehtavalista tehtavat;
    private Scanner lukija;
    
    public Kayttoliittyma(Tehtavalista tehtavat, Scanner lukija) {
        this.tehtavat = tehtavat;
        this.lukija = lukija;
    }
    
    public void kaynnista() {
        while (true) {
            System.out.print("Komento: ");
            String komento = lukija.nextLine();
            
            if (komento.equals("lopeta")) {
                break;
            }
            
            if (komento.equals("lisaa")) {
                System.out.print("Lisättävä: ");
                String lisattava = lukija.nextLine();
                tehtavat.lisaa(lisattava);
            }
            
            if (komento.equals("poista")) {
                System.out.print("Mikä poistetaan? ");
                int poistettava = Integer.valueOf(lukija.nextLine());
                tehtavat.poista(poistettava);
            }
            
            if (komento.equals("listaa")) {
                tehtavat.tulosta();
            }
        }
    }
}
