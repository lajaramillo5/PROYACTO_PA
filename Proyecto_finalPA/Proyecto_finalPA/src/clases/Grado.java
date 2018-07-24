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
public class Grado {
    String nombre;
   int id;
    Paralelo paralelo;
    AñoLectivo año;

    public Grado() {
    }

    public Grado(String nombre, Paralelo paralelo, AñoLectivo año) {
        this.nombre = nombre;
        this.paralelo = paralelo;
        this.año = año;
    }

    public Grado(String nombre, Paralelo paralelo) {
        this.nombre = nombre;
        this.paralelo = paralelo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public Paralelo getParalelo() {
        return paralelo;
    }

    public AñoLectivo getAño() {
        return año;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setParalelo(Paralelo paralelo) {
        this.paralelo = paralelo;
    }

    public void setAño(AñoLectivo año) {
        this.año = año;
    }

  

    @Override
    public String toString() {
        return nombre +" \t-\t " + paralelo ;
    }
    

   
    
    
}
