package com.example.components;

import javax.swing.JTextField;
import java.awt.Font;

import com.example.constants.Colors;

public class MainTextField extends JTextField {
   final static Font titleFont = new Font("Poppins", Font.PLAIN, 13);

   public MainTextField(){
      setFont(titleFont);
      setBackground(Colors.mainWhite);
      setForeground(Colors.darkBlue);
      setBorder(null);
   }
}
