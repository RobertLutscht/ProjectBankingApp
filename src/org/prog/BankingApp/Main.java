package org.prog.BankingApp;

import org.prog.BankingApp.database.Database;
import org.prog.BankingApp.ui.*;
import org.prog.BankingApp.ui.dialog.*;
import org.prog.BankingApp.user.Admin;

import java.io.PrintStream;

public class Main {

    public static LoginFrame f;
    public static RegisterPanel r;
    public static WorkInterface w;
    public static TransferPopUp t;
    public static DepositPopUp d;
    public static WithdrawPopUp with;
    public static SearchDialog search;
    public static AddKontoDialog add;

    public static void main(String[] args) {
        Database.data.initiateDB();
        Admin admin = new Admin();

        f = new LoginFrame();
        f.setVisible(true);
        r.setVisible(true);
        w.setVisible(true);
        t.setVisible(true);
        d.setVisible(true);
        with.setVisible(true);
        search.setVisible(true);
        add.setVisible(true);
    }
}
