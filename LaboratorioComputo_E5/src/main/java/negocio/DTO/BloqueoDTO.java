/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit este template
 */
package negocio.DTO;

import java.util.Calendar;

/**
 * BloqueoDTO representa el DTO (Data Transfer Object) para los bloqueos aplicados a los estudiantes
 * en un sistema. Esta clase contiene información sobre el bloqueo, como el motivo, las fechas
 * relacionadas y el estudiante afectado.
 * 
 * Un DTO es utilizado para transferir datos entre capas sin exponer las entidades directamente.
 * 
 * @author santi
 */
public class BloqueoDTO {

    /**
     * Identificador único del bloqueo.
     */
    Long id;

    /**
     * Motivo del bloqueo aplicado al estudiante.
     */
    String motivo;

    /**
     * Fecha en la que se aplicó el bloqueo.
     */
    Calendar fechaBloqueo;

    /**
     * Fecha de inicio de la condición que llevó al bloqueo.
     */
    Calendar fechaInicio;

    /**
     * Estudiante afectado por el bloqueo.
     */
    EstudianteDTO estudiante;

    /**
     * Constructor vacío para inicializar un objeto BloqueoDTO sin datos predefinidos.
     */
    public BloqueoDTO() {
    }

    /**
     * Constructor que inicializa un objeto BloqueoDTO con los valores proporcionados.
     * 
     * @param id El identificador único del bloqueo.
     * @param motivo El motivo del bloqueo.
     * @param fechaBloqueo La fecha en la que se aplicó el bloqueo.
     * @param fechaInicio La fecha de inicio de la condición que llevó al bloqueo.
     * @param estudiante El DTO del estudiante afectado.
     */
    public BloqueoDTO(Long id, String motivo, Calendar fechaBloqueo, Calendar fechaInicio, EstudianteDTO estudiante) {
        this.id = id;
        this.motivo = motivo;
        this.fechaBloqueo = fechaBloqueo;
        this.fechaInicio = fechaInicio;
        this.estudiante = estudiante;
    }

    /**
     * Obtiene el identificador único del bloqueo.
     * 
     * @return El identificador del bloqueo.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único del bloqueo.
     * 
     * @param id El identificador del bloqueo.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el motivo del bloqueo.
     * 
     * @return El motivo del bloqueo.
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * Establece el motivo del bloqueo.
     * 
     * @param motivo El nuevo motivo del bloqueo.
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * Obtiene la fecha en la que se aplicó el bloqueo.
     * 
     * @return La fecha de aplicación del bloqueo.
     */
    public Calendar getFechaBloqueo() {
        return fechaBloqueo;
    }

    /**
     * Establece la fecha en la que se aplicó el bloqueo.
     * 
     * @param fechaBloqueo La nueva fecha de aplicación del bloqueo.
     */
    public void setFechaBloqueo(Calendar fechaBloqueo) {
        this.fechaBloqueo = fechaBloqueo;
    }

    /**
     * Obtiene la fecha de inicio de la condición que llevó al bloqueo.
     * 
     * @return La fecha de inicio de la condición.
     */
    public Calendar getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Establece la fecha de inicio de la condición que llevó al bloqueo.
     * 
     * @param fechaInicio La nueva fecha de inicio de la condición.
     */
    public void setFechaInicio(Calendar fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Obtiene el DTO del estudiante afectado por el bloqueo.
     * 
     * @return El DTO del estudiante.
     */
    public EstudianteDTO getEstudiante() {
        return estudiante;
    }

    /**
     * Establece el DTO del estudiante afectado por el bloqueo.
     * 
     * @param estudiante El nuevo DTO del estudiante.
     */
    public void setEstudiante(EstudianteDTO estudiante) {
        this.estudiante = estudiante;
    }

    /**
     * Retorna una representación en cadena de caracteres del objeto BloqueoDTO.
     * 
     * @return Una cadena de caracteres que contiene los datos del bloqueo.
     */
    @Override
    public String toString() {
        return "BloqueoDTO{" + "id=" + id + ", motivo=" + motivo + ", fechaBloqueo=" + fechaBloqueo + ", fechaInicio=" + fechaInicio + ", estudiante=" + estudiante + '}';
    }
}
