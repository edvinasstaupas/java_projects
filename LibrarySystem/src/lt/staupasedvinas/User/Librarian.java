package lt.staupasedvinas.User;

import static lt.staupasedvinas.User.IDCreator.createLibrarianID;

public class Librarian extends User {

    /**
     * Class Librarian is a children of Class User<br>
     * This class has fields:<br>
     * name (from parent Class)<br>
     * password<br>
     */

    private String password;

    public Librarian(String name) {
        super(name);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    @Override
    public String getType() {
        return "librarian, whose ID is ";
    }

    @Override
    public int createID() {
        return createLibrarianID();
    }
}
