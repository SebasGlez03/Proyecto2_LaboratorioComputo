/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.logica;

import java.util.ArrayList;
import java.util.List;
import negocio.DTO.CarreraDTO;
import negocio.DTO.EstudianteDTO;
import persistencia.DAO.CarreraDAO;
import persistencia.entidades.CarreraEntidad;
import persistencia.entidades.EstudianteEntidad;

/**
 *
 * @author santi
 */
public class CarreraNegocio {

    CarreraDAO carreraDAO;
    
    public CarreraNegocio() {
        
        CarreraDAO carreraDAO = new CarreraDAO(); 
        this.carreraDAO = carreraDAO;
        
    }
    
    public CarreraEntidad convertir(CarreraDTO dto){
    
        EstudianteNegocio eN = new EstudianteNegocio();
        CarreraEntidad entidad = new CarreraEntidad();
        
        entidad.setIdCarrera(dto.getId());
        entidad.setNombre(dto.getNombre());
        entidad.setTiempoDiario(dto.getTiempoDiario());
        
        List<EstudianteEntidad> estudiantes = new ArrayList<>();
        for (EstudianteDTO y : dto.getEstudiantes()){
            EstudianteEntidad x = eN.convertir(y);
            estudiantes.add(x);
        }
        
        entidad.setEstudiante(estudiantes);
        
        return entidad;
        
    }
    
    public void guardarCarrera(CarreraDTO c){
        
        carreraDAO.guardarCarrera(convertir(c));
        
    }
    
}
