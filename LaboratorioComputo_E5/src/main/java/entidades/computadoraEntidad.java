/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
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
 * Representa una computadora dentro del sistema de gestión de laboratorios.
 * La entidad está mapeada a la tabla "tblComputadora" en la base de datos.
 * 
 * Cada computadora está asociada a un centro de cómputo y almacena información
 * como la dirección IP, su estatus de inscripción, los programas instalados y el número de máquina.
 * 
 * Esta clase implementa {@link Serializable} para permitir la serialización y la
 * correcta persistencia de los objetos en la base de datos.
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idComputadora;

    /**
     * Relación de muchos-a-uno con el centro de cómputo al que pertenece la computadora.
     * Está mapeado a la columna "idCentroComputo" en la base de datos.
     */
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idCentroComputo", nullable = false)
    private CentroComputoEntidad centroComputoEntidad;    

    /**
     * Relación de uno-a-uno con el estudiante que está utilizando la computadora.
     * Está mapeado a la columna "idEstudiante" en la base de datos.
     */
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "nombreReservado", referencedColumnName = "idEstudiante")
    private estudianteEntidad estudiante;
    
    /**
     * Dirección IP de la computadora. No puede ser nula y debe tener un máximo de 50 caracteres.
     */
    @Column(name = "IP", length = 50, nullable = false)
    private String ip;

    /**
     * Estatus de inscripción de la computadora, puede ser "Disponible" o cualquier otro valor.
     * Tiene un máximo de 50 caracteres.
     */
    @Column(name = "EstatusInscripcion", length = 50)
    private String estatusoInscripcion;

    /**
     * Lista de programas (software) instalados en la computadora.
     * Se almacena como una colección de elementos en una tabla secundaria.
     */
    @ElementCollection
    private List<String> software = new ArrayList<>();

    /**
     * Número de la máquina. Permite identificar de manera única la ubicación de la computadora en el laboratorio.
     * No puede ser nulo y tiene un máximo de 50 caracteres.
     */
    @Column(name = "NumMaquina", length = 50, nullable = false)
    private int numMaquina;

    /**
     * Constructor por defecto de la entidad. 
     * Es requerido por JPA para crear instancias de la entidad.
     */
    public ComputadoraEntidad() {
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
     * @param centroComputoEntidad La nueva entidad {@link CentroComputoEntidad} asociada.
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
     * Obtiene el estatus de inscripción de la computadora.
     * 
     * @return El estatus de inscripción.
     */
    public String getEstatusoInscripcion() {
        return estatusoInscripcion;
    }

    /**
     * Establece el estatus de inscripción de la computadora.
     * 
     * @param estatusoInscripcion El nuevo estatus de inscripción.
     */
    public void setEstatusoInscripcion(String estatusoInscripcion) {
        this.estatusoInscripcion = estatusoInscripcion;
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
     * Obtiene el estudiante usando la maquina.
     * 
     * @return El estudiante usando la maquina.
     */
    public estudianteEntidad getEstudiante() {
        return estudiante;
    }

    /**
     * Establece el estudiante usando la maquina.
     * 
     * @param estudiante El estudiante usando la máquina.
     */
    public void setEstudiante(estudianteEntidad estudiante) {
        this.estudiante = estudiante;
    }

    
    
    /**
     * Proporciona una representación en cadena de la entidad.
     * 
     * @return Una cadena que representa los valores de los atributos de la computadora.
     */

    @Override
    public String toString() {
        return "computadoraEntidad{" + "idComputadora=" + idComputadora + ", centroComputoEntidad=" + centroComputoEntidad + ", estudiante=" + estudiante + ", ip=" + ip + ", estatusoInscripcion=" + estatusoInscripcion + ", software=" + software + ", numMaquina=" + numMaquina + '}';
    }


}
