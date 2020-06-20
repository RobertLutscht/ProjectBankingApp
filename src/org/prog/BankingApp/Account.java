package org.prog.BankingApp;

public abstract class Account {


    private int ownerID;
    private final String BIC;
    private final String IBAN;
    private static int accountID;
    private int accountIDcounter = 1;


    private int balance;
    private boolean covered;
    private double interestRate;
    private int limit = 0;

    //Der Account Konstruktor
    public Account(String bic, int ownerID) {
        this.BIC = bic;
        this.ownerID = ownerID;
        this.accountID = accountIDcounter;
        accountIDcounter++;
        //if(Numbers.ibancheck(iban)){
            this.IBAN = Iban.convertKnrBlzToIBAN();;
        //} else {
            System.out.println("Sie haben eine falsche IBAN eingegeben, versuchen Sie es erneut.");
        //}
        Database.data.addAccount(ownerID, IBAN, bic, balance, limit);
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


    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getOwnerID() {
        return ownerID;
    }


    public static int getAccountID() {
        return accountID;
    }

    public int getAccountIDcounter() {
        return accountIDcounter;
    }

    public int getLimit() {
        return limit;
    }

    //Setter für das Limit
    public void setLimit(int limit) {
        this.limit = limit;
    }


    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;

    }
}
