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
     * excepcion de las relaciones
     *
     * @param contraseniaMaestra contrasenia maestra del centro de computo
     * @param horaInicioServicio hora inicio de servicio del centro de computo
     * @param horaFinServicio hora fin de servicio del centro de computo
     */
    public CentroComputoEntidad(String contraseniaMaestra, Calendar horaInicioServicio, Calendar horaFinServicio) {
        this.contraseniaMaestra = contraseniaMaestra;
        this.horaInicioServicio = horaInicioServicio;
        this.horaFinServicio = horaFinServicio;
    }

    /**
     * Constructor que establece los valores de los atributos de la clase
     *
     * @param contraseniaMaestra contrasenia maestra del centro de computo
     * @param horaInicioServicio hora inicio del servicio del centro de computo
     * @param horaFinServicio hora fin de servicio del centro de computo
     * @param unidadAcademica relacion entre los centros de computo y la
     * unidadAcademica
     */
    public CentroComputoEntidad(String contraseniaMaestra, Calendar horaInicioServicio, Calendar horaFinServicio, UnidadAcademicaEntidad unidadAcademica) {
        this.contraseniaMaestra = contraseniaMaestra;
        this.horaInicioServicio = horaInicioServicio;
        this.horaFinServicio = horaFinServicio;
        this.unidadAcademica = unidadAcademica;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public UnidadAcademicaEntidad getUnidadAcademica() {
        return unidadAcademica;
    }

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
