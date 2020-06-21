package org.prog.BankingApp.user;

import org.prog.BankingApp.account.Account;
import org.prog.BankingApp.account.FixedDepositAccount;
import org.prog.BankingApp.database.Database;

public class Admin extends User{

    public Admin(){
        super("admin", "Faule", "Bastarde", "04.06.2000", "Affen Straße",
                68309, "Mannheim", "Germany", "01746743567", "admin@bank.de", "Admin");
    }

    public Admin(int userID){
        super("Faule", "Bastarde", "04.06.2000", "Affen Straße", 68309, "Mannheim", "Germany",
                "01746743567", "admin@bank.de", 1);
    }




    public void searchAd(int userID, String table, String item) {
        Database.data.searchData(userID, table, item);
    }

    public void setTerm(FixedDepositAccount fix, int term){
        fix.setTerm(term);
    }

    public void setInterestRate(Account acc, int interest){
        acc.setInterestRate(interest);
    }
}
