package org.prog.BankingApp;

import org.prog.BankingApp.database.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String args[]){
        System.out.println(Database.data.getMaxId("userid", "accounts"));
    }
}
