/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package operador.reportes;

import operador.*;
import operador.mi_perfil.menu_perfil;
import admin.control_de_operadores.Registrar_Operador;
import inicio.de.sesion.Acceso;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Luis
 */
public class menu_reportes extends javax.swing.JFrame {

    /**
     * Creates new form accseso
     */
    public menu_reportes() {
        initComponents();
        initradiobutton();
    setLocationRelativeTo(null); //se elije en que parte de la pantalla aparecera null (centro)
        setResizable(false);//evitamos que la pantalla se modifique.
        this.setTitle("Menu Reportes-Inteppco");//titulo a la pantalla.
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/logo_1.png")).getImage());
         try{
        BufferedImage imagen =ImageIO.read(Registrar_Operador.class.getResourceAsStream("/imagenes/fondo.png"));;
        Control_fondo.
        BgBorder borde = new Control_fondo.BgBorder(imagen) ;            
      jPanel1.setBorder(borde);}
       catch(IOException io){
           
       }
        
//        
//        //para colocar el fondo de jframe.
//       ((JPanel)getContentPane()).setOpaque(fal­se);
//         ImageIcon uno=new ImageIcon(this.getClass().getResource("/imagenes/fondo_ope.png"));
//         JLabel fondo= new JLabel(); 
//         fondo.setIcon(uno); 
//         getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
//         fondo.setBounds(0,0,uno.getIconWidth(),u­no.getIconHeight());
//         //para colocar el fondo de jframe.
//       
        
    }

    public void initradiobutton(){
        final int x=16;
        final int y=16;
        
        final Thread hilo = new Thread() {

            public void run() {
                while (true) {
                    URL oracle;
                    try {
                        String url="http://10.10.10.2/http_in_010000.htm";
                                   // "http://localhost/inteppco/input.html";
                        oracle = new URL(url);

                        BufferedReader in = new BufferedReader(
                                new InputStreamReader(oracle.openStream()));

                        String inputLine;
                        int x = 0;
                        //columna
                        for (int i = 0; i < 12; i++) {
                            inputLine = in.readLine();
                        }
                        
                        //fila
                        for (int i = 0; i < 1; i++) {
                            inputLine = in.readLine();
                            inputLine = inputLine.replaceAll(" ", "").split("=")[2];
                            try {   
                                if(inputLine.charAt(15)=='0'){
                                    uno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/2.png")));
                                }else{
                                    uno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/4.png")));
                                }
                                if(inputLine.charAt(14)=='0'){
                                    dos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/2.png")));
                                }else{
                                    dos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/4.png")));
                                }
                                if(inputLine.charAt(13)=='0'){
                                    tres.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/2.png")));
                                }else{
                                    tres.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/4.png")));
                                }
                                if(inputLine.charAt(12)=='0'){
                                    cuatro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/2.png")));
                                }else{
                                    cuatro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/4.png")));
                                }
                            }catch(Exception e){
                                System.out.println(e+inputLine);
                            }
                            
                        }
                        System.out.println("\n");

                        in.close();
                    } catch (MalformedURLException ex) {
//                        Logger.getLogger(prueba.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException e) {

                    }
                    try {
                    Thread.sleep(100);
                } catch (final InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                }
            }
        };
        
        hilo.start();
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
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        cuatro = new javax.swing.JLabel();
        tres = new javax.swing.JLabel();
        dos = new javax.swing.JLabel();
        uno = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btn_operacion = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        btn_reportes = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        btn_mi_perfil = new javax.swing.JButton();

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Operación");

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-up.png"))); // NOI18N
        jButton5.setBorder(null);
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-press.png"))); // NOI18N
        jButton5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-over.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setText("Cerrar Sesión");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        cuatro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1.png"))); // NOI18N
        jPanel1.add(cuatro, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 110, -1, -1));

        tres.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        tres.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1.png"))); // NOI18N
        tres.setToolTipText("");
        jPanel1.add(tres, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, 30, -1));

        dos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1.png"))); // NOI18N
        jPanel1.add(dos, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, -1, -1));

        uno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1.png"))); // NOI18N
        jPanel1.add(uno, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setText("Menú-Reportes");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(105, 183, 158)));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 790, 378));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(105, 183, 158)));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("<html>Reporte<br>Estadistico</html>");
        jLabel5.setFocusable(false);
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 100, 40));

        btn_operacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-up.png"))); // NOI18N
        btn_operacion.setBorder(null);
        btn_operacion.setBorderPainted(false);
        btn_operacion.setContentAreaFilled(false);
        btn_operacion.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-press.png"))); // NOI18N
        btn_operacion.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-over.png"))); // NOI18N
        btn_operacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_operacionActionPerformed(evt);
            }
        });
        jPanel2.add(btn_operacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("<html>Reporte<br>de Error</hmtl>");
        jLabel10.setFocusable(false);
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, 90, 40));

        btn_reportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-up.png"))); // NOI18N
        btn_reportes.setBorder(null);
        btn_reportes.setBorderPainted(false);
        btn_reportes.setContentAreaFilled(false);
        btn_reportes.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-press.png"))); // NOI18N
        btn_reportes.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-over.png"))); // NOI18N
        btn_reportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reportesActionPerformed(evt);
            }
        });
        jPanel2.add(btn_reportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("<html>Reporte<br>de Producción</html>");
        jLabel15.setFocusable(false);
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 90, 40));

        btn_mi_perfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-up.png"))); // NOI18N
        btn_mi_perfil.setBorder(null);
        btn_mi_perfil.setBorderPainted(false);
        btn_mi_perfil.setContentAreaFilled(false);
        btn_mi_perfil.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-press.png"))); // NOI18N
        btn_mi_perfil.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-over.png"))); // NOI18N
        btn_mi_perfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mi_perfilActionPerformed(evt);
            }
        });
        jPanel2.add(btn_mi_perfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 790, 70));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       Acceso link = new Acceso();
        link.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_operacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_operacionActionPerformed
        reporte_estadistic link = new reporte_estadistic();
        link.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_operacionActionPerformed

    private void btn_reportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reportesActionPerformed
        operador.reportes.reporte_errores link = new reporte_errores();
        link.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_reportesActionPerformed

    private void btn_mi_perfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mi_perfilActionPerformed
        operador.reportes.reporte_produccion link = new reporte_produccion();
        link.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_mi_perfilActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu_reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new menu_reportes().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_mi_perfil;
    private javax.swing.JButton btn_operacion;
    private javax.swing.JButton btn_reportes;
    private javax.swing.JLabel cuatro;
    private javax.swing.JLabel dos;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel tres;
    private javax.swing.JLabel uno;
    // End of variables declaration//GEN-END:variables
}
