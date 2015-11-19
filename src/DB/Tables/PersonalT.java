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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Caudillo
 */
public class PersonalT {
    public Personal personal;
    public String error;
    public PersonalT(){
        error="";
        personal=new Personal();
    }
    
  public static String[] nameField() {
        String[] names = new String[]{"id", "nombre", "correo", "segurosocial", 
            "telefono", "direccion", "lugarnacimiento", "fechanacimiento", 
            "puesto", "activo"};
        return names;
    }
  public static  String nameTable() {
        return "personal";
    }
  public static List<Personal> listaPersonal(){
        String query="SELECT * FROM  "+nameTable();
        List<Personal> personas= new ArrayList<Personal> ();
        
         try {
             Connection con = Conexion.createConnection();
            PreparedStatement preparedStatement =con.prepareStatement(query);
            ResultSet p = preparedStatement.executeQuery();
            while (p.next()) {
                Personal personal=new Personal();
                personal.id=p.getInt(nameField()[0]);
                personal.nombre = p.getString(nameField()[1]);                
                personal.correo = p.getString(nameField()[2]);
                personal.seguroSocial = p.getString(nameField()[3]);
                personal.telefono = p.getLong(nameField()[4]);
                personal.direccion= p.getString(nameField()[5]);
                personal.lugarnaciemiento=p.getString(nameField()[6]);
                
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                System.out.println(p.getString(nameField()[7]));
                personal.fechanacimeinto=formatter.parse(p.getString(nameField()[7]));
                personal.puesto_id=p.getInt(nameField()[8]);
                personal.activo=p.getInt(nameField()[9]);
                personas.add(personal);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         catch(Exception e){
             
         }
         return personas;
    }
  public Personal persona(int id){
        
        
        String query="SELECT * FROM  `"+nameTable()+"`  WHERE  "+nameField()[0]+
                     "=?;";  
        personal=new Personal();
         try {
             Connection con = Conexion.createConnection();
            PreparedStatement preparedStatement =con.prepareStatement(query);
            preparedStatement.setString(1, id+"");
            ResultSet p = preparedStatement.executeQuery();
            if (p.next()) {                  
                personal.id=p.getInt(nameField()[0]);
                personal.nombre = p.getString(nameField()[1]);                
                personal.correo = p.getString(nameField()[2]);
                personal.seguroSocial = p.getString(nameField()[3]);
                personal.telefono = p.getLong(nameField()[4]);
                personal.direccion= p.getString(nameField()[5]);
                personal.lugarnaciemiento=p.getString(nameField()[6]);                
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");                
                personal.fechanacimeinto=formatter.parse(p.getString(nameField()[7]));
                personal.puesto_id=p.getInt(nameField()[8]);
                personal.activo=p.getInt(nameField()[9]);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         catch (Exception e){
             
         }
        
        return personal;
    }
  private int insertar() { 
      int id=-1;
      if (personal != null) {        
        String query="insert into "+nameTable()+" "+Arrays.toString(nameField())
                .replace('[', '(').replace(']', ')')+" values (null,?,?,?,?,?,?,?,?,1)";
                
        try {
            Connection con = Conexion.createConnection();
            PreparedStatement insertar = con.prepareStatement(query,
                    Statement.RETURN_GENERATED_KEYS);
                insertar.setString  (1, personal.nombre);
                insertar.setString  (2, personal.correo);
                insertar.setString     (3, personal.seguroSocial);
                insertar.setLong   (4, personal.telefono);
                insertar.setString  (5, personal.direccion);
                insertar.setString  (6, personal.lugarnaciemiento);
                insertar.setDate    (7, new java.sql.Date(personal.
                                        fechanacimeinto.getTime()));
                insertar.setInt     (8, personal.puesto_id);
                
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
      if (personal != null) {        
        String query="UPDATE  "+nameTable()+" SET "+nameField()[1]+" = ?, "
            +nameField()[2]+" = ?, "+nameField()[3]+" = ?, "+nameField()[4]+" = ?, "
            +nameField()[5]+" = ?, "+nameField()[6]+" = ?, "+nameField()[7]+" = ?, "
            +nameField()[8]+" = ? "+" WHERE "+nameField()[0]+" = ? ;";
                
        try {
            Connection con = Conexion.createConnection();
            PreparedStatement insertar = con.prepareStatement(query,
                    Statement.RETURN_GENERATED_KEYS);
                insertar.setString  (1, personal.nombre);
                insertar.setString  (2, personal.correo);
                insertar.setString     (3, personal.seguroSocial);
                insertar.setLong   (4, personal.telefono);
                insertar.setString  (5, personal.direccion);
                insertar.setString  (6, personal.lugarnaciemiento);
                insertar.setDate    (7, new java.sql.Date(personal.
                                        fechanacimeinto.getTime()));
                insertar.setInt     (8, personal.puesto_id);
                insertar.setInt     (9, personal.id);
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
  public Personal Update(Personal personal) {
        if (personal != null) {
            
            if (validate(personal)) {
                personal.id=Update();
                return personal;
            }
        }

        return null;

    }
  public Personal insertar(Personal personal) {
        if (personal != null) {
            
            if (validate(personal)) {
                personal.id=insertar();
                return personal;
            }
        }

        return null;

    }
   public Personal Update(Personal personal,ContactoEmergencia contacto) {
        if (contacto != null & personal!=null) {
            ContactoEmergenciaT contactoT =new ContactoEmergenciaT();
            //al validar el personal se cargan los datos en personalt
            if (validate(personal)&contactoT.validate(contacto)) {
                Update(personal);
                contactoT.Update(contacto);
                return personal;
            }else{
                JOptionPane.showMessageDialog(null, error+contactoT.error, 
            "Inntepco", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        return null;

    }
  public Personal insertar(Personal personal,ContactoEmergencia contacto) {
        if (contacto != null & personal!=null) {
            ContactoEmergenciaT contactoT =new ContactoEmergenciaT();
            //al validar el personal se cargan los datos en personalt
            if (validate(personal)&contactoT.validate(contacto)) {
                contacto.id_personal=insertar(personal).id;
                contactoT.insertar(contacto);
                return personal;
            }else{
                JOptionPane.showMessageDialog(null, error+contactoT.error, 
            "Inntepco", JOptionPane.INFORMATION_MESSAGE);
            }
        }  
        return null; 
    }
  //validaciones here
  public boolean validate(Personal personal){
      this.personal=personal;
      boolean value=true;
      if(personal.fechanacimeinto==null){
          error+="Fecha no puede ser nula \n";
          value= false;
      }
      if(personal.nombre==null){
          error+="Nombre invalido \n";
          value= false;
      }
      else{if(personal.nombre.trim().isEmpty()|
         personal.nombre.length()>100 | personal.nombre.length()<5
              ){
          error+="Nombre invalido \n";
          value= false;
      }}
      if(personal.correo==null){
          error+="Correo invalido \n";
          value= false;
      }else{
      if(!validateEmail(personal.correo)){
          error+="Correo invalido \n";
          value= false;
      }}
      if(personal.direccion==null)
          personal.direccion="";
      if(personal.lugarnaciemiento==null)
          personal.lugarnaciemiento="";
      
        return value;
    }
   public  boolean validateEmail(String email) {
 
        // Compiles the given regular expression into a pattern.
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
        // Match the given input against this pattern
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
 
    }
}
