/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.datacredito;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Alejo02
 */
public class Persona implements Serializable {

    private String nombre;
    private String apellido;
    private Integer identificacion;
    private String correo;
    private String fechaNacimiento;

    private HashMap<Integer, Record> mapaPersonas;

    public Persona(String nombre, String apellido, Integer identificacion, String correo, String fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;

        mapaPersonas = new HashMap<>();
    }
   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Integer identificacion) {
        this.identificacion = identificacion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public HashMap<Integer, Record> getMapaPersonas() {
        return mapaPersonas;
    }

    public void setMapaPersonas(HashMap<Integer, Record> mapaPersonas) {
        this.mapaPersonas = mapaPersonas;
    }

    
}
