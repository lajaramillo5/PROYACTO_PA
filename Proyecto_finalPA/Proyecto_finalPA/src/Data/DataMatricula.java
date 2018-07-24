/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import clases.Matricula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lenovo
 */
public class DataMatricula extends Conexion {

    private Matricula matri = new Matricula();
    Conexion c = new Conexion();

    public ResultSet Consultar() throws ClassNotFoundException, SQLException {
        Statement st = c.AbrirConexion().createStatement();//obj para poder manipular abre coneccion y crea unStatement 
        String Sentencia = "SELECT * FROM matricula";//crea un a varible y ponermos la cadena para recuperar todo desde la BDD
        ResultSet rs = st.executeQuery(Sentencia);//recuper un un ResultSet y envio la varible a executeQuery
        return rs;//retornma en un obj ResultSet rs
    }

    public Matricula RegistrarMatricula(Matricula Objmatri) {

        Matricula Objmat = new Matricula();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "INSERT INTO matricula (idAño,idEst,idRepre,idGra) VALUES (?,?,?,?)";

        try {

            ps = con.prepareStatement(sql);

            ps.setInt(1, Objmatri.getAnio().getIdaño());
            ps.setInt(2, Objmatri.getEstu().getCodigoCarnet());
            ps.setInt(3, Objmatri.getRepre().getCodigoCarnet());
            ps.setInt(4, Objmatri.getGrado().getId());

            System.out.println("dddd   " + ps.toString());
            ps.execute();
            return Objmat;
        } catch (Exception e) {
            System.err.println("errorxxx   " + e);
            return Objmat;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public int Eliminar(Matricula matri) throws SQLException, ClassNotFoundException {
        int intRetorno = 0;//declarmos
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "DELETE FROM matricula WHERE idEst=" + "'" + matri.getEstu().getCodigoCarnet() + "'";//"'" porque es de tipo String se cierra entre comllias
        intRetorno = st.executeUpdate(Sentencia);
//        c.CerrarConexion();
        return intRetorno;
    }

    public int idRepre(Matricula matri) throws SQLException {
        int x = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "Select idMatri from representante WHERE idEst=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, matri.getEstu().getCodigoCarnet());
            rs = ps.executeQuery();
            if (rs.next()) {
                x = Integer.parseInt(rs.getString("idMatri"));
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

    public Matricula Consultar(Matricula matri) throws SQLException {
        //sentencia sql
        String sql = "SELECT * FROM matricula WHERE idEst='"
                + matri.getEstu().getCodigoCarnet() + "'";
        //utilizar el flujo de la coneccion a la bd
        PreparedStatement ps = c.getConexion().prepareStatement(sql);
        Statement instruccionSQL = c.getConexion().createStatement();

        //ejucatar el sql
        ResultSet execute = ps.executeQuery();
        //1er registro
        System.out.println(matri);

        return matri;
    }

}
