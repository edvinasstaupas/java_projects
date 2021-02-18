package lt.staupasedvinas;

import static lt.staupasedvinas.Main.*;

public class InterfaceMethods {

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
