/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PLC;
 
import DB.Modelos.*;
import DB.Tables.*;
import admin.MenuAdministrador;
import inicio.de.sesion.Navegacion;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;
import javax.swing.JOptionPane;
import operador.menu_operador;

/**
 *
 * @author Caudillo
 */
public class TCP_IP {
    
    PLCpaint pintar;
    PLC_Model plcVariables;
    public Socket smtpSocket ;  
    public DataOutputStream os ;
    public DataInputStream is ;
    public BufferedReader in;
    /*
    *cuando es true el metedo sendreadplc enciende o apaga el plc dependiendo del status de este.
    */
    public boolean onOff;
    private final int PORT=1200;
    private final String IP="192.168.1.50";
    /**
     *    hexadecimal que enciende la maquinaria
    */
    private final String ENCENDER = "cccc010011000000000000000000000001000000231100005006010000000200410000000000000001";
    /**
     *    hexadecimal que apaga la maquinaria
    */
    private final String  APAGAR  = "cccc010011000000000000000000000001000000231100005006010000000200410000000000000000";
    /**
     *  no es del todo basura ya que ayuda a mantener viva la conexion al plc   
    */
    private final String BASURA="666601000000000000000000000000000100000006000000";
    /**
     *   esta variable me regresa el estado de la maquinaria
    */
    private final String send="cccc010002000000000000000000000001000000230200005005";
    /**
     * cadena de comparacion
     */
    private String comparar;
    
    /**
     * este metodo se puede modificar modificar
     * dependiendo lo que se desee guardar o 
     * @param sensores son las distintas variables del sistema adquiridas en la
     *trama de datos.
     * aqui se pueden actualizar el numero de sensores
     * 
     */
   
    public  TCP_IP(PLCpaint pintar){

        this.pintar=pintar;
       
        plcVariables=new PLC_Model();
        comparar="cccc01004000000000000000010000000000000007000000000005000000f5717e54010101x101x301x501x201x401x60100012d000000e009000037000000013635000001000110010000fc1200008c0200000163b40000";
        onOff=false;
        sendping(IP);
        login();
       cicloLectura();
    }
    
    public void login(){
        conexionplc();
        /* while(smtpSocket == null | os == null | is == null){
             conexionplc();
            if(JOptionPane.showConfirmDialog(null,"No se logro conectar al equipo"
                    +" desea volver a intentar", 
            "Inteppco", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
                    System.exit(0); 
                } 
         }*/
         
         String[] login=new String[]{
        "cccc01000900000000000000000000000100000023090000428f63400c2d434543",
        "cccc010076000000000000000000000001000000237600000104000000060000000000000000cdcd0a00070600000400000000000c060000040000000000250900000400000000002609000004000000000027090000040000000000280900000400000000002e090000040000000000dc0500000400000000007704000004000000000078040000040000000000",
        "cccc0100010000000000000000000000010000002301000011",
        "cccc010002000000000000000000000001000000230200005112",
        "cccc010002000000000000000000000001000000230200003800",
        "cccc01001c000000000000000000000001000000231c00009c040800ffff76001400000001000000000000000100000000000000",
        "cccc0100880000000000000000000000010000002388000050140d00000001000000000001000000010004000000010000000100080000000100000001000c000000010000000200000000000100000002000400000001000000020008000000010000000400a4460000010000000400ac4600000c0000000400bc460000040000000400d4460000010000000400dc4600000c0000000400ec46000004000000"
        };
         if (smtpSocket != null && os != null && is != null) {
             try {
                System.out.println("Login");                
                for (String send : login) {
                    os.write( hexStringToByteArray(send));
                    lectura(is);
                    os.write( hexStringToByteArray(BASURA));
                    lectura(is);
                }   System.out.println("End Login");
             } catch (UnknownHostException e) {
                
                System.err.println("No fue posible establecer la conexion con el plc" );
            } catch (IOException e) {
                System.err.println("No fue posible establecer la conexion con el plc");
            }
        }else{
        System.out.println("No se logro Conectar al PLC");
         }
    }
    public boolean conexionplc(){
        boolean x=false;
        try{
            smtpSocket = new Socket(IP, PORT);
            os = new DataOutputStream(smtpSocket.getOutputStream());
            is = new DataInputStream(smtpSocket.getInputStream());
            in = new BufferedReader(new InputStreamReader(
                           smtpSocket.getInputStream()));
          System.out.println("conectando");
        } catch (UnknownHostException e) {
            System.err.println("No se pudo realizar la conexion al host");
            x=true;
           
        } catch (IOException e) {
            System.err.println("No se pudo realizar la conexion al host");
            x=true;
            
        }
        return false;
    }
    public void cicloLectura(){
    if (smtpSocket != null && os != null && is != null) {
    Thread Leyendo= new Thread(){
        public void run(){
            System.out.println("Thread Running");
            while(true){
                sendreadplc();
                try{
                        Thread.sleep(100);
                    }catch(Exception e)
                    {
                       System.out.println("error al dormir");
                    }
            }
            }
     };
    Leyendo.start();
    }
    }
    public synchronized void sendreadplc(){
       if (smtpSocket != null && os != null && is != null) {
             try {    
                    String lectura;
                    os.write( hexStringToByteArray(send));
                    lectura=lectura(is);
                    if(lectura.length()>100){
                    if(!(lectura.substring(70, 100).equals
                         (comparar.substring(70, 100)))){
                        comparar=lectura;
                         final PLC_Model oldplc=plcVariables;
                         plcVariables=new PLC_Model();
                        updatevariables(AllSensor(lectura));
                        savebd(oldplc);
                        System.out.println(lectura);
                    }}else{
                        System.out.println("no se recivio nada"+lectura);
                    }
                        
                    os.write( hexStringToByteArray(BASURA));
                    lectura(is);
                    
                    
                    if(this.onOff){
                        if(plcVariables.encendidoSistema){
                            os.write( hexStringToByteArray(APAGAR));
                            
                        }else
                        {
                            os.write( hexStringToByteArray(ENCENDER));
                        }
                        lectura(is);
                        System.out.println("encendiendo/apagando");
                        os.write( hexStringToByteArray(BASURA));
                        lectura(is);
                        onOff=false;
                    }
                    
                    
                    
             } catch (UnknownHostException e) {
                
                System.err.println("No fue posible establecer la conexion con el plc" );
            } catch (IOException e) {
                System.err.println("No fue posible establecer la conexion con el plc");
            }
        }else{
        System.out.println("No se logro Conectar al PLC");
         }
    }
     public void updatevariables(boolean[][] sensores){
        //final PLC_Model plcVariables2=plcVariables;
        //indican si esta encendido el equipo o pieza
        plcVariables.banda1=sensores[3][3];
        plcVariables.banda2=sensores[1][5];
        plcVariables.blower=sensores[1][6];
        plcVariables.botonEncendido=sensores[2][0];
        plcVariables.criva=sensores[1][6];
        plcVariables.dosificadora=sensores[3][0];
        plcVariables.encendidoSistema=sensores[5][1];
        plcVariables.lleno=sensores[3][6];
        plcVariables.lleno1=sensores[3][2];
        plcVariables.lleno2=sensores[3][1];
        plcVariables.metales=sensores[3][5];
        plcVariables.trituradora=sensores[3][4];
        plcVariables.pulverizadora=sensores[5][0];
        //indican si hubo hay o existio un error en la pieza
        plcVariables.sensorBanda1=sensores[4][4];
        plcVariables.sensorBanda2=sensores[2][7];
        plcVariables.sensorBlower=sensores[4][2];
        plcVariables.sensorCriva=sensores[4][5];
        plcVariables.sensorDosificadora=sensores[4][6];
        plcVariables.sensorPulverizadora=sensores[4][3];
        plcVariables.sensorTrituradora=sensores[4][7];
        plcVariables.sensorlleno1=sensores[4][1];
        plcVariables.sensorlleno2=sensores[0][0];
        plcVariables.sensormetales=sensores[0][5];
        //pintar.repaint(plcVariables);
    }
    public void savebd(PLC_Model plc_old){
        if(plcVariables.sensorBanda1!=plc_old.sensorBanda1){
           if(plcVariables.sensorBanda1 ){
               guardarerror("sensorBanda1",1);
           }else{ 
               updateerror(1);
           } 
        }
        if(plcVariables.sensorBanda2==plc_old.sensorBanda2){
            if(plcVariables.sensorBanda2 ){
               guardarerror("sensorBanda2",2);
           }else{ 
               updateerror(2);
           } 
        }
        if(plcVariables.sensorBlower==plc_old.sensorBlower){
            if(plcVariables.sensorBlower ){
               guardarerror("sensorBlower",3);
           }else{ 
               updateerror(3);
           } 
            
        }
        if(plcVariables.sensorCriva==plc_old.sensorCriva){
            if(plcVariables.sensorCriva ){
               guardarerror("sensorCriva",4);
           }else{ 
               updateerror(4);
           } 
        }
        if(plcVariables.sensorDosificadora==plc_old.sensorDosificadora){
            if(plcVariables.sensorDosificadora ){
               guardarerror("sensorDosificadora",5);
           }else{ 
               updateerror(5);
           } 
            
        }
        if(plcVariables.sensorPulverizadora==plc_old.sensorPulverizadora){
            if(plcVariables.sensorPulverizadora ){
               guardarerror("sensorPulverizadora",6);
           }else{ 
               updateerror(6);
           } 
        }
        if(plcVariables.sensorTrituradora==plc_old.sensorTrituradora){
            if(plcVariables.sensorTrituradora ){
               guardarerror("sensor trituradora",7);
           }else{ 
               updateerror(7);
           } 
        }
        if(plcVariables.sensorlleno1==plc_old.sensorlleno1){
            if(plcVariables.sensorlleno1 ){
//               guardarerror("");
            } 
        }
        if(plcVariables.sensorlleno2==plc_old.sensorlleno2){
            if(plcVariables.sensorlleno2 ){
//               guardarerror("");
           } 
        }
        if(plcVariables.sensormetales==plc_old.sensormetales){
            if(plcVariables.sensormetales ){
               guardarerror("sensor metales",8);
           }else{ 
               updateerror(8);
           } 
        }
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
    public synchronized void setOnOff(){
        onOff=true;
    }
    
    public  boolean sendping(String id){
        boolean recivido;
        try{
        InetAddress inet = InetAddress.getByName(id);
        recivido=inet.isReachable(5000);
        }
        catch(UnknownHostException ex){
                recivido=false;
                System.out.println(ex.getMessage());
                }
        catch(IOException ex){ 
            recivido=false;
            System.out.println(ex.getMessage());
                    }
        return recivido;
    }
    public  byte[] hexStringToByteArray(String s) {
    int len = s.length();
    byte[] data = new byte[len / 2];
    for (int i = 0; i < len; i += 2) {
        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                             + Character.digit(s.charAt(i+1), 16));
        }
    return data;
    }
    public int hexdecimaltoint(String hexa){
         int entero=0;
         try{
            entero= Integer.parseInt(hexa.trim(), 16 );
         } catch(Exception e){}
         return entero;                 
    }
    
    
    public String lectura(DataInputStream is){
        String lectura="";
        String tamaño="";
        try{
        
        for (int i = 0; i < 4; i++) {
                lectura+=  String.format("%02x", is.read() & 0xff);
                }
        for (int i = 0; i < 8; i++) {
                String read=  String.format("%02x", is.read() & 0xff);
                lectura+=read;
                tamaño=read+tamaño;
                }
        for (int i = 0; i < 12+(hexdecimaltoint(tamaño)); i++) {
                lectura+=  String.format("%02x", is.read() & 0xff);
                }
        } catch (IOException e) {
                System.err.println("IOException:  " + e);
        }
                
        return lectura;
    }
    /**
    @param numero un valor de 0 a 100 en hexadecimal
    @return regresa un arreglo de 9 variables boleanas dependiendo el valor del numero 
    la regresara en true o false
    * 
    */
    public boolean[][] AllSensor(String cadena){
        boolean[][] sensores=new boolean[6][8];
        sensores[0]=Arraysensor(cadena.substring(74, 76));
        sensores[1]=Arraysensor(cadena.substring(86,88 ));
        sensores[2]=Arraysensor(cadena.substring(78,80 ));
        sensores[3]=Arraysensor(cadena.substring(90,92 ));
        sensores[4]=Arraysensor(cadena.substring(82,84 ));
        sensores[5]=Arraysensor(cadena.substring(94,96 ));
        return sensores;
    }
    public  boolean[] Arraysensor(String numero){        
        return  Arraysensor(hexdecimaltoint(numero));                
    }
    /**
    @param number un valor de 0 a 256
    @return regresa un arreglo de 9 variables boleanas dependiendo el valor del numero 
    la regresara en true o false
    * 
    */
    public  boolean[] Arraysensor(int number){
        boolean[] sensores=new boolean[8];
                            
        int valor[]=new int[]{1,2,4,8,16,32,64,128};
        for (int i = 7; i >= 0; i--) {
            if(number==0){
                break;
            }
           if((number-valor[i])>=0){
            sensores[i]=true;
            number-=valor[i];
        } 
        }
        return sensores;                
    }
    
}
