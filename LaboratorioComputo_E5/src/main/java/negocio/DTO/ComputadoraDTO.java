/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.DTO;

import java.util.ArrayList;
import java.util.List;
import persistencia.entidades.ApartadoEntidad;
import persistencia.entidades.CentroComputoEntidad;
import persistencia.entidades.ComputadoraEntidad;
/**
 * a
 * @hidden
 */
public class ComputadoraDTO {

    /** Identificador único de la computadora */
    Long id;

    /** Indica si la computadora es administradora (esAdmin = true) o no */
    boolean esAdmin;

    /** Centro de cómputo al que pertenece la computadora */
    CentroComputoDTO centroComputo;

    /** Dirección IP de la computadora */
    String ip;

    /** Número de la computadora */
    int numComputadora;

    /** Lista de apartados reservados en la computadora */
    List<ApartadoDTO> apartados;

    /** Lista de software */
    List<String> software;

    /**
     * Constructor por defecto
     */
    public ComputadoraDTO() {
    }

    /**
     * Constructor completo
     * 
     * @param id Identificador único de la computadora
     * @param esAdmin Estado de administrador de la computadora
     * @param centroComputo Centro de cómputo al que pertenece la computadora
     * @param estudiante Estudiante asignado a la computadora
     * @param ip Dirección IP de la computadora
     * @param apartados Lista de apartados reservados
     */
    public ComputadoraDTO(Long id, boolean esAdmin, CentroComputoDTO centroComputo, String ip, List<ApartadoDTO> apartados, int numComputadora, List<String> software) {
        this.id = id;
        this.esAdmin = esAdmin;
        this.centroComputo = centroComputo;
        this.ip = ip;
        this.apartados = apartados;
        this.numComputadora = numComputadora;
        this.software = software;
        
    }

    /**
     * Constructor que convierte una entidad ComputadoraEntidad en un DTO.
     * 
     * @param cE Entidad de tipo ComputadoraEntidad
     */
    public ComputadoraDTO(ComputadoraEntidad cE) {
        this.id = cE.getIdComputadora();
        this.esAdmin = cE.isEsAdmin();
        CentroComputoDTO centro = new CentroComputoDTO(cE.getCentroComputoEntidad());
        this.centroComputo = centro;
        this.ip = cE.getIp();
        this.numComputadora = cE.getNumMaquina();
        this.software = cE.getSoftware();

//        if (cE.getApartado() != null){
//        List<ApartadoDTO> apartados = new ArrayList<>();
//        for (ApartadoEntidad a : cE.getApartado()) {
//            ApartadoDTO c = new ApartadoDTO(a);
//            apartados.add(c);
//        }
//        this.apartados = apartados;
//        } else{       this.apartados = null;}
    }

    /**
     * Obtiene el identificador único de la computadora
     * 
     * @return id Identificador de la computadora
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único de la computadora
     * 
     * @param id Identificador de la computadora
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el estado de administrador de la computadora
     * 
     * @return esAdmin Estado de administrador
     */
    public boolean isEsAdmin() {
        return esAdmin;
    }

    /**
     * Establece el estado de administrador de la computadora
     * 
     * @param esAdmin Estado de administrador
     */
    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }

    /**
     * Obtiene el centro de cómputo al que pertenece la computadora
     * 
     * @return centroComputo Centro de cómputo
     */
    public CentroComputoDTO getCentroComputo() {
        return centroComputo;
    }

    /**
     * Establece el centro de cómputo al que pertenece la computadora
     * 
     * @param centroComputo Centro de cómputo
     */
    public void setCentroComputo(CentroComputoDTO centroComputo) {
        this.centroComputo = centroComputo;
    }



    /**
     * Obtiene la dirección IP de la computadora
     * 
     * @return ip Dirección IP
     */
    public String getIp() {
        return ip;
    }

    /**
     * Establece la dirección IP de la computadora
     * 
     * @param ip Dirección IP
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * Obtiene la lista de software en la computadora
     * 
     * @return software
     */
    public List<String> getSoftware() {
        return software;
    }

    /**
     * Establece la lista de software en la computadora
     * 
     * @param apartados Lista de software en la computadora
     */
    public void setSoftware(List<String> software) {
        this.software = software;
    }

    /**
     * Obtiene la lista de apartados reservados en la computadora
     * 
     * @return apartados Lista de apartados
     */
    public List<ApartadoDTO> getApartados() {
        return apartados;
    }

    /**
     * Establece la lista de apartados reservados en la computadora
     * 
     * @param apartados Lista de apartados
     */
    public void setApartados(List<ApartadoDTO> apartados) {
        this.apartados = apartados;
    }

    /**
     * Obtiene numComputadora en la computadora
     * 
     * @return numComputadora
     */
    public int getNumComputadora() {
        return numComputadora;
    }

    /**
     * Establece numComputadora en la computadora
     * 
     * @param numComputadora numComputadora en la computadora
     */
    public void setNumComputadora(int numComputadora) {
        this.numComputadora = numComputadora;
    }


    

    /**
     * Método toString para representar el objeto en formato de texto
     * 
     * @return Cadena de texto con los valores de los atributos de la computadora
     */
    @Override
    public String toString() {
        return "ComputadoraDTO{" + "id=" + id + ", esAdmin=" + esAdmin + ", centroComputo=" + centroComputo + ", ip=" + ip + ", numComputadora=" + numComputadora + ", apartados=" + apartados + ", software=" + software + '}';
    }


}
