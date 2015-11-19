/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package admin.reportes;

import admin.MenuAdministrador;
import inicio.de.sesion.Acceso;
import inicio.de.sesion.Navegacion;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 *
 * @author Luis
 */
public class reportes extends javax.swing.JFrame {
public Navegacion navegacion;
    /**
     * Creates new form accseso
     */
    public reportes(Navegacion navegacion) {
          this.navegacion= navegacion;
        initComponents();
        setLocationRelativeTo(null); //se elije en que parte de la pantalla aparecera null (centro)
        //setResizable(false);//evitamos que la pantalla se modifique.
        this.setTitle("Menu Administrador-Inteppco");//titulo a la pantalla.
        setIconImage(new ImageIcon(getClass().getResource("/imgVentanas/logo_1.png")).getImage());
                try{
        BufferedImage imagen =ImageIO.read(MenuAdministrador.class.getResourceAsStream("/imgVentanas/fondo.png"));
        Control_fondo.
        BgBorder borde = new Control_fondo.BgBorder(imagen) ;            
      primario.setBorder(borde);
     
                }
       catch(IOException io){
           
       }
    }

   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        repor_errores1 = new javax.swing.JButton();
        primario = new javax.swing.JPanel();
        tabbedPaneHeader1 = new org.edisoncor.gui.tabbedPane.TabbedPaneHeader();
        ControlPer = new org.edisoncor.gui.panel.PanelTranslucido();
        imagen1 = new org.edisoncor.gui.panel.PanelImage();
        Menu = new javax.swing.JPanel();
        btn_reportes = new javax.swing.JButton();
        gestion_de_componentes1 = new javax.swing.JButton();
        btn_control_operadores = new javax.swing.JButton();

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Operación");

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-up.png"))); // NOI18N
        jButton5.setBorder(null);
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-press.png"))); // NOI18N
        jButton5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-over.png"))); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("<html>Reportes<br>de Errores<html>");
        jLabel15.setFocusable(false);

        repor_errores1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-up.png"))); // NOI18N
        repor_errores1.setBorder(null);
        repor_errores1.setBorderPainted(false);
        repor_errores1.setContentAreaFilled(false);
        repor_errores1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-press.png"))); // NOI18N
        repor_errores1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-over.png"))); // NOI18N
        repor_errores1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repor_errores1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        primario.setOpaque(false);

        tabbedPaneHeader1.setBackground(new java.awt.Color(255, 255, 255));
        tabbedPaneHeader1.setColorDeBorde(new java.awt.Color(255, 255, 255));

        ControlPer.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(219, 237, 223), new java.awt.Color(133, 178, 163)));
        ControlPer.setColorPrimario(new java.awt.Color(219, 237, 223));
        ControlPer.setColorSecundario(new java.awt.Color(133, 178, 163));

        imagen1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVentanas/icono-pantalla.png"))); // NOI18N

        javax.swing.GroupLayout imagen1Layout = new javax.swing.GroupLayout(imagen1);
        imagen1.setLayout(imagen1Layout);
        imagen1Layout.setHorizontalGroup(
            imagen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 55, Short.MAX_VALUE)
        );
        imagen1Layout.setVerticalGroup(
            imagen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 57, Short.MAX_VALUE)
        );

        Menu.setOpaque(false);

        btn_reportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/errores-normal.png"))); // NOI18N
        btn_reportes.setBorder(null);
        btn_reportes.setBorderPainted(false);
        btn_reportes.setContentAreaFilled(false);
        btn_reportes.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/errores-press.png"))); // NOI18N
        btn_reportes.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/errores-over.png"))); // NOI18N
        btn_reportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reportesActionPerformed(evt);
            }
        });

        gestion_de_componentes1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/indicadores-normal.png"))); // NOI18N
        gestion_de_componentes1.setBorder(null);
        gestion_de_componentes1.setBorderPainted(false);
        gestion_de_componentes1.setContentAreaFilled(false);
        gestion_de_componentes1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/indicadores-press.png"))); // NOI18N
        gestion_de_componentes1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/indicadores-over.png"))); // NOI18N
        gestion_de_componentes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestion_de_componentes1ActionPerformed(evt);
            }
        });

        btn_control_operadores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/produccion-normal.png"))); // NOI18N
        btn_control_operadores.setBorder(null);
        btn_control_operadores.setBorderPainted(false);
        btn_control_operadores.setContentAreaFilled(false);
        btn_control_operadores.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/produccion-press.png"))); // NOI18N
        btn_control_operadores.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/produccion-over.png"))); // NOI18N
        btn_control_operadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_control_operadoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_control_operadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_reportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gestion_de_componentes1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_control_operadores)
                .addGap(4, 4, 4)
                .addComponent(btn_reportes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gestion_de_componentes1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ControlPerLayout = new javax.swing.GroupLayout(ControlPer);
        ControlPer.setLayout(ControlPerLayout);
        ControlPerLayout.setHorizontalGroup(
            ControlPerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ControlPerLayout.createSequentialGroup()
                .addGap(0, 1125, Short.MAX_VALUE)
                .addComponent(imagen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(ControlPerLayout.createSequentialGroup()
                .addGap(433, 433, 433)
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ControlPerLayout.setVerticalGroup(
            ControlPerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ControlPerLayout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addComponent(imagen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tabbedPaneHeader1.addTab("Menú-Reportes", ControlPer);

        javax.swing.GroupLayout primarioLayout = new javax.swing.GroupLayout(primario);
        primario.setLayout(primarioLayout);
        primarioLayout.setHorizontalGroup(
            primarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(primarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPaneHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        primarioLayout.setVerticalGroup(
            primarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, primarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPaneHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(primario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(primario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void repor_errores1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repor_errores1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repor_errores1ActionPerformed

    private void btn_reportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reportesActionPerformed
       //  navegacion.openReportesErrores();
    }//GEN-LAST:event_btn_reportesActionPerformed

    private void gestion_de_componentes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestion_de_componentes1ActionPerformed
        // navegacion.openReportesDesempeño();
    }//GEN-LAST:event_gestion_de_componentes1ActionPerformed

    private void btn_control_operadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_control_operadoresActionPerformed
      dispose();
       // navegacion.openReportesProduccion();
       
    }//GEN-LAST:event_btn_control_operadoresActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.panel.PanelTranslucido ControlPer;
    private javax.swing.JPanel Menu;
    private javax.swing.JButton btn_control_operadores;
    private javax.swing.JButton btn_reportes;
    private javax.swing.JButton gestion_de_componentes1;
    private org.edisoncor.gui.panel.PanelImage imagen1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel primario;
    private javax.swing.JButton repor_errores1;
    private org.edisoncor.gui.tabbedPane.TabbedPaneHeader tabbedPaneHeader1;
    // End of variables declaration//GEN-END:variables
}
