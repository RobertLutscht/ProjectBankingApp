package org.prog.BankingApp.ui;

import org.prog.BankingApp.Main;
import org.prog.BankingApp.database.Database;
import org.prog.BankingApp.user.Admin;
import org.prog.BankingApp.user.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class LoginFrame extends JFrame {

    GridBagConstraints gbc = new GridBagConstraints();

    public LoginFrame(){
        Container pane = getContentPane();
        pane.setLayout(new GridBagLayout());

        setTitle("Login");
        setLocationRelativeTo(null);
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        gbc.insets = new Insets(5, 10, 5, 10);

        //Text Fields
        JTextField userId = new JTextField(20);
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(userId, gbc);

        JPasswordField pw = new JPasswordField(20);
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(pw, gbc);


        //Labels
        JLabel id = new JLabel("Hier die UserID angeben");
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(id, gbc);

        JLabel password = new JLabel("Hier Passwort eingeben");
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(password, gbc);

        //ComboBox
        String[] roles = {"User", "Admin"};
        JComboBox role = new JComboBox(roles);
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(role, gbc);

        //Buttons
        JButton login = new JButton("Login");
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(login, gbc);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String userId_value = userId.getText();
                int loginId_value = Integer.parseInt(userId_value);
                String password_value = pw.getText();
                String role_value = role.getSelectedItem().toString();

                if(Database.data.checkLogin(loginId_value, password_value, role_value)){
                    User user = Database.data.getUser(loginId_value);

                }
                else {
                    System.out.println("Fehler beim einloggen");
                }


            }
        });


        JButton registrieren = new JButton("Registrieren");
        gbc.gridx = 4;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(registrieren, gbc);

        registrieren.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String userId_value = userId.getText();
                int loginId_value = Integer.parseInt(userId_value);
                String password_value = password.getText();
                String role_value = role.getSelectedItem().toString();

                if(role_value.equals("Admin")){
                    System.out.println("Du kannst kein Admin sein");
                }
                else {

                }
            }
        });


    }

    public static void main(String args[]){
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                LoginFrame f = new LoginFrame();
            }
        });

    }
}
