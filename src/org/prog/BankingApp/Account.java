package org.prog.BankingApp;

public abstract class Account {

    private String owner;
    private int ownerID;
    private int ownerIDcounter = 1;
    private final String BIC;
    private final String IBAN;

    private int balance;
    private boolean covered;
    private double interestRate;
    private int limit = 0;

    //Der Account Konstruktor
    public Account(String bic, String iban, String owner) {
        this.owner = owner;
        this.BIC = bic;
        ownerID = ownerIDcounter;
        ownerIDcounter++;
        //if(Numbers.ibancheck(iban)){
            this.IBAN = iban;
        //} else {
            System.out.println("Sie haben eine falsche IBAN eingegeben, versuchen Sie es erneut.");
        //}
        Database.data.addAccount(ownerID, IBAN, BIC, balance, limit);
    }

    //Methode um Geld auf das Konto einzuzahlen
    public void deposit(int ammount) {
        Transactions transaction = new Transactions(ownerID, ammount, IBAN, "Wurde eingezahlt");
        balance += ammount;
    }

    //Methode um Geld vom Konto abzuheben
    public void withdraw(int ammount) {
        if (balance - ammount >= 0) {
            Transactions transaction = new Transactions(ownerID, ammount, "Von Konto abgehoben", IBAN);
            balance -= ammount;
            return;
        } else {
            System.out.println("Du hast nicht genug Geld auf deinem Konto");
            return;
        }
    }

    public void transfer(int ammount, String iban){
        if (balance - ammount >= 0) {
            Transactions transaction = new Transactions(ownerID, ammount, iban, this.IBAN);
            balance -= ammount;
            return;
        } else {
            System.out.println("Du hast nicht genug Geld auf deinem Konto");
            return;
        }
    }

    //getter Methoden für alle Variablen
    public String getOwner() {
        return owner;
    }

    public String getBIC() {
        return BIC;
    }

    public String getIBAN() {
        return IBAN;
    }

    public int getBalance() {
        return balance;
    }

    public boolean isCovered() {
        return covered;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public int getOwnerIDcounter() {
        return ownerIDcounter;
    }

    public int getLimit() {
        return limit;
    }

    //Setter für das Limit
    public void setLimit(int limit) {
        this.limit = limit;
    }
}
