/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.Tables;

import DB.Conexion;
import DB.Modelos.FallasPosibles;
import DB.Modelos.PersonalHorario;
import DB.Modelos.Piezas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Caudillo
 */
public class PiezasT {
    
    Piezas pieza;
    String error;
    public PiezasT(){
        error="";
        pieza=new Piezas();
    }
  public  String[] nameField() {
        String[] names = new String[]{"id", "nombre", "descripcion", "TiempoVida", 
            "valor"};
        return names;
    }
  public  String nameTable() {
        return "piezas";
    }
  private int insertar() { 
      int id=-1;
      if (pieza != null) {        
        String query="insert into "+nameTable()+" "+Arrays.toString(nameField())
                .replace('[', '(').replace(']', ')')+" values (null,?,?,?,?)";
                
        try {
            Connection con = Conexion.createConnection();
            PreparedStatement insertar = con.prepareStatement(query,
                    Statement.RETURN_GENERATED_KEYS);
                insertar.setString    (1, pieza.nombre);
                insertar.setString    (2, pieza.descripcion);
                insertar.setInt       (3, pieza.tiempoVida);
                insertar.setString    (4, pieza.valor);
                
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
      if (pieza != null) {        
        String query="UPDATE  "+nameTable()+" SET "+nameField()[1]+" = ?, "
            +nameField()[2]+" = ?, "+nameField()[3]+" = ?, "+nameField()[4]+" = ? "
            +" WHERE "+nameField()[0]+" = ? ;";
                
        try {
            Connection con = Conexion.createConnection();
            PreparedStatement insertar = con.prepareStatement(query,
                    Statement.RETURN_GENERATED_KEYS);
                
                insertar.setString    (1, pieza.nombre);
                insertar.setString    (2, pieza.descripcion);
                insertar.setInt       (3, pieza.tiempoVida);
                insertar.setString    (4, pieza.valor);
                insertar.setInt       (5, pieza.id);
                
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
  public  List<Piezas> listaPiezas(){
        String query="SELECT * FROM  "+nameTable();
        List<Piezas> piezas= new ArrayList<Piezas> ();
        
         try {
             Connection con = Conexion.createConnection();
            PreparedStatement preparedStatement =con.prepareStatement(query);
            ResultSet p = preparedStatement.executeQuery();
            while (p.next()) {
                Piezas pieza= new Piezas();
                pieza.id=p.getInt(nameField()[0]);
                pieza.nombre = p.getString(nameField()[1]); 
                pieza.descripcion=p.getString(nameField()[2]);
                pieza.tiempoVida = p.getInt(nameField()[3]);
                pieza.valor = p.getString(nameField()[4]);
                piezas.add(pieza);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         catch(Exception e){
             
         }
         return piezas;
    }
  public Piezas pieza(int id){
        
        
        String query="SELECT * FROM  `"+nameTable()+"`  WHERE  "+nameField()[0]+
                     "=?;";  
        pieza=new Piezas();
         try {
             Connection con = Conexion.createConnection();
            PreparedStatement preparedStatement =con.prepareStatement(query);
            preparedStatement.setString(1, id+"");
            ResultSet p = preparedStatement.executeQuery();
            if (p.next()) {                  
                pieza.id=p.getInt(nameField()[0]);
                pieza.nombre = p.getString(nameField()[1]);                
                  pieza.tiempoVida = p.getInt(nameField()[3]);
                pieza.valor = p.getString(nameField()[4]);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         catch (Exception e){
             
         }
        
        return pieza;
    }
  public void insertar(Piezas pieza){
      
          this.pieza=pieza;
          insertar();
      
  }
}
