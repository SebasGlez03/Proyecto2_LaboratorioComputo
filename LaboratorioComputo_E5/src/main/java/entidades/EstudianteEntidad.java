/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * La clase {@code EstudianteEntidad} representa un estudiante en la base de
 * datos.
 * <p>
 * Esta entidad contiene información básica del estudiante, así como relaciones
 * con otras entidades como la unidad académica, bloqueos, y carrera.
 * </p>
 *
 * @author sebasglez
 */
@Entity
@Table(name = "tblEstudiante")
public class EstudianteEntidad implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEstudiante")
    private Long idEstudiante;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "apellidoPaterno", length = 50, nullable = false)
    private String apellidoPaterno;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "computadoraRentada", referencedColumnName = "idComputadora")
    private ComputadoraEntidad computadora;

    @Column(name = "apellidoMaterno", length = 50, nullable = false)
    private String apellidoMaterno;

    @Column(name = "contrasenia", length = 25, nullable = false)
    private String contrasenia;

    @Column(name = "estatusInscripcion", length = 15, nullable = false)
    private String estatusInscripcion;

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.PERSIST)
    private List<BloqueoEntidad> bloqueo;

    @OneToMany(mappedBy = "estudiante")
    private List<RentaEntidad> rentas;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idCarrera", referencedColumnName = "nombre")
    private CarreraEntidad carrera;

    /**
     * Constructor por omision.
     */
    public EstudianteEntidad() {
    }

    /**
     * Constructor que establece los valores de los atributos de la clase a
     * excepción de la relación con la unidad académica.
     *
     * @param nombre nombre del estudiante.
     * @param apellidoPaterno apellido paterno del estudiante.
     * @param apellidoMaterno apellido materno del estudiante.
     * @param contrasenia contraseña del estudiante.
     * @param estatusInscripcion estatus de la inscripción del estudiante.
     */
    public EstudianteEntidad(String nombre, String apellidoPaterno, String apellidoMaterno, String contrasenia, String estatusInscripcion) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.contrasenia = contrasenia;
        this.estatusInscripcion = estatusInscripcion;
    }

    /**
     * Constructor que establece todos los valores de los atributos de la clase.
     *
     * @param id identificador del estudiante.
     * @param nombre nombre del estudiante.
     * @param apellidoPaterno apellido paterno del estudiante.
     * @param computadora entidad que representa la computadora rentada por el
     * estudiante.
     * @param apellidoMaterno apellido materno del estudiante.
     * @param contrasenia contraseña del estudiante.
     * @param estatusInscripcion estatus de la inscripción del estudiante.
     * @param carrera relación entre el estudiante y una carrera.
     */
    public EstudianteEntidad(Long id, String nombre, String apellidoPaterno, ComputadoraEntidad computadora, String apellidoMaterno, String contrasenia, String estatusInscripcion, CarreraEntidad carrera) {
        this.idEstudiante = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.computadora = computadora;
        this.apellidoMaterno = apellidoMaterno;
        this.contrasenia = contrasenia;
        this.estatusInscripcion = estatusInscripcion;
        this.carrera = carrera;
    }

    /**
     * Método que obtiene el ID del estudiante.
     *
     * @return id del estudiante.
     */
    public Long getId() {
        return idEstudiante;
    }

    /**
     * Método que establece el ID del estudiante.
     *
     * @param id id del estudiante a establecer.
     */
    public void setId(Long id) {
        this.idEstudiante = id;
    }

    /**
     * Método que obtiene el nombre del estudiante.
     *
     * @return nombre del estudiante.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que establece el nombre del estudiante.
     *
     * @param nombre nombre del estudiante a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que obtiene el apellido paterno del estudiante.
     *
     * @return apellido paterno del estudiante.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Método que establece el apellido paterno del estudiante.
     *
     * @param apellidoPaterno apellido paterno del estudiante a establecer.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Método que obtiene el apellido materno del estudiante.
     *
     * @return apellido materno del estudiante.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Método que establece el apellido materno del estudiante.
     *
     * @param apellidoMaterno apellido materno del estudiante a establecer.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Método que obtiene la contraseña del estudiante.
     *
     * @return contraseña del estudiante.
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Método que establece la contraseña del estudiante.
     *
     * @param contrasenia contraseña del estudiante a establecer.
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Método que obtiene el estatus de la inscripción del estudiante.
     *
     * @return estatus de la inscripción del estudiante.
     */
    public String getEstatusInscripcion() {
        return estatusInscripcion;
    }

    /**
     * Método que establece el estatus de la inscripción del estudiante.
     *
     * @param estatusInscripcion estatus de la inscripción del estudiante a
     * establecer.
     */
    public void setEstatusInscripcion(String estatusInscripcion) {
        this.estatusInscripcion = estatusInscripcion;
    }

    /**
     * Método que obtiene la relación de la computadora y el estudiante.
     *
     * @return relación de la computadora con el estudiante.
     */
    public ComputadoraEntidad getComputadora() {
        return computadora;
    }

    /**
     * Método que establece la relación de la computadora y el estudiante.
     *
     * @param computadora relación de la computadora con el estudiante a
     * establecer.
     */
    public void setComputadora(ComputadoraEntidad computadora) {
        this.computadora = computadora;
    }

    /**
     * Obtiene la lista de bloqueos asociados a un estudiante.
     *
     * @return Una lista de bloqueos asociados al estudiante.
     */
    public List<BloqueoEntidad> getBloqueo() {
        return bloqueo;
    }

    /**
     * Establece la lista de bloqueos asociados a un estudiante.
     *
     * @param bloqueo La lista de bloqueos a establecer.
     */
    public void setBloqueo(List<BloqueoEntidad> bloqueo) {
        this.bloqueo = bloqueo;
    }

    /**
     * Obtiene la lista de rentas asociadas a un estudiante.
     *
     * @return Una lista de rentas asociadas al estudiante.
     */
    public List<RentaEntidad> getRentas() {
        return rentas;
    }

    /**
     * Establece la lista de rentas asociadas a un estudiante.
     *
     * @param rentas La lista de rentas a establecer.
     */
    public void setRentas(List<RentaEntidad> rentas) {
        this.rentas = rentas;
    }

    /**
     * Método que obtiene la relación entre el estudiante y una carrera.
     *
     * @return relación de la carrera con el estudiante.
     */
    public CarreraEntidad getCarrera() {
        return carrera;
    }

    /**
     * Método que establece la relación entre el estudiante y una carrera.
     *
     * @param carrera relación de la carrera con el estudiante a establecer.
     */
    public void setCarrera(CarreraEntidad carrera) {
        this.carrera = carrera;
    }

    /**
     * Método que retorna una representación en cadena de la entidad estudiante.
     *
     * @return representación en cadena del estudiante.
     */
    @Override
    public String toString() {
        return "EstudianteEntidad{" + "id=" + idEstudiante + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", contrasenia=" + contrasenia + ", estatusInscripcion=" + estatusInscripcion + ", carrera=" + carrera + '}';
    }
}
