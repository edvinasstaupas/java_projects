package sample;

public class Factory {
    public static Account createNewAccount() {
        return new Account();
    }

    public static Person createNewPerson(String name) {
        return new Person(name, IDCreator.createID());
    }
}