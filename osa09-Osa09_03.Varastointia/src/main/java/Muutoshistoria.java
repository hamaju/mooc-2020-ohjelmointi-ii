
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author haha
 */
public class Muutoshistoria {
    
    private ArrayList<Double> historia;
    
    public Muutoshistoria() {
        this.historia = new ArrayList<>();
    }
    
    public void lisaa(double tilanne) {
        this.historia.add(tilanne);
    }
    
    public void nollaa() {
        this.historia.clear();
    }
    
    public double maxArvo() {
        if (this.historia.isEmpty()) {
            return 0.0;
        }
        
        double suurin = this.historia.get(0);
        for (double i : this.historia) {
            if (i > suurin) {
                suurin = i;
            }
        }
        
        return suurin;
    }
    
    public double minArvo() {
        if (this.historia.isEmpty()) {
            return 0.0;
        }
        
        double pienin = this.historia.get(0);
        for (double i : this.historia) {
            if (i < pienin) {
                pienin = i;
            }
        }
        
        return pienin;
    }
    
    public double keskiarvo() {
        if (this.historia.isEmpty()) {
            return 0.0;
        }
/*        
        double summa = 0.0;
        int j = 0;
        for (double i : this.historia) {
            summa += this.historia.get(j);
            j++;
        }
*/      
        double summa = 0.0;
        for (double i : this.historia) {
            summa += i;
        }

        return summa / this.historia.size();
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.historia);
    }
}
