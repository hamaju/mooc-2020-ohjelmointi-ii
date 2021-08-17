
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juhani
 */
public class Hajautustaulu<K, V> {
    
    private ArrayList<Pari<K, V>>[] arvot;
    private int arvoja;

    public Hajautustaulu() {
        this.arvot = new ArrayList[32];
        this.arvoja = 0;
    }
    
    public V hae(K avain) {
        // lasketaan ensin avaimen hajautusarvo ja päätellään sen perusteella 
        // hajautustaulun sisäisen taulukon indeksi
        // jakojäännöstä käytetään hajautusarvon hajautustaulun koon sisällä pysymiseen
        int hajautusArvo = Math.abs(avain.hashCode() % this.arvot.length);
        if (this.arvot[hajautusArvo] == null) {
            return null;
        }

        ArrayList<Pari<K, V>> arvotIndeksissa = this.arvot[hajautusArvo];

        // käydään taulukon indeksissä oleva lista läpi, ja verrataan avaimen 
        // yhtäsuuruutta jokaiseen listan avain-arvo -parin avaimeen
        for (int i = 0; i < this.arvoja; i++) {
            if (arvotIndeksissa.get(i).getAvain().equals(avain)) {
                // palautetaan listalta löytyneen avaimen arvo
                return arvotIndeksissa.get(i).getArvo();
            }
        }

        return null;
    }
    
    public void lisaa(K avain, V arvo) {
        ArrayList<Pari<K, V>> arvotIndeksissa = haeAvaimeenLittyvaLista(avain);
        int i = haeAvaimenIndeksi(arvotIndeksissa, avain);

        if (i < 0) {
            arvotIndeksissa.add(new Pari<>(avain, arvo));
            this.arvoja++;
        } else {
            arvotIndeksissa.get(i).setArvo(arvo);
        }
        
        // hajautustaulun kokoa kasvatetaan aina jos hajautustaulussa olevien 
        // avain-arvo -parien määrä on yli 75% taulukon koosta
        if (1.0 * this.arvoja / this.arvot.length > 0.75) {
            kasvata();
        }
    }
    
    public V poista(K avain) {
        // haetaan avaimeen liittyvä lista
        // haeAvaimeenLittyvaLista luo uuden listan jos sitä ei ole jo olemassa
        ArrayList<Pari<K, V>> arvotIndeksissa = haeAvaimeenLittyvaLista(avain);
        // palautetaan null jos listassa ei ole arvoja
        if (arvotIndeksissa.size() == 0) { //.isEmpty() toimii myös
            return null;
        }
        
        // haeAvaimenIndeksi palauttaa -1
        // jos avainta ei löydy palautetaan null
        int i = haeAvaimenIndeksi(arvotIndeksissa, avain);
        if (i < 0) {
            return null;
        }

        // kopioidaan indeksissä oleva lista muuttujaan
        Pari<K, V> pari = arvotIndeksissa.get(i);
        // poistetaan lista
        arvotIndeksissa.remove(pari);
        // palautetaan vielä poistettu arvo
        return pari.getArvo();
    }

    private void kasvata() {
        // luodaan uusi taulukko
        ArrayList<Pari<K, V>>[] uusi = new ArrayList[this.arvot.length * 2];

        for (int i = 0; i < this.arvot.length; i++) {
            // kopioidaan vanhan taulukon arvot uuteen
            kopioi(uusi, i);
        }

        // korvataan vanha taulukko uudella
        this.arvot = uusi;
    }
    
    private void kopioi(ArrayList<Pari<K, V>>[] uusi, int indeksista) {
        for (int i = 0; i < this.arvot[indeksista].size(); i++) {
            Pari<K, V> arvo = this.arvot[indeksista].get(i);

            int hajautusarvo = Math.abs(arvo.getAvain().hashCode() % uusi.length);
            if(uusi[hajautusarvo] == null) {
                uusi[hajautusarvo] = new ArrayList<>();
            }

            uusi[hajautusarvo].add(arvo);
        }
    }
    
    private ArrayList<Pari<K, V>> haeAvaimeenLittyvaLista(K avain) {
        // lasketaan hajautusarvo avaimelle
        int hajautusArvo = Math.abs(avain.hashCode() % arvot.length);
        // luodaan uusi lista, jos hajautusarvoa ei ole
        if (arvot[hajautusArvo] == null) {
            arvot[hajautusArvo] = new ArrayList<>();
        }
        
        // palautetaan arvo taulukossa lasketun hajautusarvon kohdalta
        return arvot[hajautusArvo];
    }

    private int haeAvaimenIndeksi(ArrayList<Pari<K, V>> lista, K avain) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getAvain().equals(avain)) {
                return i;
            }
        }

        return -1;
    }
}
