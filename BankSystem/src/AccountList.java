import java.util.ArrayList;
import java.util.List;

public class AccountList {
    private List <AccountData> accountList;
    
    public AccountList()
    {
        accountList = new ArrayList<AccountData>();
    }
    
    public void addAccountData(AccountData a)
    {
        accountList.add(a);
    }
    
    public void removeAccountData (int number) {
        accountList.remove(number);
    }
    
    public AccountData selectAccountData(int number)
    {
        return accountList.get(number - 1);
    }
    
    public List<AccountData> returnAllAccountData()
    {
        return accountList;
    }

}
