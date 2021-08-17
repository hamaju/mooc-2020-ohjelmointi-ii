
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
public class Kellari {
    
    private HashMap<String, ArrayList<String>> komerot;
    
    public Kellari() {
        this.komerot = new HashMap<>();
    }
    
    public void lisaa(String komero, String tavara) {
        this.komerot.putIfAbsent(komero, new ArrayList<>());
        this.komerot.get(komero).add(tavara);
    }
    
    public ArrayList<String> sisalto(String komero) {
        ArrayList<String> tyhja = new ArrayList<>();
        
        if (this.komerot.isEmpty() || this.komerot.get(komero) == null) {
            return tyhja;
        }
        
        return this.komerot.get(komero);
    }
    
    public void poista(String komero, String tavara) {
        if (this.komerot.get(komero).contains(tavara)) {
            this.komerot.get(komero).remove(tavara);
        }
        
        if (this.komerot.get(komero).isEmpty()) {
            this.komerot.remove(komero);
        }
    }
    
    public ArrayList<String> komerot() {
        ArrayList<String> palautettavat = new ArrayList<>();
        
        for (String komero : komerot.keySet()) {
            palautettavat.add(komero);
        }
        
        return palautettavat;
    }
}
