package lt.staupasedvinas;

import static lt.staupasedvinas.InterfaceMethods.*;
import static lt.staupasedvinas.Main.*;

public class BookMethods {


    public static void showBooks() {
        if (books.size() == 0) {
            printLine("There are no books in the collection.");
        }
        for (Book book : books) {
            printString("\"" + book.getName() + "\" by " + book.getAuthor() + " written in " + book.getYear() + ". Status = ");
            if (book.getState()) {
                printLine("taken.");
            } else {
                printLine("in library.");
            }
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

    public static void checkBook(String title) {
        int counter = 0;
        for (Book book : books) {
            if (book.getName().equals(title)) {
                ++counter;
                printString("\"" + book.getName() + "\" by " + book.getAuthor() + " written in " + book.getYear() + ". Status = ");
                if (book.getState()) {
                    printLine("taken.");
                } else {
                    printLine("in library.");
                }
            }
        }
        if (counter == 0) {
            printLine("We are sorry, but we do not have " + title + " in our collection.");
        }
    }

    public static void takeBook(String title) {
        if (title == null) {
            title = getTitle();
        }
        int counter = 0;
        for (Book book : books) {
            if (book.getName().equals(title)) {
                if (!book.getState()) {
                    printLine("Here you go. \"" + title + "\" by " + book.getAuthor() + ". We wish you a good read!");
                    book.setState(true);
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

    public static void returnBook() {
        String title = getTitle();
        for (Book book : books) {
            if (book.getName().equals(title)) {
                if (book.getState()) {
                    printLine("We hope you liked the book. Please choose another book to read.");
                    book.setState(false);
                    return;
                }
            }
        }
        printLine("Your book was not returned. Please contact librarian for further information.");
    }
}
