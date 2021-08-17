
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
public class Laatikko implements Talletettava {
    
    private ArrayList<Talletettava> sisalto;
    private double maksimiPaino;
    
    public Laatikko(double maksimiPaino) {
        this.sisalto = new ArrayList<>();
        this.maksimiPaino = maksimiPaino;
    }
    
    public void lisaa(Talletettava talletettava) {
        if (this.paino() + talletettava.paino() <= this.maksimiPaino) {
            sisalto.add(talletettava);
        }
    }

    @Override
    public double paino() {
        double paino = 0;
        for (Talletettava talletettava : this.sisalto) {
            paino += talletettava.paino();
        }
        
        return paino;
    }
    
    @Override
    public String toString() {
        return "Laatikko: " + this.sisalto.size() + " esinettä, paino yhteensä " + this.paino() + " kiloa";
    }
}
