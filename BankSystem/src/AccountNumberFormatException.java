
public class AccountNumberFormatException extends Exception {
    
    AccountNumberFormatException() {
        super("Podany numer konta jest bledny! Uzyj formatu 26 cyfr lub elektronicznego");
    }
    
    private static final long serialVersionUID = 1L;
}
