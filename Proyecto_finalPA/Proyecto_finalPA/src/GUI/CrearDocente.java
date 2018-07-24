/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BL.BLDocente;
import BL.BLUsuario;
import BL.Expresiones;
import clases.Docente;
import clases.Grado;
import clases.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lenovo
 */
public class CrearDocente extends javax.swing.JFrame {

    BLDocente bldocente = new BLDocente();
    Docente docent = new Docente();
    Expresiones expre =new Expresiones();

    public CrearDocente() {
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
        jTextFieldNombreDocente = new javax.swing.JTextField();
        jLabelTelefonoDocente = new javax.swing.JLabel();
        jTextFieldTelefonoDocente = new javax.swing.JTextField();
        jTextFieldRHDocente = new javax.swing.JTextField();
        jLabelRhDocente = new javax.swing.JLabel();
        jLabelCCTIDocente = new javax.swing.JLabel();
        jTextFieldTICC = new javax.swing.JTextField();
        jLabelEdadDocente = new javax.swing.JLabel();
        jLabelApellidoDocente = new javax.swing.JLabel();
        jTextFieldApellidoDocente = new javax.swing.JTextField();
        jLabelAsignatura2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextCorreo = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextDocente = new javax.swing.JTextField();
        jSpinner1 = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        jButtonAceptarDocente = new javax.swing.JButton();
        jButtonLimpiarDocente = new javax.swing.JButton();
        jButtonVolverDocente = new javax.swing.JButton();
        jButtonCargarDocente = new javax.swing.JButton();
        jButtonModificardocente = new javax.swing.JButton();
        jButtonEliminarDocente = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTexteditdirec = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("CREAR DOCENTE");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

        jLabelNombreDocente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNombreDocente.setText("Nombre:");
        getContentPane().add(jLabelNombreDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, 30));

        jTextFieldNombreDocente.setBackground(new java.awt.Color(0, 0, 0));
        jTextFieldNombreDocente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextFieldNombreDocente.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldNombreDocente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNombreDocenteKeyTyped(evt);
            }
        });
        getContentPane().add(jTextFieldNombreDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 134, 20));

        jLabelTelefonoDocente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTelefonoDocente.setText("Telefono:");
        getContentPane().add(jLabelTelefonoDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, 30));

        jTextFieldTelefonoDocente.setBackground(new java.awt.Color(0, 0, 0));
        jTextFieldTelefonoDocente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextFieldTelefonoDocente.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldTelefonoDocente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTelefonoDocenteKeyTyped(evt);
            }
        });
        getContentPane().add(jTextFieldTelefonoDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 90, 20));

        jTextFieldRHDocente.setBackground(new java.awt.Color(0, 0, 0));
        jTextFieldRHDocente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextFieldRHDocente.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTextFieldRHDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 126, 20));

        jLabelRhDocente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelRhDocente.setText("Direccion:");
        getContentPane().add(jLabelRhDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, 30));

        jLabelCCTIDocente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelCCTIDocente.setText("Cedula:");
        getContentPane().add(jLabelCCTIDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 30));

        jTextFieldTICC.setBackground(new java.awt.Color(0, 0, 0));
        jTextFieldTICC.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextFieldTICC.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldTICC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTICCKeyTyped(evt);
            }
        });
        getContentPane().add(jTextFieldTICC, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 62, 80, -1));

        jLabelEdadDocente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelEdadDocente.setText("Edad:");
        getContentPane().add(jLabelEdadDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, 30));

        jLabelApellidoDocente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelApellidoDocente.setText("Apellido:");
        getContentPane().add(jLabelApellidoDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, 30));

        jTextFieldApellidoDocente.setBackground(new java.awt.Color(0, 0, 0));
        jTextFieldApellidoDocente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextFieldApellidoDocente.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldApellidoDocente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldApellidoDocenteKeyTyped(evt);
            }
        });
        getContentPane().add(jTextFieldApellidoDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 134, 20));

        jLabelAsignatura2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelAsignatura2.setText("Seleccione un docente:");
        getContentPane().add(jLabelAsignatura2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Correo:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, 30));

        jTextCorreo.setBackground(new java.awt.Color(0, 0, 0));
        jTextCorreo.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTextCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 130, 20));

        jScrollPane2.setBackground(new java.awt.Color(0, 0, 0));

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
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 360, 150));

        jTextDocente.setBackground(new java.awt.Color(0, 0, 0));
        jTextDocente.setForeground(new java.awt.Color(255, 255, 255));
        jTextDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextDocenteActionPerformed(evt);
            }
        });
        jTextDocente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextDocenteKeyTyped(evt);
            }
        });
        getContentPane().add(jTextDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, 170, -1));

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(18, 18, null, 1));
        getContentPane().add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, -1, 30));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonAceptarDocente.setBackground(new java.awt.Color(102, 102, 102));
        jButtonAceptarDocente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonAceptarDocente.setText("Guardar");
        jButtonAceptarDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarDocenteActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAceptarDocente);

        jButtonLimpiarDocente.setBackground(new java.awt.Color(102, 102, 102));
        jButtonLimpiarDocente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonLimpiarDocente.setText("Limpiar");
        jButtonLimpiarDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarDocenteActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonLimpiarDocente);

        jButtonVolverDocente.setBackground(new java.awt.Color(102, 102, 102));
        jButtonVolverDocente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonVolverDocente.setText("Volver");
        jButtonVolverDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverDocenteActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonVolverDocente);

        jButtonCargarDocente.setBackground(new java.awt.Color(102, 102, 102));
        jButtonCargarDocente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonCargarDocente.setText("Cargar Docente");
        jButtonCargarDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCargarDocenteActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCargarDocente);

        jButtonModificardocente.setBackground(new java.awt.Color(102, 102, 102));
        jButtonModificardocente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonModificardocente.setText("Modificar Docente");
        jButtonModificardocente.setEnabled(false);
        jButtonModificardocente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonModificardocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificardocenteActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonModificardocente);

        jButtonEliminarDocente.setBackground(new java.awt.Color(102, 102, 102));
        jButtonEliminarDocente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonEliminarDocente.setText("Eliminar Docente");
        jButtonEliminarDocente.setEnabled(false);
        jButtonEliminarDocente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonEliminarDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarDocenteActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonEliminarDocente);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 640, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Cambiar direccion:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, -1, -1));

        jTexteditdirec.setBackground(new java.awt.Color(0, 0, 0));
        jTexteditdirec.setForeground(new java.awt.Color(255, 255, 255));
        jTexteditdirec.setEnabled(false);
        getContentPane().add(jTexteditdirec, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 270, 160, -1));

        jButton2.setText("Si");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 270, -1, -1));

        jButton3.setText("No");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 270, -1, -1));

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 240, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
 private void habilitarComponentes() {
        jButtonEliminarDocente.setEnabled(false);
        jButtonModificardocente.setEnabled(false);
        jButtonAceptarDocente.setEnabled(true);
        jButtonLimpiarDocente.setEnabled(true);
        jButtonCargarDocente.setEnabled(true);

    }

    public void ListarDatos() throws ClassNotFoundException, SQLException {
        //Como el método de la BL retorna un ArrayList de la clase Estudiantes
        //Aqui lo recuperamos

        ArrayList<Docente> lstdocentes = bldocente.ConsultaLista();

        Object columnas[] = {"nombres", "apellidos", "edad", "cedula", "direccion", "Telefono", "correo"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        jTable1.setModel(modelo);

        for (Docente objeto : lstdocentes) {
            //String id=String.valueOf(objeto.getStrCodigo());
            String nombres = objeto.getNombre();
            String apellidos = objeto.getApellido();
            String direccion = objeto.getDireccion();
            String cedula = objeto.getCedula();
            int edad = objeto.getEdad();
            String correo = objeto.getCorreo();
            String telefono = objeto.getTelefono();
            
            String modeloTemp[] = {nombres, apellidos, String.valueOf(edad), cedula, direccion, telefono, correo};
            modelo.addRow(modeloTemp);
        }

    }

    private void limpiar() {
        this.jTextFieldNombreDocente.setText("");
        this.jTextFieldApellidoDocente.setText("");
        this.jTextFieldTelefonoDocente.setText("");
        this.jTextFieldRHDocente.setText("");
        this.jTextFieldTICC.setText("");
        this.jTextCorreo.setText("");
        this.jTexteditdirec.setText("");
        this.jTextDocente.setText("");
        
        habilitarComponentes();
    }

    public boolean validar() {
        if (jTextFieldNombreDocente.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "campo de texto del nombre del docente esta vacio", "docentes", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else if (jTextFieldApellidoDocente.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "campo de texto del apellido del docente esta vacio", "docentes", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else if (this.jTextCorreo.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "campo de texto del codigo del carnet del docente esta vacio", "docentes", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else if (jTextFieldTICC.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "campo de texto del documento del docente esta vacio", "docentes", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else if (jTextFieldTelefonoDocente.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "campo de texto del telefono del docente esta vacio", "docentes", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else if (jTextFieldRHDocente.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "campo de texto del RH del docente esta vacio", "docentes", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else {
            try {
                Integer.parseInt(jTextFieldTICC.getText());

                Integer.parseInt(jTextFieldTelefonoDocente.getText());
                return true;
            } catch (NullPointerException | NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "algun dato esta con el formato incorrecto", "docentes", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }

        }
    }

    private void crearDocente() throws ClassNotFoundException, SQLException {

        if (validar()) {
            BLUsuario user = new BLUsuario();
            Usuario userai = new Usuario();
            docent.setCedula(String.valueOf(jTextFieldTICC.getText()));
            docent.setTelefono(String.valueOf(jTextFieldTelefonoDocente.getText()));
            docent.setNombre(jTextFieldNombreDocente.getText());
            docent.setApellido(jTextFieldApellidoDocente.getText());
            docent.setDireccion(jTextFieldRHDocente.getText());
            docent.setCorreo(jTextCorreo.getText());
            docent.setEdad((int) this.jSpinner1.getValue());

            if (bldocente.Consultar(docent)) {
                boolean creado = bldocente.RegistrarDocente(docent);
                userai.setUser(this.jTextFieldNombreDocente.getText() + (int) this.jSpinner1.getValue());
                userai.setPassword(jTextFieldTICC.getText());
                userai.setRoll(2);
                user.RegistrarUsuario(userai);
                if (creado) {
                    limpiar();
                    this.ListarDatos();
                    JOptionPane.showMessageDialog(this, "Se creo el docente", "Crear docente", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo Crear el docente", "crear docente", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                jTextFieldTICC.setText("");
                jTextFieldTICC.requestFocus();
                JOptionPane.showMessageDialog(this, "El docente ya existe", "Crear docente", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private void eliminarDocente() throws SQLException, ClassNotFoundException {
        BLDocente bldocente = new BLDocente();
        Docente docent = new Docente();
        String cedula = this.jTextDocente.getText();
        if (bldocente.Consultar(docent)) {
            docent.setCedula(cedula);
            bldocente.Eliminar(docent);

            JOptionPane.showMessageDialog(this, "se elimino el docente", "docentes", JOptionPane.INFORMATION_MESSAGE);
            habilitarComponentes();
            this.ListarDatos();
            limpiar();
        }

    }

    private void modificarDocente() throws ClassNotFoundException, SQLException {

        String Direccion = this.jTexteditdirec.getText();
        String Cedula = this.jTextDocente.getText();
        docent.setCedula(Cedula);
        docent.setDireccion(Direccion);
        
        if (bldocente.Consultar(docent)) {
            if (expre.referencia(Direccion)){
                 String actual = docent.getDireccion();
            bldocente.Modificar(docent);
            JOptionPane.showMessageDialog(this, "se Modifico la direccion el docente", "docentes", JOptionPane.INFORMATION_MESSAGE);
            habilitarComponentes();
            this.ListarDatos();
            limpiar();
            }
           
        }

    }
    private void jButtonAceptarDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarDocenteActionPerformed
        try {
            crearDocente();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CrearDocente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CrearDocente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonAceptarDocenteActionPerformed

    private void jButtonLimpiarDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarDocenteActionPerformed
        limpiar();
        jTextFieldTICC.setEditable(true);
    }//GEN-LAST:event_jButtonLimpiarDocenteActionPerformed

    private void jButtonVolverDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverDocenteActionPerformed
        GUISecretaria notas = new GUISecretaria();
        notas.setEnabled(true);
        notas.setVisible(true);
        dispose();
        limpiar();
        jTextFieldTICC.setEditable(true);

    }//GEN-LAST:event_jButtonVolverDocenteActionPerformed

    private void jButtonCargarDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCargarDocenteActionPerformed
        try {
            this.ListarDatos();
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }//GEN-LAST:event_jButtonCargarDocenteActionPerformed

    private void jButtonModificardocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificardocenteActionPerformed
        try {
            modificarDocente();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CrearDocente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CrearDocente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonModificardocenteActionPerformed

    private void jButtonEliminarDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarDocenteActionPerformed
        try {
            eliminarDocente();
        } catch (SQLException ex) {
            Logger.getLogger(CrearDocente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CrearDocente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonEliminarDocenteActionPerformed

    private void jTextFieldNombreDocenteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNombreDocenteKeyTyped
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
    }//GEN-LAST:event_jTextFieldNombreDocenteKeyTyped

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

    private void jTextFieldTelefonoDocenteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTelefonoDocenteKeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "ingrese solo numeros");
        }
    }//GEN-LAST:event_jTextFieldTelefonoDocenteKeyTyped

    private void jTextFieldTICCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTICCKeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "ingrese solo numeros");
        }
    }//GEN-LAST:event_jTextFieldTICCKeyTyped

    private void jTextDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextDocenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextDocenteActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.jButtonModificardocente.setEnabled(true);
        this.jTexteditdirec.setEnabled(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.jButtonEliminarDocente.setEnabled(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.jButton2.setEnabled(true);
        this.jButton3.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextDocenteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextDocenteKeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "ingrese CEDULA a eliminar");
        }
    }//GEN-LAST:event_jTextDocenteKeyTyped

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
            java.util.logging.Logger.getLogger(CrearDocente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearDocente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearDocente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearDocente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearDocente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonAceptarDocente;
    private javax.swing.JButton jButtonCargarDocente;
    private javax.swing.JButton jButtonEliminarDocente;
    private javax.swing.JButton jButtonLimpiarDocente;
    private javax.swing.JButton jButtonModificardocente;
    private javax.swing.JButton jButtonVolverDocente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelApellidoDocente;
    private javax.swing.JLabel jLabelAsignatura2;
    private javax.swing.JLabel jLabelCCTIDocente;
    private javax.swing.JLabel jLabelEdadDocente;
    private javax.swing.JLabel jLabelNombreDocente;
    private javax.swing.JLabel jLabelRhDocente;
    private javax.swing.JLabel jLabelTelefonoDocente;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextCorreo;
    private javax.swing.JTextField jTextDocente;
    private javax.swing.JTextField jTextFieldApellidoDocente;
    private javax.swing.JTextField jTextFieldNombreDocente;
    private javax.swing.JTextField jTextFieldRHDocente;
    private javax.swing.JTextField jTextFieldTICC;
    private javax.swing.JTextField jTextFieldTelefonoDocente;
    private javax.swing.JTextField jTexteditdirec;
    // End of variables declaration//GEN-END:variables
}