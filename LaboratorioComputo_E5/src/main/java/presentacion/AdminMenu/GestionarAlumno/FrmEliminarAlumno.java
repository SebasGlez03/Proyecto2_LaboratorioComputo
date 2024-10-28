/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion.AdminMenu.GestionarAlumno;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import negocio.DTO.CarreraDTO;
import negocio.DTO.EstudianteDTO;
import negocio.logica.CarreraNegocio;
import negocio.logica.EstudianteNegocio;
import utilerias.JButtonCellEditor;
import utilerias.JButtonRenderer;

/**
 *
 * @author nomar
 */
public class FrmEliminarAlumno extends javax.swing.JFrame {

    CarreraNegocio carreraNegocio = new CarreraNegocio();
    EstudianteNegocio estudianteNegocio = new EstudianteNegocio();

    /**
     * Creates new form FrmEliminarAlumno
     */
    public FrmEliminarAlumno() {
        initComponents();
        cargarConfiguracionInicialTablaCartelera();
        llenarTablaEstudiantes(estudianteNegocio.buscarTodosLosEstudiantes());

    }

    public void llenarTablaEstudiantes(List<EstudianteDTO> listaEstudiantes) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblEstudiantes.getModel();

        if (modeloTabla.getRowCount() > 0) {
            for (int i = modeloTabla.getRowCount() - 1; i > -1; i--) {
                modeloTabla.removeRow(i);
            }
        }

        if (listaEstudiantes != null) {
            listaEstudiantes.forEach(row -> {
                Object[] fila = new Object[7];
                fila[0] = row.getId();
                fila[1] = row.getNombre();
                fila[2] = row.getApellidoPaterno();
                fila[3] = row.getApellidoMaterno();
                fila[4] = row.getContrasenia();
                fila[5] = row.getEstatusInscripcion();
                fila[6] = row.getCarrera().getNombre();

                modeloTabla.addRow(fila);
            });
        }
    }

    public CarreraDTO obtenerCarreraDTOdeString(String nombreCarrera) {

        for (CarreraDTO carrera : carreraNegocio.buscarCarreras()) {
            if (carrera.getNombre().equals(nombreCarrera)) {
                return carrera;
            }
        }
        return null;
    }

    private void cargarConfiguracionInicialTablaCartelera() {

        ActionListener onEliminarClickListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtén la fila seleccionada
                int filaSeleccionada = tblEstudiantes.getSelectedRow();

                if (filaSeleccionada != -1) { // Verifica que haya una fila seleccionada
                    // Usa el modelo para obtener los datos del estudiante en esa fila
                    DefaultTableModel modeloTabla = (DefaultTableModel) tblEstudiantes.getModel();

                    Long idEstudiante = (Long) modeloTabla.getValueAt(filaSeleccionada, 0); // Suponiendo que el ID esté en la columna 0
                    String nombreEstudiante = (String) modeloTabla.getValueAt(filaSeleccionada, 1);
                    String apellidoPaterno = (String) modeloTabla.getValueAt(filaSeleccionada, 2);
                    String apellidoMaterno = (String) modeloTabla.getValueAt(filaSeleccionada, 3);
                    String contrasenia = (String) modeloTabla.getValueAt(filaSeleccionada, 4);
                    String estatusInscripcion = (String) modeloTabla.getValueAt(filaSeleccionada, 5);
                    String carrera = (String) modeloTabla.getValueAt(filaSeleccionada, 6);

                    // Crea un EstudianteDTO usando los datos obtenidos de la fila
                    EstudianteDTO estudiante = new EstudianteDTO();
                    CarreraDTO carreraDTO = new CarreraDTO();
                    estudiante.setId(idEstudiante);
                    estudiante.setNombre(nombreEstudiante);
                    estudiante.setApellidoPaterno(apellidoPaterno);
                    estudiante.setApellidoMaterno(apellidoMaterno);
                    estudiante.setContrasenia(contrasenia);
                    estudiante.setEstatusInscripcion(estatusInscripcion);
                    estudiante.setCarrera(obtenerCarreraDTOdeString(carrera));

                    // Aquí puedes implementar la lógica de eliminación o cualquier otra acción
//                    System.out.println("Estudiante a eliminar: " + estudiante.toString());
                    try {
                        estudianteNegocio.eliminarEstudiante(estudiante);
                        JOptionPane.showMessageDialog(null, "El alumno se ha eliminado correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado al eliminar el alumno: " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                    }

                }
            }
        };

        TableColumnModel modeloColumnas = this.tblEstudiantes.getColumnModel();
        modeloColumnas.getColumn(7).setCellRenderer(new JButtonRenderer("Eliminar"));
        modeloColumnas.getColumn(7).setCellEditor(new JButtonCellEditor("Eliminar", onEliminarClickListener));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancelar = new javax.swing.JButton();
        Titulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEstudiantes = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(50, 48, 49));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 700, -1, -1));

        Titulo.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        Titulo.setForeground(new java.awt.Color(255, 255, 255));
        Titulo.setText("Eliminar Alumno");
        getContentPane().add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, -1));

        tblEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "idEstudiante", "Nombre", "ApellidoPaterno", "ApellidoMaterno", "Contraseña", "EstatusInscripcion", "Carrera", "Eliminar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblEstudiantes);
        if (tblEstudiantes.getColumnModel().getColumnCount() > 0) {
            tblEstudiantes.getColumnModel().getColumn(5).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 920, 500));

        jPanel1.setBackground(new java.awt.Color(50, 48, 49));
        jPanel1.setForeground(new java.awt.Color(50, 48, 49));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 750));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmEliminarAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEliminarAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEliminarAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEliminarAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmEliminarAlumno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEstudiantes;
    // End of variables declaration//GEN-END:variables
}
