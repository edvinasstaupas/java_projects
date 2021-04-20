package lt.staupasedvinas;

import java.io.*;

import static java.lang.System.exit;

public class binIO {

    static void readBin() {

        String inputFile = "res/binary.bin";
        String outputFile = "res/binary2.bin";


        try (InputStream inputStream = new FileInputStream(inputFile);
             OutputStream outputStream = new FileOutputStream(outputFile);) {

            int byteRead;

            while ((byteRead = inputStream.read()) != -1) {
                outputStream.write(byteRead);
            }

        } catch (IOException ex) {
            exit(-3);
        }
    }
}
