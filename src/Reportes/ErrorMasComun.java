/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author franciscojavier
 */
public class ErrorMasComun {

    //variables rellenadas por el constructor
    private String ID;
    private String administrador;
    private Date intervaloInicio;
    private Date intervalofin;
    private Date fechaActual;
    //variables internas para la clase, todas seran rellenadas en el constructor de la clase, pero no son rellenadas por medio de los parametro del constructor
    private String stringInicio;
    private String stringFin;
    private String stringFechaActual;
    private String stringHoraActual;
    private String consultaInicio;
    private String consultaFin;
    //varialbes de control de BD
    private BDControl bdc;
    private Connection co;
    
    //mapa global
    private HashMap map;
    
    //otras cosas;
    private Calendar c;
    
    public ErrorMasComun(String ID, String administrador, Date intervaloInicio, Date intervalofin, Date fechaActual, Connection coneccion) {
        this.ID = ID;
        this.administrador = administrador;
        this.intervaloInicio = intervaloInicio;
        this.intervalofin = intervalofin;
        this.fechaActual = fechaActual;
        this.co = coneccion;
        this.bdc = new BDControl(co);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm a");
        SimpleDateFormat sdfConsultas = new SimpleDateFormat("yyyy-MM-dd");
        stringInicio = sdf.format(intervaloInicio);
        stringFin = sdf.format(intervalofin);
        stringFechaActual = sdf.format(fechaActual);
        stringHoraActual = sdf2.format(fechaActual);
        //String utilizados para los interalos del reporte
        consultaInicio = sdfConsultas.format(intervaloInicio);
        c.setTime(intervalofin);
        c.add(Calendar.DAY_OF_MONTH, 1);
        Date intervale1DiaMas = c.getTime();
        consultaFin = sdfConsultas.format(intervale1DiaMas);
        
        map = new HashMap();
        map.put("titleID", this.ID);
        map.put("titleadministradorNombre", this.administrador);
        map.put("dateInicio", this.intervaloInicio);
        map.put("dateFin", this.intervalofin);
        map.put("titleDateInicio", stringInicio);
        map.put("titleDateFin", stringFin);
        map.put("titleFechaActual", stringFechaActual);
        map.put("titleHoraActual", stringHoraActual);
        map.put("dateHoraActual", this.fechaActual);
        
        map.put("consultaInicio", this.consultaInicio);
        map.put("consultaFin", this.consultaFin);

    }

    public String getID() {
        return ID;
    }

    public String getOperador() {
        return administrador;
    }

    public Date getIntervaloInicio() {
        return intervaloInicio;
    }

    public Date getIntervalofin() {
        return intervalofin;
    }

    public Date getFechaActual() {
        return fechaActual;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setOperador(String operador) {
        this.administrador = operador;
    }

    public void setIntervaloInicio(Date intervaloInicio) {
        this.intervaloInicio = intervaloInicio;
    }

    public void setIntervalofin(Date intervalofin) {
        this.intervalofin = intervalofin;
    }

    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }
    
    private int valorInt(String query){
        int cantidad = -1;
        ResultSet rs = bdc.query(query);
        try {
            rs.next();
             cantidad = rs.getInt(1);
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ErrorMasComun.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cantidad;
    }
    
    private double valorDouble(String query){
        double cantidad = -1;
        ResultSet rs = bdc.query(query);
        try {
            rs.next();
             cantidad = rs.getDouble(1);
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ErrorMasComun.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cantidad;
    }
    
    private Time valorTime(String query){
        Time cantidad = null;
        ResultSet rs = bdc.query(query);
        try {
            rs.next();
             cantidad = rs.getTime(1);
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ErrorMasComun.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cantidad;
    }
    
    
    
    public void crearReporte() {
        InputStream is = null;
        ResultSet rs;
        try {
            
            //FAAAAAALLAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA!!  
             rs = bdc.query("SELECT fp.id,COUNT(fp.id) AS rep FROM fallasocurridas fo, fallasposibles fp "
                     + "WHERE fo.idfalla = fp.id AND fp.tipo = 'falla' AND "
                     + "(fo.inicio BETWEEN '"+consultaInicio+"' AND '"+consultaFin+"') "
                     + "GROUP by fp.id ORDER BY rep DESC LIMIT 1");
             rs.next();
             int fallaMComunId = rs.getInt(1);
             int fallaeMComunRep = rs.getInt(2);
             rs.close();
             
             rs = bdc.query("SELECT fp.nombre,s.solucion FROM fallasposibles fp,solucion s "
                     + "WHERE s.idfallaposible = fp.id AND fp.id = '"+fallaMComunId+"'");
             rs.next();
             String nombrefalla = rs.getString(1);
             String solucionfalla = rs.getString(2);
             rs.close();
             
             rs = bdc.query("SELECT AVG(tabla.tiempoFalla) as promFalla,AVG(tabla.tiempoRep) as promRep,"
                     + "AVG(tabla.espera) as promEspera,SEC_TO_TIME(ROUND(AVG(tabla.tiempo))) "
                     + "AS tiempoProm FROM (SELECT TIMESTAMPDIFF(MINUTE,fo.inicio,fo.fin) AS "
                     + "tiempoFalla,ROUND(TIME_TO_SEC(TiempoRep)/60) AS tiempoRep,"
                     + "(TIMESTAMPDIFF(MINUTE,fo.inicio,fo.fin) - ROUND(TIME_TO_SEC(TiempoRep)/60)) "
                     + "AS espera ,TIME_TO_SEC(TIME(fo.inicio)) as tiempo FROM fallasocurridas fo, "
                     + "fallasposibles fp WHERE fo.idfalla = fp.id AND fp.id = '"+fallaMComunId+"' AND "
                     + "(fo.inicio BETWEEN '"+consultaInicio+"' AND '"+consultaFin+"')) AS tabla");
             rs.next();
             int duracionPromFalla = rs.getInt(1);
             int tiempoEspPromFalla = rs.getInt(3);
             Time horaPromFalla = rs.getTime(4);
             rs.close();
             
             map.put("fallaeMComunRep", fallaeMComunRep);
             map.put("nombrefalla", nombrefalla);
             map.put("solucionfalla", solucionfalla);
             map.put("duracionPromFalla", duracionPromFalla);
             map.put("tiempoEspPromFalla", tiempoEspPromFalla);
             map.put("horaPromFalla", horaPromFalla.toString());
            
            
             //ACCIDENTESSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS!!!!! 
             rs = bdc.query("SELECT fp.id,COUNT(fp.id) AS rep FROM fallasocurridas fo, fallasposibles fp "
                     + "WHERE fo.idfalla = fp.id AND fp.tipo = 'accidente' AND "
                     + "(fo.inicio BETWEEN '"+consultaInicio+"' AND '"+consultaFin+"') "
                     + "GROUP by fp.id ORDER BY rep DESC LIMIT 1");
             rs.next();
             int AccidenteMComunId = rs.getInt(1);
             int AccidenteMComunRep = rs.getInt(2);
             rs.close();
             
             rs = bdc.query("SELECT fp.nombre,s.solucion FROM fallasposibles fp,solucion s "
                     + "WHERE s.idfallaposible = fp.id AND fp.id = '"+AccidenteMComunId+"'");
             rs.next();
             String nombreAccident = rs.getString(1);
             String solucionAccidente = rs.getString(2);
             rs.close();
             
             rs = bdc.query("SELECT AVG(tabla.tiempoFalla) as promFalla,AVG(tabla.tiempoRep) as promRep,"
                     + "AVG(tabla.espera) as promEspera,SEC_TO_TIME(ROUND(AVG(tabla.tiempo))) "
                     + "AS tiempoProm FROM (SELECT TIMESTAMPDIFF(MINUTE,fo.inicio,fo.fin) AS "
                     + "tiempoFalla,ROUND(TIME_TO_SEC(TiempoRep)/60) AS tiempoRep,"
                     + "(TIMESTAMPDIFF(MINUTE,fo.inicio,fo.fin) - ROUND(TIME_TO_SEC(TiempoRep)/60)) "
                     + "AS espera ,TIME_TO_SEC(TIME(fo.inicio)) as tiempo FROM fallasocurridas fo, "
                     + "fallasposibles fp WHERE fo.idfalla = fp.id AND fp.id = '"+AccidenteMComunId+"' AND "
                     + "(fo.inicio BETWEEN '"+consultaInicio+"' AND '"+consultaFin+"')) AS tabla");
             rs.next();
             
             int duracionPromAccident = rs.getInt(1);
             int tiempoEspPromAccident = rs.getInt(3);
             Time horaPromAccident = rs.getTime(4);
             rs.close();
             
             map.put("AccidenteMComunRep", AccidenteMComunRep);
             map.put("nombreAccident", nombreAccident);
             map.put("solucionAccidente", solucionAccidente);
             map.put("duracionPromAccident", duracionPromAccident);
             map.put("tiempoEspPromAccident", tiempoEspPromAccident);
             map.put("horaPromAccident", horaPromAccident.toString());
            
             //OOOOTROOOOSSSSssssssssssssSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS!!!!!!!
             rs = bdc.query("SELECT fp.id,COUNT(fp.id) AS rep FROM fallasocurridas fo, fallasposibles fp "
                     + "WHERE fo.idfalla = fp.id AND fp.tipo = 'otro' AND "
                     + "(fo.inicio BETWEEN '"+consultaInicio+"' AND '"+consultaFin+"') "
                     + "GROUP by fp.id ORDER BY rep DESC LIMIT 1");
             rs.next();
             int otroMComunId = rs.getInt(1);
             int otroMComunRep = rs.getInt(2);
             rs.close();
             
             rs = bdc.query("SELECT fp.nombre,s.solucion FROM fallasposibles fp,solucion s "
                     + "WHERE s.idfallaposible = fp.id AND fp.id = '"+otroMComunId+"'");
             rs.next();
             String nombreOtro = rs.getString(1);
             String solucionOtro = rs.getString(2);
             rs.close();
             
             rs = bdc.query("SELECT AVG(tabla.tiempoFalla) as promFalla,AVG(tabla.tiempoRep) as promRep,"
                     + "AVG(tabla.espera) as promEspera,SEC_TO_TIME(ROUND(AVG(tabla.tiempo))) "
                     + "AS tiempoProm FROM (SELECT TIMESTAMPDIFF(MINUTE,fo.inicio,fo.fin) AS "
                     + "tiempoFalla,ROUND(TIME_TO_SEC(TiempoRep)/60) AS tiempoRep,"
                     + "(TIMESTAMPDIFF(MINUTE,fo.inicio,fo.fin) - ROUND(TIME_TO_SEC(TiempoRep)/60)) "
                     + "AS espera ,TIME_TO_SEC(TIME(fo.inicio)) as tiempo FROM fallasocurridas fo, "
                     + "fallasposibles fp WHERE fo.idfalla = fp.id AND fp.id = '"+otroMComunId+"' AND "
                     + "(fo.inicio BETWEEN '"+consultaInicio+"' AND '"+consultaFin+"')) AS tabla");
             rs.next();
             
             int duracionPromOtro = rs.getInt(1);
             int tiempoEspPromOtro = rs.getInt(3);
             Time horaPromOtro = rs.getTime(4);
             rs.close();
             
             map.put("otroMComunRep", otroMComunRep);
             map.put("nombreOtro", nombreOtro);
             map.put("solucionOtro", solucionOtro);
             map.put("duracionPromOtro", duracionPromOtro);
             map.put("tiempoEspPromOtro", tiempoEspPromOtro);
             map.put("horaPromOtro", horaPromOtro.toString());
             
             
             
           //generacion del grafico 
           ArrayList arr = new ArrayList();
            Map m = new HashMap();
            m.put("tipo", "Accidentes");
            m.put("cantidad", AccidenteMComunRep);
            m.put("cantidadS", String.valueOf(AccidenteMComunRep));
            arr.add(m);
            m = new HashMap();
            m.put("tipo", "Fallas");
            m.put("cantidad", fallaeMComunRep);
            m.put("cantidadS", String.valueOf(fallaeMComunRep));
            arr.add(m);
            m = new HashMap();
            m.put("tipo", "Otros");
            m.put("cantidad", otroMComunRep);
            m.put("cantidadS", String.valueOf(otroMComunRep));
            arr.add(m);
            
            List l = arr;
            JRMapCollectionDataSource dataSource = new JRMapCollectionDataSource(l);
            map.put("mapCollection", dataSource);
            
            
            is = (InputStream) getClass().getResourceAsStream("/ReportesJ/ReporteErrorMasComun/ReporteErrorMasComun.jrxml");

            JasperDesign jd = JRXmlLoader.load(is);
            JasperReport report = JasperCompileManager.compileReport(jd);
            JasperPrint print = JasperFillManager.fillReport(report, map, co);
            JasperViewer.viewReport(print, false);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                is.close();
            } catch (Exception e) {
            }
        }
    }
    
    
}
