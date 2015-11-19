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
public class PuestoT {
    Puesto puesto;
    String error;
    public PuestoT(){
        error="";
        puesto=new Puesto();
    }
  public  String[] nameField() {
        String[] names = new String[]{"id", "nombre", "descripcion"};
        return names;
    }
  public  String nameTable() {
        return "puesto";
    }
  /*
    public static void main(String[] args) {
        puesto puesto= new puesto();
        puesto.nombre="nombre";
        puesto.correo="correo@correo.no";
        puesto.compañia="er";
        puesto.direccion="er";
        puesto.telefono=1234567890;
        new puestoT().insertar(puesto);
    }*/
  private int insertar() { 
      int id=-1;
      if (puesto != null) {        
        String query="insert into "+nameTable()+" "+Arrays.toString(nameField())
                .replace('[', '(').replace(']', ')')+" values (null,?,?,?,?,?)";
                
        try {
            Connection con = Conexion.createConnection();
            PreparedStatement insertar = con.prepareStatement(query,
                    Statement.RETURN_GENERATED_KEYS);
                insertar.setString  (1, puesto.nombre);
                insertar.setString  (2, puesto.descripcion);
                
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
  public Puesto insertar(Puesto puesto) {
        if (puesto != null) {
            
            if (validate(puesto)) {
                puesto.id=insertar();
                return puesto;
            }else{
                JOptionPane.showMessageDialog(null, error, 
            "Inntepco", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        return null;

    }
  //validaciones here
  public boolean validate(Puesto puesto){
      this.puesto=puesto;
      boolean value=true;
      
      if(puesto.nombre==null){
          error+="nombre invalida \n";
          value=false;
      }
      if(puesto.descripcion==null){
          error+="descripcion invalida \n";
          value=false;
      }
      
        return value;
    }
}
