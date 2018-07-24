/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import clases.Docente;
import clases.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lenovo
 */
public class DataDocente extends Conexion {

    private Docente docente = new Docente();
    Conexion c = new Conexion();

    public ResultSet Consultar() throws ClassNotFoundException, SQLException {
        Statement st = c.AbrirConexion().createStatement();//obj para poder manipular abre coneccion y crea unStatement 
        String Sentencia = "SELECT * FROM docente";//crea un a varible y ponermos la cadena para recuperar todo desde la BDD
        ResultSet rs = st.executeQuery(Sentencia);//recuper un un ResultSet y envio la varible a executeQuery
        return rs;//retornma en un obj ResultSet rs
    }

    public Docente Consultar(Docente docent) throws SQLException {
        //sentencia sql
        String sql = "SELECT * FROM docente WHERE Cedula='"
                + docent.getCedula() + "'";
        //utilizar el flujo de la coneccion a la bd
        PreparedStatement ps = c.getConexion().prepareStatement(sql);
        Statement instruccionSQL = c.getConexion().createStatement();

        try {
            //ejucatar el sql
            ResultSet execute = ps.executeQuery();
            //1er registro
            if (execute.first()) {
                docente.setNombre(execute.getString("Nombre"));
                docente.setApellido(execute.getString("Apellido"));
                docente.setEdad(Integer.parseInt(execute.getString("Edad")));
                docente.setCedula(execute.getString("Cedula"));
                docente.setDireccion(execute.getString("Direccion"));
                docente.setTelefono(execute.getString("Telefono"));
                docente.setDireccion(execute.getString("Direccion"));
            }
            //registros restantes
            while (execute.next()) {
                docente.setNombre(execute.getString("Nombre"));
                docente.setApellido(execute.getString("Apellido"));
                docente.setEdad(Integer.parseInt(execute.getString("Edad")));
                docente.setCedula(execute.getString("Cedula"));
                docente.setDireccion(execute.getString("Direccion"));
                docente.setTelefono(execute.getString("Telefono"));
                docente.setDireccion(execute.getString("Direccion"));
            }
        } catch (SQLException e) {
            docente = null;
            System.out.println(e);
        }
        return docente;
    }

    public Docente Consultar_id(String cedula) throws SQLException {
        //sentencia sql
        String sql = "SELECT * FROM docente WHERE Cedula='"
                + cedula + "'";
        //utilizar el flujo de la coneccion a la bd
        PreparedStatement ps = c.getConexion().prepareStatement(sql);
        Statement instruccionSQL = c.getConexion().createStatement();

        try {
            //ejucatar el sql
            ResultSet execute = ps.executeQuery();
            //1er registro
          

            if (execute.first()) {
                docente.setCodigoCarnet(Integer.parseInt(execute.getString("idRepresentante")));
                docente.setNombre(execute.getString("Nombre"));
                docente.setApellido(execute.getString("Apellido"));
                docente.setEdad(Integer.parseInt(execute.getString("Edad")));
                docente.setCedula(execute.getString("Cedula"));
                docente.setDireccion(execute.getString("Direccion"));
                docente.setTelefono(execute.getString("Telefono"));
                docente.setDireccion(execute.getString("Direccion"));
            }
            //registros restantes
            while (execute.next()) {
                docente.setNombre(execute.getString("Nombre"));
                docente.setApellido(execute.getString("Apellido"));
                docente.setEdad(Integer.parseInt(execute.getString("Edad")));
                docente.setCedula(execute.getString("Cedula"));
                docente.setDireccion(execute.getString("Direccion"));
                docente.setTelefono(execute.getString("Telefono"));
                docente.setDireccion(execute.getString("Direccion"));
            }
        } catch (SQLException e) {
            docente = null;
            System.out.println(e);
        }
        System.out.println(docente);
        return docente;
    }

    public Docente RegistrarDocente(Docente ObjDocente) {

        Docente Objdocent = new Docente();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "INSERT INTO docente (Nombre,Apellido,Edad,Cedula,Direccion,Telefono,Correo) VALUES (?,?,?,?,?,?,?)";

        try {

            ps = con.prepareStatement(sql);

            ps.setString(1, ObjDocente.getNombre());
            ps.setString(2, ObjDocente.getApellido());
            ps.setInt(3, ObjDocente.getEdad());
            ps.setString(4, ObjDocente.getCedula());
            ps.setString(5, ObjDocente.getDireccion());
            ps.setString(6, ObjDocente.getTelefono());
            ps.setString(7, ObjDocente.getCorreo());

            System.out.println("dddd   " + ps.toString());
            ps.execute();
            return Objdocent;
        } catch (Exception e) {
            System.err.println("errorxxx   " + e);
            return Objdocent;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public int Eliminar(Docente doc) throws SQLException, ClassNotFoundException {
        int intRetorno = 0;//declarmos
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "DELETE FROM docente WHERE Cedula=" + "'" + doc.getCedula() + "'";//"'" porque es de tipo String se cierra entre comllias
        intRetorno = st.executeUpdate(Sentencia);
//        c.CerrarConexion();
        return intRetorno;
    }

    public int Modificar(Docente doc) throws ClassNotFoundException, SQLException {
        int Retorno = 0;
        Statement st = c.AbrirConexion().createStatement();
        String sentencia = "UPDATE docente SET Direccion=" + "'" + doc.getDireccion() + "'" + "WHERE Cedula=" + "'" + doc.getCedula()+ "'";
        Retorno = st.executeUpdate(sentencia);
//         c.CerrarConexion();
        return Retorno;
    }
     public int idDoc(Docente doc) throws SQLException {
        int x = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "Select idDoc from docente WHERE Cedula=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, doc.getCedula());
            rs = ps.executeQuery();
            if (rs.next()) {
                x =Integer.parseInt(rs.getString("idDoc"));
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
