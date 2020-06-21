package org.prog.BankingApp.ui.dialog;

import org.prog.BankingApp.Main;
import org.prog.BankingApp.account.Account;
import org.prog.BankingApp.database.Database;
import org.prog.BankingApp.user.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransferPopUp extends JDialog {

    GridBagConstraints gbc = new GridBagConstraints();

    public TransferPopUp(User user){
        Container pane = getContentPane();
        pane.setLayout(new GridBagLayout());

        setTitle("Überweisen");
        setLocationRelativeTo(null);
        setSize(500, 500);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);


        gbc.insets = new Insets(5, 10, 5, 10);

        //Labels
        JLabel am = new JLabel("Geben Sie hier die Menge an die Sie überweisen wollen");
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(am, gbc);

        JLabel toib = new JLabel("Geben Sie hier die Iban an die Sie überweisen wollen");
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(toib, gbc);

        JLabel fromib = new JLabel("Geben Sie hier die Iban von der Sie überweisen wollen");
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(fromib, gbc);

        //Textfelder
        JTextField ammount = new JTextField(20);
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(ammount, gbc);

        JTextField iban = new JTextField(20);
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(iban, gbc);

        JTextField fromiban = new JTextField(20);
        gbc.gridx = 3;
        gbc.gridy = 5;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(fromiban, gbc);

        //Buttons
        JButton transfer = new JButton("Überweisen");
        gbc.gridx = 3;
        gbc.gridy = 6;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(transfer, gbc);

        transfer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Account acc = Database.data.getAccount(fromiban.getText());
                user.transfer(acc, iban.getText(), Integer.parseInt(ammount.getText()));
                Main.t.dispose();
            }
        });

        setVisible(true);

    }
}
