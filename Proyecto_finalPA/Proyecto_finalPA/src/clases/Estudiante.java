/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class Estudiante {

    int codigoCarnet;
    String nombre;
    String apellido;
    int edad;
    String Cedula;
    String Direccion;
    String telefono;

    public Estudiante() {
    }

    public Estudiante(int codigoCarnet) {
        this.codigoCarnet = codigoCarnet;
    }
    
    

    public Estudiante(int codigoCarnet, String nombre, String apellido, int edad, String Cedula, String Direccion, String telefono) {
        this.codigoCarnet = codigoCarnet;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.Cedula = Cedula;
        this.Direccion = Direccion;
        this.telefono = telefono;
    }

    public int getCodigoCarnet() {
        return codigoCarnet;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getCedula() {
        return Cedula;
    }

    public String getDireccion() {
        return Direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setCodigoCarnet(int codigoCarnet) {
        this.codigoCarnet = codigoCarnet;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

  


   
    
}
