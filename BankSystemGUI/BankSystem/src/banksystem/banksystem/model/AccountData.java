package banksystem.model;

import java.math.BigDecimal;

import javafx.beans.binding.StringExpression;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class AccountData {
    SimpleStringProperty name, surname, login, password, accountType;
    StringProperty street, postCode, city, pesel, accountNumber;
    BigDecimal accountBalance;
    int id;

    public AccountData(String name, String surname, String street, String postCode, String city, String pesel, 
                       String accountName, BigDecimal accountBalance, String login, String password,
                       String accountType, Boolean isAdmin) {
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
        this.street = new SimpleStringProperty(street);
        this.postCode = new SimpleStringProperty(postCode);
        this.city = new SimpleStringProperty(city);
        this.pesel = new SimpleStringProperty(pesel);
        this.accountNumber = new SimpleStringProperty(accountName);
        this.accountBalance = accountBalance;
        this.login = new SimpleStringProperty(login);
        this.password = new SimpleStringProperty(password);
        this.accountType = new SimpleStringProperty(accountType);
    }
    
    public AccountData() {
        this.name = new SimpleStringProperty("");
        this.surname = new SimpleStringProperty("");
        this.street = new SimpleStringProperty("");
        this.postCode = new SimpleStringProperty("");
        this.city = new SimpleStringProperty("");
        this.pesel = new SimpleStringProperty("");
        this.accountNumber = new SimpleStringProperty("");
        this.accountBalance = new BigDecimal(0);
        this.login = new SimpleStringProperty("");
        this.password = new SimpleStringProperty("");
        this.accountType = new SimpleStringProperty("");
    }
    
    public AccountData(Object object) {
        if (object instanceof AccountData) {
            this.name = ((AccountData) object).name;
            this.surname = ((AccountData) object).surname;
            this.street = ((AccountData) object).street;
            this.postCode = ((AccountData) object).postCode;
            this.city = ((AccountData) object).city;
            this.pesel = ((AccountData) object).pesel;
            this.accountNumber = ((AccountData) object).accountNumber;
            this.accountBalance = ((AccountData) object).accountBalance;
            this.login = ((AccountData) object).login;
            this.password = ((AccountData) object).password;
            this.accountType = ((AccountData) object).accountType;
        }
    }

    public String getStreet() {
        return street.get();
    }

    public void setStreet(String street) {
        this.street.set(street);
    }
    
    public StringProperty getStreetProperty() {
        return street;
    }

    public String getPostCode() {
        return postCode.get();
    }

    public void setPostCode(String postCode) {
        this.postCode.set(postCode);
    }
    
    public StringProperty getPostCodeProperty() {
        return postCode;
    }

    public String getCity() {
        return city.get();
    }

    public void setCity(String city) {
        this.city.set(city);
    }
    
    public StringProperty getCityProperty() {
        return city;
    }

    public String getPesel() {
        return pesel.get();
    }

    public void setPesel(String pesel) {
        this.pesel.set(pesel);
    }
    
    public StringProperty getPeselProperty() {
        return pesel;
    }

    public String getAccountNumber() {
        return accountNumber.get();
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber.set(accountNumber);
    }
    
    public StringProperty getAccountNumberProperty() {
        return accountNumber;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }
    
    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }
    
    public StringProperty getNameProperty() {
        return name;
    }

    public String getSurname() {
        return surname.get();
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }
    
    public StringProperty getSurnameProperty() {
        return surname;
    }
    
    public String getLogin() {
        return login.get();
    }

    public void setLogin(String login) {
        this.login.set(login);
    }
    
    public StringProperty getLoginProperty() {
        return login;
    }
    
    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password.set(password);
    }
    
    public StringProperty getPasswordProperty() {
        return password;
    }
    
    public String getAccountType() {
        return accountType.get();
    }

    public void setAccountType(String accountType) {
        this.accountType.set(accountType);
    }
    
    public StringProperty getAccountTypeProperty() {
        return accountType;
    }

    public StringExpression getFullName() {
       return name.concat(" ").concat(surname);
    }
}
