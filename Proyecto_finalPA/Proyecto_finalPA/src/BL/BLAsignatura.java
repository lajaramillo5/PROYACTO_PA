/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import Data.DataAsignatura;
import clases.Asignatura;
import clases.Docente;
import clases.Grado;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class BLAsignatura {

    DataAsignatura ObjDatAsig = new DataAsignatura();
    Asignatura ObjAsig = new Asignatura();
    public static ArrayList lstAsignaturas;

    public ArrayList<Asignatura> ConsultaLista() throws ClassNotFoundException, SQLException {
        String nombre = "";
        String grado = "";
        String docente = "";
        String horario = "";
        Docente doc = new Docente();
        Grado grad = new Grado();
        ResultSet rs;//recuper datos desde rs y los desgloso o desconpone
        lstAsignaturas = new ArrayList<>();
        rs = ObjDatAsig.Consultar();
        ResultSetMetaData rm = rs.getMetaData();//descompogo todos los datos agrupaados desde la base de datos
        //Recupera los campos de la tabla
        int columnCount = rm.getColumnCount();//si hace o no la opreacion
        ArrayList<String> columns = new ArrayList<>();//arrayList que permite retorna solo las comlumnas de la BDD
        for (int i = 1; i <= columnCount; i++) {
            String columnName = rm.getColumnName(i);//retorna una a una las columnas
            columns.add(columnName);
        }
        while (rs.next()) {
            for (String columnName : columns) {
                String value = rs.getString(columnName);
                if (columnName.equals("Nombre")) {
                    nombre = value;
                }
                if (columnName.equals("Horario")) {
                    horario = value;
                }
                if (columnName.equals("idDoc")) {
                    docente = value;
                }
                if (columnName.equals("idGra")) {
                    grado = value;
                }
            }
            grad.setId(Integer.parseInt(grado));

            doc.setCodigoCarnet(Integer.parseInt(docente));

            try {
                Asignatura p = new Asignatura(nombre, horario, doc, grad);
                lstAsignaturas.add(p);
            } catch (Exception ex) {
                String msn = ex.getMessage();
            }
        }
//        this.cerrarConexion();
        return lstAsignaturas;

    }

    public boolean Consultar(Asignatura secre) throws ClassNotFoundException, SQLException {

        boolean bandera = true;

        ObjAsig = ObjDatAsig.Consultar(secre);
        bandera = true;
        return bandera;
    }

      public int Consultar_id(Asignatura doc) throws ClassNotFoundException, SQLException {

        int x = 0;

        x = ObjDatAsig.idAsig(doc);

        return x;
    }


    public boolean RegistrarAsignatura(Asignatura Objsecre) {

        boolean bandera = true;

        ObjDatAsig.RegistrarAsignatura(Objsecre);

        bandera = true;

        return bandera;
    }
     public ArrayList<Asignatura> ConsultaLista2(Docente id) throws ClassNotFoundException, SQLException {
        ResultSet rs;//recuper datos desde rs y los desgloso o desconpone
        ArrayList listAsignatura = new ArrayList<>();
        rs = ObjDatAsig.ObtenerAsignaturas(id);
       
        while (rs.next()) {
            Asignatura p = new Asignatura(rs.getString("nombre"));
            listAsignatura.add(p);
            } 
        return listAsignatura;
    }
}
