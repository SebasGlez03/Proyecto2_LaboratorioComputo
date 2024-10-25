/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.entidades;

import java.io.Serializable;
import java.util.Calendar;
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
 *
 * @author PC
 */
@Entity
@Table(name = "tblApartado")
public class ApartadoEntidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idApartado")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechaInicio", nullable = false)
    private Calendar fechaInicio;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechaFin", nullable = false)
    private Calendar fechaFin;

    @ManyToOne()
    @JoinColumn(name = "idEstudiante", nullable = false)
    private EstudianteEntidad estudiante;

    @ManyToOne()
    @JoinColumn(name = "idComputadora", nullable = false)
    private ComputadoraEntidad computadora;

    /**
     * Constructor por omision
     */
    public ApartadoEntidad() {
    }

    /**
     * Constructor que establece los valores de los atributos de la clase.
     *
     * @param fechaInicio Fecha hora de inicio de la renta
     * @param fechaFin Fecha hora de fin de la renta
     * @param estudiante Estudiante asociado con la renta
     * @param computadora Computadora asociada con la renta
     */
    public ApartadoEntidad(Calendar fechaInicio, Calendar fechaFin, EstudianteEntidad estudiante, ComputadoraEntidad computadora) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estudiante = estudiante;
        this.computadora = computadora;
    }

    /**
     * Metodo que obtiene el ID de la renta
     *
     * @return Id de la renta
     */
    public Long getId() {
        return id;
    }

    /**
     * Metodo que establece el ID de la renta
     *
     * @param id ID de la renta a establecer
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Metodo que obtiene la fecha hora de inicio de la renta
     *
     * @return fecha hora de inicio de la renta
     */
    public Calendar getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Metodo que establece la fecha hora de inicio de la renta
     *
     * @param fechaInicio fecha hora de inicio de la renta a establcer
     */
    public void setFechaInicio(Calendar fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Metodo que obtiene la fecha hora fin de la renta
     *
     * @return fecha hora de fin de la renta
     */
    public Calendar getFechaFin() {
        return fechaFin;
    }

    /**
     * Metodo que establece la fecha hora fin de la renta
     *
     * @param fechaFin fecha hora de fin de la renta a establecer
     */
    public void setFechaFin(Calendar fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * Metodo que obtiene la lista de estudiantes asociados a la renta
     *
     * @return La lista de estuidnates
     */
    public EstudianteEntidad getEstudiante() {
        return estudiante;
    }

    /**
     * Metodo que establece la lista de estudiantes asociados a la renta
     *
     * @param estudiante La lista de estudiantes
     */
    public void setEstudiante(EstudianteEntidad estudiante) {
        this.estudiante = estudiante;
    }

    /**
     * Metodo que obtiene la lista de computadoras asociadas a la renta
     *
     * @return La lista de computadoras
     */
    public ComputadoraEntidad getComputadora() {
        return computadora;
    }

    /**
     * Metodo que establece la lista de computadoras asociadas a la renta
     *
     * @param computadora La lista de computadoras
     */
    public void setComputadora(ComputadoraEntidad computadora) {
        this.computadora = computadora;
    }

    /**
     * Metodo que devuelve el valor de los atributos de la clase de forma de
     * string
     *
     * @return Los atributos de la clase de forma de string
     */
    @Override
    public String toString() {
        return "RentaEntidad{" + "id=" + id + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", estudiante=" + estudiante + ", computadora=" + computadora + '}';
    }

}
