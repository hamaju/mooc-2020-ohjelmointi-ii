
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author haha
 */
public class Tyontekijat {
    
    private List<Henkilo> tyontekijat;
    
    public Tyontekijat() {
        this.tyontekijat = new ArrayList<>();
    }
    
    public void lisaa(Henkilo lisattava) {
        this.tyontekijat.add(lisattava);
    }
    
    public void lisaa(List<Henkilo> lisattavat) {
        this.tyontekijat.addAll(lisattavat);
    }
    
    public void tulosta() {
        Iterator<Henkilo> iteraattori = tyontekijat.iterator();
        
        while (iteraattori.hasNext()) {
            System.out.println(iteraattori.next());
        }
    }
    
    public void tulosta(Koulutus koulutus) {
        Iterator<Henkilo> iteraattori = tyontekijat.iterator();
        
        while (iteraattori.hasNext()) {
            Henkilo haettava = iteraattori.next();
            if (haettava.getKoulutus().equals(koulutus)) {
                System.out.println(haettava);
            }
        }
    }
    
    public void irtisano(Koulutus koulutus) {
        Iterator<Henkilo> iteraattori = tyontekijat.iterator();
        
        while (iteraattori.hasNext()) {
            if (iteraattori.next().getKoulutus().equals(koulutus)) {
                iteraattori.remove();
            }
        }
    }
}
