/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.Modelos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

/**
 *
 * @author Caudillo
 * Encargado Mantenimiento
 */
public class EncargadoMto {
    /**
     * identificador
     */
    public int id;
    /**
     * Nombre completo    
    */
    public String nombre;
     /**
     * compañia
     */
    public String compañia;
     /**
     * Numero de telefono
     */
    public int telefono;
    /**
     * Correo
     */
    public String correo;
   
    /**
     * Completa calle, #,colonia 
     */
    public String direccion;
  
   
    
    
}