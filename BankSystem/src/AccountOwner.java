import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.Serializable;

public class AccountOwner implements Serializable {
    private String name;
    private String surname;
    private String street;
    private String city;
    private String postCode;
    private String pesel;
    
    AccountOwner() throws PostCodeFormatException, PeselFormatException {
        setName();
        setSurname();
        setStreet();
        setCity();
        setPostCode();
        setPesel();
    }
    
    public void setName() {
        this.name = inputStr();
    }
    
    public void setSurname() {
        this.surname = inputStr();
    }
    
    public void setStreet() {
        this.street = inputStr();
    }
    
    public void setCity() {
        this.city = inputStr();
    }
    
    public void setPostCode() throws PostCodeFormatException{
        this.postCode = inputStr();
        if(!postCode.matches("[0-9]{2}-[0-9]{3}")) throw new PostCodeFormatException();
    }
    
    public void setPesel() throws PeselFormatException {
        this.pesel = inputStr();
        if(!pesel.matches("[0-9]{11}")) throw new PeselFormatException();
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getSurname() {
        return this.surname;
    }
    
    public String getStreet() {
        return this.street;
    }
    
    public String getCity() {
        return this.city;
    }
    
    public String getPostCode() {
        return this.postCode;
    }
    
    public String getPesel() {
        return this.pesel;
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
