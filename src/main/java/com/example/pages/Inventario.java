package com.example.pages;

import javax.swing.JPanel;

import com.example.components.MainTable;
import com.example.components.MainTitle;
import com.example.components.TableButton;
import com.example.constants.Colors;

public class Inventario extends JPanel {

  final static MainTitle titulo = new MainTitle("Inventario");
  final static MainTable tabla = new MainTable();
  final static TableButton btnAgregar = new TableButton("Agregar");
  final static TableButton btnEditar = new TableButton("Editar");
  final static TableButton btnEliminar = new TableButton("Eliminar");


  public Inventario(){
    setSize(500, 500);
    setBackground(Colors.mainWhite);
    setLayout(null);
    titulo.setForeground(Colors.lightPurple);
    titulo.setBounds(50, 50, 200, 50);

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
