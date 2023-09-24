package com.example.pages;

import java.awt.ScrollPane;

import javax.swing.JPanel;

import com.example.components.CartPanel;
import com.example.components.MainTitle;
import com.example.components.ProductsPanel;
import com.example.constants.Colors;

public class Ventas extends JPanel {
  final static MainTitle etiqueta = new MainTitle("Ventas");
  public final static ProductsPanel productsPanel = new ProductsPanel();

  final static ScrollPane scroll = new ScrollPane();
  public final static CartPanel cartPanel = new CartPanel();


  public Ventas(){
    setSize(500, 500);
    scroll.setSize(500, 500);
    scroll.add(productsPanel);
    setBackground(Colors.mainWhite);
    setLayout(null);
    etiqueta.setForeground(Colors.lightPurple);
    etiqueta.setBounds(50, 50, 200, 50);
    add(etiqueta);
    scroll.setBounds(50, 100, 550, 500);
    add(scroll);
    cartPanel.setBounds(630, 100, 300, 500);
    add(cartPanel);
    
  }
}

