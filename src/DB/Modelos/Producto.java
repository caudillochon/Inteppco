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
public class Producto {
      /**
     * identificador
     */
    public int id;
     /**
     * relacion con personal
     */
    public int id_pieza;
    /**
     * Nombre completo   
    */
    public Date fecha_compra;
    /**
     * Valor devuelto pore plc
     */
    public Date instalacion;
    /**
     * Valor devuelto pore plc
     */
    public Date mantenimiento;
    /**
     * Valor devuelto pore plc
     */
    public float precio;
    /**
     * Valor devuelto pore plc
     */
    public int encargadomto_id;
   
}
