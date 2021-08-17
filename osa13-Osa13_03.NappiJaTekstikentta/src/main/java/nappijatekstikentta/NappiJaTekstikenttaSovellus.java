package nappijatekstikentta;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class NappiJaTekstikenttaSovellus extends Application {

    @Override
    public void start(Stage ikkuna) {
        Button nappi = new Button("Nappi");
        TextField tekstikentta = new TextField("Tekstielementti");

        FlowPane komponenttiryhma = new FlowPane();
        komponenttiryhma.setVgap(5);
        komponenttiryhma.setHgap(5);
        komponenttiryhma.getChildren().add(nappi);
        komponenttiryhma.getChildren().add(tekstikentta);

        Scene nakyma = new Scene(komponenttiryhma);

        ikkuna.setScene(nakyma);
        ikkuna.show();
    }
    
    public static void main(String[] args) {
        launch();
    }
}
