package banksystem.view;

import java.math.BigDecimal;
import java.sql.SQLException;

import banksystem.model.AccountData;
import banksystem.model.AccountRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class AccountWithdrawDepositDialogController {
    
    @FXML
    private Label balanceLabel;    
    
    @FXML
    private TextField accountBalanceField;
    
    private Stage dialogStage;
    private AccountData accountData;
    private boolean okClicked = false;
    
    
    @FXML
    private void initialize() {
    }
    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    public void setAccountBalance(AccountData accountData) {
        this.accountData = accountData;
        balanceLabel.setText(accountData.getAccountBalance().toString());
        accountBalanceField.setText(accountData.getAccountBalance().toString());
    }
    
    public boolean isOkClicked() {
        return okClicked;
    }
    
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            accountData.setAccountBalance(new BigDecimal(accountBalanceField.getText()));

            okClicked = true;
            dialogStage.close();
        }
    }
    
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
    
    private boolean isInputValid() {
        String errorMessage = "";

        if (accountBalanceField.getText() == null || accountBalanceField.getText().length() == 0) {
            errorMessage += "No valid account balance!\n"; 
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
