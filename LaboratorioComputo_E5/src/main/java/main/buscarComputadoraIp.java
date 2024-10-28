/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import negocio.DTO.ComputadoraDTO;
import negocio.logica.ComputadoraNegocio;
import presentacion.FrmComputadora;
import presentacion.FrmLogin;
import utilerias.LectorIp;

/**
 *
 * Clase `buscarComputadoraIp` que verifica si una computadora con una IP específica está registrada en el sistema,
 * y abre el formulario correspondiente según el perfil del usuario
 * (admin o usuario regular).
 */
public class buscarComputadoraIp {

    // Instancias de clases necesarias para la funcionalidad
    ComputadoraNegocio computadoraNegocio = new ComputadoraNegocio(); // Negocio para gestionar computadoras
    ComputadoraDTO computadoraUsuario = new ComputadoraDTO(); // DTO de la computadora del usuario
    LectorIp lector = new LectorIp(); // Utilidad para obtener la IP local

    /**
     * Método para buscar una computadora en el sistema usando su dirección IP local.
     * Si la computadora existe en el sistema, verifica si el usuario es admin o no
     * y abre el formulario correspondiente.
     */
    public void buscarComputadoraPorIP(){
    
        // Obtener la dirección IP de la computadora local
        String ip;
        ip = lector.getLocalIPAddress();
        System.out.println(ip); // Imprimir la IP para depuración

        // Verificar si la computadora con esa IP está registrada en el sistema
        if (computadoraNegocio.buscarComputadorasPorIP(ip).isEmpty()){

           // Mostrar mensaje si la computadora no está registrada
           JOptionPane.showMessageDialog(new JFrame(), "Esta computadora no es parte del sistema" ); 
           
        } else {
            // Obtener la primera computadora encontrada con la IP
            this.computadoraUsuario = computadoraNegocio.buscarComputadorasPorIP(ip).getFirst();  

            // Verificar si el usuario es admin y abrir el formulario adecuado
            if (computadoraUsuario.isEsAdmin()) {
                FrmLogin frm = new FrmLogin(); // Abrir formulario de inicio de sesión para admin
                frm.setVisible(true);
            } else {
                // Abrir formulario de uso de computadora para usuario regular
                FrmComputadora frm = new FrmComputadora(computadoraUsuario);
                frm.setVisible(true);
            }
        }
    }
}
