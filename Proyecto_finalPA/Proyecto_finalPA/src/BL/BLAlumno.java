/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import Data.DataAlumno;
import clases.Estudiante;
import clases.Grado;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class BLAlumno {
    DataAlumno ObjDatestu = new DataAlumno();
    Estudiante Objestu = new Estudiante();
    public static ArrayList lstestudiantes;

    public ArrayList<Estudiante> ConsultaLista() throws ClassNotFoundException, SQLException {
        String nombre = "";
        String apellido = "";
        String direcion = "";
        String cedula = "";
        String edad = "";
        String telefono = "";
        String id = "";
        ResultSet rs;//recuper datos desde rs y los desgloso o desconpone
        lstestudiantes = new ArrayList<>();
        rs = ObjDatestu.Consultar();
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
                if (columnName.equals("idEst")) {
                    id = value;
                }
                if (columnName.equals("Nombre")) {
                    nombre = value;
                }
                if (columnName.equals("Apellido")) {
                    apellido = value;
                }
                if (columnName.equals("Edad")) {
                    edad = value;
                }
                if (columnName.equals("Cedula")) {
                    cedula = value;
                }
                if (columnName.equals("Direccion")) {
                    direcion = value;
                }
                if (columnName.equals("Telefono")) {
                    telefono = value;
                }

            }
            try {
                Estudiante p = new Estudiante(Integer.parseInt(id),nombre, apellido, Integer.parseInt(edad), cedula, direcion, telefono);
                lstestudiantes.add(p);
            } catch (Exception ex) {
                String msn = ex.getMessage();
            }
        }
//        this.cerrarConexion();
        return lstestudiantes;

    }

    public boolean Consultar(Estudiante secre) throws ClassNotFoundException, SQLException {
        boolean bandera = true;

         ObjDatestu.Consultar(secre);
        bandera = true;
        return bandera;
    }
      public int Consultar_id(Estudiante doc) throws ClassNotFoundException, SQLException {

        int x = 0;

        x = ObjDatestu.idEst(doc);

        return x;
    }
      public int Consultar_id2(Grado gra) throws ClassNotFoundException, SQLException {

        int x = 0;

        x = ObjDatestu.idestu(gra);

        return x;
    }
  

    public boolean RegistrarEstudiante(Estudiante ObjEstu) {

        boolean bandera = true;

        ObjDatestu.RegistrarEstudiante(ObjEstu);

        bandera = true;

        return bandera;
    }

    public int Modificar(Estudiante ObjEstu) throws ClassNotFoundException, SQLException {
        return ObjDatestu.Modificar(ObjEstu);

    }

    public int Eliminar(Estudiante ObjEstu) throws SQLException, ClassNotFoundException {
        return this.ObjDatestu.Eliminar(ObjEstu);
    }
}
