/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.DTO;

import java.util.ArrayList;
import java.util.List;
import persistencia.entidades.ApartadoEntidad;
import persistencia.entidades.BloqueoEntidad;
import persistencia.entidades.EstudianteEntidad;
/**
 * Clase DTO (Data Transfer Object) que representa un estudiante.
 * Contiene los datos básicos del estudiante, incluyendo su computadora asignada,
 * carrera, contraseñas, estado de inscripción, y listas de bloqueos y apartados.
 */
public class EstudianteDTO {

    /** Identificador único del estudiante */
    Long id;

    /** Nombre del estudiante */
    String nombre;

    /** Apellido paterno del estudiante */
    String apellidoPaterno;

    /** Apellido materno del estudiante */
    String apellidoMaterno;


    /** Contraseña del estudiante */
    String contrasenia;

    /** Estado de inscripción del estudiante */
    String estatusInscripcion;

    /** Carrera del estudiante */
    CarreraDTO carrera;

    /** Lista de bloqueos asociados al estudiante */
    List<BloqueoDTO> bloqueos;

    /** Lista de apartados realizados por el estudiante */
    List<ApartadoDTO> apartados;

    /**
     * Constructor por defecto.
     */
    public EstudianteDTO() {
    }

    /**
     * Constructor completo.
     * 
     * @param id Identificador único del estudiante
     * @param nombre Nombre del estudiante
     * @param apellidoPaterno Apellido paterno del estudiante
     * @param apellidoMaterno Apellido materno del estudiante
     * @param computadora Computadora asignada al estudiante
     * @param contrasenia Contraseña del estudiante
     * @param estatusInscripcion Estado de inscripción del estudiante
     * @param bloqueos Lista de bloqueos asociados al estudiante
     * @param apartados Lista de apartados realizados por el estudiante
     * @param carrera Carrera del estudiante
     */
    public EstudianteDTO(Long id, String nombre, String apellidoPaterno, CarreraDTO carrera, String apellidoMaterno, String contrasenia, String estatusInscripcion, List<BloqueoDTO> bloqueos, List<ApartadoDTO> apartados) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.contrasenia = contrasenia;
        this.estatusInscripcion = estatusInscripcion;
        this.bloqueos = bloqueos;
        this.apartados = apartados;
        this.carrera = carrera;
    }

    /**
     * Constructor que convierte una entidad EstudianteEntidad en un DTO.
     * 
     * @param e Entidad de tipo EstudianteEntidad
     */
    public EstudianteDTO(EstudianteEntidad e) {
        this.id = e.getId();
        this.nombre = e.getNombre();
        this.apellidoPaterno = e.getApellidoPaterno();
        this.apellidoMaterno = e.getApellidoMaterno();

        this.contrasenia = e.getContrasenia();
        this.estatusInscripcion = e.getEstatusInscripcion();

//
//        if (e.getApartado()!= null){
//        List<ApartadoDTO> apartados = new ArrayList<>();
//        for (ApartadoEntidad y : e.getApartado()) {
//            ApartadoDTO x = new ApartadoDTO(y);
//            apartados.add(x);
//        }
//        this.apartados = apartados;
//                } else{        this.apartados = null;}
//
//        
//        if (e.getBloqueo() != null){
//        List<BloqueoDTO> bloqueos = new ArrayList<>();
//        for (BloqueoEntidad y : e.getBloqueo()) {
//            BloqueoDTO x = new BloqueoDTO(y);
//            bloqueos.add(x);
//        }
//        this.bloqueos = bloqueos;     
//        
//                } else{        this.bloqueos = null;}
//        
    }

    /**
     * Obtiene el identificador único del estudiante.
     * 
     * @return id Identificador del estudiante
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único del estudiante.
     * 
     * @param id Identificador del estudiante
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del estudiante.
     * 
     * @return nombre Nombre del estudiante
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del estudiante.
     * 
     * @param nombre Nombre del estudiante
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido paterno del estudiante.
     * 
     * @return apellidoPaterno Apellido paterno del estudiante
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Establece el apellido paterno del estudiante.
     * 
     * @param apellidoPaterno Apellido paterno del estudiante
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Obtiene el apellido materno del estudiante.
     * 
     * @return apellidoMaterno Apellido materno del estudiante
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Establece el apellido materno del estudiante.
     * 
     * @param apellidoMaterno Apellido materno del estudiante
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }



    /**
     * Obtiene la contraseña del estudiante.
     * 
     * @return contrasenia Contraseña del estudiante
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Establece la contraseña del estudiante.
     * 
     * @param contrasenia Contraseña del estudiante
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Obtiene el estado de inscripción del estudiante.
     * 
     * @return estatusInscripcion Estado de inscripción del estudiante
     */
    public String getEstatusInscripcion() {
        return estatusInscripcion;
    }

    /**
     * Establece el estado de inscripción del estudiante.
     * 
     * @param estatusInscripcion Estado de inscripción del estudiante
     */
    public void setEstatusInscripcion(String estatusInscripcion) {
        this.estatusInscripcion = estatusInscripcion;
    }

    /**
     * Obtiene la lista de bloqueos asociados al estudiante.
     * 
     * @return bloqueos Lista de bloqueos
     */
    public List<BloqueoDTO> getBloqueos() {
        return bloqueos;
    }

    /**
     * Establece la lista de bloqueos asociados al estudiante.
     * 
     * @param bloqueos Lista de bloqueos
     */
    public void setBloqueos(List<BloqueoDTO> bloqueos) {
        this.bloqueos = bloqueos;
    }

    /**
     * Obtiene la lista de apartados realizados por el estudiante.
     * 
     * @return apartados Lista de apartados
     */
    public List<ApartadoDTO> getApartados() {
        return apartados;
    }

    /**
     * Establece la lista de apartados realizados por el estudiante.
     * 
     * @param apartados Lista de apartados
     */
    public void setApartados(List<ApartadoDTO> apartados) {
        this.apartados = apartados;
    }

    /**
     * Obtiene la carrera del estudiante.
     * 
     * @return carrera Carrera del estudiante
     */
    public CarreraDTO getCarrera() {
        return carrera;
    }

    /**
     * Establece la carrera del estudiante.
     * 
     * @param carrera Carrera del estudiante
     */
    public void setCarrera(CarreraDTO carrera) {
        this.carrera = carrera;
    }

    /**
     * Método toString para representar el objeto en formato de texto.
     * 
     * @return Cadena de texto con los valores de los atributos del estudiante
     */
    @Override
    public String toString() {
        return "EstudianteDTO{" + "id=" + id + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno  + ", contrasenia=" + contrasenia + ", estatusInscripcion=" + estatusInscripcion + ", bloqueos=" + bloqueos + ", apartados=" + apartados + '}';
    }
}
