package lt.staupasedvinas;

public class BadInputException extends Exception {
    public BadInputException(Throwable cause) {
        super("Bad input", cause);
    }
}
