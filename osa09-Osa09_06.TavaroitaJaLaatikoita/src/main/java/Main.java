
public class Main {

    public static void main(String[] args) {
        // testaa täällä luokkiesi toimintaa
/*
        Kirja kirja1 = new Kirja("Fedor Dostojevski", "Rikos ja Rangaistus", 2);
        Kirja kirja2 = new Kirja("Robert Martin", "Clean Code", 1);
        Kirja kirja3 = new Kirja("Kent Beck", "Test Driven Development", 0.5);

        CDLevy cd1 = new CDLevy("Pink Floyd", "Dark Side of the Moon", 1973);
        CDLevy cd2 = new CDLevy("Wigwam", "Nuclear Nightclub", 1975);
        CDLevy cd3 = new CDLevy("Rendezvous Park", "Closer to Being Here", 2012);

        System.out.println(kirja1);
        System.out.println(kirja2);
        System.out.println(kirja3);
        System.out.println(cd1);
        System.out.println(cd2);
        System.out.println(cd3);
        
        System.out.println("--------");
        
        Laatikko laatikko = new Laatikko(10);

        laatikko.lisaa(new Kirja("Fedor Dostojevski", "Rikos ja Rangaistus", 2)) ;
        laatikko.lisaa(new Kirja("Robert Martin", "Clean Code", 1));
        laatikko.lisaa(new Kirja("Kent Beck", "Test Driven Development", 0.7));

        laatikko.lisaa(new CDLevy("Pink Floyd", "Dark Side of the Moon", 1973));
        laatikko.lisaa(new CDLevy("Wigwam", "Nuclear Nightclub", 1975));
        laatikko.lisaa(new CDLevy("Rendezvous Park", "Closer to Being Here", 2012));

        System.out.println(laatikko);
*/        
        Laatikko laatikko1 = new Laatikko(10);
        Laatikko laatikko2 = new Laatikko(20);
        Laatikko laatikko3 = new Laatikko(30);
        
        laatikko1.lisaa(new Kirja("Fedor Dostojevski", "Rikos ja Rangaistus", 2));
        laatikko2.lisaa(new Kirja("Robert Martin", "Clean Code", 1));
        laatikko3.lisaa(new CDLevy("Algernon Cadwaller", "Fun", 2010));
        
        laatikko2.lisaa(laatikko1);
        laatikko3.lisaa(laatikko2);
        //laatikko1.lisaa(laatikko1); // StackOverflowError
        
        System.out.println(laatikko1);
        System.out.println(laatikko2);
        System.out.println(laatikko3);
    }
}
