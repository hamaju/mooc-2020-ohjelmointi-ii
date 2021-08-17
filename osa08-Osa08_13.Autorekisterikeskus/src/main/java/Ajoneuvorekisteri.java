
import java.util.ArrayList;
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
public class Ajoneuvorekisteri {
    
    private HashMap<Rekisterinumero, String> omistajat;
    
    public Ajoneuvorekisteri() {
        this.omistajat = new HashMap<>();
    }
    
    public boolean lisaa(Rekisterinumero rekkari, String omistaja) {
        if (this.omistajat.get(rekkari) == null) {
            this.omistajat.put(rekkari, omistaja);
            return true;
        }

        return false;
    }
    
    public String hae(Rekisterinumero rekkari) {
        if (this.omistajat.containsKey(rekkari)) {
            return this.omistajat.get(rekkari);
        }
        
        return null;
    }
    
    public boolean poista(Rekisterinumero rekkari) {
        if (this.omistajat.containsKey(rekkari)) {
            this.omistajat.remove(rekkari);
            return true;
        }
        
        return false;
    }
    
    public void tulostaRekisterinumerot() {
        for (Rekisterinumero rekkari : this.omistajat.keySet()) {
            System.out.println(rekkari);
        }
    }
    
    public void tulostaOmistajat() {
        ArrayList<String> tulostettavat = new ArrayList<>();
        
        for (Rekisterinumero rekkari : this.omistajat.keySet()) {
            if (!tulostettavat.contains(this.omistajat.get(rekkari))) {
                tulostettavat.add(this.omistajat.get(rekkari));
            }
        }
        
        for (String omistaja : tulostettavat) {
            System.out.println(omistaja);
        }
    }
}
