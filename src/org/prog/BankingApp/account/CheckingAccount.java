package org.prog.BankingApp.account;

import org.prog.BankingApp.account.Account;
import org.prog.BankingApp.database.Database;

public class CheckingAccount extends Account {
    public CheckingAccount(int ownerID){
       super(ownerID);
       setKind(1);
       Database.data.updateAccount("kind", 1, getIBAN());
    }

    public CheckingAccount(int ownerID, String iban, int accountId, String bic, int balance, int limit){
        super(ownerID, iban,accountId, bic, balance, limit);
        setKind(1);
    }

    @Override
    public void setLimit(int limit) throws RuntimeException{
        throw new RuntimeException("Das Limit auf dem Konto ist 0€");
    }
}
