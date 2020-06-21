package org.prog.BankingApp.ui;

import org.prog.BankingApp.Main;
import org.prog.BankingApp.ui.dialog.*;
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
                Main.t = new TransferPopUp(user);
            }
        });

        JButton deposit = new JButton("Einzahlen");
        deposit.setFont(new Font("Tahoma", Font.PLAIN, 20));
        pane.add(deposit);

        deposit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.d = new DepositPopUp(user);
            }
        });

        JButton withdraw = new JButton("Abheben");
        withdraw.setFont(new Font("Tahoma", Font.PLAIN, 20));
        pane.add(withdraw);

        withdraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.with = new WithdrawPopUp(user);
            }
        });


        //Menubar
        JMenuBar menu = new JMenuBar();
        JMenu file = new JMenu("Daten");
        JMenuItem search = new JMenuItem("Suchen");
        JMenuItem updateGeneral = new JMenuItem("Informationen updaten");
        JMenuItem updateResidence = new JMenuItem("Wohnsitz updaten");
        JMenuItem addKonto = new JMenuItem("Ein Konto eröffnen");
        JMenuItem removeKonto = new JMenuItem("Ein Konto auflösen");

        file.add(search);
        file.addSeparator();
        file.add(updateGeneral);
        file.add(updateResidence);
        file.addSeparator();
        file.add(addKonto);
        file.add(removeKonto);
        menu.add(file);
        setJMenuBar(menu);

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.search = new SearchDialog(user);

            }
        });

        updateGeneral.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        updateResidence.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        addKonto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.add = new AddKontoDialog(user);
            }
        });

        removeKonto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}
