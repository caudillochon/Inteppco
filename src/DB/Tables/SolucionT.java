/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.Tables;

import DB.Conexion;
import DB.Modelos.*;
import static DB.Tables.UsuarioT.nameField;
import static DB.Tables.UsuarioT.nameTable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import javax.swing.JOptionPane;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Caudillo
 */
public class SolucionT {
    Solucion solucion;
    String error;
    public SolucionT(){
        error="";
        solucion=new Solucion();
    }
    
  public  String[] nameField() {
        String[] names = new String[]{"id", "idfallaposible", "solucion", "autores", 
            "fecha"};
        return names;
    }
  public  String nameTable() {
        return "solucion";
    }
  public Solucion Contacto(int id){
        
        
        String query="SELECT * FROM  `"+nameTable()+"`  WHERE  "+nameField()[1]+
                     "=?;";  
        solucion=new Solucion();
         try {
             Connection con = Conexion.createConnection();
            PreparedStatement preparedStatement =con.prepareStatement(query);
            preparedStatement.setString(1, id+"");
            ResultSet p = preparedStatement.executeQuery();
            if (p.next()) {                  
                solucion.id=p.getInt(nameField()[0]);
                solucion.id_falla_posible=p.getInt(nameField()[1]);
                solucion.solucion = p.getString(nameField()[2]);                
                solucion.autores = p.getString(nameField()[3]);
                solucion.fecha = p.getDate(nameField()[4]);
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         catch (Exception e){
             
         }
        
        return solucion;
    }
  private int insertar() { 
      int id=-1;
      if (solucion != null) {        
        String query="insert into "+nameTable()+" "+Arrays.toString(nameField())
                .replace('[', '(').replace(']', ')')+" values (null,?,?,?,?,?)";
                
        try {
            Connection con = Conexion.createConnection();
            PreparedStatement insertar = con.prepareStatement(query,
                    Statement.RETURN_GENERATED_KEYS);
                insertar.setInt     (1, solucion.id);
                insertar.setInt     (2, solucion.id_falla_posible);
                insertar.setString  (3, solucion.solucion);
                insertar.setString  (4, solucion.autores);
                insertar.setDate    (5, new java.sql.Date(solucion.
                                        fecha.getTime()));
                
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
  private int Update() { 
      int id=-1;
      if (solucion != null) {        
        String query="UPDATE  "+nameTable()+" SET "+nameField()[2]+" = ?, "
                +nameField()[3]+" = ?, "+nameField()[4]+" = ?, "+nameField()[5]+" = ? "
                +" WHERE "+nameField()[1]+" = ? ;";
                
        try {
            Connection con = Conexion.createConnection();
            PreparedStatement insertar = con.prepareStatement(query,
                    Statement.RETURN_GENERATED_KEYS);
                
                insertar.setInt  (1, solucion.id_falla_posible);
                insertar.setString  (2, solucion.solucion);
                insertar.setString    (3, solucion.autores);
                insertar.setDate  (4, new java.sql.Date(solucion.
                                        fecha.getTime()));
               
                
            insertar.executeUpdate();
            ResultSet generate=insertar.getGeneratedKeys();
           if(generate.next()){
            id= generate.getInt(1);}
            con.close();
        } catch (SQLException e) {
            System.out.println(query);
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,"no se pudo Actualizar  "
                    + "verifique su conexion a la base de datos", 
            "Inntepco", JOptionPane.ERROR_MESSAGE);
        }
      }
        return id;
    }
    
  public Solucion Update(Solucion solucion) {
        if (solucion != null) {
            
            if (validate(solucion)) {
                solucion.id=Update();
                return solucion;
            }
        }
        return null;
    }
  public Solucion insertar(Solucion solucion) {
        if (solucion != null) {
            
            if (validate(solucion)) {
                solucion.id=insertar();
                return solucion;
            }
        }
        return null;
    }
  //validaciones here
  public boolean validate(Solucion solucion){
      this.solucion=solucion;
      boolean value=true;
      /*
      if(solucion.nombre==null){
          error+="Nombre contacto invalido \n";
          value= false;
      }
      else{if(solucion.nombre.trim().isEmpty()|
         solucion.nombre.length()>100 | solucion.nombre.length()<5
              ){
          error+="Nombre contacto invalido \n";
          value= false;
      }
      }
      if(solucion.correo!=null){
      if(!validateEmail(solucion.correo)){
          error+="Correo contacto invalido \n";
          value= false;
      }}
      if(solucion.direccion==null)
          solucion.direccion="";*/
      
        return value;
    }

}
