/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.logica;

import java.util.ArrayList;
import java.util.List;
import negocio.DTO.CarreraDTO;
import negocio.DTO.EstudianteDTO;
import persistencia.DAO.CarreraDAO;
import persistencia.entidades.CarreraEntidad;
import persistencia.entidades.EstudianteEntidad;

/**
 * Clase CarreraNegocio
 * <p>
 * Esta clase proporciona la lógica de negocio para gestionar las carreras universitarias,
 * permitiendo realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre carreras
 * y gestionar la conversión entre DTOs y entidades de persistencia.
 * </p>
 * 
 * @author santi
 */
public class CarreraNegocio {

    CarreraDAO carreraDAO;

    /**
     * Constructor de CarreraNegocio
     * <p>
     * Inicializa un nuevo objeto CarreraDAO para manejar la persistencia de los datos
     * relacionados con las carreras.
     * </p>
     */
    public CarreraNegocio() {
        CarreraDAO carreraDAO = new CarreraDAO();
        this.carreraDAO = carreraDAO;
    }

    /**
     * Convierte un objeto CarreraDTO a una entidad CarreraEntidad.
     * 
     * @param dto el objeto CarreraDTO que se desea convertir.
     * @return la entidad CarreraEntidad correspondiente al DTO proporcionado.
     */
    public CarreraEntidad convertir(CarreraDTO dto) {
        EstudianteNegocio eN = new EstudianteNegocio();
        CarreraEntidad entidad = new CarreraEntidad();
        
        entidad.setIdCarrera(dto.getId());
        entidad.setNombre(dto.getNombre());
        entidad.setTiempoDiario(dto.getTiempoDiario());

        List<EstudianteEntidad> estudiantes = new ArrayList<>();
        for (EstudianteDTO y : dto.getEstudiantes()) {
            EstudianteEntidad x = eN.convertir(y);
            estudiantes.add(x);
        }
        
        entidad.setEstudiante(estudiantes);
        
        return entidad;
    }

    /**
     * Guarda una carrera en la base de datos.
     * 
     * @param c el objeto CarreraDTO que se desea guardar.
     */
    public void guardarCarrera(CarreraDTO c) {
        carreraDAO.guardarCarrera(convertir(c));
    }

    /**
     * Modifica una carrera existente en la base de datos.
     * 
     * @param c el objeto CarreraDTO con los datos actualizados de la carrera.
     */
    public void modificarCarrera(CarreraDTO c) {
        carreraDAO.modificarCarrera(convertir(c));
    }

    /**
     * Elimina una carrera de la base de datos.
     * 
     * @param c el objeto CarreraDTO que se desea eliminar.
     */
    public void eliminarCarrera(CarreraDTO c) {
        carreraDAO.eliminarCarrera(convertir(c));
    }

    /**
     * Busca una carrera específica por su identificador.
     * 
     * @param id el identificador único de la carrera a buscar.
     * @return un objeto CarreraDTO con los datos de la carrera encontrada.
     */
    public CarreraDTO buscarCarrera(Long id) {
        CarreraDTO carrera = new CarreraDTO(carreraDAO.buscarUnaCarrera(id));
        return carrera;
    }

    /**
     * Obtiene una lista de todas las carreras registradas.
     * 
     * @return una lista de objetos CarreraDTO que representa todas las carreras.
     *         Si no hay carreras, retorna null.
     */
    public List<CarreraDTO> buscarCarreras() {
        List<CarreraDTO> carreras = new ArrayList<>();
        List<CarreraEntidad> bE = new ArrayList<>();
        bE = carreraDAO.buscarTodasCarrera();
        
        if (carreras != null) {
            for (CarreraEntidad y : bE) {
                CarreraDTO x = new CarreraDTO(y);
                carreras.add(x);
            }
            return carreras;
        } else { 
            return null;
        }
    }
}
