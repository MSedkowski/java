import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    private static int range, guessingNumber;
    private static boolean repeat = true;

    private void parse(String[] data) throws ArgumentAIsZeroException, NumberFormatException {
        range = Integer.parseInt(data[0]);
        if (range <= 0) {
            throw new ArgumentAIsZeroException();
        }
    }

    private void input() {
        try {
            Scanner input = new Scanner(System.in);
            guessingNumber = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Nalezy podac liczbe!");
            guessingNumber = -1;
        }
    }

    public void checkRepeat() {
        do {
<<<<<<< HEAD
            System.out.println("Czy chcesz zagraæ ponownie? [1] - Tak, [2] - Nie");
=======
            System.out.println("Czy chcesz zagrac ponownie? [1] - Tak, [2] - Nie");
>>>>>>> e192a12ec5b6ad8fb075abacf58f3273affb9064
            this.input();
            if (guessingNumber == 2) {
                repeat = false;
            } else if (guessingNumber == 1) {
                repeat = true;
            } else {
<<<<<<< HEAD
                System.out.println("Podales zla liczbe!");
=======
                System.out.println("Nalezy podac '1' albo '2'!");
>>>>>>> e192a12ec5b6ad8fb075abacf58f3273affb9064
                guessingNumber = 0;
            }
        } while (guessingNumber == 0);
    }

    public static void help() {
        System.out.println("Aby poprawnie wywolac program wpisz polecenie:");
        System.out.println("java Program n");
        System.out.println("gdzie n to gorny zakres losowanej liczby, np. 250");
    }

    public static void main(String[] data) {
        try {
            do {
                Program obj = new Program();
                obj.parse(data);
                Game object = new Game(range);
                System.out.println("Gra");
                System.out.println("Szukana liczba zostala wylosowana z zakresu od 0 do " + range);
                do {
                    System.out.print("Podaj swoj typ: ");
                    obj.input();
                    object.check(guessingNumber);
                } while (object.getNumberOfTries() < 10 && object.getResult() == false);
                clearScreen();
                object.showResults(range);
                obj.checkRepeat();
            } while (repeat == true);
            System.out.println("Dziekuje za gre");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Brak podanego zakresu");
            help();
        } catch (NumberFormatException error) {
            System.out.println("Podany zakres musi byc liczba!");
            help();
        } catch (ArgumentAIsZeroException a) {
            System.out.println(a.getMessage());
            help();
        } finally {
        }
    }

    public static void clearScreen() { // Works only on Linux
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}