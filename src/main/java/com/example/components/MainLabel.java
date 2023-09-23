package com.example.components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class MainLabel extends JLabel {
   Font font = new Font("Poppins", Font.PLAIN, 14);
   Color colorBlancoTranslucido = new Color(255, 255, 255, 150);
   public MainLabel(String text){
      super(text);
      setFont(font);
      setForeground(colorBlancoTranslucido);
   }
}
