/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import clases.Asignatura;
import clases.Docente;
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
public class DataAsignatura extends Conexion {

    private Asignatura asignatura = new Asignatura();
    Conexion c = new Conexion();

    public ResultSet Consultar() throws ClassNotFoundException, SQLException {
        Statement st = c.AbrirConexion().createStatement();//obj para poder manipular abre coneccion y crea unStatement 
        String Sentencia = "SELECT * FROM asignatura";//crea un a varible y ponermos la cadena para recuperar todo desde la BDD
        ResultSet rs = st.executeQuery(Sentencia);//recuper un un ResultSet y envio la varible a executeQuery
        return rs;//retornma en un obj ResultSet rs
    }

   public int idAsig(Asignatura asig) throws SQLException {
        int x = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "Select idAsignatura from asignatura WHERE Nombre=? and idDoc=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, asig.getNombre());
            ps.setInt(2, asig.getDocente().getCodigoCarnet());
            rs = ps.executeQuery();
            if (rs.next()) {
                x =Integer.parseInt(rs.getString("idAsignatura"));
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

    public Asignatura Consultar(Asignatura docent) throws SQLException {
        //sentencia sql
        String sql = "SELECT * FROM asignatura WHERE Nombre='"
                + docent.getNombre() + "'";
        //utilizar el flujo de la coneccion a la bd
        PreparedStatement ps = c.getConexion().prepareStatement(sql);
        Statement instruccionSQL = c.getConexion().createStatement();

        try {
            //ejucatar el sql
            ResultSet execute = ps.executeQuery();
            //1er registro
            System.out.println(asignatura);

            if (execute.first()) {
                asignatura.setNombre(execute.getString("Nombre"));
                asignatura.setHorario(execute.getString("Horario"));

            }
            //registros restantes
            while (execute.next()) {
                asignatura.setNombre(execute.getString("Nombre"));
                asignatura.setHorario(execute.getString("Horario"));
            }
        } catch (SQLException e) {
            asignatura = null;
            System.out.println(e);
        }
        System.out.println(asignatura);
        return asignatura;
    }

    public Asignatura RegistrarAsignatura(Asignatura ObjAsig) {

        Asignatura Objasig = new Asignatura();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "INSERT INTO asignatura (Nombre,Horario,idDoc,idGra) VALUES (?,?,?,?)";

        try {

            ps = con.prepareStatement(sql);

            ps.setString(1, ObjAsig.getNombre());
            ps.setString(2, ObjAsig.getHorario());
            ps.setInt(4, ObjAsig.getGrado().getId());
            ps.setInt(3, ObjAsig.getDocente().getCodigoCarnet());

            System.out.println("dddd   " + ps.toString());
            ps.execute();
            return Objasig;
        } catch (Exception e) {
            System.err.println("errorxxx   " + e);
            return Objasig;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
       public ResultSet ObtenerAsignaturas(Docente a) throws ClassNotFoundException, SQLException{
        Statement st = c.AbrirConexion().createStatement();//obj para poder manipular abre coneccion y crea unStatement 
        String Sentencia = "SELECT * FROM asignatura WHERE idDoc="+a.getCodigoCarnet();//crea un a varible y ponermos la cadena para recuperar todo desde la BDD
        ResultSet rs = st.executeQuery(Sentencia);//recuper un un ResultSet y envio la varible a executeQuery
        return rs;//retornma en un obj ResultSet rs
    }
}
