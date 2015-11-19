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
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Caudillo
 */
public class FuncionRegistroT {
    FuncionRegistro funcionRegistro;
    String error;
    public FuncionRegistroT(){
        error="";
        funcionRegistro=new FuncionRegistro();
    }
  public  String[] nameField() {
        String[] names = new String[]{"id", "idfuncion", "fecha",};
        return names;
    }
  public  String nameTable() {
        return "funcionregistro";
    }
    /*public static void main(String[] args) {
        FuncionRegistro funcionRegistro= new FuncionRegistro();
        funcionRegistro.id_funcion=1;
        funcionRegistro.fecha=new Date();
        new FuncionRegistroT().insertar(funcionRegistro);
        new FuncionRegistroT().iniciodia(new Date());
    }*/
    public boolean iniciodia(Date fecha){       
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String query="SELECT * FROM  `"+nameTable()+"`  WHERE  DATE_FORMAT("
                +nameField()[2]+ ",\"%Y-%m-%d\")='"+df.format(fecha)+"';";
        
        ResultSet p = Conexion.consultar(query);
         try {
            if (p.next()) {  
                System.out.println("true");
               return true;                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }catch(Exception e){System.out.println(e.getMessage());}
        System.out.println("false");
        return false;
    }
  private int insertar() { 
      int id=-1;
      if (funcionRegistro != null) {   
          DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String query="insert into "+nameTable()+" "+Arrays.toString(nameField())
                .replace('[', '(').replace(']', ')')+" values (null,?,'"
                +df.format(funcionRegistro.fecha)+"')";
        try {
            Connection con = Conexion.createConnection();
            PreparedStatement insertar = con.prepareStatement(query,
                    Statement.RETURN_GENERATED_KEYS);
            
                insertar.setInt     (1, funcionRegistro.id_funcion);
                
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
  public FuncionRegistro insertar(FuncionRegistro funcionRegistro) {
        if (funcionRegistro != null) {
            
            if (validate(funcionRegistro)) {
                funcionRegistro.id=insertar();
                return funcionRegistro;
            }else{
                JOptionPane.showMessageDialog(null, error, 
            "Inntepco", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        return null;

    }
  //validaciones here
  public boolean validate(FuncionRegistro funcionRegistro){
      this.funcionRegistro=funcionRegistro;
      boolean value=true;
     
      
        return value;
    }
 
}
