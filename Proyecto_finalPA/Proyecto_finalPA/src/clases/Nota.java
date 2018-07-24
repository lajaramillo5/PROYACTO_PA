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
public class Nota {
     Asignatura asignaturas;
    double par11, par12, par13,quimestre1, par21, par22, par23,  quimestre2,notaFinal;
     Estudiante estudiante;
    public Nota(Asignatura asignaturas, double par11, double par12, double par13, double quimestre1, double par21, double par22, double par23, double quimestre2, double notaFinal, Estudiante estudiante) {
        this.asignaturas = asignaturas;
        this.par11 = par11;
        this.par12 = par12;
        this.par13 = par13;
        this.quimestre1 = quimestre1;
        this.par21 = par21;
        this.par22 = par22;
        this.par23 = par23;
        this.quimestre2 = quimestre2;
        this.notaFinal = notaFinal;
        this.estudiante = estudiante;
    }

    public Nota(double par11, double par12, double par13, double quimestre1, double par21, double par22, double par23, double quimestre2, double notaFinal, Estudiante estudiante) {
        this.par11 = par11;
        this.par12 = par12;
        this.par13 = par13;
        this.quimestre1 = quimestre1;
        this.par21 = par21;
        this.par22 = par22;
        this.par23 = par23;
        this.quimestre2 = quimestre2;
        this.notaFinal = notaFinal;
        this.estudiante = estudiante;
    }

  
    
   

    public Nota() {
    }

    

    public double getPar11() {
        return par11;
    }

    public void setPar11(double par11) {
        this.par11 = par11;
    }

    public double getPar12() {
        return par12;
    }

    public void setPar12(double par12) {
        this.par12 = par12;
    }

    public double getPar13() {
        return par13;
    }

    public void setPar13(double par13) {
        this.par13 = par13;
    }

    public double getPar21() {
        return par21;
    }

    public void setPar21(double par21) {
        this.par21 = par21;
    }

    public double getPar22() {
        return par22;
    }

    public void setPar22(double par22) {
        this.par22 = par22;
    }

    public double getPar23() {
        return par23;
    }

    public void setPar23(double par23) {
        this.par23 = par23;
    }

    public double getQuimestre1() {
        return quimestre1;
    }

    public void setQuimestre1(double quimestre1) {
        this.quimestre1 = quimestre1;
    }

    public double getQuimestre2() {
        return quimestre2;
    }

    public void setQuimestre2(double quimestre2) {
        this.quimestre2 = quimestre2;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

    public Asignatura getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(Asignatura asignaturas) {
        this.asignaturas = asignaturas;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    @Override
    public String toString() {
        return "Nota{" + "par11=" + par11 + ", par12=" + par12 + ", par13=" + par13 + ", par21=" + par21 + ", par22=" + par22 + ", par23=" + par23 + ", quimestre1=" + quimestre1 + ", quimestre2=" + quimestre2 + ", notaFinal=" + notaFinal + ", asignaturas=" + asignaturas + ", estudiante=" + estudiante + '}';
    }
}
