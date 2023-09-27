package com.esalu.components;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolTip;

import com.esalu.Main;
import com.esalu.constants.Colors;
import com.esalu.constants.CustomBorder;

public class PanelDerecho extends JPanel {
   
   final static ActionListener ventasAction = e -> {
      Main.changePaneltoVentas();
      PanelDerecho.ventas.isSelected(true);
      PanelDerecho.inventario.isSelected(false);
      PanelDerecho.configuracion.isSelected(false);
      PanelDerecho.reportes.isSelected(false);
   };
   final static ActionListener inventarioAction = e -> {
      Main.changePaneltoInventario();
      PanelDerecho.inventario.isSelected(true);
      PanelDerecho.ventas.isSelected(false);
      PanelDerecho.configuracion.isSelected(false);
      PanelDerecho.reportes.isSelected(false);
   };
   final static ActionListener configuracionAction = e -> {
      Main.changePaneltoConfiguracion();
      PanelDerecho.configuracion.isSelected(true);
      PanelDerecho.inventario.isSelected(false);
      PanelDerecho.ventas.isSelected(false);
      PanelDerecho.reportes.isSelected(false);
   };
   final static ActionListener reportesAction = e -> {
      Main.changePaneltoReportes();
      PanelDerecho.reportes.isSelected(true);
      PanelDerecho.inventario.isSelected(false);
      PanelDerecho.configuracion.isSelected(false);
      PanelDerecho.ventas.isSelected(false);
   };
   
   final static JLabel titulo = new JLabel("Mueblería");
   final static JLabel titulo2 = new JLabel("Salas Luján");
   final static Font titleFont = new Font("Poppins", Font.BOLD, 20);
   final static SectionButton ventas = new SectionButton("Ventas", ventasAction, new CustomBorder(Colors.darkPurple, Colors.lightPurple,Colors.lightPurple,Colors.lightPurple, 3));
   final static SectionButton inventario = new SectionButton("Inventario", inventarioAction, new CustomBorder(Colors.darkPurple, Colors.lightPurple,Colors.lightPurple,Colors.lightPurple, 3));
   final static SectionButton configuracion = new SectionButton("Configuración", configuracionAction, new CustomBorder(Colors.darkPurple, Colors.lightPurple,Colors.lightPurple,Colors.lightPurple, 3));
   final static SectionButton reportes = new SectionButton("Reportes", reportesAction, new CustomBorder(Colors.darkPurple, Colors.lightPurple,Colors.lightPurple,Colors.lightPurple, 3));

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
      ventas.setToolTipText("Abrir sección de ventas");
      add(ventas);
      inventario.setBounds(0, 320, 300, 120);
      inventario.setToolTipText("Abrir sección de inventario");
      add(inventario);
      reportes.setBounds(0, 440, 300, 120);
      reportes.setToolTipText("Abrir sección de reportes");
      add(configuracion);
      configuracion.setBounds(0, 560, 300, 120);
      configuracion.setToolTipText("Abrir sección de configuración");
      add(reportes);
   }
   
}
