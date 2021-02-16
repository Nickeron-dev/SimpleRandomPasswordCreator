package classes;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.Random;

public class PasswordCreator implements ActionListener{
  Random rand = new Random();
  PrintWriter pw = new PrintWriter(System.out,true);
  JButton buttonCreate;
  JCheckBox capitals, symbols, numbers;
  JTextField password, lengthOfPassword;
  JComboBox<String> fileTXTOrHere;
  JLabel message;
  Color backG = new Color(254, 248, 221);
  boolean includeCapitals, includeSymbols, includeNumbers = true;
  Checkings checks = new Checkings();

  String[] list = {"Create password here", "Create password in txt file"};

  public PasswordCreator() {
    // creating a JFrame
    JFrame frame = new JFrame("Password Creator");

    // adding some options to frame
    frame.setLayout(new FlowLayout());
    frame.setSize(500, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setBackground(backG);

    // configuring components
    buttonCreate = new JButton("GENERATE");
    buttonCreate.addActionListener(this);
    buttonCreate.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));

    capitals = new JCheckBox("capitals", true);
    capitals.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent event) {
        includeCapitals = true;
      }
    });
    capitals.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));

    symbols = new JCheckBox("symbols", true);
    symbols.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent event) {
        includeSymbols = true;
      }
    });
    symbols.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));

    numbers = new JCheckBox("numbers", true);
    numbers.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent event) {
        includeNumbers = true;
      }
    });
    numbers.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));

    password = new JTextField(20);
    password.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
    lengthOfPassword = new JTextField(5);
    lengthOfPassword.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));

    message = new JLabel("<html>Input here the length of the <br> password(10 by default)<html>");
    message.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));

    fileTXTOrHere = new JComboBox<String>(list);
    fileTXTOrHere.addActionListener(this);
    fileTXTOrHere.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));

    // adding components
    frame.add(capitals);
    frame.add(symbols);
    frame.add(numbers);
    frame.add(message);
    frame.add(lengthOfPassword);
    frame.add(fileTXTOrHere);
    frame.add(password);
    frame.add(buttonCreate);

    // making frame visible
    SwingUtilities.updateComponentTreeUI(frame); // making this app autoresizable
    frame.setVisible(true);
    frame.setResizable(false);
  }

  public void actionPerformed(ActionEvent ae) {
    if(ae.getActionCommand().equals("GENERATE")) {
      int length = 10;
      try {
        length = Integer.parseInt(lengthOfPassword.getText());
      } catch(NumberFormatException exc) {
        lengthOfPassword.setText("10");
      }
      password.setText("");
      if(capitals.isSelected() & symbols.isSelected() & numbers.isSelected()) {
        password.setText(checks.allOn(length));
      }

      if(!capitals.isSelected() & !symbols.isSelected() & !numbers.isSelected()) {
        password.setText(checks.allOFF(length));
      }

      if((!capitals.isSelected()) & symbols.isSelected() & numbers.isSelected()) {
        password.setText(checks.symbolsAndNumbersOn(length));
      }

      if(capitals.isSelected() & (!symbols.isSelected()) & numbers.isSelected()) {
        password.setText(checks.capitalsAndNumbersOn(length));
      }

      if(capitals.isSelected() & symbols.isSelected() & (!numbers.isSelected())) {
        password.setText(checks.capitalsAndSymbolsOn(length));
      }

      if((!capitals.isSelected()) & (!symbols.isSelected()) & numbers.isSelected()) {
        password.setText(checks.numbersOn(length));
      }

      if(capitals.isSelected() & (!symbols.isSelected()) & (!numbers.isSelected())) {
        password.setText(checks.capitalsOn(length));
      }

      if((!capitals.isSelected()) & symbols.isSelected() & (!numbers.isSelected())) {
        password.setText(checks.symbolsOn(length));
      }
    }
    if(fileTXTOrHere.getItemAt(fileTXTOrHere.getSelectedIndex()).equals(list[1])) {
      password.setText("Password is in password.txt");
      if(ae.getActionCommand().equals("GENERATE")) {
        String input = password.getText();
        try(FileWriter fw = new FileWriter("password.txt")) {
          int length = 10;
          try {
            length = Integer.parseInt(lengthOfPassword.getText());
          } catch(NumberFormatException exc) {
            lengthOfPassword.setText("10");
          }
          if(capitals.isSelected() & symbols.isSelected() & numbers.isSelected()) {
            fw.write(checks.allOn(length));
          }

          if(!capitals.isSelected() & !symbols.isSelected() & !numbers.isSelected()) {
            fw.write(checks.allOFF(length));
          }

          if((!capitals.isSelected()) & symbols.isSelected() & numbers.isSelected()) {
            fw.write(checks.symbolsAndNumbersOn(length));
          }

          if(capitals.isSelected() & (!symbols.isSelected()) & numbers.isSelected()) {
            fw.write(checks.capitalsAndNumbersOn(length));
          }

          if(capitals.isSelected() & symbols.isSelected() & (!numbers.isSelected())) {
            fw.write(checks.capitalsAndSymbolsOn(length));
          }

          if((!capitals.isSelected()) & (!symbols.isSelected()) & numbers.isSelected()) {
            fw.write(checks.numbersOn(length));
          }

          if(capitals.isSelected() & (!symbols.isSelected()) & (!numbers.isSelected())) {
            fw.write(checks.capitalsOn(length));
          }

          if((!capitals.isSelected()) & symbols.isSelected() & (!numbers.isSelected())) {
            fw.write(checks.symbolsOn(length));
          }
          fw.close();
        } catch(IOException exc) {
          password.setText("Input/Output exception");
        }
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
