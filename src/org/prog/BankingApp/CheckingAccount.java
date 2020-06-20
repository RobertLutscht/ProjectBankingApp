package org.prog.BankingApp;

public class CheckingAccount extends Account{
    public CheckingAccount(int ownerID, String bic){
       super(bic, ownerID);
    }

    @Override
    public void setLimit(int limit) {
        System.out.println("Das Limit ist 0€");
    }
}
