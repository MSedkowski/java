import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;

public class BankAccountSystem {
    int chosenOption;
    static int position;
    static boolean repeatOption, repeatTransactionOption;
    private static Scanner input;

    BankAccountSystem() {
    }

    private int getChosenOption() {
        return chosenOption;
    }

    private void setChosenOption() {
        chosenOption = inputInt();
    }

    private static void setRepeat(boolean value) {
        repeatOption = value;
    }

    private static void setRepeatTransaction(boolean value) {
        repeatTransactionOption = value;
    }

    public void showMenu() {
        System.out.println("[1] Dodaj konto");
        System.out.println("[2] Aktualizuj konto");
        System.out.println("[3] Usun konto");
        System.out.println("[4] Wykonaj transakcje");
        System.out.println("[5] Wyszukaj");
        System.out.println("[6] Wszystkie konta");
        System.out.println("[0] Wyjscie");
    }

    public static void showOwnerDataMenu() {
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

    public static void showTransactionMenu() {
        System.out.println("[1] Wplata");
        System.out.println("[2] Wyplata");
        System.out.println("[3] Transfer miedzy kontami");
        System.out.println("[0] Wyjscie");
    }

    private static int inputInt() {
        try {
            input = new Scanner(System.in);
            return input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Nalezy podac liczbe!");
            return 0;
        }
    }

    private static BigDecimal inputBigDecimal() {
        try {
            input = new Scanner(System.in);
            return input.nextBigDecimal();
        } catch (InputMismatchException e) {
            System.out.println("Nalezy podac liczbe!");
            return null;
        }
    }

    private static String inputStr() {
        input = new Scanner(System.in);
        return input.next();
    }

    private AccountList readDatabaseFromFile(AccountList newList)
            throws FileNotFoundException, PostCodeFormatException, PeselFormatException, AccountNumberFormatException {
        try {
            File databaseFile = new File("accountDatabase.txt");
            input = new Scanner(databaseFile);
            AccountOwner newOwner = new AccountOwner();
            AccountData newData = new AccountData();
            int zdanie = input.nextInt();
            input.useDelimiter(System.getProperty("line.separator"));
            for (; zdanie > 0; zdanie--) {
                newOwner.setName(input.next());
                newOwner.setSurname(input.next());
                newOwner.setStreet(input.next());
                newOwner.setPostCode(input.next());
                newOwner.setCity(input.next());
                newOwner.setPesel(input.next());
                newData.setOwner(newOwner);
                newData.setAccountNumber(input.next());
                newData.setAccountBalance(input.nextBigDecimal());
                newList.addAccountData(newData);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Brak bazy danych. Zostanie stworzona nowa po zakoñczeniu dzia³ania programu.");
        }

        return newList;
    }

    private void saveDatabaseToFile(AccountList newList) throws FileNotFoundException {
        PrintWriter saveDatabase = new PrintWriter("accountDatabase.txt");
        PrintWriter saveText = new PrintWriter("accountText.txt");
        saveDatabase.println(newList.getList().size());
        for (int i = 0; i < newList.getList().size(); i++) {
            saveDatabase.println(newList.getList().get(i).databaseSave());
        }
        for (int i = 0; i < newList.getList().size(); i++) {
            saveText.println(newList.getList().get(i));
        }
        saveDatabase.close();
        saveText.close();
    }

    public static void main(String[] args)
            throws PostCodeFormatException, PeselFormatException, AccountNumberFormatException, FileNotFoundException {
        setRepeat(true);
        System.out.println("Witam w programie bankowym");
        BankAccountSystem newSystem = new BankAccountSystem();
        AccountList newList = new AccountList();
        newSystem.readDatabaseFromFile(newList);
        while (repeatOption) {
            newSystem.showMenu();
            newSystem.setChosenOption();
            switch (newSystem.getChosenOption()) {

            case 1: {
                try {
                    clearScreen();
                    AccountOwner newOwner = new AccountOwner();
                    AccountData newData = new AccountData();
                    System.out.print("Podaj imie wlasciciela: ");
                    newOwner.setName(inputStr());
                    System.out.println("Podaj nazwisko wlasciciela: ");
                    newOwner.setSurname(inputStr());
                    System.out.println("Podaj adres wlasciciela: ");
                    System.out.println("Ulica: ");
                    newOwner.setStreet(inputStr());
                    System.out.println("Kod pocztowy: ");
                    newOwner.setPostCode(inputStr());
                    System.out.println("Miasto: ");
                    newOwner.setCity(inputStr());
                    System.out.println("Pesel: ");
                    newOwner.setPesel(inputStr());
                    newData.setOwner(newOwner);
                    System.out.println("Podaj stan konta: ");
                    newData.setAccountBalance(inputBigDecimal());
                    System.out.println("Podaj numer konta: ");
                    newData.setAccountNumber(inputStr());
                    newList.addAccountData(newData);
                    newData.toString();
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
                clearScreen();
                System.out.println("Podaj pozycje do aktualizacji: ");
                position = inputInt();
                AccountData newData = newList.getList().get(position - 1);
                System.out.println(newData.toString());
                System.out.println("Podaj ktore dane chcesz aktualizowac :");
                showOwnerDataMenu();
                System.out.println("Twoj wybor: ");
                switch (inputInt()) {

                case 1: {
                    clearScreen();
                    System.out.println("Imie wlasciciela: " + newData.owner.getName());
                    System.out.println("Podaj nowe imie: ");
                    newData.owner.setName(inputStr());
                    break;
                }

                case 2: {
                    clearScreen();
                    System.out.println("Nazwisko wlasciciela: " + newData.owner.getSurname());
                    System.out.println("Podaj nowe nazwisko: ");
                    newData.owner.setSurname(inputStr());
                    break;
                }

                case 3: {
                    clearScreen();
                    System.out.println("Obecny adres - ulica: " + newData.owner.getStreet());
                    System.out.println("Nowy adres - ulica: ");
                    newData.owner.setStreet(inputStr());
                    break;
                }

                case 4: {
                    clearScreen();
                    System.out.println("Obecny adres - kod pocztowy: " + newData.owner.getPostCode());
                    System.out.println("Nowy adres - kod pocztowy: ");
                    newData.owner.setPostCode(inputStr());
                    break;
                }

                case 5: {
                    clearScreen();
                    System.out.println("Obecny adres - miasto: " + newData.owner.getCity());
                    System.out.println("Nowy adres - miasto: ");
                    newData.owner.setCity(inputStr());
                    break;
                }

                case 6: {
                    clearScreen();
                    System.out.println("Obecny PESEL: " + newData.owner.getPesel());
                    System.out.println("Nowy PESEL: ");
                    newData.owner.setPesel(inputStr());
                    break;
                }

                case 7: {
                    clearScreen();
                    System.out.println("Obecny stan konta: " + newData.getAccountBalance());
                    System.out.println("Podaj nowy stan konta: ");
                    newData.setAccountBalance(inputBigDecimal());
                    break;
                }

                case 8: {
                    clearScreen();
                    System.out.println("Obecny numer konta: " + newData.getAccountNumber());
                    System.out.println("Podaj nowy numer konta: ");
                    newData.setAccountNumber(inputStr());
                    break;
                }

                case 0: {
                    System.out.println("Brak zmian!");
                    break;
                }
                }
                newData.toString();
                newList.setAccountData(newData, position - 1);
                break;
            }

            case 3: {
                clearScreen();
                System.out.println("Podaj pozycje do usuniecia: ");
                newList.removeAccountData(inputInt() - 1);
                break;
            }

            case 4: {
                clearScreen();
                setRepeatTransaction(true);
                while (repeatTransactionOption) {
                    showTransactionMenu();
                    System.out.println("Twoj wybor: ");
                    switch (inputInt()) {

                    case 1: {
                        clearScreen();
                        System.out.println("Podaj numer klienta");
                        AccountData newData = newList.getList().get(inputInt() - 1);
                        newData.toString();
                        System.out.println("Podaj kwotê do wplaty");
                        newData.setAccountBalance(newData.getAccountBalance().add(inputBigDecimal()));
                    }

                    case 2: {
                        clearScreen();
                        System.out.println("Podaj numer klienta");
                        AccountData newData = newList.getList().get(inputInt() - 1);
                        newData.toString();
                        System.out.println("Podaj kwotê do wplaty");
                        newData.setAccountBalance(newData.getAccountBalance().subtract(inputBigDecimal()));
                    }

                    case 3: {
                        clearScreen();
                        System.out.println("Podaj numer klienta - adresata");
                        AccountData newAddresseeData = newList.getList().get(inputInt() - 1);
                        newAddresseeData.toString();
                        System.out.println("Podaj numer klienta - odbiorcy");
                        AccountData newRecipientData = newList.getList().get(inputInt() - 1);
                        newRecipientData.toString();
                        System.out.println("Podaj kwotê transakcji");
                        newAddresseeData
                                .setAccountBalance(newAddresseeData.getAccountBalance().subtract(inputBigDecimal()));
                        newRecipientData.setAccountBalance(newRecipientData.getAccountBalance().add(inputBigDecimal()));
                    }

                    case 0: {
                        clearScreen();
                        System.out.println("Koniec transakcji");
                        setRepeatTransaction(false);
                    }
                    }
                }
                break;
            }

            case 6: {
                clearScreen();
                for (int i = 0; i < newList.getList().size(); i++) {
                    System.out.println(newList.getList().get(i));
                }
                break;
            }

            case 0: {
                setRepeat(false);
            }
                newSystem.saveDatabaseToFile(newList);
            }

        }
    }
    
    public static void clearScreen() { // Works only on Linux
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
