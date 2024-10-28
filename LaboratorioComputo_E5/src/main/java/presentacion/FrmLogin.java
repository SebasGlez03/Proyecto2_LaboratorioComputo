/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import java.util.List;
import javax.swing.JOptionPane;
import negocio.DTO.CentroComputoDTO;
import negocio.DTO.EstudianteDTO;
import negocio.DTO.UnidadAcademicaDTO;
import negocio.logica.CentroComputoNegocio;
import negocio.logica.EstudianteNegocio;
import negocio.logica.UnidadAcademicaNegocio;
import presentacion.AdminMenu.FrmAdminMenu;
import utilerias.CaesarCipher;

/**
 *
 * @author PC
 */
public class FrmLogin extends javax.swing.JFrame {

    /**
     * Creates new form FrmLogin
     */

    @Override
    public void setExtendedState(int state) {
        super.setExtendedState(FrmLogin.MAXIMIZED_BOTH); 
    }
    EstudianteNegocio estudianteNegocio;
    UnidadAcademicaNegocio unidadAcademicaNegocio;
    CentroComputoNegocio centroComputoNegocio;
    Long CentroSeleccionado;
    Long idcC;
    CaesarCipher encriptar = new CaesarCipher();
    
    public FrmLogin() {
        initComponents();
        
        
        EstudianteNegocio estudianteNegocio = new EstudianteNegocio();
        UnidadAcademicaNegocio unidadAcademicaNegocio = new UnidadAcademicaNegocio();
        CentroComputoNegocio centroComputoNegocio = new CentroComputoNegocio();
        
        this.centroComputoNegocio = centroComputoNegocio;
        this.estudianteNegocio = estudianteNegocio;
        this.unidadAcademicaNegocio = unidadAcademicaNegocio;
        
        llenarBoxUnidades(unidadAcademicaNegocio.buscarUnidadAcademica());

        
    }

    private void llenarBoxUnidades(List<UnidadAcademicaDTO> UnidadAcademica) {
        int i = 0;
        while (UnidadAcademica.size() > i) {
            boxUnidadesAcademicas.addItem(UnidadAcademica.get(i).getNombre());
            i++;
        }
    }
    
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

        btnAdmin = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JLabel();
        btnClose = new javax.swing.JLabel();
        txtContrasenia = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        lblCentroComputo = new javax.swing.JLabel();
        boxCentroComputo = new javax.swing.JComboBox<>();
        lblCampus = new javax.swing.JLabel();
        boxUnidadesAcademicas = new javax.swing.JComboBox<>();
        background_img = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Apartado");
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnAdmin.png"))); // NOI18N
        btnAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAdminMouseClicked(evt);
            }
        });
        getContentPane().add(btnAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 640, -1, -1));

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnAceptar_azul.png"))); // NOI18N
        btnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarMouseClicked(evt);
            }
        });
        getContentPane().add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 560, 121, 54));

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnCancelar.png"))); // NOI18N
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 560, 121, 54));

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/close_btn.png"))); // NOI18N
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });
        getContentPane().add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 10, 30, 30));

        txtContrasenia.setBackground(new java.awt.Color(114, 114, 114));
        txtContrasenia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtContrasenia.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 470, 430, 60));

        txtId.setBackground(new java.awt.Color(114, 114, 114));
        txtId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtId.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 330, 430, 60));

        lblCentroComputo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblCentroComputo.setForeground(new java.awt.Color(255, 255, 255));
        lblCentroComputo.setText("Centro Cómputo");
        getContentPane().add(lblCentroComputo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 360, 30));

        boxCentroComputo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxCentroComputoActionPerformed(evt);
            }
        });
        getContentPane().add(boxCentroComputo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 200, 40));

        lblCampus.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblCampus.setForeground(new java.awt.Color(255, 255, 255));
        lblCampus.setText("Campus");
        getContentPane().add(lblCampus, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 150, 50));

        boxUnidadesAcademicas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxUnidadesAcademicasActionPerformed(evt);
            }
        });
        getContentPane().add(boxUnidadesAcademicas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 200, 40));

        background_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_Login.png"))); // NOI18N
        getContentPane().add(background_img, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 750));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        dispose();
    }//GEN-LAST:event_btnCloseMouseClicked

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        System.out.println("boton cancelar click!");
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseClicked
        System.out.println("boton aceptar click!");
        
        EstudianteDTO eD = new EstudianteDTO();
        if (txtId.getText().matches(".*\\D+.*") || txtId.getText().isEmpty())
        {JOptionPane.showMessageDialog(this, "Un ID no puede contener letras, caracteres especiales o estar vacío" );}
        else{
            
        Long id = Long.decode(txtId.getText());
        eD.setId(Long.decode(txtId.getText()));
        eD.setContrasenia(txtContrasenia.getText());
        EstudianteDTO estudiante = estudianteNegocio.buscarEstudiante(id);

        if (estudiante != null)
        {

            if(encriptar.decrypt(estudiante.getContrasenia(), 3).equals(eD.getContrasenia())){
        
            Long idE = estudiante.getId();
            FrmSistemaApartado frm = new FrmSistemaApartado(idcC, idE);
            frm.setVisible(true);
            this.dispose();

            
        } else{

            JOptionPane.showMessageDialog(this, "Contraseña incorrecta" );          
                
            }
        }
        else{
        
            JOptionPane.showMessageDialog(this, "No existe un estudiante con ese ID o contraseña" );
            
        }
        }
               
    }//GEN-LAST:event_btnAceptarMouseClicked

    private void btnAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdminMouseClicked
        new FrmAdminMenu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAdminMouseClicked

    private void boxCentroComputoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxCentroComputoActionPerformed
        // TODO add your handling code here:
        this.idcC = (long) boxCentroComputo.getSelectedIndex() +1 ;
        System.out.println(idcC);

    }//GEN-LAST:event_boxCentroComputoActionPerformed

    private void boxUnidadesAcademicasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxUnidadesAcademicasActionPerformed
       
        Long unidadSeleccionada = (long) boxCentroComputo.getSelectedIndex() + 2;
        llenarBoxCentros(centroComputoNegocio.buscarCentrosComputosPorUnidad(unidadSeleccionada));
        
    }//GEN-LAST:event_boxUnidadesAcademicasActionPerformed

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
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background_img;
    private javax.swing.JComboBox<String> boxCentroComputo;
    private javax.swing.JComboBox<String> boxUnidadesAcademicas;
    private javax.swing.JLabel btnAceptar;
    private javax.swing.JLabel btnAdmin;
    private javax.swing.JLabel btnCancelar;
    private javax.swing.JLabel btnClose;
    private javax.swing.JLabel lblCampus;
    private javax.swing.JLabel lblCentroComputo;
    private javax.swing.JTextField txtContrasenia;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
