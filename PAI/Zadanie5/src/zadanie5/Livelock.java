package zadanie5;

class Worker {

    boolean status = false;

    public void action(Electrician electrician) {
        while (!electrician.status && !Thread.currentThread().isInterrupted()) {
            System.out.println("Mietek!?, Gdzie jesteś?");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
        System.out.println("Znalazłem Mietka, kończymy fuszkę!");
    }

}

class Electrician {

    boolean status = false;

    public void action(Worker worker) {
        while (!worker.status && !Thread.currentThread().isInterrupted()) {
            System.out.println("Zdzichu?, gdzie jesteś Zdzichu?");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
        System.out.println("Zdzisiek się odnalazł, bierzemy się do pracy!");
    }
}

public class Livelock extends Thread {

    public void run() {
        System.out.println("Zaczynamy pracę");
        Worker worker = new Worker();
        Electrician electrician = new Electrician();

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                worker.action(electrician);
            }
        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                electrician.action(worker);
            }
        });

        t1.start();
        t2.start();

        while (!isInterrupted());

        t1.interrupt();
        t2.interrupt();

        System.out.println("Koniec pracy!");
    }
}
