package com.example.components;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.example.constants.Colors;

public class ProductsPanel extends JPanel {
   Card card = new Card("Facebook", "$1000.50", "facebook.png");
   public ProductsPanel(){
      setBackground(Color.WHITE);
      setLayout(new GridLayout(20, 2));
      add(card);
   }
}
