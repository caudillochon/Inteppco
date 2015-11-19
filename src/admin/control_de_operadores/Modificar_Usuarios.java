/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package admin.control_de_operadores;

import DB.Modelos.ContactoEmergencia;
import DB.Modelos.Personal;
import DB.Modelos.Usuario;
import DB.Tables.ContactoEmergenciaT;
import DB.Tables.PersonalT;
import DB.Tables.UsuarioT;
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
public class Modificar_Usuarios extends javax.swing.JFrame {
    public Navegacion navegacion;
    int personal_id=-1;
    int Usuario_id=-1;
    String Pass;
    /**
     * Creates new form accseso
     */
    public Modificar_Usuarios(Navegacion navegacion,Usuario user) {
        this.navegacion=navegacion;
        initComponents();
        setLocationRelativeTo(null); //se elije en que parte de la pantalla aparecera null (centro)
    
        setResizable(false);//evitamos que la pantalla se modifique.
        this.setTitle("Registrar Operadores-Inteppco");//titulo a la pantalla.
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/logo_1.png")).getImage());
        try{
        BufferedImage imagen =ImageIO.read(Registrar_Operador.class.getResourceAsStream("/imagenes/fondo.png"));;
        Control_fondo.
        BgBorder borde = new Control_fondo.BgBorder(imagen) ;            
       jPanel4.setBorder(borde);}
       catch(IOException io){           
       }
        Tusuario.setText(user.user);
        Trol.setSelectedIndex(user.rol);
        Tactivo.setSelectedIndex(user.activo);
        Personal Datos= (new PersonalT()).persona(user.Personal_id);
        Tnombre.setText(Datos.nombre);
        Temail.setText(Datos.correo);
        Tseguro.setText(Datos.seguroSocial+"");
        Ttelefono.setText(Datos.telefono+"");
        Tdirreccion.setText(Datos.direccion+"");
        Tlugarnac.setText(Datos.lugarnaciemiento);
        Tfechanac.setDate(Datos.fechanacimeinto);
        ContactoEmergencia Contacto=(new ContactoEmergenciaT()).Contacto(user.Personal_id);
        tnombrecontacto.setText(Contacto.nombre);
        Temailcontacto.setText(Contacto.correo);
        Ttelefonocontacto.setText(Contacto.telefono+"");
        Tdirrecconcontacto.setText(Contacto.direccion);
        personal_id=Datos.id;
        Usuario_id=user.id;
        Pass=user.password;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Tnombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Tseguro = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Tlugarnac = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Ttelefono = new javax.swing.JFormattedTextField();
        Tdirreccion = new javax.swing.JTextField();
        Tfechanac = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        Temail = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tnombrecontacto = new javax.swing.JTextField();
        Tdirrecconcontacto = new javax.swing.JTextField();
        Temailcontacto = new javax.swing.JTextField();
        Ttelefonocontacto = new javax.swing.JFormattedTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        Tusuario = new javax.swing.JTextField();
        Tcontraseña1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        Tcontraseña2 = new javax.swing.JTextField();
        Trol = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        Tactivo = new javax.swing.JComboBox();

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAutoRequestFocus(false);
        setResizable(false);

        jPanel4.setAutoscrolls(true);

        jPanel7.setAutoscrolls(true);
        jPanel7.setOpaque(false);

        jPanel1.setAutoscrolls(true);
        jPanel1.setOpaque(false);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setText("Modificar Usuario ");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registrar_o.png"))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(105, 183, 158)), "Captura de Datos.", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel2.setOpaque(false);

        Tnombre.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(105, 183, 158)));
        Tnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TnombreActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre:");

        jLabel10.setText("Fecha de Nacimiento:");

        jLabel7.setText("No. de Seguro.");

        Tseguro.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(105, 183, 158)));

        jLabel4.setText("Telefono:");

        Tlugarnac.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(105, 183, 158)));
        Tlugarnac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TlugarnacActionPerformed(evt);
            }
        });

        jLabel5.setText("Dirección:");

        jLabel9.setText("Lugar de Nacimiento:");

        Ttelefono.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(105, 183, 158)));
        try {
            Ttelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        Ttelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TtelefonoActionPerformed(evt);
            }
        });

        Tdirreccion.setText(" ");
        Tdirreccion.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(105, 183, 158)));
        Tdirreccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TdirreccionActionPerformed(evt);
            }
        });

        jLabel17.setText("Email:");

        Temail.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(105, 183, 158)));
        Temail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TemailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Tfechanac, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9)
                            .addComponent(jLabel17))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Tlugarnac, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Ttelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                            .addComponent(Tseguro)
                            .addComponent(Tnombre)
                            .addComponent(Tdirreccion)
                            .addComponent(Temail))))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2)
                    .addContainerGap(458, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Tnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(Temail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(Tseguro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Ttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Tdirreccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(Tlugarnac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(Tfechanac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2)
                    .addContainerGap(172, Short.MAX_VALUE)))
        );

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(105, 183, 158)), "Contacto en Caso de Emergencia.", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel3.setOpaque(false);

        jLabel3.setText("Nombre:");

        jLabel8.setText("Telefono:");

        jLabel12.setText("Email(Opcional):");

        jLabel14.setText("Dirección:");

        tnombrecontacto.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(105, 183, 158)));
        tnombrecontacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnombrecontactoActionPerformed(evt);
            }
        });

        Tdirrecconcontacto.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(105, 183, 158)));
        Tdirrecconcontacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TdirrecconcontactoActionPerformed(evt);
            }
        });

        Temailcontacto.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(105, 183, 158)));
        Temailcontacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TemailcontactoActionPerformed(evt);
            }
        });

        Ttelefonocontacto.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(105, 183, 158)));
        try {
            Ttelefonocontacto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        Ttelefonocontacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TtelefonocontactoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3)
                    .addComponent(jLabel14)
                    .addComponent(jLabel12))
                .addGap(51, 51, 51)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Ttelefonocontacto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Tdirrecconcontacto)
                        .addComponent(Temailcontacto, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tnombrecontacto, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tnombrecontacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(Ttelefonocontacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tdirrecconcontacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Temailcontacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(105, 183, 158)), "Contacto en Caso de Emergencia.", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel6.setOpaque(false);

        jLabel6.setText("Usuario");

        Tusuario.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(105, 183, 158)));
        Tusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TusuarioActionPerformed(evt);
            }
        });

        Tcontraseña1.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(105, 183, 158)));
        Tcontraseña1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tcontraseña1ActionPerformed(evt);
            }
        });

        jLabel13.setText("Contraseña");

        jLabel15.setText("Rol");

        Tcontraseña2.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(105, 183, 158)));
        Tcontraseña2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tcontraseña2ActionPerformed(evt);
            }
        });

        Trol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Rol", "Admin", "Personal" }));

        jLabel16.setText("Estatus");

        Tactivo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Inactivo", "Activo" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(Trol, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Tactivo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Tusuario)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(Tcontraseña1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                .addComponent(Tcontraseña2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(88, 88, 88))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Tusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(Tcontraseña1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tcontraseña2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Trol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16)
                        .addComponent(Tactivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(jLabel11)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tnombrecontactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnombrecontactoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnombrecontactoActionPerformed

    private void TdirrecconcontactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TdirrecconcontactoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TdirrecconcontactoActionPerformed

    private void TemailcontactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TemailcontactoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TemailcontactoActionPerformed

    private void TtelefonocontactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TtelefonocontactoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TtelefonocontactoActionPerformed

    private void TdirreccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TdirreccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TdirreccionActionPerformed

    private void TtelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TtelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TtelefonoActionPerformed

    private void TlugarnacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TlugarnacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TlugarnacActionPerformed

    private void TnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TnombreActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        UsuarioT Update=new UsuarioT();
        Usuario usuario=new Usuario(Tusuario.getText(),Update.sha1(Tcontraseña1.getText()),Update.sha1(Tcontraseña2.getText()),
        Trol.getSelectedIndex(),Tactivo.getSelectedIndex());
        usuario.id=Usuario_id;
        Personal personal=new Personal();
        personal.id=personal_id;
        personal.nombre=Tnombre.getText();
        personal.correo=Temail.getText();
        personal.direccion=Tdirreccion.getText();
        personal.lugarnaciemiento=Tlugarnac.getText();
        personal.fechanacimeinto=Tfechanac.getDate();
        personal.puesto_id=1;
        personal.seguroSocial=Tseguro.getText();
        personal.telefono=Long.parseLong("0"+(Ttelefono.getText().replace("-", "")).trim());
        ContactoEmergencia contacto=new ContactoEmergencia();
        contacto.id_personal=personal_id;
        contacto.nombre=tnombrecontacto.getText()+"";
        contacto.correo=Temailcontacto.getText();
        contacto.telefono=Long.parseLong("0"+(Ttelefonocontacto.getText().replace("-", "")).trim());
        contacto.direccion=Tdirrecconcontacto.getText();
        if(Tcontraseña1.getText().isEmpty()&Tcontraseña2.getText().isEmpty()){
            usuario.password=Pass;
            usuario.password_repeat=Pass;
        }
        
        Update.Update(usuario, personal, contacto);
        if(Update.usuario!=null){
        dispose();}
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TemailActionPerformed

    private void Tcontraseña2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tcontraseña2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tcontraseña2ActionPerformed

    private void Tcontraseña1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tcontraseña1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tcontraseña1ActionPerformed

    private void TusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TusuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TusuarioActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Tactivo;
    private javax.swing.JTextField Tcontraseña1;
    private javax.swing.JTextField Tcontraseña2;
    private javax.swing.JTextField Tdirreccion;
    private javax.swing.JTextField Tdirrecconcontacto;
    private javax.swing.JTextField Temail;
    private javax.swing.JTextField Temailcontacto;
    private com.toedter.calendar.JDateChooser Tfechanac;
    private javax.swing.JTextField Tlugarnac;
    private javax.swing.JTextField Tnombre;
    private javax.swing.JComboBox Trol;
    private javax.swing.JTextField Tseguro;
    private javax.swing.JFormattedTextField Ttelefono;
    private javax.swing.JFormattedTextField Ttelefonocontacto;
    private javax.swing.JTextField Tusuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTextField tnombrecontacto;
    // End of variables declaration//GEN-END:variables
}