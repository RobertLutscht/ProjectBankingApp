package org.prog.BankingApp;

import org.prog.BankingApp.ui.LoginFrame;
import org.prog.BankingApp.ui.RegisterPanel;
import org.prog.BankingApp.ui.TransferDialog;
import org.prog.BankingApp.ui.WorkInterface;

public class Main {

    public static LoginFrame f;
    public static RegisterPanel r;
    public static WorkInterface w;
    public static TransferDialog t;

    public static void main(String[] args) {
        f = new LoginFrame();
        f.setVisible(true);
        r.setVisible(true);
        w.setVisible(true);
        t.setVisible(true);
    }
}
