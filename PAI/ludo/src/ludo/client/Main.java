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
}
