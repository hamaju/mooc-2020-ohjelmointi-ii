package kollaasi;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class KollaasiSovellus extends Application {

    @Override
    public void start(Stage stage) {

        // esimerkki avaa kuvan, luo uuden kuvan, ja kopioi avatun kuvan 
        // uuteen kuvaan pikseli kerrallaan
        Image lahdeKuva = new Image("file:monalisa.png");

        PixelReader kuvanLukija = lahdeKuva.getPixelReader();

        int leveys = (int) lahdeKuva.getWidth();
        int korkeus = (int) lahdeKuva.getHeight();

        WritableImage kohdeKuva = new WritableImage(leveys, korkeus);
        PixelWriter kuvanKirjoittaja = kohdeKuva.getPixelWriter();

        for (int y = 0; y < korkeus; y++) {
            for (int x = 0; x < leveys; x++) {
                
                Color vari = kuvanLukija.getColor(x, y);
                // negatiivi
                double punainen = 1 - vari.getRed();
                double vihrea = 1 - vari.getGreen();
                double sininen = 1 - vari.getBlue();
                double lapinakyvyys = vari.getOpacity();

                Color uusiVari = new Color(punainen, vihrea, sininen, lapinakyvyys);

                //kuvanKirjoittaja.setColor(x, y, uusiVari);
                    
                if (x % 2 == 0 && y % 2 == 0) {
                    // eka (vasen yläkulma)
                    kuvanKirjoittaja.setColor((x / 2), (y / 2), uusiVari);
                    // toka (oikea yläkulma)
                    kuvanKirjoittaja.setColor((x / 2 + leveys / 2), (y / 2), uusiVari);
                    // kolmas (vasen alakulma)
                    kuvanKirjoittaja.setColor((x / 2), (y / 2 + korkeus / 2), uusiVari);
                    // neljäs (oikea alakulma)
                    kuvanKirjoittaja.setColor((x / 2 + leveys / 2), (y / 2 + korkeus / 2), uusiVari);
                }
            }
        }
        
        ImageView kuva = new ImageView(kohdeKuva);

        Pane pane = new Pane();
        pane.getChildren().add(kuva);

        stage.setScene(new Scene(pane));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
