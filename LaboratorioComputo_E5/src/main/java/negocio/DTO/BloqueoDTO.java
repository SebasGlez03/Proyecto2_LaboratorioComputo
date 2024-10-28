/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit este template
 */
package negocio.DTO;

import java.util.Calendar;
import persistencia.entidades.BloqueoEntidad;

/**
 * BloqueoDTO representa el DTO (Data Transfer Object) para los bloqueos
 * aplicados a los estudiantes en un sistema. Esta clase contiene información
 * sobre el bloqueo, como el motivo, las fechas relacionadas y el estudiante
 * afectado.
 *
 * Un DTO es utilizado para transferir datos entre capas sin exponer las
 * entidades directamente.
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
     * Fecha de liberación del bloqueo.
     */
    Calendar fechaLiberacion;

    /**
     * Estudiante afectado por el bloqueo.
     */
    EstudianteDTO estudiante;

    /**
     * Constructor vacío para inicializar un objeto BloqueoDTO sin datos
     * predefinidos.
     */
    public BloqueoDTO() {
    }

    /**
     * Constructor que inicializa un objeto BloqueoDTO con los valores
     * proporcionados.
     *
     * @param id El identificador único del bloqueo.
     * @param motivo El motivo del bloqueo.
     * @param fechaBloqueo La fecha en la que se aplicó el bloqueo.
     * @param fechaLiberacion La fecha de liberación del bloqueo.
     * @param estudiante El DTO del estudiante afectado.
     */
    public BloqueoDTO(Long id, String motivo, Calendar fechaBloqueo, Calendar fechaLiberacion, EstudianteDTO estudiante) {
        this.id = id;
        this.motivo = motivo;
        this.fechaBloqueo = fechaBloqueo;
        this.fechaLiberacion = fechaLiberacion;
        this.estudiante = estudiante;
    }

    /**
     * Constructor que inicializa un objeto BloqueoDTO con los valores
     * proporcionados
     *
     * @param motivo El motivo del bloqueo.
     * @param fechaBloqueo La fecha en la que se aplico el bloqueo.
     * @param fechaLiberacion La fecha en la que se libero el bloqueo.
     * @param estudiante El DTO del estudiante afectado
     */
    public BloqueoDTO(String motivo, Calendar fechaBloqueo, Calendar fechaLiberacion, EstudianteDTO estudiante) {
        this.motivo = motivo;
        this.fechaBloqueo = fechaBloqueo;
        this.fechaLiberacion = fechaLiberacion;
        this.estudiante = estudiante;
    }

    /**
     * Constructor que convierte una entidad de BloqueoEntidad en un objeto
     * BloqueoDTO.
     *
     * @param b La entidad BloqueoEntidad que contiene los datos del bloqueo.
     */
    public BloqueoDTO(BloqueoEntidad b) {
        this.id = b.getId();
        this.motivo = b.getMotivo();
        this.fechaBloqueo = b.getFechaBloqueo();
        this.fechaLiberacion = b.getFechaLiberacion();
        EstudianteDTO e = new EstudianteDTO(b.getEstudiante());
        this.estudiante = e;
    }

    // Getters y setters
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
     * Obtiene la fecha de liberación del bloqueo.
     *
     * @return La fecha de liberación del bloqueo.
     */
    public Calendar getFechaLiberacion() {
        return fechaLiberacion;
    }

    /**
     * Establece la fecha de liberación del bloqueo.
     *
     * @param fechaLiberacion La nueva fecha de liberación del bloqueo.
     */
    public void setFechaLiberacion(Calendar fechaLiberacion) {
        this.fechaLiberacion = fechaLiberacion;
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
        return "BloqueoDTO{" + "id=" + id + ", motivo=" + motivo + ", fechaBloqueo=" + fechaBloqueo + ", fechaLiberacion=" + fechaLiberacion + ", estudiante=" + estudiante + '}';
    }
}
