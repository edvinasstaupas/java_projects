package sample;

import java.util.ArrayList;
import java.util.List;

public class Person {
    String name;
    int ID;
    List<Account> accountList;

    public Person(String personName, int personID) {
        name = personName;
        accountList = new ArrayList<>();
        ID = personID;
    }

    public List<Account> getAccounts() {
        return accountList;
    }

    public void openAccount() {
        Account account = Factory.createNewAccount();
        account.setHolderID(ID);
        accountList.add(account);
    }

    public int getID() {
        return ID;
    }
}
