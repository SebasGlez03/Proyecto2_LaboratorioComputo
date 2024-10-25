/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia.Interfaces;

import java.util.List;
import persistencia.entidades.EstudianteEntidad;

/**
 *
 * @author santi
 */
public interface IEstudianteDAO {
    
    public void guardarEstudiante(EstudianteEntidad estudiante);
    
    public void eliminarEstudiante(EstudianteEntidad estudiante);
    
    public void modificarEstudiante(EstudianteEntidad estudiante);
    
    public EstudianteEntidad buscarUnEstudiante(Long id);
    
    public List<EstudianteEntidad> buscarTodosEstudiante();
    
}
