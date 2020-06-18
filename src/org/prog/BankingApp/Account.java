package org.prog.BankingApp;

import java.util.ArrayList;
import java.util.List;

public class Account {

    public String owner;
    public String bic;
    public String iban;

    private int balance;
    private boolean covered;
    private List<Transactions> transactions = new ArrayList<Transactions>();

    //ein Default Konstrukter
    public Account() { }

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

    public void getList(){
        for(Transactions transaction: transactions){
            System.out.println(transaction);
        }
    }
}
