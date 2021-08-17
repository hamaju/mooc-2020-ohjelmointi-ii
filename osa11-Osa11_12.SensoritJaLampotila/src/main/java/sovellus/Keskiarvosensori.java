/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovellus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 *
 * @author juhani
 */
public class Keskiarvosensori implements Sensori {
    
    private List<Sensori> sensorit;
    private List<Integer> mittaukset;
    
    public Keskiarvosensori() {
        this.sensorit = new ArrayList<>();
        this.mittaukset = new ArrayList<>();
    }
    
    public void lisaaSensori(Sensori lisattava) {
        this.sensorit.add(lisattava);
    }
    
    public List<Integer> mittaukset() {
        return this.mittaukset;
    }
    
    @Override
    public boolean onPaalla() {
        for (Sensori sensori : sensorit) {
            if (!sensori.onPaalla()) {
                return false;
            }
        }
        
        return true;
    }

    @Override
    public void paalle() {
        for (Sensori sensori : sensorit) {
            sensori.paalle();
        }
    }

    @Override
    public void poisPaalta() {
        this.sensorit.get(new Random().nextInt(sensorit.size())).poisPaalta();
    }

    @Override
    public int mittaa() {
        if (sensorit.isEmpty()) {
            throw new IllegalStateException("Ei mittareita");
        } else if (!onPaalla()) {
            throw new IllegalStateException("Sensorit eivät ole päällä");
        }
        
        int keskiarvo = (int)sensorit.stream().mapToInt(s -> s.mittaa()).average().getAsDouble();
        this.mittaukset.add(keskiarvo);
        
        return keskiarvo;
    }
}
