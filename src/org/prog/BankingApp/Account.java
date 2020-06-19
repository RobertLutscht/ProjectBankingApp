package org.prog.BankingApp;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {

    private String owner;
    private final String BIC;
    private final String IBAN;

    private int balance;
    private boolean covered;
    private double interestRate;
    private List<Transactions> transactions = new ArrayList<Transactions>();

    //Der Account Konstruktor
    public Account(String BIC, String IBAN, String owner) {
        this.owner = owner;
        this.BIC = BIC;
        if(Numbers.ibancheck(IBAN)){
            this.IBAN = IBAN;
        } else {
            System.out.println("Sie haben eine falsche IBAN eingegeben, versuchen Sie es erneut.");
        }
    }

    //Methode um Geld auf das Konto einzuzahlen
    public void deposit(int ammount) {
        Transactions transaction = new Transactions(ammount, "Auf Konto eingezahlt");
        balance += ammount;
        transactions.add(transaction);
    }

    //Methode um Geld vom Konto abzuheben
    public void withdraw(int ammount) {
        if (balance - ammount >= 0) {
            Transactions transaction = new Transactions(ammount, "Von Konto abgehoben");
            balance -= ammount;
            transactions.add(transaction);
            return;
        } else {
            System.out.println("Du hast nicht genug Geld auf deinem Konto");
            return;
        }
    }

    public void transfer(int ammount, Account name){
        if (balance - ammount >= 0) {
            Transactions transaction = new Transactions(ammount, "An " + name.owner + " überwiesen.");
            balance -= ammount;
            transactions.add(transaction);
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

    public void getList(){
        for(Transactions transaction: transactions){
            System.out.println(transaction);
        }
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setList(Transactions transaction){
        this.transactions.add(transaction);
    }
}
