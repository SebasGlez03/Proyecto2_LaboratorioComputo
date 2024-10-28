/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * La clase {@code CarreraEntidad} representa una carrera universitaria en la
 * base de datos. Cada carrera tiene un nombre, un tiempo diario y una lista de
 * estudiantes asociados.
 *
 * Esta clase está mapeada a la tabla {@code tblCarrera} en la base de datos.
 *
 * @author santi
 */
@Entity
@Table(name = "tblCarrera")
public class CarreraEntidad implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Identificador único de la carrera. Se genera automáticamente utilizando
     * la estrategia de identidad.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCarrera")
    private Long idCarrera;

    /**
     * Nombre de la carrera, con un máximo de 50 caracteres. Es obligatorio.
     */
    @Column(name = "Nombre", length = 50, nullable = false)
    private String nombre;

    /**
     * Tiempo diario que los estudiantes dedican a la carrera. Se guarda como
     * una hora (tipo {@code Calendar}). Es obligatorio.
     */
    @Temporal(TemporalType.TIME)
    @Column(name = "tiempoDiario", nullable = false)
    private Date tiempoDiario;

    /**
     * Lista de estudiantes asociados a la carrera. Esta es una relación de uno
     * a muchos con la entidad {@code EstudianteEntidad}.
     */
    @OneToMany()
    @JoinColumn(name = "idEstudiante")
    private List<EstudianteEntidad> estudiante;

    /**
     * Constructor por omisión. Necesario para JPA.
     */
    public CarreraEntidad() {
    }

    /**
     * Constructor que inicializa una carrera con su nombre, tiempo diario,
     * unidad academica y lista de estudiantes.
     *
     * @param nombre El nombre de la carrera.
     * @param tiempoDiario El tiempo diario que se dedica a la carrera.
     * @param estudiante La lista de estudiantes asociados a la carrera.
     */
    public CarreraEntidad(String nombre, Date tiempoDiario, List<EstudianteEntidad> estudiante) {
        this.nombre = nombre;
        this.tiempoDiario = tiempoDiario;
        this.estudiante = estudiante;
    }

    /**
     * Constructor que inicializa una carrera con su nombre, tiempo diario,
     * unidad academica y lista de estudiantes.
     *
     * @param nombre El nombre de la carrera.
     * @param tiempoDiario El tiempo diario que se dedica a la carrera.
     */
    public CarreraEntidad(String nombre, Date tiempoDiario) {
        this.nombre = nombre;
        this.tiempoDiario = tiempoDiario;

    }

    /**
     * Obtiene el identificador único de la carrera.
     *
     * @return El identificador de la carrera.
     */
    public Long getIdCarrera() {
        return idCarrera;
    }

    /**
     * Establece el identificador único de la carrera.
     *
     * @param idCarrera El nuevo identificador de la carrera.
     */
    public void setIdCarrera(Long idCarrera) {
        this.idCarrera = idCarrera;
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
     * @param nombre El nuevo nombre de la carrera.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el tiempo diario que los estudiantes dedican a la carrera.
     *
     * @return El tiempo diario de la carrera como un {@code Calendar}.
     */
    public Date getTiempoDiario() {
        return tiempoDiario;
    }

    /**
     * Establece el tiempo diario que los estudiantes dedican a la carrera.
     *
     * @param tiempoDiario El nuevo tiempo diario a establecer.
     */
    public void setTiempoDiario(Date tiempoDiario) {
        this.tiempoDiario = tiempoDiario;
    }

    /**
     * Obtiene la lista de estudiantes asociados a la carrera.
     *
     * @return La lista de estudiantes.
     */
    public List<EstudianteEntidad> getEstudiante() {
        return estudiante;
    }

    /**
     * Establece la lista de estudiantes asociados a la carrera.
     *
     * @param estudiante La nueva lista de estudiantes.
     */
    public void setEstudiante(List<EstudianteEntidad> estudiante) {
        this.estudiante = estudiante;
    }

    /**
     * ToString
     *
     */
    @Override
    public String toString() {
        return "CarreraEntidad{" + "idCarrera=" + idCarrera + ", nombre=" + nombre + ", tiempoDiario=" + tiempoDiario + ", estudiante=" + estudiante + '}';
    }

}
