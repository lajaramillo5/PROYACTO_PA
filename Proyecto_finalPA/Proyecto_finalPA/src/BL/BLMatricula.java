/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import Data.DataMatricula;
import clases.Matricula;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class BLMatricula {
      DataMatricula ObjDatmat = new DataMatricula();
   Matricula ObjMtri = new Matricula();
    public static ArrayList lstAsignaturas;
     public int Consultar_id(Matricula matricu) throws ClassNotFoundException, SQLException {

        int x = 0;

        x = ObjDatmat.idRepre(matricu);

        return x;
    }

    public boolean RegistrarMatricula(Matricula Objmatri) {

        boolean bandera = true;

        ObjDatmat.RegistrarMatricula(Objmatri);

        bandera = true;

        return bandera;
    }
     public boolean Consultar(Matricula matri) throws ClassNotFoundException, SQLException {
        boolean bandera = true;

         ObjDatmat.Consultar(matri);
        bandera = true;
        return bandera;
    }
}
