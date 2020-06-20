package org.prog.BankingApp;

public class User {

    private String firstName;
    private String lastName;
    private int birthday;
    private String street;
    private int plz;
    private String city;
    private String country;
    private String phoneNumber;
    private String  eMail;
    private final int userID;
    private String password;


    public User(int userID, String password, String firstName, String lastName, int birthday, String street, int plz, String city, String country, String phoneNumber, String eMail){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.street = street;
        this.plz = plz;
        this.city = city;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.eMail = eMail;
        this.userID = userID;
        this.password = password;
    }




}
