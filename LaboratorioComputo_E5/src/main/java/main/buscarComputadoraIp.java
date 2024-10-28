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
 * @author santiago
 */
public class BuscarComputadoraIp {

    
        ComputadoraNegocio computadoraNegocio = new ComputadoraNegocio();
    ComputadoraDTO computadoraUsuario = new ComputadoraDTO();
    LectorIp lector = new LectorIp();
    
    public void buscarComputadoraPorIP(){
    
        String ip;
        ip = lector.getLocalIPAddress();
        System.out.println(ip);
        if (computadoraNegocio.buscarComputadorasPorIP(ip).isEmpty()){

           JOptionPane.showMessageDialog(new JFrame(), "Esta computadora no es parte del sistema" ); 
           
            
        }else
        {
            
            this.computadoraUsuario = computadoraNegocio.buscarComputadorasPorIP(ip).getFirst();  
                    if(computadoraUsuario.isEsAdmin()){
        FrmLogin frm = new FrmLogin();
        frm.setVisible(true);
        }
        else{
        
            FrmComputadora frm = new FrmComputadora(computadoraUsuario);
            frm.setVisible(true);
            }
        }
    }
}

        
        
    
    

    
