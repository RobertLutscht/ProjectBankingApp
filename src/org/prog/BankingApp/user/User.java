package org.prog.BankingApp.user;

import org.prog.BankingApp.account.Account;
import org.prog.BankingApp.account.CheckingAccount;
import org.prog.BankingApp.account.Creditcard;
import org.prog.BankingApp.account.FixedDepositAccount;
import org.prog.BankingApp.database.Database;
import org.prog.BankingApp.database.IdGetter;

import javax.xml.crypto.Data;

public class User {

    private String firstName;
    private String lastName;
    private String birthday;
    private String street;
    private int plz;
    private String city;
    private String country;
    private String phoneNumber;
    private String  eMail;
    private final int userID;


    public User(String password, String firstName, String lastName, String birthday, String street, int plz, String city,
                String country, String phoneNumber, String eMail, String rolle){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.street = street;
        this.plz = plz;
        this.city = city;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.eMail = eMail;
        this.userID = IdGetter.getNextOwnerId();
        Database.data.addUser(userID, this.firstName, this.lastName, this.birthday, this.street, this.plz, this.city,
                this.country, this.phoneNumber, this.eMail);
        Database.data.addLoginData(userID, password, rolle);
    }

    public User(String firstName, String lastName, String birthday, String street, int plz, String city, String country,
                String phoneNumber, String eMail, int userId){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.street = street;
        this.plz = plz;
        this.city = city;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.eMail = eMail;
        this.userID = userId;
    }

    public void search(String table, String item){
        Database.data.searchData(userID, table, item);
    }

    public void updateResidence(String street, String plz, String city, String country){
        Database.data.updateUserResidence(street, plz, city, country, userID);
    }

    public void updateGeneral(String change, String update){
        Database.data.updateUserGeneral(change, update, userID);
    }

    public void newCheckingAccount(){
        CheckingAccount check = new CheckingAccount(userID);
    }

    public void newCreditcard(){
        Creditcard credit = new Creditcard(userID, 0);
    }

    public void newFixedDepositAccount(){
        FixedDepositAccount check = new FixedDepositAccount(userID, 3);
    }

    public void withdraw(Account acc, int amount){
        acc.withdraw(amount);
    }

    public void transfer(Account acc, String destinationIban, int amount){
        acc.transfer(amount, destinationIban);
    }

    public void deposit(Account acc, int amount){
        acc.deposit(amount);
    }
}
