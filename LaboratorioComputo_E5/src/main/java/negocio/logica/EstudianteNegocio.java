/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.logica;

import java.util.ArrayList;
import java.util.List;
import negocio.DTO.ApartadoDTO;
import negocio.DTO.BloqueoDTO;
import negocio.DTO.ComputadoraDTO;
import negocio.DTO.EstudianteDTO;
import persistencia.DAO.EstudianteDAO;
import persistencia.entidades.ApartadoEntidad;
import persistencia.entidades.BloqueoEntidad;
import persistencia.entidades.ComputadoraEntidad;
import persistencia.entidades.EstudianteEntidad;

/**
 * Clase EstudianteNegocio
 * <p>
 * Esta clase gestiona la lógica de negocio para la entidad Estudiante, permitiendo
 * realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) y gestionar la
 * conversión entre objetos DTO y entidades de persistencia.
 * </p>
 * 
 * @autor santi
 */
public class EstudianteNegocio {

    EstudianteDAO estudianteDAO;

    /**
     * Constructor de EstudianteNegocio.
     * <p>
     * Inicializa un nuevo objeto EstudianteDAO para manejar la persistencia de
     * los datos relacionados con los estudiantes.
     * </p>
     */
    public EstudianteNegocio() {
        EstudianteDAO estudianteDAO = new EstudianteDAO();
        this.estudianteDAO = estudianteDAO;
    }

    /**
     * Convierte un objeto EstudianteDTO a una entidad EstudianteEntidad.
     * 
     * @param dto el objeto EstudianteDTO que se desea convertir.
     * @return la entidad EstudianteEntidad correspondiente al DTO proporcionado.
     */
    public EstudianteEntidad convertir(EstudianteDTO dto) {
        BloqueoNegocio bN = new BloqueoNegocio();
        CarreraNegocio caN = new CarreraNegocio();
        ApartadoNegocio aN = new ApartadoNegocio();
        CarreraNegocio cN = new CarreraNegocio();
        EstudianteEntidad entidad = new EstudianteEntidad();

        entidad.setId(dto.getId());
        entidad.setNombre(dto.getNombre());
        entidad.setApellidoMaterno(dto.getApellidoMaterno());
        entidad.setApellidoPaterno(dto.getApellidoPaterno());
        entidad.setEstatusInscripcion(dto.getEstatusInscripcion());
        entidad.setContrasenia(dto.getContrasenia());
        
        if (dto.getCarrera() != null){
            
        entidad.setCarrera(cN.convertir(dto.getCarrera()));
        }

        // Convierte la lista de ApartadoDTO a ApartadoEntidad si existen
        if (dto.getApartados() != null) {
            List<ApartadoEntidad> apartados = new ArrayList<>();
            for (ApartadoDTO y : dto.getApartados()) {
                ApartadoEntidad x = aN.convertir(y);
                apartados.add(x);
            }
            entidad.setApartado(apartados);
        } else {
            entidad.setApartado(null);
        }

        // Convierte la lista de BloqueoDTO a BloqueoEntidad si existen
        if (dto.getBloqueos() != null) {
            List<BloqueoEntidad> bloqueos = new ArrayList<>();
            for (BloqueoDTO y : dto.getBloqueos()) {
                BloqueoEntidad x = bN.convertir(y);
                bloqueos.add(x);
            }
            entidad.setBloqueo(bloqueos);
        } else {
            entidad.setBloqueo(null);
        }

        return entidad;
    }

    /**
     * Guarda un estudiante en la base de datos.
     * 
     * @param e el objeto EstudianteDTO que se desea guardar.
     */
    public void guardarEstudiante(EstudianteDTO e) {
        estudianteDAO.guardarEstudiante(convertir(e));
    }

    /**
     * Modifica un estudiante existente en la base de datos.
     * 
     * @param e el objeto EstudianteDTO con los datos actualizados del estudiante.
     */
    public void modificarEstudiante(EstudianteDTO e) {
        estudianteDAO.modificarEstudiante(convertir(e));
    }

    /**
     * Elimina un estudiante de la base de datos.
     * 
     * @param e el objeto EstudianteDTO que se desea eliminar.
     */
    public void eliminarEstudiante(EstudianteDTO e) {
        estudianteDAO.eliminarEstudiante(convertir(e));
    }

    /**
     * Busca un estudiante específico por su identificador.
     * 
     * @param id el identificador único del estudiante a buscar.
     * @return un objeto EstudianteDTO con los datos del estudiante encontrado.
     */
    public EstudianteDTO buscarEstudiante(Long id) {
        
        EstudianteDTO estudiante = new EstudianteDTO();
        
        if (estudianteDAO.buscarUnEstudiante(id) != null){
        estudiante = new EstudianteDTO(estudianteDAO.buscarUnEstudiante(id));
        return estudiante;
        }
        else{
        
            return null;
            
        }
    }

    /**
     * Obtiene una lista de todos los estudiantes registrados.
     * 
     * @return una lista de objetos EstudianteDTO que representa todos los estudiantes.
     *         Si no hay estudiantes, retorna null.
     */
    public List<EstudianteDTO> buscarEstudiante() {
        List<EstudianteDTO> estudiantes = new ArrayList<>();
        List<EstudianteEntidad> bE = estudianteDAO.buscarTodosEstudiante();

        if (estudiantes != null) {
            for (EstudianteEntidad y : bE) {
                EstudianteDTO x = new EstudianteDTO(y);
                estudiantes.add(x);
            }
            return estudiantes;
        } else {
            return null;
        }
    }
}
