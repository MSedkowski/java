package banksystem.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Account {
    StringProperty accountName, password;
    IntegerProperty accountId;

    public Account(String accountName, String password, int accountId) {
        this.accountName = new SimpleStringProperty(accountName);
        this.password = new SimpleStringProperty(password);
        this.accountId = new SimpleIntegerProperty(accountId);
    }

    public String getAccountName() {
        return accountName.get();
    }

    public void setAccountName(String accountName) {
        this.accountName.set(accountName);
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password.set(password);
    }
}
