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
public class ProductoTipoT {
    ProductoTipo productoTipo;
    String error;

    public ProductoTipoT(){
        error="";
        productoTipo =new ProductoTipo();
    }
    
  public  String[] nameField() {
        String[] names = new String[]{"id", "descripcion", "procesotipo", "Tamaño", 
            "Color"};
        return names;
    }
  public  String nameTable() {
        return "productotipo";
    }
  public ProductoTipo Contacto(int id){
        
        
        String query="SELECT * FROM  `"+nameTable()+"`  WHERE  "+nameField()[1]+
                     "=?;";  
        productoTipo =new ProductoTipo();
         try {
             Connection con = Conexion.createConnection();
            PreparedStatement preparedStatement =con.prepareStatement(query);
            preparedStatement.setString(1, id+"");
            ResultSet p = preparedStatement.executeQuery();
            if (p.next()) {                  
                productoTipo.id=p.getInt(nameField()[0]);
                productoTipo.descripcion=p.getString(nameField()[1]);
                productoTipo.procesotipo= p.getString(nameField()[2]);                
                productoTipo.Tamaño= p.getString(nameField()[3]);
                productoTipo.Color = p.getString(nameField()[4]);
               
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         catch (Exception e){
             
         }
        
        return productoTipo;
    }
  private int insertar() { 
      int id=-1;
      if (productoTipo != null) {        
        String query="insert into "+nameTable()+" "+Arrays.toString(nameField())
                .replace('[', '(').replace(']', ')')+" values (null,?,?,?,?,?)";
                
        try {
            Connection con = Conexion.createConnection();
            PreparedStatement insertar = con.prepareStatement(query,
                    Statement.RETURN_GENERATED_KEYS);          
                insertar.setString  (1, productoTipo.descripcion);
                insertar.setString  (2, productoTipo.procesotipo);
                insertar.setString    (3, productoTipo.Tamaño);
                insertar.setString  (4, productoTipo.Color);
                
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
    }/*
  private int Update() { 
      int id=-1;
      if (productoTipo != null) {        
        String query="UPDATE  "+nameTable()+" SET "+nameField()[2]+" = ?, "
                +nameField()[3]+" = ?, "+nameField()[4]+" = ?,"
                +" WHERE "+nameField()[0]+" = ? ;";
                
        try {
            Connection con = Conexion.createConnection();
            PreparedStatement insertar = con.prepareStatement(query,
                    Statement.RETURN_GENERATED_KEYS);
                
                insertar.setString  (1, ProductoTipo.procesotipo);
                insertar.setString  (2, ProductoTipo.Tamaño);
                insertar.setString  (3, ProductoTipo.Color);
                
            
                
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
    
  public ProductoTipo Update(ProductoTipo productoTipo) {
        if (productoTipo != null) {
            
            if (validate(productoTipo)) {
                productoTipo.id=Update();
                return productoTipo;
            }
        }
        return null;
    }*/
  public ProductoTipo insertar(ProductoTipo productoTipo) {
        if (productoTipo != null) {
            
            if (/*validate(productoTipo)*/true) {
                 productoTipo.id=insertar();
                return productoTipo;
            }
        }
        return null;
    }
  //validaciones here
 /* public boolean validate(ProductoTipo  productoTipo){
      this.productoTipo=productoTipo;
      boolean value=true;
      
      if(productoTipo.nombre==null){
          error+="Nombre contacto invalido \n";
          value= false;
      }
      else{if(productoTipo.nombre.trim().isEmpty()|
         productoTipo.nombre.length()>100 | productoTipo.nombre.length()<5
              ){
          error+="Nombre contacto invalido \n";
          value= false;
      }
      }
      if(productoTipo.correo!=null){
      if(!validateEmail(productoTipo.correo)){
          error+="Correo contacto invalido \n";
          value= false;
      }}
      if(productoTipo.direccion==null)
          productoTipo.direccion="";
      
        return value;
    }*/
}
