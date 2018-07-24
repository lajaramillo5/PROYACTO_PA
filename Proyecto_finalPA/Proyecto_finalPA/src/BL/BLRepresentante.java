/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import Data.DataRepresentante;
import clases.Representante;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class BLRepresentante {

    DataRepresentante ObjDatrepre = new DataRepresentante();
    Representante ObjRep = new Representante();
    public static ArrayList lstrepre;

    public ArrayList<Representante> ConsultaLista() throws ClassNotFoundException, SQLException {
        String nombre = "";
        String apellido = "";
        String direcion = "";
        String cedula = "";
        String edad = null;
        String telefono = null;
        String Correo = null;
        ResultSet rs;//recuper datos desde rs y los desgloso o desconpone
        lstrepre = new ArrayList<>();
        rs = ObjDatrepre.Consultar();
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
                if (columnName.equals("Correo")) {
                    Correo = value;
                }

            }
            try {
                Representante p = new Representante(nombre, apellido, Integer.parseInt(edad), cedula, direcion, telefono, Correo);
                lstrepre.add(p);
            } catch (Exception ex) {
                String msn = ex.getMessage();
            }
        }
//        this.cerrarConexion();
        return lstrepre;

    }

    public boolean Consultar(Representante repre) throws ClassNotFoundException, SQLException {
        Representante Objrepre = new Representante();
        boolean bandera = true;

        Objrepre = ObjDatrepre.Consultar(repre);
        bandera = true;
        return bandera;
    }

    public boolean RegistrarRepresentante(Representante Objrepres) {
        DataRepresentante ObjDatDocente = new DataRepresentante();

        boolean bandera = true;

        ObjDatDocente.RegistrarDocente(Objrepres);

        bandera = true;

        return bandera;
    }

    public int Modificar(Representante Objrepres) throws ClassNotFoundException, SQLException {
        return ObjDatrepre.Modificar(Objrepres);

    }

    public int Eliminar(Representante Objrepres) throws SQLException, ClassNotFoundException {
        return this.ObjDatrepre.Eliminar(Objrepres);
    }

    public int Consultar_id(Representante repre) throws ClassNotFoundException, SQLException {

        int x = 0;

        x = ObjDatrepre.idRepre(repre);

        return x;
    }
}
