package banksystem.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.math.BigDecimal;

import banksystem.model.AccountData;

public class AccountEditDialogController {
    
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField streetField;
    @FXML
    private TextField postalCodeField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField peselField;
    @FXML
    private TextField accountNumberField;
    @FXML
    private TextField accountBalanceField;
    @FXML 
    private TextField loginField;
    @FXML
    private TextField passwordField;


    private Stage dialogStage;
    private AccountData accountData;
    private boolean okClicked = false;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the person to be edited in the dialog.
     * 
     * @param person
     */
    public void setAccount(AccountData accountData) {
        this.accountData = accountData;

        firstNameField.setText(accountData.getName());
        lastNameField.setText(accountData.getSurname());
        streetField.setText(accountData.getStreet());
        postalCodeField.setText(accountData.getPostCode());
        cityField.setText(accountData.getCity());
        peselField.setText(accountData.getPesel());
        accountNumberField.setText(accountData.getAccountNumber());
        accountBalanceField.setText(accountData.getAccountBalance().toString());
        loginField.setText(accountData.getLogin());
        passwordField.setText(accountData.getPassword());
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     * 
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            accountData.setName(firstNameField.getText());
            accountData.setSurname(lastNameField.getText());
            accountData.setStreet(streetField.getText());
            accountData.setPostCode(postalCodeField.getText());
            accountData.setCity(cityField.getText());
            accountData.setPesel(peselField.getText());
            accountData.setAccountNumber(accountNumberField.getText());
            accountData.setAccountBalance(new BigDecimal(accountBalanceField.getText()));
            accountData.setLogin(loginField.getText());
            accountData.setPassword(passwordField.getText());

            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     * 
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
            errorMessage += "No valid first name!\n"; 
        }
        if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
            errorMessage += "No valid last name!\n"; 
        }
        if (streetField.getText() == null || streetField.getText().length() == 0) {
            errorMessage += "No valid street!\n"; 
        }

        if (postalCodeField.getText() == null || postalCodeField.getText().length() == 0) {
            errorMessage += "No valid post code!\n"; 
        }

        if (cityField.getText() == null || cityField.getText().length() == 0) {
            errorMessage += "No valid city!\n"; 
        }
        
        if (peselField.getText() == null || peselField.getText().length() == 0) {
            errorMessage += "No valid pesel!\n"; 
        }
        
        if (accountNumberField.getText() == null || accountNumberField.getText().length() == 0) {
            errorMessage += "No valid account number!\n"; 
        }
        
        if (accountBalanceField.getText() == null || accountBalanceField.getText().length() == 0) {
            errorMessage += "No valid account balance!\n"; 
        }
        
        if (loginField.getText() == null || loginField.getText().length() == 0) {
            errorMessage += "No valid login!\n"; 
        }
        
        if (passwordField.getText() == null || passwordField.getText().length() == 0) {
            errorMessage += "No valid password!\n"; 
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
    
}
