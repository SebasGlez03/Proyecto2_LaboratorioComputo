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
 * La clase {@code BloqueoEntidad} representa un bloqueo hacia un alumno en la
 * base de datos. Este bloqueo está asociado a un motivo y a una fecha
 * específica, y está relacionado con un estudiante a través de una relación de
 * muchos a uno con la entidad {@code EstudianteEntidad}.
 *
 * @author santi
 */
@Entity
@Table(name = "tblBloqueo")
public class BloqueoEntidad implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Identificador único del bloqueo. Se autogenera con la estrategia de
     * identidad.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBloqueo")
    private Long idBloqueo;

    /**
     * Motivo del bloqueo. Es obligatorio y tiene un límite de 50 caracteres.
     */
    @Column(name = "motivoBloqueo", length = 50, nullable = false)
    private String motivo;

    /**
     * Fecha en la que se aplica el bloqueo. Es obligatoria.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechaBloqueo", nullable = false)
    private Calendar fechaBloqueo;

    /**
     * Fecha en la que se libera el bloqueo. No es obligatoria.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechaLiberacion")
    private Calendar fechaLiberacion;

    /**
     * Relación con la entidad {@code EstudianteEntidad}, que indica el
     * estudiante al que se le aplica el bloqueo. Es una relación de muchos a
     * uno y es obligatoria.
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "estudiante")
    private EstudianteEntidad estudiante;

    /**
     * Constructor por omisión, necesario para JPA.
     */
    public BloqueoEntidad() {
    }

    /**
     * Constructor para inicializar un bloqueo con los valores de motivo, fecha
     * de bloqueo y estudiante.
     *
     * @param motivo El motivo del bloqueo.
     * @param fechaBloqueo La fecha y hora en la que se aplica el bloqueo.
     * @param estudiante El estudiante al que se le asigna el bloqueo.
     */
    public BloqueoEntidad(String motivo, Calendar fechaBloqueo, EstudianteEntidad estudiante) {
        this.motivo = motivo;
        this.fechaBloqueo = fechaBloqueo;
        this.estudiante = estudiante;
    }

    /**
     * Constructor para inicializar un bloqueo con los valores de motivo, fecha
     * de bloqueo, fecha de liberacion y estudiante.
     *
     * @param motivo El motivo del bloqueo.
     * @param fechaBloqueo La fecha y hora en la que se aplica el bloqueo.
     * @param fechaLiberacion La fecha y hora en la que se libera del bloqueo.
     * @param estudiante El estudiante al que se le asigna el bloqueo.
     */
    public BloqueoEntidad(String motivo, Calendar fechaBloqueo, Calendar fechaLiberacion, EstudianteEntidad estudiante) {
        this.motivo = motivo;
        this.fechaBloqueo = fechaBloqueo;
        this.fechaLiberacion = fechaLiberacion;
        this.estudiante = estudiante;
    }

    /**
     * Obtiene el identificador del bloqueo.
     *
     * @return El identificador del bloqueo.
     */
    public Long getId() {
        return idBloqueo;
    }

    /**
     * Establece el identificador del bloqueo.
     *
     * @param id El identificador a establecer.
     */
    public void setId(Long id) {
        this.idBloqueo = id;
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
     * @param motivo El motivo a establecer.
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * Obtiene la fecha en la que se aplicó el bloqueo.
     *
     * @return La fecha del bloqueo.
     */
    public Calendar getFechaBloqueo() {
        return fechaBloqueo;
    }

    /**
     * Establece la fecha del bloqueo.
     *
     * @param fechaBloqueo La fecha a establecer.
     */
    public void setFechaBloqueo(Calendar fechaBloqueo) {
        this.fechaBloqueo = fechaBloqueo;
    }

    /**
     * Obtiene la fecha en la que se libero el bloqueo
     *
     * @return La fecha de liberacion del bloqueo.
     */
    public Calendar getFechaLiberacion() {
        return fechaLiberacion;
    }

    /**
     * Establece la fecha de liberacion del bloqueo.
     *
     * @param fechaLiberacion La fecha a establecer.
     */
    public void setFechaLiberacion(Calendar fechaLiberacion) {
        this.fechaLiberacion = fechaLiberacion;
    }

    /**
     * Obtiene el estudiante al que se le asignó el bloqueo.
     *
     * @return El estudiante relacionado con el bloqueo.
     */
    public EstudianteEntidad getEstudiante() {
        return estudiante;
    }

    /**
     * Establece el estudiante relacionado con el bloqueo.
     *
     * @param estudiante El estudiante a asignar al bloqueo.
     */
    public void setEstudiante(EstudianteEntidad estudiante) {
        this.estudiante = estudiante;
    }
}
