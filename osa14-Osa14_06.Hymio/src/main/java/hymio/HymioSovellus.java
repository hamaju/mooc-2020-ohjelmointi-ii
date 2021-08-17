package hymio;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HymioSovellus extends Application {

    @Override
    public void start(Stage ikkuna) {
        Canvas piirtoalusta = new Canvas(400, 400);
        GraphicsContext piirturi = piirtoalusta.getGraphicsContext2D();
        
        BorderPane asettelu = new BorderPane();
        asettelu.setCenter(piirtoalusta);
        
        // silmät
        // 50x50 kokoinen suorakulmio, jonka vasen yläkulma alkaa pisteestä (100, 60)
        piirturi.fillRect(100, 70, 50, 50);
        piirturi.fillRect(250, 70, 50, 50);
        // suun viiva
        piirturi.fillRect(100, 250, 200, 50);
        // suupielet
        piirturi.fillRect(50, 200, 50, 50);
        piirturi.fillRect(300, 200, 50, 50);
        
        Scene nakyma = new Scene(asettelu);
        
        ikkuna.setScene(nakyma);
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(HymioSovellus.class);
    }
}
