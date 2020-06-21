package org.prog.BankingApp.ui;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    JButton b1, b2, b3, b4, b5;
    GridBagConstraints gbc = new GridBagConstraints();

    public Panel(){
        setLayout(new GridBagLayout());

        gbc.insets = new Insets(5, 5, 5, 5);

        b1 = new JButton("Button1");
        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.gridheight = 5;
        gbc.fill = GridBagConstraints.VERTICAL;
        add(b1, gbc);

        b2 = new JButton("Button2");
        gbc.gridx = 1;
        gbc.gridy = 1;

        gbc.gridheight = 1;
        add(b2, gbc);

        b3 = new JButton("Button3");
        gbc.gridx = 2;
        gbc.gridy = 2;

        gbc.gridheight = 1;
        add(b3, gbc);

        b4 = new JButton("Button4");
        gbc.gridx = 3;
        gbc.gridy = 3;

        gbc.gridheight = 1;
        add(b4, gbc);

        b5 = new JButton("Button5");
        gbc.gridx = 1;
        gbc.gridy = 4;

        gbc.gridheight = 1;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(b5, gbc);
    }

    public static void main(String[] args) {
        Panel p = new Panel();
        JFrame jf = new JFrame();

        jf.setTitle("test");
        jf.setSize(500, 500);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.add(p);
    }
}
