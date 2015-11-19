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
public class UsuarioRegistroT {
    UsuarioRegistro usuarioRegistro;
    String error;
    public UsuarioRegistroT(){
        error="";
        usuarioRegistro=new UsuarioRegistro();
    }
  public  String[] nameField() {
        String[] names = new String[]{"id", "iduser", "entrada", "salida"};
        return names;
    }
  public  String nameTable() {
        return "usuarioRegistro";
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
      if (usuarioRegistro != null) {        
        String query="insert into "+nameTable()+" "+Arrays.toString(nameField())
                .replace('[', '(').replace(']', ')')+" values (null,?,?,?,?,?)";
                
        try {
            Connection con = Conexion.createConnection();
            PreparedStatement insertar = con.prepareStatement(query,
                    Statement.RETURN_GENERATED_KEYS);
                insertar.setInt  (1, usuarioRegistro.iduser);
                insertar.setDate (2,new java.sql.Date(usuarioRegistro.
                                        entrada.getTime()) );
                insertar.setDate (3, new java.sql.Date(usuarioRegistro.
                                        salida.getTime()));
                
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
  public UsuarioRegistro insertar(UsuarioRegistro usuarioRegistro) {
        if (usuarioRegistro != null) {
            
            if (validate(usuarioRegistro)) {
                usuarioRegistro.id=insertar();
                return usuarioRegistro;
            }else{
                JOptionPane.showMessageDialog(null, error, 
            "Inntepco", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        return null;

    }
  //validaciones here
  public boolean validate(UsuarioRegistro usuarioRegistro){
      this.usuarioRegistro=usuarioRegistro;
      boolean value=true;
      
      if(usuarioRegistro.iduser==0){
          error+="Id invalida \n";
          value=false;
      }
      if(usuarioRegistro.entrada==null){
          error+="Entrada invalida \n";
          value=false;
      }
      if(usuarioRegistro.salida==null){
          error+="Salida invalida \n";
          value=false;
      }
      
        return value;
    }
}