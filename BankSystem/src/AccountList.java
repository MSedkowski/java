import java.util.ArrayList;
import java.util.List;

public class AccountList {
    private List <AccountOwner> accountList;
    
    public AccountList()
    {
        accountList = new ArrayList<AccountOwner>();
    }
    
    public void addAccountOwner(AccountOwner a)
    {
        accountList.add(a);
    }
    
    public AccountOwner selectAccountOwner(int numer)
    {
        return accountList.get(numer);
    }
    
    public List<AccountOwner> returnAllAccountOwners()
    {
        return accountList;
    }

}
