/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author lenovo
 */
public class Usuario {
    int codigo;
     int roll;
   String user;
     String password;

    public Usuario() {
    }

    public Usuario(int codigo, int roll, String user, String password) {
        this.codigo = codigo;
        this.roll = roll;
        this.user = user;
        this.password = password;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getRoll() {
        return roll;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" + "codigo=" + codigo + ", roll=" + roll + ", user=" + user + ", password=" + password + '}';
    }
     
}
