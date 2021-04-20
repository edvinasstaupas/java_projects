package lt.staupasedvinas.User;

import static lt.staupasedvinas.User.IDCreator.createReaderID;

public class Reader extends User {

    /**
     * Class Reader is a children of Class User<br>
     * This class has fields:<br>
     *
     * @param name (from parent Class)<br>
     */

    public Reader(String name) {
        super(name);
    }

    @Override
    public String getType() {
        return "reader, whose ID is ";
    }

    @Override
    public int createID() {
        return createReaderID();
    }
}
