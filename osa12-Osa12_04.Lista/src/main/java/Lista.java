/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juhani
 */
public class Lista<T> {
    
    private T[] arvot;
    private int arvoja;

    public Lista() {
        this.arvot = (T[]) new Object[10];
        this.arvoja = 0;
    }
    
    public void lisaa(T arvo) {
        // kasvatetaan taulukon kokoa kun se on täynnä
        if(this.arvoja == this.arvot.length) {
                kasvata();
        }
        
        this.arvot[this.arvoja] = arvo;
        this.arvoja++;
    }
    
    private void kasvata() {
        // uuden taulukon koko on 1.5x vanha taulukko
        int uusiKoko = this.arvot.length + this.arvot.length / 2;
        // luodaan uusi taulukko, johon vanhan taulukon arvot kopioidaan
        T[] uusi = (T[]) new Object[uusiKoko];
        for (int i = 0; i < this.arvot.length; i++) {
            uusi[i] = this.arvot[i];
        }

        this.arvot = uusi;
    }
    
    public boolean sisaltaa(T arvo) {
        return arvonIndeksi(arvo) >= 0;
    }
    
    public void poista(T arvo) {
        int arvonIndeksi = arvonIndeksi(arvo);
        if (arvonIndeksi < 0) {
            return; // ei löydy
        }
        // kopioidaan poiston yhteydessä jokaisen poistettua alkiota 
        // seuraavan alkion vasemmalle -> ei ole kovin tehokas menetelmä
        siirraVasemmalle(arvonIndeksi);
        this.arvoja--;
    }
    
    public int arvonIndeksi(T arvo) {
        for (int i = 0; i < this.arvoja; i++) {
            if (this.arvot[i].equals(arvo)) {
                return i;
            }
        }

        return -1;
    }
    
    private void siirraVasemmalle(int indeksistaLahtien) {
        for (int i = indeksistaLahtien; i < this.arvoja - 1; i++) {
            this.arvot[i] = this.arvot[i + 1];
        }
    }
    
    public T arvo(int indeksi) {
        if (indeksi < 0 || indeksi >= this.arvoja) {
            throw new ArrayIndexOutOfBoundsException("Indeksi " + indeksi + " alueen [0, " + this.arvoja + "[ ulkopuolella.");
        }

        return this.arvot[indeksi];
    }
    
    public int koko() {
        return this.arvoja;
    }
}
