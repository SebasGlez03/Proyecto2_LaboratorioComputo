/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia.Interfaces;

import java.util.List;
import persistencia.entidades.UnidadAcademicaEntidad;

/**
 *
 * @author santi
 */
public interface IUnidadAcademicaDAO {
    
    public void guardarUnidadAcademica(UnidadAcademicaEntidad unidadAcademica);
    
    public void eliminarUnidadAcademica(UnidadAcademicaEntidad unidadAcademica);
    
    public void modificarUnidadAcademica(UnidadAcademicaEntidad unidadAcademica);
    
    public UnidadAcademicaEntidad buscarUnaUnidadAcademica(Long id);
    
    public List<UnidadAcademicaEntidad> buscarTodasUnidadAcademica();
    
}
