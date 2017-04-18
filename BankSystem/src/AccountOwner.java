import java.util.InputMismatchException;
import java.util.Scanner;

public class AccountOwner {
    private String name;
    private String surname;
    private String street;
    private String city;
    private String postCode;
    private String pesel;
    
    AccountOwner() {
        this.name = inputStr();
        this.surname = inputStr();
        this.street = inputStr();
        this.city = inputStr();
        this.postCode = inputStr();
        this.pesel = inputStr();
        
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
}
