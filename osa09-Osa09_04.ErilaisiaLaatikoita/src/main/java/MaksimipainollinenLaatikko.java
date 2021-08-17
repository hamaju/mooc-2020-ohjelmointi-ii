
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
public class MaksimipainollinenLaatikko extends Laatikko {
    
    private int maksimipaino;
    private ArrayList<Tavara> tavarat;
    
    public MaksimipainollinenLaatikko(int maksimipaino) {
        this.maksimipaino = maksimipaino;
        this.tavarat = new ArrayList<>();
    }

    @Override
    public void lisaa(Tavara tavara) {
        int sisallonPaino = 0;
        for (Tavara t : this.tavarat) {
            sisallonPaino += t.getPaino();
        }
        if (sisallonPaino + tavara.getPaino() <= this.maksimipaino) {
            this.tavarat.add(tavara);
        }
    }

    @Override
    public boolean onkoLaatikossa(Tavara tavara) {
        for (Tavara t : this.tavarat) {
            if (t.equals(tavara)) {
                return true;
            }
        }
        return false;
    }
}
