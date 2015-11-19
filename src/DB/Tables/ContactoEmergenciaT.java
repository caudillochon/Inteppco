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
public class ContactoEmergenciaT {
    ContactoEmergencia ContactoE;
    String error;
    public ContactoEmergenciaT(){
        error="";
        ContactoE=new ContactoEmergencia();
    }
    
  public  String[] nameField() {
        String[] names = new String[]{"Id", "Id_Personal", "Nombre", "Email", 
            "Telefono", "Dirrecion"};
        return names;
    }
  public  String nameTable() {
        return "contactoemergencia";
    }
  public ContactoEmergencia Contacto(int id){
        
        
        String query="SELECT * FROM  `"+nameTable()+"`  WHERE  "+nameField()[1]+
                     "=?;";  
        ContactoE=new ContactoEmergencia();
         try {
             Connection con = Conexion.createConnection();
            PreparedStatement preparedStatement =con.prepareStatement(query);
            preparedStatement.setString(1, id+"");
            ResultSet p = preparedStatement.executeQuery();
            if (p.next()) {                  
                ContactoE.id=p.getInt(nameField()[0]);
                ContactoE.id_personal=p.getInt(nameField()[1]);
                ContactoE.nombre = p.getString(nameField()[2]);                
                ContactoE.correo = p.getString(nameField()[3]);
                ContactoE.telefono = p.getLong(nameField()[4]);
                ContactoE.direccion= p.getString(nameField()[5]);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         catch (Exception e){
             
         }
        
        return ContactoE;
    }
  private int insertar() { 
      int id=-1;
      if (ContactoE != null) {        
        String query="insert into "+nameTable()+" "+Arrays.toString(nameField())
                .replace('[', '(').replace(']', ')')+" values (null,?,?,?,?,?)";
                
        try {
            Connection con = Conexion.createConnection();
            PreparedStatement insertar = con.prepareStatement(query,
                    Statement.RETURN_GENERATED_KEYS);
                insertar.setInt     (1, ContactoE.id_personal);
                insertar.setString  (2, ContactoE.nombre);
                insertar.setString  (3, ContactoE.correo);
                insertar.setLong    (4, ContactoE.telefono);
                insertar.setString  (5, ContactoE.direccion);
                
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
      if (ContactoE != null) {        
        String query="UPDATE  "+nameTable()+" SET "+nameField()[2]+" = ?, "
                +nameField()[3]+" = ?, "+nameField()[4]+" = ?, "+nameField()[5]+" = ? "
                +" WHERE "+nameField()[1]+" = ? ;";
                
        try {
            Connection con = Conexion.createConnection();
            PreparedStatement insertar = con.prepareStatement(query,
                    Statement.RETURN_GENERATED_KEYS);
                
                insertar.setString  (1, ContactoE.nombre);
                insertar.setString  (2, ContactoE.correo);
                insertar.setLong    (3, ContactoE.telefono);
                insertar.setString  (4, ContactoE.direccion);
                insertar.setInt     (5, ContactoE.id_personal);
                
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
    
  public ContactoEmergencia Update(ContactoEmergencia ContactoE) {
        if (ContactoE != null) {
            
            if (validate(ContactoE)) {
                ContactoE.id=Update();
                return ContactoE;
            }
        }
        return null;
    }
  public ContactoEmergencia insertar(ContactoEmergencia ContactoE) {
        if (ContactoE != null) {
            
            if (validate(ContactoE)) {
                ContactoE.id=insertar();
                return ContactoE;
            }
        }
        return null;
    }
  //validaciones here
  public boolean validate(ContactoEmergencia ContactoE){
      this.ContactoE=ContactoE;
      boolean value=true;
      
      if(ContactoE.nombre==null){
          error+="Nombre contacto invalido \n";
          value= false;
      }
      else{if(ContactoE.nombre.trim().isEmpty()|
         ContactoE.nombre.length()>100 | ContactoE.nombre.length()<5
              ){
          error+="Nombre contacto invalido \n";
          value= false;
      }
      }
      if(ContactoE.correo!=null & !ContactoE.correo.equals("")){
      if(!validateEmail(ContactoE.correo)){
          error+="Correo contacto invalido \n";
          value= false;
      }}
      if(ContactoE.direccion==null)
          ContactoE.direccion="";
      
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
