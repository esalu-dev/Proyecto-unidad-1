package com.example.pages;

import javax.swing.JPanel;
import com.example.components.MainTitle;
import com.example.constants.Colors;

public class Inventario extends JPanel {

  final static MainTitle titulo = new MainTitle("Inventario");

  public Inventario(){
    setSize(500, 500);
    setBackground(Colors.mainWhite);
    setLayout(null);
    titulo.setForeground(Colors.lightPurple);
    titulo.setBounds(50, 50, 200, 50);
    add(titulo);
  }
}
