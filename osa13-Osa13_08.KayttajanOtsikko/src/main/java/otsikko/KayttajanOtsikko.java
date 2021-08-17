package otsikko;

import javafx.application.Application;
import javafx.stage.Stage;

public class KayttajanOtsikko extends Application {

    @Override
    public void start(Stage ikkuna) {
        String otsikko = getParameters().getNamed().get("otsikko");
        
        ikkuna.setTitle(otsikko);
        ikkuna.show();
    }
}
