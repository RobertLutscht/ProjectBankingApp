package org.prog.BankingApp.account;

import org.prog.BankingApp.account.Account;

public class FixedDepositAccount extends Account {

    private int term;

    public FixedDepositAccount(int ownerID, int term){
        super(ownerID);
        this.term = term;
    }

    @Override
    public void setLimit(int limit) {
        System.out.println("Sie haben kein Zugriff auf Ihr Geld");
    }

    @Override
    public void withdraw(int ammount) {
        System.out.println("Sie haben kein Zugriff bis der Vertrag ausgelaufen ist.");
    }

    @Override
    public void transfer(int ammount, String iban) {
        System.out.println("Sie haben kein Zugriff bis der Vertrag ausgelaufen ist.");
    }

    @Override
    public void setInterestRate(double interestRate) {
        System.out.println("Der Zinsbetrag auf diesem Konto ist fest.");
    }
}
