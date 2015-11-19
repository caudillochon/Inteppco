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
public class FuncionT {
    Funcion funcion;
    String error;
    public FuncionT(){
        error="";
        funcion=new Funcion();
    }
  public  String[] nameField() {
        String[] names = new String[]{"id", "funcion", "valor"};
        return names;
    }
  public  String nameTable() {
        return "funcion";
    }
  /*
    public static void main(String[] args) {
        funcion funcion= new funcion();
        funcion.nombre="nombre";
        funcion.correo="correo@correo.no";
        funcion.compañia="er";
        funcion.direccion="er";
        funcion.telefono=1234567890;
        new funcionT().insertar(funcion);
    }*/
  private int insertar() { 
      int id=-1;
      if (funcion != null) {        
        String query="insert into "+nameTable()+" "+Arrays.toString(nameField())
                .replace('[', '(').replace(']', ')')+" values (null,?,?,?,?,?)";
                
        try {
            Connection con = Conexion.createConnection();
            PreparedStatement insertar = con.prepareStatement(query,
                    Statement.RETURN_GENERATED_KEYS);
                insertar.setString  (1, funcion.funcion);
                insertar.setString  (2, funcion.valor);
                
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
  public Funcion insertar(Funcion funcion) {
        if (funcion != null) {
            
            if (validate(funcion)) {
                funcion.id=insertar();
                return funcion;
            }else{
                JOptionPane.showMessageDialog(null, error, 
            "Inntepco", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        return null;

    }
  //validaciones here
  public boolean validate(Funcion funcion){
      this.funcion=funcion;
      boolean value=true;    
      
      if(funcion.funcion==null){
          error+="Valor invalido \n";
          value=false;
      }
      if(funcion.valor==null){
          error+="Valor invalido \n";
          value=false;
      }
      
        return value;
    }
   
}