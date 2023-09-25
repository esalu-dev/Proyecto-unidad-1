package com.esalu.components;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.esalu.constants.Colors;
import com.esalu.constants.CustomBorder;

public class SectionButton extends JButton {
   final static Font titleFont = new Font("Poppins", Font.PLAIN, 18);
   public SectionButton(String text, ActionListener action, CustomBorder borde){
      super(text);
      setFocusable(false);
      setFont(titleFont);
      setContentAreaFilled(false);
      setOpaque(false);
      setForeground(Colors.mainWhite);
      setSize(300, 120);
      setBorder(borde);
      addActionListener(action);
   }
}
