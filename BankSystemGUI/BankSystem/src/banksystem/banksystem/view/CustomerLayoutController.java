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

public class CustomerLayoutController {
        @FXML
        private Label firstNameLabel;
        @FXML
        private Label lastNameLabel;
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
        }
        
        public void setMainApp(MainApp mainApp, String accountName, AccountRepository accountRepository) throws SQLException {
            this.mainApp = mainApp;
            this.accountRepository = accountRepository;
            
            // Add observable list data to the table
            LoadSaveDatabase.loadSpecificData("accountName", accountName, this.accountRepository);
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
        private void handleEditAccount() {
            AccountData selectedAccount = accountRepository.getAccountList().get(0);
            if (selectedAccount != null) {
                boolean okClicked = mainApp.showAccountEditDialog(selectedAccount);
                if (okClicked) {
                    showAccountDetails(selectedAccount);
                }

            } else {
                // Nothing selected.
                Alert alert = new Alert(AlertType.WARNING);
                alert.initOwner(mainApp.getPrimaryStage());
                alert.setTitle("Brak wyboru");
                alert.setHeaderText("Nie wybrano konta");
                alert.setContentText("Proszê wybraæ konto z tablicy");

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
            AccountData selectedAccount = accountRepository.getAccountList().get(0);
            if (selectedAccount != null) {
                boolean okClicked = mainApp.showAccountDepositWithdraw(selectedAccount);
                if (okClicked) {
                    showAccountDetails(selectedAccount);
                }

            } else {
                // Nothing selected.
                Alert alert = new Alert(AlertType.WARNING);
                alert.initOwner(mainApp.getPrimaryStage());
                alert.setTitle("Brak wyboru");
                alert.setHeaderText("Nie wybrano konta");
                alert.setContentText("Proszê wybraæ konto z tablicy");

                alert.showAndWait();
            }
        }
        
    }

