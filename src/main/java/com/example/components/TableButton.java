package com.example.components;

import java.awt.Font;

import javax.swing.JButton;


public class TableButton extends JButton {
   final static Font titleFont = new Font("Poppins", Font.PLAIN, 14);
   public TableButton(String text){
      super(text);
      setFont(titleFont);
   }
   
}
