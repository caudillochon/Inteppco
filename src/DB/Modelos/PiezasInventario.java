/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.Modelos;

import java.util.Date;

/**
 *
 * @author Caudillo
 */
public class PiezasInventario {
      /**
     * identificador
     */
    public int id;
     /**
     * relacion con personal
     */
    public double cantidad;
    /**
     * Nombre completo   
    */
    public Date fecha;
    /**
     * Valor devuelto pore plc
     */
    public int borrado_logico;
    /**
     * Valor devuelto pore plc
     */
    public String nota;
    /**
     * Valor devuelto pore plc
     */
    public int producto_tipo_id;
   
}
