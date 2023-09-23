package com.example.components;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.example.constants.Colors;
import com.example.constants.CustomBorder;

public class Card extends JPanel {
   final static Font titleFont = new Font("Poppins", Font.BOLD, 14);
   final static Font priceFont = new Font("Poppins", Font.PLAIN, 14);
   final static JLabel titulo = new JLabel();
   final static JLabel precio = new JLabel();
   static ImageIcon image;
   static Image img;
   static JLabel imagen;
   final static JPanel northPanel = new JPanel();
   final static CardButton button = new CardButton();
   public Card(String title, String price, String imgLink){
      setSize(150, 150);
      setLayout(new BorderLayout());
      setBackground(Colors.mainWhite);

      titulo.setText(title);
      precio.setText(price);
      image = new ImageIcon(imgLink);
      img = image.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
      imagen  = new JLabel(new ImageIcon(img));
      

      northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
      titulo.setFont(titleFont);
      titulo.setForeground(Colors.mainBlue);
      titulo.setHorizontalAlignment(JLabel.CENTER);
      precio.setFont(priceFont);
      precio.setForeground(Colors.lightPurple);
      precio.setHorizontalAlignment(JLabel.CENTER);
      imagen.setHorizontalAlignment(JLabel.CENTER);
      titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
      precio.setAlignmentX(Component.CENTER_ALIGNMENT);
      imagen.setAlignmentX(Component.CENTER_ALIGNMENT);


      northPanel.add(Box.createVerticalGlue());
      northPanel.add(titulo);
      northPanel.add(Box.createVerticalGlue());
      northPanel.add(precio);
      add(northPanel, BorderLayout.NORTH);
      add(imagen, BorderLayout.CENTER);
      add(button, BorderLayout.SOUTH);

      

   }
   
}
