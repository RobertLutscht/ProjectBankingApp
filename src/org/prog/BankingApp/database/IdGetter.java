package org.prog.BankingApp.database;

public class IdGetter {

    private IdGetter() {
        //utility class
    }

    public static int getNextAccId() {
        //TODO @jonas hier die id aus der db getten
        if(Database.data.getMaxId("kontonummer", "accounts") == null){
            return 1;
        }else {
            return 1 + Database.data.getMaxId("kontonummer", "accounts");
        }
    }

    public static int getNextOwnerId() {
        //TODO @jonas hier die ownerid aus der db getten
        if(Database.data.getMaxId("userID", "users") == null){
            return 1;
        }else {
            return 1 + Database.data.getMaxId("userID", "users");
        }
    }

    public static int getNextTracId() {
        //TODO
        if(Database.data.getMaxId("transactionID", "transactions") == null){
            return 1;
        }else {
            return 1 + Database.data.getMaxId("transactionID", "transactions");
        }
    }
}
