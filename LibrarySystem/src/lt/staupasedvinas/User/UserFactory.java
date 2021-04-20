package lt.staupasedvinas.User;


/**
 * Creates User children class objects
 */
public class UserFactory {
    public static Reader createDefaultReader(String name) {
        return new Reader(name);
    }

    public static Librarian createDefaultLibrarian(String name) {
        return new Librarian(name);
    }
}
