/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadanie3;
import javafx.scene.layout.VBox;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Mateusz
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        ToggleButton btn = new ToggleButton();
        btn.setText("Run Utility");
        btn.setDisable(true);
        btn.setMaxHeight(Double.MAX_VALUE);
        btn.setPrefWidth(160);
        Button btn1 = new Button();
        btn1.setText("Help");
        btn1.setMaxHeight(Double.MAX_VALUE);
        btn1.setPrefWidth(160);
        Button btn2 = new Button();
        btn2.setText("About");
        btn2.setMaxHeight(Double.MAX_VALUE);
        btn2.setPrefWidth(160);
        Button btn3 = new Button();
        btn3.setText("Exit after save");
        btn3.setMaxHeight(Double.MAX_VALUE);
        btn3.setPrefWidth(160);
        
        VBox box = new VBox();
        box.getChildren().addAll(btn,btn1,btn2,btn3);
        box.setPrefWidth(160);
        box.setAlignment(Pos.CENTER);
        VBox.setVgrow(btn, Priority.ALWAYS);
        VBox.setVgrow(btn1, Priority.ALWAYS);
        VBox.setVgrow(btn2, Priority.ALWAYS);
        VBox.setVgrow(btn3, Priority.ALWAYS);
        box.setBorder(new Border(new BorderStroke(Color.BLACK,
        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        box.setPadding(new Insets(5));
        
        Button browse = new Button();
        browse.setText("Browse...");
        Button browse2 = new Button();
        browse2.setText("Browse...");
        
        Label source = new Label();
        source.setText("Source");
        source.setPadding(new Insets(5,15,0,5));
        Label report = new Label();
        report.setText("Report");
        report.setPadding(new Insets(5,15,0,5));
        
        TextField input = new TextField();
        input.prefWidth(140);
        TextField input2 = new TextField();
        input2.prefWidth(140);
        input2.setText("report.txt");
        
        HBox hbox = new HBox(5);
        hbox.getChildren().addAll(source, input, browse);
        hbox.setPadding(new Insets(15, 0, 0, 0));
        HBox hbox2 = new HBox(5);
        hbox2.getChildren().addAll(report, input2, browse2);
        
        VBox box2 = new VBox(10);
        box2.getChildren().addAll(hbox, hbox2);
        box2.setPrefWidth(340);
        box2.setBorder(new Border(new BorderStroke(Color.BLACK,
        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        box2.setPadding(new Insets(5));
        
        AnchorPane root = new AnchorPane();
        AnchorPane.setTopAnchor(box, 0.0);
        AnchorPane.setLeftAnchor(box, 0.0);
        AnchorPane.setBottomAnchor(box, 0.0);
        AnchorPane.setTopAnchor(box2, 0.0);
        AnchorPane.setRightAnchor(box2, 0.0);
        AnchorPane.setBottomAnchor(box2, 0.0);
        root.getChildren().addAll(box,box2);
        
        Scene scene = new Scene(root, 500, 200);
        
        primaryStage.setTitle("File IO Utility");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
