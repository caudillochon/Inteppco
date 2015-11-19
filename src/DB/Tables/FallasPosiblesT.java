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
public class FallasPosiblesT {
    FallasPosibles fallasPosibles;
    String error;
    public FallasPosiblesT(){
        error="";
        fallasPosibles=new FallasPosibles();
    }
  public  String[] nameField() {
        String[] names = new String[]{"id", "tipo", "nombre", "pieza", 
            "valor", "descripcion"};
        return names;
    }
  public  String nameTable() {
        return "fallasposibles";
    }
    /*public static void main(String[] args) {
        FallasPosibles fallasPosibles= new FallasPosibles();
        fallasPosibles.nombre="nombre";
        fallasPosibles.tipo="accidente";
       // fallasPosibles.valor="er";
        fallasPosibles.descripcion="er";
        fallasPosibles.pieza=1;
        new FallasPosiblesT().insertar(fallasPosibles);
    }*/
  private int insertar() { 
      int id=-1;
      if (fallasPosibles != null) {        
        String query="insert into "+nameTable()+" "+Arrays.toString(nameField())
                .replace('[', '(').replace(']', ')')+" values (null,?,?,?,?,?)";
                
        try {
            Connection con = Conexion.createConnection();
            PreparedStatement insertar = con.prepareStatement(query,
                    Statement.RETURN_GENERATED_KEYS);
                insertar.setString  (1, fallasPosibles.tipo);
                insertar.setString  (2, fallasPosibles.nombre);
                insertar.setInt     (3, fallasPosibles.pieza);
                insertar.setString  (4, fallasPosibles.valor);
                insertar.setString  (5, fallasPosibles.descripcion);
                
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
  public FallasPosibles insertar(FallasPosibles fallasPosibles) {
        if (fallasPosibles != null) {
            
            if (validate(fallasPosibles)) {
                fallasPosibles.id=insertar();
                return fallasPosibles;
            }else{
                JOptionPane.showMessageDialog(null, error, 
            "Inntepco", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        return null;

    }
  //validaciones here
  public boolean validate(FallasPosibles fallasPosibles){
      this.fallasPosibles=fallasPosibles;
      boolean value=true;
      if(fallasPosibles.nombre==null){
          error+="Nombre invalido \n";
          value= false;
      }
      else{if(fallasPosibles.nombre.trim().isEmpty()|
         fallasPosibles.nombre.length()>100 | fallasPosibles.nombre.length()<5
              ){
          error+="Nombre invalido \n";
          value= false;
      }}
      if(fallasPosibles.tipo==null){
          error+="Tipo de falla invalida \n";
          value= false;
      }else{
      if(!(fallasPosibles.tipo.equals("accidente")|fallasPosibles.tipo
              .equals("falla")|fallasPosibles.tipo.equals("otro"))){
          error+="Tipo de Falla invalida \n";
          value= false;
      }}
      
      if(fallasPosibles.valor==null){
          fallasPosibles.valor="01";
      }
      if(fallasPosibles.descripcion==null){
          error+="Descripcion invalida \n";
          value=false;
      }
      
        return value;
    }
 
}
