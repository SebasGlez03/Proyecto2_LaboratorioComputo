/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia.Interfaces;

import java.util.List;
import persistencia.entidades.CentroComputoEntidad;

/**
 *
 * @author santi
 */
public interface ICentroComputoDAO {
    
    public void guardarCentroComputo(CentroComputoEntidad CentroComputo);
        
    public void eliminarCentroComputo(CentroComputoEntidad CentroComputo);
    
    public void modificarCentroComputo(CentroComputoEntidad CentroComputo);
    
    public CentroComputoEntidad buscarUnCentroComputo(Long id);
    
    public List<CentroComputoEntidad> buscarTodosCentroComputo();
    
}
