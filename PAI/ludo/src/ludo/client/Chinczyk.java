package ludo.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ludo.Board;
import ludo.Player;
import ludo.PlayerList;
import ludo.view.EnterScreenController;
import ludo.view.GeneralViewController;
import ludo.view.WinningScreenController;

/**
 *
 * @author Mateusz
 */
public class Chinczyk extends Application{

    private Stage primaryStage;
    private Board board;
    private PlayerList listOfPlayers;
    private String hostName = "localhost";
    private int portNumber = 4444;
    Socket echoSocket;
    
    @Override
    public void start(Stage stage) { 
       try {
             this.echoSocket = new Socket(hostName, portNumber);
             listOfPlayers = new PlayerList();
             this.board = new Board(listOfPlayers);
             this.primaryStage = stage;
             this.primaryStage.setTitle("Chińczyk");
             
             showEnterScreen();
             
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to "
                    + hostName);
            System.exit(1);
        }
    }
    
    public void showEnterScreen() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Chinczyk.class.getResource("./view/EnterScreen.fxml"));
            AnchorPane enterScreen = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage enterStage = new Stage();
            enterStage.setTitle("Logowanie");
            enterStage.initModality(Modality.WINDOW_MODAL);
            enterStage.initOwner(primaryStage);
            Scene scene = new Scene(enterScreen);
            enterStage.setScene(scene);

            // Set the person into the controller.
            EnterScreenController controller = loader.getController();
            controller.setEnterStage(enterStage);
            controller.setChinczyk(this);

            // Show the dialog and wait until the user closes it
            enterStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

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
            controller.setChinczyk(this, board, listOfPlayers);
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
    
    public static void main(String[] args) {
        launch(args);
    }
    
    public void sendRequest(String request) throws IOException {
        DataOutputStream out = new DataOutputStream(echoSocket.getOutputStream());
        out.writeUTF(request);
    }
    
    public void readResponse() throws IOException {
        DataInputStream in = new DataInputStream(echoSocket.getInputStream());
        while(true) {
                String fromServer;
                fromServer = in.readUTF();
                System.out.println("Server: " + fromServer);
                String[] request = fromServer.split(":");
                int selection = Integer.parseInt(request[0]);
                switch(selection) {
                    case 102: { //get player color
                        if (request[1].equalsIgnoreCase(this.name)) {
                        this.color = request[2];
                        break;
                        }
                        break;
                    }
                    case 103: { //get actual player
                        this.actualPlayer = Integer.parseInt(request[1]);
                        break;
                    }
                    case 104: {
                        
                        break;
                    }
                }
                break;
             }
    }
}
