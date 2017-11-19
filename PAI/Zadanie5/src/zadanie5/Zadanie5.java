package zadanie5;

public class Zadanie5 {

    public static void main(String[] args) {
        if (args.length != 1) {
            return;
        }

        Thread t = null;
        switch(args[0]) {
            case "1": {
                t = new Starvation();
                break;
            }
            case "2": {
                t = new Deadlock();
                break;
            }
            case "3": {
                t = new Livelock();
                break;
            }
        }
        t.setName("Pracownicy");
        t.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.interrupt();
    }

}
