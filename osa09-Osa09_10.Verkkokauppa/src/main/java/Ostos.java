/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author haha
 */
public class Ostos {
    
    private String tuote;
    private int maara;
    private int yksikkohinta;
    
    public Ostos(String tuote, int kpl, int yksikkohinta) {
        this.tuote = tuote;
        this.maara = kpl;
        this.yksikkohinta = yksikkohinta;
    }
    
    public int hinta() {
        return this.maara * this.yksikkohinta;
    }
    
    public void kasvataMaaraa() {
        this.maara++;
    }
    
    @Override
    public String toString() {
        return this.tuote + ": " + this.maara;
    }
}
