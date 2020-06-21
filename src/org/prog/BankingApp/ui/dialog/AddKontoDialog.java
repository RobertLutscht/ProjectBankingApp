package org.prog.BankingApp.ui.dialog;

import org.prog.BankingApp.Main;
import org.prog.BankingApp.user.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddKontoDialog extends JDialog{

    GridBagConstraints gbc = new GridBagConstraints();

    public AddKontoDialog(User user){
        Container pane = getContentPane();
        pane.setLayout(new GridBagLayout());

        setTitle("Suchen");
        setLocationRelativeTo(null);
        setSize(400, 300);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        gbc.insets = new Insets(5, 10, 5, 10);

        //Combobox
        String[] types = {"Kreditkarte", "Giro Konto", "Festgeldkonto"};
        JComboBox type = new JComboBox(types);
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(type, gbc);



        //Labels
        JLabel kind = new JLabel("Geben Sie hier an in welche Art von Konto Sie eröffnen wollen");
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(kind, gbc);


        //Button
        JButton go = new JButton("Eröffnen");
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(go, gbc);

        go.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String type_value = type.getSelectedItem().toString();
                if(type_value.equals("Giro Konto")){
                    user.newCheckingAccount();
                }
                else if(type_value.equals("Kreditkarte")) {
                    user.newCreditcard();
                }
                else if(type_value.equals("Festgeldkonto")){
                    user.newFixedDepositAccount();
                }

                Main.add.dispose();
            }
        });

        setVisible(true);
    }
}
