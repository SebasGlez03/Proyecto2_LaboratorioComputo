/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.entidades;

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
 * a
 * @hidden
 */
@Entity
@Table(name = "tblApartado")
public class ApartadoEntidad implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Identificador único de la renta
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idApartado")
    private Long id;

    /**
     * Fecha y hora de inicio de la renta
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechaInicio", nullable = false)
    private Calendar fechaInicio;

    /**
     * Fecha y hora de finalización de la renta
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechaFin", nullable = false)
    private Calendar fechaFin;

    /**
     * Minutos activos que duró la renta
     */
    @Column(name = "MinutosActivo", nullable = false)
    private int minutosActivo;

    /**
     * Estudiante asociado con la renta
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idEstudiante", nullable = false)
    private EstudianteEntidad estudiante;

    /**
     * Computadora asociada con la renta
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idComputadora", nullable = false)
    private ComputadoraEntidad computadora;

    /**
     * Constructor por omisión.
     */
    public ApartadoEntidad() {
    }

    /**
     * Constructor que inicializa los atributos de la clase.
     *
     * @param fechaInicio Fecha y hora de inicio de la renta.
     * @param fechaFin Fecha y hora de fin de la renta.
     * @param estudiante Estudiante asociado a la renta.
     * @param computadora Computadora asociada a la renta.
     */
    public ApartadoEntidad(Calendar fechaInicio, Calendar fechaFin, EstudianteEntidad estudiante, ComputadoraEntidad computadora) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estudiante = estudiante;
        this.computadora = computadora;
    }

    /**
     * Obtiene el identificador único de la renta.
     *
     * @return ID de la renta.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único de la renta.
     *
     * @param id ID de la renta a establecer.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la fecha y hora de inicio de la renta.
     *
     * @return Fecha y hora de inicio de la renta.
     */
    public Calendar getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Establece la fecha y hora de inicio de la renta.
     *
     * @param fechaInicio Fecha y hora de inicio a establecer.
     */
    public void setFechaInicio(Calendar fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Obtiene la fecha y hora de finalización de la renta.
     *
     * @return Fecha y hora de fin de la renta.
     */
    public Calendar getFechaFin() {
        return fechaFin;
    }

    /**
     * Establece la fecha y hora de finalización de la renta.
     *
     * @param fechaFin Fecha y hora de fin a establecer.
     */
    public void setFechaFin(Calendar fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * Obtiene el estudiante asociado a la renta.
     *
     * @return Estudiante asociado a la renta.
     */
    public EstudianteEntidad getEstudiante() {
        return estudiante;
    }

    /**
     * Establece el estudiante asociado a la renta.
     *
     * @param estudiante Estudiante a asociar con la renta.
     */
    public void setEstudiante(EstudianteEntidad estudiante) {
        this.estudiante = estudiante;
    }

    /**
     * Obtiene la computadora asociada a la renta.
     *
     * @return Computadora asociada a la renta.
     */
    public ComputadoraEntidad getComputadora() {
        return computadora;
    }

    /**
     * Establece la computadora asociada a la renta.
     *
     * @param computadora Computadora a asociar con la renta.
     */
    public void setComputadora(ComputadoraEntidad computadora) {
        this.computadora = computadora;
    }

    /**
     * Obtiene los minutos activos que duró la renta.
     *
     * @return Minutos activos de la renta.
     */
    public int getMinutosActivo() {
        return minutosActivo;
    }

    /**
     * Establece los minutos activos que duró la renta.
     *
     * @param minutosActivo Minutos activos a establecer.
     */
    public void setMinutosActivo(int minutosActivo) {
        this.minutosActivo = minutosActivo;
    }

    /**
     * Representación en cadena de los atributos de la clase.
     *
     * @return Cadena con los atributos de la clase.
     */
    @Override
    public String toString() {
        return "RentaEntidad{" + "id=" + id + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", estudiante=" + estudiante + ", computadora=" + computadora + '}';
    }
}
