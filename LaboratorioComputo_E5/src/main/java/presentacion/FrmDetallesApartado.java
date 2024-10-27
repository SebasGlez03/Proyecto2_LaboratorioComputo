/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import negocio.logica.ComputadoraNegocio;
import com.github.lgooddatepicker.components.DateTimePicker;
import java.awt.FlowLayout;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;


/**
 *
 * @author nomar
 */
public class FrmDetallesApartado extends javax.swing.JFrame {

    Long idCComputo;
    Long idComputadora;
    Long idEstudiante;
    ComputadoraNegocio computadoraNegocio = new ComputadoraNegocio();
    DateTimePicker dateTimePicker = new DateTimePicker();
    
    /**
     * Creates new form FrmGestionarAlumno
     */
    public FrmDetallesApartado(Long idComputadora, Long idEstudiante, Long idCComputo) {
        
        initComponents();
        this.idComputadora = idComputadora;
        this.idEstudiante = idEstudiante;
        this.idCComputo = idCComputo;
        
        llenarTablaSoftware(computadoraNegocio.buscarComputadora(idComputadora).getSoftware());

        fldDateTime.setLayout(new FlowLayout()); 
        fldDateTime.add(dateTimePicker);


    }

    private void llenarTablaSoftware(List<String> sofwtare) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblSoftware.getModel();

        if (modeloTabla.getRowCount() > 0) {
            for (int i = modeloTabla.getRowCount() - 1; i > -1; i--) {
                modeloTabla.removeRow(i);
            }
        }

        if (sofwtare != null) {
            sofwtare.forEach(row -> {
                Object[] fila = new Object[7];
                fila[0] = row;

                modeloTabla.addRow(fila);
            });
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

        lblDetalles = new javax.swing.JLabel();
        lblNumComputadora = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSoftware = new javax.swing.JTable();
        btnAtras = new javax.swing.JLabel();
        btnOk = new javax.swing.JLabel();
        lblApartado = new javax.swing.JLabel();
        lblNumComputadora1 = new javax.swing.JLabel();
        fldDateTime = new javax.swing.JPanel();
        btnSeleccionarFecha = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDetalles.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblDetalles.setForeground(new java.awt.Color(255, 255, 255));
        lblDetalles.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDetalles.setText("Detalles");
        getContentPane().add(lblDetalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1000, -1));

        lblNumComputadora.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblNumComputadora.setForeground(new java.awt.Color(255, 255, 255));
        lblNumComputadora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNumComputadora.setText("Num Computadora");
        getContentPane().add(lblNumComputadora, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 1000, -1));

        tblSoftware.setBackground(new java.awt.Color(255, 255, 255));
        tblSoftware.setForeground(new java.awt.Color(0, 0, 0));
        tblSoftware.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Software"
            }
        ));
        tblSoftware.setToolTipText("");
        tblSoftware.setGridColor(new java.awt.Color(102, 102, 102));
        jScrollPane1.setViewportView(tblSoftware);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 310, 100));

        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnAtras.png"))); // NOI18N
        btnAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAtrasMouseClicked(evt);
            }
        });
        getContentPane().add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 680, -1, -1));

        btnOk.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnOk.png"))); // NOI18N
        btnOk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOkMouseClicked(evt);
            }
        });
        getContentPane().add(btnOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 590, 1000, 63));

        lblApartado.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblApartado.setForeground(new java.awt.Color(255, 255, 255));
        lblApartado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblApartado.setText("Apartado");
        getContentPane().add(lblApartado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1000, -1));

        lblNumComputadora1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblNumComputadora1.setForeground(new java.awt.Color(255, 255, 255));
        lblNumComputadora1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNumComputadora1.setText("Selecciones la fecha de apartado");
        getContentPane().add(lblNumComputadora1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 1000, -1));
        getContentPane().add(fldDateTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 1000, 60));

        btnSeleccionarFecha.setText("Seleccionar fecha");
        btnSeleccionarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarFechaActionPerformed(evt);
            }
        });
        getContentPane().add(btnSeleccionarFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 430, 420, 40));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BackGroundGeneral.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseClicked
        
        new FrmSistemaApartado(idCComputo, idEstudiante).setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnAtrasMouseClicked

    private void btnOkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOkMouseClicked
        dispose();
    }//GEN-LAST:event_btnOkMouseClicked

    private void btnSeleccionarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarFechaActionPerformed

        LocalDateTime dateTime = dateTimePicker.getDateTimePermissive();
        if (dateTime != null){
        
        System.out.println(dateTime.toString());
        }
        else {
            JOptionPane.showMessageDialog(this, "Selecciona una fecha/hora primero" );
        }
        
    }//GEN-LAST:event_btnSeleccionarFechaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAtras;
    private javax.swing.JLabel btnOk;
    private javax.swing.JButton btnSeleccionarFecha;
    private javax.swing.JPanel fldDateTime;
    private javax.swing.JLabel fondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApartado;
    private javax.swing.JLabel lblDetalles;
    private javax.swing.JLabel lblNumComputadora;
    private javax.swing.JLabel lblNumComputadora1;
    private javax.swing.JTable tblSoftware;
    // End of variables declaration//GEN-END:variables
}
