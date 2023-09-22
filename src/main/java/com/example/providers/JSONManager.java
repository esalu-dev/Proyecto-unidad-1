package com.example.providers;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;

import com.example.types.Mueble;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;


public class JSONManager {
   final static Gson gson = new GsonBuilder().setPrettyPrinting().create();
   static List<Mueble> muebles = new ArrayList<>();


   public static void saveDataInJSON(List<Mueble> listaMuebles) {
    try (Writer writer = new FileWriter("products.json")) {
        gson.toJson(listaMuebles, writer);
        System.out.println("Datos guardados en el archivo JSON");
    } catch (IOException e) {
        e.printStackTrace();
    }
}


    public static List<Mueble> getDataFromLocalJSON(){
        try (Reader reader = new FileReader("products.json")) {
            Type tipoLista = new TypeToken<List<Mueble>>() {}.getType();
            muebles = gson.fromJson(reader, tipoLista);
        } catch (IOException e) {
            e.printStackTrace();
        }
      return muebles;
    }
}
