import java.util.InputMismatchException;
import java.util.Scanner;

public class BankAccountSystem {
    int chosenOption;
    static int position;
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
        System.out.println("[4] Wykonaj transakcje");
        System.out.println("[5] Wyszukaj");
        System.out.println("[6] Wszystkie konta");
        System.out.println("[0] Wyjscie");
    }

    static void showOwnerDataMenu() {
        System.out.println("[1] Imie");
        System.out.println("[2] Nazwisko");
        System.out.println("[3] Ulica");
        System.out.println("[4] Kod pocztowy");
        System.out.println("[5] Miasto");
        System.out.println("[6] Pesel");
        System.out.println("[7] Stan konta");
        System.out.println("[8] Numer konta");
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
    
    private static String inputStr() {
        try {
            Scanner input = new Scanner(System.in);
            return input.next();
        } catch (InputMismatchException e) {
            System.out.println("Nalezy podac liczbe!");
            return "Brak danych";
        }
    }
    
    public static void main(String[] args) throws PostCodeFormatException, PeselFormatException, AccountNumberFormatException {
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
            
            case 2: {
                System.out.println("Podaj pozycje do aktualizacji: ");
                position = inputInt();
                AccountData newData = newList.selectAccountData(position);
                newData.showOwner();
                System.out.println("Podaj ktore dane chcesz aktualizowac :");
                showOwnerDataMenu();
                System.out.println("Twoj wybor: ");
                switch(inputInt()) {
                
                case 1: {
                    newData.owner.setName();
                    break;
                }
                
                case 2: {
                    newData.owner.setSurname();
                    break;
                }
                
                case 3: {
                    newData.owner.setStreet();
                    break;
                }
                
                case 4: {
                    newData.owner.setPostCode();
                    break;
                }
                
                case 5: {
                    newData.owner.setCity();
                    break;
                }
                
                case 6: {
                    newData.owner.setPesel();
                    break;
                }
                
                case 7: {
                    System.out.println("Podaj nowy stan konta: ");
                    newData.setAccountBalance(inputInt());
                    break;
                }
                
                case 8: {
                    System.out.println("Podaj nowy numer konta: ");
                    newData.setAccountNumber(inputStr());
                    break;
                }
                
                case 0: {
                    System.out.println("Brak zmian!");
                    break;
                }
                }
                newData.showOwner();
                newList.setAccountData(newData, position - 1);
                break;
            }
            
            case 3: {
                System.out.println("Podaj pozycje do usuniecia: ");
                newList.removeAccountData(inputInt() - 1);
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
