/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion.AdminMenu.GestionarComputadora;

import presentacion.AdminMenu.GestionarAlumno.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import negocio.DTO.CarreraDTO;
import negocio.DTO.CentroComputoDTO;
import negocio.DTO.ComputadoraDTO;
import negocio.DTO.EstudianteDTO;
import negocio.logica.CarreraNegocio;
import negocio.logica.CentroComputoNegocio;
import negocio.logica.ComputadoraNegocio;
import negocio.logica.EstudianteNegocio;
import presentacion.AdminMenu.FrmAdminMenu;
import utilerias.JButtonCellEditor;
import utilerias.JButtonRenderer;

/**
 *
 * @author nomar
 */
public class FrmGestionarComputadora extends javax.swing.JFrame {

    CentroComputoNegocio centroComputoNegocio = new CentroComputoNegocio();
    ComputadoraNegocio computadoraNegocio = new ComputadoraNegocio();
    int pagina = 0;
    int limite = 3;

    /**
     * Creates new form FrmGestionarAlumno
     */
    public FrmGestionarComputadora() {
        initComponents();

        botonEditarEnTabla();
        botonEliminarEnTabla();
        llenarTablaEstudiantes(obtenerPagina(pagina, limite));
    }
    
    /**
     * Metodo que llena la tabla de estudiantes con la informacion de la base de
     * datos
     *
     * @param listaEstudiantes lista de estudiantes proveniente de la base de
     * datos.
     */

    private List<ComputadoraDTO> obtenerPagina(int indiceInicio, int indiceFin) {
        List<ComputadoraDTO> todas= computadoraNegocio.buscarComputadora();
        List<ComputadoraDTO> todasLasPaginas = new ArrayList<>();
        indiceFin = Math.min(indiceFin, todas.size());
        for (int i = indiceInicio; i < indiceFin; i++) {
            todasLasPaginas.add(todas.get(i));
        }
        return todasLasPaginas;
    }    
    
    
    /**
     * Metodo que llena la tabla de estudiantes con la informacion de la base de
     * datos
     *
     * @param listaEstudiantes lista de estudiantes proveniente de la base de
     * datos.
     */
    public void llenarTablaEstudiantes(List<ComputadoraDTO> listaEstudiantes) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblComputadoras.getModel();

        if (modeloTabla.getRowCount() > 0) {
            for (int i = modeloTabla.getRowCount() - 1; i > -1; i--) {
                modeloTabla.removeRow(i);
            }
        }

        if (listaEstudiantes != null) {
            listaEstudiantes.forEach(row -> {
                Object[] fila = new Object[7];
                fila[0] = row.getId();
                fila[1] = row.isEsAdmin();
                fila[2] = row.getIp();
                fila[3] = row.getNumComputadora();
                fila[4] = row.getCentroComputo().getNombre();

                modeloTabla.addRow(fila);
            });
        }
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
                int filaSeleccionada = tblComputadoras.getSelectedRow();

                if (filaSeleccionada != -1) { // Verifica que haya una fila seleccionada
                    // Usa el modelo para obtener los datos del estudiante en esa fila
                    DefaultTableModel modeloTabla = (DefaultTableModel) tblComputadoras.getModel();

                    Long idEstudiante = (Long) modeloTabla.getValueAt(filaSeleccionada, 0); // Suponiendo que el ID esté en la columna 0
                    Boolean esAdmin = (Boolean) modeloTabla.getValueAt(filaSeleccionada, 1);
                    String ip = (String) modeloTabla.getValueAt(filaSeleccionada, 2);
                    int numComputadora = (int) modeloTabla.getValueAt(filaSeleccionada, 3);
                    String fila = (String) modeloTabla.getValueAt(filaSeleccionada, 4);

                    // Crea un EstudianteDTO usando los datos obtenidos de la fila
                    ComputadoraDTO computadora = new ComputadoraDTO();
                    CentroComputoDTO centroComputoDTO = new CentroComputoDTO();
                    centroComputoDTO = centroComputoNegocio.buscarCentroComputo(obtenerCentroComputoDTOdeString(fila).getId());
                    
                    computadora.setId(idEstudiante);
                    computadora.setEsAdmin(esAdmin);
                    computadora.setIp(ip);
                    computadora.setNumComputadora(numComputadora);
                    computadora.setCentroComputo(centroComputoDTO);

                    // Aquí puedes implementar la lógica de eliminación o cualquier otra acción
//                    System.out.println("Estudiante a eliminar: " + estudiante.toString());
                    int respuesta = JOptionPane.showConfirmDialog(
                            null,
                            "¿Está seguro de que desea eliminar este alumno?",
                            "Confirmar eliminación",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE
                    );

                    if (respuesta == JOptionPane.YES_OPTION) {
                        try {
                            computadoraNegocio.eliminarComputadora(computadora);
                            JOptionPane.showMessageDialog(null, "El alumno se ha eliminado correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                            dispose();
                            FrmGestionarComputadora frm = new FrmGestionarComputadora();
                            frm.setVisible(true);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado al eliminar el alumno: " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }

                }
            }
        };

        TableColumnModel modeloColumnas = this.tblComputadoras.getColumnModel();
        modeloColumnas.getColumn(6).setCellRenderer(new JButtonRenderer("Eliminar"));
        modeloColumnas.getColumn(6).setCellEditor(new JButtonCellEditor("Eliminar", onEliminarClickListener));
    }

    /**
     * Metodo que transforma el nombre de la carrera del estudiante a una
     * CarreraDTO
     *
     * @param nombreCentroComputo nombre de la carrera del esutidante
     * @return CarreraDTO proveniente del nombre de la carrera del estudiante
     */
    public CentroComputoDTO obtenerCentroComputoDTOdeString(String nombreCentroComputo) {

        for (CentroComputoDTO centroComputoD : centroComputoNegocio.buscarCentrosComputos()) {
            if (centroComputoD.getNombre().equals(nombreCentroComputo)) {
                return centroComputoD;
            }
        }
        return null;
    }
    
    /**
     * Metodo que agrega el boton en la tabla, que a su vez contiene la logica
     * para eliminar el esutidante deseado
     */
    private void botonEditarEnTabla() {

        ActionListener onEliminarClickListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtén la fila seleccionada
                int filaSeleccionada = tblComputadoras.getSelectedRow();

                if (filaSeleccionada != -1) { // Verifica que haya una fila seleccionada
                    // Usa el modelo para obtener los datos del estudiante en esa fila
                    DefaultTableModel modeloTabla = (DefaultTableModel) tblComputadoras.getModel();


                    Long idComputadora = (Long) modeloTabla.getValueAt(filaSeleccionada, 0); // Suponiendo que el ID esté en la columna 0
                    Boolean esAdmin = (Boolean) modeloTabla.getValueAt(filaSeleccionada, 1);
                    String ip = (String) modeloTabla.getValueAt(filaSeleccionada, 2);
                    int numComputadora = (int) modeloTabla.getValueAt(filaSeleccionada, 3);
                    String fila = (String) modeloTabla.getValueAt(filaSeleccionada, 4);

                    // Crea un EstudianteDTO usando los datos obtenidos de la fila
                    ComputadoraDTO computadora = new ComputadoraDTO();
                    CentroComputoDTO centroComputoDTO = new CentroComputoDTO();
                    centroComputoDTO = centroComputoNegocio.buscarCentroComputo(obtenerCentroComputoDTOdeString(fila).getId());
                    
                    
                    computadora.setId(idComputadora);
                    computadora.setEsAdmin(esAdmin);
                    computadora.setIp(ip);
                    computadora.setNumComputadora(numComputadora);
                    computadora.setCentroComputo(centroComputoDTO);

                    // Aquí puedes implementar la lógica de eliminación o cualquier otra acción
                    System.out.println("Computadora a editar: " + computadora.toString());
                    FrmEditarComputadora frmEAPU = new FrmEditarComputadora(computadora);
                    frmEAPU.setVisible(true);
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

        TableColumnModel modeloColumnas = this.tblComputadoras.getColumnModel();
        modeloColumnas.getColumn(5).setCellRenderer(new JButtonRenderer("Editar"));
        modeloColumnas.getColumn(5).setCellEditor(new JButtonCellEditor("Editar", onEliminarClickListener));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCentroDeComputo = new javax.swing.JLabel();
        lblGestionar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblComputadoras = new javax.swing.JTable();
        btnAtras = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JLabel();
        btnFlechaDerecha = new javax.swing.JLabel();
        btnFlechaIzquierda = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCentroDeComputo.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblCentroDeComputo.setForeground(new java.awt.Color(255, 255, 255));
        lblCentroDeComputo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCentroDeComputo.setText("Computadoras");
        getContentPane().add(lblCentroDeComputo, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 90, 1000, -1));

        lblGestionar.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblGestionar.setForeground(new java.awt.Color(255, 255, 255));
        lblGestionar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGestionar.setText("Gestionar");
        getContentPane().add(lblGestionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 40, 1000, -1));

        tblComputadoras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "idComputadora", "Admin", "Ip", "numMaquina", "Centro Cómputo", "Editar", "Eliminar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblComputadoras);
        if (tblComputadoras.getColumnModel().getColumnCount() > 0) {
            tblComputadoras.getColumnModel().getColumn(0).setResizable(false);
            tblComputadoras.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblComputadoras.getColumnModel().getColumn(1).setResizable(false);
            tblComputadoras.getColumnModel().getColumn(2).setResizable(false);
            tblComputadoras.getColumnModel().getColumn(3).setResizable(false);
            tblComputadoras.getColumnModel().getColumn(4).setResizable(false);
            tblComputadoras.getColumnModel().getColumn(5).setResizable(false);
            tblComputadoras.getColumnModel().getColumn(6).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 960, -1));

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
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 670, -1, -1));

        btnFlechaDerecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnFlechaD.png"))); // NOI18N
        btnFlechaDerecha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFlechaDerecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFlechaDerechaMouseClicked(evt);
            }
        });
        getContentPane().add(btnFlechaDerecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 670, -1, -1));

        btnFlechaIzquierda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnFlechaI.png"))); // NOI18N
        btnFlechaIzquierda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFlechaIzquierda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFlechaIzquierdaMouseClicked(evt);
            }
        });
        getContentPane().add(btnFlechaIzquierda, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 670, -1, -1));

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
        FrmAgregarAlumno frm = new FrmAgregarAlumno();
        frm.setVisible(true);
    }//GEN-LAST:event_btnAgregarMouseClicked

    private void btnFlechaIzquierdaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFlechaIzquierdaMouseClicked
        // TODO add your handling code here:
        if (pagina -3 < 0)
        {
            JOptionPane.showMessageDialog(this, "No hay más páginas atrás");
        }
        else
        {
        pagina -= 3;
        limite -= 3;   
        llenarTablaEstudiantes(obtenerPagina(pagina, limite));
        } 


    }//GEN-LAST:event_btnFlechaIzquierdaMouseClicked

    private void btnFlechaDerechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFlechaDerechaMouseClicked
        pagina += 3;
        limite += 3;   
        llenarTablaEstudiantes(obtenerPagina(pagina, limite));
    }//GEN-LAST:event_btnFlechaDerechaMouseClicked

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
            java.util.logging.Logger.getLogger(FrmGestionarComputadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmGestionarComputadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmGestionarComputadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmGestionarComputadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmGestionarComputadora().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAgregar;
    private javax.swing.JLabel btnAtras;
    private javax.swing.JLabel btnFlechaDerecha;
    private javax.swing.JLabel btnFlechaIzquierda;
    private javax.swing.JLabel fondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCentroDeComputo;
    private javax.swing.JLabel lblGestionar;
    private javax.swing.JTable tblComputadoras;
    // End of variables declaration//GEN-END:variables
}
