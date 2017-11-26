package oscilloscope.view;

import java.net.URL;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import oscilloscope.Oscilloscope;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import oscilloscope.draw.Calculate;

public class RootLayoutController {
    @FXML
    private Label freqXVal;
    @FXML
    private Label freqYVal;
    @FXML
    private Label phaseShiftXVal;
    @FXML
    private Label phaseShiftYVal;
    @FXML
    private ImageView knob1;
    @FXML
    private ImageView knob2;  
    @FXML
    private ImageView knob3;  
    @FXML
    private ImageView knob4;
    @FXML
    private ImageView onoff;
    @FXML
    private Canvas canvOscy;
    @FXML
    private StackPane canvHold;
    @FXML
    private GridPane mainGrid;
    
    private Oscilloscope oscilloscope;
    private double knobPosition=0;
    private double windowX=0;
    private double mousePosX=0;
    private double nextMousePosX=0;
    private double frequencyX=0;
    private double frequencyY=0;
    private int phaseX=0;
    private int phaseY=0;
    private GraphicsContext gc;
    private boolean power=false;
    private Image on;
    private Image off;
    private int stepX = 0;
    private int stepY = 0;
    
    public void initialize(){
        for(int i=0;i<mainGrid.getChildren().size();i++)
            GridPane.setHalignment(mainGrid.getChildren().get(i), HPos.CENTER);
        canvHold.setStyle("-fx-background-color: black");
        gc = canvOscy.getGraphicsContext2D();
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(1);
        URL onurl=RootLayoutController.class.getResource("on.png");
        URL offurl=RootLayoutController.class.getResource("off.png");
        on=new Image(onurl.toString());
        off=new Image(offurl.toString());
        frequencyX();
        frequencyY();
        phaseX();
        phaseY();
    }
    
    public void loadOscilloscope(Oscilloscope oscyloskop){
    	this.oscilloscope=oscyloskop;
    }
    
    public void onClickReleased(){
        if(power){
            gc.clearRect(0, 0, 351, 330);
            Calculate.calculatePoints(frequencyX, frequencyY, phaseX, phaseY, gc);
        }
    }
    
    public void turnPower(){
        if(power){
            power=false;
            onoff.setImage(off);
            gc.clearRect(0, 0, 351, 330);
            phaseX = 0;
            phaseY = 0;
        }else{
            power=true;
            onoff.setImage(on);
            phaseX = (int) knob3.getRotate();
            phaseY = (int) knob4.getRotate();
            Calculate.calculatePoints(frequencyX, frequencyY, phaseX, phaseY, gc);
        }
    }

    public void frequencyX(){
        knob1.setOnMouseDragged((MouseEvent me) -> {
            knobPosition=knob1.getParent().getParent().getLayoutX();
            windowX=this.oscilloscope.getStage().getScene().windowProperty().get().getX()+knobPosition+knob1.getLayoutX();
            nextMousePosX=me.getScreenX()-windowX;
            if(nextMousePosX>mousePosX){
                stepX++;
                if (stepX >= 15){
            	knob1.setRotate(knob1.getRotate()+45);
                this.frequencyX++;
                stepX = 0;
                }
            }else{
                stepX--;
                if (stepX <= -15) {
            	knob1.setRotate(knob1.getRotate()-45);
            	this.frequencyX--;
            	if(frequencyX<=0){
                    this.frequencyX=0;
                    knob1.setRotate(0);
            	}
                stepX = 0;
                }
            }
            Double a=frequencyX;
            freqXVal.setText(a.toString().format("%.0f", a));
            mousePosX=me.getScreenX()-windowX;      
        });  
    }
    
    public void frequencyY(){
        knob2.setOnMouseDragged((MouseEvent me) -> {
            knobPosition=knob2.getParent().getParent().getLayoutX();
            windowX=this.oscilloscope.getStage().getScene().windowProperty().get().getX()+knobPosition+knob2.getLayoutX();
            nextMousePosX=me.getScreenX()-windowX;
            if(nextMousePosX>mousePosX){
                stepY++;
                if (stepY >= 15) {
                knob2.setRotate(knob2.getRotate()+45);
            	this.frequencyY++;
                stepY = 0;
                }
            }else{
                stepY--;
                if (stepY <= -15) {
            	knob2.setRotate(knob2.getRotate()-45);
            	this.frequencyY--;
            	if(frequencyY<=0){
                    this.frequencyY=0;
                    knob2.setRotate(0);
            	}
                stepY = 0;
                }
            }
            Double a=frequencyY;
            freqYVal.setText(a.toString().format("%.0f", a));
            mousePosX=me.getScreenX()-windowX;      
        });  
    }
    
    public void phaseX(){
        knob3.setOnMouseDragged((MouseEvent me) -> {
            knobPosition=knob3.getParent().getParent().getLayoutX();
            windowX=this.oscilloscope.getStage().getScene().windowProperty().get().getX()+knobPosition+knob3.getLayoutX()+53;
            nextMousePosX=me.getScreenX()-windowX;
            if(nextMousePosX>mousePosX){
            	knob3.setRotate(knob3.getRotate()+1);
                this.phaseX++;
            	if(phaseX>=360){
                    phaseX=360;
                    knob3.setRotate(360);
            	}
            }else{
            	knob3.setRotate(knob3.getRotate()-1);
            	this.phaseX--;
            	if(phaseX<=-360){
                    this.phaseX=-360;
                    knob3.setRotate(-360);
            	}
            }
            Double a=knob3.rotateProperty().get();
            phaseShiftXVal.setText(a.toString().format("%.0f", a));
            mousePosX=me.getScreenX()-windowX;      
        });  
    }
    
    public void phaseY(){
        knob4.setOnMouseDragged((MouseEvent me) -> {
            knobPosition=knob4.getParent().getParent().getLayoutX();
            windowX=this.oscilloscope.getStage().getScene().windowProperty().get().getX()+knobPosition+knob4.getLayoutX()+53;
            nextMousePosX=me.getScreenX()-windowX;
            if(nextMousePosX>mousePosX){
            	knob4.setRotate(knob4.getRotate()+1);
            	this.phaseY++;
            	if(phaseY>=360){
                    phaseY=360;
                    knob4.setRotate(360);
                }
            }else{
            	knob4.setRotate(knob4.getRotate()-1);
            	this.phaseY--;
            	if(phaseY<=-360) {
                    this.phaseY=-360;
                    knob4.setRotate(-360);
            	}
            }
            Double a = knob4.rotateProperty().get();
            phaseShiftYVal.setText(a.toString().format("%.0f", a));
            mousePosX = me.getScreenX()-windowX;      
        });  
    }

}