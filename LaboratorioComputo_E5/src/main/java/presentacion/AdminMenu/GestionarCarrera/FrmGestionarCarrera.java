/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion.AdminMenu.GestionarCarrera;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import negocio.DTO.CarreraDTO;
import negocio.logica.CarreraNegocio;
import presentacion.AdminMenu.FrmAdminMenu;

import utilerias.JButtonCellEditor;
import utilerias.JButtonRenderer;

/**
 *
 * @author nomar
 */
public class FrmGestionarCarrera extends javax.swing.JFrame {

    CarreraNegocio carreraNegocio = new CarreraNegocio();
    
    /**
     * Creates new form FrmGestionarCarrera
     */
    public FrmGestionarCarrera() {
        initComponents();
        
        botonEditarEnTabla();
        botonEliminarEnTabla();
        llenarTablaCarrera(carreraNegocio.buscarCarreras());
    }

    public void llenarTablaCarrera(List<CarreraDTO> listaCarrera) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblCarrera.getModel();

        if (modeloTabla.getRowCount() > 0) {
            for (int i = modeloTabla.getRowCount() - 1; i > -1; i--) {
                modeloTabla.removeRow(i);
            }
        }

        if (listaCarrera != null) {
            listaCarrera.forEach(row -> {
                Object[] fila = new Object[7];
                fila[0] = row.getId();
                fila[1] = row.getNombre();
                fila[2] = row.getTiempoDiario();

                modeloTabla.addRow(fila);
            });
        }
    }
    
private void botonEliminarEnTabla() {

        ActionListener onEliminarClickListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtén la fila seleccionada
                int filaSeleccionada = tblCarrera.getSelectedRow();

                if (filaSeleccionada != -1) { // Verifica que haya una fila seleccionada
                    // Usa el modelo para obtener los datos de la carrera en esa fila
                    DefaultTableModel modeloTabla = (DefaultTableModel) tblCarrera.getModel();

                    Long idCarrera = (Long) modeloTabla.getValueAt(filaSeleccionada, 0); // Suponiendo que el ID esté en la columna 0
                    String nombreCarrera = (String) modeloTabla.getValueAt(filaSeleccionada, 1);
                    Date tiempoDiario = (Date) modeloTabla.getValueAt(filaSeleccionada, 2);
                    

                    // Crea un carreraDTO usando los datos obtenidos de la fila
                    
                    CarreraDTO carrera = new CarreraDTO();
                    carrera.setId(idCarrera);
                    carrera.setNombre(nombreCarrera);
                    carrera.setTiempoDiario(tiempoDiario);
        
                    // Aquí puedes implementar la lógica de eliminación o cualquier otra acción
//                    System.out.println("Carrera a eliminar: " + carrera.toString());
                    int respuesta = JOptionPane.showConfirmDialog(
                            null,
                            "¿Está seguro de que desea eliminar esta Carrera?",
                            "Confirmar eliminación",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE
                    );

                    if (respuesta == JOptionPane.YES_OPTION) {
                        try {
                            carreraNegocio.eliminarCarrera(carrera);
                            JOptionPane.showMessageDialog(null, "La Carrera se ha eliminado correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                            dispose();
                            FrmGestionarCarrera frm = new FrmGestionarCarrera();
                            frm.setVisible(true);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado al eliminar la carrera: " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }

                }
            }
        };

        TableColumnModel modeloColumnas = this.tblCarrera.getColumnModel();
        modeloColumnas.getColumn(4).setCellRenderer(new JButtonRenderer("Eliminar"));
        modeloColumnas.getColumn(4).setCellEditor(new JButtonCellEditor("Eliminar", onEliminarClickListener));
    }

    private void botonEditarEnTabla() {

        ActionListener onEliminarClickListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtén la fila seleccionada
                int filaSeleccionada = tblCarrera.getSelectedRow();

                if (filaSeleccionada != -1) { // Verifica que haya una fila seleccionada
                    // Usa el modelo para obtener los datos del estudiante en esa fila
                    DefaultTableModel modeloTabla = (DefaultTableModel) tblCarrera.getModel();

                    Long idCarrera = (Long) modeloTabla.getValueAt(filaSeleccionada, 0); // Suponiendo que el ID esté en la columna 0
                    String nombreCarrera = (String) modeloTabla.getValueAt(filaSeleccionada, 1);
                    Date tiempoDiario = (Date) modeloTabla.getValueAt(filaSeleccionada, 2);

                    // Crea un carreraDTO usando los datos obtenidos de la fila
                    
                    CarreraDTO carrera = new CarreraDTO();
                    carrera.setId(idCarrera);
                    carrera.setNombre(nombreCarrera);
                    carrera.setTiempoDiario(tiempoDiario);

                    // Aquí puedes implementar la lógica de eliminación o cualquier otra acción
                    System.out.println("Estudiante a eliminar: " + carrera.toString());
                    FrmEditarCarrera frmEC = new FrmEditarCarrera(carrera);
                    frmEC.setVisible(true);
//                    int respuesta = JOptionPane.showConfirmDialog(
//                            null,
//                            "¿Está seguro de que desea editar este alumno?",
//                            "Confirmar eliminación",
//                            JOptionPane.YES_NO_OPTION,
//                            JOptionPane.QUESTION_MESSAGE
//                    );
//                    
//                    if (respuesta == JOptionPane.YES_OPTION) {
//                        try {
//                            estudianteNegocio.modificarEstudiante(estudiante);
//                            JOptionPane.showMessageDialog(null, "El alumno se ha eliminado correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
//                            dispose();
//                            FrmGestionarAlumno frm = new FrmGestionarAlumno();
//                            frm.setVisible(true);
//                        } catch (Exception ex) {
//                            JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado al eliminar el alumno: " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
//                        }
//                    }

                }
            }
        };

        TableColumnModel modeloColumnas = this.tblCarrera.getColumnModel();
        modeloColumnas.getColumn(3).setCellRenderer(new JButtonRenderer("Editar"));
        modeloColumnas.getColumn(3).setCellEditor(new JButtonCellEditor("Editar", onEliminarClickListener));
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
        tblCarrera = new javax.swing.JTable();
        btnFlechaIzquierda = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        centroDeComputo.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        centroDeComputo.setForeground(new java.awt.Color(255, 255, 255));
        centroDeComputo.setText("Carrera");
        getContentPane().add(centroDeComputo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, -1, -1));

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
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 670, -1, -1));

        btnFlechaDerecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnFlechaD.png"))); // NOI18N
        getContentPane().add(btnFlechaDerecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 410, -1, -1));

        tblCarrera.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "idCarrera", "Nombre de la Carrera", "Tiempo de uso Diario", "Editar", "Eliminar"
            }
        ));
        jScrollPane1.setViewportView(tblCarrera);

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

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
        // TODO add your handling code here:
        FrmAgregarCarrera frm = new FrmAgregarCarrera();
        frm.setVisible(true);
    }//GEN-LAST:event_btnAgregarMouseClicked

   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAgregar;
    private javax.swing.JLabel btnAtras;
    private javax.swing.JLabel btnFlechaDerecha;
    private javax.swing.JLabel btnFlechaIzquierda;
    private javax.swing.JLabel centroDeComputo;
    private javax.swing.JLabel fondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel reporte;
    private javax.swing.JTable tblCarrera;
    // End of variables declaration//GEN-END:variables
}
