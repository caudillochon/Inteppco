/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.Tables;

import DB.Conexion;
import DB.Modelos.FallasPosibles;
import DB.Modelos.PersonalHorario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Caudillo
 */
public class PersonalHorarioT {
    
    PersonalHorario personalHorario;
    String error;
    public PersonalHorarioT(){
        error="";
        personalHorario=new PersonalHorario();
    }
  public  String[] nameField() {
        String[] names = new String[]{"id", "id_personal", "dia", "entrada", 
            "salida", "descanzoe","descanzos"};
        return names;
    }
  public  String nameTable() {
        return "personal_horario";
    }
  private int insertar() { 
      int id=-1;
      if (personalHorario != null) {        
        String query="insert into "+nameTable()+" "+Arrays.toString(nameField())
                .replace('[', '(').replace(']', ')')+" values (null,?,?,?,?,?,?)";
                
        try {
            Connection con = Conexion.createConnection();
            PreparedStatement insertar = con.prepareStatement(query,
                    Statement.RETURN_GENERATED_KEYS);
                insertar.setInt    (1, personalHorario.personalid);
                insertar.setString (2, personalHorario.dia);
                insertar.setTime   (3, personalHorario.entrada);
                insertar.setTime   (4, personalHorario.salida);
                insertar.setTime   (5, personalHorario.descanzoe);
                insertar.setTime   (6, personalHorario.descanzos);
                
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
      if (personalHorario != null) {        
        String query="UPDATE  "+nameTable()+" SET "+nameField()[2]+" = ?, "
            +nameField()[3]+" = ?, "+nameField()[4]+" = ?, "+nameField()[5]+" = ?, "
            +nameField()[6]+" = ? "+" WHERE "+nameField()[1]+" = ? ;";
                
        try {
            Connection con = Conexion.createConnection();
            PreparedStatement insertar = con.prepareStatement(query,
                    Statement.RETURN_GENERATED_KEYS);
                
                insertar.setString (1, personalHorario.dia);
                insertar.setTime   (2, personalHorario.entrada);
                insertar.setTime   (3, personalHorario.salida);
                insertar.setTime   (4, personalHorario.descanzoe);
                insertar.setTime   (5, personalHorario.descanzos);
                insertar.setInt    (6, personalHorario.personalid);
                
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
      }
        return id;
    }
  public PersonalHorario horario(int id){
        
        
        String query="SELECT * FROM  `"+nameTable()+"`  WHERE  "+nameField()[1]+
                     "=?;";  
        personalHorario=new PersonalHorario();
         try {
             Connection con = Conexion.createConnection();
            PreparedStatement preparedStatement =con.prepareStatement(query);
            preparedStatement.setString(1, id+"");
            ResultSet p = preparedStatement.executeQuery();
            if (p.next()) {                  
                personalHorario.id=p.getInt(nameField()[0]);
                personalHorario.personalid = p.getInt(nameField()[1]);                
                personalHorario.dia = p.getString(nameField()[2]);
                personalHorario.entrada = p.getTime(nameField()[3]);
                personalHorario.salida = p.getTime(nameField()[4]);
                personalHorario.descanzoe= p.getTime(nameField()[5]);
                personalHorario.descanzos=p.getTime(nameField()[6]);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         catch (Exception e){
             
         }
        
        return personalHorario;
    }
  public void actualizarhorario(PersonalHorario horario){
      horario(horario.personalid);
      if(personalHorario.id>0){
          personalHorario=horario;
          Update();
      }else{
          personalHorario=horario;
          insertar();
      }
  }
}
