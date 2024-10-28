/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion.AdminMenu.GestionarBloqueo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import negocio.DTO.BloqueoDTO;
import negocio.DTO.CarreraDTO;
import negocio.DTO.EstudianteDTO;
import negocio.logica.BloqueoNegocio;
import negocio.logica.EstudianteNegocio;
import presentacion.AdminMenu.FrmAdminMenu;
import utilerias.JButtonCellEditor;
import utilerias.JButtonRenderer;

/**
 *
 * @author nomar
 */
public class FrmGestionarBloqueo extends javax.swing.JFrame {

    BloqueoNegocio bloqueoNegocio = new BloqueoNegocio();
    EstudianteNegocio estudianteNegocio = new EstudianteNegocio();

    /**
     * Creates new form FrmGestionarBloqueo
     */
    public FrmGestionarBloqueo() {
        initComponents();

        botonEliminarEnTabla();
        llenarTablaBloqueos(bloqueoNegocio.buscarBloqueos());
    }

    /**
     * Metodo que llena la tabla con la lista de bloqueos de la base de datos
     *
     * @param listaBloqueos lista de bloqueos proveniente de la base de datos
     */
    public void llenarTablaBloqueos(List<BloqueoDTO> listaBloqueos) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblBloqueos.getModel();

        if (modeloTabla.getRowCount() > 0) {
            for (int i = modeloTabla.getRowCount() - 1; i > -1; i--) {
                modeloTabla.removeRow(i);
            }
        }

        if (listaBloqueos != null) {
            listaBloqueos.forEach(row -> {
                Object[] fila = new Object[7];
                fila[0] = row.getId();
                fila[1] = row.getFechaBloqueo().getTime();
                fila[2] = row.getFechaLiberacion().getTime();
                fila[3] = row.getMotivo();
                fila[4] = row.getEstudiante().getId();

                modeloTabla.addRow(fila);
            });
        }
    }

    /**
     * Metodo que transforma el ID de el estudiante que se le bloqueo la
     * computadora a un EstudianteDTO
     *
     * @param idEstudiante id del estudiante
     * @return EstudianteDTO proveniente de el idEstudiante
     */
    public EstudianteDTO obtenerEstudianteDTOdeString(Long idEstudiante) {

        for (EstudianteDTO estudiante : estudianteNegocio.buscarTodosLosEstudiantes()) {
            if (estudiante.getId() == idEstudiante) {
                return estudiante;
            }
        }
        return null;
    }

    /**
     * Metodo que agrega el boton en la tabla, que a su vez contiene la logica
     * para eliminar el esutidante deseado
     */
    private void botonEliminarEnTabla() {

        ActionListener onEliminarClickListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtén la fila seleccionada
                int filaSeleccionada = tblBloqueos.getSelectedRow();

                if (filaSeleccionada != -1) { // Verifica que haya una fila seleccionada
                    // Usa el modelo para obtener los datos del estudiante en esa fila
                    DefaultTableModel modeloTabla = (DefaultTableModel) tblBloqueos.getModel();

                    Long idBloqueo = (Long) modeloTabla.getValueAt(filaSeleccionada, 0); // Suponiendo que el ID esté en la columna 0
                    Date fechaBloqueoDate = (Date) modeloTabla.getValueAt(filaSeleccionada, 1);
                    Calendar fechaBloqueo = Calendar.getInstance(); // Se parsea el Date a Calendar
                    fechaBloqueo.setTime(fechaBloqueoDate); // Se establece el valor del Date al Calendar
                    Date fechaLiberacionDate = (Date) modeloTabla.getValueAt(filaSeleccionada, 2);
                    Calendar fechaLiberacion = Calendar.getInstance(); // Se parsea el Date a Calendar
                    fechaLiberacion.setTime(fechaLiberacionDate); // Se establece el valor del Date al Calendar
                    String motivoBloqueo = (String) modeloTabla.getValueAt(filaSeleccionada, 3);
                    Long estudiante = (Long) modeloTabla.getValueAt(filaSeleccionada, 4);

                    // Crea un EstudianteDTO usando los datos obtenidos de la fila
                    BloqueoDTO bloqueo = new BloqueoDTO();
                    bloqueo.setId(idBloqueo);
                    bloqueo.setFechaBloqueo(fechaBloqueo);
                    bloqueo.setFechaLiberacion(fechaLiberacion);
                    bloqueo.setMotivo(motivoBloqueo);
                    bloqueo.setEstudiante(obtenerEstudianteDTOdeString(estudiante));

                    // Aquí puedes implementar la lógica de eliminación o cualquier otra acción
                    System.out.println("bloqueo a eliminar: " + bloqueo.toString());
                }
            }
        };

        TableColumnModel modeloColumnas = this.tblBloqueos.getColumnModel();
        modeloColumnas.getColumn(6).setCellRenderer(new JButtonRenderer("Eliminar"));
        modeloColumnas.getColumn(6).setCellEditor(new JButtonCellEditor("Eliminar", onEliminarClickListener));
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
        btnFlechaDerecha = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBloqueos = new javax.swing.JTable();
        btnFlechaIzquierda = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
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
        btnAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAtrasMouseClicked(evt);
            }
        });
        getContentPane().add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 680, -1, -1));

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnAgregar.png"))); // NOI18N
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 670, -1, -1));

        btnFlechaDerecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnFlechaD.png"))); // NOI18N
        btnFlechaDerecha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btnFlechaDerecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 670, -1, -1));

        tblBloqueos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "idBloqueo", "FechaBloqueo", "FechaLiberacion", "MotivoBloqueo", "Estudiante", "Editar", "Eliminar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblBloqueos);
        if (tblBloqueos.getColumnModel().getColumnCount() > 0) {
            tblBloqueos.getColumnModel().getColumn(0).setResizable(false);
            tblBloqueos.getColumnModel().getColumn(0).setPreferredWidth(15);
            tblBloqueos.getColumnModel().getColumn(1).setResizable(false);
            tblBloqueos.getColumnModel().getColumn(2).setResizable(false);
            tblBloqueos.getColumnModel().getColumn(3).setResizable(false);
            tblBloqueos.getColumnModel().getColumn(4).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 940, -1));

        btnFlechaIzquierda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnFlechaI.png"))); // NOI18N
        btnFlechaIzquierda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btnFlechaIzquierda, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 670, -1, -1));

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
    private javax.swing.JLabel btnFlechaDerecha;
    private javax.swing.JLabel btnFlechaIzquierda;
    private javax.swing.JLabel centroDeComputo;
    private javax.swing.JLabel fondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel reporte;
    private javax.swing.JTable tblBloqueos;
    // End of variables declaration//GEN-END:variables
}
