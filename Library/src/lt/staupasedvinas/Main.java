package lt.staupasedvinas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static String latestTitle;
    static List<Book> books = new ArrayList<>();
    static String badInput = "Bad input!";
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String greeting = "Welcome to MIF library.";

        printLine(greeting);

        String inputGreeting = "Please choose if you are a librarian (0) or a reader (1): ";
        printString(inputGreeting);
        while (true) {
            switch (getCommands()) {
                case '0':
                    librarianInterface();
                    break;
                case '1':
                    readerInterface();
                    break;
                case 'e':
                    break;
                case '*':
                    printLine(badInput);
                    break;
                default:
                    printLine(badInput);
                    break;
            }
        }


    }

    public static void librarianInterface() {
        String password = "p";
        while (true) {
            String inputChoose = "Please enter password: ";
            printString(inputChoose);
            String passwordInput = scanner.nextLine();
            if (passwordInput.equals(password)) {
                printLine("Good day to you my fellow librarian!");
                break;
            } else {
                printLine("How dare you try to enter the forbidden world!");
            }
        }
        printLCommands();
        while (true) {
            String inputChoose = "Please enter command: ";
            printString(inputChoose);

            switch (getCommands()) {
                case '?':
                    printLCommands();
                    break;
                case '0':
                    System.exit(0);
                    break;
                case '1':
                    showBooks();
                    break;
                case '2':
                    addBook();
                    break;
                case '3':
                    checkBook(getTitle());
                    break;
                case '4':
                    takeBook(latestTitle);
                    break;
                case '5':
                    takeBook(null);
                    break;
                case '6':
                    returnBook();
                    break;
                case 'e':
                    break;
                case '*':
                    printLine(badInput);
                    break;
                default:
                    printLine(badInput);
                    break;
            }
        }
    }

    public static void readerInterface() {
        printRCommands();
        while (true) {
            String inputChoose = "Please enter command: ";
            printString(inputChoose);

            switch (getCommands()) {
                case '?':
                    printRCommands();
                    break;
                case '0':
                    System.exit(0);
                    break;
                case '1':
                    showBooks();
                    break;
                case '2':
                    checkBook(getTitle());
                    break;
                case '3':
                    takeBook(latestTitle);
                    break;
                case '4':
                    takeBook(null);
                    break;
                case '5':
                    returnBook();
                    break;
                case 'e':
                    break;
                case '*':
                    printLine(badInput);
                    break;
                default:
                    printLine(badInput);
                    break;
            }
        }
    }


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
        int counter = 0;
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

    public static String getTitle() {
        printString("Please enter the title of the book:");
        String title = scanner.nextLine();
        latestTitle = title;
        return title;
    }


    public static char getCommands() {
        String input = scanner.nextLine();
        char command;
        if (input.length() > 1)
            command = '*';
        else if (input.length() == 0)
            command = 'e';
        else
            command = input.charAt(0);
        return command;
    }

    public static void printLCommands() {
        String commands = """
                Here are all available commands:
                ? - print commands;
                0 - end program;
                1 - show all books in the register;
                2 - add book to register;
                3 - check if there is a book available for taking or reserving;
                4 - take a book you just checked from library;
                5 - take any book from library;
                6 - give back a borrowed book.""";
        System.out.println(commands);
    }

    public static void printRCommands() {
        String commands = """
                Here are all available commands:
                ? - print commands;
                0 - end program;
                1 - show all books in the register;
                2 - check if there is a book available for taking or reserving;
                3 - take a book you just checked from library;
                4 - take any book from library;
                5 - give back a borrowed book.""";
        System.out.println(commands);
    }

    public static void printLine(String string) {
        System.out.println(string);
    }

    public static void printString(String string) {
        System.out.print(string);
    }


}
