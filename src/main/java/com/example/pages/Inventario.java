package com.example.pages;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;


public class Inventario extends JFrame {
   final static JButton boton = new JButton("Botón");
   public Inventario(){
      super("Inventario");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      getContentPane().add(boton);
      setSize(400,400);
   }
}
