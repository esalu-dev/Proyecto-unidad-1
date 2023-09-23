package com.example.components;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.example.constants.Colors;


public class AddDataFrame extends JFrame {
   final static MainTitle titulo = new MainTitle("Añadir producto");
   final static MainTitle subtitulo = new MainTitle("Llena los campos para añadir un producto");
   final static MainLabel nombreLabel = new MainLabel("Nombre");
   final static MainTextField nombre = new MainTextField();
   final static MainLabel idLabel = new MainLabel("ID");
   final static MainSpinner id = new MainSpinner();
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
            JOptionPane.showMessageDialog(rootPane, "Registro agregado con éxito", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
            dispose();
         }
      }
   };

   public AddDataFrame(){
      super("Añadir un producto al inventario");
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
      idLabel.setBounds(20, 170, 100, 100);
      add(idLabel);
      id.setBounds(20, 230, 360, 30);
      add(id);
      precioLabel.setBounds(20, 250, 100, 100);
      add(precioLabel);
      precio.setBounds(20, 310, 360, 30);
      add(precio);
      cantidadLabel.setBounds(20, 330, 100, 100);
      add(cantidadLabel);
      cantidad.setBounds(20, 390, 360, 30);
      add(cantidad);
      urlImagenLabel.setBounds(20, 410, 150, 100);
      add(urlImagenLabel);
      urlImagen.setBounds(20, 470, 360, 30);
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
