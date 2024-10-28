/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion.Reportes;

import com.github.lgooddatepicker.components.DateTimePicker;
import java.awt.FlowLayout;
import java.util.List;
import negocio.DTO.CarreraDTO;
import negocio.logica.CarreraNegocio;
import presentacion.AdminMenu.FrmReportes;

/**
 *
 * @author nomar
 */
public class FrmReporteCentroComputo extends javax.swing.JFrame {

    CarreraNegocio carreraNegcio = new CarreraNegocio();
    DateTimePicker dateTimePicker = new DateTimePicker();
    DateTimePicker dateTimePicker2 = new DateTimePicker();

    /**
     * Creates new form FrmReporteCarrera
     */
    public FrmReporteCentroComputo() {
        initComponents();

        fldFechaInicio.setLayout(new FlowLayout());
        fldFechaInicio.add(dateTimePicker);
        fldFechaFin.setLayout(new FlowLayout());
        fldFechaFin.add(dateTimePicker2);
        llenarBoxCarreras(carreraNegcio.buscarCarreras());
    }

    /**
     * Metodo que se encarga de llenar el comboBox con las carreras de la base
     * de datos
     *
     * @param carrera Lista de carreras que hay en una unidad academica
     */
    private void llenarBoxCarreras(List<CarreraDTO> carrera) {
        int i = 0;
        while (carrera.size() > i) {
            comboBoxCarrera.addItem(carrera.get(i).getNombre());
            i++;
        }
    }
    
    public void generarReporteCarrera(){
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCarreras = new javax.swing.JLabel();
        lblFechaFin = new javax.swing.JLabel();
        lblFechaInicio = new javax.swing.JLabel();
        comboBoxCarrera = new javax.swing.JComboBox<>();
        fldFechaFin = new javax.swing.JPanel();
        fldFechaInicio = new javax.swing.JPanel();
        reporte = new javax.swing.JLabel();
        carrera = new javax.swing.JLabel();
        btnAtras = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCarreras.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCarreras.setForeground(new java.awt.Color(255, 255, 255));
        lblCarreras.setText("Carreras");
        getContentPane().add(lblCarreras, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 440, -1, -1));

        lblFechaFin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblFechaFin.setForeground(new java.awt.Color(255, 255, 255));
        lblFechaFin.setText("Fecha fin");
        getContentPane().add(lblFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 260, -1, -1));

        lblFechaInicio.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblFechaInicio.setForeground(new java.awt.Color(255, 255, 255));
        lblFechaInicio.setText("Fecha Inicio");
        getContentPane().add(lblFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, -1));

        getContentPane().add(comboBoxCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 480, 210, 40));
        getContentPane().add(fldFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 300, 350, 40));
        getContentPane().add(fldFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 350, 40));

        reporte.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        reporte.setForeground(new java.awt.Color(255, 255, 255));
        reporte.setText("Reporte");
        getContentPane().add(reporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, -1, -1));

        carrera.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        carrera.setForeground(new java.awt.Color(255, 255, 255));
        carrera.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        carrera.setText("Centro Cómputo");
        getContentPane().add(carrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1000, -1));

        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnAtras.png"))); // NOI18N
        btnAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAtrasMouseClicked(evt);
            }
        });
        getContentPane().add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 680, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BackGroundGeneral.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseClicked
        // TODO add your handling code here:
        new FrmReportes().setVisible(true);
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
            java.util.logging.Logger.getLogger(FrmReporteCentroComputo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmReporteCentroComputo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmReporteCentroComputo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmReporteCentroComputo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmReporteCentroComputo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAtras;
    private javax.swing.JLabel carrera;
    private javax.swing.JComboBox<String> comboBoxCarrera;
    private javax.swing.JPanel fldFechaFin;
    private javax.swing.JPanel fldFechaInicio;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel lblCarreras;
    private javax.swing.JLabel lblFechaFin;
    private javax.swing.JLabel lblFechaInicio;
    private javax.swing.JLabel reporte;
    // End of variables declaration//GEN-END:variables
}
