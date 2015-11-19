/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.Modelos;

/**
 *
 * @author Caudillo
 * @param id
 * @param user
 * @param password
 * @param rol
 */
public class Usuario  {

    /**
     * identificador del usuario en la base de datos
     */
    public int id;
    /**
     * nombre del usuario
     */
    public String user;
    /**
     * Contraseña
     */
    public String password;
    /**
     * Contraseña confirmar
     */
    public String password_repeat;
    /**
     * Admin(1)/operador(2)
     */
    public int rol;
    /**
     * referencia con los datos del usuario en personal
     */
    public int Personal_id;
    /**
     * Datos del usuario
     */
    public Personal personal;
    /**
     * 0-> usuario inactivo
     * 1-> usuario activo
     */
    public int activo;
    /**
     * datos  del usuario
     */
    public Usuario() {
        id=0;
        user="";
        password="";
        password_repeat="";
        rol=0;
        Personal_id=0;
        activo=1;
        personal=new Personal();
        
                
    }
    public Usuario(String usuario,String password,String password_repeat,int rol,int activo) {
        this();
        id=0;
        user=usuario;
        this.password=password;
        this.password_repeat=password_repeat;
        this.rol=rol;
        this.activo=activo;
                
    }
    
}