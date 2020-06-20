package org.prog.BankingApp.user;

import org.prog.BankingApp.database.Database;

public class Login {

    public Login(){

    }

    public void registrieren(String password, String firstName, String lastName, String birthday, String street, int plz, String city,
                             String country, String phoneNumber, String eMail, String rolle){
        User user = new User(password, firstName, lastName, birthday, street, plz, city,
                country, phoneNumber, eMail, rolle);
    }

    public void login(int userId, int pw, String rolle){

        if(Database.data.checkLogin(userId, pw, rolle)){
            Database.data.
        }

    }
}
