package org.prog.BankingApp;

import org.prog.BankingApp.database.Database;

import java.util.Date;

public class Transactions {
    private String date;;
    private int ammount;
    private String toIban;
    private String fromIban;
    private int transactionID;
    private int countingID = 1;

    public Transactions(int userID, int ammount, String destination, String fromIban){
        Date date = new Date();
        this.date = date.toString();
        this.ammount = ammount;
        this.toIban = destination;
        this.fromIban = fromIban;
        this.transactionID = countingID;
        countingID++;
        Database.data.addTransaction(userID, transactionID, this.fromIban, toIban, this.date, this.ammount);
    }

    public String getDate() {
        return date;
    }

    public int getAmmount() {
        return ammount;
    }

    public String gettoIban() {
        return toIban;
    }

    public String getFromIban() {
        return fromIban;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public int getCountingID() {
        return countingID;
    }
}
