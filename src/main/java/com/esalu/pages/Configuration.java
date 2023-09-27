package com.esalu.pages;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.esalu.components.AddUserFrame;
import com.esalu.components.DeleteUserFrame;
import com.esalu.components.MainTitle;
import com.esalu.constants.Colors;



public class Configuration extends JPanel {

    final static MainTitle etiqueta = new MainTitle("Configuración");

    final static JButton addUserButton = new JButton("Añadir usuario");
    final static JButton deleteUserButton = new JButton("Eliminar usuario");
    final static JButton logOutButton = new JButton("Cerrar sesión");

    final static JLabel userSectionLabel = new JLabel("Sección de usuarios");
    final static JLabel systemSectionLabel = new JLabel("Sección de sistema");

    final static JLabel programVersion = new JLabel("Versión del programa: 1.0.0");


   
   

   public Configuration(){
     setSize(500, 500);
     setBackground(Colors.mainWhite);
     setLayout(null);
     addUserButton.setBackground(Colors.mainBlue);
      addUserButton.setForeground(Colors.mainWhite);

      deleteUserButton.setBackground(Color.RED);
      deleteUserButton.setForeground(Colors.mainWhite);

      logOutButton.setBackground(Colors.darkBlue);
      logOutButton.setForeground(Colors.mainWhite);

      userSectionLabel.setBounds(50, 100, 200, 50);
      userSectionLabel.setForeground(Color.GRAY);
      userSectionLabel.setFont(new Font("Poppins", Font.PLAIN, 12));
      systemSectionLabel.setBounds(50, 300, 200, 50);
      systemSectionLabel.setForeground(Color.GRAY);
      systemSectionLabel.setFont(new Font("Poppins", Font.PLAIN, 12));
      addUserButton.setBounds(50, 150, 200, 50);
      deleteUserButton.setBounds(300, 150, 200, 50);
      logOutButton.setBounds(50, 350, 200, 50);
      addUserButton.setFont(new Font("Poppins", Font.PLAIN, 14));
      deleteUserButton.setFont(new Font("Poppins", Font.PLAIN, 14));
      programVersion.setBounds(780, 630, 200, 50);
      programVersion.setForeground(Color.GRAY);
      programVersion.setFont(new Font("Poppins", Font.PLAIN, 12));
      logOutButton.setFont(new Font("Poppins", Font.PLAIN, 14));
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
      logOutButton.addActionListener(new java.awt.event.ActionListener(){
         public void actionPerformed(java.awt.event.ActionEvent e){
            int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas cerrar sesión?\n(Atención: Se cerrará el programa y tendrá que abrirlo manualmente)", "Cerrar sesión", JOptionPane.YES_NO_OPTION);
            if(opcion != JOptionPane.YES_OPTION){
               return;
            }
            System.exit(0);
         }
      });
     etiqueta.setForeground(Colors.lightPurple);
     etiqueta.setBounds(50, 50, 200, 50); 
     add(etiqueta);
      add(userSectionLabel);
      add(addUserButton);
      add(deleteUserButton);
      add(systemSectionLabel);
      add(logOutButton);
      add(programVersion);
   }
}
