import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.Serializable;
public class AccountData implements Serializable {
    private Integer balance;
    private String accountNumber;
    AccountOwner owner;
    
    AccountData(AccountOwner owner) throws AccountNumberFormatException {
        System.out.print("Podaj stan konta: ");
        this.balance = inputInt();
        System.out.println();
        System.out.print("Podaj numer konta: ");
        this.accountNumber = inputStr();
        if(!accountNumber.matches("[0-9]{26}") && !accountNumber.matches("[0-9]{2} [0-9]{4} [0-9]{4} [0-9]{4} [0-9]{4} [0-9]{4} [0-9]{4}")) throw new AccountNumberFormatException();
        this.setOwner(owner);
    }
    
    public int getAccountBalance() {
        return balance;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public void setAccountBalance(int value) {
        this.balance = value; 
    }
    
    public void setAccountNumber(String value) throws AccountNumberFormatException {
        if(!value.matches("[0-9]{26}") && !value.matches("[0-9]{2} [0-9]{4} [0-9]{4} [0-9]{4} [0-9]{4} [0-9]{4} [0-9]{4}")) throw new AccountNumberFormatException();
        this.accountNumber = value;
    }
    
    public void showOwner() {
        System.out.println("Imie: " + getOwner().getName());
        System.out.println("Nazwisko: " + getOwner().getSurname());
        System.out.println("Adres: " + getOwner().getStreet());
        System.out.println(getOwner().getPostCode() + ", " + getOwner().getCity());
        System.out.println("Pesel: " + getOwner().getPesel());
        System.out.println("Numer konta: " + accountNumber);
        System.out.println("Stan konta: " + balance);
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
    
    private String inputStr() {
        try {
            Scanner input = new Scanner(System.in);
            return input.next();
        } catch (InputMismatchException e) {
            System.out.println("Nalezy podac liczbe!");
            return "Brak danych";
        }
    }

    public AccountOwner getOwner() {
        return owner;
    }

    public void setOwner(AccountOwner owner) {
        this.owner = owner;
    }
}
