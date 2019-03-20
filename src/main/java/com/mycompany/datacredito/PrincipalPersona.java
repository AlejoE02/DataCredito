/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.datacredito;

import Archivo.Archivo;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Alejo02
 */
public class PrincipalPersona {

    Mapa mapa = new Mapa();
    Scanner sc = new Scanner(System.in);
    Archivo archivo = new Archivo();

    public PrincipalPersona() {
        mapa = archivo.obtenerListasActuales();
    }

    public void guardar() {
        archivo.guardarRegistro(mapa);
    }

    public void llenarMapa() {
        Persona persona1 = new Persona("Diego", "reyes", 1070982877, "alejo@gmail.com", "02/10/1997");
        mapa.getData_credito().put(persona1.getIdentificacion(), persona1);
        guardar();
    }

    public void MenuPersona() {
        int opcion = 0;
        do {
            System.out.println("1. Agregar Persona");
            System.out.println("2. Administrar Persona");
            System.out.println("3. Ver Personas Registradas");
            System.out.println("4. Salir");
            System.out.print("Digite la Opcion : ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    agregarPersona();
                    break;
                case 2:
                    System.out.print("Ingrese cedula : ");
                    int identificacion = sc.nextInt();
                    seleccionarPersona(identificacion);
                    break;
                case 3:
                    verPersonas();
                    break;
                case 4:
                    System.out.println("Gracias por ingresar a DataCredito");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;

            }

        } while (opcion != 4);
    }

    public void agregarPersona() {
        System.out.print("Digite el nombre : ");
        String nombre = sc.next();
        System.out.print("Digite el apellido : ");
        String apellido = sc.next();
        System.out.print("Digite la identificacion : ");
        Integer identificacion = sc.nextInt();
        System.out.print("Digite el correo : ");
        String correo = sc.next();
        System.out.print("Introduzca la fecha de nacimiento con formato dd/mm/yyyy : ");
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = sc.next();
        String date = fecha;
        try {
            Date testDate = null;
            testDate = df.parse(date);
            System.out.println("Datos creados correctamente");
        } catch (Exception e) {
            System.out.println("formato invalido");
        }
        Persona persona = new Persona(nombre, apellido, identificacion, correo, fecha);

        mapa.getData_credito().put(identificacion, persona);
        guardar();

    }

    public void seleccionarPersona(int identificacion) {

        if (mapa.getData_credito().containsKey(identificacion)) {
            System.out.println("Persona encontrada");
            PrincipalRecord record = new PrincipalRecord();
            record.Menu(identificacion);
        } else {
            System.out.println("Persona no encontrada");
        }

    }

    public void verPersonas() {
        for (Integer iterador : mapa.getData_credito().keySet()) {

            System.out.println("Nombre :" + mapa.getData_credito().get(iterador).getNombre());
            System.out.println("Numero de Identificacion :" + mapa.getData_credito().get(iterador).getIdentificacion());
            String fecha = mapa.getData_credito().get(iterador).getFechaNacimiento();
            System.out.println("Fecha de Nacimiento:" + fecha);

        }
    }

    public boolean validacionString(String campo) {

        boolean valida = true;

        for (int i = 0; i < campo.length(); i++) {
            char caracter = campo.charAt(i);
            if (caracter >= 65 || caracter <= 90 || caracter >= 97 || caracter <= 122
                    || caracter == 32) {
                valida = true;
            } else {
                valida = false;
            }
        }
        return valida;
    }
}
