/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.logica;

import java.util.ArrayList;
import java.util.List;
import negocio.DTO.ApartadoDTO;
import negocio.DTO.BloqueoDTO;
import negocio.DTO.ComputadoraDTO;
import negocio.DTO.EstudianteDTO;
import persistencia.entidades.ApartadoEntidad;
import persistencia.entidades.BloqueoEntidad;
import persistencia.entidades.ComputadoraEntidad;
import persistencia.entidades.EstudianteEntidad;

/**
 *
 * @author santi
 */
public class EstudianteNegocio {

    public EstudianteNegocio() {
    }
    
    public EstudianteEntidad convertir(EstudianteDTO dto){
    
        BloqueoNegocio bN = new BloqueoNegocio();
        CarreraNegocio caN = new CarreraNegocio();
        ApartadoNegocio aN = new ApartadoNegocio();
        ComputadoraNegocio cN = new ComputadoraNegocio();
        EstudianteEntidad entidad = new EstudianteEntidad();
        
        entidad.setId(dto.getId());
        entidad.setNombre(dto.getNombre());
        entidad.setApellidoMaterno(dto.getApellidoMaterno());
        entidad.setApellidoPaterno(dto.getApellidoPaterno());
        entidad.setEstatusInscripcion(dto.getEstatusInscripcion());
        entidad.setContrasenia(dto.getContrasenia());
        entidad.setComputadora(cN.convertir(dto.getComputadora()));
        
        List<ApartadoEntidad> apartados = new ArrayList<>();
        for (ApartadoDTO y : dto.getApartados()){
            ApartadoEntidad x = aN.convertir(y);
            apartados.add(x);
        }
        
        List<BloqueoEntidad> bloqueos = new ArrayList<>();
        for (BloqueoDTO y : dto.getBloqueos()){
            BloqueoEntidad x = bN.convertir(y);
            bloqueos.add(x);
        }
        
        entidad.setBloqueo(bloqueos);
        entidad.setApartado(apartados);
        
        entidad.setCarrera(caN.convertir(dto.getCarrera()));
             
        return entidad;
        
    }
}
