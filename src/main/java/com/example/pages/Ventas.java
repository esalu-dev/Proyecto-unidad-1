package com.example.pages;

import java.awt.Color;
import java.awt.ScrollPane;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.example.components.CartPanel;
import com.example.components.MainTitle;
import com.example.components.ProductsPanel;
import com.example.constants.Colors;

public class Ventas extends JPanel {
  final static MainTitle etiqueta = new MainTitle("Ventas");
  public final static ProductsPanel productsPanel = new ProductsPanel();
  private static ImageIcon deleteIcon = new ImageIcon("./icons/delete.png");
  private static JButton deleteButton = new JButton(deleteIcon);

  final static ScrollPane scroll = new ScrollPane();
  public final static CartPanel cartPanel = new CartPanel();

  public void styleButton(){
    deleteButton.setBackground(Color.RED);
    deleteButton.setBorder(null);

  }

  public Ventas(){
    setSize(500, 500);
    styleButton();
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
    deleteButton.setBounds(882, 610, 45, 45);
    add(deleteButton);
  }
}

