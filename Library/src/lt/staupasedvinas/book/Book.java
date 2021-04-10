package lt.staupasedvinas.book;

import lt.staupasedvinas.interfaces.InterfaceStrings;

import java.util.Objects;

import static lt.staupasedvinas.interfaces.InterfaceStrings.*;

public class Book {

    private final String title;
    private final String author;
    private final int publishYear;
    private boolean taken;
    private int takenID;
    private boolean takenByLibrarian;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.publishYear = year;
    }

    public String getName() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getYear() {
        return this.publishYear;
    }

    public boolean getState() {
        return this.taken;
    }

    public int getTakenID() {
        return this.takenID;
    }
    /**
     * @param state if the book is taken or not
     * @param ID    if book is being taken, then method gets taker's ID, if it is being returned, method gets -1
     * @param user  string to determine if it is a librarian or a reader. Gets null if book is being returned to keep the last user's info
     * @return true if everything is okay, false if user != null and String user is not equal to InterfaceStrings.librarian or InterfaceStrings.reader (but that shouldn't happen)
     */
    public boolean setState(boolean state, int ID, String user) {
        if (user == null) {
        } else if (user.equals(librarian)) {
            this.takenByLibrarian = true;
        } else if (user.equals(reader)) {
            this.takenByLibrarian = false;
        } else {
            return false;
        }
        this.taken = state;
        if (ID != -1)
            this.takenID = ID;
        return true;
    }

    public String getGroup() {
        if (this.takenByLibrarian)
            return librarian;
        else
            return reader;
    }

    public String getBookInfo() {
        return "\"" + this.title + "\" by " + this.author + ", published in " + this.publishYear + ";";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return publishYear == book.publishYear && title.equals(book.title) && getAuthor().equals(book.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, getAuthor(), publishYear);
    }
}
