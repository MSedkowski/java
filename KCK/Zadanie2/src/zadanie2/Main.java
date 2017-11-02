/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadanie2;
import javafx.scene.layout.VBox;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
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
        Button btn = new Button();
        btn.setText("Runtime utility");
        btn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        Button btn1 = new Button();
        btn1.setText("Clear source");
        btn1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        ToggleButton btn2 = new ToggleButton();
        btn2.setText("Help");
        btn2.setDisable(true);
        btn2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        Button btn3 = new Button();
        btn3.setText("About");
        btn3.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        Button btn4 = new Button();
        btn4.setText("Exit after save");
        btn4.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        
        VBox box = new VBox();
        box.getChildren().addAll(btn,btn1,btn2,btn3,btn4);
        box.setAlignment(Pos.CENTER);
        VBox.setVgrow(btn, Priority.ALWAYS);
        VBox.setVgrow(btn1, Priority.ALWAYS);
        VBox.setVgrow(btn2, Priority.ALWAYS);
        VBox.setVgrow(btn3, Priority.ALWAYS);
        VBox.setVgrow(btn4, Priority.ALWAYS);
        box.setBorder(new Border(new BorderStroke(Color.BLACK,
        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        box.setPadding(new Insets(5));
        
        TextArea area = new TextArea();
        area.setPrefWidth(260);
        area.appendText("ala");
        area.setBorder(new Border(new BorderStroke(Color.BLACK,
        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        
        TextArea area2 = new TextArea();
        area2.setPrefWidth(Double.MAX_VALUE);
        area2.appendText("ALA");
        area2.setBorder(new Border(new BorderStroke(Color.BLACK,
        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        
        VBox box2 = new VBox(5);
        box2.getChildren().addAll(area, area2);
        box2.setPrefWidth(260);
        box2.setAlignment(Pos.CENTER);
        VBox.setVgrow(area, Priority.ALWAYS);
        VBox.setVgrow(area2, Priority.ALWAYS);
        box2.setBorder(new Border(new BorderStroke(Color.BLACK,
        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        box2.setPadding(new Insets(5));
        
        AnchorPane root = new AnchorPane();
        AnchorPane.setTopAnchor(box, 0.0);
        AnchorPane.setLeftAnchor(box, 0.0);
        AnchorPane.setBottomAnchor(box, 0.0);
        AnchorPane.setRightAnchor(box, 261.0);
        AnchorPane.setTopAnchor(box2, 0.0);
        AnchorPane.setRightAnchor(box2, 0.0);
        AnchorPane.setBottomAnchor(box2, 0.0);
        root.getChildren().addAll(box,box2);
        
        Scene scene = new Scene(root, 400, 300);
        
        primaryStage.setTitle("Screen IO Utility");
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
