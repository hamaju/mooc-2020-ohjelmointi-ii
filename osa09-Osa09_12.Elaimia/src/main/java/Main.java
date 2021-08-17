
public class Main {

    public static void main(String[] args) {
        // voit kokeilla luomiesi luokkien toimintaa täällä
/*
        Koira koira = new Koira();
        koira.hauku();
        koira.syo();

        Koira vuffe = new Koira("Vuffe");
        vuffe.hauku();
        
        Kissa kissa = new Kissa();
        kissa.mourua();
        kissa.syo();

        Kissa karvinen = new Kissa("Karvinen");
        karvinen.mourua();
*/        
        Aanteleva koira = new Koira();
        koira.aantele();

        Aanteleva kissa = new Kissa("Karvinen");
        kissa.aantele();
        Kissa k = (Kissa) kissa;
        k.mourua();
    }
}
