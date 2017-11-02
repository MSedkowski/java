package polishpainters;

import java.io.FileNotFoundException;
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
import polishpainters.model.ListOfPainters;
import polishpainters.model.Painter;
import polishpainters.view.BasicViewController;

public class PolishPainters extends Application {

    private AnchorPane rootLayout;
    private Stage primaryStage;
    private ListOfPainters listOfPainters;

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.listOfPainters = new ListOfPainters();
        primaryStage.setTitle("Polscy malarze");
        try (Stream<Path> paths = Files.walk(Paths.get("./painters"))) {
            paths
                    .filter(Files::isRegularFile)
                    .forEach(s -> {
                        try {
                            listOfPainters.addPainter(new Painter(s.getFileName().toString()));
                        } catch (IOException ex) {
                            Logger.getLogger(PolishPainters.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    });
        }
        initRootLayout(listOfPainters);
    }

    public static void main(String[] args) throws IOException {
        launch(args);
    }

    private void initRootLayout(ListOfPainters listOfPainters) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PolishPainters.class.getResource("view/BasicView.fxml"));
            rootLayout = (AnchorPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            scene.getStylesheets().add("view/stylesheet.css");
            primaryStage.setScene(scene);

            BasicViewController controller = loader.getController();
            controller.setMainApp(this, listOfPainters);
            primaryStage.show();
        } catch (IOException e) {
        }
    }
}
