/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicio.de.sesion;

import Componentes.Menu_Componentes;
import DB.Modelos.Personal;
import DB.Modelos.Usuario;
import PLC.TCP_IP;
import admin.MenuAdministrador;
import admin.control_de_operadores.Mensaje_Admin;
import admin.control_de_operadores.Modificar_Operadores;
import admin.control_de_operadores.Modificar_Usuarios;
import admin.control_de_operadores.Registrar_Operador;
import admin.control_de_operadores.Registrar_Usuarios;
import admin.reportes.ControlDePersonal;
import admin.reportes.reportes;
import operador.menu_operador;
import operador.mi_perfil.menu_perfil;

/**
 *
 * @author Caudillo
 */
public class Navegacion {
    public Usuario user;
    public TCP_IP PLC;
    
    public menu_operador pantallaoperador ;
    public MenuAdministrador pantalladministrador;
    //public javax.swing.JFrame Actual;
    public Navegacion(Usuario user){
        this.user=user;     
    }
    public void login(){
        if(user.rol==0){
            pantalladministrador=new MenuAdministrador(this);
            PLC=new TCP_IP(pantalladministrador);
            pantalladministrador.onOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PLC.setOnOff();
            }
        });
            pantalladministrador.setVisible(true);}
        else{
            pantallaoperador=new menu_operador(this);
            PLC=new TCP_IP(pantallaoperador);
            pantallaoperador.setVisible(true);  
        }
    }
    
public void openControlDePersonal(){
    final ControlDePersonal control_personal= new ControlDePersonal(this);
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {            
            control_personal.setVisible(true);
        }
    });
}
public void openControlDeReportes(){
    final reportes control_reportes= new reportes(this);
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {            
            control_reportes.setVisible(true);
        }
    });
}
public void openEditarusuarios(Usuario usuario){
    final Modificar_Usuarios modificar_Usuarios=new Modificar_Usuarios(this,usuario);
    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              
              modificar_Usuarios.setVisible(true);
            }
            });
}
public void openAddusuarios(){
    final Registrar_Usuarios registrar_Usuarios= new Registrar_Usuarios(this);
    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              
              registrar_Usuarios.setVisible(true);
            }
            });
}
public void openEditarPersonal(Personal personal){
    final Modificar_Operadores modificar_operadores= new Modificar_Operadores(this, personal);
    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
               modificar_operadores.setVisible(true);
            }
            });
}
public void openAddPersonal(){
    final Registrar_Operador  registrar_operador=new Registrar_Operador(this);
    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {            
              registrar_operador.setVisible(true);
            }
            });
}
public void openMiPerfil(){
    menu_perfil miperfil=new menu_perfil(this);
    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              miperfil.setVisible(true);
            }
            });
}
public void openMensajes(){
    Mensaje_Admin mensaje_Admin=new Mensaje_Admin(this);
    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {              
              mensaje_Admin.setVisible(true);
            }
            });
}
public void openGestioncomponentes(){
    final Menu_Componentes menu_componentes= new Menu_Componentes(this);
    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              
              menu_componentes.setVisible(true);
            }
            });
}
    public void openotro(){
        
    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                (Acceso.this);
//              .setVisible(true);
            }
            });
}
    
}
