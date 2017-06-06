package banksystem.view;

import java.sql.SQLException;

import banksystem.LoadSaveDatabase;
import banksystem.model.AccountRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class SearchDialogController {
    
    @FXML
    private ComboBox<String> searchOption;
     
    @FXML
    private TextField searchField;
    
    private Stage dialogStage;
    private AccountRepository accountRepository;
    private boolean okClicked = false;
    
    @FXML
    public void initialize()
    {
        searchOption.getItems().addAll
        (
            "Imie",
            "Nazwisko",
            "Ulica",
            "Miasto",
            "PESEL"
        );   

    }
    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    public void setAccountRepository(AccountRepository ar) {
        this.accountRepository = ar;
    }
    
    public boolean isOkClicked() {
        return okClicked;
    }
    
    @FXML
    private void handleOk() throws SQLException {
        String wybor = new String(searchOption.getValue());
        if (isInputValid(wybor)) {
            
            if (wybor.equals("Imie")) {
                LoadSaveDatabase.loadSpecificData("name", searchField.getText(), accountRepository);
            }
            if (wybor.equals("Nazwisko")) {
                LoadSaveDatabase.loadSpecificData("surname", searchField.getText(), accountRepository);
            }
            if (wybor.equals("Ulica")) {
                LoadSaveDatabase.loadSpecificData("street", searchField.getText(), accountRepository);
            }
            if (wybor.equals("Miasto")) {
                LoadSaveDatabase.loadSpecificData("city", searchField.getText(), accountRepository);
            }
            if (wybor.equals("PESEL")) {
                LoadSaveDatabase.loadSpecificData("PESEL", searchField.getText(), accountRepository);
            }
            
            
        }
        okClicked = true;
        dialogStage.close();
    }
    
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
    
    private boolean isInputValid(String wybor) {
        String errorMessage = "";

        if (searchField.getText() == null || searchField.getText().length() == 0) {
            errorMessage += "No valid search!\n"; 
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
