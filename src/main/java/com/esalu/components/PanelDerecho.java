package com.esalu.components;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.esalu.Main;
import com.esalu.constants.Colors;
import com.esalu.constants.CustomBorder;

public class PanelDerecho extends JPanel {

   final static ActionListener ventasAction = e -> {
      Main.changePaneltoVentas();
   };
   final static ActionListener inventarioAction = e -> {
      Main.changePaneltoInventario();
   };
   final static ActionListener configuracionAction = e -> {
      Main.changePaneltoConfiguracion();
   };

   final static JLabel titulo = new JLabel("Mueblería");
   final static JLabel titulo2 = new JLabel("Salas Luján");
   final static Font titleFont = new Font("Poppins", Font.BOLD, 20);
   final static SectionButton ventas = new SectionButton("Ventas", ventasAction, new CustomBorder(Colors.darkPurple, Colors.lightPurple,Colors.lightPurple,Colors.lightPurple, 3));
   final static SectionButton inventario = new SectionButton("Inventario", inventarioAction, new CustomBorder(Colors.darkPurple, Colors.lightPurple,Colors.lightPurple,Colors.lightPurple, 3));
   final static SectionButton configuracion = new SectionButton("Configuración", configuracionAction, new CustomBorder(Colors.darkPurple, Colors.darkPurple,Colors.lightPurple,Colors.lightPurple, 3));

   public PanelDerecho(){
      setLayout(null);
      setSize(300,720);
      setBackground(Colors.lightPurple);
      titulo.setBounds(97, 50, 200, 50);
      titulo.setForeground(Colors.mainWhite);
      titulo.setFont(titleFont);
      titulo2.setBounds(92, 80, 200, 50);
      titulo2.setForeground(Colors.mainWhite);
      titulo2.setFont(titleFont);
      add(titulo);
      add(titulo2);
      ventas.setBounds(0, 200, 300, 120);
      add(ventas);
      inventario.setBounds(0, 320, 300, 120);
      add(inventario);
      configuracion.setBounds(0, 440, 300, 120);
      add(configuracion);
   }
   
}
