package lt.staupasedvinas.interfaces;

import lt.staupasedvinas.user.Librarian;
import lt.staupasedvinas.user.Reader;
import lt.staupasedvinas.user.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import static lt.staupasedvinas.book.BookMethods.*;
import static lt.staupasedvinas.interfaces.InterfaceStrings.*;
import static lt.staupasedvinas.Main.*;

public class InterfaceMethods {
    public static Scanner scanner = new Scanner(System.in);

    public static void chooseInterface() {
        String greeting = "Welcome to MIF library.";

        printLine(greeting);
        while (true) {
            String inputGreeting = "Please choose if you want to log in (1) or register (2). If you want to exit program, enter (0): ";
            printString(inputGreeting);
            switch (getCommands()) {
                case '0':
                    System.exit(0);
                    break;
                case '1':
                    logIn();
                    break;
                case '2':
                    register();
                    break;
                case '-':
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

    public static String chooseUser() {
        while (true) {
            String inputGreeting = "Please choose if you are a librarian (1) or a reader (2), if you want to exit program, enter (0): ";
            printString(inputGreeting);
            switch (getCommands()) {
                case '0':
                    System.exit(0);
                    break;
                case '1':
                    return librarian;
                case '2':
                    return reader;
                case '-':
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

    public static <E extends User> E findUsers(ArrayList<E> list, String name) {
        for (E element : list) {
            if (element.getName().equals(name)) {
                return element;
            }
        }
        return null;
    }

    public static void logIn() {
        String u = chooseUser();
        String name = enterName();
        if (u.equals(librarian)) {
            //librarian
            Librarian librarian = new Librarian(name);
            librarian = findUsers(librarians, name);
            if (librarian == null) {
                printLine("User not found.");
                return;
            }
            if (!checkPassword(librarian)) {
                return;
            }
            printLine("Welcome, " + librarian.getName() + "!");
            //latestLibrarian = librarian;
            librarian.userInterface();
        } else {
            //reader
            Reader reader = new Reader(name);
            reader = findUsers(readers, name);
            if (reader == null) {
                printLine("User not found.");
                return;
            }
            printLine("Welcome, " + reader.getName() + "!");
            //latestReader = reader;
            reader.userInterface();
        }
    }

    public static void register() {
        String user = chooseUser();
        String name;
        if (user.equals(librarian)) {
            //librarian
            name = checkUsersGetName(librarians, librarian);
            Librarian librarian = new Librarian(name);
            printString("Please enter your password: ");
            librarian.setPassword(scanner.nextLine());
            librarians.add(librarian);
        } else {
            //reader
            name = checkUsersGetName(readers, reader);
            Reader reader = new Reader(name);
            readers.add(reader);
        }
    }

    /**
     * @param list either readers or librarians list<br>
     * @param user either readers or librarians identification String<br>
     * @param <E>  either Reader or Librarians<br>
     * @return name of user that is unique<br>
     */
    public static <E extends User> String checkUsersGetName(ArrayList<E> list, String user) {
        printString("Please enter your name: ");
        String name;
        while (true) {
            name = scanner.nextLine();
            if (user.equals(librarian)) {
                Librarian u = new Librarian(name);
                if (list.contains(u)) {
                    printString("There is a user with this name. Please enter a different name: ");
                } else {
                    break;
                }
            } else {
                Reader u = new Reader(name);
                if (list.contains(u)) {
                    printString("There is a user with this name. Please enter a different name: ");
                } else {
                    break;
                }
            }

        }
        return name;
    }

    /**
     * @return password as a String
     */
    public static String enterPassword() {
        String password;
        while (true) {
            printString("Please enter your password: ");
            password = scanner.nextLine();
            if (password.equals("0"))
                printLine(anotherPassword);
            else
                break;
        }
        return password;
    }

    /**
     * @param librarian gives user
     * @return returns true if password was correct, false if user wants to abandon login
     */
    public static boolean checkPassword(Librarian librarian) {
        while (true) {
            String password = enterPassword();
            if (password.equals(librarian.getPassword())) {
                return true;
            } else if (password.equals("0")) {
                return false;
            }
        }
    }

    /**
     * @return entered title
     */
    public static String getTitle() {
        printString("Please enter the title of the book:");
        String title = scanner.nextLine();
        InterfaceStrings.latestTitle = title;
        return title;
    }

    /**
     * @return entered name
     */
    public static String enterName() {
        printString("Please enter your name:");
        String name = scanner.nextLine();
        return name;
    }

    /**
     * @return entered char that represents command
     */
    public static char getCommands() {
        String input = scanner.nextLine();
        char command;
        if (input.length() > 1)
            command = '*';
        else if (input.length() == 0)
            command = '-';
        else
            command = input.charAt(0);
        return command;
    }

    public static void librarianInterface(Librarian l) {
        printLine(l.printCommands());
        while (true) {
            String inputChoose = "Please enter command: ";
            printString(inputChoose);
            switch (getCommands()) {
                case '?':
                    printLine(l.printCommands());
                    break;
                case '0':
                    System.exit(0);
                    break;
                case '1':
                    showBooks(librarian);
                    break;
                case '2':
                    addBook();
                    break;
                case '3':
                    checkBook(getTitle(), librarian);
                    break;
                case '4':
                    takeBook(latestTitle, l.getID(), librarian);
                    break;
                case '5':
                    takeBook(null, l.getID(), librarian);
                    break;
                case '6':
                    returnBook(l.getID(), librarian);
                    break;
                case '7':
                    printLine(l.getUserInfo());
                    break;
                case '8':
                    return;
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

    public static void readerInterface(Reader r) {
        printLine(r.printCommands());
        while (true) {
            String inputChoose = "Please enter command: ";
            printString(inputChoose);
            switch (getCommands()) {
                case '?':
                    printLine(r.printCommands());
                    break;
                case '0':
                    System.exit(0);
                    break;
                case '1':
                    showBooks(reader);
                    break;
                case '2':
                    checkBook(getTitle(), reader);
                    break;
                case '3':
                    takeBook(latestTitle, r.getID(), reader);
                    break;
                case '4':
                    takeBook(null, r.getID(), reader);
                    break;
                case '5':
                    returnBook(r.getID(), reader);
                    break;
                case '6':
                    printString(r.getUserInfo());
                    break;
                case '7':
                    return;
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


    /**
     * method for easier print a line
     */
    public static void printLine(String string) {
        System.out.println(string);
    }

    /**
     * method for easier print a string
     */
    public static void printString(String string) {
        System.out.print(string);
    }
}
