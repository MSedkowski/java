package oscilloscope;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import oscilloscope.view.RootLayoutController;

public class Oscilloscope extends Application {
    
    private Stage primaryStage;
    private AnchorPane rootLayout;
    
    @Override
    public void start(Stage primaryStage) {
      
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Oscilloscope");
        this.primaryStage.setMinHeight(730);
        this.primaryStage.setMinWidth(471);
        this.primaryStage.setMaxHeight(730);
        this.primaryStage.setMaxWidth(471);
        initRootLayout();
    }
    public Stage getStage(){
        return this.primaryStage;
    }

    private void initRootLayout(){
         try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Oscilloscope.class.getResource("view/RootLayout.fxml"));
            rootLayout = (AnchorPane) loader.load();
            RootLayoutController ctrl = loader.getController();
            ctrl.initialize();
            ctrl.loadOscilloscope(this);
      
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
