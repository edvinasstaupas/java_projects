package lt.staupasedvinas;

import java.io.*;
import java.util.List;

public class binIO {

    static String file = "res/binary.bin";

    public static void writeBinary(List<Book> list) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream((file)))) {
            objectOutputStream.writeObject(list);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static List<Book> readBinary() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream((file)))) {
            return (List<Book>) objectInputStream.readObject();
        } catch (ClassNotFoundException | IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        return null;
    }
}