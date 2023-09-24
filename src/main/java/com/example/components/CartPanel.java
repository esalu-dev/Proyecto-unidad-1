package com.example.components;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import com.example.Main;
import com.example.constants.Colors;
import com.example.types.Mueble;

public class CartPanel extends ScrollPane {
   final static Font titleFont = new Font("Poppins", Font.PLAIN, 12);

   
   static JPanel panel = new JPanel();
   static int index = 0;
   static ArrayList<Integer> indexList = new ArrayList<Integer>();
   public static void addProduct(Mueble mueble, int indexMueble){

      if(indexList.contains(indexMueble)){
         JOptionPane.showMessageDialog(Main.ventana, "Ya has agregado este producto al carrito", "Error", JOptionPane.ERROR_MESSAGE);
         return;
      }
      indexList.add(indexMueble);
      ProductCartPanel productCartPanel = new ProductCartPanel(mueble, index+1);
      panel.add(productCartPanel);
      panel.revalidate();
      panel.repaint();
      index++;
      System.out.println("Agregado");
   }
   
   public CartPanel(){
      setSize(300, 500);
      panel.setSize(300,500);
      panel.setBackground(Colors.mainWhite);
      panel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
      panel.setLayout(new GridLayout(0,1));
      add(panel);
   }
}
