package com.example.components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CartDeleteButton extends JButton {
   final static ImageIcon icono = new ImageIcon("./icons/delete.png");
   final static Font titleFont = new Font("Poppins", Font.PLAIN, 18);
   public CartDeleteButton(){
      super(icono);
      setFont(titleFont);
      setBackground(Color.RED);
      setBorderPainted(false);
      setForeground(Color.WHITE);
      
   }
}
