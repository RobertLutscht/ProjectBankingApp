package org.prog.BankingApp.account;

import org.prog.BankingApp.account.Account;
import org.prog.BankingApp.database.Database;

public class FixedDepositAccount extends Account {

    public FixedDepositAccount(int ownerID, int term) {
        super(ownerID);
        this.setTerm(term);
        setKind(3);
        Database.data.updateAccount("kind", 3, getIBAN());
        Database.data.updateAccount("term", getTerm(), getIBAN());
    }

    public FixedDepositAccount(int ownerID, String iban, int accountId, String bic, int balance, int limit, int term){
        super(ownerID, iban,accountId, bic, balance, limit);
        setTerm(term);
        setKind(3);
    }

    @Override
    public void setLimit(int limit) throws RuntimeException {
        throw new RuntimeException("Sie haben kein Zugriff auf das Geld");
    }

    @Override
    public void withdraw(int ammount) throws RuntimeException {
        throw new RuntimeException("Sie haben kein Zugriff auf das Geld");
    }

    @Override
    public void transfer(int ammount, String iban) throws RuntimeException {
        throw new RuntimeException("Sie haben kein Zugriff auf das Geld");
    }

    @Override
    public void setInterestRate(double interestRate) throws RuntimeException {
        throw new RuntimeException("Der Zinsbetrag auf dem Konto ist fest");
    }
}
