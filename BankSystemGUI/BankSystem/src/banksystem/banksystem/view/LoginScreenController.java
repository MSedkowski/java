package banksystem.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import banksystem.model.AccountData;

public class LoginScreenController {

    @FXML
    private TextField accountNameField;
    @FXML
    private PasswordField passwordField;

    private Stage loginStage;
    private AccountData account;
    private boolean loginClicked = false;
    private boolean registerClicked = false;

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

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            // TODO funkcje sprawdzaj¹c¹ dane wpisane z tymi w bazie

            loginClicked = true;
            loginStage.close();
        }
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
