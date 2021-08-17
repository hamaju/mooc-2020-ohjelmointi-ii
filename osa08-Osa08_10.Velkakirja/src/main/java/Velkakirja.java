
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author haha
 */
public class Velkakirja {
    
    private HashMap<String, Double> velat;
    
    public Velkakirja() {
        this.velat = new HashMap<>();
    }
    
    public void asetaLaina(String kenelle, double maara) {
        this.velat.put(kenelle, maara);
    }
    
    public double paljonkoVelkaa(String kuka) {
        if (this.velat.containsKey(kuka)) {
            return this.velat.get(kuka);
        }
        
        return 0;
    }
}
