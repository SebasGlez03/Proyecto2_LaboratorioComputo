/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

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
 * La clase {@code centroComputoEntidad} representa un centro de cómputo en la
 * base de datos. Se almacena información como el nombre, las horas de servicio,
 * una contraseña maestra y una lista de computadoras asociadas a este centro de
 * cómputo.
 *
 * Esta entidad está mapeada a la tabla "tblCentroComputo" en la base de datos.
 *
 * @author santi
 */
@Entity
@Table(name = "tblCentroComputo")
public class CentroComputoEntidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCentroComputo")
    private Long id;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "contraseniaMaestra", length = 25, nullable = false)
    private String contraseniaMaestra;

    @Temporal(TemporalType.TIME)
    @Column(name = "horaInicioServicio", nullable = false)
    private Calendar horaInicioServicio;

    @Temporal(TemporalType.TIME)
    @Column(name = "horaFinServicio", nullable = false)
    private Calendar horaFinServicio;

    @ManyToOne()
    @JoinColumn(name = "idUnidadAcademica", nullable = false)
    private UnidadAcademicaEntidad unidadAcademica;

    /**
     * Constructor por omision
     */
    public CentroComputoEntidad() {
    }

    /**
     * Constructor que establece los valores de los atributos de la clase a
     * excepcion de la relacion
     *
     * @param nombre nombre del centro de computo
     * @param contraseniaMaestra contrasenia maestra del centro de computo
     * @param horaInicioServicio hora inicio del servicio del centro de computo
     * @param horaFinServicio hora fin del servicio del centro de computo
     */
    public CentroComputoEntidad(String nombre, String contraseniaMaestra, Calendar horaInicioServicio, Calendar horaFinServicio) {
        this.nombre = nombre;
        this.contraseniaMaestra = contraseniaMaestra;
        this.horaInicioServicio = horaInicioServicio;
        this.horaFinServicio = horaFinServicio;
    }

    /**
     * Constructor que establece los valores de los atributos de la clase
     *
     * @param nombre nombre del centro de computo
     * @param contraseniaMaestra contrasenia maestra del centro de computo
     * @param horaInicioServicio hora inicio del servicio del centro de computo
     * @param horaFinServicio hora fin del servicio del centro de computo
     * @param unidadAcademica relacion entre los centros de computo y la
     * unidadAcademica
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
     * @return idCentroComputo El identificador del centro de cómputo.
     */
    public Long getId() {
        return id;
    }

    /**
     * Metodo que establece el identificador del centro de computo.
     *
     * @param id idCentroComputo el identificador del centro de computo a
     * establecer
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Metodo que obtiene el nombre del centro de computo
     *
     * @return nombre del centro de computo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que establece el nombre del centro de computo
     *
     * @param nombre nombre del centro de computo
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que obtiene la contrasenia maestra del centro de computo
     *
     * @return contrasenia maestra del centro de computo
     */
    public String getContraseniaMaestra() {
        return contraseniaMaestra;
    }

    /**
     * Metodo que establece la caontrasenia maestra del centro de computo
     *
     * @param contraseniaMaestra contrasenia maestra del centro de computo a
     * establcer
     */
    public void setContraseniaMaestra(String contraseniaMaestra) {
        this.contraseniaMaestra = contraseniaMaestra;
    }

    /**
     * Metodo que obtiene la hora de inicio del serivcio de el centro de computo
     *
     * @return hora de inicio del servicio de el centro de computo
     */
    public Calendar getHoraInicioServicio() {
        return horaInicioServicio;
    }

    /**
     * Metodo que establece la hora de inicio del servicio de el centro de
     * computo
     *
     * @param horaInicioServicio hora de inicio de el centro de computo a
     * establcer
     */
    public void setHoraInicioServicio(Calendar horaInicioServicio) {
        this.horaInicioServicio = horaInicioServicio;
    }

    /**
     * Metodo que obtiene la hora fin de el servicio de el centro de computo
     *
     * @return hora fin de el servicio de el centro de computo
     */
    public Calendar getHoraFinServicio() {
        return horaFinServicio;
    }

    /**
     * Metodo que establece la hora fin de el servicio de el centro de computo
     *
     * @param horaFinServicio hopra fin de el servicio de el centro de computo a
     * establecer
     */
    public void setHoraFinServicio(Calendar horaFinServicio) {
        this.horaFinServicio = horaFinServicio;
    }

    /**
     * Metodo que obtiene la relacion entre los centros de computo y la
     * unidadAcademica
     *
     * @return unidadAcademica con la que se relaciona el centro de computo
     */
    public UnidadAcademicaEntidad getUnidadAcademica() {
        return unidadAcademica;
    }

    /**
     * Metodo que establece la relacion entre los centros de computo y la
     * unidadAcademica
     *
     * @param unidadAcademica unidadAcademica con la que se relaciona el centro
     * de computo a establecer
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
        if (!(object instanceof CentroComputoEntidad)) {
            return false;
        }
        CentroComputoEntidad other = (CentroComputoEntidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CentroComputoEntidad[ id=" + id + " ]";
    }

}
