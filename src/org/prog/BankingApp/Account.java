package org.prog.BankingApp;

import javax.naming.event.ObjectChangeListener;
import java.util.ArrayList;
import java.util.List;

public class Account {

    private int owner;
    private String bic;
    private String iban;

    private int balance;
    private boolean covered;
    private List<Transactions> transactions = new ArrayList<Transactions>();

    //ein Default und ein spezifischer Konstruktor
    public Account() {
    }

    public Account(int owner, String bic, String iban) {
        this.owner = owner;
        this.bic = bic;
        this.iban = iban;
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

    //getter Methoden für alle Variablen
    public int getOwner() {
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

    public void getList(){
        for(Transactions transaction: transactions){
            System.out.println(transaction);

        }
    }
}
