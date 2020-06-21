package org.prog.BankingApp.ui.dialog;

import org.prog.BankingApp.user.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchDialog extends JDialog {

    GridBagConstraints gbc = new GridBagConstraints();

    public SearchDialog(User user){
        Container pane = getContentPane();
        pane.setLayout(new GridBagLayout());

        setTitle("Suchen");
        setLocationRelativeTo(null);
        setSize(200, 300);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        gbc.insets = new Insets(5, 10, 5, 10);

        //Combobox
        String[] tables = {"accounts", "users"};
        JComboBox table = new JComboBox(tables);
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(table, gbc);


        //Labels
        JLabel searchtable = new JLabel("Geben Sie hier an in welcher Tabelle Sie suchen wollen");
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(searchtable, gbc);

        JLabel search = new JLabel("Geben Sie hier an wonach Sie suchen wollen");
        gbc.gridx = 3;
        gbc.gridy = 5;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(search, gbc);


        //Textfield
        JTextField item = new JTextField(20);
        gbc.gridx = 3;
        gbc.gridy = 6;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(item, gbc);


        //Button
        JButton go = new JButton("Suchen");
        gbc.gridx = 3;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(go, gbc);

        go.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String table_value = table.getSelectedItem().toString();
                String item_value = item.getText();

                user.search(table_value, item_value);
            }
        });

        setVisible(true);
    }


}
