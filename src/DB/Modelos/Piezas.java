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
public class Piezas {
     /**
     * identificador
     */
    
    public int id;
    /**
     * Localizacion de la pieza
     */
    public String descripcion;
     /**
     * nombre completo
     */
    public String nombre;
     /**
     * tiempo en dias
     */
    public int tiempoVida;
    /**
     * Valor devuelto pore plc
     */
    public String valor;
    
    public Piezas(){
    id=0;
    descripcion="";
    nombre="";
    tiempoVida=0;
    valor="";
    
    }

    
}
