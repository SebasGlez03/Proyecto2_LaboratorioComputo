/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion.Reportes;

import com.github.lgooddatepicker.components.DateTimePicker;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import java.awt.FlowLayout;
import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import persistencia.entidades.BloqueoEntidad;
import presentacion.AdminMenu.FrmReportes;

/**
 * a
 * @hidden
 */
public class FrmReporteBloqueos extends javax.swing.JFrame {

    DateTimePicker dateTimePicker = new DateTimePicker();
    DateTimePicker dateTimePicker2 = new DateTimePicker();
    
    /**
     * Creates new form FrmReporteBloqueos
     */
    public FrmReporteBloqueos() {
        initComponents();
        
        fldFechaInicio.setLayout(new FlowLayout());
        fldFechaInicio.add(dateTimePicker);
        fldFechaFin.setLayout(new FlowLayout());
        fldFechaFin.add(dateTimePicker2);
    }
    
    public void generarReporteBloqueo(Calendar inicio, Calendar fin) {
    String dest = "reporteBloqueos.pdf";

    // Convertir Calendar a Timestamp
    Timestamp inicioTimestamp = new Timestamp(inicio.getTimeInMillis());
    Timestamp finTimestamp = new Timestamp(fin.getTimeInMillis());

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionJPA");
    EntityManager em = emf.createEntityManager();

    try {
        // Crear el documento PDF
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc);

        // Agregar título al reporte
        document.add(new Paragraph("Reporte de Bloqueos")
                .setBold()
                .setFontSize(20));
        document.add(new Paragraph("Desde: " + inicioTimestamp.toString() + " Hasta: " + finTimestamp.toString()));
        document.add(new Paragraph("\n")); // Añadir un espacio

        // Crear la tabla con las columnas
        Table table = new Table(4);
        table.addHeaderCell("Nombre del Alumno");
        table.addHeaderCell("Fecha de Bloqueo");
        table.addHeaderCell("Fecha de Liberación");
        table.addHeaderCell("Motivo");

        // Crear un formato para la fecha
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        // Obtener los bloqueos en el rango de fechas
        TypedQuery<BloqueoEntidad> query = em.createQuery("SELECT b FROM BloqueoEntidad b WHERE b.fechaBloqueo BETWEEN :inicio AND :fin", BloqueoEntidad.class);
        query.setParameter("inicio", inicioTimestamp);
        query.setParameter("fin", finTimestamp);

        List<BloqueoEntidad> bloqueos = query.getResultList();

        // Agregar datos a la tabla
        for (BloqueoEntidad bloqueo : bloqueos) {
            String nombreAlumno = bloqueo.getEstudiante().getNombre();

            // Convertir fechaBloqueo y fechaLiberacion de Calendar a Date usando getTime()
            Date fechaBloqueoDate = (bloqueo.getFechaBloqueo() != null) ? 
                bloqueo.getFechaBloqueo().getTime() : null;

            Date fechaLiberacionDate = (bloqueo.getFechaLiberacion() != null) ? 
                bloqueo.getFechaLiberacion().getTime() : null;

            // Formatear las fechas
            String fechaBloqueo = (fechaBloqueoDate != null) ? sdf.format(fechaBloqueoDate) : "N/A";
            String fechaLiberacion = (fechaLiberacionDate != null) ? sdf.format(fechaLiberacionDate) : "N/A";
            String motivo = bloqueo.getMotivo();

            table.addCell(nombreAlumno);
            table.addCell(fechaBloqueo);
            table.addCell(fechaLiberacion);
            table.addCell(motivo);
        }

        // Agregar la tabla al documento
        document.add(table);

        // Cerrar el documento
        document.close();
        em.close();
        emf.close();

        // Mensaje de éxito
        JOptionPane.showMessageDialog(this, "Reporte de Bloqueos generado con éxito: " + dest, "Éxito", JOptionPane.INFORMATION_MESSAGE);
    } catch (FileNotFoundException e) {
        JOptionPane.showMessageDialog(this, "Error al generar el reporte: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        if (em != null && em.isOpen()) {
            em.close();
        }
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}





        public Calendar convertLocalDateTimeToCalendar(LocalDateTime localDateTime) {
            if (localDateTime == null) {
                return null;
            }
            // Convertir LocalDateTime a ZonedDateTime
            ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
            // Convertir ZonedDateTime a Date
            Date date = Date.from(zonedDateTime.toInstant());
            // Crear una instancia de Calendar y establecer la fecha
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar;
        }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        reporte = new javax.swing.JLabel();
        bloqueo = new javax.swing.JLabel();
        btnAtras = new javax.swing.JLabel();
        fldFechaInicio = new javax.swing.JPanel();
        fldFechaFin = new javax.swing.JPanel();
        lblFechaFin = new javax.swing.JLabel();
        lblFechaInicio = new javax.swing.JLabel();
        btnGenerar = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        reporte.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        reporte.setForeground(new java.awt.Color(255, 255, 255));
        reporte.setText("Reporte");
        getContentPane().add(reporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, -1, -1));

        bloqueo.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        bloqueo.setForeground(new java.awt.Color(255, 255, 255));
        bloqueo.setText("Bloqueos");
        getContentPane().add(bloqueo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, -1, -1));

        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnAtras.png"))); // NOI18N
        btnAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAtrasMouseClicked(evt);
            }
        });
        getContentPane().add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 680, -1, -1));
        getContentPane().add(fldFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 350, 40));
        getContentPane().add(fldFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 300, 350, 40));

        lblFechaFin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblFechaFin.setForeground(new java.awt.Color(255, 255, 255));
        lblFechaFin.setText("Fecha fin");
        getContentPane().add(lblFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 260, -1, -1));

        lblFechaInicio.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblFechaInicio.setForeground(new java.awt.Color(255, 255, 255));
        lblFechaInicio.setText("Fecha Inicio");
        getContentPane().add(lblFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, -1));

        btnGenerar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnGenerar.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerar.setText("Generar");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGenerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 460, 140, 70));

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

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        // TODO add your handling code here:
        // Obtener las fechas desde los DateTimePickers
        LocalDateTime inicioLocal = dateTimePicker.getDateTimePermissive();
        LocalDateTime finLocal = dateTimePicker2.getDateTimePermissive();

        // Convertir LocalDateTime a Calendar
        Calendar inicio = convertLocalDateTimeToCalendar(inicioLocal);
        Calendar fin = convertLocalDateTimeToCalendar(finLocal);



        // Validar que las fechas no sean nulas
        if (inicio == null || fin == null) {
            JOptionPane.showMessageDialog(FrmReporteBloqueos.this, "Por favor seleccione un rango de fechas válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar que la fecha de inicio no sea posterior a la fecha de fin
        if (inicio.after(fin)) {
            JOptionPane.showMessageDialog(FrmReporteBloqueos.this, "La fecha de inicio no puede ser posterior a la fecha de fin.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Llamar al método para generar el reporte
        generarReporteBloqueo(inicio, fin);
   
    }//GEN-LAST:event_btnGenerarActionPerformed

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
                new FrmReporteBloqueos().setVisible(true);
            }
        });
    }
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bloqueo;
    private javax.swing.JLabel btnAtras;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JPanel fldFechaFin;
    private javax.swing.JPanel fldFechaInicio;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel lblFechaFin;
    private javax.swing.JLabel lblFechaInicio;
    private javax.swing.JLabel reporte;
    // End of variables declaration//GEN-END:variables
 }
