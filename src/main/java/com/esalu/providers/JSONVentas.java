package com.esalu.providers;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;

import com.esalu.types.Ventas;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;


public class JSONVentas {
   final static Gson gson = new GsonBuilder().setPrettyPrinting().create();
   static List<Ventas> ventas = new ArrayList<>();

   public static void saveDataInJSON(List<Ventas> listaVentas) {
    try (Writer writer = new FileWriter("ventas.json")) {
        gson.toJson(listaVentas, writer);
        System.out.println("Datos guardados en el archivo JSON");
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
   }
   public static List<Ventas> getDataFromLocalJSON(){
    try (Reader reader = new FileReader("ventas.json")) {
        Type tipoLista = new TypeToken<List<Ventas>>() {}.getType();
        ventas = gson.fromJson(reader, tipoLista);
        reader.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
   return ventas;
   }
   public static void addDataToLocalJSON(Ventas venta){
    try (Reader reader = new FileReader("ventas.json")) {
        Type tipoLista = new TypeToken<List<Ventas>>() {}.getType();
        ventas = gson.fromJson(reader, tipoLista);
        reader.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    ventas.add(venta);
    saveDataInJSON(ventas);
   }
   public static void deleteEverythingFromLocalJSON(){
    try (Reader reader = new FileReader("ventas.json")) {
        Type tipoLista = new TypeToken<List<Ventas>>() {}.getType();
        ventas = gson.fromJson(reader, tipoLista);
        reader.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    ventas.clear();
    saveDataInJSON(ventas);
   }
}