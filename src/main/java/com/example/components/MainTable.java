package com.example.components;



import java.awt.Font;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.example.providers.JSONManager;
import com.example.types.Mueble;

public class MainTable extends JScrollPane{
   final static Font titleFont = new Font("Poppins", Font.PLAIN, 12);
   final static JTable table = new JTable();


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

      // Personalizar el aspecto de las celdas
      DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
      centerRenderer.setHorizontalAlignment(JLabel.CENTER);
      table.setDefaultRenderer(Object.class, centerRenderer);

      return table;
   }
}
