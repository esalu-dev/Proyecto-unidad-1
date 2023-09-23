package com.example.components;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;


public class ProductsPanel extends JPanel {
   Card card = new Card("Facebook", "$1000.50", "facebook.png", true);
   Card card2 = new Card("Google", "$2000.50", "google.png", false);
   final static GridLayout grid = new GridLayout(0, 2);
   public ProductsPanel(){
      setSize(1000, 500);
      setBackground(Color.WHITE);
      grid.setHgap(15); // Espacio horizontal entre celdas
      grid.setVgap(15);
      setLayout(grid);
      add(card);
      add(card2);
      for(int i = 0; i < 10; i++){
         add(new Card("Facebook", "$1000.50", "facebook.png", true));
      }
      
   }
}
