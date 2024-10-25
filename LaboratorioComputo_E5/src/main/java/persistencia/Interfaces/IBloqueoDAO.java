package persistencia.Interfaces;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */


import persistencia.entidades.BloqueoEntidad;
import java.util.List;

/**
 *
 * @author santi
 */
public interface IBloqueoDAO {
    
    public void guardarBloqueo(BloqueoEntidad bloqueo);
    
    public void eliminarBloqueo(BloqueoEntidad bloqueo);
    
    public void modificarBloqueo(BloqueoEntidad bloqueo);
    
    public BloqueoEntidad buscarUnBloqueo(Long id);
    
    public List<BloqueoEntidad> buscarTodosBloqueos();
    
    
    
}
