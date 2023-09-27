package com.esalu.components;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import com.esalu.constants.Colors;
import com.esalu.providers.JSONLogIn;
import com.esalu.types.Users;

public class AddUserFrame extends JFrame {
   final static MainTitle titulo = new MainTitle("Añadir usuario");
   final static MainTitle subtitulo = new MainTitle("Llena los campos para añadir un usuario");
   final static MainLabel userLabel = new MainLabel("Usuario");
   final static MainTextField user = new MainTextField();
   final static MainLabel passwordLabel = new MainLabel("Password");
   final static JPasswordField password = new JPasswordField();
   final static MainLabel permisosLabel = new MainLabel("Permisos");
   final static JCheckBox allowVentas = new JCheckBox("Ver y editar Ventas");
   final static JCheckBox allowInventario = new JCheckBox("Ver y editar Inventario");
   final static JCheckBox allowConfiguracion = new JCheckBox("Ver y editar Configuración");
   final static JCheckBox allowReportes = new JCheckBox("Ver y editar Reportes");

   final static FormButton submitButton = new FormButton("Añadir", true);
   final static FormButton cancelButton = new FormButton("Cancelar", false);

   final ActionListener submitListener = new ActionListener(){
      public void actionPerformed(java.awt.event.ActionEvent e){
      if(user.getText().equals("") || new String(password.getPassword()).equals("")){
         JOptionPane.showMessageDialog(null, "Por favor llena todos los campos", "Error", JOptionPane.INFORMATION_MESSAGE);
         return;
      }
      if(!allowVentas.isSelected() && !allowInventario.isSelected() && !allowConfiguracion.isSelected() && !allowReportes.isSelected()){
         int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres crear un usuario sin permisos?", "Confirmación", JOptionPane.YES_NO_OPTION);
         if(opcion != JOptionPane.YES_OPTION){
            return;
         }
         else{
            int userExists = JSONLogIn.checkUserInLocalJSON(user.getText());
            if(userExists==1){
               JOptionPane.showMessageDialog(null, "El nombre de usuario ya está ocupado", "Error", JOptionPane.INFORMATION_MESSAGE);
               return;
            }
            Users newUser = new Users(user.getText(), new String(password.getPassword()), false, false, false, false);
            JSONLogIn.addDataToLocalJSON(newUser);
            JOptionPane.showMessageDialog(null, "Usuario añadido correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            dispose();
         }
      }
      else{
         int userExists = JSONLogIn.checkUserInLocalJSON(user.getText());
         if(userExists==1){
            JOptionPane.showMessageDialog(null, "El nombre de usuario ya está ocupado", "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
         }
         Users newUser = new Users(user.getText(), new String(password.getPassword()), allowVentas.isSelected(), allowInventario.isSelected(), allowConfiguracion.isSelected(), allowReportes.isSelected());
         JSONLogIn.addDataToLocalJSON(newUser);
         JOptionPane.showMessageDialog(null, "Usuario añadido correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
         dispose();
      }
      }
   };

   final ActionListener cancelListener = new ActionListener(){
      public void actionPerformed(java.awt.event.ActionEvent e){
         dispose();
      }
   };

   public void restartFields(){
      user.setText("");
      password.setText("");
      allowVentas.setSelected(false);
      allowInventario.setSelected(false);
      allowConfiguracion.setSelected(false);
      allowReportes.setSelected(false);
   }

   public AddUserFrame(){
      super("Añadir usuario");
      // setAlwaysOnTop(true);
      restartFields();
      subtitulo.setFont(new Font("Poppins", Font.PLAIN, 12));
      setResizable(false);
      setUndecorated(true);
      setSize(400,600);
      setLocationRelativeTo(null);
      getContentPane().setBackground(Colors.lightBlue);
      setLayout(null);
      titulo.setBounds(20, 0, 400, 100);
      add(titulo);
      subtitulo.setBounds(20, 35, 400, 100);
      add(subtitulo);
      userLabel.setBounds(20, 90, 400, 100);
      add(userLabel);
      user.setBounds(20, 150, 360, 30);
      add(user);
      passwordLabel.setBounds(20, 170, 400, 100);
      add(passwordLabel);
      password.setBounds(20, 230, 360, 30);
      add(password);
      permisosLabel.setBounds(20, 250, 400, 100);
      add(permisosLabel);
      allowVentas.setBackground(Colors.lightBlue);
      allowInventario.setBackground(Colors.lightBlue);
      allowConfiguracion.setBackground(Colors.lightBlue);
      allowReportes.setBackground(Colors.lightBlue);
      allowVentas.setFont(new Font("Poppins", Font.PLAIN, 13));
      allowInventario.setFont(new Font("Poppins", Font.PLAIN, 13));
      allowConfiguracion.setFont(new Font("Poppins", Font.PLAIN, 13));
      allowReportes.setFont(new Font("Poppins", Font.PLAIN, 13));
      allowVentas.setForeground(Colors.mainWhite);
      allowInventario.setForeground(Colors.mainWhite);
      allowConfiguracion.setForeground(Colors.mainWhite);
      allowReportes.setForeground(Colors.mainWhite);
      allowVentas.setBounds(20, 310, 360, 30);
      add(allowVentas);
      allowInventario.setBounds(20, 350, 360, 30);
      add(allowInventario);
      allowConfiguracion.setBounds(20, 390, 360, 30);
      add(allowConfiguracion);
      allowReportes.setBounds(20, 430, 360, 30);
      add(allowReportes);
      submitButton.setBounds(20, 520, 150, 50);
      add(submitButton);
      cancelButton.setBounds(230, 520, 150, 50);
      add(cancelButton);
      cancelButton.addActionListener(cancelListener);
      ActionListener[] listeners = submitButton.getActionListeners();
      for (ActionListener listener : listeners) {
         submitButton.removeActionListener(listener);
      }
      submitButton.addActionListener(submitListener);
      
   }
   
}
