/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author utpl
 */
public class Expresiones {
    public boolean mailValido(String email) {       
       Pattern pat = 
       Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
       Matcher mat = pat.matcher(email);
       if(mat.find()){
          return true;
       }else{
          return false;
     }
   }
        public boolean apellidoPersona(String persona) {       
       Pattern pat = 
       Pattern.compile("[A-Za-z0-9]");
       Matcher mat = pat.matcher(persona);
       if(mat.find()){
          return true;
       }else{
          return false;
     }
   }
     public boolean nombrePersona(String persona) {       
       Pattern pat = 
       Pattern.compile("[A-Za-z0-9]");
       Matcher mat = pat.matcher(persona);
       if(mat.find()){
          return true;
       }else{
          return false;
     }
   }
      public boolean calle(String persona) {       
       Pattern pat = 
       Pattern.compile("[A-Za-z0-9]");
       Matcher mat = pat.matcher(persona);
       if(mat.find()){
          return true;
       }else{
          return false;
     }
   }
       public boolean referencia(String persona) {       
       Pattern pat = 
       Pattern.compile("[A-Za-z0-9]");
       Matcher mat = pat.matcher(persona);
       if(mat.find()){
          return true;
       }else{
          return false;
     }
   }
    public boolean soloNumeros(String cedula) {       
       Pattern pat = Pattern.compile("[0-9]{10}");
       Matcher mat = pat.matcher(cedula);
       if(mat.find()){
          return true;
       }else{
          return false;
     }
   }
     public boolean Numerocasa(String cedula) {       
       Pattern pat = Pattern.compile("[0-9]+\\-[0-9]");
       Matcher mat = pat.matcher(cedula);
       if(mat.find()){
          return true;
       }else{
          return false;
     }
   }
     public boolean NumeroTelefono(String cedula) {       
       Pattern pat = Pattern.compile("[0-9]{2}+\\-[0-9]{7}");
       Matcher mat = pat.matcher(cedula);
       if(mat.find()){
          return true;
       }else{
          return false;
     }
   }
      public boolean fecha(String cedula) {       
       Pattern pat = Pattern.compile("[0-3]{1}+[0-9]{1}\\/[0-1]{1}+[0-9]{1}+\\/[2-9]{1}+[0-9]{3}");
       Matcher mat = pat.matcher(cedula);
       if(mat.find()){
          return true;
       }else{
          return false;
     }
   }

  
    
}
