package borderpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BorderPaneSovellus extends Application {

    @Override
    public void start(Stage ikkuna) {
        BorderPane bp = new BorderPane();
        
        Label north = new Label("NORTH");
        Label south = new Label("SOUTH");
        Label east = new Label("EAST");
        
        bp.setTop(north);
        //BorderPane.setAlignment(north,Pos.CENTER);
        bp.setBottom(south);
        //BorderPane.setAlignment(south,Pos.CENTER);
        bp.setRight(east);
        //BorderPane.setAlignment(east,Pos.CENTER);

        Scene nakyma = new Scene(bp);

        ikkuna.setHeight(300);
        ikkuna.setWidth(300);
        
        ikkuna.setScene(nakyma);
        ikkuna.show();
    }    

    public static void main(String[] args) {
        launch();
    }
}
