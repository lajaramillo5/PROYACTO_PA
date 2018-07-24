/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import clases.Representante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lenovo
 */
public class DataRepresentante extends Conexion{

    private Representante repre = new Representante();
    Conexion c = new Conexion();
    public ResultSet Consultar() throws ClassNotFoundException, SQLException
    {
        Statement st = c.AbrirConexion().createStatement();//obj para poder manipular abre coneccion y crea unStatement 
        String Sentencia = "SELECT * FROM representante";//crea un a varible y ponermos la cadena para recuperar todo desde la BDD
        ResultSet rs = st.executeQuery(Sentencia);//recuper un un ResultSet y envio la varible a executeQuery
        return rs;//retornma en un obj ResultSet rs
    }

    public Representante Consultar(Representante repre) throws SQLException {
        //sentencia sql
        String sql = "SELECT * FROM representante WHERE Cedula='"
                + repre.getCedula() + "'";
        //utilizar el flujo de la coneccion a la bd
        PreparedStatement ps = c.getConexion().prepareStatement(sql);
        Statement instruccionSQL = c.getConexion().createStatement();

        try {
            //ejucatar el sql
            ResultSet execute = ps.executeQuery();
            //1er registro
            System.out.println(repre);

            if (execute.first()) {
                repre.setNombre(execute.getString("Nombre"));
                repre.setApellido(execute.getString("Apellido"));
                repre.setEdad(Integer.parseInt(execute.getString("Edad")));
                repre.setCedula(execute.getString("Cedula"));
                repre.setDireccion(execute.getString("Direccion"));
                repre.setTelefono(execute.getString("Telefono"));
                repre.setDireccion(execute.getString("Direccion"));
            }
            //registros restantes
            while (execute.next()) {
                repre.setNombre(execute.getString("Nombre"));
                repre.setApellido(execute.getString("Apellido"));
                repre.setEdad(Integer.parseInt(execute.getString("Edad")));
                repre.setCedula(execute.getString("Cedula"));
                repre.setDireccion(execute.getString("Direccion"));
                repre.setTelefono(execute.getString("Telefono"));
                repre.setDireccion(execute.getString("Direccion"));
            }
        } catch (SQLException e) {
            repre = null;
            System.out.println(e);
        }
        System.out.println(repre);
        return repre;
    }
    
    public Representante RegistrarDocente(Representante ObjRepresent) {

        Representante Objdocent = new Representante();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "INSERT INTO representante (Nombre,Apellido,Edad,Cedula,Direccion,Telefono,Correo) VALUES (?,?,?,?,?,?,?)";

        try {

            ps = con.prepareStatement(sql);

            
            ps.setString(1, ObjRepresent.getNombre());
            ps.setString(2, ObjRepresent.getApellido());
             ps.setInt(3, ObjRepresent.getEdad());
            ps.setString(4, ObjRepresent.getCedula());
            ps.setString(5, ObjRepresent.getDireccion());
            ps.setString(6, ObjRepresent.getTelefono());
            ps.setString(7, ObjRepresent.getCorreo());
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

    public int Eliminar(Representante objRepre) throws SQLException, ClassNotFoundException {
        int intRetorno = 0;//declarmos
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "DELETE FROM representante WHERE Cedula=" + "'" + objRepre.getCedula() + "'";//"'" porque es de tipo String se cierra entre comllias
        intRetorno = st.executeUpdate(Sentencia);
//        c.CerrarConexion();
        return intRetorno;
    }

    public int Modificar(Representante objRepre) throws ClassNotFoundException, SQLException {
        int Retorno = 0;
        Statement st = c.AbrirConexion().createStatement();
        String sentencia = "UPDATE representante SET Direccion=" + "'" + objRepre.getDireccion() + "'" + "WHERE Cedula=" + "'" + objRepre.getCedula() + "'";
        Retorno = st.executeUpdate(sentencia);
//         c.CerrarConexion();
        return Retorno;
    }
     public int idRepre(Representante repre) throws SQLException {
        int x = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "Select idRepre from representante WHERE Cedula=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, repre.getCedula());
            rs = ps.executeQuery();
            if (rs.next()) {
                x =Integer.parseInt(rs.getString("idRepre"));
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
