package org.prog.BankingApp.account;

import org.prog.BankingApp.account.Account;

public class CheckingAccount extends Account {
    public CheckingAccount(int ownerID){
       super(ownerID);
    }

    @Override
    public void setLimit(int limit) {
        System.out.println("Das Limit ist 0€");
    }
}
