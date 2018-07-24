/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import clases.Asignatura;
import clases.Docente;
import clases.Estudiante;
import clases.Grado;
import clases.Nota;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataNota extends Conexion {

    private Nota objNot = new Nota();
    private Estudiante objEst = new Estudiante();
    private Asignatura objAsig = new Asignatura();

    Conexion c = new Conexion();

    public ResultSet Consultar() throws ClassNotFoundException, SQLException {
        Statement st = c.AbrirConexion().createStatement();//obj para poder manipular abre coneccion y crea unStatement 
        String Sentencia = "SELECT * FROM nota";//crea un a varible y ponermos la cadena para recuperar todo desde la BDD
        ResultSet rs = st.executeQuery(Sentencia);//recuper un un ResultSet y envio la varible a executeQuery
        return rs;//retornma en un obj ResultSet rs
    }
    public ResultSet Consultarid(Grado id) throws ClassNotFoundException, SQLException {
        Statement st = c.AbrirConexion().createStatement();//obj para poder manipular abre coneccion y crea unStatement 
        String Sentencia = "Select idEst from matricula WHERE idGra="+id.getId();//crea un a varible y ponermos la cadena para recuperar todo desde la BDD
        ResultSet rs = st.executeQuery(Sentencia);//recuper un un ResultSet y envio la varible a executeQuery
        return rs;//retornma en un obj ResultSet rs
    }
    public ResultSet Consultarestu(Estudiante id) throws ClassNotFoundException, SQLException {
        Statement st = c.AbrirConexion().createStatement();//obj para poder manipular abre coneccion y crea unStatement 
        String Sentencia = "Select idAsig,parcial1_1,parcial1_2, parcial1_3, Quimestre1, parcial2_1,parcial2_2, parcial2_3, Quimestre2, NotaFinal from nota WHERE idEst="+id.getCodigoCarnet();//crea un a varible y ponermos la cadena para recuperar todo desde la BDD
        ResultSet rs = st.executeQuery(Sentencia);//recuper un un ResultSet y envio la varible a executeQuery
        return rs;//retornma en un obj ResultSet rs
    }
    public ResultSet ConsultarAsig(Asignatura id) throws ClassNotFoundException, SQLException {
        Statement st = c.AbrirConexion().createStatement();//obj para poder manipular abre coneccion y crea unStatement 
        String Sentencia = "Select parcial1_1,parcial1_2, parcial1_3, Quimestre1, parcial2_1,parcial2_2, parcial2_3, Quimestre2, NotaFinal,idEst from nota WHERE idAsig="+id.getIdasig();//crea un a varible y ponermos la cadena para recuperar todo desde la BDD
        ResultSet rs = st.executeQuery(Sentencia);//recuper un un ResultSet y envio la varible a executeQuery
        return rs;//retornma en un obj ResultSet rs
    }
   
  public int Insertar (Nota ObjNotas) throws SQLException, ClassNotFoundException{
        int retorno=0;
        Statement st=c.getConexion().createStatement();
        String sentencia="INSERT INTO nota (idAsig,parcial1_1,parcial1_2, parcial1_3, Quimestre1, parcial2_1,parcial2_2, parcial2_3, Quimestre2, NotaFinal,idEst)  VALUES ("
                     +"'" +ObjNotas.getAsignaturas().getIdasig()+ "'" 
                +","+ "'" +ObjNotas.getPar11()+ "'" 
                +","+ "'" +ObjNotas.getPar12()+ "'" 
                +","+ "'" +ObjNotas.getPar13()+ "'" 
                +","+ "'" +ObjNotas.getQuimestre1()+   "'"
                +","+ "'" +ObjNotas.getPar21()+    "'" 
                +","+ "'" +ObjNotas.getPar22()+    "'" 
                +","+ "'" +ObjNotas.getPar23()+    "'" 
                +","+ "'" +ObjNotas.getQuimestre2()+  "'" 
                +","+ "'" +ObjNotas.getNotaFinal()+  "'" 
                +","+"'"+ObjNotas.getEstudiante().getCodigoCarnet()+"'"+")";
        System.out.println(sentencia);
        retorno = st.executeUpdate(sentencia);
        return retorno;
       
    }


    public ResultSet Consultar(Estudiante es) throws ClassNotFoundException, SQLException {
        Statement st = c.AbrirConexion().createStatement();//obj para poder manipular abre coneccion y crea unStatement 
        String Sentencia = "SELECT * FROM nota WHERE idEst=' " + es.getCodigoCarnet() + "'";//crea un a varible y ponermos la cadena para recuperar todo desde la BDD
        ResultSet rs = st.executeQuery(Sentencia);//recuper un un ResultSet y envio la varible a executeQuery
        return rs;//retornma en un obj ResultSet rs
    }
    public int Actualizar(Nota Objnotas) throws ClassNotFoundException, SQLException {
        int Retorno = 0;
        Statement st = c.getConexion().createStatement();
        String sentencia = "UPDATE nota SET parcial1_1=" + "'" + Objnotas.getPar11() + "'"
                + ", parcial1_2=" + "'" + Objnotas.getPar12() + "'"
                + ", parcial1_3=" + "'" + Objnotas.getPar13() + "'"
                + ", Quimestre1=" + "'" + Objnotas.getQuimestre1() + "'"
                + ", parcial2_1=" + "'" + Objnotas.getPar21() + "'"
                + ", parcial2_2=" + "'" + Objnotas.getPar22() + "'"
                + ", parcial2_3=" + "'" + Objnotas.getPar23() + "'"
                + ", Quimestre2=" + "'" + Objnotas.getQuimestre2() + "'"
                + ", NotaFinal=" + "'" + Objnotas.getNotaFinal() + "'"
                + "WHERE idEst=" + "'" + Objnotas.getEstudiante().getCodigoCarnet() + "'"
                + "and idAsig=" + "'" + Objnotas.getAsignaturas().getIdasig() + "'";
        Retorno = st.executeUpdate(sentencia);
        return Retorno;
    }

    public int idAsig(Grado gra, Docente doc) throws SQLException {
        int x = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "Select idAsignatura from asignatura WHERE idGra=? and idDoc=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, gra.getId());
            ps.setInt(2, doc.getCodigoCarnet());

            rs = ps.executeQuery();
            if (rs.next()) {
                x = Integer.parseInt(rs.getString("idAsignatura"));
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

    public ArrayList<Estudiante> ListaEstu(Grado gra) throws SQLException {
        ArrayList<Estudiante> Listado = new ArrayList<>();
        Estudiante estu = new Estudiante();

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = " Select idEst from matricula WHERE idGra=? ";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, gra.getId());
            rs = ps.executeQuery();
            while (rs.next()) {
                estu.setCodigoCarnet(rs.getInt("idEst"));

                Listado.add(estu);
            }
            return Listado;
        } catch (Exception e) {
            System.err.println("errorxxx   " + e);
            return Listado;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
