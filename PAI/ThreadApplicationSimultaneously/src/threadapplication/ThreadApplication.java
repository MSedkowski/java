package threadapplication;

import java.io.FileNotFoundException;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ThreadApplication {

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException, FileNotFoundException {

        ThreadApplication createThread = new ThreadApplication();
        createThread.simultaneouslyThreads(args);
    }

    private void simultaneouslyThreads(String[] args) throws InterruptedException, BrokenBarrierException {
        Runnable[] runners = new Runnable[args.length];
        Thread[] threads = new Thread[args.length];
        ThreadGroup group = new ThreadGroup("groupOfThreads");

        final CyclicBarrier gate = new CyclicBarrier(args.length + 1);

        for (int i = 0; i < args.length; i++) {
            runners[i] = new ThreadContent(args[i], gate);
        }
        for (int i = 0; i < args.length; i++) {
            threads[i] = new Thread(group, runners[i]);
        }
        for (int i = 0; i < args.length; i++) {
            threads[i].start();
        }
        
        long startTime = System.currentTimeMillis();
        gate.await();
        while (group.activeCount() != 0) {
        }
        long endTime = System.currentTimeMillis();
        
        System.out.println("Czas wykonania (jednoczesnie): " + (endTime - startTime) + "ms");
    }
}
