package com.esalu.pages;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.esalu.components.AddUserFrame;
import com.esalu.components.DeleteUserFrame;
import com.esalu.components.MainTitle;
import com.esalu.constants.Colors;



public class Configuration extends JPanel {

    final static MainTitle etiqueta = new MainTitle("Configuración");

    final static JButton addUserButton = new JButton("Añadir usuario");
    final static JButton deleteUserButton = new JButton("Eliminar usuario");

    final static JLabel userSectionLabel = new JLabel("Sección de usuarios");

   
   

   public Configuration(){
     setSize(500, 500);
     setBackground(Colors.mainWhite);
     setLayout(null);
     addUserButton.setBackground(Colors.mainBlue);
      addUserButton.setForeground(Colors.mainWhite);

      deleteUserButton.setBackground(Color.RED);
      deleteUserButton.setForeground(Colors.mainWhite);

      userSectionLabel.setBounds(50, 100, 200, 50);
      userSectionLabel.setForeground(Color.GRAY);
      userSectionLabel.setFont(new Font("Poppins", Font.PLAIN, 12));
      addUserButton.setBounds(50, 150, 200, 50);
      deleteUserButton.setBounds(300, 150, 200, 50);
      addUserButton.setFont(new Font("Poppins", Font.PLAIN, 14));
      deleteUserButton.setFont(new Font("Poppins", Font.PLAIN, 14));
      addUserButton.addActionListener(new java.awt.event.ActionListener(){
         public void actionPerformed(java.awt.event.ActionEvent e){
            new AddUserFrame().setVisible(true);
         }
      });
      deleteUserButton.addActionListener(new java.awt.event.ActionListener(){
         public void actionPerformed(java.awt.event.ActionEvent e){
            new DeleteUserFrame().setVisible(true);
         }
      });
     etiqueta.setForeground(Colors.lightPurple);
     etiqueta.setBounds(50, 50, 200, 50); 
     add(etiqueta);
      add(userSectionLabel);
      add(addUserButton);
      add(deleteUserButton);
   }
}
