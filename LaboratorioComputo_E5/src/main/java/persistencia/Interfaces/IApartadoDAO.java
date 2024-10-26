/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia.Interfaces;

import java.util.List;
import persistencia.entidades.ApartadoEntidad;

/**
 *
 * @author santi
 */
public interface IApartadoDAO {
    
    public void guardarApartado(ApartadoEntidad renta);
    
    public void eliminarApartado(ApartadoEntidad renta);
    
    public void modificarApartado(ApartadoEntidad renta);
    
    public ApartadoEntidad buscarUnApartado(Long id);
    
    public List<ApartadoEntidad> buscarTodosApartados();
    
}
