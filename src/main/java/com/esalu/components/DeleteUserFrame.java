package com.esalu.components;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import com.esalu.constants.AppIcon;
import com.esalu.constants.Colors;
import com.esalu.providers.JSONLogIn;

public class DeleteUserFrame extends JFrame {
   final static MainTitle titulo = new MainTitle("Eliminar usuario");
   final static MainTitle subtitulo = new MainTitle("Llena los campos para eliminar un usuario");
   final static MainLabel userLabel = new MainLabel("Usuario");
   final static MainTextField user = new MainTextField();
   final static MainLabel passwordLabel = new MainLabel("Password");
   final static JPasswordField password = new JPasswordField();
   

   final static FormButton submitButton = new FormButton("Eliminar", true);
   final static FormButton cancelButton = new FormButton("Cancelar", false);

   final ActionListener submitListener = new ActionListener(){
      public void actionPerformed(java.awt.event.ActionEvent e){
      if(user.getText().equals("") || new String(password.getPassword()).equals("")){
         JOptionPane.showMessageDialog(null, "Por favor llena todos los campos", "Error", JOptionPane.INFORMATION_MESSAGE);
         return;
      }
      
      else{
         int status = JSONLogIn.deleteUserFromLocalJSON(user.getText(), new String(password.getPassword()));
         if(status == 1){
            JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            dispose();
         }
         else if(status == 0){
            JOptionPane.showMessageDialog(null, "Datos incorrectos", "Error", JOptionPane.INFORMATION_MESSAGE);
         }
         else{
            JOptionPane.showMessageDialog(null, "Error desconocido", "Error", JOptionPane.INFORMATION_MESSAGE);
         }
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
   }

   public DeleteUserFrame(){
      super("Eliminar usuario");
      // setAlwaysOnTop(true);
      restartFields();
      subtitulo.setFont(new Font("Poppins", Font.PLAIN, 12));
      setResizable(false);
      setUndecorated(true);
      setSize(400,600);
      setLocationRelativeTo(null);
      getContentPane().setBackground(Colors.lightBlue);
      setLayout(null);
      setIconImage(AppIcon.appIcon.getImage());
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
