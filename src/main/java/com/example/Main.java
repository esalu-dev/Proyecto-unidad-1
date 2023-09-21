package com.example;


import javax.swing.JFrame;

import com.example.components.PanelDerecho;
import com.example.pages.Inventario;


public class Main {

    final static JFrame ventana = new JFrame("Inventario");
    public static void main(String[] args) {
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(1280, 720);
        ventana.getContentPane().add(new PanelDerecho());
        ventana.getContentPane().add(new Inventario());
        ventana.setVisible(true);
    }
}