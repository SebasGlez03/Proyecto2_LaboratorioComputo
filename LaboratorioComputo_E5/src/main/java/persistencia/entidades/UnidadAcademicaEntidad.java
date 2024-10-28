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
 * La clase {@code UnidadAcademicaEntidad} representa una unidad académica en la
 * base de datos de ITSON. Esta entidad almacena información sobre las unidades
 * académicas y sus respectivos centros de cómputo.
 *
 * <p>
 * Esta clase implementa la interfaz {@code Serializable} para permitir la
 * serialización de sus instancias.
 * </p>
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
     * Constructor por omisión que inicializa una nueva instancia de
     * {@code UnidadAcademicaEntidad}.
     */
    public UnidadAcademicaEntidad() {
    }

    /**
     * Constructor que inicializa el atributo de la clase "nombre".
     *
     * @param nombre El nombre de la unidad académica a establecer.
     */
    public UnidadAcademicaEntidad(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que obtiene el ID de la unidad académica.
     *
     * @return El ID de la unidad académica.
     */
    public Long getId() {
        return id;
    }

    /**
     * Método que establece el ID de la unidad académica.
     *
     * @param id El ID de la unidad académica a establecer.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Método que obtiene el nombre de la unidad académica.
     *
     * @return El nombre de la unidad académica.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que establece el nombre de la unidad académica.
     *
     * @param nombre El nombre de la unidad académica a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que obtiene la lista de centros de cómputo asociados a la unidad
     * académica.
     *
     * @return La lista de centros de cómputo.
     */
    public List<CentroComputoEntidad> getCentrosComputo() {
        return centrosComputo;
    }

    /**
     * Método que establece la lista de centros de cómputo asociados a la unidad
     * académica.
     *
     * @param centrosComputo La lista de centros de cómputo a establecer.
     */
    public void setCentrosComputo(List<CentroComputoEntidad> centrosComputo) {
        this.centrosComputo = centrosComputo;
    }
}
