package com.esalu.types;

public class Ventas {
   String sellerName, clientName, date, hour;
   double totalPrice;
   Mueble[] muebles;
   public Ventas(String sellerName, String clientName, String date, String hour, double totalPrice, Mueble[] muebles){
      this.sellerName = sellerName;
      this.clientName = clientName;
      this.date = date;
      this.hour = hour;
      this.totalPrice = totalPrice;
      this.muebles = muebles;
   }
   public String getSellerName(){
      return sellerName;
   }
   public String getClientName(){
      return clientName;
   }
   public String getDate(){
      return date;
   }
   public String getHour(){
      return hour;
   }
   public double getTotalPrice(){
      return totalPrice;
   }
   public Mueble[] getMuebles(){
      return muebles;
   }
   public void setSellerName(String sellerName){
      this.sellerName = sellerName;
   }
   public void setClientName(String clientName){
      this.clientName = clientName;
   }
   public void setDate(String date){
      this.date = date;
   }
   public void setHour(String hour){
      this.hour = hour;
   }
   public void setTotalPrice(double totalPrice){
      this.totalPrice = totalPrice;
   }
   public void setMuebles(Mueble[] muebles){
      this.muebles = muebles;
   }
   public Object[] toArray(){
      String muebles = "";
      for(Mueble mueble : this.muebles){
         muebles += mueble.getNombre() + "(" + mueble.getCantidad() + "), ";
      }
      Object[] venta = {sellerName, clientName, date, hour, totalPrice, muebles};
      return venta;
   }
}
