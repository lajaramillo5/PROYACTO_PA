/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import clases.AñoLectivo;
import clases.Docente;
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
public class DataGrado extends Conexion {

    private Grado Gra = new Grado();
    Conexion c = new Conexion();

    public ResultSet Consultar() throws ClassNotFoundException, SQLException {
        Statement st = c.AbrirConexion().createStatement();//obj para poder manipular abre coneccion y crea unStatement 
        String Sentencia = "SELECT * FROM grado";//crea un a varible y ponermos la cadena para recuperar todo desde la BDD
        ResultSet rs = st.executeQuery(Sentencia);//recuper un un ResultSet y envio la varible a executeQuery
        return rs;//retornma en un obj ResultSet rs
    }

    public Grado Consultar(Grado grado) throws SQLException {
        //sentencia sql
        String sql = "SELECT * FROM grado WHERE Nombre='"
                + grado.getNombre() + "'";
        //utilizar el flujo de la coneccion a la bd
        PreparedStatement ps = c.getConexion().prepareStatement(sql);
        Statement instruccionSQL = c.getConexion().createStatement();

        try {
            //ejucatar el sql
            ResultSet execute = ps.executeQuery();
            //1er registro
            System.out.println(grado);

            if (execute.first()) {
                grado.setNombre(execute.getString("Nombre"));

            }
            //registros restantes
            while (execute.next()) {
                grado.setNombre(execute.getString("Nombre"));

            }
        } catch (SQLException e) {
            grado = null;
            System.out.println(e);
        }
        System.out.println(grado);
        return grado;
    }

    public Grado RegistrarGrado(Grado ObjGrado) {

        Grado Objdocent = new Grado();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "INSERT INTO grado (Nombre,idParal,idAño) VALUES (?,?,?)";

        try {

            ps = con.prepareStatement(sql);

            ps.setString(1, ObjGrado.getNombre());
            ps.setInt(2, ObjGrado.getParalelo().getIdPar());
            ps.setInt(3, ObjGrado.getAño().getIdaño());

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

    public int Eliminar(Grado gra) throws SQLException, ClassNotFoundException {
        int intRetorno = 0;//declarmos
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "DELETE FROM grado WHERE Nombre=" + "'" + gra.getId() + "'";//"'" porque es de tipo String se cierra entre comllias
        intRetorno = st.executeUpdate(Sentencia);
//        c.CerrarConexion();
        return intRetorno;
    }

    public ResultSet ObtenerGrados(AñoLectivo p) throws ClassNotFoundException, SQLException {
        Statement st = c.AbrirConexion().createStatement();//obj para poder manipular abre coneccion y crea unStatement 
        String Sentencia = "SELECT * FROM grado WHERE idAño=" + p.getIdaño();//crea un a varible y ponermos la cadena para recuperar todo desde la BDD
        ResultSet rs = st.executeQuery(Sentencia);//recuper un un ResultSet y envio la varible a executeQuery
        return rs;

    }

    public ResultSet ObtenerGrado(Grado a) throws ClassNotFoundException, SQLException {
        Statement st = c.AbrirConexion().createStatement();//obj para poder manipular abre coneccion y crea unStatement 
        String Sentencia = "SELECT * FROM grado WHERE idGra=" + a.getId();//crea un a varible y ponermos la cadena para recuperar todo desde la BDD
        ResultSet rs = st.executeQuery(Sentencia);//recuper un un ResultSet y envio la varible a executeQuery
        return rs;//retornma en un obj ResultSet rs
    }

    public int idGra(Docente doc) throws SQLException {
        int x = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "Select idGra from asignatura WHERE idDoc=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, doc.getCodigoCarnet());
            rs = ps.executeQuery();
            if (rs.next()) {
                x = Integer.parseInt(rs.getString("idGra"));
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
