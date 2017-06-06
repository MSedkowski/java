package banksystem.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.*;
import banksystem.LoadSaveDatabase;

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
            errorMessage += "No valid account name!\n";
        }
        if (passwordField.getText() == null || passwordField.getText().length() == 0) {
            errorMessage += "No valid password!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(loginStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

}
