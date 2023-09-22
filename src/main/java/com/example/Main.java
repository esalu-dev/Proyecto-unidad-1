package com.example;


import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.example.components.PanelDerecho;
import com.example.pages.Configuration;
import com.example.pages.Inventario;
import com.example.pages.Ventas;

import mdlaf.MaterialLookAndFeel;


public class Main {

    final static JFrame ventana = new JFrame("Inventario");

    public static void setDesign(){
        try {
            Font defaultFont = new Font("Poppins", Font.PLAIN, 14);
            UIManager.put("Button.font", defaultFont); 
            UIManager.put("Label.font", defaultFont);
            UIManager.put("TextField.font", defaultFont);
            UIManager.put("TextArea.font", defaultFont);
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }
    public static void changePaneltoInventario(){
        ventana.getContentPane().removeAll();
        ventana.getContentPane().add(new PanelDerecho());
        ventana.getContentPane().add(new Inventario());
        ventana.revalidate();
        ventana.repaint();
    }
    public static void changePaneltoVentas(){
        ventana.getContentPane().removeAll();
        ventana.getContentPane().add(new PanelDerecho());
        ventana.getContentPane().add(new Ventas());
        ventana.revalidate();
        ventana.repaint();
    }
    public static void changePaneltoConfiguracion(){
        ventana.getContentPane().removeAll();
        ventana.getContentPane().add(new PanelDerecho());
        ventana.getContentPane().add(new Configuration());
        ventana.revalidate();
        ventana.repaint();
    }
    public static void main(String[] args) {
        setDesign();
        
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(1280, 720);
        ventana.getContentPane().add(new PanelDerecho());
        ventana.getContentPane().add(new Inventario());
        
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }


}