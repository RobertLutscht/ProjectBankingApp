package org.prog.BankingApp.ui;

import org.prog.BankingApp.Main;
import org.prog.BankingApp.database.Database;
import org.prog.BankingApp.user.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class RegisterPanel extends JFrame {

    GridBagConstraints gbc = new GridBagConstraints();

    public RegisterPanel(){
        Container pane = getContentPane();
        pane.setLayout(new GridBagLayout());

        setTitle("Register");
        setLocationRelativeTo(null);
        setSize(300, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        gbc.insets = new Insets(5, 5, 5, 5);

        //Text Fields
        JTextField firstName = new JTextField(20);
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(firstName, gbc);

        JTextField lastName = new JTextField(20);
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(lastName, gbc);

        JTextField birthday = new JTextField(20);
        gbc.gridx = 3;
        gbc.gridy = 5;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(birthday, gbc);

        JTextField street = new JTextField(20);
        gbc.gridx = 3;
        gbc.gridy = 7;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(street, gbc);

        JTextField plz = new JTextField(20);
        gbc.gridx = 3;
        gbc.gridy = 9;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(plz, gbc);

        JTextField city = new JTextField(20);
        gbc.gridx = 3;
        gbc.gridy = 11;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(city, gbc);

        JTextField country = new JTextField(20);
        gbc.gridx = 3;
        gbc.gridy = 13;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(country, gbc);

        JTextField phoneNumber = new JTextField(20);
        gbc.gridx = 3;
        gbc.gridy = 15;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(phoneNumber, gbc);

        JTextField eMail = new JTextField(20);
        gbc.gridx = 3;
        gbc.gridy = 17;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(eMail, gbc);

        JPasswordField pw = new JPasswordField(20);
        gbc.gridx = 3;
        gbc.gridy = 19;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(pw, gbc);





        //Labels
        JLabel fN = new JLabel("Hier den Vornamen angeben");
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(fN, gbc);

        JLabel lN = new JLabel("Hier den Nachnamen angeben");
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(lN, gbc);

        JLabel bd = new JLabel("Hier das Geburtsdatum angeben");
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(bd, gbc);

        JLabel str = new JLabel("Hier die Straße angeben");
        gbc.gridx = 3;
        gbc.gridy = 6;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(str, gbc);

        JLabel post = new JLabel("Hier die Postleitzahl angeben");
        gbc.gridx = 3;
        gbc.gridy = 8;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(post, gbc);

        JLabel cit = new JLabel("Hier Wohnort angeben");
        gbc.gridx = 3;
        gbc.gridy = 10;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(cit, gbc);

        JLabel cont = new JLabel("Hier Land des Wohnsitzes angeben");
        gbc.gridx = 3;
        gbc.gridy = 12;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(cont, gbc);

        JLabel pN = new JLabel("Hier die Telefonnummer angeben");
        gbc.gridx = 3;
        gbc.gridy = 14;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(pN, gbc);

        JLabel eM = new JLabel("Hier die EMail angeben");
        gbc.gridx = 3;
        gbc.gridy = 16;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(eM, gbc);

        JLabel password = new JLabel("Hier Passwort eingeben");
        gbc.gridx = 3;
        gbc.gridy = 18;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(password, gbc);


        //Button
        JButton registrieren = new JButton("Registrieren");
        gbc.gridx = 3;
        gbc.gridy = 20;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(registrieren, gbc);

        registrieren.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password_value = new String(pw.getPassword());
                User user = new User(password_value, firstName.getText(), lastName.getText(), birthday.getText(),
                        street.getText(), Integer.parseInt(plz.getText()), city.getText(), country.getText(),
                        phoneNumber.getText(), eMail.getText(), "User");
                WorkInterface work = new WorkInterface(user);
                Main.f.dispose();
                Main.r.dispose();
            }
        });





    }

}
