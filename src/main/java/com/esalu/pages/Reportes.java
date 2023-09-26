package com.esalu.pages;
import java.awt.Font;
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
  final static Font font = new Font("Poppins", Font.PLAIN, 18);

  public static void updateTotal(){
    double total = 0;
    List<com.esalu.types.Ventas> ventas = JSONVentas.getDataFromLocalJSON();
    for(com.esalu.types.Ventas venta : ventas){
      total += venta.getTotalPrice();
    }
    Reportes.total.setText("Total: " + total);
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
     
 
   }
   
}
