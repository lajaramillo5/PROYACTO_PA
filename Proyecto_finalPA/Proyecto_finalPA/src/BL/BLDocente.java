/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import Data.DataDocente;
import Data.DataUsuario;
import clases.Docente;
import clases.Usuario;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class BLDocente {

    DataDocente ObjDatdoc = new DataDocente();
    Docente ObjCue = new Docente();
    public static ArrayList lstCliente;

    public ArrayList<Docente> ConsultaLista() throws ClassNotFoundException, SQLException {
        String nombre = "";
        String apellido = "";
        String direcion = "";
        String cedula = "";
        String edad = null;
        String telefono = null;
        String Correo = null;
        ResultSet rs;//recuper datos desde rs y los desgloso o desconpone
        lstCliente = new ArrayList<>();
        rs = ObjDatdoc.Consultar();
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
                Docente p = new Docente(nombre, apellido, Integer.parseInt(edad), cedula, direcion, telefono, Correo);
                lstCliente.add(p);
            } catch (Exception ex) {
                String msn = ex.getMessage();
            }
        }
//        this.cerrarConexion();
        return lstCliente;

    }

    public boolean Consultar(Docente docent) throws ClassNotFoundException, SQLException {
        Docente Objdocent = new Docente();
        boolean bandera = true;

        Objdocent = ObjDatdoc.Consultar(docent);
        bandera = true;
        return bandera;
    }

    public boolean RegistrarDocente(Docente Objdoce) {
        DataDocente ObjDatDocente = new DataDocente();

        boolean bandera = true;

        ObjDatDocente.RegistrarDocente(Objdoce);

        bandera = true;

        return bandera;
    }

    public int Modificar(Docente doc) throws ClassNotFoundException, SQLException {
        return ObjDatdoc.Modificar(doc);

    }

    public int Eliminar(Docente doc) throws SQLException, ClassNotFoundException {
        return this.ObjDatdoc.Eliminar(doc);
    }

    public int Consultar_id(Docente doc) throws ClassNotFoundException, SQLException {

        int x = 0;

        x = ObjDatdoc.idDoc(doc);

        return x;
    }

}
