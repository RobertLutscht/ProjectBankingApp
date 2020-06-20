package org.prog.BankingApp.account;

import org.prog.BankingApp.database.Database;
import org.prog.BankingApp.Iban;
import org.prog.BankingApp.Transactions;
import org.prog.BankingApp.database.IdGetter;
import org.prog.BankingApp.util.CheckUtility;

public abstract class Account {


    private int ownerID;
    public static final String BIC = "EinsAchtZwiebel";
    private final String IBAN;
    private int accountID;


    private int balance;
    private double interestRate;
    private int limit = 0;

    //Der Account Konstruktor
    public Account(int ownerID) {
        this.ownerID = ownerID;
        this.accountID = IdGetter.getNextAccId();
        this.IBAN = Iban.convertKnrBlzToIBAN(accountID);
        Database.data.addAccount(ownerID, IBAN, accountID, BIC, balance, limit);
    }

    //Methode um Geld auf das Konto einzuzahlen
    public void deposit(int ammount) {
        Transactions transaction = new Transactions(ownerID, ammount, IBAN, "Wurde eingezahlt");
        balance += ammount;
        Database.data.updateAccount("balance", balance, this.IBAN);
    }

    //Methode um Geld vom Konto abzuheben
    public void withdraw(int ammount) {
        if (balance - ammount >= 0) {
            Transactions transaction = new Transactions(ownerID, ammount, "Von Konto abgehoben", IBAN);
            balance -= ammount;
            Database.data.updateAccount("balance", balance, this.IBAN);
        } else {
            System.out.println("Du hast nicht genug Geld auf deinem Konto");
        }
    }

    public void transfer(int ammount, String iban){
        if(CheckUtility.ibancheck(iban)) {

            if (balance - ammount >= 0) {
                Transactions transaction = new Transactions(ownerID, ammount, iban, this.IBAN);
                balance -= ammount;
                Database.data.updateAccount("balance", balance, this.IBAN);

            } else {
                System.out.println("Du hast nicht genug Geld auf deinem Konto");
            }

        } else {
            System.out.println("Fehlerhafte Iban");
        }
    }

    //getter für Variablen

    public String getIBAN() {
        return IBAN;
    }

    public int getBalance() {
        return balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public int getLimit() {
        return limit;
    }

    public int getAccountID() {
        return accountID;
    }

    //setter für Variablen

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }


    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

}
