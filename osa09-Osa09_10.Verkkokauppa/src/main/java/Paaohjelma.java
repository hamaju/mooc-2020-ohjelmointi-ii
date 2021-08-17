
import java.util.Scanner;

public class Paaohjelma {

    public static void main(String[] args) {
        // tee tänne testikoodia
/*
        Varasto varasto = new Varasto();
        varasto.lisaaTuote("maito", 3, 10);
        varasto.lisaaTuote("kahvi", 5, 6);
        varasto.lisaaTuote("piima", 2, 20);
        varasto.lisaaTuote("jugurtti", 2, 20);

        System.out.println("tuotteet:");

        for (String tuote: varasto.tuotteet()) {
            System.out.println(tuote);
        }
        
        System.out.println("");
        
        Ostos ostos = new Ostos("maito", 4, 2);
        System.out.println("ostoksen joka sisältää 4 maitoa yhteishinta on " + ostos.hinta());
        System.out.println(ostos);
        ostos.kasvataMaaraa();
        System.out.println(ostos);
        
        System.out.println("");
        
        Ostoskori kori = new Ostoskori();
        kori.lisaa("maito", 3);
        kori.lisaa("piima", 2);
        kori.lisaa("juusto", 5);
        System.out.println("korin hinta: " + kori.hinta());
        kori.lisaa("tietokone", 899);
        System.out.println("korin hinta: " + kori.hinta());
        
        System.out.println("");
        
        kori.tulosta();

        Ostoskori kori = new Ostoskori();
        kori.lisaa("maito", 3);
        kori.tulosta();
        System.out.println("korin hinta: " + kori.hinta() + "\n");

        kori.lisaa("piima", 2);
        kori.tulosta();
        System.out.println("korin hinta: " + kori.hinta() + "\n");

        kori.lisaa("maito", 3);
        kori.tulosta();
        System.out.println("korin hinta: " + kori.hinta() + "\n");

        kori.lisaa("maito", 3);
        kori.tulosta();
        System.out.println("korin hinta: " + kori.hinta() + "\n");
*/
        Varasto varasto = new Varasto();
        varasto.lisaaTuote("kahvi", 5, 10);
        varasto.lisaaTuote("maito", 3, 20);
        varasto.lisaaTuote("piima", 2, 55);
        varasto.lisaaTuote("leipa", 7, 8);

        Kauppa kauppa = new Kauppa(varasto, new Scanner(System.in));
        kauppa.asioi("Pekka");
    }
}
