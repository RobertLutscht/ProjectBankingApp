package org.prog.BankingApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String args[]){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con =  con = DriverManager.getConnection("jdbc:mysql://localhost", "root", "Hallo!");
            PreparedStatement ps = con.prepareStatement("CREATE DATABASE IF NOT EXISTS Bank");
            ps.execute();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }
    }

}
