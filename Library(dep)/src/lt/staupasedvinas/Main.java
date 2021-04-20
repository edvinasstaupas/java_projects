package lt.staupasedvinas;

/**
 * Library management system
 *
 * @author Edvinas Staupas
 * @version 1.0
 */

import lt.staupasedvinas.book.Book;
import lt.staupasedvinas.user.Librarian;
import lt.staupasedvinas.user.Reader;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static lt.staupasedvinas.interfaces.InterfaceMethods.*;

public class Main {

    public static HashSet<Book> books = new HashSet<>();
    public static ArrayList<Librarian> librarians = new ArrayList<>();
    public static ArrayList<Reader> readers = new ArrayList<>();

    public static void main(String[] args) {
        chooseInterface();
    }

}
