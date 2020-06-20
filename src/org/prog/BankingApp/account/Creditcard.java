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
    public void withdraw(int ammount) throws RuntimeException{
        throw new RuntimeException("Sie können kein Geld von Ihrer Kreditkarte abheben");
    }

    @Override
    public void transfer(int ammount, String iban) throws RuntimeException{
        if (getBalance() + getLimit() - ammount >= 0) {
            Transactions transaction = new Transactions(this.getOwnerID(), ammount, this.getIBAN(), iban);
            setBalance(getBalance() - ammount);
            overdrawn = checkOverdraw();
        } else {
            throw new RuntimeException("Sie haben nicht genug Geld auf dem Konto");
        }
    }

    private boolean checkOverdraw(){
        if(getBalance() < 0){
            return true;
        } else {
            return false;
        }
    }

    //Getter aller Variablen
    public boolean isOverdrawn() {
        return overdrawn;
    }
}
