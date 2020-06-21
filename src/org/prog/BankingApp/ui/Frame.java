package org.prog.BankingApp.ui;

import org.prog.BankingApp.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {

    public Frame(){
        //GUI
        setTitle("Banking App");
        setSize(1920, 1080);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        //Labels
        JLabel user = new JLabel("UserID hier eingeben");
        JLabel pw = new JLabel("Passwort hier eingeben");

        //Eingabefelder
        JTextField userId = new JTextField(20);
        JPasswordField password = new JPasswordField(20);

        userId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        //Combobox
        String[] roles = {"User", "Admin"};
        JComboBox role = new JComboBox(roles);


        //Buttons
        JButton login = new JButton("Login");
        JButton register = new JButton("Registrieren");

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        //Layout
        GridBagLayout gbl = new GridBagLayout();
        setLayout(gbl);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbl.setConstraints(login, gbc);
        add(login);
    }

    public static void main(String args[]){
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                Frame f = new Frame();
                f.setVisible(true);
            }
        });

    }
}
