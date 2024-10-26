/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion.AdminMenu;

import presentacion.Reportes.FrmReporteCarrera;
import presentacion.Reportes.FrmReporteBloqueos;
import presentacion.Reportes.FrmReporteCentroDeComputo;

/**
 *
 * @author nomar
 */
public class FrmReportes extends javax.swing.JFrame {

    /**
     * Creates new form FrmReportes
     */
    public FrmReportes() {
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

        btnBloqueos = new javax.swing.JLabel();
        btnCarrera = new javax.swing.JLabel();
        btnCentroDeComputo = new javax.swing.JLabel();
        btnAtras = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBloqueos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnBloqueos.png"))); // NOI18N
        btnBloqueos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBloqueosMouseClicked(evt);
            }
        });
        getContentPane().add(btnBloqueos, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 260, -1, -1));

        btnCarrera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnCarrera.png"))); // NOI18N
        btnCarrera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCarreraMouseClicked(evt);
            }
        });
        getContentPane().add(btnCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 380, -1, -1));

        btnCentroDeComputo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnCentroDeComputo.png"))); // NOI18N
        btnCentroDeComputo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCentroDeComputoMouseClicked(evt);
            }
        });
        getContentPane().add(btnCentroDeComputo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 500, -1, -1));

        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnAtras.png"))); // NOI18N
        btnAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAtrasMouseClicked(evt);
            }
        });
        getContentPane().add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 680, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Reportes.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBloqueosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBloqueosMouseClicked
        // TODO add your handling code here:
        new FrmReporteBloqueos().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBloqueosMouseClicked

    private void btnCarreraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCarreraMouseClicked
        // TODO add your handling code here:
        new FrmReporteCarrera().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCarreraMouseClicked

    private void btnCentroDeComputoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCentroDeComputoMouseClicked
        // TODO add your handling code here:
        new FrmReporteCentroDeComputo().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCentroDeComputoMouseClicked

    private void btnAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseClicked
        // TODO add your handling code here:
        new FrmAdminMenu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAtrasMouseClicked

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
            java.util.logging.Logger.getLogger(FrmReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmReportes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAtras;
    private javax.swing.JLabel btnBloqueos;
    private javax.swing.JLabel btnCarrera;
    private javax.swing.JLabel btnCentroDeComputo;
    private javax.swing.JLabel fondo;
    // End of variables declaration//GEN-END:variables
}
