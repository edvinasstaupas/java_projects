package lt.staupasedvinas.Methods;

import lt.staupasedvinas.Book.Book;

/**
 * Creates Book objects
 */
class BookFactory {
    public static Book createDefaultBook(String title, String author, int publishYear) {
        return new Book(title, author, publishYear);
    }
}
