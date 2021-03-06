package ludo;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
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
    @Override
    public void start(Stage stage) {
        this.listOfPlayers = new PlayerList();
        this.listOfPlayers.addPlayer(new Player("Mateusz", "blue"));
        this.listOfPlayers.addPlayer(new Player("Michal", "green"));
        this.listOfPlayers.addPlayer(new Player("Tomek", "yellow"));
        this.listOfPlayers.addPlayer(new Player("Piotr", "red"));
        this.board = new Board(listOfPlayers);
       
        showGeneralView();
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
    
}
