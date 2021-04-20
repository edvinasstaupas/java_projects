package lt.staupasedvinas.book;

import lt.staupasedvinas.user.User;

import java.util.ArrayList;
import java.util.HashSet;

import static lt.staupasedvinas.interfaces.InterfaceMethods.*;
import static lt.staupasedvinas.Main.*;
import static lt.staupasedvinas.interfaces.InterfaceStrings.*;
import static lt.staupasedvinas.interfaces.InterfaceStrings.bookNotTaken;

public class BookMethods {

    public static void showBooks(String user) {
        if (books.size() == 0) {
            printLine("There are no books in the collection.");
        }
        for (Book book : books) {
            showBookInfo(book, user);
        }
    }

    public static void getBorrowID(Book book, String user) {
        if(user.equals(librarian)) {
            if (book.getState())
                printLine("The book is currently taken by: " + book.getGroup() + " " + book.getTakenID() + ".");
            else if (!book.getState() && book.getTakenID() != 0)
                printLine("The book was last taken by: " + book.getGroup() + " " + book.getTakenID() + ".");
            else
                printLine(bookNotTaken);
        } else {
            if (book.getState())
                printLine(bookIsTaken);
            else if (!book.getState() && book.getTakenID() != 0)
                printLine(bookIsFreeToTake);
            else
                printLine(bookNotTaken);
        }
    }

    public static void addBook() {
        printLine("Enter book's title:");
        String title = scanner.nextLine();
        printLine("Enter book's author:");
        String author = scanner.nextLine();

        int publishYear = 0;
        boolean goodYear = false;
        while (!goodYear) {
            printLine("Enter book's year of publish:");
            String publishYearString = scanner.nextLine();
            if (publishYearString.matches("[0-9]+") && publishYearString.length() == 4) {
                publishYear = Integer.parseInt(publishYearString);
                goodYear = true;
            } else {
                printString(badInput);
            }
        }
        Book oneBook = new Book(title, author, publishYear);
        books.add(oneBook);
    }

    public static void showBookInfo(Book book, String user) {
        printString("\"" + book.getName() + "\" by " + book.getAuthor() + " written in " + book.getYear() + ". ");        getBorrowID(book, user);
    }

    public static void checkBook(String title, String user) {
        int counter = 0;
        for (Book book : books) {
            if (book.getName().equals(title)) {
                ++counter;
                showBookInfo(book, user);
            }
        }
        if (counter == 0) {
            printLine("We are sorry, but we do not have " + title + " in our collection.");
        }
    }

    public static void takeBook(String title, int ID, String user) {
        if (title == null) {
            title = getTitle();
        }
        int counter = 0;
        for (Book book : books) {
            if (book.getName().equals(title)) {
                if (!book.getState()) {
                    boolean success = book.setState(true, ID, user);
                    if (success) {
                        printLine("Here you go. \"" + title + "\" by " + book.getAuthor() + ". We wish you a good read!");
                        if (user.equals(librarian))
                            addToIDArray(librarians, ID, book);
                        else
                            addToIDArray(readers, ID, book);
                        return;
                    } else
                        printLine("Something is wrong, the book was not taken. Please contact any librarian.");
                    return;
                } else {
                    ++counter;
                }
            }
        }
        if (counter > 0) {
            printLine("We are sorry, but at the moment all \"" + title + "\" books are taken.");
        } else {
            printLine("We are sorry, but we do not have \"" + title + "\" in our collection.");
        }
    }

    public static void returnBook(int ID, String user) {
        String title = getTitle();
        for (Book book : books) {
            if (book.getName().equals(title)) {
                if (book.getState()) {
                    if (!book.setState(false, -1, null))
                        break;
                    else {
                        printLine("We hope you liked the book. Please choose another book to read.");
                        if (user.equals(librarian))
                            removeFromIDArray(librarians, ID, book);
                        else
                            removeFromIDArray(readers, ID, book);
                        return;
                    }
                }
            }
        }
        printLine("Your book was not returned. Please contact librarian for further information.");
    }

    public static <E extends User> void addToIDArray(ArrayList<E> list, int ID, Book book) {
        for (E element : list) {
            if (ID == element.getID()) {
                element.addIDToArray(book);
            }
        }
    }

    public static <E extends User> void removeFromIDArray(ArrayList<E> list, int ID, Book book) {
        for (E element : list) {
            if (ID == element.getID()) {
                element.removeIDFromArray(book);
            }
        }
    }
}
