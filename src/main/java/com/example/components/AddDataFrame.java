package com.example.components;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.example.Main;
import com.example.constants.Colors;
import com.example.providers.JSONManager;
import com.example.types.Mueble;


public class AddDataFrame extends JFrame {
   final static MainTitle titulo = new MainTitle("Añadir producto");
   final static MainTitle subtitulo = new MainTitle("Llena los campos para añadir un producto");
   final static MainLabel nombreLabel = new MainLabel("Nombre");
   final static MainTextField nombre = new MainTextField();
   final static MainLabel precioLabel = new MainLabel("Precio");
   final static MainTextField precio = new MainTextField();
   final static MainLabel cantidadLabel = new MainLabel("Cantidad");
   final static MainSpinner cantidad = new MainSpinner();
   final static MainLabel urlImagenLabel = new MainLabel("URL de la imagen");
   final static MainTextField urlImagen = new MainTextField();
   final static FormButton submitButton = new FormButton("Añadir", true);
   final static FormButton cancelButton = new FormButton("Cancelar", false);

   final ActionListener eventoCancel = new ActionListener() {
      public void actionPerformed(ActionEvent ev){
         if(ev.getSource().equals(cancelButton)){
            dispose();
         }
      }
   };
   final ActionListener eventoSubmit = new ActionListener() {
      public void actionPerformed(ActionEvent ev){
         if(ev.getSource().equals(submitButton)){
            try{
               Integer.parseInt(precio.getText());
            }catch(NumberFormatException e){
               JOptionPane.showMessageDialog(rootPane, "El precio debe ser un número", "Error", JOptionPane.INFORMATION_MESSAGE);
               return;
            }
            if(nombre.getText().equals("") || precio.getText().equals("") || urlImagen.getText().equals("")){
               JOptionPane.showMessageDialog(rootPane, "Por favor, llena todos los campos", "Error", JOptionPane.INFORMATION_MESSAGE);
               return;
            }
            if(Integer.parseInt(precio.getText()) <= 0){
               JOptionPane.showMessageDialog(rootPane, "El precio debe ser mayor a 0", "Error", JOptionPane.INFORMATION_MESSAGE);
               return;
            }
            if(Integer.parseInt(cantidad.getValue().toString()) <= 0){
               JOptionPane.showMessageDialog(rootPane, "La cantidad debe ser mayor a 0", "Error", JOptionPane.INFORMATION_MESSAGE);
               return;
            }
            
            
            Mueble mueble = new Mueble(nombre.getText(), Double.parseDouble(precio.getText()), Integer.parseInt(cantidad.getValue().toString()), urlImagen.getText());
            JSONManager.addDataToLocalJSON(mueble);
            JOptionPane.showMessageDialog(rootPane, "Registro agregado con éxito", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
            Main.inventario.refreshTable();
            dispose();
         }
      }
   };
   public void restartFields(){
      nombre.setText("");
      precio.setText("");
      cantidad.setValue(0);
      urlImagen.setText("");
   }

   public AddDataFrame(){
      super("Añadir un producto al inventario");
      restartFields();
      setAlwaysOnTop(true);
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
      nombreLabel.setBounds(20, 90, 100, 100);
      add(nombreLabel);
      nombre.setBounds(20, 150, 360, 30);
      add(nombre);
      precioLabel.setBounds(20, 170, 100, 100);
      add(precioLabel);
      precio.setBounds(20, 230, 360, 30);
      add(precio);
      cantidadLabel.setBounds(20, 250, 100, 100);
      add(cantidadLabel);
      cantidad.setBounds(20, 310, 360, 30);
      add(cantidad);
      urlImagenLabel.setBounds(20, 330, 150, 100);
      add(urlImagenLabel);
      urlImagen.setBounds(20, 390, 360, 30);
      add(urlImagen);
      submitButton.setBounds(20, 520, 150, 50);
      add(submitButton);
      cancelButton.setBounds(230, 520, 150, 50);
      add(cancelButton);
      cancelButton.addActionListener(eventoCancel);
      ActionListener[] listeners = submitButton.getActionListeners();
      for (ActionListener listener : listeners) {
         submitButton.removeActionListener(listener);
      }
      submitButton.addActionListener(eventoSubmit);


   }
}
