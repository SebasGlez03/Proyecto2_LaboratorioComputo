/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "tblUnidadAcademica")
public class UnidadAcademicaEntidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUnidadAcademica")
    private Long id;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "unidadAcademica")
    private List<EstudianteEntidad> estudiantes;

    /**
     * Constructor por omision
     */
    public UnidadAcademicaEntidad() {
    }

    /**
     * Constructor que inicializa el atributo de la clase "nombre"
     *
     * @param nombre nombre a agregar
     */
    public UnidadAcademicaEntidad(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que obtiene el id de la Unidad Academica
     *
     * @return id de la Unidad Academica a obtener
     */
    public Long getId() {
        return id;
    }

    /**
     * Metodo que establece el id de la Unidad Academica
     *
     * @param id id de la Unidad Academica a establecer
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Metodo que obtiene el nombre de la Unidad Academica
     *
     * @return nombre de la Unidad Academica a obtener
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que establece el nombre de la Unidad Academica
     *
     * @param nombre nombre de la Unidad Academica a establecer
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que obtiene la lista de la relacion entre estudiante y
     * unidadAcademica
     *
     * @return lista de la relacion entre estudiante y unidadAcademica
     */
    public List<EstudianteEntidad> getEstudiantes() {
        return estudiantes;
    }

    /**
     * Metodo que establece la lista de la relacion entre estudiante y
     * unidadAcademica
     *
     * @param estudiantes lista de la relacion entre estudiante y
     * unidadAcademica a establecer
     */
    public void setEstudiantes(List<EstudianteEntidad> estudiantes) {
        this.estudiantes = estudiantes;
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
        if (!(object instanceof UnidadAcademicaEntidad)) {
            return false;
        }
        UnidadAcademicaEntidad other = (UnidadAcademicaEntidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.unidadAcademicaEntidad[ id=" + id + " ]";
    }

}
