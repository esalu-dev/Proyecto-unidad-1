package com.example.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.example.constants.Colors;
import com.example.providers.JSONManager;
import com.example.types.Mueble;

public class Card extends JPanel {
   final static Font titleFont = new Font("Poppins", Font.BOLD, 14);
   final static Font priceFont = new Font("Poppins", Font.PLAIN, 14);
   final static Font quantityFont = new Font("Poppins", Font.PLAIN, 12);
   final private JLabel titulo = new JLabel();
   final private JLabel precio = new JLabel();
   final private JLabel cantidad = new JLabel();
   private ImageIcon image;
   private Image img;
   private JLabel imagen;
   final private JPanel northPanel = new JPanel();
   final private CardButton button = new CardButton();
   int index;

   public int getIndex(){
      return index;
   }

   final static ActionListener addEvent = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
         CardButton button = (CardButton) e.getSource();
         Card card = (Card) button.getParent();
         int index = card.getIndex();
         Mueble mueble = JSONManager.getRowFromLocalJSON(index);
         CartPanel.addProduct(mueble, index);
      }
   };
   
   public Card(String title, String price, String imgLink,int Cantidad, boolean isAvailable, int index){
      setPreferredSize(new Dimension(150,200));
      setMaximumSize(new Dimension(150,200));
      setLayout(new BorderLayout());
      setBackground(Colors.mainWhite);
      NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("es", "MX", "MX"));
      String formattedPrice = currencyFormatter.format(Double.parseDouble(price));
      this.index = index;
      titulo.setText(title);
      precio.setText(formattedPrice);
      cantidad.setText("Disponible: "+String.valueOf(Cantidad));
      image = new ImageIcon(imgLink);
      int alturaDeseada = 80;
      int nuevaAnchura = (int) ((double) alturaDeseada / image.getImage().getHeight(null) * image.getImage().getWidth(null));
      img = image.getImage().getScaledInstance(nuevaAnchura, alturaDeseada, Image.SCALE_SMOOTH);
      imagen  = new JLabel(new ImageIcon(img));
      

      northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
      titulo.setFont(titleFont);
      titulo.setForeground(Colors.mainBlue);
      titulo.setHorizontalAlignment(JLabel.CENTER);
      precio.setFont(priceFont);
      precio.setForeground(Colors.lightPurple);
      precio.setHorizontalAlignment(JLabel.CENTER);
      cantidad.setFont(quantityFont);
      cantidad.setForeground(Colors.darkBlue);
      cantidad.setHorizontalAlignment(JLabel.CENTER);
      imagen.setHorizontalAlignment(JLabel.CENTER);
      titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
      precio.setAlignmentX(Component.CENTER_ALIGNMENT);
      imagen.setAlignmentX(Component.CENTER_ALIGNMENT);
      cantidad.setAlignmentX(Component.CENTER_ALIGNMENT);

      setAvailable(isAvailable);

      northPanel.add(Box.createVerticalGlue());
      northPanel.add(titulo);
      northPanel.add(Box.createVerticalGlue());
      northPanel.add(precio);
      northPanel.add(Box.createVerticalGlue());
      northPanel.add(cantidad);
      add(northPanel, BorderLayout.NORTH);
      add(imagen, BorderLayout.CENTER);
      add(button, BorderLayout.SOUTH);
   }
   public void setAvailable(boolean isAvailable){
      if (isAvailable) {
         cantidad.setForeground(Colors.darkBlue);
         button.addActionListener(addEvent);
     } else {
         cantidad.setForeground(Color.RED);
         button.removeActionListener(addEvent);
     }
      button.setButtonEnabled(isAvailable);
   }
   
}
