import java.util.InputMismatchException;
import java.util.Scanner;

public class AccountOwner {
    private String name;
    private String surname;
    private String street;
    private String city;
    private Integer pesel;
    private Integer accountNumber;
    private Integer balance;
    
    
    public AccountOwner() {
        this.name = "";
        this.surname = "";
        this.street = "";
        this.city = "";
        this.pesel = new Integer(0);
        this.accountNumber = new Integer(0);
        this.balance = new Integer (0);
    }
    
    public void setName() {
        name = inputStr();
    }
    
    public void setSurname() {
        surname = inputStr();
    }
    
    public void setStret() {
        street = inputStr();
    }
    
    public void setCity() {
        city = inputStr();
    }
    
    public void setPesel() {
        pesel = inputInt();
    }
    
    public void setAccountNumber() {
        accountNumber = inputInt();
    }
    
    public void setBalance() {
        balance = inputInt();
    }
    
    public void setAll() {
        name = inputStr();
        surname = inputStr();
        street = inputStr();
        city = inputStr();
        pesel = inputInt();
        accountNumber = inputInt();
        balance = inputInt();
    }
    
    public String getName() {
        return name;
    }
    
    public String getSurname() {
        return surname;
    }
    
    public String getStreet() {
        return street;
    }
    
    public String getCity() {
        return city;
    }
    
    public int getPesel() {
        return pesel;
    }
    
    public int getAccountNumber() {
       return accountNumber;
    }
    
    public int getBalance() {
        return balance;
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
