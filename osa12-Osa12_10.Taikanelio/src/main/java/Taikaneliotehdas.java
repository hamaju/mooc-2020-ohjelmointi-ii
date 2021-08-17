
public class Taikaneliotehdas {

    public Taikanelio luoTaikanelio(int koko) {

        Taikanelio nelio = new Taikanelio(koko);

        // toteuta taikaneliön luominen Siamese method -algoritmilla tänne
        // ylimmän rivin keskikohta
        int x = nelio.getLeveys() / 2;
        int y = 0;
        int asetettavaNumero = 1;
        
        while (nelio.annaKaikkiNumerot().contains(0)) {
            nelio.asetaArvo(x, y, asetettavaNumero);
            
            // siirtyminen ulos neliöstä oikealta
            if (x + 1 >= koko) {
                x = 0;
            // muuten siirrytään yksi ruutu oikealle
            } else {
                x++;
            }
            
            // siirtyminen ulos neliöstä ylhäältä
            if (y - 1 < 0) {
                y = koko - 1;
            // muuten siirrytään yksi ruutu ylös
            } else {
                y--;
            }
            
            // jos ruudussa on jo numero (0 = tyhjä)
            if (nelio.annaArvo(x, y) != 0) {
                // palataan lähtökohtaan ja siirrytään yksi ruutu alas
                x -= 1;
                y += 2;
                
                // jos lähtökohta oli toisella puolella riviä
                if (x < 0) {
                    x += koko;
                }

                // jos lähtökohta oli toisella puolella saraketta
                if (y >= koko) {
                    y -= koko;
                }
            }
            
            asetettavaNumero++;
        }
        
        return nelio;
    }
}
