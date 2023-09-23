package com.example.components;

import java.awt.Font;

import javax.swing.JButton;

import com.example.constants.Colors;

public class CardButton extends JButton {
   final static Font titleFont = new Font("Poppins", Font.BOLD, 13);
   public CardButton(String text){
      super(text);
      buildButton();
   }
   public CardButton(){
      super("Añadir");
      buildButton();
   }
   public void setButtonEnabled(boolean enabled){
      setEnabled(enabled);
      if(enabled){
         this.setText("Añadir");
         setBackground(Colors.mainGreen);
      }else{
         this.setText("No disponible");
         setBackground(Colors.lightPurple);
      }
   }
   public void buildButton(){
      setBackground(Colors.mainGreen);
      setForeground(Colors.mainWhite);
      setFocusPainted(false);
      setBorderPainted(false);
      setFont(titleFont);
   }
}
