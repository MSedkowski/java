package ludo.view;

import client.Chinczyk;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Mateusz
 */
public class EnterScreenController {
    
    @FXML 
    private Label error;
    
    @FXML
    private TextField nameField;
    
    private Chinczyk chinczyk;
    private Stage enterStage;
    private boolean nameOK = false;
    
    @FXML
    public void initialize() {
    } 
    
    public void setEnterStage(Stage enterStage) {
        this.enterStage = enterStage;
    }
    
    public void setChinczyk(Chinczyk chinczyk) {
        this.chinczyk = chinczyk;
    }
    
    public boolean getNameOK() {
        return nameOK;
    }
     
    private String validation(String validate) {
        if (validate.length() <= 2) {
            return "Imię nie może być krótsze niż 2 znaki.";
        }
        else {
            nameOK = true;
            return "";
        }
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        error.setText(validation(nameField.getText()));
        if (nameOK) {
            chinczyk.setName(nameField.getText());
            chinczyk.sendRequest("101:" + nameField.getText());
            chinczyk.sendRequest("102:" + nameField.getText());
            chinczyk.readResponse();
            chinczyk.showGame(nameField.getText());
            enterStage.close();
        }
    }
    
       
    
}
