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
public class GeneralDeErrores {

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
    public GeneralDeErrores(String ID, String administrador, Date intervaloInicio, Date intervalofin, Date fechaActual, Connection coneccion) {
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
            Logger.getLogger(GeneralDeErrores.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(GeneralDeErrores.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(GeneralDeErrores.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cantidad;
    }
    
    public void crearReporte() {
        InputStream is = null;
       
        try {
             
             int alertAccident = valorInt("SELECT COUNT(tabla.tipo) as total "
                     + "FROM (SELECT fp.tipo FROM fallasocurridas fo,fallasposibles fp "
                     + "WHERE fo.idfalla = fp.id AND fp.tipo = 'accidente' "
                     + "AND (inicio BETWEEN '"+consultaInicio+"' AND '"+consultaFin+"')) as tabla");
             
             int alertFalla = valorInt("SELECT COUNT(tabla.tipo) as total "
                     + "FROM (SELECT fp.tipo FROM fallasocurridas fo,fallasposibles fp "
                     + "WHERE fo.idfalla = fp.id AND fp.tipo = 'falla' "
                     + "AND (inicio BETWEEN '"+consultaInicio+"' AND '"+consultaFin+"')) as tabla");
            
            int alertOtro = valorInt("SELECT COUNT(tabla.tipo) as total "
                     + "FROM (SELECT fp.tipo FROM fallasocurridas fo,fallasposibles fp "
                     + "WHERE fo.idfalla = fp.id AND fp.tipo = 'otro' "
                     + "AND (inicio BETWEEN '"+consultaInicio+"' AND '"+consultaFin+"')) as tabla");
            
            int totalErrores = alertAccident + alertFalla + alertOtro;
            
            double duracionProm = valorDouble("SELECT AVG(tabla.tfalla) FROM "
                    + "(SELECT TIMESTAMPDIFF(MINUTE,inicio,fin) as tfalla "
                    + "FROM fallasocurridas fp WHERE inicio BETWEEN '"+consultaInicio+"' AND '"+consultaFin+"') as tabla");
            BigDecimal big = new BigDecimal(duracionProm);
            big = big.setScale(2, RoundingMode.HALF_UP);
            
            double esperaProm = valorDouble("SELECT AVG(tabla.espera) AS tiempoPromEspera "
                    + "FROM (SELECT (TIMESTAMPDIFF(MINUTE,inicio,fin) - ROUND(TIME_TO_SEC(TiempoRep)/60)) "
                    + "as espera FROM fallasocurridas fp WHERE inicio BETWEEN '"+consultaInicio+"' AND '"+consultaFin+"') AS tabla");
            BigDecimal big2 = new BigDecimal(esperaProm);
            big2 = big2.setScale(2, RoundingMode.HALF_UP);
            
            
            Time horaPromOcu = valorTime("SELECT SEC_TO_TIME(ROUND(AVG(tabla.tiempoS))) "
                    + "FROM (SELECT TIME_TO_SEC(TIME(inicio)) as tiempoS FROM fallasocurridas fp "
                    + "WHERE inicio BETWEEN '"+consultaInicio+"' AND '"+consultaFin+"') as tabla");
            
            if (horaPromOcu == null) {
                horaPromOcu = new Time(0, 0, 0);
            }
            
            map.put("alertAccident", alertAccident);
            map.put("alertFalla", alertFalla);
            map.put("alertOtro", alertOtro);
            map.put("totalErrores", totalErrores);
            map.put("duracionProm", big);
            map.put("esperaProm", big2);
            map.put("horaPromOcu", horaPromOcu.toString());
            
            //generacion del grafico 
            ArrayList arr = new ArrayList();
            Map m = new HashMap();
            m.put("tipo", "Accidentes");
            m.put("cantidad", alertAccident);
            m.put("cantidadS", String.valueOf(alertAccident));
            arr.add(m);
            m = new HashMap();
            m.put("tipo", "Fallas");
            m.put("cantidad", alertFalla);
            m.put("cantidadS", String.valueOf(alertFalla));
            arr.add(m);
            m = new HashMap();
            m.put("tipo", "Otros");
            m.put("cantidad", alertOtro);
            m.put("cantidadS", String.valueOf(alertOtro));
            arr.add(m);
            
            List l = arr;
            JRMapCollectionDataSource dataSource = new JRMapCollectionDataSource(l);
            map.put("mapCollection", dataSource);
            
            
            is = (InputStream) getClass().getResourceAsStream("/ReportesJ/ReporteGeneralDeErrores/ReporteGeneralDeErrores.jrxml");

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
