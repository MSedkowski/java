package banksystem.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.*;
import banksystem.LoadSaveDatabase;
import banksystem.MainApp;

public class LoginScreenController {

    @FXML
    private TextField accountNameField;
    @FXML
    private PasswordField passwordField;

    private Stage loginStage;
    private boolean loginClicked = false;
    private boolean registerClicked = false;
    private boolean loginOK = false;

    @FXML
    private void initialize() {
    }

    public void setLoginStage(Stage loginStage) {
        this.loginStage = loginStage;
    }

    public boolean isLoginClicked() {
        return loginClicked;
    }
    
    public boolean isRegisterClicked() {
        return registerClicked ;
    }
    
    public boolean getLoginOK() {
        return loginOK;
    }

    @FXML
    private boolean handleLogin() throws SQLException {
        if (isInputValid()) {
            
            if (LoadSaveDatabase.loginMethod(accountNameField.getText(), passwordField.getText())) {
                MainApp.accountName = accountNameField.getText();
                loginOK = true;
                loginStage.close();
            }
            else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.initOwner(loginStage);
                alert.setTitle("Bledne dane");
                alert.setHeaderText("Podany login i haslo sa nieprawidlowe");

                alert.showAndWait();
                loginOK = false;
            }
        }
        return loginClicked;
    }
    
    @FXML
    private void handleRegister() {
        registerClicked = true; 
        loginStage.close();
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (accountNameField.getText() == null || accountNameField.getText().length() == 0) {
            errorMessage += "Z�y login! Pole nie mo�e by� puste!\n";
        }
        if (passwordField.getText() == null || passwordField.getText().length() == 0) {
            errorMessage += "Z�e has�o! Pole nie mo�e by� puste!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(loginStage);
            alert.setTitle("Niepoprawnie wype�nione pola");
            alert.setHeaderText("Prosz� poprawi�: ");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

}
