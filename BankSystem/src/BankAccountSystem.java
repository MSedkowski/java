import java.util.InputMismatchException;
import java.util.Scanner;

public class BankAccountSystem {
    int chosenOption;
    
    BankAccountSystem() {
        chosenOption = inputInt();
    }
    
    void showMenu() {
        System.out.println("[1] Dodaj konto");
        System.out.println("[2] Aktualizuj konto");
        System.out.println("[3] Usun konto");
        System.out.println("[4] Wykonaj przelew");
        System.out.println("[5] Wyszukaj");
        System.out.println("[6] Wszystkie konta");
        System.out.println("[0] Wyjscie");
    }

    void showTransactionMenu() {
        System.out.println("[1] Wplata");
        System.out.println("[2] Wyplata");
        System.out.println("[3] Transfer miedzy kontami");
        System.out.println("[0] Wyjscie");
    }
    
    private int inputInt() {
        try {
            Scanner input = new Scanner(System.in);
            return input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Nalezy podac liczbe!");
            return 0;
        }
    }
    
}
