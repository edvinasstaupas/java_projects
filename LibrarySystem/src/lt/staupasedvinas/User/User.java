package lt.staupasedvinas.User;

import lt.staupasedvinas.Book.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class User {

    /**
     * User Class is an abstract class that has two children classes (Librarian and Reader)<br>
     * class has fields: (it doesnt let me have paraml, smh)<br>
     * name which is name of the user (kind of like a username, because it has to be unique)<br>
     * borrowedBooks is a list, that stores Book objects
     */

    public final String name;
    private final int ID = createID();
    List<Book> borrowedBooks = new ArrayList<>();


    public User(String name) {
        this.name = name;
    }

    abstract int createID();

    /**
     * @return what kind of type is User (returns String)
     */
    abstract String getType();

    /**
     * @return int that is User's ID
     */
    public int getID() {
        return this.ID;
    }

    /**
     * @return User's name (String)
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return information about user as a String
     */
    public String toString() {
        StringBuilder info = new StringBuilder(getName() + " - " + getType() + getID());
        if (borrowedBooks.size() == 0)
            info.append(". You do not have any borrowed books.");
        else {
            info.append(". Your borrowed books are:");
            for (Book borrowedBook : borrowedBooks) {
                info.append("\n").append(borrowedBook.toString());
            }
        }
        return info.toString();
    }

    /**
     * @param book book that is added to borrowedBooks list
     */
    public void addIDToArray(Book book) {
        borrowedBooks.add(book);
    }

    /**
     * @param book book that is removed from borrowedBooks list
     */
    public void removeIDFromArray(Book book) {
        borrowedBooks.remove(book);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getID() == user.getID() && getName().equals(user.getName()) && borrowedBooks.equals(user.borrowedBooks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getID(), borrowedBooks);
    }
}
