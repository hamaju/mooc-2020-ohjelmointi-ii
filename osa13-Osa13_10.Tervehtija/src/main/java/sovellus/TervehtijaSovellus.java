package sovellus;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TervehtijaSovellus extends Application {

    @Override
    public void start(Stage ikkuna) {
        Label ohjeteksti = new Label("Kirjoita nimesi ja aloita.");
        TextField tekstikentta = new TextField();
        Button aloitusnappi = new Button("Aloita");
      
        GridPane aloitusAsettelu = new GridPane();
        aloitusAsettelu.add(ohjeteksti, 0, 0);
        aloitusAsettelu.add(tekstikentta, 0, 1);
        aloitusAsettelu.add(aloitusnappi, 0, 2);

        aloitusAsettelu.setPrefSize(300, 180);
        aloitusAsettelu.setAlignment(Pos.CENTER);
        aloitusAsettelu.setVgap(10);
        aloitusAsettelu.setHgap(10);
        aloitusAsettelu.setPadding(new Insets(20, 20, 20, 20));

        Label tervetuloaTeksti = new Label();
        
        StackPane tervetuloaAsettelu = new StackPane();
        tervetuloaAsettelu.setPrefSize(300, 180);
        tervetuloaAsettelu.getChildren().add(tervetuloaTeksti);
        tervetuloaAsettelu.setAlignment(Pos.CENTER);
        
        Scene aloitusNakyma = new Scene(aloitusAsettelu);
        Scene tervetuloaNakyma = new Scene(tervetuloaAsettelu);
        
        aloitusnappi.setOnAction((event) -> {
            ikkuna.setScene(tervetuloaNakyma);
            tervetuloaTeksti.setText("Tervetuloa " + tekstikentta.getText() + "!");
        });
        
        ikkuna.setScene(aloitusNakyma);
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
