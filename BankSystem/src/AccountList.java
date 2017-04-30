import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.util.Scanner;

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
    
    /*public void loadList(){
         File file = new File("ala.txt");
         Scanner in = new Scanner(file);
       
         accountList.set(i) = in.nextLine();
    }*/
    
    public void saveList() throws FileNotFoundException{
        PrintWriter saveDatabase = new PrintWriter("accountDatabase.txt");
        PrintWriter saveText = new PrintWriter("accountText.txt");
        saveDatabase.println(accountList.size());
        for (int i = 0; i < accountList.size(); i++) {
            saveDatabase.println(accountList.get(i).databaseSave());
        }
        for (int i = 0; i < accountList.size(); i++) {
            saveText.println(accountList.get(i).textSave());
        }
        saveDatabase.close();
        saveText.close();
  }

}
