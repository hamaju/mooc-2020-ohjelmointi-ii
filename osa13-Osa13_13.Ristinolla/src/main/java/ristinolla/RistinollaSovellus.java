package ristinolla;

import java.util.List;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class RistinollaSovellus extends Application {
    
    private String vuoro;
    private List<Button> napit;
    
    @Override
    public void start(Stage ikkuna) {
        this.vuoro = "X";
        this.napit = new ArrayList<>();
                
        BorderPane asettelu = new BorderPane();
        Label vuoroteksti = new Label("Vuoro: " + this.vuoro);
        GridPane lauta = new GridPane();
        
        // rivit
        for (int i = 0; i < 3; i++) {
            // sarakkeet
            for (int j = 0; j < 3; j++) {
                // luodaan ja asetellaan napit ruudukkoon
                Button nappi = new Button(" ");
                nappi.setFont(Font.font("Monospaced", 40));
                lauta.add(nappi, i, j);
                // lisätään napit myös listaan pelin toiminnallisuutta varten
                napit.add(nappi);
            }
        }
        
        napit.stream().forEach(n -> n.setOnMouseClicked((event) -> {
            if (n.getText().equals(" ")) {
                n.setText(vuoro);
                vaihdaVuoroa();
                vuoroteksti.setText("Vuoro: " + vuoro);
                
                if (onkoVoittajaa()) {
                    vuoroteksti.setText("Loppu!");
                }
            }
        }));
        
        asettelu.setTop(vuoroteksti);
        asettelu.setCenter(lauta);
        
        Scene nakyma = new Scene(asettelu);
        
        ikkuna.setTitle("Ristinolla");
        ikkuna.setScene(nakyma);
        ikkuna.show();
    }
    
    public void vaihdaVuoroa() {
        if (vuoro.equals("X")) {
            this.vuoro = "O";
        } else {
            this.vuoro = "X";
        }
    }
    
    public boolean onkoVoittajaa() {
        // 0 1 2
        // 3 4 5
        // 6 7 8
        if (tarkista(napit.get(0), napit.get(1), napit.get(2))) {
            return true;
        } else if (tarkista(napit.get(3), napit.get(4), napit.get(5))) {
            return true;
        } else if (tarkista(napit.get(6), napit.get(7), napit.get(8))) {
            return true;
        } else if (tarkista(napit.get(0), napit.get(3), napit.get(6))) {
            return true;
        } else if (tarkista(napit.get(1), napit.get(4), napit.get(7))) {
            return true;
        } else if (tarkista(napit.get(2), napit.get(5), napit.get(8))) {
            return true;
        } else if (tarkista(napit.get(0), napit.get(4), napit.get(8))) {
            return true;
        } else if (tarkista(napit.get(2), napit.get(4), napit.get(6))) {
            return true;
        }
        
        return false;
    }
    
    public boolean tarkista(Button n1, Button n2, Button n3) {
        return !n1.getText().equals(" ") && 
                n1.getText().equals(n2.getText()) && 
                n2.getText().equals(n3.getText());
    }
    
    public static void main(String[] args) {
        launch();
    }
}
