
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author haha
 */
public class SamatMaatVierekkainArvojarjestykseen implements Comparator<Kortti> {

    @Override
    public int compare(Kortti t, Kortti t1) {
        if (t.getMaa().ordinal() == t1.getMaa().ordinal()) {
            return t.getArvo() - t1.getArvo();
        } else {
            return t.getMaa().ordinal() - t1.getMaa().ordinal();
        }
    }
}
