/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.entidades;

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
 * La clase {@code UnidadAcademicaEntidad} representa una unidad de ITSON en la
 * bd.
 *
 * @author sebasglez
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
    private List<CentroComputoEntidad> centrosComputo;

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
     * Metodo que obtiene la lista de la relacion entre los centros de computo y
     * la unidadAcademica
     *
     * @return lista de relacion entre los centros de computo y la
     * unidadAcademica
     */
    public List<CentroComputoEntidad> getCentrosComputo() {
        return centrosComputo;
    }

    /**
     * Metodo que establece la lista de la relacion entre los centros de computo
     * y la unidadAcademica
     *
     * @param centrosComputo lista de relacion entre los centros de computo y la
     * unidadAcademica
     */
    public void setCentrosComputo(List<CentroComputoEntidad> centrosComputo) {
        this.centrosComputo = centrosComputo;
    }

}
