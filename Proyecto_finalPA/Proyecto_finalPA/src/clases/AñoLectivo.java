/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Date;

/**
 *
 * @author lenovo
 */
public class AñoLectivo {
    int idaño;
    Date inicio;
    Date fin;

    public AñoLectivo() {
    }

    public AñoLectivo(int idaño) {
        this.idaño = idaño;
    }

   
    

    public AñoLectivo(Date inicio, Date fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    public int getIdaño() {
        return idaño;
    }

    public Date getInicio() {
        return inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setIdaño(int idaño) {
        this.idaño = idaño;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    } 

    @Override
    public String toString() {
        return  inicio +"\t y \t "+ fin ;
    }

    
}
