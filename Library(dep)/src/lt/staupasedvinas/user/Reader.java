package lt.staupasedvinas.user;

import static lt.staupasedvinas.interfaces.IDCreator.createReaderID;
import static lt.staupasedvinas.interfaces.InterfaceMethods.*;
import static lt.staupasedvinas.interfaces.InterfaceStrings.*;

public class Reader extends User {

    /**
     * Class Reader is a children of Class User<br>
     * This class has fields:<br>
     * @param name (from parent Class)<br>
     *
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

    @Override
    public String printCommands() {
        return RCommands;
    }

    @Override
    public void userInterface() {
        readerInterface(this);
    }
}
