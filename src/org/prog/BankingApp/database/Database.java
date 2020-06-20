package org.prog.BankingApp.database;

import org.prog.BankingApp.account.Account;
import org.prog.BankingApp.user.User;

import javax.xml.xpath.XPathEvaluationResult;
import java.sql.*;

public class Database {

    public static Database data = new Database();

    Connection con;

    private Database(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost", "root", "Hallo!");
            PreparedStatement ps = con.prepareStatement("CREATE DATABASE IF NOT EXISTS Bank");
            ps.executeUpdate();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }
    }

    public void initiateDB(){
        try {
            PreparedStatement statement = con.prepareStatement("CREATE TABLE IF NOT EXISTS Bank.users (" +
                    "userID INT NOT NULL, firstName VARCHAR(45) NOT NULL, lastName VARCHAR(45) NOT NULL, " +
                    "birthday VARCHAR(45) NOT NULL, street VARCHAR(45) NOT NULL, plz VARCHAR(45) NOT NULL, " +
                    "city VARCHAR(45) NOT NULL, country VARCHAR(45) NOT NULL, phoneNumber VARCHAR(45) NOT NULL, " +
                    "eMail VARCHAR(45) NOT NULL)");
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            PreparedStatement statement = con.prepareStatement("CREATE TABLE IF NOT EXISTS Bank.accounts (" +
                    "userID INT NOT NULL, iban VARCHAR(45) NOT NULL, kontonummer INT NOT NULL, bic VARCHAR(45) NOT NULL, " +
                    "balance INT NOT NULL, `limit` INT NOT NULL)");
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            PreparedStatement statement = con.prepareStatement("CREATE TABLE IF NOT EXISTS Bank.transactions (" +
                    "userID INT NOT NULL, transactionID INT NOT NULL, fromIBAN VARCHAR(45) NOT NULL, " +
                    "toIBAN VARCHAR(45) NOT NULL, date VARCHAR(45) NOT NULL, ammount INT NOT NULL)");
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            PreparedStatement statement = con.prepareStatement("CREATE TABLE IF NOT EXISTS Bank.loginData (" +
                    "userID INT NOT NULL, password VARCHAR(45) NOT NULL, rolle VARCHAR(45) NOT NULL)");
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addUser(int userID, String firstName, String lastName, String birthday, String street, int plz, String city, String country, String phoneNumber, String eMail){
        try {
            PreparedStatement st = con.prepareStatement("insert into Bank.users values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            st.setInt(1, userID);
            st.setString(2, firstName);
            st.setString(3, lastName);
            st.setString(4, birthday);
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

    public void addAccount(int userID, String iban, int knr, String bic, int balance, int limit){
        try {
            PreparedStatement st = con.prepareStatement("insert into Bank.accounts values (?, ?, ?, ?, ?, ?)");
            st.setInt(1, userID);
            st.setString(2, iban);
            st.setInt(3, knr);
            st.setString(4, bic);
            st.setInt(5, balance);
            st.setInt(6, limit);
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


    public boolean checkLogin(int userID, int pw, String rolle){
        try {
            String query = "select * from Bank.loginData where userid = " + userID;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();

            if(rs.getInt("password") == pw && rs.getString("rolle").equals(rolle)){
                return true;
            } else {
                return false;
            }

        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    public User getUser(int userID){

    }

    public Account getAccount(String iban){
        try {
            PreparedStatement st = con.prepareStatement("SELECT userID, bic, balance, 'limit' FROM accounts WHERE iban = ?");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void searchData(int userID, String table, String item){

        String query = "select " + item + " from " + table + " where userID=" + userID;
        ResultSet rs = search(query, item);
        try {

            int columns =rs.getMetaData().getColumnCount();

            for (int i = 1; i <= columns; i++) {
                System.out.print(rs.getMetaData().getColumnLabel(i) + "\t\t");
            }
            System.out.println();

            while(rs.next()){
                for(int i = 1; i <= columns; i++){
                    System.out.print(rs.getString(i) + "\t\t");
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


    public void updateAccount(String column, int change, String iban){
        try {
            PreparedStatement st = con.prepareStatement("update Bank.accounts set ? = ? where iban = ?");
            st.setString(1, column);
            st.setInt(2, change);
            st.setString(3, iban);
            st.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateUserGeneral(String change, String update, int id){
        try {
            PreparedStatement st = con.prepareStatement("update Bank.users set ? = ? where userID = ?");
            st.setString(1, change);
            st.setString(2, update);
            st.setInt(3, id);
            st.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateUserResidence(String street, String plz, String city, String country, int id){
        try {
            PreparedStatement st = con.prepareStatement("update Bank.users set street = ? set plz = ? set city = ? " +
                    "set country = ? where userID = ?");
            st.setString(1, street);
            st.setString(2, plz);
            st.setString(3, city);
            st.setString(4, country);
            st.setInt(5, id);
            st.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateLogin(int userID, String pw){
        try {
            PreparedStatement st = con.prepareStatement("update Bank.Login set password = ? where userID = ?");
            st.setInt(1, userID);
            st.setString(2, pw);
            st.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public int getMaxId(String id, String table){
        String query = "select MAX(" + id + ") as number FROM bank." + table;
        int ergebnis = 0;
        try {
            Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query);
             rs.next();
             ergebnis = Integer.parseInt(rs.getString("number"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            return ergebnis;
        }
    }
}
