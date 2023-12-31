package com.esalu.pages;

import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.esalu.Main;
import com.esalu.components.CartPanel;
import com.esalu.components.MainTitle;
import com.esalu.components.ProductsPanel;
import com.esalu.components.TableButton;
import com.esalu.components.VentasTable;
import com.esalu.constants.Colors;
import com.esalu.providers.JSONManager;
import com.esalu.providers.JSONVentas;
import com.esalu.types.Mueble;

public class Ventas extends JPanel {
  final static MainTitle etiqueta = new MainTitle("Ventas");
  public final static ProductsPanel productsPanel = new ProductsPanel();
  final static Font titleFont = new Font("Poppins", Font.PLAIN, 14);
  final static TableButton tableButton = new TableButton("Comprar");

  final static ScrollPane scroll = new ScrollPane();
  public final static CartPanel cartPanel = new CartPanel();

  final static JLabel totalLabel = new JLabel("Total: ");
  static double priceToPay = 0;
  static NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();

  public static void setBuyButtonEnabled(double priceToPay){
    if(priceToPay > 0){
      tableButton.setBackground(Colors.darkPurple);
      tableButton.setEnabled(true);
    }else{
      tableButton.setBackground(Colors.darkBlue);
      tableButton.setEnabled(false);
    }
  }
  
  final static ActionListener buyEvent = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      int opcion = JOptionPane.showConfirmDialog(Main.ventana, "¿Estás seguro de realizar la compra?", "Confirmar compra", JOptionPane.YES_NO_OPTION);
      if(opcion != JOptionPane.YES_OPTION){
        return;
      }
      String clientName = JOptionPane.showInputDialog(Main.ventana, "Ingresa el nombre del cliente", "Nombre del cliente", JOptionPane.QUESTION_MESSAGE);
      if(clientName == null){
        JOptionPane.showMessageDialog(Main.ventana, "Venta cancelada", "Error", JOptionPane.ERROR_MESSAGE);
        return;
      }
      if(clientName.trim().equals("")){
        JOptionPane.showMessageDialog(Main.ventana, "El nombre del cliente no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
        return;
      }
      Date fechaYhora = new Date(System.currentTimeMillis());
      SimpleDateFormat fechaFormat = new SimpleDateFormat("dd-MM-yyyy");
      SimpleDateFormat horaFormat = new SimpleDateFormat("HH:mm:ss");
      String fecha = fechaFormat.format(fechaYhora);
      String hora = horaFormat.format(fechaYhora);
      String mensaje = "Compra realizada por " + clientName + "\nTotal a pagar: " + currencyFormatter.format(priceToPay)+ "\n\nProductos comprados:\n";
      com.esalu.types.Ventas venta = new com.esalu.types.Ventas(Main.usuario.getUsername(),clientName, fecha, hora, priceToPay, CartPanel.mueblesInCart.toArray(new Mueble[CartPanel.mueblesInCart.size()]));
      JSONVentas.addDataToLocalJSON(venta);
      VentasTable.refreshTable();
      for(Mueble mueble : CartPanel.mueblesInCart){
        mensaje += mueble.getCantidad() + " "+ mueble.getNombre() + "\n";
        JSONManager.decreaseQuantityFromLocalJSON(mueble);
      }
      JOptionPane.showMessageDialog(Main.ventana, mensaje, "Compra realizada", JOptionPane.INFORMATION_MESSAGE);
      CartPanel.panel.removeAll();
      CartPanel.panel.revalidate();
      CartPanel.panel.repaint();
      CartPanel.index = 0;
      CartPanel.indexList.clear();
      CartPanel.mueblesInCart.clear();
      priceToPay = 0;
      setBuyButtonEnabled(priceToPay);
      String totalPriceString = currencyFormatter.format(priceToPay);
      totalLabel.setText("Total: " + totalPriceString);
      Main.inventario.refreshTable();
      Ventas.productsPanel.getData();
    }
  };
  public static void addTotal (double total) {
    priceToPay += total;
    setBuyButtonEnabled(priceToPay);
    String totalPriceString = currencyFormatter.format(priceToPay);
    totalLabel.setText("Total: " + totalPriceString);
  }
  public static void removeTotal (double total) {
    priceToPay -= total;
    setBuyButtonEnabled(priceToPay);
    String totalPriceString = currencyFormatter.format(priceToPay);
    totalLabel.setText("Total: " + totalPriceString);
  }


  public Ventas(){
    setSize(500, 500);
    scroll.setSize(500, 500);
    scroll.add(productsPanel);
    setBackground(Colors.mainWhite);
    setLayout(null);
    etiqueta.setForeground(Colors.lightPurple);
    etiqueta.setBounds(50, 50, 200, 50);
    add(etiqueta);
    scroll.setBounds(50, 100, 550, 550);
    add(scroll);
    cartPanel.setBounds(630, 100, 300, 450);
    add(cartPanel);
    
    totalLabel.setFont(titleFont);
    totalLabel.setForeground(Colors.mainBlue);
    totalLabel.setBounds(630, 550, 300, 50);
    add(totalLabel);
    tableButton.setEnabled(false);
    tableButton.setBounds(630, 600, 300, 50);
    tableButton.setForeground(Colors.mainWhite);
    tableButton.setBackground(Colors.darkBlue);
    tableButton.addActionListener(buyEvent);
    add(tableButton);
    
  }
}

