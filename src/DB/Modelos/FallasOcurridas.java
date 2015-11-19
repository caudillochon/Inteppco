package DB.Modelos;

import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Caudillo
 * Encargado Mantenimiento
 */
public class FallasOcurridas {
    /**
     * identificador
     */
    public int id;
    /**
     * identificador
     */
    public int id_falla;
    /**
     * --personal(parada manualmente por un operador)
     * --sistema (activada por un sensor)     * 
    */
    public String deteccion;
     /**
     * valor sensor
     */
    public String activadapor;
     /**
     * relacion con la pieza la pieza uno sera un valor default
     */
    public Date inicio;
    /**
     * Valor devuelto pore plc
     */
    public Date fin;
   
    
  
   
    
    
}