package org.prog.BankingApp.account;

import org.prog.BankingApp.Transactions;
import org.prog.BankingApp.account.Account;
import org.prog.BankingApp.database.Database;

public class Creditcard extends Account {

    private boolean overdrawn;

    //Konstruktor
    public Creditcard(int ownerID, int limit){
        super(ownerID);
        this.setLimit(limit);
        setKind(2);
        //Database.data.updateAccount("kind", 2, getIBAN());
        //Database.data.updateAccount("limit", getLimit(), getIBAN());
    }

    public Creditcard(int ownerID, String iban, int accountId, String bic, int balance, int limit){
        super(ownerID, iban,accountId, bic, balance, limit);
        setKind(2);
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
            Database.data.updateAccount("balance", getBalance(), this.getIBAN());
            Database.data.updateAccount("balance", Database.data.getBalance(iban) + ammount, iban);
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
