package com.example.components;

import java.awt.Font;
import java.text.NumberFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.example.types.Mueble;

public class ProductCartPanel extends JPanel {
   final static Font titleFont = new Font("Poppins", Font.PLAIN, 13);
   public ProductCartPanel(Mueble mueble, int index){
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
      
      setSize(290, 200);
      setLayout(null);
      name.setBounds(10, 0, 155, 50);
      price.setBounds(165, 0, 75, 50);
      quantity.setBounds(240, 0, 50, 50);
      deleteButton.setBounds(240, 50, 50, 50);
      name.setFont(titleFont);
      price.setFont(titleFont);
      quantity.setFont(titleFont);

      add(name);
      add(price);
      add(quantity);
      add(deleteButton);
   }
}
