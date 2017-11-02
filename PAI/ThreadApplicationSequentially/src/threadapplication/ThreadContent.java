package threadapplication;

import java.io.FileNotFoundException;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadContent implements Runnable{
    private final String filename;
    private final CyclicBarrier gate;
    
    ThreadContent(String name) {
        this.filename = name;
        this.gate = null;
    }
    
    ThreadContent(String name, CyclicBarrier gate) {
        this.filename = name;
        this.gate = gate;
    }
    
    @Override
    public void run() {
        
        try {
            ReadFromFile object = new ReadFromFile();
            if(gate != null) gate.await();
            System.out.println("Liczba wierszy pliku " + filename + " : " + object.read(filename));
        } catch (InterruptedException | BrokenBarrierException | FileNotFoundException ex){
            Logger.getLogger(ThreadContent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
