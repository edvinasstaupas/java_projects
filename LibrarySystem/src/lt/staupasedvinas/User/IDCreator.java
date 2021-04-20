package lt.staupasedvinas.User;

public class IDCreator {
    private static int ID = 0;

    /**
     * @return librarianID
     */
    static synchronized int createLibrarianID() {
        return ID++;
    }

    /**
     * @return readerID
     */
    static synchronized int createReaderID() {
        return ID++;
    }


}