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
public class PersonalAsistenciaT {
    PersonalAsistencia personalAsistencia;
    String error;
    public PersonalAsistenciaT(){
        error="";
        personalAsistencia=new PersonalAsistencia();
    }
  public  String[] nameField() {
        String[] names = new String[]{"id", "idpersonal", "puesto", "dia", 
            "entrada", "salida", "nota"};
        return names;
    }
  public  String nameTable() {
        return "personalAsistencia";
    }
  private int insertar() { 
      int id=-1;
      if (personalAsistencia != null) {        
        String query="insert into "+nameTable()+" "+Arrays.toString(nameField())
                .replace('[', '(').replace(']', ')')+" values (null,?,?,?,?,?)";
                
        try {
            Connection con = Conexion.createConnection();
            PreparedStatement insertar = con.prepareStatement(query,
                    Statement.RETURN_GENERATED_KEYS);
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                insertar.setInt    (1, personalAsistencia.idpersonal);
                insertar.setInt    (2, personalAsistencia.puesto);
                insertar.setInt    (3, personalAsistencia.dia);
                //insertar.setDate   (4, personalAsistencia.entrada);
                //insertar.setDate   (5, personalAsistencia.salida);
                insertar.setString (6, personalAsistencia.nota);
                
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
  public PersonalAsistencia insertar(PersonalAsistencia personalAsistencia) {
        if (personalAsistencia != null) {
            
            if (validate(personalAsistencia)) {
                personalAsistencia.id=insertar();
                return personalAsistencia;
            }else{
                JOptionPane.showMessageDialog(null, error, 
            "Inntepco", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        return null;

    }
  //validaciones here
  public boolean validate(PersonalAsistencia personalAsistencia){
      this.personalAsistencia=personalAsistencia;
      boolean value=true;
      
      if(personalAsistencia.idpersonal==0){
          error+="Id invalida \n";
          value=false;
      }
      if(personalAsistencia.puesto==0){
          error+="Puesto invalida \n";
          value=false;
      }
      if(personalAsistencia.dia==0){
          error+="Dia invalida \n";
          value=false;
      }
      if(personalAsistencia.entrada==null){
          error+="Entrada invalida \n";
          value=false;
      }
      if(personalAsistencia.salida==null){
          error+="Salida invalida \n";
          value=false;
      }
      if(personalAsistencia.nota==null){
          error+="Nota invalida \n";
          value=false;
      }
      
        return value;
    }
}