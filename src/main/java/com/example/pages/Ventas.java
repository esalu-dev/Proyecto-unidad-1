package com.example.pages;

import java.awt.Font;
import java.awt.ScrollPane;
import java.text.NumberFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.example.components.CartPanel;
import com.example.components.MainTitle;
import com.example.components.ProductsPanel;
import com.example.constants.Colors;

public class Ventas extends JPanel {
  final static MainTitle etiqueta = new MainTitle("Ventas");
  public final static ProductsPanel productsPanel = new ProductsPanel();
  final static Font titleFont = new Font("Poppins", Font.PLAIN, 14);

  final static ScrollPane scroll = new ScrollPane();
  public final static CartPanel cartPanel = new CartPanel();

  final static JLabel totalLabel = new JLabel("Total: ");
  static double priceToPay = 0;
  static NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();

  public static void addTotal (double total) {
    priceToPay += total;
    String totalPriceString = currencyFormatter.format(priceToPay);
    totalLabel.setText("Total: " + totalPriceString);
  }
  public static void removeTotal (double total) {
    priceToPay -= total;
    String totalPriceString = currencyFormatter.format(priceToPay);
    totalLabel.setText("Total: " + totalPriceString);
  }


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
    cartPanel.setBounds(630, 100, 300, 450);
    add(cartPanel);
    
    totalLabel.setFont(titleFont);
    totalLabel.setForeground(Colors.mainBlue);
    totalLabel.setBounds(630, 550, 300, 50);
    add(totalLabel);
    
  }
}

