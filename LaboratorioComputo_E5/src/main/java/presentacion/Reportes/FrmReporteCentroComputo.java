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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import main.buscarComputadoraIp;
import negocio.DTO.CarreraDTO;
import negocio.DTO.CentroComputoDTO;
import negocio.logica.CarreraNegocio;
import negocio.logica.CentroComputoNegocio;
import negocio.logica.ComputadoraNegocio;
import persistencia.entidades.BloqueoEntidad;
import presentacion.AdminMenu.FrmReportes;

/**
 *
 * @author nomar
 */
public class FrmReporteCentroComputo extends javax.swing.JFrame {

    CarreraNegocio carreraNegcio = new CarreraNegocio();
    DateTimePicker dateTimePicker = new DateTimePicker();
    DateTimePicker dateTimePicker2 = new DateTimePicker();
    DefaultListModel<String> listModel = new DefaultListModel<>();
    DefaultListModel<String> listModel2 = new DefaultListModel<>();
    CentroComputoNegocio centroComputoNegocio = new CentroComputoNegocio();
    
    List<CarreraDTO> carrerasDTO = new ArrayList<>();
    List<CentroComputoDTO> centrosDTO = new ArrayList<>();

    int carreraCounter = 0;
    int centroCounter = 0;
    List<String> carreras = new ArrayList<>();
    List<String> centros = new ArrayList<>();
    int numMaquina;
    /**
     * Creates new form FrmReporteCarrera
     */
    public FrmReporteCentroComputo() {
        initComponents();

        fldFechaInicio.setLayout(new FlowLayout());
        fldFechaInicio.add(dateTimePicker);
        fldFechaFin.setLayout(new FlowLayout());
        fldFechaFin.add(dateTimePicker2);
        this.carrerasDTO = carreraNegcio.buscarCarreras();
        llenarBoxCarreras(carrerasDTO);
        this.centrosDTO = centroComputoNegocio.buscarCentrosComputos();
        llenarBoxCentros(centrosDTO);
        System.out.println(carrerasDTO.toString());
        
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
     * Metodo que se encarga de llenar el comboBox con las carreras de la base
     * de datos
     *
     * @param centro Lista de carreras que hay en una unidad academica
     */
    private void llenarBoxCentros(List<CentroComputoDTO> centro) {
        int i = 0;
        while (centro.size() > i) {
            comboBoxCentro.addItem(centro.get(i).getNombre());
            i++;
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
    
    public void generarReporteCentroComputoSinFiltro(){
        
                // Obtener las fechas desde los DateTimePickers
        LocalDateTime inicioLocal = dateTimePicker.getDateTimePermissive();
        LocalDateTime finLocal = dateTimePicker2.getDateTimePermissive();

        // Convertir LocalDateTime a Calendar
        Calendar inicio = convertLocalDateTimeToCalendar(inicioLocal);
        Calendar fin = convertLocalDateTimeToCalendar(finLocal);


        if (inicio == null || fin == null) {
            JOptionPane.showMessageDialog(FrmReporteCentroComputo.this, "Seleccione fechas", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (inicio.after(fin)) {
            JOptionPane.showMessageDialog(FrmReporteCentroComputo.this, "La fecha de inicio no puede ser después de la fecha fin.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        
        generarReporteCentroComputo(centroComputoNegocio.obtenerReporteCentroComputoSinFiltro(inicio, fin), inicio, fin);
   
        
    }
    public void generarReporteCentroComputoFiltrado(){
        
                // Obtener las fechas desde los DateTimePickers
        LocalDateTime inicioLocal = dateTimePicker.getDateTimePermissive();
        LocalDateTime finLocal = dateTimePicker2.getDateTimePermissive();

        // Convertir LocalDateTime a Calendar
        Calendar inicio = convertLocalDateTimeToCalendar(inicioLocal);
        Calendar fin = convertLocalDateTimeToCalendar(finLocal);


        if (inicio == null || fin == null) {
            JOptionPane.showMessageDialog(FrmReporteCentroComputo.this, "Seleccione fechas", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (inicio.after(fin)) {
            JOptionPane.showMessageDialog(FrmReporteCentroComputo.this, "La fecha de inicio no puede ser después de la fecha fin.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        
        generarReporteCentroComputo(centroComputoNegocio.obtenerReporteCentroComputo(centros, carreras,inicio, fin), inicio, fin);
   
        
    }
    
    public void generarReporteCentroComputo(List<Object[]> lista, Calendar inicio, Calendar fin) {
    String dest = "reporteCentroComputo.pdf";

    // Convertir Calendar a Timestamp
    Timestamp inicioTimestamp = new Timestamp(inicio.getTimeInMillis());
    Timestamp finTimestamp = new Timestamp(fin.getTimeInMillis());


    try {
        // Crear el documento PDF
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc);

        // Agregar título al reporte
        document.add(new Paragraph("Reporte de Centro Computo")
                .setBold()
                .setFontSize(20));
        document.add(new Paragraph("Desde: " + inicioTimestamp.toString() + " Hasta: " + finTimestamp.toString()));
        document.add(new Paragraph("\n")); // Añadir un espacio

        // Crear la tabla con las columnas
        Table table = new Table(5);
        table.addHeaderCell("Centro de Cómputo");
        table.addHeaderCell("Número de computadora");
        table.addHeaderCell("Cantidad de usuarios");
        table.addHeaderCell("Minutos utilizados");
        table.addHeaderCell("Minutos inactivos");

        // Crear un formato para la fecha
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");


        // Agregar datos a la tabla
        for (Object[] row : lista) {
            String nombreCentro = (String) row[0];
            int numComputarda = (int) row[1];
            Long cantUsuarios = (Long) row[2];
            Long minutos = (Long) row[3];
        Long differenceInMillis = inicio.getTimeInMillis() - fin.getTimeInMillis();
        Long differenceInMinutes = differenceInMillis / (1000 * 60); // Convert milliseconds to minutes

        differenceInMinutes = differenceInMinutes-minutos;
            table.addCell(nombreCentro);
            table.addCell("#"+numComputarda);
            table.addCell(cantUsuarios.toString());
            table.addCell(minutos.toString());
            table.addCell(differenceInMinutes.toString());
        }

        // Agregar la tabla al documento
        document.add(table);

        // Cerrar el documento
        document.close();


        // Mensaje de éxito
        JOptionPane.showMessageDialog(this, "Reporte de Bloqueos generado con éxito: " + dest, "Éxito", JOptionPane.INFORMATION_MESSAGE);
    } catch (FileNotFoundException e) {
        JOptionPane.showMessageDialog(this, "Error al generar el reporte: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } 
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lblCarreras = new javax.swing.JLabel();
        lblFechaFin = new javax.swing.JLabel();
        lblFechaInicio = new javax.swing.JLabel();
        comboBoxCarrera = new javax.swing.JComboBox<>();
        fldFechaFin = new javax.swing.JPanel();
        fldFechaInicio = new javax.swing.JPanel();
        reporte = new javax.swing.JLabel();
        carrera = new javax.swing.JLabel();
        btnAtras = new javax.swing.JLabel();
        lblCarreras1 = new javax.swing.JLabel();
        comboBoxCentro = new javax.swing.JComboBox<>();
        btnAgregarCarrera = new javax.swing.JButton();
        btnAgregarCentro = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listCarreras = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listCentros = new javax.swing.JList<>();
        btnGenerarReporte = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCarreras.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCarreras.setForeground(new java.awt.Color(255, 255, 255));
        lblCarreras.setText("Carreras");
        getContentPane().add(lblCarreras, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, -1, -1));

        lblFechaFin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblFechaFin.setForeground(new java.awt.Color(255, 255, 255));
        lblFechaFin.setText("Fecha fin");
        getContentPane().add(lblFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 260, -1, -1));

        lblFechaInicio.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblFechaInicio.setForeground(new java.awt.Color(255, 255, 255));
        lblFechaInicio.setText("Fecha Inicio");
        getContentPane().add(lblFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, -1));

        getContentPane().add(comboBoxCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 210, 40));
        getContentPane().add(fldFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 300, 350, 40));
        getContentPane().add(fldFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 350, 40));

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

        lblCarreras1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCarreras1.setForeground(new java.awt.Color(255, 255, 255));
        lblCarreras1.setText("Centro de Cómputo");
        getContentPane().add(lblCarreras1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 350, -1, -1));

        getContentPane().add(comboBoxCentro, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 390, 210, 40));

        btnAgregarCarrera.setText("Agregar");
        btnAgregarCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCarreraActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregarCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, -1, -1));

        btnAgregarCentro.setText("Agregar");
        btnAgregarCentro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCentroActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregarCentro, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 440, -1, -1));

        jScrollPane1.setViewportView(listCarreras);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, 210, 90));

        jScrollPane2.setViewportView(listCentros);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 470, 210, 90));

        btnGenerarReporte.setText("Generar");
        btnGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteActionPerformed(evt);
            }
        });
        getContentPane().add(btnGenerarReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 600, 280, 90));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BackGroundGeneral.jpg"))); // NOI18N
        fondo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                fondoMouseMoved(evt);
            }
        });
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseClicked
        // TODO add your handling code here:
        new FrmReportes().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAtrasMouseClicked

    private void fondoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fondoMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_fondoMouseMoved

    private void btnAgregarCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCarreraActionPerformed
        listCarreras.setModel(listModel);
        int fila = (int) comboBoxCarrera.getSelectedIndex();

        listModel.add(carreraCounter, carreraNegcio.buscarCarrera(carrerasDTO.get(fila).getId()).getNombre());
        listModel.setSize(20);
        this.carreras.add(carreraNegcio.buscarCarrera(carrerasDTO.get(fila).getId()).getNombre());
 
        carreraCounter++;

    }//GEN-LAST:event_btnAgregarCarreraActionPerformed

    
    
    private void btnAgregarCentroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCentroActionPerformed
        listCentros.setModel(listModel2);
        int fila = (int) comboBoxCentro.getSelectedIndex();
        
        listModel2.add(centroCounter, centrosDTO.get(fila).getNombre());
        listModel2.setSize(20);
        this.centros.add(centrosDTO.get(fila).getNombre());
 
        centroCounter++;
    }//GEN-LAST:event_btnAgregarCentroActionPerformed

    private void btnGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteActionPerformed
        // TODO add your handling code here:
        if (carreras != null && centros != null){
        
            generarReporteCentroComputoFiltrado();
            
        }else{
        generarReporteCentroComputoSinFiltro();
        }
        
    }//GEN-LAST:event_btnGenerarReporteActionPerformed

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
    private javax.swing.JButton btnAgregarCarrera;
    private javax.swing.JButton btnAgregarCentro;
    private javax.swing.JLabel btnAtras;
    private javax.swing.JButton btnGenerarReporte;
    private javax.swing.JLabel carrera;
    private javax.swing.JComboBox<String> comboBoxCarrera;
    private javax.swing.JComboBox<String> comboBoxCentro;
    private javax.swing.JPanel fldFechaFin;
    private javax.swing.JPanel fldFechaInicio;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCarreras;
    private javax.swing.JLabel lblCarreras1;
    private javax.swing.JLabel lblFechaFin;
    private javax.swing.JLabel lblFechaInicio;
    private javax.swing.JList<String> listCarreras;
    private javax.swing.JList<String> listCentros;
    private javax.swing.JLabel reporte;
    // End of variables declaration//GEN-END:variables
}
