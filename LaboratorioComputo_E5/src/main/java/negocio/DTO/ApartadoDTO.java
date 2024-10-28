/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.DTO;

import java.util.Calendar;
import persistencia.entidades.ApartadoEntidad;
import persistencia.entidades.ComputadoraEntidad;
import persistencia.entidades.EstudianteEntidad;

/**
 * a
 *
 * @hidden
 */
public class ApartadoDTO {

    /**
     * Identificador único del apartado.
     */
    Long id;

    /**
     * Fecha de inicio del apartado.
     */
    int minutosActivo;
    /**
     * Fecha de inicio del apartado.
     */
    Calendar fechaInicio;

    /**
     * Fecha de fin del apartado.
     */
    Calendar fechaFin;

    /**
     * DTO del estudiante que realiza el apartado.
     */
    EstudianteDTO estudiante;

    /**
     * DTO de la computadora asignada para el apartado.
     */
    ComputadoraDTO computadora;

    /**
     * Constructor vacío para inicializar un objeto ApartadoDTO sin datos
     * predefinidos.
     */
    public ApartadoDTO() {
    }

    /**
     * Constructor que inicializa un objeto ApartadoDTO con los valores
     * proporcionados.
     *
     * @param id El identificador único del apartado.
     * @param fechaInicio La fecha de inicio del apartado.
     * @param fechaFin La fecha de fin del apartado.
     * @param estudiante El DTO del estudiante asociado al apartado.
     * @param computadora El DTO de la computadora asignada.
     */
    public ApartadoDTO(Long id, Calendar fechaInicio, Calendar fechaFin, EstudianteDTO estudiante, ComputadoraDTO computadora) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estudiante = estudiante;
        this.computadora = computadora;
    }

    /**
     * Constructor que convierte una entidad de ApartadoEntidad en un objeto
     * ApartadoDTO.
     *
     * @param aE La entidad ApartadoEntidad que contiene los datos del apartado.
     */
    public ApartadoDTO(ApartadoEntidad aE) {
        this.id = aE.getId();
        this.fechaInicio = aE.getFechaInicio();
        this.fechaFin = aE.getFechaFin();
        EstudianteDTO estudiante = new EstudianteDTO(aE.getEstudiante());
        this.estudiante = estudiante;
        ComputadoraDTO computadora = new ComputadoraDTO(aE.getComputadora());
        this.computadora = computadora;
        this.minutosActivo = aE.getMinutosActivo();
    }

    // Getters y setters
    /**
     * Obtiene el identificador único del apartado.
     *
     * @return El identificador del apartado.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único del apartado.
     *
     * @param id El identificador del apartado.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la fecha de inicio del apartado.
     *
     * @return La fecha de inicio del apartado.
     */
    public Calendar getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Establece la fecha de inicio del apartado.
     *
     * @param fechaInicio La nueva fecha de inicio del apartado.
     */
    public void setFechaInicio(Calendar fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Obtiene la fecha de fin del apartado.
     *
     * @return La fecha de fin del apartado.
     */
    public Calendar getFechaFin() {
        return fechaFin;
    }

    /**
     * Establece la fecha de fin del apartado.
     *
     * @param fechaFin La nueva fecha de fin del apartado.
     */
    public void setFechaFin(Calendar fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * Obtiene el DTO del estudiante asociado al apartado.
     *
     * @return El DTO del estudiante.
     */
    public EstudianteDTO getEstudiante() {
        return estudiante;
    }

    /**
     * Establece el DTO del estudiante asociado al apartado.
     *
     * @param estudiante El nuevo DTO del estudiante.
     */
    public void setEstudiante(EstudianteDTO estudiante) {
        this.estudiante = estudiante;
    }

    /**
     * Obtiene el DTO de la computadora asignada al apartado.
     *
     * @return El DTO de la computadora.
     */
    public ComputadoraDTO getComputadora() {
        return computadora;
    }

    /**
     * Establece el DTO de la computadora asignada al apartado.
     *
     * @param computadora El nuevo DTO de la computadora.
     */
    public void setComputadora(ComputadoraDTO computadora) {
        this.computadora = computadora;
    }

    /**
     * Obtiene el DTO de la computadora asignada al apartado.
     *
     * @return El DTO de la computadora.
     */
    public int getMinutosActivo() {
        return minutosActivo;
    }

    /**
     * stablece el DTO de la computadora asignada al apartado.
     *
     * @param minutosActivo minutos activo de la computadora
     */
    public void setMinutosActivo(int minutosActivo) {
        this.minutosActivo = minutosActivo;
    }

    /**
     * Retorna una representación en cadena de caracteres del objeto
     * ApartadoDTO.
     *
     * @return Una cadena de caracteres que contiene los datos del apartado.
     */
    @Override
    public String toString() {
        return "ApartadoDTO{" + "id=" + id + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", estudiante=" + estudiante + ", computadora=" + computadora + '}';
    }

}
