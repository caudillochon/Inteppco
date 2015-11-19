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
 */
public class Personal {
    /**
     * identificador
     */
    public int id;
    /**
     * Nombre completo    
    */
    public String nombre;
    /**
     * Correo
     */
    public String correo;
    /**
     * # del seguro social
     */
    public String seguroSocial;
    /**
     * Numero de telefono
     */
    public long telefono;
    /**
     * Completa calle, #,colonia 
     */
    public String direccion;
    public String lugarnaciemiento;

    public Date fechanacimeinto;
    /**
     * Referencia al puesto desempeñado
     */
    public int puesto_id;
    /**
     * puesto desempeñado
     */
    public Puesto puesto;
    /**
     * 1->activo
     * 0->inactivo
     */
    public int activo;
        
}