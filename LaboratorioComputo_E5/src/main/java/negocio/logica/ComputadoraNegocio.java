/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.logica;

import negocio.DTO.ApartadoDTO;
import negocio.DTO.ComputadoraDTO;
import persistencia.entidades.ApartadoEntidad;
import persistencia.entidades.ComputadoraEntidad;

/**
 *
 * @author santi
 */
public class ComputadoraNegocio {

    public ComputadoraNegocio() {
    }
    
    
    public ComputadoraEntidad convertir(ComputadoraDTO dto){
        
        
        EstudianteNegocio eN = new EstudianteNegocio();
        CentroComputoNegocio ccN = new CentroComputoNegocio();
        ComputadoraEntidad computadora = new ComputadoraEntidad();
        
        computadora.setIdComputadora(dto.getId());
        computadora.setIp(dto.getIp());
        computadora.setNumMaquina(dto.getNumComputadora());
        computadora.setEsAdmin(dto.isEsAdmin());
        
        computadora.setEstudiante(eN.convertir(dto.getEstudiante()));
        computadora.setSoftware(dto.getSoftware());
        computadora.setCentroComputoEntidad(ccN.convertir(dto.getCentroComputo()));
        

        
        return computadora;
        
    }
    
}
