package lt.staupasedvinas.interfaces;

public class IDCreator {
    static int readerIDCounter = 0;
    static int librarianIDCounter = 0;

    /**
     * @return librarianID
     */
    public static synchronized int createLibrarianID() {
        return librarianIDCounter++;
    }

    /**
     * @return readerID
     */
    public static synchronized int createReaderID() {
        return readerIDCounter++;
    }
}
