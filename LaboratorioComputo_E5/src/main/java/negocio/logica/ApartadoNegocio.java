/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.logica;

import negocio.DTO.ApartadoDTO;
import negocio.DTO.EstudianteDTO;
import persistencia.DAO.ApartadoDAO;
import persistencia.entidades.ApartadoEntidad;

/**
 *
 * @author santi
 */
public class ApartadoNegocio {

    ApartadoDAO apartadoDAO = null;
    
    public ApartadoNegocio() {
        
        ApartadoDAO apartadoDAO = new ApartadoDAO(); 
        this.apartadoDAO = apartadoDAO;
        
    }
    
    public ApartadoEntidad convertir(ApartadoDTO dto){
    
        ComputadoraNegocio cN = new ComputadoraNegocio();
        EstudianteNegocio eN = new EstudianteNegocio();
        ApartadoEntidad entidad = new ApartadoEntidad();
        
        entidad.setId(dto.getId());
        entidad.setFechaInicio(dto.getFechaInicio());
        entidad.setFechaFin(dto.getFechaFin());
        
        entidad.setComputadora(cN.convertir(dto.getComputadora()));
        entidad.setEstudiante(eN.convertir(dto.getEstudiante()));
        
        return entidad;
        
    }
    
    public void guardarApartado(ApartadoDTO ap){
    
        
        apartadoDAO.guardarApartado(convertir(ap));
        
    }
    
}
