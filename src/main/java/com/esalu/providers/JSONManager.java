package com.esalu.providers;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;

import com.esalu.types.Mueble;
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
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}


    public static List<Mueble> getDataFromLocalJSON(){
        try (Reader reader = new FileReader("products.json")) {
            Type tipoLista = new TypeToken<List<Mueble>>() {}.getType();
            muebles = gson.fromJson(reader, tipoLista);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
      return muebles;
    }

    public static void addDataToLocalJSON(Mueble mueble){
        try (Reader reader = new FileReader("products.json")) {
            Type tipoLista = new TypeToken<List<Mueble>>() {}.getType();
            muebles = gson.fromJson(reader, tipoLista);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        muebles.add(mueble);
        saveDataInJSON(muebles);
    }
    public static void deleteDataFromLocalJSON(int index){
        try (Reader reader = new FileReader("products.json")) {
            Type tipoLista = new TypeToken<List<Mueble>>() {}.getType();
            muebles = gson.fromJson(reader, tipoLista);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        muebles.remove(index);
        saveDataInJSON(muebles);
    }
    public static Mueble getRowFromLocalJSON(int index){
        try (Reader reader = new FileReader("products.json")) {
            Type tipoLista = new TypeToken<List<Mueble>>() {}.getType();
            muebles = gson.fromJson(reader, tipoLista);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return muebles.get(index);
    }
    public static void editDataFromLocalJSON(int index, Mueble mueble){
        try (Reader reader = new FileReader("products.json")) {
            Type tipoLista = new TypeToken<List<Mueble>>() {}.getType();
            muebles = gson.fromJson(reader, tipoLista);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        muebles.set(index, mueble);
        saveDataInJSON(muebles);
    }
    public static void decreaseQuantityFromLocalJSON(Mueble mueble){
        try (Reader reader = new FileReader("products.json")) {
            Type tipoLista = new TypeToken<List<Mueble>>() {}.getType();
            muebles = gson.fromJson(reader, tipoLista);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int index = 0;
        for(Mueble muebleInJSON : muebles){
            if(muebleInJSON.getNombre().equals(mueble.getNombre()) && muebleInJSON.getPrecio()==mueble.getPrecio() && muebleInJSON.getImgLink().equals(mueble.getImgLink()) ){
                muebleInJSON.setCantidad(muebleInJSON.getCantidad() - mueble.getCantidad());
                editDataFromLocalJSON(index, muebleInJSON);
                break;
            }
            index++;
        }
    }
   public static int checkUserInLocalJSON(String nombreMueble){
      try (Reader reader = new FileReader("products.json")) {
         Type tipoLista = new TypeToken<List<Mueble>>() {}.getType();
         muebles = gson.fromJson(reader, tipoLista);
         reader.close();
      } catch (IOException e) {
          e.printStackTrace();
      }
      for(Mueble mueble : muebles){
         if(mueble.getNombre().equals(nombreMueble)){
            return 1;
         }
      }
      return 0;
   }
}
