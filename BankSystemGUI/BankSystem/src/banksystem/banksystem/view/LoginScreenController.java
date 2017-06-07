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
    private int loginOK = 0;

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
    
    public int getLoginOK() {
        return loginOK;
    }

    @FXML
    private boolean handleLogin() throws SQLException {
        if (isInputValid()) {
            int rodzaj = LoadSaveDatabase.loginMethod(accountNameField.getText(), passwordField.getText());
            if (rodzaj == 1) {
                MainApp.accountName = accountNameField.getText();
                loginOK = 1;
                loginStage.close();
            }
            if (rodzaj == 2) {
                MainApp.accountName = accountNameField.getText();
                loginOK = 2;
                loginStage.close();
            }
            else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.initOwner(loginStage);
                alert.setTitle("Bledne dane");
                alert.setHeaderText("Podany login i haslo sa nieprawidlowe");

                alert.showAndWait();
                loginOK = 0;
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
