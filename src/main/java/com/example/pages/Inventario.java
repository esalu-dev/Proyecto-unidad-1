package com.example.pages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.example.Main;
import com.example.components.AddDataFrame;
import com.example.components.MainTable;
import com.example.components.MainTitle;
import com.example.components.TableButton;
import com.example.constants.Colors;
import com.example.providers.JSONManager;

public class Inventario extends JPanel {

  final static MainTitle titulo = new MainTitle("Inventario");
  public final static MainTable tabla = new MainTable();
  final static TableButton btnAgregar = new TableButton("Agregar");
  final static TableButton btnEditar = new TableButton("Editar");
  final static TableButton btnEliminar = new TableButton("Eliminar");

  final static ActionListener eventoAdd = new ActionListener() {
    public void actionPerformed(ActionEvent ev){
      if(ev.getSource().equals(btnAgregar)){
        AddDataFrame añadir = new AddDataFrame();
        añadir.setVisible(true);
      }
    }
  };
  final static ActionListener eventoEdit = new ActionListener() {
    public void actionPerformed(ActionEvent ev){
      if(ev.getSource().equals(btnEditar)){
        AddDataFrame añadir = new AddDataFrame();
        añadir.setVisible(true);
      }
    }
  };
  final static ActionListener eventoDelete = new ActionListener() {
    public void actionPerformed(ActionEvent ev){
      if(ev.getSource().equals(btnEliminar)){
        
        int row = MainTable.table.getSelectedRow();
        if(row == -1){
          JOptionPane.showMessageDialog(null, "Por favor, selecciona un mueble", "Error", JOptionPane.ERROR_MESSAGE);
          return;
        }
        int dialogResult = JOptionPane.showConfirmDialog (null, "¿Estás seguro de eliminar este mueble?", "Warning", JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){
          JOptionPane.showMessageDialog(null, "Mueble eliminado", "Éxito", JOptionPane.INFORMATION_MESSAGE);
          JSONManager.deleteDataFromLocalJSON(row);
          Main.inventario.refreshTable();
        }

      }
    }
  };

  public void refreshTable(){
    tabla.refreshTable();
    revalidate();
    repaint();
  }


  public Inventario(){
    setSize(500, 500);
    setBackground(Colors.mainWhite);
    setLayout(null);
    titulo.setForeground(Colors.lightPurple);
    titulo.setBounds(50, 50, 200, 50);
    btnAgregar.addActionListener(eventoAdd);
    btnEditar.addActionListener(eventoEdit);
    btnEliminar.addActionListener(eventoDelete);

    btnAgregar.setBackground(Colors.darkPurple);
    btnEditar.setBackground(Colors.darkPurple);
    btnEliminar.setBackground(Colors.darkPurple);
    btnAgregar.setForeground(Colors.mainWhite);
    btnEditar.setForeground(Colors.mainWhite);
    btnEliminar.setForeground(Colors.mainWhite);
    add(titulo);
    tabla.setBounds(50, 100, 840, 450);
    add(tabla);
    btnAgregar.setBounds(50, 600, 120, 50);
    add(btnAgregar);
    btnEditar.setBounds(190, 600, 120, 50);
    add(btnEditar);
    btnEliminar.setBounds(330, 600, 120, 50);
    add(btnEliminar);

  }
}
