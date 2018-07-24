/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import clases.Secretaria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lenovo
 */
public class DataAdmi extends Conexion{

    private Secretaria secretaria = new Secretaria();
    Conexion c = new Conexion();
    public ResultSet Consultar() throws ClassNotFoundException, SQLException
    {
        Statement st = c.AbrirConexion().createStatement();//obj para poder manipular abre coneccion y crea unStatement 
        String Sentencia = "SELECT * FROM secretaria";//crea un a varible y ponermos la cadena para recuperar todo desde la BDD
        ResultSet rs = st.executeQuery(Sentencia);//recuper un un ResultSet y envio la varible a executeQuery
        return rs;//retornma en un obj ResultSet rs
    }

    public Secretaria Consultar(Secretaria docent) throws SQLException {
        //sentencia sql
        String sql = "SELECT * FROM secretaria WHERE Cedula='"
                + docent.getCedula() + "'";
        //utilizar el flujo de la coneccion a la bd
        PreparedStatement ps = c.getConexion().prepareStatement(sql);
        Statement instruccionSQL = c.getConexion().createStatement();

        try {
            //ejucatar el sql
            ResultSet execute = ps.executeQuery();
            //1er registro
            System.out.println(secretaria);

            if (execute.first()) {
                secretaria.setNombre(execute.getString("Nombre"));
                secretaria.setApellido(execute.getString("Apellido"));
                secretaria.setEdad(Integer.parseInt(execute.getString("Edad")));
                secretaria.setCedula(execute.getString("Cedula"));
                secretaria.setDireccion(execute.getString("Direccion"));
                secretaria.setTelefono(execute.getString("Telefono"));
                secretaria.setDireccion(execute.getString("Direccion"));
            }
            //registros restantes
            while (execute.next()) {
                secretaria.setNombre(execute.getString("Nombre"));
                secretaria.setApellido(execute.getString("Apellido"));
                secretaria.setEdad(Integer.parseInt(execute.getString("Edad")));
                secretaria.setCedula(execute.getString("Cedula"));
                secretaria.setDireccion(execute.getString("Direccion"));
                secretaria.setTelefono(execute.getString("Telefono"));
                secretaria.setDireccion(execute.getString("Direccion"));
            }
        } catch (SQLException e) {
            secretaria = null;
            System.out.println(e);
        }
        System.out.println(secretaria);
        return secretaria;
    }

    public Secretaria RegistrarAdmi(Secretaria ObjDocente) {

        Secretaria Objsecre = new Secretaria();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "INSERT INTO secretaria (Nombre,Apellido,Edad,Cedula,Direccion,Telefono,Correo) VALUES (?,?,?,?,?,?,?)";

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
            return Objsecre;
        } catch (Exception e) {
            System.err.println("errorxxx   " + e);
            return Objsecre;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public int Eliminar(Secretaria secre) throws SQLException, ClassNotFoundException {
        int intRetorno = 0;//declarmos
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "DELETE FROM secretaria WHERE cedula=" + "'" + secre.getCedula() + "'";//"'" porque es de tipo String se cierra entre comllias
        intRetorno = st.executeUpdate(Sentencia);
//        c.CerrarConexion();
        return intRetorno;
    }


}
