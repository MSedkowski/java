package banksystem.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AccountRepository {

    private ObservableList<AccountData> accountList = FXCollections.observableArrayList();
    
    public void setAccountList(ObservableList<AccountData> accountList) {
        this.accountList = accountList;
    }

    public ObservableList<AccountData> getAccountList() {
        return accountList;
    }
    
    public void addAccount(AccountData account) {
        this.accountList.add(account);
    }
    
    public void removeAccount(AccountData account) {
        this.accountList.remove(account);
    }
}
