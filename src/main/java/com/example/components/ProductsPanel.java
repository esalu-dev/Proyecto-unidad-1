package com.example.components;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import com.example.providers.JSONManager;
import com.example.types.Mueble;


public class ProductsPanel extends JPanel {
   final static GridLayout grid = new GridLayout(0, 2);

   public void getData(){
      this.removeAll();
      int index=0;
      for(Mueble mueble : JSONManager.getDataFromLocalJSON()){
         add(new Card(mueble.getNombre(), String.valueOf(mueble.getPrecio()), mueble.getImgLink(),mueble.getCantidad() , mueble.isAvailable(), index));
         index++;
         this.revalidate();
         this.repaint();
      }

   }

   public ProductsPanel(){
      setSize(1000, 500);
      setBackground(Color.WHITE);
      grid.setHgap(15); // Espacio horizontal entre celdas
      grid.setVgap(15);
      setLayout(grid);
      getData();
      
   }
}
