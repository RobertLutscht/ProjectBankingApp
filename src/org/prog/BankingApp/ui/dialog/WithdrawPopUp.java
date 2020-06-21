package org.prog.BankingApp.ui.dialog;

import org.prog.BankingApp.Main;
import org.prog.BankingApp.account.Account;
import org.prog.BankingApp.database.Database;
import org.prog.BankingApp.user.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WithdrawPopUp extends JDialog {

    GridBagConstraints gbc = new GridBagConstraints();

    public WithdrawPopUp(User user) {
        Container pane = getContentPane();
        pane.setLayout(new GridBagLayout());

        setTitle("Abheben");
        setLocationRelativeTo(null);
        setSize(500, 500);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);


        gbc.insets = new Insets(5, 10, 5, 10);

        //Labels
        JLabel am = new JLabel("Geben Sie hier die Menge an die Sie abheben wollen");
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(am, gbc);

        JLabel ib = new JLabel("Geben Sie hier die Iban von der Sie abheben wollen");
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(ib, gbc);

        //Textfelder
        JTextField ammount = new JTextField(20);
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(ammount, gbc);

        JTextField fromiban = new JTextField(20);
        gbc.gridx = 3;
        gbc.gridy = 5;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(fromiban, gbc);

        //Buttons
        JButton withdraw = new JButton("Abheben");
        gbc.gridx = 3;
        gbc.gridy = 6;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(withdraw, gbc);

        withdraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Account acc = Database.data.getAccount(fromiban.getText());
                user.withdraw(acc, Integer.parseInt(ammount.getText()));
                Main.with.dispose();
            }
        });
        setVisible(true);

    }
}
