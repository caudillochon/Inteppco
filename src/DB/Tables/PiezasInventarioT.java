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
public class PiezasInventarioT {
    PiezasInventario piezasInventario;
    String error;
    public PiezasInventarioT(){
        error="";
        piezasInventario=new PiezasInventario();
    }
  public  String[] nameField() {
        String[] names = new String[]{"id", "cantidad", "fecha", "borradologico", 
            "nota", "productotipoid"};
        return names;
    }
  public  String nameTable() {
        return "piezasInventario";
    }
  
  private int insertar() { 
      int id=-1;
      if (piezasInventario != null) {        
        String query="insert into "+nameTable()+" "+Arrays.toString(nameField())
                .replace('[', '(').replace(']', ')')+" values (null,?,?,?,?,?)";
                
        try {
            Connection con = Conexion.createConnection();
            PreparedStatement insertar = con.prepareStatement(query,
                    Statement.RETURN_GENERATED_KEYS);
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                insertar.setDouble  (1, piezasInventario.cantidad);
                insertar.setDate    (2, new java.sql.Date(piezasInventario.
                                        fecha.getTime()));
                insertar.setInt     (3, piezasInventario.borrado_logico);
                insertar.setString  (4, piezasInventario.nota);
                insertar.setInt     (5, piezasInventario.producto_tipo_id);
                
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
  public PiezasInventario insertar(PiezasInventario piezasInventario) {
        if (piezasInventario != null) {
            
            if (validate(piezasInventario)) {
                piezasInventario.id=insertar();
                return piezasInventario;
            }else{
                JOptionPane.showMessageDialog(null, error, 
            "Inntepco", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        return null;

    }
  //validaciones here
  public boolean validate(PiezasInventario piezasInventario){
      this.piezasInventario=piezasInventario;
      boolean value=true;
      
      if(piezasInventario.cantidad==0){
          error+="Cantidad invalida \n";
          value=false;
      }
      if(piezasInventario.fecha==null){
          error+="Fecha invalida \n";
          value=false;
      }
      if(piezasInventario.nota==null){
          error+="Nota invalida \n";
          value=false;
      }
      if(piezasInventario.producto_tipo_id==0){
          error+="Id invalida \n";
          value=false;
      }
      
        return value;
    }
}