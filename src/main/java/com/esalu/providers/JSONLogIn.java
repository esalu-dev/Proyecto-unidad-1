package com.esalu.providers;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;

import com.esalu.types.Users;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;


public class JSONLogIn {
   final static Gson gson = new GsonBuilder().setPrettyPrinting().create();
   static List<Users> users = new ArrayList<>();

   public static List<Users> getDataFromLocalJSON(){
      try (Reader reader = new FileReader("users.json")) {
         Type tipoLista = new TypeToken<List<Users>>() {}.getType();
         users = gson.fromJson(reader, tipoLista);
         reader.close();
      } catch (IOException e) {
          e.printStackTrace();
      }
      return users;
   }

   public static void saveDataInJSON(List<Users> listaUsers) {
      try (Writer writer = new FileWriter("users.json")) {
         gson.toJson(listaUsers, writer);
         System.out.println("Datos guardados en el archivo JSON");
         writer.close();
      } catch (IOException e) {
          e.printStackTrace();
      }
   }

   public static void addDataToLocalJSON(Users user){
      try (Reader reader = new FileReader("users.json")) {
         Type tipoLista = new TypeToken<List<Users>>() {}.getType();
         users = gson.fromJson(reader, tipoLista);
         reader.close();
      } catch (IOException e) {
          e.printStackTrace();
      }
      users.add(user);
      saveDataInJSON(users);
   }

   public static int checkUserInLocalJSON(String user){
      try (Reader reader = new FileReader("users.json")) {
         Type tipoLista = new TypeToken<List<Users>>() {}.getType();
         users = gson.fromJson(reader, tipoLista);
         reader.close();
      } catch (IOException e) {
          e.printStackTrace();
      }
      for(Users usuario : users){
         if(usuario.getUsername().equals(user)){
            return 1;
         }
      }
      return 0;
   }
   
   public static int deleteUserFromLocalJSON(String user, String password){
      try (Reader reader = new FileReader("users.json")) {
         Type tipoLista = new TypeToken<List<Users>>() {}.getType();
         users = gson.fromJson(reader, tipoLista);
         reader.close();
      } catch (IOException e) {
          e.printStackTrace();
      }
      for(Users usuario : users){
         if(usuario.getUsername().equals(user) && usuario.getPassword().equals(password)){
            users.remove(usuario);
            saveDataInJSON(users);
            return 1;
         }
      }
      return 0;
   }
}
