package com.example.pages;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.example.constants.Colors;



public class Configuration extends JPanel {

   final JLabel etiqueta = new JLabel("Panel configuración");
   
   

   public Configuration(){
     setSize(500, 500);
     setBackground(Colors.mainWhite);
     add(etiqueta);
   }
}
