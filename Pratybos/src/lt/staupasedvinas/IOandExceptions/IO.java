package lt.staupasedvinas.IOandExceptions;

import java.io.*;

import static java.lang.System.exit;

public class IO {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File("res/data.csv"));
            //fileInputStream.r;
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("res/data.csv"));
            //bufferedInputStream.read
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
            exit(-1);
        } catch (IOException ioException) {
            ioException.printStackTrace();
            exit(-2);
        }
    }
}
