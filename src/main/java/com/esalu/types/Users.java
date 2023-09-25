package com.esalu.types;

public class Users {
   String username;
   String password;
   boolean isAdmin;
   public Users(String username, String password, boolean isAdmin) {
      this.username = username;
      this.password = password;
      this.isAdmin = isAdmin;
   }
   public String getUsername() {
      return username;
   }
   public String getPassword() {
      return password;
   }
   public boolean getIsAdmin() {
      return isAdmin;
   }
   public void setUsername(String username) {
      this.username = username;
   }
   public void setPassword(String password) {
      this.password = password;
   }
   public void setIsAdmin(boolean isAdmin) {
      this.isAdmin = isAdmin;
   }
   @Override
   public String toString() {
      return "Users [isAdmin=" + isAdmin + ", password=" + password + ", username=" + username + "]";
   }
}
