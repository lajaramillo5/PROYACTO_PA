/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author lenovo
 */
public class Paralelo {
    int idPar;
    String Nombre;

    public Paralelo() {
    }

    public Paralelo(int idPar) {
        this.idPar = idPar;
    }
    

    public Paralelo(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getIdPar() {
        return idPar;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setIdPar(int idPar) {
        this.idPar = idPar;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    @Override
    public String toString() {
        return Nombre ;
    }
    
}
