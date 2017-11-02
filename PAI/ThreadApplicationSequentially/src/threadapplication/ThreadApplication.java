package threadapplication;

import java.io.FileNotFoundException;
import java.util.concurrent.BrokenBarrierException;

public class ThreadApplication {
    
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException, FileNotFoundException {
        
        ThreadApplication createThread = new ThreadApplication();
        createThread.sequentiallyThreads(args);
    }
    
    private void sequentiallyThreads(String[] args) throws FileNotFoundException, InterruptedException {
        Runnable[] runners = new Runnable[args.length];
        Thread[] threads = new Thread[args.length];
        
        for (int i = 0; i < args.length; i++) {
            runners[i] = new ThreadContent(args[i]);
        }
        for (int i = 0; i < args.length; i++) {
            threads[i] = new Thread(runners[i]);
        }
        
        ReadFromFile object = new ReadFromFile();
        long startTime = System.currentTimeMillis();
        for (Thread thread : threads) {
            thread.start();
            thread.join();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Czas wykonania (sekwencyjnie): " + (endTime - startTime) + "ms");
    }
}
