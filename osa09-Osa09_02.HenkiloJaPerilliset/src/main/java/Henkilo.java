/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author haha
 */
public class Henkilo {
    
    private String nimi;
    private String osoite;
    
    public Henkilo(String nimi, String osoite) {
        this.nimi = nimi;
        this.osoite = osoite;
    }
    
    @Override
    public String toString() {
        return this.nimi + "\n" + 
        "  "  + this.osoite;
    }
}
