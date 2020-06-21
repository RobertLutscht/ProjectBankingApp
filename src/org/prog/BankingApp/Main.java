package org.prog.BankingApp;

import org.prog.BankingApp.database.Database;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.Flow;

public class Main extends JFrame {

    public Main(){
        //GUI
        setTitle("Unsere GUI");
        setSize(1920, 1080);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);



        //Button
        JButton button = new JButton("Quit");

        JButton button2 = new JButton("Quit");

        JButton button3 = new JButton("Quit");

        JButton button4 = new JButton("Quit");

        JButton button5 = new JButton("Quit");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser filechooser = new JFileChooser();
                FileFilter filter = new FileNameExtensionFilter("Images", "png");
                filechooser.addChoosableFileFilter(filter);
                int dialog = filechooser.showDialog(getContentPane(), "Datei öffnen");

                if(dialog == JFileChooser.APPROVE_OPTION){
                    File file = filechooser.getSelectedFile();

                }
            }
        });

        JCheckBox cb = new JCheckBox("Ich bin eine CheckBox");
        cb.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBox cb_source = (JCheckBox) e.getSource();
                if(cb_source.isSelected()){
                    cb.setFont(new Font("Calibri", Font.ITALIC, 12));
                }
            }
        });

        String[] list = {"Auswahl eins", "Auswahl zwei"};
        JComboBox<String> comb = new JComboBox<String>(list);

        comb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    comb.addItem(e.getItem().toString());
                }
            }
        });


        //Menubar
        JMenuBar menu = new JMenuBar();
        JMenu file = new JMenu("Datei");
        JMenu submenu = new JMenu("Submenu");
        JMenuItem item1 = new JMenuItem("Ich bin im sub");
        JMenuItem abo = new JMenuItem("Abonniert mich");

        abo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Desktop desktop = Desktop.getDesktop();
                URL url = null;

                try {
                    url = new URL("https://www.youtube.com/watch?v=U_9ilSvimVE&list=PLNmsVeXQZj7o5ALam15-pQWtf22RgU6D7&index=2");
                } catch (MalformedURLException malformedURLException) {
                    malformedURLException.printStackTrace();
                }
                try {
                    desktop.browse(url.toURI());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (URISyntaxException uriSyntaxException) {
                    uriSyntaxException.printStackTrace();
                }

            }
        });



        submenu.add(item1);
        file.add(abo);
        file.addSeparator();
        file.add(submenu);
        menu.add(file);
        setJMenuBar(menu);

        //Layout
        Container pane = getContentPane();
        pane.setLayout(new FlowLayout());
        pane.add(button);
        pane.add(cb);
        pane.add(comb);

    }

    public static void main(String args[]){
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                Main m = new Main();
                m.setVisible(true);
            }
        });

    }
}
