package sovellus;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UseampiNakyma extends Application {

    @Override
    public void start(Stage ikkuna) {
        BorderPane ekaBP = new BorderPane();
        Button tokaan = new Button("Tokaan näkymään");
        Label ekaTeksti = new Label("Eka näkymä!");
        ekaBP.setTop(ekaTeksti);
        ekaBP.setCenter(tokaan);
        
        VBox tokaVB = new VBox();
        Button kolmanteen = new Button("Kolmanteen näkymään");
        Label tokaTeksti = new Label("Toka näkymä!");
        tokaVB.getChildren().add(kolmanteen);
        tokaVB.getChildren().add(tokaTeksti);
        
        GridPane kolmasGP = new GridPane();
        Button ekaan = new Button("Ekaan näkymään!");
        Label kolmasTeksti = new Label("Kolmas näkymä!");
        kolmasGP.add(kolmasTeksti, 0, 0);
        kolmasGP.add(ekaan, 1, 1);
        
        Scene ekaNakyma = new Scene(ekaBP);
        Scene tokaNakyma = new Scene(tokaVB);
        Scene kolmasNakyma = new Scene(kolmasGP);

        ekaan.setOnAction((event) -> {
            ikkuna.setScene(ekaNakyma);
        });
        
        tokaan.setOnAction((event) -> {
            ikkuna.setScene(tokaNakyma);
        });
        
        kolmanteen.setOnAction((event) -> {
            ikkuna.setScene(kolmasNakyma);
        });
        
        ikkuna.setScene(ekaNakyma);
        ikkuna.show();
    }
    
    public static void main(String[] args) {
        launch();
    }
}
