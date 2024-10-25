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
public interface IRentaDAO {
    
    public void guardarRenta(ApartadoEntidad renta);
    
    public void eliminarRenta(ApartadoEntidad renta);
    
    public void modificarRenta(ApartadoEntidad renta);
    
    public ApartadoEntidad buscarUnaRenta(Long id);
    
    public List<ApartadoEntidad> buscarTodasRenta();
    
}
