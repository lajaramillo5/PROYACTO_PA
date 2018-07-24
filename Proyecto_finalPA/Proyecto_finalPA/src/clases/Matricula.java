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
public class Matricula {
    int idmatri;
    AñoLectivo anio;
    Estudiante estu;
    Representante repre;
    Grado grado;

    public Matricula() {
    }

    public Matricula(AñoLectivo anio, Estudiante estu, Representante repre, Grado grado) {
        this.anio = anio;
        this.estu = estu;
        this.repre = repre;
        this.grado = grado;
    }

    public int getIdmatri() {
        return idmatri;
    }

    public AñoLectivo getAnio() {
        return anio;
    }

    public Estudiante getEstu() {
        return estu;
    }

    public Representante getRepre() {
        return repre;
    }

    public Grado getGrado() {
        return grado;
    }

    public void setIdmatri(int idmatri) {
        this.idmatri = idmatri;
    }

    public void setAnio(AñoLectivo anio) {
        this.anio = anio;
    }

    public void setEstu(Estudiante estu) {
        this.estu = estu;
    }

    public void setRepre(Representante repre) {
        this.repre = repre;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }
    
    
    
}
