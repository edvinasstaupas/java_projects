package lt.staupasedvinas;

import java.util.List;

public class Book {
    private String title;
    private String author;
    private int publishYear;
    private boolean taken;

    public Book (String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.publishYear = year;
    }
    public void addBook(List books) {

    }

    public static void checkBook() {

    }

    public static void takeBook() {

    }

    public static void giveBackBook() {

    }

    public String getName() {
        return title;
    }

    public int getYear() {
        return publishYear;
    }

    public boolean getState() {
        return taken;
    }


    public void setState(boolean state) {
        taken = state;
    }

    public String getAuthor() {
        return author;
    }
}
