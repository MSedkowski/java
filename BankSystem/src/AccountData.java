import java.io.Serializable;
import java.math.BigDecimal;

public class AccountData implements Serializable {
    private static final long serialVersionUID = 7178247579750074142L;
    private BigDecimal balance;
    private String accountNumber;
    AccountOwner owner;

    AccountData() {
    }

    public BigDecimal getAccountBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountBalance(BigDecimal value) {
        this.balance = value;
    }

    public void setAccountNumber(String value) throws AccountNumberFormatException {
        if (!value.matches("[0-9]{26}")
                && !value.matches("[0-9]{2}[ ][0-9]{4}[ ][0-9]{4}[ ][0-9]{4}[ ][0-9]{4}[ ][0-9]{4}[ ][0-9]{4}"))
            throw new AccountNumberFormatException();
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

    public void setOwner(AccountOwner newOwner) {
        this.owner = newOwner;
    }

}
