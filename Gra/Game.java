import java.util.Random;

public class Game {

    private int numberOfTries, number;
    private static long seed;
    private boolean result;

    Game(int range) {
        seed = System.currentTimeMillis();
        Random rnd = new Random();
        rnd.setSeed(seed);
        number = rnd.nextInt(range + 1);
        numberOfTries = 0;
    }

    public int getNumberOfTries() {
        return numberOfTries;
    }

    private void setNumberOfTries() {
        numberOfTries++;
    }

    public boolean getResult() {
        return result;
    }

    public void showResults(int range) {
        if (result) {
            System.out.println("WYGRANA !");
        } else {
            System.out.println("PORAZKA !");
        }
        System.out.println("Wyniki koncowe!");
        System.out.println("Zakres: " + range);
        System.out.println("Szukana liczba: " + number);
        System.out.println("Liczba prob: " + numberOfTries);
    }

    public void check(int guessingNumber) {
        if (guessingNumber == number) {
            result = true;
        } else if (guessingNumber > number) {
            setNumberOfTries();
            System.out.println("Szukana liczba jest mniejsza!");
            System.out.println("Liczba pozostalych prob: " + (10 - numberOfTries));
        } else if (guessingNumber == -1) {
            setNumberOfTries();
            System.out.println("Liczba pozostalych prob: " + (10 - numberOfTries));
        } else {
            setNumberOfTries();
            System.out.println("Szukana liczba jest wieksza!");
            System.out.println("Liczba pozostalych prob: " + (10 - numberOfTries));
        }
    }

}