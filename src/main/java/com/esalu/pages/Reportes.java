package com.esalu.pages;
import javax.swing.JPanel;
import com.esalu.components.MainTitle;
import com.esalu.constants.Colors;



public class Reportes extends JPanel {

    final static MainTitle etiqueta = new MainTitle("Reportes");

   
   

   public Reportes(){
     setSize(500, 500);
     setBackground(Colors.mainWhite);
     setLayout(null);
     etiqueta.setForeground(Colors.lightPurple);
     etiqueta.setBounds(50, 50, 200, 50); 
     add(etiqueta);
   }
   
}
