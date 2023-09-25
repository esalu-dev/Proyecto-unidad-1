package com.esalu.providers;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
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
}
