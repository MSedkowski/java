package oscilloscope.draw;

import javafx.scene.canvas.GraphicsContext;

public class Calculate {

    public static void calculatePoints(double freqX, double freqY, double phaseX, double phaseY,GraphicsContext gc) {

        double ampliX = 154; 
        double ampliY = 130;
        double phaseXrad;    
        double phaseYrad;

        phaseXrad = Math.toRadians(phaseX);
        phaseYrad = Math.toRadians(phaseY);

        for (double t = 0.0; t < 10000;t += 0.1){
            double x = (ampliX * (Math.sin(freqX * t + phaseXrad))+176);
            double y = (ampliY * (Math.sin(freqY * t + phaseYrad))-140);
            gc.strokeLine(x,(y*-1),x,(y*-1));
        }
    }
}
