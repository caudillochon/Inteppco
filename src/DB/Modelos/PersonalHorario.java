/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.Modelos;

import java.sql.Time;
import java.util.Date;

/**
 * @author Caudillo
 * horario del personal
 */
public class PersonalHorario {
    /**
     * identificador Base de Datos
     */
    public int id;
    public int personalid;
    public String dia;
    /**
     * hora de entrada
     */
    public Time entrada;
    /**
     * hora de salida
     */
    public Time salida;
    
    public Time descanzoe;
    
    public Time descanzos;
    public PersonalHorario(){
        id=0;
        personalid=0;
        dia="0000000";
        entrada=new Time(0,0,0);
        salida=new Time(0,0,0);
        descanzoe=new Time(0,0,0);
        descanzos=new Time(0,0,0);
                
    }
            
    
    
}
