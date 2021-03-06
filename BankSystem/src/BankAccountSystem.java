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
            System.out.println("Nalezy podac liczbe.");
            return -1;
        }
    }

    private static BigDecimal inputBigDecimal() {
        try {
            input = new Scanner(System.in);
            return input.nextBigDecimal();
        } catch (InputMismatchException e) {
            System.out.println("Nalezy podac liczbe. Brak zmian.");
            return BigDecimal.ZERO;
        }
    }

    private static String inputStr() {
        input = new Scanner(System.in);
        return input.nextLine();
    }

    private AccountList readDatabaseFromFile(AccountList newList)
            throws FileNotFoundException, PostCodeFormatException, PeselFormatException, AccountNumberFormatException {
        try {
            File databaseFile = new File("accountDatabase.txt");
            input = new Scanner(databaseFile);
            int zdanie = input.nextInt();
            input.useDelimiter(System.getProperty("line.separator"));
            for (; zdanie > 0; zdanie--) {
                AccountOwner newOwner = new AccountOwner();
                AccountData newData = new AccountData();
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
            System.out.println("Brak bazy danych. Zostanie stworzona nowa po zakonczeniu dzialania programu.");
        }

        return newList;
    }

    private void saveDatabaseToFile(AccountList newList) throws FileNotFoundException {
        PrintWriter saveDatabase = new PrintWriter("accountDatabase.txt");
        PrintWriter saveText = new PrintWriter("accountText.txt");
        saveDatabase.println(newList.getList().size());
        for (int i = 0; i < newList.getList().size(); i++) {
            saveDatabase.println(newList.getAccountData(i).databaseSave());
        }
        for (int i = 0; i < newList.getList().size(); i++) {
            saveText.println(newList.getAccountData(i));
        }
        saveDatabase.close();
        saveText.close();
    }

    public static boolean confirmation() {
        System.out.println("Czy jestes pewien? - [1] - Tak ");
        if (inputInt() == 1) {
            return true;
        } else {
            System.out.println("Brak potwierdzenia, zmiany nie zostaly wprowadzone");
            return false;
        }
    }

    private AccountData addNewClient() {
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
            newData.toString();
            return newData;
        } catch (PostCodeFormatException e) {
            System.out.println(e.getMessage());
            System.out.println("Podane dane nie zostaly zapisane");
            return null;
        } catch (PeselFormatException e) {
            System.out.println(e.getMessage());
            System.out.println("Podane dane nie zostaly zapisane");
            return null;
        } catch (AccountNumberFormatException e) {
            System.out.println(e.getMessage());
            System.out.println("Podane dane nie zostaly zapisane");
            return null;
        }

    }

    private void updateClient(AccountList newList) {
        clearScreen();
        String tempValue;
        BigDecimal tempValueBigDecimal;
        try {
            System.out.println("Podaj pozycje do aktualizacji: ");
            position = inputInt();
            AccountData newData = newList.getAccountData(position - 1);
            System.out.println(newData.toString());
            System.out.println("Podaj ktore dane chcesz aktualizowac :");
            showOwnerDataMenu();
            System.out.println("Twoj wybor: ");
            switch (inputInt()) {

            case 1: {
                clearScreen();
                System.out.println("Imie wlasciciela: " + newData.owner.getName());
                System.out.println("Podaj nowe imie: ");
                tempValue = inputStr();
                if (confirmation()) {
                    newData.owner.setName(tempValue);
                }
                break;
            }

            case 2: {
                clearScreen();
                System.out.println("Nazwisko wlasciciela: " + newData.owner.getSurname());
                System.out.println("Podaj nowe nazwisko: ");
                tempValue = inputStr();
                if (confirmation()) {
                    newData.owner.setSurname(tempValue);
                }
                break;
            }

            case 3: {
                clearScreen();
                System.out.println("Obecny adres - ulica: " + newData.owner.getStreet());
                System.out.println("Nowy adres - ulica: ");
                tempValue = inputStr();
                if (confirmation()) {
                    newData.owner.setStreet(tempValue);
                }
                break;
            }

            case 4: {
                clearScreen();
                System.out.println("Obecny adres - kod pocztowy: " + newData.owner.getPostCode());
                System.out.println("Nowy adres - kod pocztowy: ");
                tempValue = inputStr();
                if (confirmation()) {
                    newData.owner.setPostCode(tempValue);
                }
                break;
            }

            case 5: {
                clearScreen();
                System.out.println("Obecny adres - miasto: " + newData.owner.getCity());
                System.out.println("Nowy adres - miasto: ");
                tempValue = inputStr();
                if (confirmation()) {
                    newData.owner.setCity(tempValue);
                }
                break;
            }

            case 6: {
                clearScreen();
                System.out.println("Obecny PESEL: " + newData.owner.getPesel());
                System.out.println("Nowy PESEL: ");
                tempValue = inputStr();
                if (confirmation()) {
                    newData.owner.setPesel(tempValue);
                }
                break;
            }

            case 7: {
                clearScreen();
                System.out.println("Obecny stan konta: " + newData.getAccountBalance());
                System.out.println("Podaj nowy stan konta: ");
                tempValueBigDecimal = inputBigDecimal();
                if (confirmation()) {
                    newData.setAccountBalance(tempValueBigDecimal);
                }
                break;
            }

            case 8: {
                clearScreen();
                System.out.println("Obecny numer konta: " + newData.getAccountNumber());
                System.out.println("Podaj nowy numer konta: ");
                tempValue = inputStr();
                if (confirmation()) {
                    newData.setAccountNumber(tempValue);
                }
                break;
            }

            case 0: {
                System.out.println("Brak zmian!");
                break;
            }
            }
            newData.toString();
        } catch (PostCodeFormatException e) {
            System.out.println(e.getMessage());
            System.out.println("Podane dane nie zostaly zapisane");
        } catch (PeselFormatException e) {
            System.out.println(e.getMessage());
            System.out.println("Podane dane nie zostaly zapisane");
        } catch (AccountNumberFormatException e) {
            System.out.println(e.getMessage());
            System.out.println("Podane dane nie zostaly zapisane");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Podany numer klienta nie istnieje");
            System.out.println("Obecnie w bazie jest " + newList.getList().size() + " klientow");
        }
    }

    private void removeClient(AccountList newList) {
        clearScreen();
        try {
            int tempValueInt;
            System.out.println("Podaj pozycje do usuniecia: ");
            tempValueInt = inputInt();
            if (confirmation()) {
                newList.removeAccountData(tempValueInt - 1);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Podany numer klienta nie istnieje");
            System.out.println("Obecnie w bazie jest " + newList.getList().size() + " klientow");
        }
    }

    private void makeTransactionBetweenClients(AccountList newList) {
        clearScreen();
        try {
            setRepeatTransaction(true);
            while (repeatTransactionOption) {
                showTransactionMenu();
                BigDecimal tempValueBigDecimal;
                System.out.println("Twoj wybor: ");
                switch (inputInt()) {

                case 1: {
                    clearScreen();
                    System.out.println("Podaj numer klienta");
                    AccountData newData = newList.getAccountData(inputInt() - 1);
                    newData.toString();
                    System.out.println("Podaj kwote do wplaty");
                    tempValueBigDecimal = inputBigDecimal();
                    if (confirmation()) {
                        newData.setAccountBalance(newData.getAccountBalance().add(tempValueBigDecimal));
                    }
                    break;
                }

                case 2: {
                    clearScreen();
                    System.out.println("Podaj numer klienta");
                    AccountData newData = newList.getAccountData(inputInt() - 1);
                    newData.toString();
                    System.out.println("Podaj kwote do wyplaty");
                    tempValueBigDecimal = inputBigDecimal();
                    if (confirmation()) {
                        newData.setAccountBalance(newData.getAccountBalance().subtract(tempValueBigDecimal));
                    }
                    break;
                }

                case 3: {
                    clearScreen();
                    System.out.println("Podaj numer klienta - adresata");
                    AccountData newAddresseeData = newList.getAccountData(inputInt() - 1);
                    newAddresseeData.toString();
                    System.out.println("Podaj numer klienta - odbiorcy");
                    AccountData newRecipientData = newList.getAccountData(inputInt() - 1);
                    newRecipientData.toString();
                    System.out.println("Podaj kwote transakcji");
                    tempValueBigDecimal = inputBigDecimal();
                    if (confirmation() && newAddresseeData.getAccountBalance().compareTo(tempValueBigDecimal) > -1) {
                        newAddresseeData
                                .setAccountBalance(newAddresseeData.getAccountBalance().subtract(tempValueBigDecimal));
                        newRecipientData
                                .setAccountBalance(newRecipientData.getAccountBalance().add(tempValueBigDecimal));
                    }
                    break;
                }

                case 0: {
                    clearScreen();
                    System.out.println("Koniec transakcji");
                    setRepeatTransaction(false);
                }
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Podany numer klienta nie istnieje");
            System.out.println("Obecnie w bazie jest " + newList.getList().size() + " klientow");
        }
    }

    private void searchClientsInDatabase(AccountList newList) {
        clearScreen();
        int[] answer;
        int tempValue;
        showOwnerDataMenu();
        System.out.println("Podaj kryterium wyszukiwania: ");
        tempValue = inputInt();
        System.out.println("Podaj wartosc do wyszukania: ");
        String searchingName = inputStr();
        SearchEngine newSearch = new SearchEngine();
        switch (tempValue) {
        case 1: {
            System.out.println("Wyszukiwanie po imieniu");
            answer = newSearch.compareByName(newList, searchingName);
            newSearch.showResults(newList, answer);
            break;
        }

        case 2: {
            System.out.println("Wyszukiwanie po nazwisku");
            answer = newSearch.compareBySurname(newList, searchingName);
            newSearch.showResults(newList, answer);
            break;
        }

        case 3: {
            System.out.println("Wyszukiwanie po adresie - ulica");
            answer = newSearch.compareByCity(newList, searchingName);
            newSearch.showResults(newList, answer);
            break;
        }

        case 4: {
            System.out.println("Wyszukiwanie po adresie - kod pocztowy");
            answer = newSearch.compareByPostCode(newList, searchingName);
            newSearch.showResults(newList, answer);
            break;
        }

        case 5: {
            System.out.println("Wyszukiwanie po adresie - miasto");
            answer = newSearch.compareByCity(newList, searchingName);
            newSearch.showResults(newList, answer);
            break;
        }

        case 6: {
            System.out.println("Wyszukiwanie po numerze pesel");
            answer = newSearch.compareByPesel(newList, searchingName);
            newSearch.showResults(newList, answer);
            break;
        }

        case 7: {
            System.out.println("Wyszukiwanie po numerze konta");
            answer = newSearch.compareByAccountNumber(newList, searchingName);
            newSearch.showResults(newList, answer);
            break;
        }

        case 0: {
            System.out.println("Koniec wyszukiwania");
            break;
        }
        }
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
                newList.addAccountData(newSystem.addNewClient());
                break;
            }

            case 2: {
                newSystem.updateClient(newList);
                break;
            }

            case 3: {
                newSystem.removeClient(newList);
                break;
            }

            case 4: {
                newSystem.makeTransactionBetweenClients(newList);
                break;
            }

            case 5: {
                newSystem.searchClientsInDatabase(newList);
                break;
            }

            case 6: {
                clearScreen();
                for (int i = 0; i < newList.getList().size(); i++) {
                    System.out.println(newList.getAccountData(i));
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
