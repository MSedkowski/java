/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadanie1;
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
        btn.setText("Insert File");
        btn.setPrefSize(120, 30);
        btn.setAlignment(Pos.CENTER);
        Button btn1 = new Button();
        btn1.setText("Clear Text");
        btn1.setPrefSize(120, 30);
        btn1.setAlignment(Pos.CENTER);
        ToggleButton btn2 = new ToggleButton();
        btn2.setText("Run Utility");
        btn2.setDisable(true);
        btn2.setPrefSize(120, 30);
        btn2.setAlignment(Pos.CENTER);
        Button btn3 = new Button();
        btn3.setText("Save File");
        btn3.setPrefSize(120, 30);
        btn3.setAlignment(Pos.CENTER);
        Button btn4 = new Button();
        btn4.setText("Help");
        btn4.setPrefSize(120, 30);
        btn4.setAlignment(Pos.CENTER);
        Button btn5 = new Button();
        btn5.setText("About");
        btn5.setPrefSize(120, 30);
        btn5.setAlignment(Pos.CENTER);
        Button btn6 = new Button();
        btn6.setText("Exit");
        btn6.setPrefSize(120, 30);
        btn6.setAlignment(Pos.CENTER);
        
        VBox box = new VBox();
        box.getChildren().addAll(btn,btn1,btn2,btn3,btn4,btn5,btn6);
        box.setBorder(new Border(new BorderStroke(Color.BLACK,
        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        box.setPadding(new Insets(5));
        
        TextArea area = new TextArea();
        area.setPrefWidth(260);
        area.appendText("Pole Tekstowe");
        area.setBorder(new Border(new BorderStroke(Color.BLACK,
        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        area.setPadding(new Insets(5));
        
        AnchorPane root = new AnchorPane();
        AnchorPane.setTopAnchor(box, 0.0);
        AnchorPane.setLeftAnchor(box, 0.0);
        AnchorPane.setBottomAnchor(box, 0.0);
        AnchorPane.setTopAnchor(area, 0.0);
        AnchorPane.setRightAnchor(area, 0.0);
        AnchorPane.setBottomAnchor(area, 0.0);
        root.getChildren().addAll(box,area);
        
        Scene scene = new Scene(root, 400, 300);
        
        primaryStage.setTitle("Text/File IO Utility");
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
