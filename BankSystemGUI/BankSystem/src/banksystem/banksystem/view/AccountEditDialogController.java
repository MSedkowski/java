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
            accountData.setAccountType("Customer");

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
            errorMessage += "B³êdne imie! Pole nie mo¿e byæ puste!\n"; 
        }
        if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
            errorMessage += "B³êdne nazwisko! Pole nie mo¿e byæ puste!\n"; 
        }
        if (streetField.getText() == null || streetField.getText().length() == 0) {
            errorMessage += "B³êdny adres! Pole ulica nie mo¿e byæ puste!\n"; 
        }

        if (postalCodeField.getText() == null || postalCodeField.getText().length() == 0
            || !postalCodeField.getText().matches("[0-9]{2}-[0-9]{3}")) {
            errorMessage += "Niepoprawny kod pocztowy! Proszê u¿yæ formatu xx-xxx\n"; 
        }

        if (cityField.getText() == null || cityField.getText().length() == 0) {
            errorMessage += "Brak podanego miasta! Pole nie mo¿e byæ puste!\n"; 
        }
        
        if (peselField.getText() == null || peselField.getText().length() == 0
            || !peselField.getText().matches("[0-9]{2}[0-1]{1}[0-9]{1}[0-3]{1}[0-9]{6}")) {
            errorMessage += "B³êdny numer pesel!\n"; 
        }
        
        if (accountNumberField.getText() == null || accountNumberField.getText().length() == 0
            || !accountNumberField.getText().matches("[0-9]{26}")) {
            errorMessage += "B³êdny numer konta! Podaj 26 cyfrowy numer konta\n"; 
        }
        
        if (accountBalanceField.getText() == null || accountBalanceField.getText().length() == 0
            || !accountBalanceField.getText().matches("[0-9]+.[0-9]+")) {
            errorMessage += "B³êdne saldo! Pole nie mo¿e byæ puste!\n"; 
        }
        
        if (loginField.getText() == null || loginField.getText().length() == 0) {
            errorMessage += "B³êdny login! Pole nie mo¿e byæ puste!\n"; 
        }
        
        if (passwordField.getText() == null || passwordField.getText().length() == 0) {
            errorMessage += "B³êdne has³o! Pole nie mo¿e byæ puste!\n"; 
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Niepoprawnie wype³nione pola");
            alert.setHeaderText("Proszê poprawiæ: ");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
    
}
