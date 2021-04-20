package lt.staupasedvinas.Methods;

import lt.staupasedvinas.User.Librarian;
import lt.staupasedvinas.User.Reader;
import lt.staupasedvinas.User.User;
import lt.staupasedvinas.User.UserFactory;

import java.util.ArrayList;

import static lt.staupasedvinas.Methods.Lists.*;
import static lt.staupasedvinas.Methods.MethodString.*;

public class InterfaceMethods {

    /**
     * @param list librarian or reader list depending on which user type is being checked
     * @param name name of the user
     * @param <E>  Librarian or Reader depending on which user type is being checked
     * @return null if User was not found, User if User was found
     */
    public static <E extends User> E findUsers(ArrayList<E> list, String name) {
        for (E element : list) {
            if (element.getName().equals(name)) {
                return element;
            }
        }
        return null;
    }


    /**
     * @param password needed only for librarian, otherwise doesn't matter
     * @param u        to determine if it is a librarian (enter "librarian") or a reader ("reader")
     * @param name User name
     * @return true if everything is okay, false if there is no such user or if password is wrong (only for librarian)
     */
    public static boolean logIn(String password, String u, String name) {
        if (u.equals(librarian)) {
            //librarian
            Librarian librarian = findUsers(librarians, name);
            if (librarian == null) {
                return false;
            }
            if (!checkPassword(librarian, password)) {
                return false;
            }
            return true;
        } else {
            //reader
            Reader reader = findUsers(readers, name);
            if (reader == null) {
                return false;
            }
            return true;
        }
    }

    /**
     * @param password needed only for librarian, otherwise doesn't matter
     * @param u        to determine if it is a librarian (enter "librarian") or a reader ("reader")
     * @param name User name
     * @return true if User was registered, false if there is a User with that name already
     */

    public static boolean register(String password, String u, String name) {
        if (u.equals(librarian)) {
            //librarian
            if (!checkUsersForName(librarians, librarian, name))
                return false;
            Librarian librarian = UserFactory.createDefaultLibrarian(name);
            librarian.setPassword(password);
            librarians.add(librarian);
        } else {
            //reader
            //librarian
            if (!checkUsersForName(readers, reader, name))
                return false;
            Reader reader = UserFactory.createDefaultReader(name);
            readers.add(reader);
        }
        return true;
    }

    /**
     * @param list either readers or librarians list<br>
     * @param user either readers or librarians identification String<br>
     * @param <E>  either Reader or Librarians<br>
     * @return name of user that is unique<br>
     */
    public static <E extends User> boolean checkUsersForName(ArrayList<E> list, String user, String name) {
        if (user.equals(librarian)) {
            Librarian u = UserFactory.createDefaultLibrarian(name);
            if (list.contains(u)) {
                return false;
            } else {
                return true;
            }
        } else {
            Reader u = UserFactory.createDefaultReader(name);
            if (list.contains(u)) {
                return false;
            } else {
                return true;
            }
        }
    }

    /**
     * @param librarian Librarian whose password is being checked
     * @param password  Librarian's password in String
     * @return returns true if password was correct, false if user wants to abandon login
     */
    public static boolean checkPassword(Librarian librarian, String password) {
        if (password.equals(librarian.getPassword()))
            return true;
        else
            return false;

    }

    /**
     * implement function that latestTitle becomes title!
     *
     * @return entered title
     */
    public static String getTitle() {
        return "";
    }
}
