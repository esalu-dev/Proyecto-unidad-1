package com.esalu.components;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.esalu.Main;
import com.esalu.constants.Colors;

public class LogInFrame extends JFrame implements ActionListener {

   @Override
   public void actionPerformed(ActionEvent ev){
      Object obSource = ev.getSource();
      if(obSource == cancelButton){
         int opcion = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea salir?", "Salir", JOptionPane.YES_NO_OPTION);
         if(opcion == JOptionPane.YES_OPTION){
            System.exit(0);
         }
      }
      if(obSource == loginButton){
         Main.logIn(userField.getText(), new String(passwordField.getPassword()));
      }
   }

   final static Font titleFont = new Font("Poppins", Font.BOLD, 24);
   final static Font textFont = new Font("Poppins", Font.PLAIN, 14);
   final static Font textFont2 = new Font("Poppins", Font.PLAIN, 16);
   final static JLabel h1 = new JLabel("Bienvenido");
   final static JLabel h2 = new JLabel("Por favor, ingrese sus credenciales");
   final static JLabel h3 = new JLabel("Usuario");
   final static JLabel h4 = new JLabel("Contraseña");
   final static JButton loginButton = new JButton("Ingresar");
   final static JButton cancelButton = new JButton("Salir");
   final static ImageIcon icono = new ImageIcon("./icons/login_background_sized.png");
   final static JTextField userField = new JTextField();
   final static JPasswordField passwordField = new JPasswordField();
   final static JLabel background = new JLabel(icono);
   public LogInFrame() {
      super("Log In");
      setSize(900, 600);
      setUndecorated(true);
      //setAlwaysOnTop(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(null);
      setLocationRelativeTo(null);
      setResizable(false);
      getContentPane().setBackground(Colors.loginBlue);
      background.setBounds(450, 0, 450, 600);
      getContentPane().add(background);
      h1.setFont(titleFont);
      h1.setBounds(50, 50, 200, 50);
      h1.setForeground(Colors.mainWhite);
      h2.setFont(textFont);
      h2.setBounds(50, 100, 300, 50);
      h2.setForeground(Colors.mainWhite);
      h3.setFont(textFont2);
      h3.setBounds(50, 200, 100, 50);
      h3.setForeground(Colors.mainWhite);
      h4.setFont(textFont2);
      h4.setBounds(50, 300, 100, 50);
      h4.setForeground(Colors.mainWhite);
      loginButton.addActionListener(this);
      cancelButton.addActionListener(this);
      loginButton.setBounds(50, 470, 100, 40);
      loginButton.setBackground(Colors.mainWhite);
      loginButton.setForeground(Colors.loginBlue);
      cancelButton.setBounds(170, 470, 100, 40);
      cancelButton.setBackground(Colors.darkPurple);
      cancelButton.setForeground(Colors.mainWhite);
      cancelButton.setBorder(BorderFactory.createLineBorder(Colors.mainWhite, 2));
      loginButton.setFont(textFont);
      cancelButton.setFont(textFont);
      userField.setFont(textFont);
      userField.setBounds(50, 250, 300, 30);
      passwordField.setBounds(50, 350, 300, 30);
      getContentPane().add(userField);
      getContentPane().add(passwordField);
      getContentPane().add(loginButton);
      getContentPane().add(cancelButton);
      getContentPane().add(h3);
      getContentPane().add(h4);
      getContentPane().add(h1);
      getContentPane().add(h2);
   }
}
