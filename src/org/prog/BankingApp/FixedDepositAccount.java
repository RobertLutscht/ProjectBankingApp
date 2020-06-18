package org.prog.BankingApp;

public class FixedDepositAccount extends Account{

    private int term;
    private final double interestRate;

    public FixedDepositAccount(String owner, String bic,String iban, int term, double interestRate){
        super(owner, bic, iban);
        this.term = term;
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(int ammount) {
        System.out.println("Sie haben kein Zugriff bis der Vertrag ausgelaufen ist.");
    }
}
