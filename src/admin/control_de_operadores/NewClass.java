/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.control_de_operadores;

import DB.Modelos.FallasOcurridas;
import DB.Tables.FallasOcurridasT;
import java.util.Date;

/**
 *
 * @author Caudillo
 */
public class NewClass {
 
    public static void main(String[] args) {
       // guardarerror("pulverizadora", 6);
        updateerror(1);
    }
     private static void guardarerror(String activadoX, int idfalla){
        FallasOcurridas falla=new FallasOcurridas();
               falla.activadapor=activadoX;
               falla.deteccion="";
               falla.inicio=new Date();
               falla.fin=new Date();
               falla.id_falla=idfalla;
               FallasOcurridasT bd =new FallasOcurridasT();
               bd.insertar(falla);
    }
    private static void updateerror(int idfalla){
        FallasOcurridasT bd =new FallasOcurridasT();
               int id=bd.Update(idfalla);
    }
}
