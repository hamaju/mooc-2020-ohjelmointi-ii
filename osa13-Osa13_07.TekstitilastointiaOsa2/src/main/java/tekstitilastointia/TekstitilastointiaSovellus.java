package tekstitilastointia;

import java.util.Arrays;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TekstitilastointiaSovellus extends Application {

    @Override
    public void start(Stage ikkuna) {
        BorderPane asettelu = new BorderPane();
        TextArea tekstialue = new TextArea("");
        
        HBox tilastot = new HBox();
        Label kirjaimet = new Label("Kirjaimia: 0");
        Label sanat = new Label("Sanoja: 0");
        Label pisinSana = new Label("Pisin sana on:");
        tilastot.getChildren().add(kirjaimet);
        tilastot.getChildren().add(sanat);
        tilastot.getChildren().add(pisinSana);
        tilastot.setSpacing(10);
        
        tekstialue.textProperty().addListener((muutos, vanhaArvo, uusiArvo) -> {
            int merkkeja = uusiArvo.length();
            String[] palat = uusiArvo.split(" ");
            int sanoja = palat.length;
            String pisin = Arrays.stream(palat)
                .sorted((s1, s2) -> s2.length() - s1.length())
                .findFirst()
                .get();

            kirjaimet.setText("Kirjaimia: " + merkkeja);
            sanat.setText("Sanoja: " + sanoja);
            pisinSana.setText("Pisin sana on: " + pisin);
        });
        
        asettelu.setCenter(tekstialue);
        asettelu.setBottom(tilastot);
        
        Scene nakyma = new Scene(asettelu);

        ikkuna.setScene(nakyma);
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
