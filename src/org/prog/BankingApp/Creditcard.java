package org.prog.BankingApp;

public class Creditcard extends Account {

    private boolean overdrawn;
    private int limit;

    //Konstruktor
    public Creditcard(String owner, int limit, String bic,String iban){
        this.owner = owner;
        this.limit = limit;
        this.bic = bic;
        if(Numbers.ibancheck(iban)){
            this.iban = iban;
        } else {
            System.out.println("Sie haben eine falsche IBAN eingegeben, versuchen Sie es erneut.");
        }
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
