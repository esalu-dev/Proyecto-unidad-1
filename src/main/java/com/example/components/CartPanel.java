package com.example.components;

import java.awt.BorderLayout;
import java.awt.Font;
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

public class CartPanel extends JPanel {
   final static Font titleFont = new Font("Poppins", Font.PLAIN, 12);
   public DefaultTableModel model;
   private JTable table;
   final static Mueble ejemplo = new Mueble("Antecomedor", 15000, 10, "null");
   
   static class PrecioTableCellRenderer extends DefaultTableCellRenderer {
      private static final DecimalFormat formatoPrecio = new DecimalFormat("$#,##0.00");

      @Override
      protected void setValue(Object value) {
         // Formatear el valor de la celda como un precio
         if (value != null) {
            setText(formatoPrecio.format(value));
         } else {
            setText("");
         }
      }
   }


   public CartPanel(){
      setBackground(Colors.mainWhite);
      setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
      setLayout(new BorderLayout());
      

      String[] columnNames = {"Nombre", "Precio", "Cantidad"};
      model = new DefaultTableModel(columnNames, 0){
         @Override
         public boolean isCellEditable(int row, int column){
            return false;
         }
      };;

      table = new JTable(model);
      table.setRowHeight(60);
      table.setFont(titleFont);
      table.setShowGrid(false);
      table.setShowHorizontalLines(false);
      table.setShowVerticalLines(false);
      table.setTableHeader(null);
      table.setFillsViewportHeight(true);
      table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      TableColumnModel columnModel = table.getColumnModel();
      int precioColumnIndex = 1; // Índice de la columna de "Precio"
      columnModel.getColumn(precioColumnIndex).setCellRenderer(new PrecioTableCellRenderer());

      
      table.getColumnModel().getColumn(0).setPreferredWidth(300);
      table.getColumnModel().getColumn(1).setPreferredWidth(200);
      
      for(int i = 0; i<3; i++){
         model.addRow(new Object[]{ejemplo.getNombre(), ejemplo.getPrecio(), String.valueOf(3)});
      }

      JScrollPane scrollPane = new JScrollPane(table);
      add(scrollPane, BorderLayout.CENTER);

   }
}
