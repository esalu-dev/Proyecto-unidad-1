package com.example.pages;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.example.constants.Colors;



public class Inventario extends JPanel {

   final JLabel etiqueta = new JLabel("Panel inventario");
   
   

   public Inventario(){
     setSize(500, 500);
     setBackground(Colors.mainWhite);
     add(etiqueta);
   }
}
