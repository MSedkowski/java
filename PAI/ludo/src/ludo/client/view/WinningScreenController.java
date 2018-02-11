/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ludo.client.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mateusz
 */
public class WinningScreenController implements Initializable {

    @FXML 
    private Label winningPlayer;
            
    private Stage winningStage;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setStage(Stage winningStage) {
        this.winningStage = winningStage;
    }
    
    public void setWinner(String text, String color) {
        winningPlayer.setText(text);
        switch(color.toLowerCase()) {
            case "blue": {
                winningPlayer.setTextFill(Color.BLUE);
                break;
            }
            case "green": {
                winningPlayer.setTextFill(Color.GREEN);
                break;
            }
            case "yellow": {
                winningPlayer.setTextFill(Color.DARKORANGE);
                break;
            }
            case "red": {
                winningPlayer.setTextFill(Color.RED);
                break;
            }
        }
    }
    
    public void handleOK(ActionEvent event) {
        winningStage.close();
        System.exit(0);
    }
}
