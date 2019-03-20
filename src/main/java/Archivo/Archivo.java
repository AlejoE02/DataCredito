/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivo;

import com.mycompany.datacredito.Mapa;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Alejo02
 */
public class Archivo {
    /**
     * String que contiene la ruta donde se creara el archivo
     */
    /**
     * Objeto del tipo listasdatos
     */
    public Mapa mapaDatos;
    private static final String ruta = "documento.txt";
    /**
     * Constructor inicial de la clase archivos
     */
    public Archivo() {
       validarArchivo();
    }
    
    /**
     * Metodo que valida si existe el archivo 
     * o si no existe lo crea
     */
    private void validarArchivo(){
     try {
            
            File file = new File(ruta);
           
            if (!file.exists()) {
                file.createNewFile();
                mapaDatos=new Mapa();
                guardarRegistro(mapaDatos);
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
     
    
    }
 
    /**
     * Metodo encargado de obtener la lista de datos del archivo
     * @return Listadatos 
     */
    public Mapa obtenerListasActuales() {
        mapaDatos=new Mapa();
       
        try {
            ObjectInputStream entrada =  new ObjectInputStream(new FileInputStream(ruta));
            mapaDatos = (Mapa) entrada.readObject();
  
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        } 
        
        return mapaDatos;
    }
      
    /**
     * Metodo encargado guardar el registro del archivo creado
     * @param listaDatos escribe la lista de datos que contiene el archivo
     */
    
       public void guardarRegistro(Mapa listaDatos) {
           
        try {
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(ruta));
            salida.writeObject(listaDatos);
            salida.close();
        } catch (Exception ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }
    }
       
    
}

