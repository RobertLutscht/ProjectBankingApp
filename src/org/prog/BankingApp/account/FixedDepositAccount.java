package org.prog.BankingApp.account;

import org.prog.BankingApp.account.Account;

public class FixedDepositAccount extends Account {

    private int term;

    public FixedDepositAccount(int ownerID, int term){
        super(ownerID);
        this.term = term;
    }

    @Override
    public void setLimit(int limit) throws RuntimeException{
        throw new RuntimeException("Sie haben kein Zugriff auf das Geld");
    }

    @Override
    public void withdraw(int ammount) throws RuntimeException{
        throw new RuntimeException("Sie haben kein Zugriff auf das Geld");
    }

    @Override
    public void transfer(int ammount, String iban) throws RuntimeException{
        throw new RuntimeException("Sie haben kein Zugriff auf das Geld");
    }

    @Override
    public void setInterestRate(double interestRate) throws RuntimeException{
        throw new RuntimeException("Der Zinsbetrag auf dem Konto ist fest");
    }
}
