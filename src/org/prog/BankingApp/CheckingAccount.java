package org.prog.BankingApp;

public class CheckingAccount extends Account{
    public CheckingAccount(String owner, String bic,String iban){
       super(owner, bic, iban);
    }

    @Override
    public void setLimit(int limit) {
        System.out.println("Das Limit ist 0€");
    }
}
