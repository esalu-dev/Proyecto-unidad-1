package com.esalu.components;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import com.esalu.Main;
import com.esalu.constants.Colors;
import com.esalu.types.Mueble;

public class CartPanel extends ScrollPane {
   final static Font titleFont = new Font("Poppins", Font.PLAIN, 12);

   
   public static JPanel panel = new JPanel();
   public static int index = 0;
   public static ArrayList<Integer> indexList = new ArrayList<Integer>();
   public static ArrayList<Mueble> mueblesInCart = new ArrayList<Mueble>();

   public static void addProduct(Mueble mueble, int indexMueble){

      if(indexList.contains(indexMueble)){
         JOptionPane.showMessageDialog(Main.ventana, "Ya has agregado este producto al carrito", "Error", JOptionPane.ERROR_MESSAGE);
         return;
      }
      indexList.add(indexMueble);
      ProductCartPanel productCartPanel = new ProductCartPanel(mueble, indexMueble);
      panel.add(productCartPanel);
      mueblesInCart.add(mueble);
      panel.revalidate();
      panel.repaint();
      index++;
   }
   public static void removeProduct(Mueble mueble, int indexMueble) {
      for (Component component : panel.getComponents()) {
          if (component instanceof ProductCartPanel) {
              ProductCartPanel cartPanel = (ProductCartPanel) component;
              if (cartPanel.indexMueble == indexMueble) {
                  panel.remove(cartPanel);
                  indexList.remove(Integer.valueOf(indexMueble));
                  mueblesInCart.remove(cartPanel.mueble);
                  panel.revalidate();
                  panel.repaint();
                  index--;
                  break; 
              }
          }
      }
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
