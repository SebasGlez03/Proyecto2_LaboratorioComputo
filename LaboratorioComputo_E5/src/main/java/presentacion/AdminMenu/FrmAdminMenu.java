/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion.AdminMenu;

import presentacion.AdminMenu.GestionarComputadora.FrmGestionarComputadora;
import presentacion.AdminMenu.GestionarCarrera.FrmGestionarCarrera;
import presentacion.AdminMenu.GestionarBloqueo.FrmGestionarBloqueo;
import presentacion.AdminMenu.GestionarAlumno.FrmGestionarAlumno;
import presentacion.FrmLogin;

/**
 *
 * @author nomar
 */
public class FrmAdminMenu extends javax.swing.JFrame {

    /**
     * Creates new form AdminMenu
     */
    public FrmAdminMenu() {
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

        btnReporte = new javax.swing.JLabel();
        btnGestionarAlumnos = new javax.swing.JLabel();
        btnInsetarUnidades = new javax.swing.JLabel();
        btnGestionarBloqueos = new javax.swing.JLabel();
        btnGestionarCarrera = new javax.swing.JLabel();
        btnGestionarComputadora = new javax.swing.JLabel();
        btnAtras = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnReportes.png"))); // NOI18N
        btnReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReporteMouseClicked(evt);
            }
        });
        getContentPane().add(btnReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, -1, -1));

        btnGestionarAlumnos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnGestionarAlumno.png"))); // NOI18N
        btnGestionarAlumnos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGestionarAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGestionarAlumnosMouseClicked(evt);
            }
        });
        getContentPane().add(btnGestionarAlumnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 280, -1, -1));

        btnInsetarUnidades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InsetarUnidades.png"))); // NOI18N
        btnInsetarUnidades.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInsetarUnidades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInsetarUnidadesMouseClicked(evt);
            }
        });
        getContentPane().add(btnInsetarUnidades, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 400, -1, -1));

        btnGestionarBloqueos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GestionarBloqueo.png"))); // NOI18N
        btnGestionarBloqueos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGestionarBloqueos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGestionarBloqueosMouseClicked(evt);
            }
        });
        getContentPane().add(btnGestionarBloqueos, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 400, -1, -1));

        btnGestionarCarrera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GestionarCarrera.png"))); // NOI18N
        btnGestionarCarrera.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGestionarCarrera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGestionarCarreraMouseClicked(evt);
            }
        });
        getContentPane().add(btnGestionarCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 520, -1, -1));

        btnGestionarComputadora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GestionarComputadora.png"))); // NOI18N
        btnGestionarComputadora.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGestionarComputadora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGestionarComputadoraMouseClicked(evt);
            }
        });
        getContentPane().add(btnGestionarComputadora, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 520, -1, -1));

        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnAtras.png"))); // NOI18N
        btnAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAtrasMouseClicked(evt);
            }
        });
        getContentPane().add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 680, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AdminMenu.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnReporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReporteMouseClicked
        // TODO add your handling code here:
        new FrmReportes().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnReporteMouseClicked

    private void btnInsetarUnidadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsetarUnidadesMouseClicked
        // TODO add your handling code here:
        new FrmInsertarUnidad().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnInsetarUnidadesMouseClicked

    private void btnGestionarCarreraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGestionarCarreraMouseClicked
        // TODO add your handling code here:
        new FrmGestionarCarrera().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnGestionarCarreraMouseClicked

    private void btnGestionarAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGestionarAlumnosMouseClicked
        // TODO add your handling code here:
        new FrmGestionarAlumno().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnGestionarAlumnosMouseClicked

    private void btnGestionarBloqueosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGestionarBloqueosMouseClicked
        // TODO add your handling code here:
        new FrmGestionarBloqueo().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnGestionarBloqueosMouseClicked

    private void btnGestionarComputadoraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGestionarComputadoraMouseClicked
        // TODO add your handling code here:
        new FrmGestionarComputadora().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnGestionarComputadoraMouseClicked

    private void btnAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseClicked
        // TODO add your handling code here:
        new FrmLogin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAtrasMouseClicked

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAtras;
    private javax.swing.JLabel btnGestionarAlumnos;
    private javax.swing.JLabel btnGestionarBloqueos;
    private javax.swing.JLabel btnGestionarCarrera;
    private javax.swing.JLabel btnGestionarComputadora;
    private javax.swing.JLabel btnInsetarUnidades;
    private javax.swing.JLabel btnReporte;
    private javax.swing.JLabel fondo;
    // End of variables declaration//GEN-END:variables
}
