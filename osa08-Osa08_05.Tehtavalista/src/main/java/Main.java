
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Kokeile sovelluksen osien yhteistoimintaa täällä
        Tehtavalista lista = new Tehtavalista();
        lista.lisaa("yksi");
        lista.lisaa("kaksi");
        lista.lisaa("kolme");
        Scanner lukija = new Scanner(System.in);

        Kayttoliittyma liittyma = new Kayttoliittyma(lista, lukija);
        liittyma.kaynnista();
        lista.tulosta();
    }
}
