package zadanie5;

public class Deadlock extends Thread{

    public static Object bolts = new Object();
    public static Object nuts = new Object();

    public void run(){
        Thread worker1 = new job1();
        Thread worker2 = new job2();
        long startTime = System.currentTimeMillis();
        worker1.start();
        worker2.start();
        long period = 0;
        while (true) {
            period = System.currentTimeMillis() - startTime;
            if (period > 10000) {
                System.out.println("Wymuszono zamknięcie");
                System.exit(0);
            }
        }
    }

    private static class job1 extends Thread {

        public void run() {
            synchronized (bolts) {
                System.out.println("Pracownik Zdzisiek bierze wszystkie śruby...");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
                System.out.println("Pracownik Zdzisiek szuka nakrętek...");
                synchronized (nuts) {
                    System.out.println("Pracownik Zdzisiek skompletował śruby i nakrętki...");
                }
            }
        }
    }

    private static class job2 extends Thread {

        public void run() {
            synchronized (nuts) {
                System.out.println("Pracownik Marian bierze wszystkie nakrętki...");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
                System.out.println("Pracownik Marian szuka śrubek...");
                synchronized (bolts) {
                    System.out.println("Pracownik Marian ma wszystkie nakrętki i śrubki...");
                }
            }
        }
    }
}
