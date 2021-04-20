package lt.staupasedvinas.Methods;

import lt.staupasedvinas.Book.Book;
import lt.staupasedvinas.User.User;

import java.util.ArrayList;

import static lt.staupasedvinas.Methods.Lists.*;
import static lt.staupasedvinas.Methods.MethodString.*;

public class BookMethods {


    /**
     * @param user determines how much information will be shown (librarian ("librarian") and reader ("redaer") modes available)
     * @return info String if there are any books, empty String if there aren't any.
     */
    public static String showBooks(String user) {
        StringBuilder info = new StringBuilder();
        if (books.size() == 0) {
            return "";
        }
        for (Book book : books) {
            info.append(book.toString(user));
        }
        return info.toString();
    }

    /**
     * @param title       title of the book
     * @param author      author of the book
     * @param publishYear year of publish
     * @return if year input is good and book was added, returns true, otherwise - false
     */
    public static boolean addBook(String title, String author, int publishYear) {
        String publishYearString = String.valueOf(publishYear);
        if (!publishYearString.matches("[0-9]+")) {
            return false;
        }
        Book oneBook = BookFactory.createDefaultBook(title, author, publishYear);
        books.add(oneBook);
        return true;
    }

    /**
     * @param title
     * @param user
     * @return returns string of books with the title, string is empty if no books were found
     */
    public static String checkBook(String title, String user) {
        StringBuilder info = new StringBuilder();
        for (Book book : books) {
            if (book.getName().equals(title)) {
                info.append(book.toString());
            }
        }
        return info.toString();
    }

    /**
     * @param title
     * @param ID
     * @param user
     * @return -2 - something went wrong with book taking; -1 - library doesnt have this book; 0 - all books are taken; 1 - book was taken.
     */

    public static int takeBook(String title, int ID, String user) {
        int counter = 0;
        for (Book book : books) {
            if (book.getName().equals(title)) {
                if (!book.getTaken()) {
                    boolean success = book.setTaken(true, ID, user);
                    if (success) {
                        if (user.equals(librarian))
                            addToIDArray(librarians, ID, book);
                        else
                            addToIDArray(readers, ID, book);
                        return 1;
                    } else
                        return -2;
                } else {
                    ++counter;
                }
            }
        }
        if (counter > 0) {
            return 0;
        } else {
            return -1;
        }
    }


    /**
     * @param title
     * @param ID
     * @param user
     * @return true - book was returned, false - something went wrong.
     */

    public static boolean returnBook(String title, int ID, String user) {
        for (Book book : books) {
            if (book.getName().equals(title)) {
                if (book.getTaken()) {
                    if (!book.setTaken(false, -1, null))
                        break;
                    else {
                        if (user.equals(librarian))
                            removeFromIDArray(librarians, ID, book);
                        else
                            removeFromIDArray(readers, ID, book);
                        return true;
                    }
                }
            }
        }
        return false;
    }


    /**
     * @param list librarians or readers list depending on which user type is being checked
     * @param ID User ID
     * @param book book that is being added
     * @param <E> Librarian or Reader depending on which user type is being checked
     */
    static <E extends User> void addToIDArray(ArrayList<E> list, int ID, Book book) {
        for (E element : list) {
            if (ID == element.getID()) {
                element.addIDToArray(book);
            }
        }
    }

    static <E extends User> void removeFromIDArray(ArrayList<E> list, int ID, Book book) {
        for (E element : list) {
            if (ID == element.getID()) {
                element.removeIDFromArray(book);
            }
        }
    }
}
