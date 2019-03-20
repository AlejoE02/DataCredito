/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.datacredito;

import Archivo.Archivo;
import java.util.Scanner;

/**
 *
 * @author Alejo02
 */
public class PrincipalRecord {

    Scanner scan = new Scanner(System.in);
    Mapa mapa = new Mapa();
    Archivo archivo = new Archivo();

    public PrincipalRecord() {

        mapa = archivo.obtenerListasActuales();

    }

    public void guardar() {
        archivo.guardarRegistro(mapa);
    }

    public void Menu(int identificacion) {
        int opcion = 0;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("1. Agregar Record");
            System.out.println("2. Eliminar Record");
            System.out.println("3. Ver Record");
            System.out.println("4. Salir");
            System.out.print("Digite la Opcion : ");
            opcion = scan.nextInt();

            switch (opcion) {
                case 1:
                    AgregarRecord(identificacion);
                    break;
                case 2:
                    System.out.print("Ingrese codigo : ");
                    int codigo = scan.nextInt();
                    eliminarRecord(identificacion, codigo);
                    break;
                case 3:
                    verRecords(identificacion);
                    break;
                case 4:
                    System.out.println("Gracias por ingresar Data Credito");
                    break;
                default:
                    System.out.print("Opcion no valida");
                    break;
            }

        } while (opcion != 5);
    }

    public void AgregarRecord(int identificacion) {

        System.out.print("Ingrese el codigo : ");
        int cod = scan.nextInt();

        System.out.print("Ingrese el nombre : ");
        String nombre = scan.next();

        System.out.print("Ingrese el estado : ");
        boolean estado = scan.nextBoolean();

        System.out.print("Ingrese la descripcion : ");
        String descripcion = scan.next();

        System.out.print("Ingrese el valor : ");
        double valor = scan.nextDouble();

        Record nuevoRecord = new Record(cod, nombre, estado, descripcion, valor);

        mapa.getData_credito().get(identificacion).getMapaPersonas().put(cod, nuevoRecord);
        guardar();

    }

    public void eliminarRecord(int identificacion, int cod) {

        if (mapa.getData_credito().get(identificacion).getMapaPersonas().containsKey(cod)) {
            System.out.println("Record encontrado");
            mapa.getData_credito().get(identificacion).getMapaPersonas().remove(cod);
            System.out.println("Record eliminado");
            guardar();
        } else {
            System.out.println("Record no encontrado");
        }

    }

    public void verRecords(int identificacion) {
        for (Integer iterador : mapa.getData_credito().get(identificacion).getMapaPersonas().keySet()) {

            Record record = mapa.getData_credito().get(identificacion).getMapaPersonas().get(iterador);
            System.out.println("Codigo : " + record.getCodigo());
            System.out.println("Nombre : " + record.getNombre());
            System.out.println("Estado : " + record.isEstado());
            System.out.println("Descripcion : " + record.getDescripcion());
            System.out.println("Valor : " + record.getValor());

        }
    }
}
