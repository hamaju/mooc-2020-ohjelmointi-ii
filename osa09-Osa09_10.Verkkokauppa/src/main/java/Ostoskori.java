
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author haha
 */
public class Ostoskori {
    
    private Map<String, Ostos> ostokset;
    
    public Ostoskori() {
        this.ostokset = new HashMap<>();
    }
    
    public void lisaa(String tuote, int hinta) {        
        Ostos ostos = new Ostos(tuote, 1, hinta);
        if (this.ostokset.containsKey(tuote)) {
            this.ostokset.get(tuote).kasvataMaaraa();
        } else {
            this.ostokset.put(tuote, ostos);
        }
    }
    
    public int hinta() {
        int kokonaishinta = 0;
        for (Ostos ostos : this.ostokset.values()) {
            kokonaishinta += ostos.hinta();
        }
        
        return kokonaishinta;
    }
    
    public void tulosta() {
        for (Ostos ostos : this.ostokset.values()) {
            System.out.println(ostos);
        }
    }
}
