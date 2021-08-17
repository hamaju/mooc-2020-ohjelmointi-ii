
import java.util.ArrayList;
import java.util.Collections;
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
public class Kasi implements Comparable<Kasi> {
    
    private List<Kortti> kortit;
    
    public Kasi() {
        this.kortit = new ArrayList<>();
    }
    
    public void lisaa(Kortti kortti) {
        this.kortit.add(kortti);
    }
    
    public void tulosta() {
        for (Kortti kortti : this.kortit) {
            System.out.println(kortti);
        }
        
        //this.kortit.stream().forEach(k -> System.out.println(k));
    }
    
    public void jarjesta() {
        Collections.sort(this.kortit);
    }
    
    public int summa() {
        int summa = 0;
        for (Kortti kortti : this.kortit) {
            summa += kortti.getArvo();
        }
        
        return summa;
    }
    
    public void jarjestaMaittain() {
        Collections.sort(this.kortit, new SamatMaatVierekkainArvojarjestykseen());
    }

    @Override
    public int compareTo(Kasi t) {
        return this.summa() - t.summa();
    }
}
