/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.logica;

import negocio.DTO.ApartadoDTO;
import negocio.DTO.BloqueoDTO;
import persistencia.entidades.ApartadoEntidad;
import persistencia.entidades.BloqueoEntidad;

/**
 *
 * @author santi
 */
public class BloqueoNegocio {

    public BloqueoNegocio() {
    }
    
    public BloqueoEntidad convertir(BloqueoDTO dto){
    
        ComputadoraNegocio cN = new ComputadoraNegocio();
        EstudianteNegocio eN = new EstudianteNegocio();
        BloqueoEntidad entidad = new BloqueoEntidad();
        
        entidad.setId(dto.getId());
        entidad.setFechaBloqueo(dto.getFechaBloqueo());
        entidad.setFechaLiberacion(dto.getFechaLiberacion());
        entidad.setMotivo(dto.getMotivo());
        entidad.setEstudiante(eN.convertir(dto.getEstudiante()));
        
        return entidad;
        
    }
}
