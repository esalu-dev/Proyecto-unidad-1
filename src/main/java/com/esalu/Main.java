package com.esalu;


import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.esalu.components.LogInFrame;
import com.esalu.components.PanelDerecho;
import com.esalu.constants.AppIcon;
import com.esalu.constants.Colors;
import com.esalu.pages.Configuration;
import com.esalu.pages.Inventario;
import com.esalu.pages.Reportes;
import com.esalu.pages.Ventas;
import com.esalu.providers.JSONLogIn;
import com.esalu.types.Users;



public class Main {

    public final static JFrame ventana = new JFrame("Sistema Mueblería Salas Luján");
    public final static Inventario inventario = new Inventario();
    final static Ventas ventas = new Ventas();
    final static Configuration configuracion = new Configuration();
    final static Reportes reportes = new Reportes();
    public static Users usuario;
    final static JLabel background = new JLabel(AppIcon.backgroundIcon);

    public static void setDesign(){
        try {
            ventana.setIconImage(AppIcon.appIcon.getImage());
            Font defaultFont = new Font("Poppins", Font.PLAIN, 14);
            UIManager.put("Button.font", defaultFont); 
            UIManager.put("Label.font", defaultFont);
            UIManager.put("TextField.font", defaultFont);
            UIManager.put("TextArea.font", defaultFont);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void changePaneltoReportes(){
        if(usuario.getCanAccessReportes()){
            ventana.getContentPane().removeAll();
            ventana.getContentPane().add(new PanelDerecho());
            reportes.setBounds(300, 0, 967, 683);
            ventana.getContentPane().add(reportes);
            ventana.revalidate();
            ventana.repaint();
        }
        else{
            JOptionPane.showMessageDialog(Main.ventana, "No tienes permisos para ver esta sección", "Permiso denegado", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void changePaneltoLogIn(){
        ventana.getContentPane().removeAll();
        ventana.getContentPane().setBackground(Colors.mainWhite);
        ventana.getContentPane().add(new PanelDerecho());
        background.setBounds(300, 0, 967, 683);
        ventana.getContentPane().add(background);
        ventana.revalidate();
        ventana.repaint();
    }
    public static void changePaneltoInventario(){
        if(usuario.getCanAccessInventario()){
            ventana.getContentPane().removeAll();
            ventana.getContentPane().add(new PanelDerecho());
            inventario.setBounds(300, 0, 967, 683);
            ventana.getContentPane().add(inventario);
            ventana.revalidate();
            ventana.repaint();
        }
        else{
            JOptionPane.showMessageDialog(Main.ventana, "No tienes permisos para ver esta sección", "Permiso denegado", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void changePaneltoVentas(){
        if(usuario.getCanAccessVentas()){
            ventana.getContentPane().removeAll();
            ventana.getContentPane().add(new PanelDerecho());
            ventas.setBounds(300, 0, 967, 683);
            ventana.getContentPane().add(ventas);
            ventana.revalidate();
            ventana.repaint();
        }
        else{
            JOptionPane.showMessageDialog(Main.ventana, "No tienes permisos para ver esta sección", "Permiso denegado", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void changePaneltoConfiguracion(){
        if(usuario.getCanAccessConfiguracion()){
            ventana.getContentPane().removeAll();
            ventana.getContentPane().add(new PanelDerecho());
            configuracion.setBounds(300, 0, 967, 683);
            ventana.getContentPane().add(configuracion);
            ventana.revalidate();
            ventana.repaint();
        }
        else{
            JOptionPane.showMessageDialog(Main.ventana, "No tienes permisos para ver esta sección", "Permiso denegado", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void logIn(String username, String password){
        List<Users> users = JSONLogIn.getDataFromLocalJSON();;
        for (Users user : users) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){ 
                usuario = user;
                JOptionPane.showMessageDialog(ventana, "Bienvenido " + user.getUsername(), "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
                logInFrame.dispose();
                setDesign();
                ventana.setResizable(false);
                ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ventana.setSize(1280, 720);
                ventana.setLayout(null);
                changePaneltoLogIn();
                ventana.setLocationRelativeTo(null);
                ventana.setVisible(true);
                return;
            }
            
        }
        JOptionPane.showMessageDialog(ventana, "Usuario o contraseña incorrectos", "Error", JOptionPane.INFORMATION_MESSAGE);
        return;
    }
    final static LogInFrame logInFrame = new LogInFrame();
    public static void main(String[] args) {
        logInFrame.setVisible(true);
    }


}