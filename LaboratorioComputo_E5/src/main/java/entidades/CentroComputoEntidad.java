/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * La clase {@code CentroComputoEntidad} representa un centro de cómputo en la
 * base de datos. Se almacena información como el nombre, las horas de servicio,
 * una contraseña maestra y la relación con una unidad académica.
 * <p>
 * Esta entidad está mapeada a la tabla "tblCentroComputo" en la base de datos.
 * 
 * @author santi
 */
@Entity
@Table(name = "tblCentroComputo")
public class CentroComputoEntidad implements Serializable {

    private static final long serialVersionUID = 1L;

    /** Identificador único del centro de cómputo en la base de datos. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCentroComputo")
    private Long id;

    /** Nombre del centro de cómputo. */
    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    /** Contraseña maestra del centro de cómputo. */
    @Column(name = "contraseniaMaestra", length = 25, nullable = false)
    private String contraseniaMaestra;

    /** Hora de inicio del servicio del centro de cómputo. */
    @Temporal(TemporalType.TIME)
    @Column(name = "horaInicioServicio", nullable = false)
    private Calendar horaInicioServicio;

    /** Hora de fin del servicio del centro de cómputo. */
    @Temporal(TemporalType.TIME)
    @Column(name = "horaFinServicio", nullable = false)
    private Calendar horaFinServicio;

    /** Relación con la entidad {@code UnidadAcademicaEntidad}. */
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idUnidadAcademica", nullable = false)
    private UnidadAcademicaEntidad unidadAcademica;

    /**
     * Constructor por defecto. Crea una instancia vacía de {@code CentroComputoEntidad}.
     */
    public CentroComputoEntidad() {
    }

    /**
     * Constructor que establece los valores de los atributos del centro de cómputo, 
     * excluyendo la relación con la unidad académica.
     *
     * @param nombre nombre del centro de cómputo
     * @param contraseniaMaestra contraseña maestra del centro de cómputo
     * @param horaInicioServicio hora de inicio del servicio
     * @param horaFinServicio hora de fin del servicio
     */
    public CentroComputoEntidad(String nombre, String contraseniaMaestra, Calendar horaInicioServicio, Calendar horaFinServicio) {
        this.nombre = nombre;
        this.contraseniaMaestra = contraseniaMaestra;
        this.horaInicioServicio = horaInicioServicio;
        this.horaFinServicio = horaFinServicio;
    }

    /**
     * Constructor que establece los valores de todos los atributos del centro de cómputo.
     *
     * @param nombre nombre del centro de cómputo
     * @param contraseniaMaestra contraseña maestra del centro de cómputo
     * @param horaInicioServicio hora de inicio del servicio
     * @param horaFinServicio hora de fin del servicio
     * @param unidadAcademica unidad académica asociada al centro de cómputo
     */
    public CentroComputoEntidad(String nombre, String contraseniaMaestra, Calendar horaInicioServicio, Calendar horaFinServicio, UnidadAcademicaEntidad unidadAcademica) {
        this.nombre = nombre;
        this.contraseniaMaestra = contraseniaMaestra;
        this.horaInicioServicio = horaInicioServicio;
        this.horaFinServicio = horaFinServicio;
        this.unidadAcademica = unidadAcademica;
    }

    /**
     * Obtiene el identificador del centro de cómputo.
     *
     * @return el identificador del centro de cómputo
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador del centro de cómputo.
     *
     * @param id identificador del centro de cómputo
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del centro de cómputo.
     *
     * @return el nombre del centro de cómputo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del centro de cómputo.
     *
     * @param nombre el nombre del centro de cómputo
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la contraseña maestra del centro de cómputo.
     *
     * @return la contraseña maestra del centro de cómputo
     */
    public String getContraseniaMaestra() {
        return contraseniaMaestra;
    }

    /**
     * Establece la contraseña maestra del centro de cómputo.
     *
     * @param contraseniaMaestra la nueva contraseña maestra del centro de cómputo
     */
    public void setContraseniaMaestra(String contraseniaMaestra) {
        this.contraseniaMaestra = contraseniaMaestra;
    }

    /**
     * Obtiene la hora de inicio del servicio del centro de cómputo.
     *
     * @return la hora de inicio del servicio
     */
    public Calendar getHoraInicioServicio() {
        return horaInicioServicio;
    }

    /**
     * Establece la hora de inicio del servicio del centro de cómputo.
     *
     * @param horaInicioServicio la nueva hora de inicio del servicio
     */
    public void setHoraInicioServicio(Calendar horaInicioServicio) {
        this.horaInicioServicio = horaInicioServicio;
    }

    /**
     * Obtiene la hora de fin del servicio del centro de cómputo.
     *
     * @return la hora de fin del servicio
     */
    public Calendar getHoraFinServicio() {
        return horaFinServicio;
    }

    /**
     * Establece la hora de fin del servicio del centro de cómputo.
     *
     * @param horaFinServicio la nueva hora de fin del servicio
     */
    public void setHoraFinServicio(Calendar horaFinServicio) {
        this.horaFinServicio = horaFinServicio;
    }

    /**
     * Obtiene la unidad académica asociada con el centro de cómputo.
     *
     * @return la unidad académica asociada
     */
    public UnidadAcademicaEntidad getUnidadAcademica() {
        return unidadAcademica;
    }

    /**
     * Establece la unidad académica asociada con el centro de cómputo.
     *
     * @param unidadAcademica la nueva unidad académica asociada
     */
    public void setUnidadAcademica(UnidadAcademicaEntidad unidadAcademica) {
        this.unidadAcademica = unidadAcademica;
    }

    /**
     * Genera el código hash basado en el identificador de la entidad.
     *
     * @return el código hash
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Compara esta entidad con otra para verificar igualdad.
     *
     * @param object el objeto con el que se compara
     * @return {@code true} si los objetos son iguales, {@code false} de lo contrario
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CentroComputoEntidad)) {
            return false;
        }
        CentroComputoEntidad other = (CentroComputoEntidad) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    /**
     * Representa la entidad como cadena de texto.
     *
     * @return una representación textual de la entidad
     */
    @Override
    public String toString() {
        return "entidades.CentroComputoEntidad[ id=" + id + " ]";
    }

}
