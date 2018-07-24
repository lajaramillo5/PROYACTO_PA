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
public class Asignatura {
    String Nombre;
    String Horario;
    Grado  grado;
    Docente docente;
    int idasig;

    public Asignatura() {
    }

    public Asignatura(String Nombre) {
        this.Nombre = Nombre;
    }

    public Asignatura(int idasig) {
        this.idasig = idasig;
    }
    
    

    public Asignatura(String Nombre, String Horario, Docente docente, Grado grado) {
        this.Nombre = Nombre;
        this.Horario = Horario;
        this.grado = grado;
        this.docente = docente;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getHorario() {
        return Horario;
    }

    public Grado getGrado() {
        return grado;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setHorario(String Horario) {
        this.Horario = Horario;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public int getIdasig() {
        return idasig;
    }

    public void setIdasig(int idasig) {
        this.idasig = idasig;
    }
    

    @Override
    public String toString() {
        return Nombre ;
    }

  
    
}
