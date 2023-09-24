package com.example.components;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CartDeleteButton extends JButton {
   final static ImageIcon icono = new ImageIcon("./icons/delete.png");
   public CartDeleteButton(){
      super(icono);
      setBackground(Color.RED);
      setBorderPainted(false);
      
   }
}
