package org.prog.BankingApp.database;

public class IdGetter {

    private IdGetter() {
        //utility class
    }

    public static int getNextAccId() {
        //TODO @jonas hier die id aus der db getten
        return 1 + Database.data.getMaxId("kontonummer", "accounts");
    }

    public static int getNextOwnerId() {
        //TODO @jonas hier die ownerid aus der db getten
        return 1 + Database.data.getMaxId("userID", "users");
    }

    public static int getNextTracId() {
        //TODO
        return 1 + Database.data.getMaxId("transactionID", "transactions");
    }
}
