package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();


    }


    public static void main(String[] args) throws FileNotFoundException {
        /*Person person = Factory.createNewPerson("Edvinas");
        System.out.println(person.getID());
        List<Account> list = person.getAccounts();
        for (int i = 0; i < 2; i++) {
            if (list.size() == 0) {
                System.out.println("No accounts");
            }
            for (Account account : list) {
                System.out.println(account.getAccountNumber() + " " + account.getBalance());
            }
            System.out.println();
            person.openAccount();
        }*/
        //CSVUser reader = new CSVUser();
        //reader.readCSV();


        String line = "";
        String splitBy = ",";
        try {
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader("src/sample/data.csv"));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] account = line.split(splitBy);    // use comma as separator
                System.out.println(account[0] + " " + account[1]  + " " + account[2]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //launch(args);
    }
}

