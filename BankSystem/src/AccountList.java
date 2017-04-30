import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
        accountList.remove(number - 1);
    }
    
    /*public AccountData selectAccountData(int number)
    {
        return accountList.get(number - 1);
    }*/
    
    public List<AccountData> getList()
    {
        return accountList;
    }

    public void setAccountData(AccountData newData, int i) {
        accountList.set(i, newData);
    }

    public int getListSize() {
        return accountList.size();
    }
    
    public void saveList() throws FileNotFoundException{
        PrintWriter zapis = new PrintWriter("ala.txt");
        for (int i = 0; i < accountList.size(); i++) {
        zapis.println(accountList.get(i));
        }
        zapis.close();
  }

}
