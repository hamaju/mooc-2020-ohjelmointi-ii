
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // tee tänne testikoodia
/*        
        Opettaja ada = new Opettaja("Ada Lovelace", "Korsontie 1 03100 Vantaa", 1200);
        Opettaja esko = new Opettaja("Esko Ukkonen", "Mannerheimintie 15 00100 Helsinki", 5400);
        System.out.println(ada);
        System.out.println(esko);

        Opiskelija olli = new Opiskelija("Olli", "Ida Albergintie 1 00400 Helsinki");

        int i = 0;
        while (i < 25) {
          olli.opiskele();
          i = i + 1;
        }
        System.out.println(olli);
*/
        ArrayList<Henkilo> henkilot = new ArrayList<Henkilo>();
        henkilot.add(new Opettaja("Ada Lovelace", "Korsontie 1 03100 Vantaa", 1200));
        henkilot.add(new Opiskelija("Olli", "Ida Albergintie 1 00400 Helsinki"));

        tulostaHenkilot(henkilot);
    }
    
    public static void tulostaHenkilot(ArrayList<Henkilo> henkilot) {
        for (Henkilo henkilo : henkilot) {
            System.out.println(henkilo);
        }
    }
}
