
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
public class Tehtavalista {
    
    private ArrayList<String> tehtavat;
    
    public Tehtavalista() {
        this.tehtavat = new ArrayList<>();
    }
    
    public void lisaa(String tehtava) {
        this.tehtavat.add(tehtava);
    }
    
    public void tulosta() {
        int i = 1;
        for (String tehtava : this.tehtavat) {
            System.out.println(i + ": " + tehtava);
            i++;
        }
    }
    
    public void poista(int numero) {
        this.tehtavat.remove(numero - 1);
    }
}
