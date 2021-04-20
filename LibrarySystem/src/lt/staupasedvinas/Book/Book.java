package lt.staupasedvinas.Book;

import java.util.Objects;

import static lt.staupasedvinas.Methods.MethodString.librarian;

public class Book {

    private final String title;
    private final String author;
    private final int publishYear;
    private boolean isTaken;
    private int takerID;
    private boolean isTakenByLibrarian;

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

    public boolean getTaken() {
        return this.isTaken;
    }

    public int getTakerID() {
        return this.takerID;
    }

    /**
     * @param state taken - true, not taken - false
     * @param ID    if book is being taken, then method gets taker's ID, if it is being returned, method gets -1
     * @param user  string to determine if it is a librarian or a reader. Gets null if book is being returned to keep the last user's info
     * @return true if everything is okay, false if user != null and String user is not equal to InterfaceStrings.librarian or InterfaceStrings.reader (but that shouldn't happen)
     */
    public boolean setTaken(boolean state, int ID, String user) {
        if (user == null) {
        } else if (user.equals("librarian")) {
            this.isTakenByLibrarian = true;
        } else if (user.equals("reader")) {
            this.isTakenByLibrarian = false;
        } else {
            return false;
        }
        this.isTaken = state;
        if (ID != -1)
            this.takerID = ID;
        return true;
    }

    /**
     *
     * @return string which user has taken the book (librarian or reader)
     */
    public String getTakerType() {
        if (this.isTakenByLibrarian)
            return "librarian";
        else
            return "reader";
    }

    /**
     *
     * @return full book info in String format
     */

    public String toString(String u) {
        String info = "\"" + this.title + "\" by " + this.author + ", published in " + this.publishYear;
        if(u.equals(librarian)) {
            info += ". This book is ";
            if (getTaken()) {
                info += "taken by " + this.getTakerType() + ", whose ID is " + getTakerID();
            }
            else
                info += "not taken";
        }
        return info + ".\n";
    }

    /** @deprecated
     *
     * @return string that is book's info
     */
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
