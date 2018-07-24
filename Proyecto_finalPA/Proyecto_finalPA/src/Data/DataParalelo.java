/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import clases.Paralelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lenovo
 */
public class DataParalelo extends Conexion {

    private Paralelo Gra = new Paralelo();
    Conexion c = new Conexion();

    public ResultSet Consultar() throws ClassNotFoundException, SQLException {
        Statement st = c.AbrirConexion().createStatement();//obj para poder manipular abre coneccion y crea unStatement 
        String Sentencia = "SELECT * FROM paralelo";//crea un a varible y ponermos la cadena para recuperar todo desde la BDD
        ResultSet rs = st.executeQuery(Sentencia);//recuper un un ResultSet y envio la varible a executeQuery
        return rs;//retornma en un obj ResultSet rs
    }

    public Paralelo Consultar(Paralelo paralelo) throws SQLException {
        //sentencia sql
        String sql = "SELECT * FROM paralelo WHERE Nombre='"
                + paralelo.getNombre() + "'";
        //utilizar el flujo de la coneccion a la bd
        PreparedStatement ps = c.getConexion().prepareStatement(sql);
        Statement instruccionSQL = c.getConexion().createStatement();

        try {
            //ejucatar el sql
            ResultSet execute = ps.executeQuery();
            //1er registro
            System.out.println(paralelo);

            if (execute.first()) {
                paralelo.setNombre(execute.getString("Nombre"));

            }
            //registros restantes
            while (execute.next()) {
                paralelo.setNombre(execute.getString("Nombre"));

            }
        } catch (SQLException e) {
            paralelo = null;
            System.out.println(e);
        }
        System.out.println(paralelo);
        return paralelo;
    }

    public Paralelo RegistrarParalelo(Paralelo ObjPara) {

        Paralelo Objdparale = new Paralelo();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "INSERT INTO paralelo (Nombre) VALUES (?)";

        try {

            ps = con.prepareStatement(sql);

            ps.setString(1, ObjPara.getNombre());

            System.out.println("dddd   " + ps.toString());
            ps.execute();
            return Objdparale;
        } catch (Exception e) {
            System.err.println("errorxxx   " + e);
            return Objdparale;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public int Eliminar(Paralelo objParalelo) throws SQLException, ClassNotFoundException {
        int intRetorno = 0;//declarmos
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "DELETE FROM paralelo WHERE idParalelo=" + "'" + objParalelo.getIdPar() + "'";//"'" porque es de tipo String se cierra entre comllias
        intRetorno = st.executeUpdate(Sentencia);
//        c.CerrarConexion();
        return intRetorno;
    }

}
