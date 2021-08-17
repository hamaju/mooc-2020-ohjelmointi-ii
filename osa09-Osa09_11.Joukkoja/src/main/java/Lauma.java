
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author haha
 */
public class Lauma implements Siirrettava {
    
    private List<Siirrettava> eliot;
    
    public Lauma() {
        this.eliot = new ArrayList<>();
    }
    
    public void lisaaLaumaan(Siirrettava siirrettava) {
        this.eliot.add(siirrettava);
    }
    
    @Override
    public String toString() {
        String tulostus = "";
        for (Siirrettava elio : this.eliot) {
            tulostus += elio + "\n";
        }
        
        return tulostus;
    }
    
    @Override
    public void siirra(int dx, int dy) {
        for (Siirrettava elio : this.eliot) {
            elio.siirra(dx, dy);
        }
    }   
}
