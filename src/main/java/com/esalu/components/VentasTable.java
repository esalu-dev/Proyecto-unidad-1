package com.esalu.components;

import java.awt.Font;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import com.esalu.providers.JSONVentas;
import com.esalu.types.Ventas;

public class VentasTable extends JScrollPane {
   private static JTable table;
   private static DefaultTableModel model = new DefaultTableModel();
   final static Font titleFont = new Font("Poppins", Font.PLAIN, 12);

   public static void refreshTable(){
      List<Ventas> ventas = JSONVentas.getDataFromLocalJSON();
      for(Ventas venta : ventas){
         model.addRow(venta.toArray());
      }
      table.revalidate();
      table.repaint();
   }
      static class PrecioTableCellRenderer extends DefaultTableCellRenderer {
         private static final DecimalFormat formatoPrecio = new DecimalFormat("$#,##0.00");

         @Override
         protected void setValue(Object value) {
            System.out.println(value);
            // Formatear el valor de la celda como un precio
            if (value != null) {
               setHorizontalAlignment(JLabel.CENTER);
               setText(formatoPrecio.format(value));
            } else {
                setText("");
            }
         }
    }

   
   public VentasTable() {      
      // Crea el modelo de la tabla
      model.addColumn("Vendedor");
      model.addColumn("Cliente");
      model.addColumn("Fecha");
      model.addColumn("Hora");
      model.addColumn("Total");
      model.addColumn("Muebles");

      List<Ventas> ventas = JSONVentas.getDataFromLocalJSON();
      for(Ventas venta : ventas){
         model.addRow(venta.toArray());
      }

      // Crea la tabla y asigna el modelo
      table = new JTable(model);
      table.setRowHeight(60);
      table.setFont(titleFont);
      table.setFillsViewportHeight(true);
      table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      
      // Modifica el ancho de las columnas
      TableColumn column = null;
      for (int i = 0; i < table.getColumnCount(); i++) {
         column = table.getColumnModel().getColumn(i);
         if (i == 0 || i == 1) {
            column.setPreferredWidth(100); // Ancho de las columnas de texto
         } else if (i == 2) {
            column.setPreferredWidth(80); // Ancho de la columna de precio
         } else if (i == 3) {
            column.setPreferredWidth(100); // Ancho de la columna de fecha
         } else if (i == 4) {
            column.setPreferredWidth(60); // Ancho de la columna de hora
         } else {
            column.setPreferredWidth(200); // Ancho de la columna de muebles
         }
      }
      TableColumnModel columnModel = table.getColumnModel();
      columnModel.getColumn(4).setCellRenderer(new PrecioTableCellRenderer());
      
      // Personalizar el aspecto de las celdas
      DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
      centerRenderer.setHorizontalAlignment(JLabel.CENTER);
      table.setDefaultRenderer(Object.class, centerRenderer);

      setViewportView(table);
      // Agrega la tabla a un JScrollPane para que tenga barras de desplazamiento
      
   }
}
