package lt.staupasedvinas.interfaces;

public class InterfaceStrings {
    public static String bookNotTaken = "The book has not been taken yet.";
    public static String bookIsTaken = "The book is currently taken.";
    public static String bookIsFreeToTake = "Book is free to taken.";
    public static String librarian = "librarian";
    public static String reader = "reader";
    public static String badInput = "Bad input!";
    public static String latestTitle;
    public static String anotherPassword = "Please enter different password.";
    public static String RCommands = """
            Here are all available commands:
            ? - print commands;
            0 - end program;
            1 - show all books in the register;
            2 - check if there is a book available for taking or reserving;
            3 - take a book you just checked from library;
            4 - take any book from library;
            5 - give back a borrowed book;
            6 - see your information;
            7 - log out.""";

    public static String LCommands = """
            Here are all available commands:
            ? - print commands;
            0 - end program;
            1 - show all books in the register;
            2 - add book to register;
            3 - check if there is a book available for taking or reserving;
            4 - take a book you just checked from library;
            5 - take any book from library;
            6 - give back a borrowed book;
            7 - see your information
            8 - log out.""";
}
