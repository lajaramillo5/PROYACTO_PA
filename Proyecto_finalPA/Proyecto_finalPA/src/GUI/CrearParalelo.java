/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BL.BLParalelo;
import clases.Paralelo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alexis Montoya
 */
public class CrearParalelo extends javax.swing.JFrame {

    BLParalelo blparalelo = new BLParalelo();
    Paralelo paraleo = new Paralelo();

    public CrearParalelo() throws ClassNotFoundException, SQLException {
        initComponents();
        ListarParalelos();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextparaaleo = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Crear Paralelo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nombre Paralelo:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Seleccione un paralelo: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, -1, -1));

        jTextparaaleo.setBackground(new java.awt.Color(0, 0, 0));
        jTextparaaleo.setForeground(new java.awt.Color(255, 255, 255));
        jTextparaaleo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextparaaleoKeyTyped(evt);
            }
        });
        getContentPane().add(jTextparaaleo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 130, -1));

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, -1, -1));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 280, 90));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton4.setBackground(new java.awt.Color(102, 102, 102));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton4.setText("Cargar Paralelos");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);

        jButton2.setBackground(new java.awt.Color(102, 102, 102));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setText("Limpiar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jButton3.setBackground(new java.awt.Color(102, 102, 102));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton3.setText("Volver");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);

        jButton5.setBackground(new java.awt.Color(102, 102, 102));
        jButton5.setText("Eliminarar");
        jButton5.setEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 440, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents
 public void ListarDatos() throws ClassNotFoundException, SQLException {
        //Como el método de la BL retorna un ArrayList de la clase Estudiantes
        //Aqui lo recuperamos

        ArrayList<Paralelo> lstparalelo = blparalelo.ConsultaLista();

        Object columnas[] = {"nombres"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        jTable1.setModel(modelo);

        for (Paralelo objeto : lstparalelo) {
            //String id=String.valueOf(objeto.getStrCodigo());
            String nombres = objeto.getNombre();
            String modeloTemp[] = {nombres};
            modelo.addRow(modeloTemp);
        }

    }

    private void limpiar() {
        this.jTextparaaleo.setText("");

    }

    public boolean validar() {
        if (jTextparaaleo.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "campo de texto del nombre del paralelo esta vacio", "docentes", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        try {
            return true;
        } catch (NullPointerException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "algun dato esta con el formato incorrecto", "docentes", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }

    }

    private void crearParalelo() throws ClassNotFoundException, SQLException {

        if (validar()) {

            paraleo.setNombre(this.jTextparaaleo.getText());

            if (blparalelo.Consultar(paraleo)) {
                boolean creado = blparalelo.RegistrarParalelo(paraleo);
                if (creado) {
                    limpiar();
                    this.ListarDatos();
                    JOptionPane.showMessageDialog(this, "Se creo el paralelo", "Crear paralelo", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo Crear el paralelo", "crear paralelo", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "El paralelo ya existe", "Crear paralelo", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private void eliminarParalelo() throws SQLException, ClassNotFoundException {

        int id = this.jComboBox2.getSelectedIndex();
        paraleo.setIdPar(id);
        blparalelo.Eliminar(paraleo);

        JOptionPane.showMessageDialog(this, "se elimino el paralelo", "paralelo", JOptionPane.INFORMATION_MESSAGE);

        this.ListarDatos();
        limpiar();

    }

    public void ListarParalelos() throws ClassNotFoundException, SQLException {
        ArrayList<Paralelo> lstProvincias = new ArrayList<>();

        lstProvincias = blparalelo.ConsultaLista();
        DefaultComboBoxModel dlm = new DefaultComboBoxModel();
        Paralelo objp = new Paralelo("Seleccione");
        dlm.addElement(objp);
        for (Paralelo p : lstProvincias) {
            dlm.addElement(p);
        }
        this.jComboBox2.setModel(dlm);
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            crearParalelo();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CrearGrado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CrearGrado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        GUISecretaria secre = new GUISecretaria();
        secre.setEnabled(true);
        secre.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            // TODO add your handling code here:
            eliminarParalelo();
        } catch (SQLException ex) {
            Logger.getLogger(CrearParalelo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CrearParalelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        this.jButton5.setEnabled(true);
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jTextparaaleoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextparaaleoKeyTyped
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
    }//GEN-LAST:event_jTextparaaleoKeyTyped

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            // TODO add your handling code here:
            ListarDatos();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CrearParalelo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CrearParalelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(CrearParalelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearParalelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearParalelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearParalelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new CrearParalelo().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CrearParalelo.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(CrearParalelo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextparaaleo;
    // End of variables declaration//GEN-END:variables
}