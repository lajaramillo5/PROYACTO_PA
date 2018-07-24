/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import Data.DataAnio;
import clases.AñoLectivo;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class BLAnio {
     DataAnio ObjDatrepre = new DataAnio();
    AñoLectivo ObjRep = new AñoLectivo();
    public static ArrayList lstanios;

    public ArrayList<AñoLectivo> ConsultaLista() throws ClassNotFoundException, SQLException {
        String inicio = "";
        String fin = "";
        
        ResultSet rs;//recuper datos desde rs y los desgloso o desconpone
        lstanios = new ArrayList<>();
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
                if (columnName.equals("Fecha_inicial")) {
                    inicio = value;
                }
                if (columnName.equals("Fecha_Final")) {
                   fin = value;
                }
            }
            try {
                AñoLectivo p = new AñoLectivo(Date.valueOf(inicio),Date.valueOf(fin));
                lstanios.add(p);
            } catch (Exception ex) {
                String msn = ex.getMessage();
            }
        }
//        this.cerrarConexion();
        return lstanios;

    }
      public boolean RegistrarGrado(AñoLectivo Objanio) {
        DataAnio ObjDatanio = new DataAnio();

        boolean bandera = true;

        ObjDatanio.RegistrarAnio(Objanio);

        bandera = true;

        return bandera;
    }
        public int Consultar_id(AñoLectivo anio) throws ClassNotFoundException, SQLException {
       
        int x=0;

        x=ObjDatrepre.idAnio(anio);
       
        return x;
    }
      
  
}
