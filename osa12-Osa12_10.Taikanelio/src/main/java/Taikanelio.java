
import java.util.ArrayList;
import java.util.Collections;

public class Taikanelio {

    private int[][] nelio;

    // valmis konstruktori
    public Taikanelio(int koko) {
        if (koko < 2) {
            koko = 2;
        }

        this.nelio = new int[koko][koko];
    }

    // toteuta nämä kolme metodia
    public ArrayList<Integer> rivienSummat() {
        ArrayList<Integer> summat = new ArrayList<>();
        
        for (int rivi = 0; rivi < this.nelio.length; rivi++) {
            int rivinSumma = 0;
            for (int sarake = 0; sarake < this.nelio[rivi].length; sarake++) {
                rivinSumma += this.nelio[rivi][sarake];
            }
            
            summat.add(rivinSumma);
        }
        
        return summat;
    }

    public ArrayList<Integer> sarakkeidenSummat() {
        ArrayList<Integer> summat = new ArrayList<>();
        
        for (int sarake = 0; sarake < this.nelio.length; sarake++) {
            int sarakkeenSumma = 0;
            for (int rivi = 0; rivi < this.nelio[sarake].length; rivi++) {
                sarakkeenSumma += this.nelio[rivi][sarake];
            }
            
            summat.add(sarakkeenSumma);
        }
        
        return summat;
    }

    public ArrayList<Integer> lavistajienSummat() {
        ArrayList<Integer> summat = new ArrayList<>();
        
        // vasemmalta ylhäältä alas
        int lavistaja1Summa = 0;
        for (int i = 0; i < this.nelio.length; i++) {
            lavistaja1Summa += this.nelio[i][i];
        }
        // vasemmalta alhaalta ylös
        int lavistaja2Summa = 0;
        for (int i = 0; i < this.nelio.length; i++) {
            lavistaja2Summa += this.nelio[i][(this.nelio.length - 1) - i];
        }
        
        summat.add(lavistaja1Summa);
        summat.add(lavistaja2Summa);
        return summat;
    }

    // valmiit apumetodit -- älä koske näihin
    public boolean onTaikanelio() {
        return summatSamat() && kaikkiNumerotEri();
    }

    public ArrayList<Integer> annaKaikkiNumerot() {
        ArrayList<Integer> numerot = new ArrayList<>();
        for (int rivi = 0; rivi < nelio.length; rivi++) {
            for (int sarake = 0; sarake < nelio[rivi].length; sarake++) {
                numerot.add(nelio[rivi][sarake]);
            }
        }

        return numerot;
    }

    public boolean kaikkiNumerotEri() {
        ArrayList<Integer> numerot = annaKaikkiNumerot();

        Collections.sort(numerot);
        for (int i = 1; i < numerot.size(); i++) {
            if (numerot.get(i - 1) == numerot.get(i)) {
                return false;
            }
        }

        return true;
    }

    public boolean summatSamat() {
        ArrayList<Integer> summat = new ArrayList<>();
        summat.addAll(rivienSummat());
        summat.addAll(sarakkeidenSummat());
        summat.addAll(lavistajienSummat());

        if (summat.size() < 3) {
            return false;
        }

        for (int i = 1; i < summat.size(); i++) {
            if (summat.get(i - 1) != summat.get(i)) {
                return false;
            }
        }

        return true;
    }

    public int annaArvo(int x, int y) {
        if (x < 0 || y < 0 || x >= getLeveys() || y >= getKorkeus()) {
            return - 1;
        }

        return this.nelio[y][x];
    }

    public void asetaArvo(int x, int y, int arvo) {
        if (x < 0 || y < 0 || x >= getLeveys() || y >= getKorkeus()) {
            return;
        }

        this.nelio[y][x] = arvo;
    }

    public int getLeveys() {
        return this.nelio.length;
    }

    public int getKorkeus() {
        return this.nelio.length;
    }

    @Override
    public String toString() {
        StringBuilder palautus = new StringBuilder();
        for (int rivi = 0; rivi < nelio.length; rivi++) {
            for (int sarake = 0; sarake < nelio[rivi].length; sarake++) {
                palautus.append(nelio[rivi][sarake]).append("\t");
            }

            palautus.append("\n");
        }

        return palautus.toString();
    }
}
