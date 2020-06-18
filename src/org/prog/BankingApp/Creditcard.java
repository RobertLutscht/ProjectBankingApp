package org.prog.BankingApp;

public class Creditcard extends Account {

    private boolean overdrawn;
    private int limit;

    //Konstruktor
    public Creditcard(String owner, int limit){
        this.owner = owner;
        this.limit = limit;
        this.bic =;
        this.iban =;
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
