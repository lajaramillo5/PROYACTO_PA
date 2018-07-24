/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import Data.DataUsuario;
import clases.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class BLUsuario {

    DataUsuario ObjDatUsu = new DataUsuario();
    Usuario ObjUser = new Usuario();
    public static ArrayList lstCliente;

    public int Consultar(Usuario user) throws ClassNotFoundException, SQLException {
        int x=0;

        x = ObjDatUsu.idRol(user);
        return x;
    }

    public boolean RegistrarUsuario(Usuario ObjUsu) {
        DataUsuario ObjDatUsur = new DataUsuario();

        boolean bandera = true;

        ObjDatUsur.RegistrarUsuario(ObjUsu);

        bandera = true;

        return bandera;
    }

    public int Eliminar(Usuario delet) throws SQLException, ClassNotFoundException {
        return this.ObjDatUsu.Eliminar(delet);
    }
}
