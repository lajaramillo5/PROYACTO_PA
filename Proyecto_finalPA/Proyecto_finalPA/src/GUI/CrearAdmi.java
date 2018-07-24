/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BL.BLAdmi;
import BL.BLUsuario;
import BL.Expresiones;
import clases.Secretaria;
import clases.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lenovo
 */
public class CrearAdmi extends javax.swing.JFrame {

    BLAdmi blsecre = new BLAdmi();
    Secretaria secre = new Secretaria();
    BLUsuario user = new BLUsuario();
    Usuario userai = new Usuario();
    Expresiones expre = new Expresiones();

    public CrearAdmi() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabelNombreDocente = new javax.swing.JLabel();
        jTextnombre = new javax.swing.JTextField();
        jLabelTelefonoDocente = new javax.swing.JLabel();
        jTextFieldTelefonoDocente = new javax.swing.JTextField();
        jTextdireccion = new javax.swing.JTextField();
        jLabelRhDocente = new javax.swing.JLabel();
        jLabelCCTIDocente = new javax.swing.JLabel();
        jTextCedula = new javax.swing.JTextField();
        jLabelApellidoDocente = new javax.swing.JLabel();
        jTextFieldApellidoDocente = new javax.swing.JTextField();
        jLabelAsignatura2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextCorreo = new javax.swing.JTextField();
        jTextCEDULAE = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButtonLimpiarDocente = new javax.swing.JButton();
        jButtonAceptarDocente = new javax.swing.JButton();
        jButtonVolverDocente = new javax.swing.JButton();
        jButtonEliminarDocente = new javax.swing.JButton();
        jButtonModificarDocente = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("CREAR ADMINISTRADOR");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, -1, -1));

        jLabelNombreDocente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNombreDocente.setText("Nombre:");
        getContentPane().add(jLabelNombreDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 20));

        jTextnombre.setBackground(new java.awt.Color(0, 0, 0));
        jTextnombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextnombre.setForeground(new java.awt.Color(255, 255, 255));
        jTextnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextnombreKeyTyped(evt);
            }
        });
        getContentPane().add(jTextnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 140, -1));

        jLabelTelefonoDocente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTelefonoDocente.setText("Telefono:");
        getContentPane().add(jLabelTelefonoDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        jTextFieldTelefonoDocente.setBackground(new java.awt.Color(0, 0, 0));
        jTextFieldTelefonoDocente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextFieldTelefonoDocente.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldTelefonoDocente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTelefonoDocenteKeyTyped(evt);
            }
        });
        getContentPane().add(jTextFieldTelefonoDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 70, -1));

        jTextdireccion.setBackground(new java.awt.Color(0, 0, 0));
        jTextdireccion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextdireccion.setForeground(new java.awt.Color(255, 255, 255));
        jTextdireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextdireccionKeyTyped(evt);
            }
        });
        getContentPane().add(jTextdireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 140, -1));

        jLabelRhDocente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelRhDocente.setText("Direccion:");
        getContentPane().add(jLabelRhDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        jLabelCCTIDocente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelCCTIDocente.setText("Cedula:");
        getContentPane().add(jLabelCCTIDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jTextCedula.setBackground(new java.awt.Color(0, 0, 0));
        jTextCedula.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextCedula.setForeground(new java.awt.Color(255, 255, 255));
        jTextCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextCedulaKeyTyped(evt);
            }
        });
        getContentPane().add(jTextCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 80, -1));

        jLabelApellidoDocente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelApellidoDocente.setText("Apellido:");
        getContentPane().add(jLabelApellidoDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, 20));

        jTextFieldApellidoDocente.setBackground(new java.awt.Color(0, 0, 0));
        jTextFieldApellidoDocente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextFieldApellidoDocente.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldApellidoDocente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldApellidoDocenteKeyTyped(evt);
            }
        });
        getContentPane().add(jTextFieldApellidoDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 140, -1));

        jLabelAsignatura2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelAsignatura2.setText("Seleccione un admin :");
        getContentPane().add(jLabelAsignatura2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 150, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Correo:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, 20));

        jTextCorreo.setBackground(new java.awt.Color(0, 0, 0));
        jTextCorreo.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTextCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 140, -1));

        jTextCEDULAE.setBackground(new java.awt.Color(0, 0, 0));
        jTextCEDULAE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextCEDULAEKeyTyped(evt);
            }
        });
        getContentPane().add(jTextCEDULAE, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, 140, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Edad");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, 20));

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(18, 18, 80, 1));
        getContentPane().add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 260, 150));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonLimpiarDocente.setBackground(new java.awt.Color(102, 102, 102));
        jButtonLimpiarDocente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonLimpiarDocente.setText("Limpiar");
        jButtonLimpiarDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarDocenteActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonLimpiarDocente);

        jButtonAceptarDocente.setBackground(new java.awt.Color(102, 102, 102));
        jButtonAceptarDocente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonAceptarDocente.setText("Guardar");
        jButtonAceptarDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarDocenteActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAceptarDocente);

        jButtonVolverDocente.setBackground(new java.awt.Color(102, 102, 102));
        jButtonVolverDocente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonVolverDocente.setText("Volver");
        jButtonVolverDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverDocenteActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonVolverDocente);

        jButtonEliminarDocente.setBackground(new java.awt.Color(102, 102, 102));
        jButtonEliminarDocente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonEliminarDocente.setText("Eliminar Admi");
        jButtonEliminarDocente.setEnabled(false);
        jButtonEliminarDocente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonEliminarDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarDocenteActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonEliminarDocente);

        jButtonModificarDocente.setBackground(new java.awt.Color(102, 102, 102));
        jButtonModificarDocente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonModificarDocente.setText("Salir");
        jButtonModificarDocente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonModificarDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarDocenteActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonModificarDocente);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 400, 50));

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 240, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
private void habilitarComponentes() {
        jButtonEliminarDocente.setEnabled(false);
        jButtonModificarDocente.setEnabled(false);
        jButtonAceptarDocente.setEnabled(true);
        jButtonLimpiarDocente.setEnabled(true);

    }

    private void limpiar() {
        this.jTextnombre.setText("");
        this.jTextFieldApellidoDocente.setText("");
        this.jTextFieldTelefonoDocente.setText("");
        this.jTextdireccion.setText("");
        this.jTextCedula.setText("");
        this.jTextCorreo.setText("");

        habilitarComponentes();
    }

    public boolean validar() {
        if (jTextnombre.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "campo de texto del nombre del admin esta vacio", "docentes", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else if (jTextFieldApellidoDocente.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "campo de texto del apellido del admin esta vacio", "docentes", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else if (this.jTextCorreo.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "campo de texto del codigo del carnet del admin esta vacio", "docentes", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else if (jTextCedula.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "campo de texto del documento del admin esta vacio", "docentes", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else if (jTextFieldTelefonoDocente.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "campo de texto del telefono del admin esta vacio", "docentes", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else if (jTextdireccion.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "campo de texto del direccion del admin esta vacio", "docentes", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else {
            try {
                Integer.parseInt(jTextCedula.getText());
                return true;
            } catch (NullPointerException | NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "algun dato esta con el formato incorrecto", "admin", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }

        }
    }

    private void crearAdmi() throws ClassNotFoundException, SQLException {
        boolean creado = false;
        if (validar()) {
            secre.setEdad((int) this.jSpinner1.getValue());
            secre.setCedula(String.valueOf(jTextCedula.getText()));
            secre.setTelefono(String.valueOf(jTextFieldTelefonoDocente.getText()));
            secre.setNombre(jTextnombre.getText());
            secre.setApellido(jTextFieldApellidoDocente.getText());
            secre.setDireccion(jTextdireccion.getText());
            secre.setCorreo(jTextCorreo.getText());
            System.out.println(secre);

            if (blsecre.Consultar(secre)) {
                if (expre.calle(jTextdireccion.getText()) && expre.NumeroTelefono(jTextFieldTelefonoDocente.getText()) && expre.mailValido(jTextCorreo.getText())) {
                    creado = blsecre.RegistrarAdmi(secre);
                    userai.setUser(this.jTextnombre.getText() + (int) this.jSpinner1.getValue());
                    userai.setPassword(jTextCedula.getText());
                    userai.setRoll(3);
                    user.RegistrarUsuario(userai);

                } else {
                    JOptionPane.showMessageDialog(this, "algunos dats son incorectos", "Crear admin", JOptionPane.INFORMATION_MESSAGE);
                    limpiar();
                }
                if (creado) {
                    limpiar();

                    JOptionPane.showMessageDialog(this, "Se creo el Admi", "Crear admin", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo Crear el Admi", "crear admin", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                jTextCedula.setText("");
                jTextCedula.requestFocus();
                JOptionPane.showMessageDialog(this, "El Admi ya existe", "Crear docente", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private void eliminarAdmin() throws SQLException, ClassNotFoundException {

        String cedula = this.jTextCEDULAE.getText();
        secre.setCedula(cedula);
        if (blsecre.Consultar(secre)) {
            blsecre.Eliminar(secre);
            JOptionPane.showMessageDialog(this, "se elimino el Administrador", "Administrador", JOptionPane.INFORMATION_MESSAGE);
            habilitarComponentes();
            limpiar();
        }

    }


    private void jButtonAceptarDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarDocenteActionPerformed

        try {
            crearAdmi();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CrearAdmi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CrearAdmi.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButtonAceptarDocenteActionPerformed

    private void jButtonLimpiarDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarDocenteActionPerformed
        limpiar();
        jTextCedula.setEditable(true);
    }//GEN-LAST:event_jButtonLimpiarDocenteActionPerformed

    private void jButtonVolverDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverDocenteActionPerformed
        limpiar();
        jTextCedula.setEditable(true);
        GUISecretaria secre = new GUISecretaria();
        secre.setEnabled(true);
        secre.setVisible(true);
        dispose();

    }//GEN-LAST:event_jButtonVolverDocenteActionPerformed

    private void jButtonModificarDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarDocenteActionPerformed

        limpiar();
        jTextCedula.setEditable(true);
        InicioSecion ini = new InicioSecion();
        ini.setEnabled(true);
        ini.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonModificarDocenteActionPerformed

    private void jButtonEliminarDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarDocenteActionPerformed
        try {
            eliminarAdmin();
        } catch (SQLException ex) {
            Logger.getLogger(CrearDocente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CrearDocente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonEliminarDocenteActionPerformed

    private void jTextCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCedulaKeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "ingrese solo numeros");
        }
    }//GEN-LAST:event_jTextCedulaKeyTyped

    private void jTextFieldTelefonoDocenteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTelefonoDocenteKeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "ingrese solo numeros");
        }
    }//GEN-LAST:event_jTextFieldTelefonoDocenteKeyTyped

    private void jTextnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextnombreKeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();
        if (Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "ingrese solo letras");
        }
        if (Character.isLowerCase(validar)) {
            String cad = ("" + validar).toUpperCase();
            validar = cad.charAt(0);
            evt.setKeyChar(validar);
        }
    }//GEN-LAST:event_jTextnombreKeyTyped

    private void jTextFieldApellidoDocenteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldApellidoDocenteKeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();
        if (Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "ingrese solo letras");
        }
        if (Character.isLowerCase(validar)) {
            String cad = ("" + validar).toUpperCase();
            validar = cad.charAt(0);
            evt.setKeyChar(validar);
        }
    }//GEN-LAST:event_jTextFieldApellidoDocenteKeyTyped

    private void jTextdireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextdireccionKeyTyped

    }//GEN-LAST:event_jTextdireccionKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.jButtonEliminarDocente.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextCEDULAEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCEDULAEKeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "ingrese CEDULA a eliminar");
        }
    }//GEN-LAST:event_jTextCEDULAEKeyTyped

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CrearAdmi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearAdmi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearAdmi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearAdmi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearAdmi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAceptarDocente;
    private javax.swing.JButton jButtonEliminarDocente;
    private javax.swing.JButton jButtonLimpiarDocente;
    private javax.swing.JButton jButtonModificarDocente;
    private javax.swing.JButton jButtonVolverDocente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelApellidoDocente;
    private javax.swing.JLabel jLabelAsignatura2;
    private javax.swing.JLabel jLabelCCTIDocente;
    private javax.swing.JLabel jLabelNombreDocente;
    private javax.swing.JLabel jLabelRhDocente;
    private javax.swing.JLabel jLabelTelefonoDocente;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextCEDULAE;
    private javax.swing.JTextField jTextCedula;
    private javax.swing.JTextField jTextCorreo;
    private javax.swing.JTextField jTextFieldApellidoDocente;
    private javax.swing.JTextField jTextFieldTelefonoDocente;
    private javax.swing.JTextField jTextdireccion;
    private javax.swing.JTextField jTextnombre;
    // End of variables declaration//GEN-END:variables
}