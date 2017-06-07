package banksystem.view;

import java.math.BigDecimal;
import java.sql.SQLException;

import banksystem.model.AccountData;
import banksystem.model.AccountRepository;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class AccountWithdrawDepositDialogController {
    
    @FXML
    private Label balanceLabel;    
    
    @FXML
    private ComboBox<String> accountOperation;
     
    @FXML
    private TextField accountBalanceField;
    
    private Stage dialogStage;
    private AccountData accountData;
    private boolean okClicked = false;
    
    
    @FXML
    public void initialize()
    {
        accountOperation.getItems().addAll
        (
            "Wp³ata",
            "Wyp³ata"
        );   

        accountOperation.setValue("Wp³ata");
    }
    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    public void setAccountBalance(AccountData accountData) {
        this.accountData = accountData;
        balanceLabel.setText(accountData.getAccountBalance().toString());
    }
    
    public boolean isOkClicked() {
        return okClicked;
    }
    
    @FXML
    private void handleOk() {
        String wybor = new String(accountOperation.getValue());
        if (isInputValid(wybor)) {
            
            if (wybor.equals("Wp³ata")) {
            accountData.setAccountBalance(accountData.getAccountBalance().add(new BigDecimal(accountBalanceField.getText())));
            }
            if (wybor.equals("Wyp³ata")) {
            accountData.setAccountBalance(accountData.getAccountBalance().subtract(new BigDecimal(accountBalanceField.getText())));
            }
            okClicked = true;
            dialogStage.close();
        }
    }
    
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
    
    private boolean isInputValid(String wybor) {
        String errorMessage = "";

        if (accountBalanceField.getText() == null || accountBalanceField.getText().length() == 0) {
            errorMessage += "Niepoprawny numer konta! Pole nie mo¿e byæ puste!\n"; 
        }
        
        if (accountBalanceField.getText().matches("[0-9]{26}") || accountBalanceField.getText().matches("[0-9]{2}[ ][0-9]{4}[ ][0-9]{4}[ ][0-9]{4}[ ][0-9]{4}[ ][0-9]{4}[ ][0-9]{4}")) {
            errorMessage += "Niepoprawny numer konta! Proszê podaæ 26 cyfr!\n"; 
        }
        
        if (new BigDecimal(accountBalanceField.getText()).compareTo(accountData.getAccountBalance()) == 1 && wybor.equals("Wyp³ata")) {
            errorMessage += "Brak œrodków na koncie!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Niepoprawnie wype³nione pola");
            alert.setHeaderText("Proszê poprawiæ:");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}
