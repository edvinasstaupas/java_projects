package lt.staupasedvinas;

import java.io.*;

import static java.lang.System.exit;

public class IO {

    static String[][][] bookInfo = new String[2][100][];
    static int bookInfoLength = 0;
    static int bookInfoAdditionLength = 0;

    static void readCSV() {

        bookInfoLength = getInfo("res/data.csv", 0);

        bookInfoAdditionLength = getInfo("res/add.csv", 1);

        addInfo();

        setInfo("res/data.csv");

        deleteAddition("res/add.csv");

    }

    public static int getInfo(String fileName, int i) {
        String line;
        String splitBy = ",";
        int infoLength = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            try {
                while ((line = bufferedReader.readLine()) != null) {
                    bookInfo[i][infoLength] = line.split(splitBy);
                    //System.out.println(bookInfo[i][infoLength][0] + " " + bookInfo[i][infoLength][1] + " " + bookInfo[i][infoLength][2]);
                    infoLength++;
                }
            } catch (NullPointerException nullPointerException) {
                exit(-2);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("RIP");
            exit(-1);
        }
        return infoLength;
    }


    public static void setInfo(String fileName) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(fileName));
            for (int i = 0; i < bookInfoLength; i++) {
                for (int j = 0; j < 3; j++) {
                    bufferedWriter.write(bookInfo[0][i][j]);
                    bufferedWriter.write(",");
                }
                bufferedWriter.write("\n");
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException ioException) {
            System.out.println("RIP");
            exit(-2);
        }
    }

    public static void addInfo() {
        for (int i = 1; i < bookInfoAdditionLength; i++) {
            bookInfo[0][bookInfoLength++] = bookInfo[1][i];
        }
    }


    public static void deleteAddition(String fileName) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(fileName));
            for (int i = 0; i < bookInfo[0][0].length; i++) {
                bufferedWriter.write(bookInfo[0][0][i]);
                bufferedWriter.write(",");
            }
            bufferedWriter.write("\n");
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException ioException) {
            System.out.println("RIP");
            exit(-3);
        }
    }
}
