package org.prog.BankingApp;

import java.util.Date;

public class Transactions {
    private String date;;
    private int ammount;
    private String destination;

    public Transactions(int ammount, String destination){
        Date date = new Date();
        this.date = date.toString();
        this.ammount = ammount;
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public int getAmmount() {
        return ammount;
    }

    public String getDestination() {
        return destination;
    }
}
