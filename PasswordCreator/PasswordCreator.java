package classes;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.event.*;

public class PasswordCreator implements ActionListener{
  PrintWriter pw = new PrintWriter(System.out,true);
  JButton buttonCreate;
  JCheckBox capitals, symbols, numbers;
  JTextField password; // = new JTextField();
  JComboBox<String> fileTXTOrHere;
  Color backG = new Color(254, 248, 221);
  boolean includeCapitals, includeSymbols, includeNumbers = false;

  String[] list = {"Create password here", "Create password in txt file"};

  public PasswordCreator() {
    // creating a JFrame
    JFrame frame = new JFrame("Password Creator");

    // adding some options to frame
    frame.setLayout(new FlowLayout()); // I might change it
    frame.setSize(500, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setBackground(backG);

    // configuring and adding other components
    buttonCreate = new JButton("GENERATE");
    buttonCreate.addActionListener(this);

    capitals = new JCheckBox("capitals");
    capitals.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent event) {
        includeCapitals = true;
      }
    });

    symbols = new JCheckBox("symbols");
    symbols.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent event) {
        includeSymbols = true;
      }
    });

    numbers = new JCheckBox("numbers");
    numbers.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent event) {
        includeNumbers = true;
      }
    });

    password = new JTextField(20);

    fileTXTOrHere = new JComboBox<String>(list);
    fileTXTOrHere.addActionListener(this);

    frame.add(buttonCreate);
    frame.add(capitals);
    frame.add(symbols);
    frame.add(numbers);
    frame.add(password);
    frame.add(fileTXTOrHere);

    // making frame visible
    frame.setVisible(true);
    frame.setResizable(false);
  }

  public void actionPerformed(ActionEvent ae) {
    if(ae.getActionCommand().equals("GENERATE")) {
      password.setText("creating pass");
      if(fileTXTOrHere.getItemAt(fileTXTOrHere.getSelectedIndex()).equals(list[1])) {
        password.setText("Input name of file");
      }
    }

  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new PasswordCreator();
      }
    });
  }
}
