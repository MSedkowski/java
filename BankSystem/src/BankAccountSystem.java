import java.util.InputMismatchException;
import java.util.Scanner;

public class BankAccountSystem {
    int chosenOption;
    static boolean menuOption, transactionOption;
    
    BankAccountSystem() {
        showMenu();
        setChosenOption();
    }
    
    private int getChosenOption() {
        return chosenOption;
    }
    
    private void setChosenOption() {
        chosenOption = inputInt();
    }
    
    private static void setMenuOption(boolean value) {
        menuOption = value;
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
    
    private static int inputInt() {
        try {
            Scanner input = new Scanner(System.in);
            return input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Nalezy podac liczbe!");
            return 0;
        }
    }
    
    public static void main(String[] args) {
        menuOption = true;
        System.out.println("Witam w programie bankowym");
        AccountList newList = new AccountList();
        while(menuOption) {
            BankAccountSystem newSystem = new BankAccountSystem();
            switch(newSystem.getChosenOption()) {
            
            case 1: {
                try {
                    AccountOwner newOwner = new AccountOwner();
                    AccountData newData = new AccountData(newOwner);
                    newList.addAccountData(newData);
                    newData.showOwner();
                    break;
                } catch (PostCodeFormatException e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                } catch (PeselFormatException e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                } catch (AccountNumberFormatException e) {
                    System.out.println(e.getMessage());
                }
            }
            
            case 3: {
                System.out.println("Podaj pozycje do usuniecia: ");
                newList.removeAccountData(inputInt());
                break;
            }
            
            case 6: {
                newList.returnAllAccountData();
                break;
            }
            
            case 0: {
                setMenuOption(false);
            }
            
            }
            
        }
    }
    
}
