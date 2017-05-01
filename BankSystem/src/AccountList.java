import java.util.ArrayList;
import java.util.List;

public class AccountList {
    private List<AccountData> accountList;

    public AccountList() {
        accountList = new ArrayList<AccountData>();
    }

    public void addAccountData(AccountData a) {
        accountList.add(a);
    }

    public void removeAccountData(int number) {
        accountList.remove(number - 1);
    }

    public List<AccountData> getList() {
        return accountList;
    }

    public void setAccountData(AccountData newData, int i) {
        accountList.set(i, newData);
    }

}
