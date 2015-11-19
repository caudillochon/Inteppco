package DB.Modelos;

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
public class FallasPosibles {
    /**
     * identificador
     */
    public int id;
    /**
     * tipo de falla accidente/falla/otro   
    */
    public String tipo;
     /**
     * nombre completo
     */
    public String nombre;
     /**
     * relacion con la pieza la pieza uno sera un valor default
     */
    public int pieza;
    /**
     * Valor devuelto pore plc
     */
    public String valor;
    /**
     * 
     */
    /**
     * Descripcion de la falla
     */
    public String descripcion;
  
   
    
    
}