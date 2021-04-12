package sample;

import java.io.File;
import java.util.Scanner;

public class CSVUser {
    public void readCSV() throws Exception {
        Scanner scanner = new Scanner(new File("data.csv"));
        scanner.useDelimiter(",");
        while(scanner.hasNext()){
            System.out.println(scanner.next());
        }
        scanner.close();
    }
}
