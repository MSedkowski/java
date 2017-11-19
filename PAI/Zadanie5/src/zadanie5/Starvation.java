package zadanie5;

public class Starvation extends Thread{

    public static Object tools = new Object();

    public void run() {
        Thread worker1 = new job();
        Thread worker2 = new job();
        Thread worker3 = new job();
        worker1.setPriority(Thread.MAX_PRIORITY);
        worker2.setPriority(Thread.MAX_PRIORITY);
        worker3.setPriority(Thread.MIN_PRIORITY);
        worker1.setName("Zdzisiek");
        worker2.setName("Marian");
        worker3.setName("Leń Wojtek");
        worker1.start();
        worker2.start();
        worker3.start();
        long startTime = System.currentTimeMillis();
        while (true) {
            if ((System.currentTimeMillis() - startTime) > 20000) {
                System.out.println("Kończenie pracy programu");
                System.exit(0);
            }
        }

    }

    private static class job extends Thread {

        public synchronized void run() {
            int workProgress = 0;
            while (true) {
                if (workProgress == 100) {
                    workProgress = 0;
                }
                ++workProgress;
                System.out.println(Thread.currentThread().getName() + " obecnie pracuje");
            }
        }
    }

}
