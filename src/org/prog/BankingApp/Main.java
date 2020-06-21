package org.prog.BankingApp;

import org.prog.BankingApp.ui.*;
import org.prog.BankingApp.ui.dialog.DepositPopUp;
import org.prog.BankingApp.ui.dialog.SearchDialog;
import org.prog.BankingApp.ui.dialog.TransferPopUp;
import org.prog.BankingApp.ui.dialog.WithdrawPopUp;

public class Main {

    public static LoginFrame f;
    public static RegisterPanel r;
    public static WorkInterface w;
    public static TransferPopUp t;
    public static DepositPopUp d;
    public static WithdrawPopUp with;
    public static SearchDialog search;

    public static void main(String[] args) {
        f = new LoginFrame();
        f.setVisible(true);
        r.setVisible(true);
        w.setVisible(true);
        t.setVisible(true);
        d.setVisible(true);
        with.setVisible(true);
        search.setVisible(true);
    }
}
