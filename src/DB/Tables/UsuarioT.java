/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.Tables;

import DB.Conexion;
import DB.Modelos.ContactoEmergencia;
import DB.Modelos.Personal;
import DB.Modelos.Usuario;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Caudillo
 */
public class UsuarioT {

    public Usuario usuario;
    public String error;

    public UsuarioT() {
        error="";
        usuario = new Usuario();
    }

    public static String nameTable() {
        return "usuario";
    }
    //si se desea crecer el string favor de hacerlo a la derecha para no afectar codigo
    public static String[] nameField() {
        String[] names = new String[]{"id", "user", "password", "rol", "personalid", "activo"};
        return names;
    }
    public static List<Usuario> listauser(){
        String query="SELECT * FROM  "+nameTable();
        List<Usuario> usuarios= new ArrayList<Usuario> ();
        
         try {
             Connection con = Conexion.createConnection();
            PreparedStatement preparedStatement =con.prepareStatement(query);
            ResultSet p = preparedStatement.executeQuery();
            while (p.next()) {
                Usuario user=null;
                user=new Usuario();
                user.id = p.getInt(nameField()[0]);                
                user.user = p.getString(nameField()[1]);
                user.password = p.getString(nameField()[2]);
                user.rol = p.getInt(nameField()[3]);
                user.Personal_id= p.getInt(nameField()[4]);
                usuarios.add(user);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         return usuarios;
    }
    
    public static Usuario Login(String usern,String pass){
        pass=sha1(pass);
        Usuario user=null;
        String query="SELECT * FROM  `"+nameTable()+"`  WHERE  "+nameField()[1]+
                "=? AND "+nameField()[2]+"=?;";
        //usern
        //pass        
         try {
             Connection con = Conexion.createConnection();
            PreparedStatement preparedStatement =con.prepareStatement(query);
            preparedStatement.setString(1, usern);
            preparedStatement.setString(2, pass);
            ResultSet p = preparedStatement.executeQuery();
            if (p.next()) {  
                user=new Usuario();
                user.id = p.getInt(nameField()[0]);                
                user.user = p.getString(nameField()[1]);
                user.password = p.getString(nameField()[2]);
                user.rol = p.getInt(nameField()[3]);
                user.Personal_id= p.getInt(nameField()[4]);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return user;
    }
    private int Update() {
        int id=-1;
        String query="UPDATE  "+nameTable()+" SET "+nameField()[1]+" = ?, "
            +nameField()[2]+" = ?, "+nameField()[3]+" = ?, "
            +nameField()[5]+" = ? "+" WHERE "+nameField()[0]+" = ? ;";
                
        try {
            Connection con = Conexion.createConnection();
            PreparedStatement insertar = con.prepareStatement(query,
                    Statement.RETURN_GENERATED_KEYS);
                insertar.setString  (1, usuario.user);
                insertar.setString  (2, usuario.password);
                insertar.setInt     (3, usuario.rol);
                insertar.setInt     (4, usuario.activo);
                insertar.setInt     (5, usuario.id);
                
            insertar.executeUpdate();
            ResultSet generate=insertar.getGeneratedKeys();
           if( generate.next()){
            id= generate.getInt(1);}
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,"no se pudo insertar el usuario "
                    + "verifique su conexion a la base de datos", 
            "Inntepco", JOptionPane.ERROR_MESSAGE);
        }
        return id;
    }
    public Usuario Update(Usuario user,Personal personal,ContactoEmergencia contacto) {
        if (user != null & personal!=null) {
            usuario = user;
            PersonalT personalT=new PersonalT();
            ContactoEmergenciaT contactoT =new ContactoEmergenciaT();
            //al validar el personal se cargan los datos en personalt
            if (validate()&personalT.validate(personal)&contactoT.validate(contacto)) {
                personalT.Update(personal);
                contactoT.Update(contacto);
                usuario.id=Update();
                return usuario;
            }else{
                JOptionPane.showMessageDialog(null, error+personalT.error+contactoT.error, 
            "Inntepco", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        return null;

    }

    private int insertar() {
        int id=-1;
        String query="insert into "+nameTable()+" "+Arrays.toString(nameField())
                .replace('[', '(').replace(']', ')')+" values (null,?,?,?,?,?)";
                
        try {
            Connection con = Conexion.createConnection();
            PreparedStatement insertar = con.prepareStatement(query,
                    Statement.RETURN_GENERATED_KEYS);
                insertar.setString  (1, usuario.user);
                insertar.setString  (2, usuario.password);
                insertar.setInt     (3, usuario.rol);
                insertar.setInt     (4, usuario.Personal_id);
                insertar.setInt     (5, usuario.activo);
                
            insertar.executeUpdate();
            ResultSet generate=insertar.getGeneratedKeys();
            generate.next();
            id= generate.getInt(1);
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,"no se pudo insertar el usuario "
                    + "verifique su conexion a la base de datos", 
            "Inntepco", JOptionPane.ERROR_MESSAGE);
        }
        return id;
    }
  
    public Usuario insertar(Usuario user,Personal personal,ContactoEmergencia contacto) {
        if (user != null & personal!=null) {
            usuario = user;
            PersonalT personalT=new PersonalT();
            ContactoEmergenciaT contactoT =new ContactoEmergenciaT();
            //al validar el personal se cargan los datos en personalt
            if (validate()&personalT.validate(personal)&contactoT.validate(contacto)) {
                user.Personal_id=personalT.insertar(personal).id;
                //usuario.activo=1;
                contacto.id_personal=user.Personal_id;
                contactoT.insertar(contacto);
                usuario.password=sha1(usuario.password);
                usuario.id=insertar();
                return usuario;
            }else{
                JOptionPane.showMessageDialog(null, error+personalT.error+contactoT.error, 
            "Inntepco", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        return null;

    }

    //metodos para validar
    public boolean validate(){
        return (validatepassword() & validaterol() & validateuser());
    }
    /**
     * validar nombre usuario
     */    
    public boolean validateuser() {
        if (usuario.user == null) {
            error+="Usuario invalido\n";
            return false;
        } else {
            if ((usuario.user.trim()).isEmpty()) {
                error+="Usuario invalido\n";
                return false;
            } else {
                if (usuario.user.length() > 150|usuario.user.length() <5) {
                    error+="Usuario invalido\n";
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * validar rol
     */
    public boolean validaterol() {
        if (usuario.rol == 2 | usuario.rol == 1) {            
            return true;
        }
        error+="rol invalido\n";
        return false;
    }

    /**
     * validar rol
     */
    public boolean validatepassword() {
        if (usuario.password == null) {
             error+="contraseña invalida \n";
            return false;
        } else {
            if ((usuario.password.trim()).isEmpty()) {
                 error+="contraseña invalida \n";
                return false;
            } else {
                if (usuario.password.length() > 150 | !usuario.password.equals(usuario.password_repeat)) {
                     error+="contraseña invalida \n";
                    return false;
                }
            }
        }
        return true;
    }

    public static String sha1(String password) {
        String sha1 = "";
        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(password.getBytes("UTF-8"));
            sha1 = byteToHex(crypt.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return sha1;
    }

    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }
}
