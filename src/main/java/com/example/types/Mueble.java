package com.example.types;

public class Mueble {
   private int id;
   private String nombre;
   private double precio;
   private int cantidad;
   private String imgLink;

   public Mueble(int id, String nombre, double precio, int cantidad, String imgLink) {
      this.id = id;
      this.nombre = nombre;
      this.precio = precio;
      this.cantidad = cantidad;
      this.imgLink = imgLink;
   }

   public int getId() {
      return id;
   }

   public String getNombre() {
      return nombre;
   }

   public double getPrecio() {
      return precio;
   }

   public int getCantidad() {
      return cantidad;
   }

   public String getImgLink() {
      return imgLink;
   }

   public void setId(int id) {
      this.id = id;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public void setPrecio(double precio) {
      this.precio = precio;
   }

   public void setCantidad(int cantidad) {
      this.cantidad = cantidad;
   }

   public void setImgLink(String imgLink) {
      this.imgLink = imgLink;
   }

   public String[] toArray(){
      String[] mueble = {String.valueOf(id), nombre, String.valueOf(precio), String.valueOf(cantidad), imgLink};
      return mueble;
   }
}
