/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.DTO;

import java.util.Calendar;
import persistencia.entidades.CentroComputoEntidad;

/**
 *
 * @author santi
 */
/**
 * Clase DTO (Data Transfer Object) para representar un Centro de Cómputo.
 * Esta clase contiene los datos básicos de un centro de cómputo, tales como
 * su nombre, contraseña maestra, horas de servicio y la unidad académica asociada.
 */
public class CentroComputoDTO {

    /** Identificador único del centro de cómputo */
    Long id;

    /** Nombre del centro de cómputo */
    String nombre;

    /** Contraseña maestra para el centro de cómputo */
    String contraseniaMaestra;

    /** Hora de inicio de servicio del centro de cómputo */
    Calendar horaInicioServicio;

    /** Hora de fin de servicio del centro de cómputo */
    Calendar horaFinServicio;

    /** Unidad académica asociada al centro de cómputo */
    UnidadAcademicaDTO unidad;

    /**
     * Constructor por defecto
     */
    public CentroComputoDTO() {
    }

    /**
     * Constructor completo
     * 
     * @param id Identificador único del centro de cómputo
     * @param nombre Nombre del centro de cómputo
     * @param contraseniaMaestra Contraseña maestra para el centro de cómputo
     * @param horaInicioServicio Hora de inicio de servicio
     * @param horaFinServicio Hora de fin de servicio
     * @param unidad Unidad académica asociada
     */
    public CentroComputoDTO(Long id, String nombre, String contraseniaMaestra, Calendar horaInicioServicio, Calendar horaFinServicio, UnidadAcademicaDTO unidad) {
        this.id = id;
        this.nombre = nombre;
        this.contraseniaMaestra = contraseniaMaestra;
        this.horaInicioServicio = horaInicioServicio;
        this.horaFinServicio = horaFinServicio;
        this.unidad = unidad;
    }

    /**
     * Constructor que convierte una entidad CentroComputoEntidad en un DTO.
     * 
     * @param ccE Entidad de tipo CentroComputoEntidad
     */
    public CentroComputoDTO(CentroComputoEntidad ccE){
        this.id = ccE.getId();
        this.nombre = ccE.getNombre();
        this.contraseniaMaestra = ccE.getContraseniaMaestra();
        this.horaInicioServicio = ccE.getHoraInicioServicio();
        this.horaFinServicio = ccE.getHoraFinServicio();
        UnidadAcademicaDTO unidad = new UnidadAcademicaDTO(ccE.getUnidadAcademica());
        this.unidad = unidad;
    }

    /**
     * Obtiene el identificador único del centro de cómputo
     * 
     * @return id Identificador del centro de cómputo
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único del centro de cómputo
     * 
     * @param id Identificador del centro de cómputo
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del centro de cómputo
     * 
     * @return nombre Nombre del centro de cómputo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del centro de cómputo
     * 
     * @param nombre Nombre del centro de cómputo
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la contraseña maestra del centro de cómputo
     * 
     * @return contraseniaMaestra Contraseña maestra
     */
    public String getContraseniaMaestra() {
        return contraseniaMaestra;
    }

    /**
     * Establece la contraseña maestra del centro de cómputo
     * 
     * @param contraseniaMaestra Contraseña maestra
     */
    public void setContraseniaMaestra(String contraseniaMaestra) {
        this.contraseniaMaestra = contraseniaMaestra;
    }

    /**
     * Obtiene la hora de inicio de servicio
     * 
     * @return horaInicioServicio Hora de inicio de servicio
     */
    public Calendar getHoraInicioServicio() {
        return horaInicioServicio;
    }

    /**
     * Establece la hora de inicio de servicio
     * 
     * @param horaInicioServicio Hora de inicio de servicio
     */
    public void setHoraInicioServicio(Calendar horaInicioServicio) {
        this.horaInicioServicio = horaInicioServicio;
    }

    /**
     * Obtiene la hora de fin de servicio
     * 
     * @return horaFinServicio Hora de fin de servicio
     */
    public Calendar getHoraFinServicio() {
        return horaFinServicio;
    }

    /**
     * Establece la hora de fin de servicio
     * 
     * @param horaFinServicio Hora de fin de servicio
     */
    public void setHoraFinServicio(Calendar horaFinServicio) {
        this.horaFinServicio = horaFinServicio;
    }

    /**
     * Obtiene la unidad académica asociada al centro de cómputo
     * 
     * @return unidad Unidad académica
     */
    public UnidadAcademicaDTO getUnidad() {
        return unidad;
    }

    /**
     * Establece la unidad académica asociada al centro de cómputo
     * 
     * @param unidad Unidad académica
     */
    public void setUnidad(UnidadAcademicaDTO unidad) {
        this.unidad = unidad;
    }

    /**
     * Método toString para representar el objeto en formato de texto
     * 
     * @return Cadena de texto con los valores de los atributos del centro de cómputo
     */
    @Override
    public String toString() {
        return "CentroComputoDTO{" + "id=" + id + ", nombre=" + nombre + ", contraseniaMaestra=" + contraseniaMaestra + ", horaInicioServicio=" + horaInicioServicio + ", horaFinServicio=" + horaFinServicio + ", unidad=" + unidad + '}';
    }
}
