/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.datacredito;

import java.io.Serializable;

/**
 *
 * @author Alejo02
 */
public class Record implements Serializable{
    
    private int codigo;
    private String nombre;
    private boolean estado;
    private String descripcion;
    private double valor;

    public Record(int codigo, String nombre, boolean estado, String descripcion, double valor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.estado = estado;
        this.descripcion = descripcion;
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
