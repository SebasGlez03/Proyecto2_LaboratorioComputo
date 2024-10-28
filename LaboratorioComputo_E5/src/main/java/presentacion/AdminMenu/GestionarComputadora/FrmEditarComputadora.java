/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion.AdminMenu.GestionarComputadora;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import negocio.DTO.CentroComputoDTO;
import negocio.DTO.ComputadoraDTO;
import negocio.logica.CentroComputoNegocio;
import negocio.logica.ComputadoraNegocio;
import utilerias.LectorIp;
import java.util.OptionalInt;

/**
 * a
 *
 * @hidden
 */
public class FrmEditarComputadora extends javax.swing.JFrame {

    DefaultListModel<String> listModel = new DefaultListModel<>();
    CentroComputoNegocio centroComputoNegocio = new CentroComputoNegocio();
    List<CentroComputoDTO> centros = new ArrayList<>();
    CentroComputoDTO centro = new CentroComputoDTO();
    ComputadoraNegocio computadoraNegocio = new ComputadoraNegocio();
    ComputadoraDTO computadora = new ComputadoraDTO();

    /**
     * Creates new form FrmAgregarComputadora
     */
    int softwareCounter = 0;
    List<String> software = new ArrayList<>();
    int numMaquina;

    /**
     * Constructor que inicializa los parametros computadora de tipo
     * ComputadoraDTO
     *
     * @param computadora
     */
    public FrmEditarComputadora(ComputadoraDTO computadora) {
        initComponents();
        this.computadora = computadora;
        centros = centroComputoNegocio.buscarCentrosComputos();
        llenarBoxCentros(centros);
        campoTextoNumeroMaquina.setText(computadora.getNumComputadora() + "");
        campoTextoNumeroMaquina.disable();

        campoTextoIP.setText(computadora.getIp());
        checkAdmin.setSelected(computadora.isEsAdmin());



        
                

    }

    /**
     * Agrega los nombres de los centros de cómputo presentes en la lista
     * proporcionada al combo box `boxCentroComputo`.
     *
     * @param CentroComputo Lista de objetos `CentroComputoDTO` que contiene la
     * información de los centros de cómputo disponibles en el sistema.
     */
    private void llenarBoxCentros(List<CentroComputoDTO> CentroComputo) {
        int i = 0;
        while (CentroComputo.size() > i) {
            boxCentroComputo.addItem(CentroComputo.get(i).getNombre());
            i++;
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

        checkAdmin1 = new javax.swing.JCheckBox();
        Titulo = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        campoTextoIP = new javax.swing.JTextField();
        lblNumMaquina = new javax.swing.JLabel();
        campoTextoNumeroMaquina = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        checkAdmin = new javax.swing.JCheckBox();
        btnSoftware = new javax.swing.JButton();
        fldSoftware = new javax.swing.JTextField();
        lblSoftware = new javax.swing.JLabel();
        lblSoftware1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listSoftware = new javax.swing.JList<>();
        btnAgregarIP = new javax.swing.JButton();
        lblSoftware2 = new javax.swing.JLabel();
        boxCentroComputo = new javax.swing.JComboBox<>();
        fondo = new javax.swing.JLabel();

        checkAdmin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkAdmin1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Titulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        Titulo.setForeground(new java.awt.Color(255, 255, 255));
        Titulo.setText("Editar Computadora");
        getContentPane().add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, -1, -1));

        btnAgregar.setBackground(new java.awt.Color(0, 204, 0));
        btnAgregar.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 550, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("IP");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));
        getContentPane().add(campoTextoIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 270, 30));

        lblNumMaquina.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNumMaquina.setForeground(new java.awt.Color(255, 255, 255));
        lblNumMaquina.setText("Numero de maquina");
        getContentPane().add(lblNumMaquina, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));
        getContentPane().add(campoTextoNumeroMaquina, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 270, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Admin");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, -1, -1));

        checkAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkAdminActionPerformed(evt);
            }
        });
        getContentPane().add(checkAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 30, 30));

        btnSoftware.setText("Agregar otro Software");
        btnSoftware.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSoftwareActionPerformed(evt);
            }
        });
        getContentPane().add(btnSoftware, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 190, 20));
        getContentPane().add(fldSoftware, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 270, 30));

        lblSoftware.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSoftware.setForeground(new java.awt.Color(255, 255, 255));
        lblSoftware.setText("Software");
        getContentPane().add(lblSoftware, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, -1, -1));

        lblSoftware1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSoftware1.setForeground(new java.awt.Color(255, 255, 255));
        lblSoftware1.setText("Centro de Cómputo");
        getContentPane().add(lblSoftware1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 450, -1, -1));

        jScrollPane1.setViewportView(listSoftware);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 270, 70));

        btnAgregarIP.setText("Conseguir Ip de esta computadora");
        btnAgregarIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarIPActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregarIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 93, 250, 20));

        lblSoftware2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSoftware2.setForeground(new java.awt.Color(255, 255, 255));
        lblSoftware2.setText("Software a agregar");
        getContentPane().add(lblSoftware2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, -1, -1));

        boxCentroComputo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxCentroComputoActionPerformed(evt);
            }
        });
        getContentPane().add(boxCentroComputo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, 270, 40));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgroundChico.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        String ip = campoTextoIP.getText();
        int numMaquina = Integer.parseInt(campoTextoNumeroMaquina.getText());
        Boolean esAdmin = checkAdmin.isSelected();

        if (esAdmin) {

            try {
                ComputadoraNegocio computadoraNegocio = new ComputadoraNegocio();

                computadora.setIp(ip);
                computadora.setEsAdmin(esAdmin);
                computadora.setSoftware(software);
                computadora.setCentroComputo(centro);

                computadoraNegocio.modificarComputadora(computadora);
                JOptionPane.showMessageDialog(this, "La computadora se ha modificado correctamente.", "Aviso", JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Ha ocurrido un error inesperado: \n" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        } else {

            try {
                ComputadoraNegocio computadoraNegocio = new ComputadoraNegocio();

                computadora.setIp(ip);
                computadora.setEsAdmin(esAdmin);
                computadora.setSoftware(software);
                computadora.setNumComputadora(numMaquina);
                computadora.setCentroComputo(centro);

                computadoraNegocio.guardarComputadora(computadora);
                JOptionPane.showMessageDialog(this, "La computadora se ha modificado correctamente.", "Aviso", JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Ha ocurrido un error inesperado: \n" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void checkAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkAdminActionPerformed
        // TODO add your handling code here:
        if (checkAdmin.isSelected()) {
            campoTextoNumeroMaquina.setVisible(false);
            lblNumMaquina.setVisible(false);
        } else {

            campoTextoNumeroMaquina.setVisible(true);
            lblNumMaquina.setVisible(true);

        }

    }//GEN-LAST:event_checkAdminActionPerformed

    private void checkAdmin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkAdmin1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkAdmin1ActionPerformed

    private void btnSoftwareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSoftwareActionPerformed
        // TODO add your handling code here:
        listSoftware.setModel(listModel);
        listModel.add(softwareCounter, fldSoftware.getText());
        listModel.setSize(softwareCounter);
        this.software.add(fldSoftware.getText());
        fldSoftware.setText("");
        softwareCounter++;

    }//GEN-LAST:event_btnSoftwareActionPerformed

    private void btnAgregarIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarIPActionPerformed
        // TODO add your handling code here:
        LectorIp lector = new LectorIp();
        campoTextoIP.setText(lector.getLocalIPAddress());
    }//GEN-LAST:event_btnAgregarIPActionPerformed

    private void boxCentroComputoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxCentroComputoActionPerformed
        // TODO add your handling code here:
        this.centro = centros.get(boxCentroComputo.getSelectedIndex());

    }//GEN-LAST:event_boxCentroComputoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private javax.swing.JComboBox<String> boxCentroComputo;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregarIP;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSoftware;
    private javax.swing.JTextField campoTextoIP;
    private javax.swing.JTextField campoTextoNumeroMaquina;
    private javax.swing.JCheckBox checkAdmin;
    private javax.swing.JCheckBox checkAdmin1;
    private javax.swing.JTextField fldSoftware;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNumMaquina;
    private javax.swing.JLabel lblSoftware;
    private javax.swing.JLabel lblSoftware1;
    private javax.swing.JLabel lblSoftware2;
    private javax.swing.JList<String> listSoftware;
    // End of variables declaration//GEN-END:variables
}
