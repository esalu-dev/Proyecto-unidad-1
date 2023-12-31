package com.esalu.components;


import javax.swing.JButton;

import com.esalu.constants.Colors;


public class FormButton extends JButton  {
   public FormButton(String text, boolean isSubmit){
      super(text);
      setFont(MainTextField.titleFont);
      setBorder(null);
      setFocusable(false);
      if(isSubmit){
         setBackground(Colors.mainWhite);
         setForeground(Colors.mainBlue);
      }
      else{
         setBackground(Colors.mainBlue);
         setForeground(Colors.mainWhite);
      }
   }
   
}
