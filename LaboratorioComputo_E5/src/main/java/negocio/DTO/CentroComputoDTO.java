/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.DTO;

import java.util.Calendar;

/**
 *
 * @author santi
 */
public class CentroComputoDTO {
    
    Long id;
    String nombre;
    String contraseniaMaestra;
    Calendar horaInicioServicio;
    Calendar horaFinServicio;
    UnidadAcademicaDTO unidad;

    public CentroComputoDTO() {
    }

    public CentroComputoDTO(Long id, String nombre, String contraseniaMaestra, Calendar horaInicioServicio, Calendar horaFinServicio, UnidadAcademicaDTO unidad) {
        this.id = id;
        this.nombre = nombre;
        this.contraseniaMaestra = contraseniaMaestra;
        this.horaInicioServicio = horaInicioServicio;
        this.horaFinServicio = horaFinServicio;
        this.unidad = unidad;
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

    public String getContraseniaMaestra() {
        return contraseniaMaestra;
    }

    public void setContraseniaMaestra(String contraseniaMaestra) {
        this.contraseniaMaestra = contraseniaMaestra;
    }

    public Calendar getHoraInicioServicio() {
        return horaInicioServicio;
    }

    public void setHoraInicioServicio(Calendar horaInicioServicio) {
        this.horaInicioServicio = horaInicioServicio;
    }

    public Calendar getHoraFinServicio() {
        return horaFinServicio;
    }

    public void setHoraFinServicio(Calendar horaFinServicio) {
        this.horaFinServicio = horaFinServicio;
    }

    public UnidadAcademicaDTO getUnidad() {
        return unidad;
    }

    public void setUnidad(UnidadAcademicaDTO unidad) {
        this.unidad = unidad;
    }

    @Override
    public String toString() {
        return "CentroComputoDTO{" + "id=" + id + ", nombre=" + nombre + ", contraseniaMaestra=" + contraseniaMaestra + ", horaInicioServicio=" + horaInicioServicio + ", horaFinServicio=" + horaFinServicio + ", unidad=" + unidad + '}';
    }
    
}
