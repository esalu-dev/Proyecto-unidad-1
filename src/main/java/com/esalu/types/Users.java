package com.esalu.types;

public class Users {
   String username;
   String password;
   boolean canAccessVentas;
   boolean canAccessInventario;
   boolean canAccessConfiguracion;
   boolean canAccessReportes;
   public Users(String username, String password, boolean canAccessVentas, boolean canAccessInventario, boolean canAccessConfiguracion, boolean canAccessReportes) {
      this.username = username;
      this.password = password;
      this.canAccessVentas = canAccessVentas;
      this.canAccessInventario = canAccessInventario;
      this.canAccessConfiguracion = canAccessConfiguracion;
      this.canAccessReportes = canAccessReportes;
   }
   public String getUsername() {
      return username;
   }
   public String getPassword() {
      return password;
   }
   public boolean getCanAccessVentas() {
      return canAccessVentas;
   }
   public boolean getCanAccessInventario() {
      return canAccessInventario;
   }
   public boolean getCanAccessConfiguracion() {
      return canAccessConfiguracion;
   }
   public boolean getCanAccessReportes() {
      return canAccessReportes;
   }
   public void setUsername(String username) {
      this.username = username;
   }
   public void setPassword(String password) {
      this.password = password;
   }
   public void setCanAccessVentas(boolean canAccessVentas) {
      this.canAccessVentas = canAccessVentas;
   }
   public void setCanAccessInventario(boolean canAccessInventario) {
      this.canAccessInventario = canAccessInventario;
   }
   public void setCanAccessConfiguracion(boolean canAccessConfiguracion) {
      this.canAccessConfiguracion = canAccessConfiguracion;
   }
   public void setCanAccessReportes(boolean canAccessReportes) {
      this.canAccessReportes = canAccessReportes;
   }
   @Override
   public String toString() {
      return "Users [username=" + username + ", password=" + password + ", canAccessVentas=" + canAccessVentas
            + ", canAccessInventario=" + canAccessInventario + ", canAccessConfiguracion=" + canAccessConfiguracion
            + ", canAccessReportes=" + canAccessReportes + "]";
   }
}
