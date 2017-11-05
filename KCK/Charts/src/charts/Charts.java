package charts;

import charts.model.ChartData;
import charts.model.ListOfChartData;
import charts.view.BasicViewController;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Charts extends Application {

    private ListOfChartData listOfChartData;
    private AnchorPane rootLayout;
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.listOfChartData = new ListOfChartData();
        primaryStage.setTitle("Wykresy");
        try (Stream<Path> paths = Files.walk(Paths.get("./logFiles"))) {
            paths
                    .filter(Files::isRegularFile)
                    .forEach(s -> {
                        try {
                            listOfChartData.addChartData(new ChartData(s.getFileName().toString()));
                        } catch (IOException ex) {
                            Logger.getLogger(Charts.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    });
        }
        initRootLayout(listOfChartData);
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void initRootLayout(ListOfChartData listOfChartData) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Charts.class.getResource("view/BasicView.fxml"));
            rootLayout = (AnchorPane) loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            BasicViewController controller = loader.getController();
            controller.setMainApp(this, listOfChartData);
            primaryStage.show();
        } catch (IOException e) {
        }
    }
}
