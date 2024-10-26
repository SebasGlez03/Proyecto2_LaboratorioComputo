/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import persistencia.entidades.CarreraEntidad;
import persistencia.entidades.EstudianteEntidad;

/**
 * CarreraDTO representa el DTO (Data Transfer Object) para las carreras en un sistema académico.
 * Esta clase contiene información sobre la carrera, como su nombre, tiempo asignado diariamente
 * y la lista de estudiantes inscritos.
 * 
 * Un DTO es utilizado para transferir datos entre capas sin exponer las entidades directamente.
 * 
 * @author santi
 */
public class CarreraDTO {

    /**
     * Identificador único de la carrera.
     */
    Long id;

    /**
     * Nombre de la carrera.
     */
    String nombre;

    /**
     * Tiempo diario asignado a la carrera (por ejemplo, horas de clase).
     */
    Date tiempoDiario;

    /**
     * Lista de estudiantes inscritos en la carrera.
     */
    List<EstudianteDTO> estudiantes;

    /**
     * Constructor vacío para inicializar un objeto CarreraDTO sin datos predefinidos.
     */
    public CarreraDTO() {
    }

    /**
     * Constructor que inicializa un objeto CarreraDTO con los valores proporcionados.
     * 
     * @param id El identificador único de la carrera.
     * @param nombre El nombre de la carrera.
     * @param tiempoDiario El tiempo diario asignado a la carrera.
     * @param estudiantes La lista de estudiantes inscritos en la carrera.
     */
    public CarreraDTO(Long id, String nombre, Date tiempoDiario, List<EstudianteDTO> estudiantes) {
        this.id = id;
        this.nombre = nombre;
        this.tiempoDiario = tiempoDiario;
        this.estudiantes = estudiantes;
    }

    /**
     * Constructor que crea un CarreraDTO a partir de una entidad CarreraEntidad.
     * 
     * @param c La entidad CarreraEntidad de la cual se extraen los datos.
     */
    public CarreraDTO(CarreraEntidad c) {
        this.id = c.getIdCarrera();
        this.nombre = c.getNombre();
        this.tiempoDiario = c.getTiempoDiario();
        
        List<EstudianteDTO> estudiantes = new ArrayList<>();
        
        for (EstudianteEntidad y : c.getEstudiante()) {
            EstudianteDTO x = new EstudianteDTO(y);
            estudiantes.add(x);
        }
        
        this.estudiantes = estudiantes;
    }

    /**
     * Obtiene el identificador único de la carrera.
     * 
     * @return El identificador de la carrera.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único de la carrera.
     * 
     * @param id El identificador de la carrera.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la carrera.
     * 
     * @return El nombre de la carrera.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la carrera.
     * 
     * @param nombre El nombre de la carrera.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el tiempo diario asignado a la carrera.
     * 
     * @return El tiempo diario asignado a la carrera.
     */
    public Date getTiempoDiario() {
        return tiempoDiario;
    }

    /**
     * Establece el tiempo diario asignado a la carrera.
     * 
     * @param tiempoDiario El nuevo tiempo diario de la carrera.
     */
    public void setTiempoDiario(Date tiempoDiario) {
        this.tiempoDiario = tiempoDiario;
    }

    /**
     * Obtiene la lista de estudiantes inscritos en la carrera.
     * 
     * @return La lista de estudiantes.
     */
    public List<EstudianteDTO> getEstudiantes() {
        return estudiantes;
    }

    /**
     * Establece la lista de estudiantes inscritos en la carrera.
     * 
     * @param estudiantes La nueva lista de estudiantes inscritos.
     */
    public void setEstudiantes(List<EstudianteDTO> estudiantes) {
        this.estudiantes = estudiantes;
    }

    /**
     * Retorna una representación en cadena de caracteres del objeto CarreraDTO.
     * 
     * @return Una cadena de caracteres que contiene los datos de la carrera.
     */
    @Override
    public String toString() {
        return "CarreraDTO{" + "id=" + id + ", nombre=" + nombre + ", tiempoDiario=" + tiempoDiario + ", estudiantes=" + estudiantes + '}';
    }
}
