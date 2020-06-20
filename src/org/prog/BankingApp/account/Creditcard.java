package org.prog.BankingApp.account;

import org.prog.BankingApp.Transactions;
import org.prog.BankingApp.account.Account;

public class Creditcard extends Account {

    private boolean overdrawn;

    //Konstruktor
    public Creditcard(int ownerID, int limit){
        super(ownerID);
        this.setLimit(limit);
    }

    @Override
    public void withdraw(int ammount) {
        System.out.println("Sie können nicht von Ihrer Kreditkarte Geld abheben.");
    }

    @Override
    public void transfer(int ammount, String iban) {
        if (getBalance() + getLimit() - ammount >= 0) {
            Transactions transaction = new Transactions(this.getOwnerID(), ammount, this.getIBAN(), iban);
            setBalance(getBalance() - ammount);
            return;
        } else {
            System.out.println("Du hast nicht genug Geld auf deinem Konto");
            return;
        }
    }

    //Getter aller Variablen
    public boolean isOverdrawn() {
        return overdrawn;
    }
}
