/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia.Interfaces;

import java.util.List;
import persistencia.entidades.ComputadoraEntidad;

/**
 *
 * @author santi
 */
public interface IComputadoraDAO {
    
    public void guardarComputadora(ComputadoraEntidad Computadora);
    
    public void eliminarComputadora(ComputadoraEntidad Computadora);
    
    public void modificarComputadora(ComputadoraEntidad Computadora);
    
    public ComputadoraEntidad buscarUnaComputadora(Long id);
    
    public List<ComputadoraEntidad> buscarTodosComputadora();
    
}
