/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.Modelos;

/**
 *
 * @author Caudillo
 */
public class ContactoEmergencia {
      /**
     * identificador
     */
    public int id;
     /**
     * relacion con personal
     */
    public int id_personal;
    /**
     * Nombre completo   
    */
    public String nombre;
    /**
     * Correo
     */
    public String correo;
    
    /**
     * Numero de telefono
     */
    public long telefono;
    /**
     * Completa calle, #,colonia 
     */
    public String direccion;

   
}
