import java.util.Scanner;
import java.io.Serializable;

public class AccountOwner implements Serializable {
    private static final long serialVersionUID = 4051080129864912795L;
    private String name;
    private String surname;
    private String street;
    private String city;
    private String postCode;
    private String pesel;
    private Scanner input;
    
    AccountOwner() throws PostCodeFormatException, PeselFormatException {
        System.out.print("Podaj imie wlasciciela: ");
        setName();
        System.out.println("Podaj nazwisko wlasciciela: ");
        setSurname();
        System.out.println("Podaj adres wlasciciela: ");
        System.out.println("Ulica: ");
        setStreet();
        System.out.println("Kod pocztowy: ");
        setPostCode();
        System.out.println("Miasto: ");
        setCity();
        System.out.println("Pesel: ");
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
        input = new Scanner(System.in);
        return input.next();
    }
    
    @Override
    public String toString() {
        return "Imie i nazwisko: " + name + " " + surname + "\n " + "Adres: " + street + "\n " + postCode + ", " + city
                + "\n Pesel: " + pesel;
    }
}
