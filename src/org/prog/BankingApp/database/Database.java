package org.prog.BankingApp.database;

import org.prog.BankingApp.account.Account;
import org.prog.BankingApp.account.CheckingAccount;
import org.prog.BankingApp.account.Creditcard;
import org.prog.BankingApp.account.FixedDepositAccount;
import org.prog.BankingApp.user.Admin;
import org.prog.BankingApp.user.User;

import javax.swing.*;
import java.sql.*;

public class Database {

    public static Database data = new Database();

    Connection con;

    private Database() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost", "root", "Hallo!");
            PreparedStatement ps = con.prepareStatement("CREATE DATABASE IF NOT EXISTS Bank");
            ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void initiateDB() {
        try {
            PreparedStatement statement = con.prepareStatement("CREATE TABLE IF NOT EXISTS Bank.users (" +
                    "userID INT NOT NULL, firstName VARCHAR(45) NOT NULL, lastName VARCHAR(45) NOT NULL, " +
                    "birthday VARCHAR(100) NOT NULL, street VARCHAR(45) NOT NULL, plz VARCHAR(45) NOT NULL, " +
                    "city VARCHAR(45) NOT NULL, country VARCHAR(45) NOT NULL, phoneNumber VARCHAR(45) NOT NULL, " +
                    "eMail VARCHAR(45) NOT NULL)");
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            PreparedStatement statement = con.prepareStatement("CREATE TABLE IF NOT EXISTS Bank.accounts (" +
                    "userID INT NOT NULL, iban VARCHAR(45) NOT NULL, kontonummer INT NOT NULL, bic VARCHAR(45) NOT NULL, " +
                    "balance INT NOT NULL, `limit` INT NOT NULL, term INT NOT NULL, kind INT NOT NULL)");
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

    public void addUser(int userID, String firstName, String lastName, String birthday, String street, int plz, String city, String country, String phoneNumber, String eMail) {
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
            JOptionPane.showMessageDialog(null,"User wurde hinzugefügt");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addAccount(int userID, String iban, int knr, String bic, int balance, int limit, int term, int kind) {
        try {
            PreparedStatement st = con.prepareStatement("insert into Bank.accounts values (?, ?, ?, ?, ?, ?, ?, ?)");
            st.setInt(1, userID);
            st.setString(2, iban);
            st.setInt(3, knr);
            st.setString(4, bic);
            st.setInt(5, balance);
            st.setInt(6, limit);
            st.setInt(7, term);
            st.setInt(8, kind);
            st.executeUpdate();
            JOptionPane.showMessageDialog(null,"Konto wurde hinzugefügt");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addTransaction(int userID, int transactionID, String fromIBAN, String toIBAN, String date, int ammount) {
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
            JOptionPane.showMessageDialog(null,"Transaktion wurde hinzugefügt");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addLoginData(int userID, String password, String rolle) {
        try {
            PreparedStatement st = con.prepareStatement("insert into Bank.loginData values (?, ?, ?)");
            st.setInt(1, userID);
            st.setString(2, password);
            st.setString(3, rolle);
            st.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public boolean checkLogin(int userID, String pw, String rolle) {
        boolean isFine = false;

        try {
            PreparedStatement st = con.prepareStatement("select * from Bank.loginData where userid = ? ");
            st.setInt(1, userID);
            ResultSet rs = st.executeQuery();

            while(rs.next()){
                String check = rs.getString(2);
                String check1 = rs.getString(3);
                if (check.equals(pw) && check1.equals(rolle)) {
                    isFine = true;
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            return isFine;
        }
    }

    public User getUser(int userID) {

        PreparedStatement st = null;
        try {
            st = con.prepareStatement("SELECT * FROM bank.users WHERE userID = ?");
            st.setInt(1, userID);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                if (rs.getInt("userID") == 1) {
                    return new Admin(rs.getInt("userID"));
                } else {
                    return new User(rs.getString("firstName"), rs.getString("lastName"),
                            rs.getString("birthday"), rs.getString("street"), rs.getInt("plz"),
                            rs.getString("city"), rs.getString("country"), rs.getString("phoneNumber"),
                            rs.getString("eMail"), rs.getInt("userID"));
                }

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    public Account getAccount(String iban) {

        try {

            PreparedStatement st = con.prepareStatement("SELECT * FROM bank.accounts WHERE iban = ?");
            st.setString(1, iban);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                if (rs.getInt("kind") == 1) {

                    return new CheckingAccount(rs.getInt("userID"), rs.getString("iban"),
                            rs.getInt("kontonummer"), rs.getString("bic"),
                            rs.getInt("balance"), rs.getInt("limit"));
                } else if (rs.getInt("kind") == 2) {
                    return new Creditcard(rs.getInt("userID"), rs.getString("iban"),
                            rs.getInt("kontonummer"), rs.getString("bic"),
                            rs.getInt("balance"), rs.getInt("limit"));
                } else if (rs.getInt("kind") == 3) {
                    return new FixedDepositAccount(rs.getInt("userID"), rs.getString("iban"),
                            rs.getInt("kontonummer"), rs.getString("bic"),
                            rs.getInt("balance"), rs.getInt("limit"), rs.getInt("term"));
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }


    public void searchData(int userID, String table, String item) {

        String query = "select " + item + " from bank." + table + " where userID=" + userID;
        ResultSet rs = search(query);
        String print = "";

        try {

            int columns = rs.getMetaData().getColumnCount();

            for (int i = 1; i <= columns; i++) {
               print += rs.getMetaData().getColumnLabel(i) + "\t\t";
            }
            System.out.println();

            while (rs.next()) {
                for (int i = 1; i <= columns; i++) {
                    print += rs.getString(i) + "\t\t";
                }
                print += "\n";
            }
            JOptionPane.showMessageDialog(null, print);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean compareIban(String iban) {

        String query = "select iban from bank.accounts where iban = " + iban;
        ResultSet rs = search(query);

        try {
            rs.next();
            if (rs != null) {
                return true;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    public int getBalance(String iban) {
        String query = "select balance from bank.accounts where iban = " + iban;
        ResultSet rs = search(query);

        try {
            rs.next();
            return rs.getInt("balance");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;

    }


    private ResultSet search(String query) {

        ResultSet rs = null;

        try {
            Statement st = con.createStatement();
            rs = st.executeQuery(query);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            JOptionPane.showMessageDialog(null,"Es gab einen Fehler");
        } finally {
            return rs;
        }
    }


    public void updateAccount(String column, int change, String iban) {
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

    public void updateUserGeneral(String change, String update, int id) {
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

    public void updateUserResidence(String street, String plz, String city, String country, int id) {
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

    public void updateLogin(int userID, String pw) {
        try {
            PreparedStatement st = con.prepareStatement("update Bank.Login set password = ? where userID = ?");
            st.setInt(1, userID);
            st.setString(2, pw);
            st.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public Integer getMaxId(String id, String table) {
        String query = "select MAX(" + id + ") as number FROM bank." + table;
        Integer solution = 0;
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            solution = Integer.parseInt(rs.getString("number"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            return solution;
        }
    }
}
