package ludo.client.view;

import ludo.client.Chinczyk;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ludo.common.Request;
import ludo.client.Client;

/**
 *
 * @author Mateusz
 */
public class EnterScreenController {
    
    @FXML 
    private Label error;
    
    @FXML
    private TextField nameField;
    
    private Client client;
    private Stage enterStage;
    private boolean nameOK = false;
    
    @FXML
    public void initialize() {
    } 
    
    public void setEnterStage(Stage enterStage, Client client) {
        this.enterStage = enterStage;
        this.client = client;
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
            Request sendName = new Request(100, nameField.getText());
            client.sendRequest(sendName);
            client.setName(nameField.getText());
            //enterStage.close();
        }
    }
    
       
    
}
