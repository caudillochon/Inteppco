/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.Tables;

import DB.Conexion;
import DB.Modelos.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import javax.swing.JOptionPane;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Caudillo
 */
public class EncargadoMtoT {
    EncargadoMto encargadoMto;
    String error;
    public EncargadoMtoT(){
        error="";
        encargadoMto=new EncargadoMto();
    }
  public  String[] nameField() {
        String[] names = new String[]{"id", "nombre", "Compañia", "telefono", 
            "correo", "direccion"};
        return names;
    }
  public  String nameTable() {
        return "encargadomto";
    }
  /*
    public static void main(String[] args) {
        EncargadoMto encargadoMto= new EncargadoMto();
        encargadoMto.nombre="nombre";
        encargadoMto.correo="correo@correo.no";
        encargadoMto.compañia="er";
        encargadoMto.direccion="er";
        encargadoMto.telefono=1234567890;
        new EncargadoMtoT().insertar(encargadoMto);
    }*/
  private int insertar() { 
      int id=-1;
      if (encargadoMto != null) {        
        String query="insert into "+nameTable()+" "+Arrays.toString(nameField())
                .replace('[', '(').replace(']', ')')+" values (null,?,?,?,?,?)";
                
        try {
            Connection con = Conexion.createConnection();
            PreparedStatement insertar = con.prepareStatement(query,
                    Statement.RETURN_GENERATED_KEYS);
                insertar.setString  (1, encargadoMto.nombre);
                insertar.setString  (2, encargadoMto.compañia);
                insertar.setInt     (3, encargadoMto.telefono);
                insertar.setString  (4, encargadoMto.correo);
                insertar.setString  (5, encargadoMto.direccion);
                
            insertar.executeUpdate();
            ResultSet generate=insertar.getGeneratedKeys();
            generate.next();
            id= generate.getInt(1);
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,"no se pudo insertar  "
                    + "verifique su conexion a la base de datos", 
            "Inntepco", JOptionPane.ERROR_MESSAGE);
        }
      }
        return id;
    }
  public EncargadoMto insertar(EncargadoMto encargadoMto) {
        if (encargadoMto != null) {
            
            if (validate(encargadoMto)) {
                encargadoMto.id=insertar();
                return encargadoMto;
            }else{
                JOptionPane.showMessageDialog(null, error, 
            "Inntepco", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        return null;

    }
  //validaciones here
  public boolean validate(EncargadoMto encargadoMto){
      this.encargadoMto=encargadoMto;
      boolean value=true;
      if(encargadoMto.nombre==null){
          error+="Nombre invalido \n";
          value= false;
      }
      else{if(encargadoMto.nombre.trim().isEmpty()|
         encargadoMto.nombre.length()>100 | encargadoMto.nombre.length()<5
              ){
          error+="Nombre invalido \n";
          value= false;
      }}
      if(encargadoMto.correo==null){
          error+="Correo invalido \n";
          value= false;
      }else{
      if(!validateEmail(encargadoMto.correo)){
          error+="Correo invalido \n";
          value= false;
      }}
      if(encargadoMto.direccion==null){
          error+="Direccion invalida \n";
          value=false;
      }
      if(encargadoMto.compañia==null){
          error+="Compañia invalida \n";
          value=false;
      }
      
        return value;
    }
   public  boolean validateEmail(String email) {
 
        // Compiles the given regular expression into a pattern.
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
        // Match the given input against this pattern
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
 
    }
}
