import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.Serializable;

public class AccountData implements Serializable {
    private static final long serialVersionUID = 7178247579750074142L;
    private Integer balance;
    private String accountNumber;
    AccountOwner owner;
    private Scanner input;
    
    AccountData() {
        
    }
    
    public void setAccountData(AccountOwner owner) throws AccountNumberFormatException {
        System.out.print("Podaj stan konta: ");
        this.balance = inputInt();
        System.out.println();
        System.out.print("Podaj numer konta: ");
        this.accountNumber = inputStr();
        if(!accountNumber.matches("[0-9]{26}") && !accountNumber.matches("[0-9]{2} [0-9]{4} [0-9]{4} [0-9]{4} [0-9]{4} [0-9]{4} [0-9]{4}")) throw new AccountNumberFormatException();
        this.owner = owner;
    }
    
    public int getAccountBalance() {
        return balance;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public void setAccountBalance(int value) {
        this.balance = value; 
    }
    
    public void setAccountNumber(String value) throws AccountNumberFormatException {
        if(!value.matches("[0-9]{26}") && !value.matches("[0-9]{2}[ ][0-9]{4}[ ][0-9]{4}[ ][0-9]{4}[ ][0-9]{4}[ ][0-9]{4}[ ][0-9]{4}")) throw new AccountNumberFormatException();
        this.accountNumber = value;
    }
    
    @Override
    public String toString() {
        StringBuilder sbAccount = new StringBuilder();
        sbAccount.append(owner.toString()); 
        sbAccount.append("Numer konta: " + accountNumber).append(System.getProperty("line.separator")); 
        sbAccount.append("Stan konta: " + balance).append(System.getProperty("line.separator")); 
        return sbAccount.toString();
    }
    
    public String databaseSave() {
        StringBuilder sbAccount = new StringBuilder();
        sbAccount.append(owner.databaseSave()); 
        sbAccount.append(accountNumber).append(System.getProperty("line.separator")); 
        sbAccount.append(balance); 
        return sbAccount.toString();
    }
    
    private int inputInt() {
        try {
            input = new Scanner(System.in);
            return input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Nalezy podac liczbe!");
            return 0;
        }
    }
    
    private String inputStr() {
        input = new Scanner(System.in);
        return input.nextLine();
    }

}
