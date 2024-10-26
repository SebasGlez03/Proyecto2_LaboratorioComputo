/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.logica;

import java.util.ArrayList;
import java.util.List;
import negocio.DTO.ApartadoDTO;
import negocio.DTO.BloqueoDTO;
import negocio.DTO.CentroComputoDTO;
import negocio.DTO.EstudianteDTO;
import negocio.DTO.UnidadAcademicaDTO;
import persistencia.DAO.CentroComputoDAO;
import persistencia.entidades.ApartadoEntidad;
import persistencia.entidades.BloqueoEntidad;
import persistencia.entidades.CentroComputoEntidad;
import persistencia.entidades.ComputadoraEntidad;
import persistencia.entidades.EstudianteEntidad;

/**
 *
 * @author santi
 */
public class CentroComputoNegocio {

    CentroComputoDAO centroComputoDAO;
    
    public CentroComputoNegocio() {
        
        CentroComputoDAO centroComputoDAO = new CentroComputoDAO();
        this.centroComputoDAO = centroComputoDAO;
        
    }
    
    public CentroComputoEntidad convertir(CentroComputoDTO dto){
    

        UnidadAcademicaNegocio uaE = new UnidadAcademicaNegocio();
        CentroComputoEntidad entidad = new CentroComputoEntidad();
        
        entidad.setId(dto.getId());
        entidad.setNombre(dto.getNombre());
        entidad.setContraseniaMaestra(dto.getContraseniaMaestra());
        entidad.setHoraInicioServicio(dto.getHoraInicioServicio());
        entidad.setHoraFinServicio(dto.getHoraFinServicio());
        entidad.setUnidadAcademica(uaE.convertir(dto.getUnidad()));

        return entidad;
        
    }
    
    public void guardarCentroComputo(CentroComputoDTO cCD){
        
        centroComputoDAO.guardarCentroComputo(convertir(cCD));
        
    }
    
}
