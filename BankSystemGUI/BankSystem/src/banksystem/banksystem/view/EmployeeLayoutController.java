package banksystem.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.SQLException;

import banksystem.LoadSaveDatabase;
import banksystem.MainApp;
import banksystem.model.AccountData;
import banksystem.model.AccountRepository;

public class EmployeeLayoutController {
    @FXML
    private TableView<AccountData> accountTable;
    @FXML
    private TableColumn<AccountData, String> nameColumn;
    
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label fullNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label peselLabel;
    @FXML
    private Label accountNumberLabel;
    @FXML
    private Label balanceLabel;
    
    private MainApp mainApp;
    
    private AccountRepository accountRepository;
    
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().getFullName());

        // Listen for selection changes and show the person details when changed.
        accountTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showAccountDetails(newValue));
    }
    
    public void setMainApp(MainApp mainApp, AccountRepository accountRepository) throws SQLException {
        this.mainApp = mainApp;
        this.accountRepository = accountRepository;
        
        // Add observable list data to the table
        accountTable.getItems().clear();
        LoadSaveDatabase.loadData(this.accountRepository);
        accountTable.setItems(this.accountRepository.getAccountList());
    }
    
    private void showAccountDetails(AccountData accountData) {
        if (accountData != null) {
            firstNameLabel.setText(accountData.getName());
            lastNameLabel.setText(accountData.getSurname());
            streetLabel.setText(accountData.getStreet());
            postalCodeLabel.setText(accountData.getPostCode());
            cityLabel.setText(accountData.getCity());
            peselLabel.setText(accountData.getPesel());
            accountNumberLabel.setText(accountData.getAccountNumber());
            balanceLabel.setText(String.valueOf(accountData.getAccountBalance().doubleValue()));
            
        } else {
            // Person is null, remove all the text.
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            streetLabel.setText("");
            postalCodeLabel.setText("");
            cityLabel.setText("");
            peselLabel.setText("");
            accountNumberLabel.setText("");
            balanceLabel.setText("");
        }
    }
    
    @FXML
    private void handleDeleteAccount() {
        int selectedIndex = accountTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) accountTable.getItems().remove(selectedIndex);
        else {
                // Nothing selected.
                Alert alert = new Alert(AlertType.WARNING);
                alert.initOwner(mainApp.getPrimaryStage());
                alert.setTitle("No Selection");
                alert.setHeaderText("No Person Selected");
                alert.setContentText("Please select a person in the table.");

                alert.showAndWait();
        }
    }
    
    @FXML
    private void handleNewAccount() throws SQLException {
        AccountData tempAccount = new AccountData();
        boolean okClicked = mainApp.showAccountEditDialog(tempAccount);
        if (okClicked) {
            accountRepository.addAccount(tempAccount);
        }
    }
    
    @FXML
    private void handleEditAccount() {
        AccountData selectedAccount = accountTable.getSelectionModel().getSelectedItem();
        if (selectedAccount != null) {
            boolean okClicked = mainApp.showAccountEditDialog(selectedAccount);
            if (okClicked) {
                showAccountDetails(selectedAccount);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Account Selected");
            alert.setContentText("Please select an account in the table.");

            alert.showAndWait();
        }
    }
    
    @FXML
    private void handleLogOut() throws SQLException {
        LoadSaveDatabase.saveDatabase(accountRepository);
        mainApp.closePrimaryStage();
    }
    
    @FXML
    private void handleSave() throws SQLException {
        LoadSaveDatabase.saveDatabase(accountRepository);
    }
    
    @FXML
    private void handleDepositWithdraw() throws SQLException {
        AccountData selectedAccount = accountTable.getSelectionModel().getSelectedItem();
        if (selectedAccount != null) {
            boolean okClicked = mainApp.showAccountDepositWithdraw(selectedAccount);
            if (okClicked) {
                showAccountDetails(selectedAccount);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Account Selected");
            alert.setContentText("Please select an account in the table.");

            alert.showAndWait();
        }
    }
    
    @FXML 
    private void handleSearch() throws SQLException {
        accountTable.getItems().clear();
        boolean okClicked = mainApp.showSearch();
        if (okClicked) {
            
        }
    }
    
    @FXML
    private void handleEverything() throws SQLException {
        accountTable.getItems().clear();
        LoadSaveDatabase.loadData(this.accountRepository);
        accountTable.setItems(this.accountRepository.getAccountList());
    }
}
