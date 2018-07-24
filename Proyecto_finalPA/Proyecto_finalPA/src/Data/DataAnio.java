/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import clases.AñoLectivo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lenovo
 */
public class DataAnio extends Conexion {

    Conexion c = new Conexion();

    public ResultSet Consultar() throws ClassNotFoundException, SQLException {
        Statement st = c.AbrirConexion().createStatement();//obj para poder manipular abre coneccion y crea unStatement 
        String Sentencia = "SELECT * FROM año_lectivo";//crea un a varible y ponermos la cadena para recuperar todo desde la BDD
        ResultSet rs = st.executeQuery(Sentencia);//recuper un un ResultSet y envio la varible a executeQuery
        return rs;//retornma en un obj ResultSet rs
    }

    public AñoLectivo RegistrarAnio(AñoLectivo Objanio) {

        AñoLectivo Objanios = new AñoLectivo();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "INSERT INTO año_lectivo(Fecha_inicial,Fecha_Final) VALUES (?,?)";

        try {

            ps = con.prepareStatement(sql);

            ps.setDate(1, Objanio.getInicio());
            ps.setDate(2, Objanio.getFin());

            System.out.println("dddd   " + ps.toString());
            ps.execute();
            return Objanios;
        } catch (Exception e) {
            System.err.println("errorxxx   " + e);
            return Objanios;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public int idAnio(AñoLectivo anio) throws SQLException {
        int x = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "Select idAño from año_lectivo WHERE Fecha_inicial=";
        try {
            ps = con.prepareStatement(sql);
            ps.setDate(1, anio.getInicio());
            rs = ps.executeQuery();
            if (rs.next()) {
                x = Integer.parseInt(rs.getString("idAño"));
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
