
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juhani
 */
public class Putki<T> {
    
    private ArrayList<T> sisalto;
    
    public Putki() {
        this.sisalto = new ArrayList<>();
    }
    
    public void lisaaPutkeen(T arvo) {
        this.sisalto.add(arvo);
    }
    
    public T otaPutkesta() {
        if (this.sisalto.isEmpty()) {
            return null;
        }
        
        T eka = this.sisalto.get(0);
        this.sisalto.remove(0);
        return eka;
    }
    
    public boolean onkoPutkessa() {
        if (this.sisalto.isEmpty()) {
            return false;
        }
        
        return true;
    }
}
