package sovellus;

import javafx.application.Application;
import javafx.scene.chart.NumberAxis;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class ShanghaiSovellus extends Application {

    @Override
    public void start(Stage ikkuna) {
        // x-akselin alaraja 2007, yläraja 2017, välit 1
        NumberAxis xAkseli = new NumberAxis(2007, 2017, 1);
        NumberAxis yAkseli = new NumberAxis();
        xAkseli.setLabel("Vuosi");
        yAkseli.setLabel("Sijoitus");
        
        LineChart<Number, Number> viivakaavio = new LineChart<>(xAkseli, yAkseli);
        viivakaavio.setTitle("Sijoitus vuosina 2007-2017");
        
        XYChart.Series shanghaiData = new XYChart.Series();
        shanghaiData.setName("HY");
        shanghaiData.getData().add(new XYChart.Data(2007, 73));
        shanghaiData.getData().add(new XYChart.Data(2008, 68));
        shanghaiData.getData().add(new XYChart.Data(2009, 72));
        shanghaiData.getData().add(new XYChart.Data(2010, 72));
        shanghaiData.getData().add(new XYChart.Data(2011, 74));
        shanghaiData.getData().add(new XYChart.Data(2012, 73));
        shanghaiData.getData().add(new XYChart.Data(2013, 76));
        shanghaiData.getData().add(new XYChart.Data(2014, 73));
        shanghaiData.getData().add(new XYChart.Data(2015, 67));
        shanghaiData.getData().add(new XYChart.Data(2016, 56));
        shanghaiData.getData().add(new XYChart.Data(2017, 56));
        
        viivakaavio.getData().add(shanghaiData);
        
        Scene nakyma = new Scene(viivakaavio, 640, 480);
        ikkuna.setScene(nakyma);
        ikkuna.show();
    }
    
    public static void main(String[] args) {
        launch();
    }
}
