/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import Data.DataParalelo;
import clases.Paralelo;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class BLParalelo {

    DataParalelo ObjDatrepre = new DataParalelo();
    Paralelo ObjRep = new Paralelo();
    public static ArrayList lstparalelo;

    public ArrayList<Paralelo> ConsultaLista() throws ClassNotFoundException, SQLException {
        String nombre = "";
        ResultSet rs;//recuper datos desde rs y los desgloso o desconpone
        lstparalelo = new ArrayList<>();
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

            }
            try {
                Paralelo p = new Paralelo(nombre);
                lstparalelo.add(p);
            } catch (Exception ex) {
                String msn = ex.getMessage();
            }
        }
//        this.cerrarConexion();
        return lstparalelo;

    }

    public boolean Consultar(Paralelo gra) throws ClassNotFoundException, SQLException {
        Paralelo Objrepre = new Paralelo();
        boolean bandera = true;

        Objrepre = ObjDatrepre.Consultar(gra);
        bandera = true;
        return bandera;
    }

    public boolean RegistrarParalelo(Paralelo ObjParelelo) {
        DataParalelo ObjDatPara = new DataParalelo();

        boolean bandera = true;

        ObjDatPara.RegistrarParalelo(ObjParelelo);

        bandera = true;

        return bandera;
    }

    public int Eliminar(Paralelo ObjParelelo) throws SQLException, ClassNotFoundException {
        return this.ObjDatrepre.Eliminar(ObjParelelo);
    }
}
