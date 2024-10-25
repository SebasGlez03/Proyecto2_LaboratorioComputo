/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.DTO;

import java.util.List;

/**
 *
 * @author santi
 */
public class EstudianteDTO {
    
    Long id;
    String nombre;
    String apellidoPaterno;
    String apellidoMaterno;
    ComputadoraDTO computadora;
    String contrasenia;
    String estatusInscripcion;
    List<BloqueoDTO> bloqueos;
    List<ApartadoDTO> apartados;

    public EstudianteDTO() {
    }

    public EstudianteDTO(Long id, String nombre, String apellidoPaterno, String apellidoMaterno, ComputadoraDTO computadora, String contrasenia, String estatusInscripcion, List<BloqueoDTO> bloqueos, List<ApartadoDTO> apartados) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.computadora = computadora;
        this.contrasenia = contrasenia;
        this.estatusInscripcion = estatusInscripcion;
        this.bloqueos = bloqueos;
        this.apartados = apartados;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public ComputadoraDTO getComputadora() {
        return computadora;
    }

    public void setComputadora(ComputadoraDTO computadora) {
        this.computadora = computadora;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getEstatusInscripcion() {
        return estatusInscripcion;
    }

    public void setEstatusInscripcion(String estatusInscripcion) {
        this.estatusInscripcion = estatusInscripcion;
    }

    public List<BloqueoDTO> getBloqueos() {
        return bloqueos;
    }

    public void setBloqueos(List<BloqueoDTO> bloqueos) {
        this.bloqueos = bloqueos;
    }

    public List<ApartadoDTO> getApartados() {
        return apartados;
    }

    public void setApartados(List<ApartadoDTO> apartados) {
        this.apartados = apartados;
    }

    @Override
    public String toString() {
        return "EstudianteDTO{" + "id=" + id + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", computadora=" + computadora + ", contrasenia=" + contrasenia + ", estatusInscripcion=" + estatusInscripcion + ", bloqueos=" + bloqueos + ", apartados=" + apartados + '}';
    }
    
    
}
