package com.example.pages;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.example.constants.Colors;

public class Ventas extends JPanel {
   final JLabel etiqueta = new JLabel("Panel ventas");
   public Ventas(){
     setSize(500, 500);
     setBackground(Colors.mainWhite);
     add(etiqueta);
   }
}
