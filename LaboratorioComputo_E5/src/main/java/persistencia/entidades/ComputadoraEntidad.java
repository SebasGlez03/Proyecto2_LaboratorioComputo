/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.entidades;

import persistencia.entidades.CentroComputoEntidad;
import persistencia.entidades.EstudianteEntidad;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
 * Representa una computadora dentro del sistema de gestión de laboratorios. La
 * entidad está mapeada a la tabla "tblComputadora" en la base de datos.
 *
 * Cada computadora está asociada a un centro de cómputo y almacena información
 * como la dirección IP, su estatus de inscripción, los programas instalados y
 * el número de máquina.
 *
 * Esta clase implementa {@link Serializable} para permitir la serialización y
 * la correcta persistencia de los objetos en la base de datos.
 *
 * @author santi
 */
@Entity
@Table(name = "tblComputadora")
public class ComputadoraEntidad implements Serializable {

    /**
     * Identificador único de la computadora. Es generado automáticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idComputadora")
    private Long idComputadora;

    @Column(name = "esAdmin", nullable = false)
    private boolean esAdmin;

    /**
     * Relación de muchos-a-uno con el centro de cómputo al que pertenece la
     * computadora. Está mapeado a la columna "idCentroComputo" en la base de
     * datos.
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idCentroComputo", nullable = false)
    private CentroComputoEntidad centroComputoEntidad;

    /**
     * Dirección IP de la computadora. No puede ser nula y debe tener un máximo
     * de 50 caracteres.
     */
    @Column(name = "ip", length = 50, nullable = false)
    private String ip;

    /**
     * Lista de programas (software) instalados en la computadora. Se almacena
     * como una colección de elementos en una tabla secundaria.
     */
    @ElementCollection
    @CollectionTable(name = "Software_Computadoras", joinColumns = @JoinColumn(name = "COMPUTADORA"))
    private List<String> software;

    /**
     * Número de la máquina. Permite identificar de manera única la ubicación de
     * la computadora en el laboratorio. No puede ser nulo y tiene un máximo de
     * 50 caracteres.
     */
    @Column(name = "numMaquina", length = 50)
    private int numMaquina;

    @OneToMany(mappedBy = "computadora")
    private List<ApartadoEntidad> apartado;

    /**
     * Constructor por defecto de la entidad. Es requerido por JPA para crear
     * instancias de la entidad.
     */
    public ComputadoraEntidad() {
    }

    /**
     * Constructor para inicializar una entidad Computadora con los valores
     * proporcionados
     *
     * @param esAdmin Si la computadora es admin (true si es admun, false en
     * caso contrario)
     * @param centroComputoEntidad La entidad que representa el centro de
     * computo al que pertenece la computadora.
     * @param ip La direccion IP de la computadora.
     * @param software Lista de software que puede utilizar la computadora.
     * @param numMaquina El numero de maquina de la computadora dentro del
     * centro de computo.
     */
    public ComputadoraEntidad(boolean esAdmin, CentroComputoEntidad centroComputoEntidad, String ip, List<String> software, int numMaquina) {
        this.esAdmin = esAdmin;
        this.centroComputoEntidad = centroComputoEntidad;
        this.ip = ip;
        this.software = software;
        this.numMaquina = numMaquina;
    }

    /**
     * Obtiene el identificador único de la computadora.
     *
     * @return El identificador de la computadora.
     */
    public Long getIdComputadora() {
        return idComputadora;
    }

    /**
     * Establece el identificador único de la computadora.
     *
     * @param idComputadora El nuevo identificador de la computadora.
     */
    public void setIdComputadora(Long idComputadora) {
        this.idComputadora = idComputadora;
    }

    /**
     * Metodo que obtiene si la computadora es admin.
     *
     * @return True si es admin, false en caso contrario.
     */
    public boolean isEsAdmin() {
        return esAdmin;
    }

    /**
     * Metodo que establece si la computadora es admin.
     *
     * @param esAdmin True si es admin, false en caso contrario.
     */
    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }

    /**
     * Obtiene el centro de cómputo al que pertenece esta computadora.
     *
     * @return La entidad {@link CentroComputoEntidad} asociada.
     */
    public CentroComputoEntidad getCentroComputoEntidad() {
        return centroComputoEntidad;
    }

    /**
     * Establece el centro de cómputo al que pertenece esta computadora.
     *
     * @param centroComputoEntidad La nueva entidad {@link CentroComputoEntidad}
     * asociada.
     */
    public void setCentroComputoEntidad(CentroComputoEntidad centroComputoEntidad) {
        this.centroComputoEntidad = centroComputoEntidad;
    }

    /**
     * Obtiene la dirección IP de la computadora.
     *
     * @return La dirección IP como una cadena de texto.
     */
    public String getIp() {
        return ip;
    }

    /**
     * Establece la dirección IP de la computadora.
     *
     * @param ip La nueva dirección IP.
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * Obtiene la lista de software instalado en la computadora.
     *
     * @return Una lista de programas instalados.
     */
    public List<String> getSoftware() {
        return software;
    }

    /**
     * Establece la lista de software instalado en la computadora.
     *
     * @param software La nueva lista de programas.
     */
    public void setSoftware(List<String> software) {
        this.software = software;
    }

    /**
     * Obtiene el número de la máquina.
     *
     * @return El número de la máquina.
     */
    public int getNumMaquina() {
        return numMaquina;
    }

    /**
     * Establece el número de la máquina.
     *
     * @param numMaquina El nuevo número de la máquina.
     */
    public void setNumMaquina(int numMaquina) {
        this.numMaquina = numMaquina;
    }

    /**
     * Obtiene la lista de apartado que estan asociadas ca una computadora.
     *
     * @return Lista de apartado que estan asociadas con la computadora.
     */
    public List<ApartadoEntidad> getApartado() {
        return apartado;
    }

    /**
     * Establece la lista de apartado que estan asociadas a una computadora.
     *
     * @param rentas Lista de apartado que estan asociadas a una computadora a
     * establecer.
     */
    public void setApartado(List<ApartadoEntidad> rentas) {
        this.apartado = rentas;
    }

    /**
     * Proporciona una representación en cadena de la entidad.
     *
     * @return Una cadena que representa los valores de los atributos de la
     * computadora.
     */
    @Override
    public String toString() {
        return "ComputadoraEntidad{" + "idComputadora=" + idComputadora + ", esAdmin=" + esAdmin + ", centroComputoEntidad=" + centroComputoEntidad + ", ip=" + ip + ", software=" + software + ", numMaquina=" + numMaquina + ", rentas=" + apartado + '}';
    }

}
