/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia.Interfaces;

import java.util.List;
import persistencia.entidades.CarreraEntidad;

/**
 *
 * @author santi
 */
public interface ICarreraDAO {
    
        public void guardarCarrera(CarreraEntidad Carrera);
        
        public void eliminarCarrera(CarreraEntidad Carrera);
        
        public void modificarCarrera(CarreraEntidad Carrera);
        
        public CarreraEntidad buscarUnaCarrera(Long id);
        
        public List<CarreraEntidad> buscarTodasCarrera();
    
}
