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
import java.util.List;

import static javafx.application.Platform.exit;
import static sample.IDCreator.createID;

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


        String line = "";
        String splitBy = ",";
        String[][] accountInfo = new String[100][];
        try {
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader("src/sample/data.csv"));
            int i = 0;
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                accountInfo[i] = line.split(splitBy);    // use comma as separator
                if(i != 0)
                    System.out.println(accountInfo[i][0] + " " + accountInfo[i][1]  + " " + accountInfo[i][2]);
                i++;
            }
        } catch (IOException e) {
            System.out.println("RIP");
            exit();
        }
        IDCreator.setID(accountInfo[0][0]);
        Person person = Factory.createNewPerson("Edvinas");
        System.out.println(person.getID());
        person.openAccount();
        List<Account> list = person.getAccounts();
        for (Account account : list) {
                System.out.println(account.getAccountNumber() + " " + account.getBalance());
            }
        System.out.println();
        //System.out.println(createID());
        //launch(args);
    }
}

