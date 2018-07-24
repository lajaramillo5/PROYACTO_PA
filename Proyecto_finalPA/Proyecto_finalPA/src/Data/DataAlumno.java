/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import clases.Docente;
import clases.Estudiante;
import clases.Grado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lenovo
 */
public class DataAlumno extends Conexion {

    private Estudiante estudiante = new Estudiante();
    Conexion c = new Conexion();

    public ResultSet Consultar() throws ClassNotFoundException, SQLException {
        Statement st = c.AbrirConexion().createStatement();//obj para poder manipular abre coneccion y crea unStatement 
        String Sentencia = "SELECT * FROM estudiante";//crea un a varible y ponermos la cadena para recuperar todo desde la BDD
        ResultSet rs = st.executeQuery(Sentencia);//recuper un un ResultSet y envio la varible a executeQuery
        return rs;//retornma en un obj ResultSet rs
    }

    public Estudiante Consultar(Estudiante estu) throws SQLException {
        //sentencia sql
        String sql = "SELECT * FROM estudiante WHERE Cedula='"
                + estu.getCedula() + "'";
        //utilizar el flujo de la coneccion a la bd
        PreparedStatement ps = c.getConexion().prepareStatement(sql);
        Statement instruccionSQL = c.getConexion().createStatement();

        try {
            //ejucatar el sql
            ResultSet execute = ps.executeQuery();
            //1er registro
            System.out.println(estudiante);

            if (execute.first()) {
                estudiante.setNombre(execute.getString("Nombre"));
                estudiante.setApellido(execute.getString("Apellido"));
                estudiante.setEdad(Integer.parseInt(execute.getString("Edad")));
                estudiante.setCedula(execute.getString("Cedula"));
                estudiante.setDireccion(execute.getString("Direccion"));
                estudiante.setTelefono(execute.getString("Telefono"));
                estudiante.setDireccion(execute.getString("Direccion"));
            }
            //registros restantes
            while (execute.next()) {
                estudiante.setNombre(execute.getString("Nombre"));
                estudiante.setApellido(execute.getString("Apellido"));
                estudiante.setEdad(Integer.parseInt(execute.getString("Edad")));
                estudiante.setCedula(execute.getString("Cedula"));
                estudiante.setDireccion(execute.getString("Direccion"));
                estudiante.setTelefono(execute.getString("Telefono"));
                estudiante.setDireccion(execute.getString("Direccion"));
            }
        } catch (SQLException e) {
            estudiante = null;
            System.out.println(e);
        }
        System.out.println(estudiante);
        return estudiante;
    }

    public Estudiante RegistrarEstudiante(Estudiante ObjEstu) {

        Estudiante Objestu = new Estudiante();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "INSERT INTO estudiante (Nombre,Apellido,Edad,Cedula,Direccion,Telefono) VALUES (?,?,?,?,?,?)";

        try {

            ps = con.prepareStatement(sql);

            ps.setString(1, ObjEstu.getNombre());
            ps.setString(2, ObjEstu.getApellido());
            ps.setInt(3, ObjEstu.getEdad());
            ps.setString(4, ObjEstu.getCedula());
            ps.setString(5, ObjEstu.getDireccion());
            ps.setString(6, ObjEstu.getTelefono());
            System.out.println("dddd   " + ps.toString());
            ps.execute();
            return Objestu;
        } catch (Exception e) {
            System.err.println("errorxxx   " + e);
            return Objestu;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public int Eliminar(Estudiante ObjEstu) throws SQLException, ClassNotFoundException {
        int intRetorno = 0;//declarmos
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "DELETE FROM estudiante WHERE Cedula=" + "'" + ObjEstu.getCedula() + "'";//"'" porque es de tipo String se cierra entre comllias
        intRetorno = st.executeUpdate(Sentencia);
//        c.CerrarConexion();
        return intRetorno;
    }

    public int Modificar(Estudiante ObjEstu) throws ClassNotFoundException, SQLException {
        int Retorno = 0;
        Statement st = c.AbrirConexion().createStatement();
        String sentencia = "UPDATE estudiante SET Direccion=" + "'" + ObjEstu.getDireccion() + "'" + "WHERE Cedula=" + "'" + ObjEstu.getCedula() + "'";
        Retorno = st.executeUpdate(sentencia);
//         c.CerrarConexion();
        return Retorno;
    }
    public int idestu(Grado gra) throws SQLException {
        int x = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "Select idEst from matricula WHERE idGra=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, gra.getId());
            rs = ps.executeQuery();
            if (rs.next()) {
                x = Integer.parseInt(rs.getString("idEst"));
            }
            return x;
        } catch (Exception e) {
            System.err.println("errorxxx   " + e);
            return x;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }


    public int idEst(Estudiante estu) throws SQLException {
        int x = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "Select idEst from estudiante WHERE Cedula=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, estu.getCedula());
            rs = ps.executeQuery();
            if (rs.next()) {
                x = Integer.parseInt(rs.getString("idEst"));
            }
            return x;
        } catch (Exception e) {
            System.err.println("errorxxx   " + e);
            return x;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
