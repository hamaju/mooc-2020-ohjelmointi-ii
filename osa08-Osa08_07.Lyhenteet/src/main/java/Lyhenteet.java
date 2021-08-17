
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
public class Lyhenteet {
    private HashMap<String, String> lyhenteet;
    
    public Lyhenteet() {
        this.lyhenteet = new HashMap<>();
    }
    
    public void lisaaLyhenne(String lyhenne, String selite) {
        this.lyhenteet.put(lyhenne, selite);
    }
    
    public boolean onkoLyhennetta(String lyhenne) {
        if (lyhenteet.containsKey(lyhenne)) {
            return true;
        }
        
        return false;
    }
    
    public String haeLyhenne(String lyhenne) {
        if (lyhenteet.containsKey(lyhenne)) {
            return lyhenteet.get(lyhenne);
        }
        
        return null;
    }
}
