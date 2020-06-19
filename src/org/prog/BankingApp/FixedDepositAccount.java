package org.prog.BankingApp;

public class FixedDepositAccount extends Account{

    private int term;

    public FixedDepositAccount(String owner, String bic,String iban, int term, double interestRate){
        super(owner, bic, iban);
        this.term = term;
    }

    @Override
    public void withdraw(int ammount) {
        System.out.println("Sie haben kein Zugriff bis der Vertrag ausgelaufen ist.");
    }

    @Override
    public void transfer(int ammount, Account name) {
        System.out.println("Sie haben kein Zugriff bis der Vertrag ausgelaufen ist.");
    }

    @Override
    public void setInterestRate(double interestRate) {
        System.out.println("Der Zinsbetrag auf diesem Konto ist fest.");
    }
}
