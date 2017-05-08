
public class PeselFormatException extends Exception {
    PeselFormatException() {
        super("Podany numer pesel jest bledny. Uzyj poprawnego formatu 11 cyfr");
    }
    
    private static final long serialVersionUID = 1L;
}
