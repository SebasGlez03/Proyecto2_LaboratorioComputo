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
 * a
 * @hidden
 */
public class UnidadAcademicaDTO {
    
    /** Identificador único de la unidad académica */
    Long id;

    /** Nombre de la unidad académica */
    String nombre;

    /** Lista de centros de cómputo asociados a la unidad académica */
    List<CentroComputoDTO> centros;

    /**
     * Constructor por defecto.
     */
    public UnidadAcademicaDTO() {
    }

    /**
     * Constructor completo que inicializa los atributos de la unidad académica.
     * 
     * @param id Identificador único de la unidad académica
     * @param nombre Nombre de la unidad académica
     * @param centros Lista de centros de cómputo asociados a la unidad académica
     */
    public UnidadAcademicaDTO(Long id, String nombre, List<CentroComputoDTO> centros) {
        this.id = id;
        this.nombre = nombre;
        this.centros = centros;
    }
    
    /**
     * Constructor que convierte una entidad UnidadAcademicaEntidad en un DTO.
     * 
     * @param uaE Entidad de tipo UnidadAcademicaEntidad
     */
    public UnidadAcademicaDTO(UnidadAcademicaEntidad uaE){
        this.id = uaE.getId();
        this.nombre = uaE.getNombre();
        
        // Convertir los centros de cómputo de la entidad en una lista de DTOs
//        List<CentroComputoDTO> centros = new ArrayList<>();
//        for (CentroComputoEntidad centro : uaE.getCentrosComputo()) {
//            CentroComputoDTO c = new CentroComputoDTO(centro);
//            centros.add(c);
//        }
//        
//        this.centros = centros;
        this.centros = null;
    }

    /**
     * Obtiene el identificador único de la unidad académica.
     * 
     * @return id Identificador de la unidad académica
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único de la unidad académica.
     * 
     * @param id Identificador de la unidad académica
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la unidad académica.
     * 
     * @return nombre Nombre de la unidad académica
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la unidad académica.
     * 
     * @param nombre Nombre de la unidad académica
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la lista de centros de cómputo asociados a la unidad académica.
     * 
     * @return centros Lista de centros de cómputo
     */
    public List<CentroComputoDTO> getCentros() {
        return centros;
    }

    /**
     * Establece la lista de centros de cómputo asociados a la unidad académica.
     * 
     * @param centros Lista de centros de cómputo
     */
    public void setCentros(List<CentroComputoDTO> centros) {
        this.centros = centros;
    }

    /**
     * Método toString para representar el objeto en formato de texto.
     * 
     * @return Cadena de texto con los valores de los atributos de la unidad académica
     */
    @Override
    public String toString() {
        return "UnidadAcademicaDTO{" + "id=" + id + ", nombre=" + nombre + ", centros=" + centros + '}';
    }
}

