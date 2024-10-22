/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * La clase {@code centroComputoEntidad} representa un centro de cómputo en la base de datos.
 * Se almacena información como el nombre, las horas de servicio, una contraseña maestra y 
 * una lista de computadoras asociadas a este centro de cómputo.
 * 
 * Esta entidad está mapeada a la tabla "tblCentroComputo" en la base de datos.
 * 
 * @author santi
 */
@Entity
@Table(name = "tblCentroComputo")
public class centroComputoEntidad implements Serializable {

    /**
     * El identificador único del centro de cómputo.
     * Es generado automáticamente en la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCentroComputo;
    
    /**
     * Lista de computadoras que pertenecen a este centro de cómputo.
     * La relación es de uno a muchos (OneToMany) con la entidad {@link computadoraEntidad}.
     * La operación de persistencia se hace en cascada (CascadeType.PERSIST).
     */
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idComputadora", nullable = false)
    private List<computadoraEntidad> computadoraEntidad;    

    /**
     * El nombre del centro de cómputo.
     * Debe tener una longitud máxima de 50 caracteres y no puede ser nulo.
     */
    @Column(name = "Nombre", length = 50, nullable = false)
    private String nombre;

    /**
     * La hora de inicio de servicio del centro de cómputo.
     * Debe ser una fecha válida y no puede ser nula.
     */
    @Column(name = "HoraInicioServicio", nullable = false)
    private Date horaInicioServicio;

    /**
     * La hora de fin de servicio del centro de cómputo.
     * Debe ser una fecha válida y no puede ser nula.
     */
    @Column(name = "HoraFinServicio", nullable = false)
    private Date horaFinServicio;
    
    /**
     * La contraseña maestra utilizada para desbloquear computadoras en el centro de cómputo.
     * Debe tener una longitud máxima de 50 caracteres y no puede ser nula.
     */
    @Column(name = "ContraseñaMaestra", length = 50, nullable = false)
    private String contraseñaMaestra;
    
    /**
     * Constructor vacío necesario para JPA.
     */
    public centroComputoEntidad() {
    }

    // Getters y Setters

    /**
     * Obtiene el identificador del centro de cómputo.
     * 
     * @return idCentroComputo El identificador del centro de cómputo.
     */
    public Long getIdCentroComputo() {
        return idCentroComputo;
    }

    /**
     * Establece el identificador del centro de cómputo.
     * 
     * @param idCentroComputo El identificador a establecer.
     */
    public void setIdCentroComputo(Long idCentroComputo) {
        this.idCentroComputo = idCentroComputo;
    }

    /**
     * Obtiene la lista de computadoras asociadas al centro de cómputo.
     * 
     * @return La lista de {@link computadoraEntidad}.
     */
    public List<computadoraEntidad> getComputadoraEntidad() {
        return computadoraEntidad;
    }

    /**
     * Establece la lista de computadoras para el centro de cómputo.
     * 
     * @param computadoraEntidad La lista de computadoras a asociar.
     */
    public void setComputadoraEntidad(List<computadoraEntidad> computadoraEntidad) {
        this.computadoraEntidad = computadoraEntidad;
    }

    /**
     * Obtiene el nombre del centro de cómputo.
     * 
     * @return El nombre del centro de cómputo.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del centro de cómputo.
     * 
     * @param nombre El nombre a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la hora de inicio del servicio del centro de cómputo.
     * 
     * @return La hora de inicio de servicio.
     */
    public Date getHoraInicioServicio() {
        return horaInicioServicio;
    }

    /**
     * Establece la hora de inicio del servicio del centro de cómputo.
     * 
     * @param horaInicioServicio La hora de inicio de servicio a establecer.
     */
    public void setHoraInicioServicio(Date horaInicioServicio) {
        this.horaInicioServicio = horaInicioServicio;
    }

    /**
     * Obtiene la hora de fin del servicio del centro de cómputo.
     * 
     * @return La hora de fin de servicio.
     */
    public Date getHoraFinServicio() {
        return horaFinServicio;
    }

    /**
     * Establece la hora de fin del servicio del centro de cómputo.
     * 
     * @param horaFinServicio La hora de fin de servicio a establecer.
     */
    public void setHoraFinServicio(Date horaFinServicio) {
        this.horaFinServicio = horaFinServicio;
    }

    /**
     * Obtiene la contraseña maestra del centro de cómputo.
     * 
     * @return La contraseña maestra.
     */
    public String getContraseñaMaestra() {
        return contraseñaMaestra;
    }

    /**
     * Establece la contraseña maestra del centro de cómputo.
     * 
     * @param contraseñaMaestra La contraseña a establecer.
     */
    public void setContraseñaMaestra(String contraseñaMaestra) {
        this.contraseñaMaestra = contraseñaMaestra;
    }

    /**
     * Retorna una representación en cadena de la entidad {@code centroComputoEntidad}.
     * 
     * @return Una cadena que representa el centro de cómputo.
     */
    @Override
    public String toString() {
        return "centroComputoEntidad{" + "idCentroComputo=" + idCentroComputo + ", computadoraEntidad=" + computadoraEntidad + ", nombre=" + nombre + ", horaInicioServicio=" + horaInicioServicio + ", horaFinServicio=" + horaFinServicio + ", contraseñaMaestra=" + contraseñaMaestra + '}';
    }
}
