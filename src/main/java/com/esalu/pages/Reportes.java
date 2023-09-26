package com.esalu.pages;
import java.awt.Font;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import com.esalu.components.MainTitle;
import com.esalu.components.VentasTable;
import com.esalu.constants.Colors;
import com.esalu.providers.JSONVentas;



public class Reportes extends JPanel {

  final static MainTitle etiqueta = new MainTitle("Reportes");
  public final static VentasTable tabla = new VentasTable();
  final static JLabel total = new JLabel("Total: ");
  final static JLabel todayTotal = new JLabel("Total de hoy: ");
  final static Font font = new Font("Poppins", Font.PLAIN, 18);
  final static Date today = new Date(System.currentTimeMillis());
  final static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");


  public static void updateTotal(){
    double total = 0;
    double totalHoy = 0;
    List<com.esalu.types.Ventas> ventas = JSONVentas.getDataFromLocalJSON();
    String todayString = dateFormat.format(today);
    System.out.println(todayString);
    for(com.esalu.types.Ventas venta : ventas){
      total += venta.getTotalPrice();
      System.out.println(venta.getDate());
      if(venta.getDate().equals(todayString)){
        totalHoy += venta.getTotalPrice();
      }
    }

    Reportes.total.setText("Total: " + total);
    Reportes.todayTotal.setText("Total de hoy: " + totalHoy);
  }
   

   public Reportes(){
     setSize(500, 500);
     setBackground(Colors.mainWhite);
     setLayout(null);
     etiqueta.setForeground(Colors.lightPurple);
     etiqueta.setBounds(50, 50, 200, 50); 
     add(etiqueta);
     tabla.setBounds(50, 100, 840, 450);
     add(tabla);
     updateTotal();
      total.setBounds(50, 550, 200, 50);
      total.setFont(font);
      total.setForeground(Colors.mainBlue);
      add(total);
      todayTotal.setBounds(50, 600, 200, 50);
      todayTotal.setFont(font);
      todayTotal.setForeground(Colors.mainBlue);
      add(todayTotal);
     
 
   }
   
}
