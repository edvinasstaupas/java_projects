package lt.staupasedvinas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static lt.staupasedvinas.BookMethods.*;
import static lt.staupasedvinas.InterfaceMethods.*;

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

        //noinspection InfiniteLoopStatement
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
}
