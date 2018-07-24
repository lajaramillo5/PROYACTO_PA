/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import Data.DataNota;
import clases.Asignatura;
import clases.Docente;
import clases.Estudiante;
import clases.Grado;
import clases.Nota;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class BLNotas {

    DataNota ObjDatNot = new DataNota();
    Nota ObjNot = new Nota();
    public static ArrayList lstnotas;
    Asignatura asig = new Asignatura();
    Estudiante est = new Estudiante();

  

    public int Consultar_id(Grado doc, Docente doce) throws ClassNotFoundException, SQLException {

        int x = 0;

        x = ObjDatNot.idAsig(doc, doce);

        return x;
    }
     public double Calcularquimestre1(Nota objnotas) throws ClassNotFoundException, SQLException {

        double x = 0;

        x = (objnotas.getPar11()+objnotas.getPar12()+objnotas.getPar13())/3;

        return x;
    }
     public double Calcularquimestre2(Nota objnotas) throws ClassNotFoundException, SQLException {

        double x = 0;

        x = (objnotas.getPar21()+objnotas.getPar22()+objnotas.getPar23())/3;

        return x;
    }
     public double CalcularNotafinal(Nota objnotas) throws ClassNotFoundException, SQLException {

        double x = 0;

        x = (objnotas.getQuimestre1()+objnotas.getQuimestre2())/2;

        return x;
    }
    
     

    public ArrayList<Estudiante> Consulta(Grado id) throws ClassNotFoundException, SQLException {
        ArrayList<Estudiante> listaestu = new ArrayList<>();
        String ids = "";

        ResultSet rs;//recuper datos desde rs y los desgloso o desconpone
        listaestu = new ArrayList<>();
        rs = ObjDatNot.Consultarid(id);
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
                    ids = value;
                }

            }
            try {
                Estudiante p = new Estudiante(Integer.parseInt(ids));
                listaestu.add(p);
            } catch (Exception ex) {
                String msn = ex.getMessage();
            }
        }

        return listaestu;

    }

    public boolean Agregar(Nota Objnotas) throws ClassNotFoundException, SQLException {
        if (ObjDatNot.Insertar(Objnotas) == 1) {
            return true;
        } else {
            return false;

        }
    }



    public ArrayList<Nota> Consultar() throws ClassNotFoundException, SQLException {
        ArrayList<Nota> ArrayItems = new ArrayList<>();
        ResultSet rs = ObjDatNot.Consultar();
        while (rs.next()) {
            Nota ObjItem = new Nota(new Asignatura(rs.getInt(2)),rs.getDouble(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8), rs.getDouble(9),
                    rs.getDouble(10),rs.getDouble(11),new Estudiante(rs.getInt(12)));
            ArrayItems.add(ObjItem);
        }
        return ArrayItems;
    }
    public ArrayList<Nota> Consultares(Estudiante estu) throws ClassNotFoundException, SQLException {
        ArrayList<Nota> ArrayItems = new ArrayList<>();
        ResultSet rs = ObjDatNot.Consultarestu(estu);
        while (rs.next()) {
            Nota ObjItem = new Nota(new Asignatura(rs.getInt(1)),rs.getDouble(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7),
                    rs.getDouble(8), rs.getDouble(9), rs.getDouble(10),null);
            ArrayItems.add(ObjItem);
        }
        return ArrayItems;
    }
    public ArrayList<Estudiante> Consultarestu(Grado estu) throws ClassNotFoundException, SQLException {
        ArrayList<Estudiante> ArrayItems = new ArrayList<>();
        ResultSet rs = ObjDatNot.Consultarid(estu);
        while (rs.next()) {
            Estudiante ObjItem = new Estudiante(rs.getInt(1));
            ArrayItems.add(ObjItem);
        }
        return ArrayItems;
    }
    public ArrayList<Nota> Consultasig(Asignatura asig) throws ClassNotFoundException, SQLException {
        ArrayList<Nota> ArrayItems = new ArrayList<>();
        ResultSet rs = ObjDatNot.ConsultarAsig(asig);
        while (rs.next()) {
            Nota ObjItem = new Nota(rs.getDouble(1),rs.getDouble(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7),
                    rs.getDouble(8), rs.getDouble(9),new Estudiante(rs.getInt(10)));
            ArrayItems.add(ObjItem);
        }
        return ArrayItems;
    }

    public boolean Actualizar(Nota ObjItem) throws ClassNotFoundException, SQLException {
        if (ObjDatNot.Actualizar(ObjItem) == 1) {
            return true;
        } else {
            return false;
        }
    }

}
