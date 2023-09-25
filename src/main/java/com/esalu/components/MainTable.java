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
import javax.swing.table.TableColumnModel;

import com.esalu.providers.JSONManager;
import com.esalu.types.Mueble;

public class MainTable extends JScrollPane{
   final static Font titleFont = new Font("Poppins", Font.PLAIN, 12);
   public final static JTable table = new JTable();


   public MainTable(){
      setSize(500, 500);
      JTable table = createCustomTable();
      setViewportView(table);
   }

   public void refreshTable(){
      revalidate();
      repaint();
      table.setModel(createCustomTable().getModel());
      table.repaint();
   }
   static class PrecioTableCellRenderer extends DefaultTableCellRenderer {
        private static final DecimalFormat formatoPrecio = new DecimalFormat("$#,##0.00");

        @Override
        protected void setValue(Object value) {
            // Formatear el valor de la celda como un precio
            if (value != null) {
               setHorizontalAlignment(JLabel.CENTER);
                setText(formatoPrecio.format(value));
            } else {
                setText("");
            }
        }
    }

   private static JTable createCustomTable() {
      String[] columnNames = {"Nombre", "Precio", "Cantidad"};
      DefaultTableModel model = new DefaultTableModel(columnNames, 0){
         @Override
         public boolean isCellEditable(int row, int column){
            return false;
         }
      };
      
      List<Mueble> muebles =JSONManager.getDataFromLocalJSON();
      for (Mueble mueble : muebles) {
         Object[] row = {mueble.getNombre(), mueble.getPrecio(), mueble.getCantidad()};
         model.addRow(row);
      }
      
      
      table.setModel(model);
      table.setFont(titleFont);
      
      // Personalizar el aspecto de la tabla
      table.setFillsViewportHeight(true);
      table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      table.setRowHeight(50); // Altura de las filas
      TableColumnModel columnModel = table.getColumnModel();
      int precioColumnIndex = 1; // Índice de la columna de "Precio"
      columnModel.getColumn(precioColumnIndex).setCellRenderer(new PrecioTableCellRenderer());
      
      // Personalizar el aspecto de las celdas
      DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
      centerRenderer.setHorizontalAlignment(JLabel.CENTER);
      table.setDefaultRenderer(Object.class, centerRenderer);

      return table;
   }
}
