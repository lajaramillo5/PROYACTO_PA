/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

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
public class DataUsuario extends Conexion{
     private Usuario usuario = new Usuario();
    Conexion c = new Conexion();
   public int idRol(Usuario user) throws SQLException {
        int x = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "Select Funcion from usuario WHERE User=? and password=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getUser());
            ps.setString(2, user.getPassword());
            rs = ps.executeQuery();
            if (rs.next()) {
                x = Integer.parseInt(rs.getString("Funcion"));
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

  public Usuario RegistrarUsuario(Usuario ObjUsuario) {

        Usuario ObjCli = new Usuario();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "INSERT INTO usuario (Funcion,User,password) VALUES (?,?,?)";

        try {
                  
            ps = con.prepareStatement(sql);
     
            
            ps.setInt(1, ObjUsuario.getRoll());
            ps.setString(2, ObjUsuario.getUser());
            ps.setString(3, ObjUsuario.getPassword());
            System.out.println("dddd   "+ps.toString());
            ps.execute();
            return ObjCli;
        } catch (Exception e) {
            System.err.println("errorxxx   "+e);
            return ObjCli;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
     public int Eliminar(Usuario user) throws SQLException, ClassNotFoundException{
        int intRetorno=0;//declarmos
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "DELETE FROM usuario WHERE password="+"'"+user.getPassword()+"'";//"'" porque es de tipo String se cierra entre comllias
        intRetorno = st.executeUpdate(Sentencia);
//        c.CerrarConexion();
        return intRetorno;
    }

   
    
}
