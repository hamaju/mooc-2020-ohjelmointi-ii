package sovellus;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class VitsiSovellus extends Application {

    @Override
    public void start(Stage ikkuna) {
        // päänäkymä
        BorderPane asettelu = new BorderPane();
        
        HBox valikko = new HBox();
        valikko.setPadding(new Insets(20, 20, 20, 20));
        valikko.setSpacing(10);
        
        Button vitsi = new Button("Vitsi");
        Button vastaus = new Button("Vastaus");
        Button selitys = new Button("Selitys");
        
        valikko.getChildren().addAll(vitsi, vastaus, selitys);
        
        asettelu.setTop(valikko);
        
        // alinäkymat
        StackPane vitsiAsettelu = luoNakyma("What do you call a bear with no teeth?");
        StackPane vastausAsettelu = luoNakyma("A gummy bear.");
        StackPane selitysAsettelu = luoNakyma("LOL!");
        
        vitsi.setOnAction((event) -> asettelu.setCenter(vitsiAsettelu));
        vastaus.setOnAction((event) -> asettelu.setCenter(vastausAsettelu));
        selitys.setOnAction((event) -> asettelu.setCenter(selitysAsettelu));
        
        asettelu.setCenter(vitsiAsettelu);
        
        Scene nakyma = new Scene(asettelu);
        
        ikkuna.setScene(nakyma);
        ikkuna.show();
    }
    
    private StackPane luoNakyma(String teksti) {
        StackPane asettelu = new StackPane();
        asettelu.setPrefSize(300, 180);
        asettelu.getChildren().add(new Label(teksti));
        asettelu.setAlignment(Pos.CENTER);

        return asettelu;
    }

    public static void main(String[] args) {
        launch();
    }
}
