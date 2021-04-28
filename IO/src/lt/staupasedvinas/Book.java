package lt.staupasedvinas;

import java.io.Serializable;

public class Book implements Serializable {

    private final String title;
    private final String author;
    private final int publishYear;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.publishYear = year;
    }

    public String toString() {
        return title + author + publishYear;
    }

}
