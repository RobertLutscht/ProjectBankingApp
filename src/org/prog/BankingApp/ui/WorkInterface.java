package org.prog.BankingApp.ui;

import org.prog.BankingApp.Main;
import org.prog.BankingApp.user.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkInterface extends JFrame{

    public WorkInterface(User user){

        Container pane = getContentPane();
        pane.setLayout(new GridLayout(3,1));

        setTitle("Banking App");
        setLocationRelativeTo(null);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);



        //Buttons
        JButton transfer = new JButton("Überweisen");
        transfer.setFont(new Font("Tahoma", Font.PLAIN, 20));
        pane.add(transfer);

        transfer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.t = new TransferDialog(user);
            }
        });

        JButton deposit = new JButton("Einzahlen");
        deposit.setFont(new Font("Tahoma", Font.PLAIN, 20));
        pane.add(deposit);

        deposit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JButton withdraw = new JButton("Abheben");
        withdraw.setFont(new Font("Tahoma", Font.PLAIN, 20));
        pane.add(withdraw);

        withdraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        //Menubar
        JMenuBar menu = new JMenuBar();
        JMenu file = new JMenu("Daten");
        JMenuItem search = new JMenuItem("Suchen");
        JMenuItem updateGeneral = new JMenuItem("Informationen updaten");
        JMenuItem updateResidence = new JMenuItem("Wohnsitz updaten");

        file.add(search);
        file.addSeparator();
        file.add(updateGeneral);
        file.add(updateResidence);
        menu.add(file);
        setJMenuBar(menu);



    }

}