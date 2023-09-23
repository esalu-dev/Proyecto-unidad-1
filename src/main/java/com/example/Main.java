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

    public final static JFrame ventana = new JFrame("Sistema Mueblería Salas Luján");
    final static Inventario inventario = new Inventario();
    final static Ventas ventas = new Ventas();
    final static Configuration configuracion = new Configuration();

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
        inventario.setBounds(300, 0, 967, 683);
        ventana.getContentPane().add(inventario);
        ventana.revalidate();
        ventana.repaint();
    }
    public static void changePaneltoVentas(){
        ventana.getContentPane().removeAll();
        ventana.getContentPane().add(new PanelDerecho());
        ventas.setBounds(300, 0, 967, 683);
        ventana.getContentPane().add(ventas);
        ventana.revalidate();
        ventana.repaint();
    }
    public static void changePaneltoConfiguracion(){
        ventana.getContentPane().removeAll();
        ventana.getContentPane().add(new PanelDerecho());
        configuracion.setBounds(300, 0, 967, 683);
        ventana.getContentPane().add(configuracion);
        ventana.revalidate();
        ventana.repaint();
    }
    public static void main(String[] args) {
        setDesign();
        ventana.setResizable(false);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(1280, 720);
        ventana.setLayout(null);
        changePaneltoInventario();
        
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }


}