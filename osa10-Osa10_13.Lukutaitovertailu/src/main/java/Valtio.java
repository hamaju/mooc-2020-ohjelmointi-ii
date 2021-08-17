/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author haha
 */
public class Valtio implements Comparable<Valtio> {
    
    private String nimi;
    private int vuosi;
    private String sukupuoli;
    private double lukutaito;
    
    public Valtio(String nimi, int vuosi, String sukupuoli, double lukutaito) {
        this.nimi = nimi;
        this.vuosi = vuosi;
        this.sukupuoli = sukupuoli;
        this.lukutaito = lukutaito;
    }

    @Override
    public String toString() {
        return this.nimi + " (" + this.vuosi + "), " + this.sukupuoli + ", " + this.lukutaito;
    }    
    
    @Override
    public int compareTo(Valtio t) {
        if (this.lukutaito == t.lukutaito) {
            return 0;
        } else if (this.lukutaito < t.lukutaito) {
            return -1;
        } else {
            return 1;
        }
    }
}
