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
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import com.itextpdf.kernel.pdf.PdfWriter;

/**
 *
 * @author nomar
 */
public class FrmReporteCarrera extends javax.swing.JFrame {

    CarreraNegocio carreraNegcio = new CarreraNegocio();
    DateTimePicker dateTimePicker = new DateTimePicker();
    DateTimePicker dateTimePicker2 = new DateTimePicker();
    List<CarreraDTO> listaCarrerasAFiltrar = new ArrayList<>();

    /**
     * Creates new form FrmReporteCarrera
     */
    public FrmReporteCarrera() {
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

    /**
     * Metodo que transforma una fecha LocalDateTime a Calendar
     *
     * @param fechaAConvertir Fecha de tipo LocalDateTime a convertir
     * @return Fecha convertida a Calendar
     */
    private Calendar convertirDateTimePickerACalendar(LocalDateTime fechaAConvertir) {

        Date FechaConvertidaADate = Date.from(fechaAConvertir.atZone(ZoneId.systemDefault()).toInstant());

        Calendar fechaConvertidaCalendar = Calendar.getInstance();
        fechaConvertidaCalendar.setTime(FechaConvertidaADate);

        return fechaConvertidaCalendar;
    }

    public void generarReporteCarrera(Timestamp inicio, Timestamp fin, List<CarreraDTO> listaCarreras) {
        
        String dest = "reporteCarrera.pdf";
        
//        PdfWriter writer = new PdfWriter();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGenerarReporte = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnAgregarCarrera = new javax.swing.JButton();
        lblCarreras = new javax.swing.JLabel();
        lblFechaFin = new javax.swing.JLabel();
        lblFechaInicio = new javax.swing.JLabel();
        comboBoxCarrera = new javax.swing.JComboBox<>();
        fldFechaFin = new javax.swing.JPanel();
        fldFechaInicio = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaNotificador = new javax.swing.JTextArea();
        reporte = new javax.swing.JLabel();
        carrera = new javax.swing.JLabel();
        btnAtras = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGenerarReporte.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnGenerarReporte.setText("Generar Reporte");
        getContentPane().add(btnGenerarReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 460, 240, 100));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 630, -1, -1));

        btnAgregarCarrera.setText("Agregar");
        btnAgregarCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCarreraActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregarCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 430, 90, 40));

        lblCarreras.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCarreras.setForeground(new java.awt.Color(255, 255, 255));
        lblCarreras.setText("Carreras");
        getContentPane().add(lblCarreras, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, -1, -1));

        lblFechaFin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblFechaFin.setForeground(new java.awt.Color(255, 255, 255));
        lblFechaFin.setText("Fecha fin");
        getContentPane().add(lblFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 260, -1, -1));

        lblFechaInicio.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblFechaInicio.setForeground(new java.awt.Color(255, 255, 255));
        lblFechaInicio.setText("Fecha Inicio");
        getContentPane().add(lblFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, -1));

        getContentPane().add(comboBoxCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, 250, 40));
        getContentPane().add(fldFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 300, 350, 40));
        getContentPane().add(fldFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 350, 40));

        txtAreaNotificador.setColumns(20);
        txtAreaNotificador.setRows(5);
        jScrollPane1.setViewportView(txtAreaNotificador);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 500, 350, 120));

        reporte.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        reporte.setForeground(new java.awt.Color(255, 255, 255));
        reporte.setText("Reporte");
        getContentPane().add(reporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, -1, -1));

        carrera.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        carrera.setForeground(new java.awt.Color(255, 255, 255));
        carrera.setText("Carreras");
        getContentPane().add(carrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, -1, -1));

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

    private void btnAgregarCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCarreraActionPerformed
        CarreraDTO carrera = carreraNegcio.buscarCarreras().get(comboBoxCarrera.getSelectedIndex());
        listaCarrerasAFiltrar.add(carrera);
        txtAreaNotificador.append("Se agrego la carrera: " + carrera.getNombre() + " a la lista del filtro.\n");
    }//GEN-LAST:event_btnAgregarCarreraActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        listaCarrerasAFiltrar.clear();

        txtAreaNotificador.setText("Se vacio le lista de carreras a filtrar!\n");
    }//GEN-LAST:event_btnLimpiarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmReporteCarrera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmReporteCarrera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmReporteCarrera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmReporteCarrera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmReporteCarrera().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCarrera;
    private javax.swing.JLabel btnAtras;
    private javax.swing.JButton btnGenerarReporte;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel carrera;
    private javax.swing.JComboBox<String> comboBoxCarrera;
    private javax.swing.JPanel fldFechaFin;
    private javax.swing.JPanel fldFechaInicio;
    private javax.swing.JLabel fondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCarreras;
    private javax.swing.JLabel lblFechaFin;
    private javax.swing.JLabel lblFechaInicio;
    private javax.swing.JLabel reporte;
    private javax.swing.JTextArea txtAreaNotificador;
    // End of variables declaration//GEN-END:variables
}
