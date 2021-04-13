package lt.staupasedvinas;

import java.io.*;
import java.util.*;

import static java.lang.System.exit;

public class Main {

    static String[][][] bookInfo = new String[2][6][];

    public static void main(String[] args) throws IOException {
        //method
        //method

        getInfo("res/data.csv", 0);
        getInfo("res/add.csv", 1);

        //Scanner scanner = new Scanner(System.in);
        String[] newBook = {"\"Lord of the Ring. Two towers", "R. R. Tolkien", "1997\""};
        //bookInfo[infoLength] = newBook;
        //infoLength++;


        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("res/data.csv"));
        for(int i = 0; i < bookInfo[0].length; i++) {
            for(int j = 0; j < 3; j++) {
                bufferedWriter.write(bookInfo[0][i][j]);
                bufferedWriter.write(",");
            }
            bufferedWriter.write("\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();


    }

    public static void getInfo (String fileName, int i) {
        String line;
        String splitBy = ",";
        int infoLength = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            try {
                while ((line = bufferedReader.readLine()) != null) {
                    bookInfo[i][infoLength] = line.split(splitBy);
                    System.out.println(bookInfo[i][infoLength][0] + " " + bookInfo[i][infoLength][1] + " " + bookInfo[i][infoLength][2]);
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
    }
}
