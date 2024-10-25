/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.logica;

import negocio.DTO.ApartadoDTO;
import negocio.DTO.EstudianteDTO;
import persistencia.entidades.ApartadoEntidad;

/**
 *
 * @author santi
 */
public class ApartadoNegocio {

    public ApartadoNegocio() {
    }
    
    public ApartadoEntidad convertirAEntidad(ApartadoDTO apartadoDTO){
    
        ApartadoEntidad apartadoE = new ApartadoEntidad();
        
        apartadoE.setId(apartadoDTO.getId());
        apartadoE.setFechaFin(apartadoDTO.getFechaFin());
        apartadoE.setFechaInicio(apartadoDTO.getFechaInicio());
        EstudianteDTO e = new EstudianteDTO();
        e.set
        apartadoE.setEstudiante(apartadoDTO.getEstudiante());
        apartadoE.setComputadora(apartadoDTO.getComputadora());
        
        return apartadoE;
    }
    
    public ApartadoDTO convertirADTO(ApartadoEntidad apartadoEntidad){
    
        ApartadoDTO apartadoD = new ApartadoDTO();
        apartadoD.setId(apartadoEntidad.getId());
        apartadoD.set
        
    }
    
}
