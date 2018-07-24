/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import Data.DataGrado;
import clases.AñoLectivo;
import clases.Docente;
import clases.Grado;
import clases.Paralelo;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class BLGrado {

    DataGrado ObjDatrepre = new DataGrado();
    Grado ObjRep = new Grado();
    public static ArrayList lstgrado;

    public boolean Consultar(Grado gra) throws ClassNotFoundException, SQLException {
        Grado Objrepre = new Grado();
        boolean bandera = true;

        Objrepre = ObjDatrepre.Consultar(gra);
        bandera = true;
        return bandera;
    }

    public boolean RegistrarGrado(Grado Objgrado) {
        DataGrado ObjDatGrado = new DataGrado();

        boolean bandera = true;

        ObjDatGrado.RegistrarGrado(Objgrado);

        bandera = true;

        return bandera;
    }

    public int Eliminar(Grado gra) throws SQLException, ClassNotFoundException {
        return this.ObjDatrepre.Eliminar(gra);
    }

    public int Consultar_id(Docente doc) throws ClassNotFoundException, SQLException {
        int x = 0;
        x = ObjDatrepre.idGra(doc);
        return x;
    }

    public ArrayList<Grado> ConsultaLista2(Grado id) throws ClassNotFoundException, SQLException {
        ResultSet rs;//recuper datos desde rs y los desgloso o desconpone
        ArrayList listAsignatura = new ArrayList<>();
        rs = ObjDatrepre.ObtenerGrado(id);

        while (rs.next()) {
            Grado p = new Grado(rs.getString("Nombre"), new Paralelo(rs.getString("idParal")));
            listAsignatura.add(p);
        }
        return listAsignatura;
    }
    public ArrayList<Grado> ConsultaLista(AñoLectivo id) throws ClassNotFoundException, SQLException {
        ResultSet rs;//recuper datos desde rs y los desgloso o desconpone
        ArrayList listAsignatura = new ArrayList<>();
        rs = ObjDatrepre.ObtenerGrados(id);

        while (rs.next()) {
            Grado p = new Grado(rs.getString("Nombre"), new Paralelo(rs.getString("idParal")));
            listAsignatura.add(p);
        }
        return listAsignatura;
    }

    public ArrayList<Grado> ConsultaLista3() throws ClassNotFoundException, SQLException {
        ResultSet rs;//recuper datos desde rs y los desgloso o desconpone
        ArrayList listAsignatura = new ArrayList<>();
        rs = ObjDatrepre.Consultar();

        while (rs.next()) {
            Grado p = new Grado(rs.getString("Nombre"), new Paralelo(rs.getString("idParal")));
            listAsignatura.add(p);
        }
        return listAsignatura;
    }

    public ArrayList<Grado> ConsultaLista() throws ClassNotFoundException, SQLException {
        ResultSet rs;//recuper datos desde rs y los desgloso o desconpone
        ArrayList listAsignatura = new ArrayList<>();
        rs = ObjDatrepre.Consultar();

        while (rs.next()) {
            Grado p = new Grado(rs.getString("Nombre"), new Paralelo(rs.getInt("idParal")), new AñoLectivo(rs.getInt("idAño")));
            listAsignatura.add(p);
        }
        return listAsignatura;
    }

}
