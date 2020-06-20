package org.prog.BankingApp.database;

import java.sql.*;

public class Database {

    public static Database data = new Database();

    Connection con;

    private Database(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost", "admin", "Hallo!");
            PreparedStatement ps = con.prepareStatement("CREATE DATABASE IF NOT EXISTS Bank");
            ps.execute();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }
    }

    public void initiateDB(){
        try {
            PreparedStatement statement = con.prepareStatement("CREATE TABLE IF NOT EXISTS users (userID INTEGER, firstName TEXT, lastName TEXT, birthday INTEGER, street TEXT, plz TEXT, city TEXT, country TEXT, phoneNumber TEXT, eMail TEXT");
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            PreparedStatement statement = con.prepareStatement("CREATE TABLE IF NOT EXISTS accounts (userID INTEGER, iban TEXT, bic TEXT, balance INTEGER, limit INTEGER");
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            PreparedStatement statement = con.prepareStatement("CREATE TABLE IF NOT EXISTS transactions (userID INTEGER, transactionID INTEGER, fromIBAN TEXT, toIBAN TEXT, date TEXT, ammount INTEGER");
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            PreparedStatement statement = con.prepareStatement("CREATE TABLE IF NOT EXISTS loginData (userID INTEGER, password TEXT, rolle TEXT");
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addUser(int userID, String firstName, String lastName, int birthday, String street, int plz, String city, String country, String phoneNumber, String eMail){
        try {
            PreparedStatement st = con.prepareStatement("insert into Bank.users values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            st.setInt(1, userID);
            st.setString(2, firstName);
            st.setString(3, lastName);
            st.setInt(4, birthday);
            st.setString(5, street);
            st.setInt(6, plz);
            st.setString(7, city);
            st.setString(8, country);
            st.setString(9, phoneNumber);
            st.setString(10, eMail);
            st.executeUpdate();
            System.out.println("User wurde hinzugefügt");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addAccount(int userID, String iban, String bic, int balance, int limit){
        try {
            PreparedStatement st = con.prepareStatement("insert into Bank.accounts values (?, ?, ?, ?, ?)");
            st.setInt(1, userID);
            st.setString(2, iban);
            st.setString(3, bic);
            st.setInt(4, balance);
            st.setInt(5, limit);
            st.executeUpdate();
            System.out.println("Konto wurde hinzugefügt");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addTransaction(int userID, int transactionID, String fromIBAN, String toIBAN, String date, int ammount){
        PreparedStatement st = null;
        try {
            st = con.prepareStatement("insert into Bank.transactions values (?, ?, ?, ?, ?, ?)");
            st.setInt(1, userID);
            st.setInt(2, transactionID);
            st.setString(3, fromIBAN);
            st.setString(4, toIBAN);
            st.setString(5, date);
            st.setInt(6, ammount);
            st.executeUpdate();
            System.out.println("Transaktion wurde hinzugefügt");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addLoginData(int userID, String password, String rolle){
        try {
            PreparedStatement st = con.prepareStatement("insert into Bank.loginData values (?, ?, ?)");
            st.setInt(1, userID);
            st.setString(2, password);
            st.setString(3, rolle);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }





    public void searchData(String userID, String table, String item){

        String query = "select " + item + " from " + table + " where userID=" + userID;
        ResultSet rs = search(query, item);
        try {

            int columns =rs.getMetaData().getColumnCount();

            for (int i = 1; i <= columns; i++) {
                System.out.print(rs.getMetaData().getColumnLabel(i) + "\t");
            }
            System.out.println();

            while(rs.next()){
                for(int i = 1; i <= columns; i++){
                    System.out.println(rs.getString(i) + "\t");
                }
                System.out.println();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    private ResultSet search(String query, String item){

        ResultSet rs = null;

        try {
            Statement st = con.createStatement();
            rs = st.executeQuery(query);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Es gab einen Fehler");
        }
        finally {
            return rs;
        }
    }

}
