package com.example.components;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.example.constants.Colors;
import com.example.types.Mueble;

public class CartPanel extends ScrollPane {
   final static Font titleFont = new Font("Poppins", Font.PLAIN, 12);
   final static Mueble ejemplo = new Mueble("Antecomedor", 15000, 10, "null");
   
   


   public CartPanel(){
      JPanel panel = new JPanel();
      panel.setBackground(Colors.mainWhite);
      panel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
      panel.setLayout(new GridLayout(0,1));
      
      for(int i = 0; i<3; i++){
         ProductCartPanel productCartPanel = new ProductCartPanel(ejemplo, i);
         panel.add(productCartPanel);
      }
      add(panel);

      

   }
}
