/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ludo.client;

import java.io.IOException;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ludo.client.view.EnterScreenController;
import ludo.client.view.GeneralViewController;
import ludo.client.view.WinningScreenController;

/**
 *
 * @author Mateusz
 */
public class ScreenController {
    private static ScreenController screenController = null;
    
    private Stage enterStage;
    private Stage generalStage;
    private Stage winningStage;
    
    private AnimationTimer gameTimer;
    private Controller controller;
    
    private EnterScreenController enterScreenController;
    private GeneralViewController generalViewController;
    private WinningScreenController winningScreenController;
    
    public void init(AnimationTimer timer, Controller controller, Stage primaryStage) {
	this.controller = controller;
	this.gameTimer = timer;
	this.gameTimer.start();

	try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource("./view/EnterScreen.fxml"));
            AnchorPane enterScreen = (AnchorPane) loader.load();

            // Create the dialog Stage.
            this.enterStage = new Stage();
            enterStage.setTitle("Logowanie");
            enterStage.initModality(Modality.WINDOW_MODAL);
            enterStage.initOwner(primaryStage);
            Scene scene = new Scene(enterScreen);
            enterStage.setScene(scene);

            // Set the person into the controller.
            this.enterScreenController = loader.getController();
            this.enterScreenController.setEnterStage(enterStage, this.controller.getClient());

            // Show the dialog and wait until the user closes it
            enterStage.show();
            
            loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource("./view/GeneralView.fxml"));
            AnchorPane generalView = (AnchorPane) loader.load();

            // Create the dialog Stage.
            this.generalStage = new Stage();
            generalStage.setTitle("LUDO");
            generalStage.initModality(Modality.WINDOW_MODAL);
            generalStage.initOwner(primaryStage);
            Scene generalScene = new Scene(generalView);
            generalStage.setScene(generalScene);

            // Set the person into the controller.
            this.generalViewController = loader.getController();
            this.generalViewController.setEnterStage(generalStage, controller.getClient());
            
            loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource("./view/WinningScreen.fxml"));
            AnchorPane winner = (AnchorPane) loader.load();

            // Create the dialog Stage.
            this.winningStage = new Stage();
            winningStage.setTitle(" ");
            winningStage.initModality(Modality.WINDOW_MODAL);
            winningStage.initOwner(primaryStage);
            Scene resultScene = new Scene(winner);
            winningStage.setScene(resultScene);

            // Set the person into the controller.
            this.winningScreenController = loader.getController();
            this.winningScreenController.setStage(winningStage);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static ScreenController getScreenController(){
	if ( screenController == null ) {
            screenController = new ScreenController();
	}
	return screenController;
    }

    public void showGame() {
        this.generalStage.show();
    }
    
    public void showResultScreen() {
        this.winningStage.show();
    }
    
    public Stage getEnterStage() {
        return enterStage;
    }

    public void setEnterStage(Stage enterStage) {
        this.enterStage = enterStage;
    }

    public Stage getGeneralStage() {
        return generalStage;
    }

    public void setGeneralStage(Stage generalStage) {
        this.generalStage = generalStage;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public EnterScreenController getEnterScreenController() {
        return enterScreenController;
    }

    public void setEnterScreenController(EnterScreenController enterScreenController) {
        this.enterScreenController = enterScreenController;
    }

    public GeneralViewController getGeneralViewController() {
        return generalViewController;
    }

    public void setGeneralViewController(GeneralViewController generalViewController) {
        this.generalViewController = generalViewController;
    }

    public WinningScreenController getWinningStageController() {
        return winningScreenController;
    }

    public void setWinningStageController(WinningScreenController winningStageController) {
        this.winningScreenController = winningStageController;
    }

    public Stage getWinningStage() {
        return winningStage;
    }

    public void setWinningStage(Stage winningStage) {
        this.winningStage = winningStage;
    }
    
    
}
