package lt.staupasedvinas;

import java.util.List;

public class Main {

    public static void main(String[] args) throws BadInputException {
        List<Book> list = IO.readAndCreateObjects();
        for(Book book: list) {
            System.out.println(book.toString());
        }
        binIO.writeBinary(list);
        list = binIO.readBinary();
        assert list != null;
        for(Book book: list) {
            System.out.println(book.toString());
        }
    }
}
