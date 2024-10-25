/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.DTO;

import java.util.ArrayList;
import java.util.List;
import persistencia.entidades.CentroComputoEntidad;
import persistencia.entidades.UnidadAcademicaEntidad;

/**
 *
 * @author santi
 */
public class UnidadAcademicaDTO {
    
    Long id;
    String nombre;
    List<CentroComputoDTO> centros;

    public UnidadAcademicaDTO() {
    }

    public UnidadAcademicaDTO(Long id, String nombre, List<CentroComputoDTO> centros) {
        this.id = id;
        this.nombre = nombre;
        this.centros = centros;
    }
    
    public UnidadAcademicaDTO(UnidadAcademicaEntidad uaE){
    
        this.id = uaE.getId();
        this.nombre = uaE.getNombre();
        List<CentroComputoDTO> centros = new ArrayList<>();
        
        for (CentroComputoEntidad centro : uaE.getCentrosComputo()) {
            CentroComputoDTO c = new CentroComputoDTO(centro);
            centros.add(c);
        }
        
        this.centros = centros;
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<CentroComputoDTO> getCentros() {
        return centros;
    }

    public void setCentros(List<CentroComputoDTO> centros) {
        this.centros = centros;
    }

    @Override
    public String toString() {
        return "UnidadAcademicaDTO{" + "id=" + id + ", nombre=" + nombre + ", centros=" + centros + '}';
    }
    
    
}
