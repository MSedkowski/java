import java.io.Serializable;

public class AccountOwner implements Serializable {
    private static final long serialVersionUID = 4051080129864912795L;
    private String name;
    private String surname;
    private String street;
    private String city;
    private String postCode;
    private String pesel;
    
    AccountOwner(){
    }
    
    public void setName(String value) {
        this.name = value;
    }
    
    public void setSurname(String value) {
        this.surname = value;
    }
    
    public void setStreet(String value) {
        this.street = value;
    }
    
    public void setCity(String value) {
        this.city = value;
    }
    
    public void setPostCode(String value) throws PostCodeFormatException{
        if(!value.matches("[0-9]{2}-[0-9]{3}")) throw new PostCodeFormatException();
        this.postCode = value;
    }
    
    public void setPesel(String value) throws PeselFormatException {
        if(!value.matches("[0-9]{11}")) throw new PeselFormatException();
        this.pesel = value;
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
    
    @Override
    public String toString() {
        StringBuilder sbOwner = new StringBuilder();
        sbOwner.append("Imie i nazwisko: " + name + " " + surname).append(System.getProperty("line.separator")); 
        sbOwner.append("Adres: " + street).append(System.getProperty("line.separator")); 
        sbOwner.append(postCode + ", " + city).append(System.getProperty("line.separator")); 
        sbOwner.append("Pesel: " + pesel).append(System.getProperty("line.separator")); 
        return sbOwner.toString();
    }
    
    public String databaseSave() {
        StringBuilder sbOwner = new StringBuilder();
        sbOwner.append(name).append(System.getProperty("line.separator")); 
        sbOwner.append(surname).append(System.getProperty("line.separator")); 
        sbOwner.append(street).append(System.getProperty("line.separator")); 
        sbOwner.append(postCode).append(System.getProperty("line.separator")); 
        sbOwner.append(city).append(System.getProperty("line.separator")); 
        sbOwner.append(pesel).append(System.getProperty("line.separator")); 
        return sbOwner.toString();
    }
}
