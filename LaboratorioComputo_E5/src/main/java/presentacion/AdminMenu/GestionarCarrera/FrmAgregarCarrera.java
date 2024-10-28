/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion.AdminMenu.GestionarCarrera;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;
import persistencia.DAO.CarreraDAO;
import persistencia.entidades.CarreraEntidad;

/**
 *
 * @author nomar
 */
public class FrmAgregarCarrera extends javax.swing.JFrame {

    /**
     * Creates new form FrmAgregarCarrera
     */
    public FrmAgregarCarrera() {
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

        Titulo = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnReiniciar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        nombreCarrera = new javax.swing.JLabel();
        campoTextoNombreCarrera = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        campoTextoTiempoDiario = new javax.swing.JTextField();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Titulo.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        Titulo.setForeground(new java.awt.Color(255, 255, 255));
        Titulo.setText("Agregar Carrera");
        getContentPane().add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, -1, -1));

        btnReiniciar.setText("Reiniciar");
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });
        getContentPane().add(btnReiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 550, -1, -1));

        btnAgregar.setBackground(new java.awt.Color(0, 204, 0));
        btnAgregar.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 550, -1, -1));

        nombreCarrera.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nombreCarrera.setForeground(new java.awt.Color(255, 255, 255));
        nombreCarrera.setText("Nombre de la carrera");
        getContentPane().add(nombreCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));
        getContentPane().add(campoTextoNombreCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 230, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tiempo Diario HH:MM:SS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 220, -1));
        getContentPane().add(campoTextoTiempoDiario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 230, 30));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgroundChico.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        // TODO add your handling code here:
        campoTextoNombreCarrera.setText("");
        campoTextoTiempoDiario.setText("");
    }//GEN-LAST:event_btnReiniciarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        
        String nombreCarrera = campoTextoNombreCarrera.getText();
    String tiempoStr = campoTextoTiempoDiario.getText();
    
    try {
        // Convertir el tiempo de String a LocalTime y luego a Date
        LocalTime tiempoDiarioLocal = LocalTime.parse(tiempoStr);
        Date tiempoDiarioDate = Date.from(tiempoDiarioLocal.atDate(LocalDate.now())
                .atZone(ZoneId.systemDefault())
                .toInstant());
        
        // Crear instancia de CarreraEntidad con Date
        CarreraEntidad carrera = new CarreraEntidad(nombreCarrera, tiempoDiarioDate, null);
        
        // Guardar en la base de datos
        CarreraDAO carreraDAO = new CarreraDAO();
        carreraDAO.guardarCarrera(carrera);
        
        JOptionPane.showMessageDialog(this, "Carrera agregada con éxito.");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al guardar: " + e.getMessage());
    }
    }//GEN-LAST:event_btnAgregarActionPerformed

 
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JTextField campoTextoNombreCarrera;
    private javax.swing.JTextField campoTextoTiempoDiario;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel nombreCarrera;
    // End of variables declaration//GEN-END:variables
}
