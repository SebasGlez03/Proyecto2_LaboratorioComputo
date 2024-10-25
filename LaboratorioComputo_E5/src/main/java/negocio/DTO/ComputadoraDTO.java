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
 *
 * @author santi
 */
public class ComputadoraDTO {
    
    Long id;
    boolean esAdmin;
    CentroComputoDTO centroComputo;
    EstudianteDTO estudiante;
    String ip;
    List<ApartadoDTO> apartados;

    public ComputadoraDTO() {
    }

    public ComputadoraDTO(Long id, boolean esAdmin, CentroComputoDTO centroComputo, EstudianteDTO estudiante, String ip, List<ApartadoDTO> apartados) {
        this.id = id;
        this.esAdmin = esAdmin;
        this.centroComputo = centroComputo;
        this.estudiante = estudiante;
        this.ip = ip;
        this.apartados = apartados;
    }
    
    public ComputadoraDTO(ComputadoraEntidad cE){
    
        this.id = cE.getIdComputadora();
        this.esAdmin = cE.isEsAdmin();
        CentroComputoDTO centro = new CentroComputoDTO(cE.getCentroComputoEntidad());
        this.centroComputo = centro;
        EstudianteDTO estudiante = new EstudianteDTO(cE.getEstudiante());
        this.estudiante = estudiante;
        this.ip = cE.getIp();
        
        List<ApartadoDTO> apartados = new ArrayList<>();
        for (ApartadoEntidad a : cE.getApartado()) {
            ApartadoDTO c = new ApartadoDTO(a);
            apartados.add(c);
        }
        this.apartados = apartados;
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isEsAdmin() {
        return esAdmin;
    }

    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }

    public CentroComputoDTO getCentroComputo() {
        return centroComputo;
    }

    public void setCentroComputo(CentroComputoDTO centroComputo) {
        this.centroComputo = centroComputo;
    }

    public EstudianteDTO getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteDTO estudiante) {
        this.estudiante = estudiante;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public List<ApartadoDTO> getApartados() {
        return apartados;
    }

    public void setApartados(List<ApartadoDTO> apartados) {
        this.apartados = apartados;
    }

    @Override
    public String toString() {
        return "ComputadoraDTO{" + "id=" + id + ", esAdmin=" + esAdmin + ", centroComputo=" + centroComputo + ", estudiante=" + estudiante + ", ip=" + ip + ", apartados=" + apartados + '}';
    }    
    
}
