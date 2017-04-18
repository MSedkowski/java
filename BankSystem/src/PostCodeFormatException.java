
public class PostCodeFormatException extends Exception {
    PostCodeFormatException() {
        super("Podany kod pocztowy jest bledny! Uzyj formatu xx-xxx");
    }
    
    private static final long serialVersionUID = 1L;
}
