package sample;

import java.util.Random;

public class Account {
    public String accountNumber;
    private int holderID;
    public float balance;
    public Account() {
        Random random = new Random();
        accountNumber = "LT";
        int num = random.nextInt(10);
        accountNumber += num;
        num = random.nextInt(10);
        accountNumber += num;
        for(int i = 0; i < 3; i++) {
            accountNumber += " ";
            for(int j = 0; j < 4; j++) {
                num = random.nextInt(10);
                accountNumber += num;
            }
        }
        balance = 0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setHolderID(int ID) {
        holderID = ID;
    }

    public int getHolderID () {
        return holderID;
    }

    public float getBalance() {
        return balance;
    }

}
