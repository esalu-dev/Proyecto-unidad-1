package com.esalu.components;

import java.awt.Font;

import javax.swing.JLabel;

import com.esalu.constants.Colors;

public class MainTitle extends JLabel {
   final static Font titleFont = new Font("Poppins", Font.BOLD, 24);
   public MainTitle(String text){
      super(text);
      setForeground(Colors.mainWhite);
      setFont(titleFont);
   }
}
