package ludo.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Queue;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ludo.common.Board;
import ludo.common.Player;
import ludo.common.PlayerList;
import ludo.client.view.EnterScreenController;
import ludo.client.view.GeneralViewController;
import ludo.client.view.WinningScreenController;

/**
 *
 * @author Mateusz
 */
public class Chinczyk extends Application{

    private Stage primaryStage;
    private PlayerList playerList;
    private String hostName = "localhost";
    private int portNumber = 4444;
    Socket echoSocket;
    private String color;
    private String name;
    private int actualPlayer;
    private Board board;
    private PlayerList listOfPlayers;

    @Override
    public void start(Stage stage) {
        
    }
    
    public Chinczyk(PlayerList listOfPlayers) {
        this.listOfPlayers = listOfPlayers;
    }
    
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void showGeneralView() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Chinczyk.class.getResource("./view/GeneralView.fxml"));
            AnchorPane generalView = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage generalStage = new Stage();
            generalStage.setTitle("LUDO");
            generalStage.initModality(Modality.WINDOW_MODAL);
            generalStage.initOwner(primaryStage);
            Scene scene = new Scene(generalView);
            generalStage.setScene(scene);

            // Set the person into the controller.
            GeneralViewController controller = loader.getController();
            controller.setChinczyk(this, listOfPlayers, echoSocket, this.color);
            controller.setEnterStage(generalStage);

            // Show the dialog and wait until the user closes it
            generalStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    public void showWinner(String name, String color) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Chinczyk.class.getResource("./view/WinningScreen.fxml"));
            AnchorPane winner = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage winningStage = new Stage();
            winningStage.setTitle("Game");
            winningStage.initModality(Modality.WINDOW_MODAL);
            winningStage.initOwner(primaryStage);
            Scene scene = new Scene(winner);
            winningStage.setScene(scene);

            // Set the person into the controller.
            WinningScreenController controller = loader.getController();
            controller.setStage(winningStage);
            controller.setWinner(name, color);

            // Show the dialog and wait until the user closes it
            winningStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public int getActualPlayer(){
        return actualPlayer;
    }
   
}
