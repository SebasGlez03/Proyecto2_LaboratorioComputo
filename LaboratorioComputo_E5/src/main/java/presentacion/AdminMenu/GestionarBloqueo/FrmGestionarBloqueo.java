/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion.AdminMenu.GestionarBloqueo;

import presentacion.AdminMenu.FrmAdminMenu;

/**
 *
 * @author nomar
 */
public class FrmGestionarBloqueo extends javax.swing.JFrame {

    /**
     * Creates new form FrmGestionarBloqueo
     */
    public FrmGestionarBloqueo() {
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

        centroDeComputo = new javax.swing.JLabel();
        reporte = new javax.swing.JLabel();
        btnAtras = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JLabel();
        btnEditar = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JLabel();
        btnFlechaDerecha = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnFlechaIzquierda = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        centroDeComputo.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        centroDeComputo.setForeground(new java.awt.Color(255, 255, 255));
        centroDeComputo.setText("Bloqueo");
        getContentPane().add(centroDeComputo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, -1, -1));

        reporte.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        reporte.setForeground(new java.awt.Color(255, 255, 255));
        reporte.setText("Gestionar");
        getContentPane().add(reporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, -1, -1));

        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnAtras.png"))); // NOI18N
        btnAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAtrasMouseClicked(evt);
            }
        });
        getContentPane().add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 680, -1, -1));

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnAgregar.png"))); // NOI18N
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 670, -1, -1));

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnEditar.png"))); // NOI18N
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 670, -1, -1));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnEliminar.png"))); // NOI18N
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 670, -1, -1));

        btnFlechaDerecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnFlechaD.png"))); // NOI18N
        getContentPane().add(btnFlechaDerecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 410, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 810, -1));

        btnFlechaIzquierda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnFlechaI.png"))); // NOI18N
        getContentPane().add(btnFlechaIzquierda, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BackGroundGeneral.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FrmGestionarBloqueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmGestionarBloqueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmGestionarBloqueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmGestionarBloqueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmGestionarBloqueo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAgregar;
    private javax.swing.JLabel btnAtras;
    private javax.swing.JLabel btnEditar;
    private javax.swing.JLabel btnEliminar;
    private javax.swing.JLabel btnFlechaDerecha;
    private javax.swing.JLabel btnFlechaIzquierda;
    private javax.swing.JLabel centroDeComputo;
    private javax.swing.JLabel fondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel reporte;
    // End of variables declaration//GEN-END:variables
}
