package com.example.components;

import java.awt.Font;

import javax.swing.JLabel;

import com.example.constants.Colors;

public class MainTitle extends JLabel {
   final static Font titleFont = new Font("Poppins", Font.BOLD, 24);
   public MainTitle(String text){
      super(text);
      setForeground(Colors.mainWhite);
      setFont(titleFont);
   }
}
