package org.prog.BankingApp;

import org.prog.BankingApp.Account;

public class Creditcard extends Account {

    private boolean overdrawn;
    private int limit;

    //Konstruktor
    public Creditcard(int limit){
        this.limit = limit;
    }

    //Setter für das Limit
    public void setLimit(int limit) {
        this.limit = limit;
    }

    //Getter aller Variablen
    public boolean isOverdrawn() {
        return overdrawn;
    }

    public int getLimit() {
        return limit;
    }
}
