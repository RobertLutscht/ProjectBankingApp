package org.prog.BankingApp;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {


    private int ownerID;
    private final String bic;
    private final String iban;
    private int accountID;
    private int accountIDcounter = 1;

    private int balance;
    private boolean covered;
    private double interestRate;
    private int limit = 0;

    //Der Account Konstruktor
    public Account(String bic, String iban, int ownerID) {
        this.bic = bic;
        this.ownerID = ownerID;
        this.accountID = accountIDcounter;
        accountIDcounter++;
        //if(Numbers.ibancheck(iban)){
            this.iban = iban;
        //} else {
            System.out.println("Sie haben eine falsche IBAN eingegeben, versuchen Sie es erneut.");
        //}
        Database.data.addAccount(ownerID, iban, bic, balance, limit);
    }

    //Methode um Geld auf das Konto einzuzahlen
    public void deposit(int ammount) {
        Transactions transaction = new Transactions(ownerID, ammount, iban, "Wurde eingezahlt");
        balance += ammount;
    }

    //Methode um Geld vom Konto abzuheben
    public void withdraw(int ammount) {
        if (balance - ammount >= 0) {
            Transactions transaction = new Transactions(ownerID, ammount, "Von Konto abgehoben", iban);
            balance -= ammount;
            return;
        } else {
            System.out.println("Du hast nicht genug Geld auf deinem Konto");
            return;
        }
    }

    public void transfer(int ammount, String iban){
        if (balance - ammount >= 0) {
            Transactions transaction = new Transactions(ownerID, ammount, iban, this.iban);
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

    public String getBic() {
        return bic;
    }

    public String getIban() {
        return iban;
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
