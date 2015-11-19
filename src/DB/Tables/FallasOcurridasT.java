/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.Tables;

import DB.Conexion;
import DB.Modelos.*;
import static DB.Tables.PersonalT.nameField;
import static DB.Tables.PersonalT.nameTable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Caudillo
 */
public class FallasOcurridasT {
    FallasOcurridas fallasOcurridas;
    String error;
    public FallasOcurridasT(){
        error="";
        fallasOcurridas=new FallasOcurridas();
    }
  public  String[] nameField() {
        String[] names = new String[]{"id", "idfalla", "deteccion", "activadapor", 
            "inicio", "fin"};
        return names;
    }
  public  String nameTable() {
        return "fallasocurridas";
    }
    /*public static void main(String[] args) {
        FallasOcurridas fallasOcurridas= new FallasOcurridas();
        fallasOcurridas.id_falla=1;
        fallasOcurridas.deteccion="accidente";
        fallasOcurridas.inicio=new Date();;
        fallasOcurridas.activadapor="er";
        fallasOcurridas.fin=new Date();
        System.out.println(fallasOcurridas.fin);
        new FallasOcurridasT().insertar(fallasOcurridas);
    }*/
  private int insertar() { 
      int id=-1;
      if (fallasOcurridas != null) {   
          DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String query="insert into "+nameTable()+" "+Arrays.toString(nameField())
                .replace('[', '(').replace(']', ')')+" values (null,?,?,?,'"
                +df.format(fallasOcurridas.inicio)+ "','"
                +df.format(fallasOcurridas.fin)+"')";
        try {
            Connection con = Conexion.createConnection();
            PreparedStatement insertar = con.prepareStatement(query,
                    Statement.RETURN_GENERATED_KEYS);
            
                insertar.setInt     (1, fallasOcurridas.id_falla);
                insertar.setString  (2, fallasOcurridas.deteccion);
                insertar.setString  (3, fallasOcurridas.activadapor);
                
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
  public FallasOcurridas insertar(FallasOcurridas fallasOcurridas) {
        if (fallasOcurridas != null) {
            
            if (validate(fallasOcurridas)) {
                fallasOcurridas.id=insertar();
                return fallasOcurridas;
            }else{
                JOptionPane.showMessageDialog(null, error, 
            "Inntepco", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        return null;

    }
  public int Update(int id_fallao) { 
      int id=-1;         
        String query="UPDATE  "+nameTable()+" SET "+nameField()[5]+
                " = NOW() WHERE "+nameField()[5]+" > DATE(NOW()) AND "+
                nameField()[1]+" = ? ORDER BY "+nameField()[0]+" DESC LIMIT 1;";
                
        try {
            Connection con = Conexion.createConnection();
            PreparedStatement insertar = con.prepareStatement(query,
                    Statement.RETURN_GENERATED_KEYS);
                insertar.setInt(1, id_fallao); 
            insertar.executeUpdate();
            ResultSet generate=insertar.getGeneratedKeys();
            if(generate.next()){
            id= generate.getInt(1);}
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,"no se pudo Actualizar  "
                    + "verifique su conexion a la base de datos", 
            "Inntepco", JOptionPane.ERROR_MESSAGE);
        }
      
        return id;
    }
  //validaciones here
  public boolean validate(FallasOcurridas fallasOcurridas){
      this.fallasOcurridas=fallasOcurridas;
      boolean value=true;
     
      
        return value;
    }
 
}
