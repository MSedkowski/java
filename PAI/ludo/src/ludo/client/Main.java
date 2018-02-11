/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ludo.client;

/**
 *
 * @author Mateusz
 */
import java.io.IOException;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ludo.client.view.EnterScreenController;
import ludo.client.view.GeneralViewController;

public class Main extends Application {
    
        private Stage primaryStage;
	long time = 500000000;
	long lastNow = 0;
        
        @Override
	public void start(Stage stage) throws Exception {
            Controller controller = new Controller();
            AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				controller.getClient().run();
			};
		};
            ScreenController.getScreenController().init(timer, controller, primaryStage);
	}

	public static void main(String[] args) {
            launch(args);
	}
        
//        public void showEnterScreen(Controller clientController) {
//        try {
//            // Load person overview.
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(Chinczyk.class.getResource("./view/EnterScreen.fxml"));
//            AnchorPane enterScreen = (AnchorPane) loader.load();
//
//            // Create the dialog Stage.
//            Stage enterStage = new Stage();
//            enterStage.setTitle("Logowanie");
//            enterStage.initModality(Modality.WINDOW_MODAL);
//            enterStage.initOwner(primaryStage);
//            Scene scene = new Scene(enterScreen);
//            enterStage.setScene(scene);
//
//            // Set the person into the controller.
//            EnterScreenController controller = loader.getController();
//            controller.setEnterStage(enterStage, clientController.getClient());
//
//            // Show the dialog and wait until the user closes it
//            enterStage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//        
//        public void showGeneralView(Controller clientController) {
//        try {
//            // Load person overview.
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(Chinczyk.class.getResource("./view/GeneralView.fxml"));
//            AnchorPane generalView = (AnchorPane) loader.load();
//
//            // Create the dialog Stage.
//            Stage generalStage = new Stage();
//            generalStage.setTitle("LUDO");
//            generalStage.initModality(Modality.WINDOW_MODAL);
//            generalStage.initOwner(primaryStage);
//            Scene scene = new Scene(generalView);
//            generalStage.setScene(scene);
//
//            // Set the person into the controller.
//            GeneralViewController controller = loader.getController();
//            controller.setEnterStage(generalStage, clientController.getClient());
//
//            // Show the dialog and wait until the user closes it
//            generalStage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//    }
}
