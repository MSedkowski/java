
public class AccountData {
    private Integer balance;
    private Integer accountNumber;
    private AccountOwner owner;
    
    public int getAccountBalance() {
        return balance;
    }
    
    public int getAccountNumber() {
        return accountNumber;
    }
    
    public void setAccountBalance(int value) {
        this.balance = getAccountBalance() + value; 
    }
    
    public void setAccountNumber(int value) {
        this.accountNumber = value;
    }
}
