package ilmoitin;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class IlmoitinSovellus extends Application {
    
    @Override
    public void start(Stage ikkuna) {        
        VBox asettelu = new VBox();
        TextField tekstikentta = new TextField("");
        tekstikentta.setPrefColumnCount(20);
        Button nappi = new Button("Päivitä");
        Label tekstikomponentti = new Label("");
        asettelu.getChildren().add(tekstikentta);
        asettelu.getChildren().add(nappi);
        asettelu.getChildren().add(tekstikomponentti);
        
        nappi.setOnAction((event) -> {
            tekstikomponentti.setText(tekstikentta.getText());
        });

        Scene nakyma = new Scene(asettelu);
        
        ikkuna.setScene(nakyma);
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
