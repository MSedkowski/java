package banksystem;

import java.io.IOException;

import banksystem.view.LoginScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("BankSystem");

        showLoginScreen();
        initRootLayout();

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

            return controller.isLoginClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}