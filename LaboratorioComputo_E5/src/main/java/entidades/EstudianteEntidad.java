/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "tblEstudiante")
public class EstudianteEntidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEstudiante")
    private Long id;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "apellidoPaterno", length = 50, nullable = false)
    private String apellidoPaterno;

    @Column(name = "apellidoMaterno", length = 50, nullable = false)
    private String apellidoMaterno;

    @Column(name = "contrasenia", length = 25, nullable = false)
    private String contrasenia;

    @Column(name = "estatusInscripcion", length = 15, nullable = false)
    private String estatusInscripcion;

    @ManyToOne()
    @JoinColumn(name = "idUnidadAcademica", nullable = false)
    private UnidadAcademicaEntidad unidadAcademica;

    /**
     * Constructor por omision
     */
    public EstudianteEntidad() {
    }

    /**
     * Constructor que establece los valores de los atributos de la clase a
     * excepcion de la relacion de la unidadAcademica
     *
     * @param nombre nombre del estudiante
     * @param apellidoPaterno apellido paterno del estudiante
     * @param apellidoMaterno apellido materno del estudiante
     * @param contrasenia contrasenia del estudiante
     * @param estatusInscripcion estatus de la inscripcion del estudiante
     */
    public EstudianteEntidad(String nombre, String apellidoPaterno, String apellidoMaterno, String contrasenia, String estatusInscripcion) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.contrasenia = contrasenia;
        this.estatusInscripcion = estatusInscripcion;
    }

    /**
     * Constructor que establece los valores de los atributos de la clase
     *
     * @param nombre nombre del estudiante
     * @param apellidoPaterno apellido paterno del estudiante
     * @param apellidoMaterno apellido materno del estudiante
     * @param contrasenia contrasenia del estudiante
     * @param estatusInscripcion estatus de la inscripcion del estudiante
     * @param unidadAcademica relacion entre el estudiante y una unidadAcademica
     */
    public EstudianteEntidad(String nombre, String apellidoPaterno, String apellidoMaterno, String contrasenia, String estatusInscripcion, UnidadAcademicaEntidad unidadAcademica) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.contrasenia = contrasenia;
        this.estatusInscripcion = estatusInscripcion;
        this.unidadAcademica = unidadAcademica;
    }

    /**
     * Metodo que obtiene el ID del estudiante
     *
     * @return id del estudiante
     */
    public Long getId() {
        return id;
    }

    /**
     * Metodo que establece el ID del estudiante
     *
     * @param id id del estudiante a establecer
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Metodo que obtiene el nombre del estudiante
     *
     * @return nombre del estudiante
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que establece el nombre del estaudiante
     *
     * @param nombre nombre del estudiante a establecer
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que obtiene el apellido paterno del estudiante
     *
     * @return apellido paterno del estudiante
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Metodo que establece el apellido paterno del estudiante
     *
     * @param apellidoPaterno apelldio paterno del estudiante a establecer
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Metodo que obtiene el apellido materno del estudiante
     *
     * @return apellido materno del estudiante
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Metodo que establece el apellido materno del estudiante
     *
     * @param apellidoMaterno apellido materno del estudiante a obtener
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Metodo que establece la contrasenia del estudiante
     *
     * @return contrasenia del estudiante
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Metodo que establelce la contrasenia del estudiante
     *
     * @param contrasenia contrasenia del estudiante a establecer
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Metodo que obtiene el estatus de la inscripcion del estudiante
     *
     * @return estatus de la inscripcion del estudiante
     */
    public String getEstatusInscripcion() {
        return estatusInscripcion;
    }

    /**
     * Metodo que establece el estatus de la inscripcion del estudiante
     *
     * @param estatusInscripcion estatus de la inscripcion del estudiante a
     * establecer
     */
    public void setEstatusInscripcion(String estatusInscripcion) {
        this.estatusInscripcion = estatusInscripcion;
    }

    /**
     * Metodo que obtiene la relacion de la UnidadAcademica y el estudiante
     *
     * @return relacion de la UnidadAcademica con el estudiante
     */
    public UnidadAcademicaEntidad getUnidadAcademica() {
        return unidadAcademica;
    }

    /**
     * Metodo que establece la relacion de la UnidadAcademida y el estudiante
     *
     * @param unidadAcademica relacion de la UnidadAcademica con el estudiante a
     * establecer
     */
    public void setUnidadAcademica(UnidadAcademicaEntidad unidadAcademica) {
        this.unidadAcademica = unidadAcademica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstudianteEntidad)) {
            return false;
        }
        EstudianteEntidad other = (EstudianteEntidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.estudianteEntidad[ id=" + id + " ]";
    }

}
