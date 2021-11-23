package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Main extends JFrame {

    public Main(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(480, 320);

        JTextArea ta = new JTextArea();

        JPanel p = new JPanel(new FlowLayout());
        JButton b1 = new JButton("Прочитать из файла");
        p.add(b1);

        JFileChooser fc = new JFileChooser();

        b1.addActionListener(e->{
            if(fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
                File f = fc.getSelectedFile();
                try(FileReader fr = new FileReader(f)){
                    StringBuilder msg = new StringBuilder();
                    int c;
                    while ((c = fr.read()) != -1) msg.append((char) c);
                    ta.setText(msg.toString());
                }catch (IOException ex){
                    JOptionPane.showMessageDialog(this, ex.toString());
                }
            }
        });

        getContentPane().add(ta, BorderLayout.NORTH);
        getContentPane().add(p, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}