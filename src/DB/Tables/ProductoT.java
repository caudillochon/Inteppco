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
public class ProductoT {
    Producto producto;
    String error;
    public ProductoT(){
        error="";
        producto=new Producto();
    }
  public  String[] nameField() {
        String[] names = new String[]{"id", "idpieza", "fechacompra", "instalacion", 
            "mantenimiento", "precio", "encargadomtoid"};
        return names;
    }
  public  String nameTable() {
        return "producto";
    }
  
  private int insertar() { 
      int id=-1;
      if (producto != null) {        
        String query="insert into "+nameTable()+" "+Arrays.toString(nameField())
                .replace('[', '(').replace(']', ')')+" values (null,?,?,?,?,?)";
                
        try {
            Connection con = Conexion.createConnection();
            PreparedStatement insertar = con.prepareStatement(query,
                    Statement.RETURN_GENERATED_KEYS);
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                insertar.setInt   (1, producto.id_pieza);
                insertar.setDate  (2,  new java.sql.Date(producto.
                                        fecha_compra.getTime()));
                insertar.setDate  (3, new java.sql.Date(producto.
                                        instalacion.getTime()) );
                insertar.setDate  (4,  new java.sql.Date(producto.
                                        mantenimiento.getTime()));
                insertar.setFloat (5, producto.precio);
                insertar.setInt   (6, producto.encargadomto_id);
                
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
  public Producto insertar(Producto producto) {
        if (producto != null) {
            
            if (validate(producto)) {
                producto.id=insertar();
                return producto;
            }else{
                JOptionPane.showMessageDialog(null, error, 
            "Inntepco", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        return null;

    }
  //validaciones here
  public boolean validate(Producto producto){
      this.producto=producto;
      boolean value=true;

      if(producto.id_pieza==0){
          error+="Id pieza invalida \n";
          value=false;
      }
      if(producto.fecha_compra==null){
          error+="Fecha invalida \n";
          value=false;
      }
      if(producto.instalacion==null){
          error+="Instalacion invalida \n";
          value=false;
      }
      if(producto.mantenimiento==null){
          error+="Mantenimiento invalido \n";
          value=false;
      }
      if(producto.precio==0){
          error+="Precio invalida \n";
          value=false;
      }
      if(producto.encargadomto_id==0){
          error+="Encargado invalido \n";
          value=false;
      }
      
        return value;
    }
}