package banksystem;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Savepoint;

import banksystem.model.AccountData;
import banksystem.model.AccountRepository;
import banksystem.view.AccountEditDialogController;
import banksystem.view.AccountWithdrawDepositDialogController;
import banksystem.view.EmployeeLayoutController;
import banksystem.view.LoginScreenController;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    private AccountRepository accountRepository;
    
    @Override
    public void start(Stage primaryStage) throws SQLException {
        accountRepository = new AccountRepository();
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("BankSystem");

        if(showLoginScreen()) {
            initRootLayout();
            showEmployeeLayout();
        }
        
    }

    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean showLoginScreen() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/LoginScreen.fxml"));
            AnchorPane loginScreen = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage loginStage = new Stage();
            loginStage.setTitle("Sign in");
            loginStage.initModality(Modality.WINDOW_MODAL);
            loginStage.initOwner(primaryStage);
            Scene scene = new Scene(loginScreen);
            loginStage.setScene(scene);

            // Set the person into the controller.
            LoginScreenController controller = loader.getController();
            controller.setLoginStage(loginStage);
            // controller.setAccount(account);

            // Show the dialog and wait until the user closes it
            loginStage.showAndWait();

            return controller.getLoginOK();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }
    
    public boolean showSignUpScreen() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/SignUpScreen.fxml"));
            AnchorPane registerScreen = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage registerStage = new Stage();
            registerStage.setTitle("Sign up");
            registerStage.initModality(Modality.WINDOW_MODAL);
            registerStage.initOwner(primaryStage);
            Scene scene = new Scene(registerScreen);
            registerStage.setScene(scene);

            // Set the person into the controller.
            /*LoginScreenController controller = loader.getController();
            controller.setLoginStage(loginStage);
            // controller.setAccount(account);*/

            // Show the dialog and wait until the user closes it
            registerStage.showAndWait();

            return true; //controller.isRegisterClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }
    
    public void showEmployeeLayout() throws SQLException {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/EmployeeLayout.fxml"));
            AnchorPane employeeLayout = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(employeeLayout);

           // Give the controller access to the main app.
            EmployeeLayoutController controller = loader.getController();
            controller.setMainApp(this, accountRepository);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public boolean showAccountEditDialog(AccountData accountData) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/AccountEditDialog.fxml"));
            AnchorPane accountEdit = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage accountEditDialogStage = new Stage();
            accountEditDialogStage.setTitle("Edit Account");
            accountEditDialogStage.initModality(Modality.WINDOW_MODAL);
            accountEditDialogStage.initOwner(primaryStage);
            Scene scene = new Scene(accountEdit);
            accountEditDialogStage.setScene(scene);

            // Set the person into the controller.
            AccountEditDialogController controller = loader.getController();
            controller.setDialogStage(accountEditDialogStage);
            controller.setAccount(accountData);

            // Show the dialog and wait until the user closes it
            accountEditDialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean showAccountDepositWithdraw(AccountData accountData) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/DepositWithdrawDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Account Operation");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            AccountWithdrawDepositDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setAccountBalance(accountData);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
    
    public void closePrimaryStage() {
        primaryStage.close();
    }

    public static void main(String[] args) throws SQLException {
        launch(args);
    }
}