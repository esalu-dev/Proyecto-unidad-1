package com.example.components;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.example.types.Mueble;

public class ProductCartPanel extends JPanel implements ActionListener {
   final static Font titleFont = new Font("Poppins", Font.PLAIN, 13);
   public int indexMueble;

   @Override
   public void actionPerformed(ActionEvent e) {
      System.out.println(indexMueble);
      CartPanel.removeProduct(indexMueble);
   }
   
   public ProductCartPanel(Mueble mueble, int index, int indexMueble){
      this.indexMueble = indexMueble;
      JLabel name = new JLabel(String.valueOf(index)+". "+mueble.getNombre());
      JSpinner quantity = new JSpinner(new SpinnerNumberModel(1,1,mueble.getCantidad(),1));
      NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
      String priceString = currencyFormatter.format(mueble.getPrecio());
      JLabel price = new JLabel(priceString);
      CartDeleteButton deleteButton = new CartDeleteButton();
      quantity.addChangeListener(new ChangeListener() {
         @Override
         public void stateChanged(ChangeEvent e) {
               int selectedQuantity = (int) quantity.getValue();
               double totalPrice = mueble.getPrecio() * selectedQuantity;
               String totalPriceString = currencyFormatter.format(totalPrice);
               price.setText(totalPriceString);
         }
      });
      
      setPreferredSize(new Dimension(270, 100));
      setLayout(null);
      name.setBounds(10, 10, 190, 30);
      price.setBounds(200, 10, 80, 30);
      quantity.setBounds(10, 50, 50, 30);
      deleteButton.setBounds(230, 50, 30, 30);
      deleteButton.addActionListener(this);
      
      name.setFont(titleFont);
      price.setFont(titleFont);
      quantity.setFont(titleFont);

      add(name);
      add(price);
      add(quantity);
      add(deleteButton);
   }
}
