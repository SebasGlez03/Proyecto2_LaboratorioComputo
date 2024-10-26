/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.logica;

import java.util.ArrayList;
import java.util.List;
import negocio.DTO.ApartadoDTO;
import negocio.DTO.BloqueoDTO;
import persistencia.DAO.BloqueoDAO;
import persistencia.entidades.ApartadoEntidad;
import persistencia.entidades.BloqueoEntidad;

/**
 * Clase BloqueoNegocio
 * <p>
 * Esta clase proporciona la lógica de negocio para gestionar los bloqueos de computadoras.
 * Permite realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre bloqueos,
 * y convertir entidades BloqueoDTO a BloqueoEntidad para interactuar con la capa de persistencia.
 * </p>
 * 
 * @author santi
 */
public class BloqueoNegocio {

    BloqueoDAO bloqueoDAO;

    /**
     * Constructor de BloqueoNegocio
     * <p>
     * Inicializa un nuevo objeto BloqueoDAO para manejar la persistencia de los datos
     * relacionados con bloqueos.
     * </p>
     */
    public BloqueoNegocio() {
        BloqueoDAO bloqueoDAO = new BloqueoDAO();
        this.bloqueoDAO = bloqueoDAO;
    }

    /**
     * Convierte un BloqueoDTO a una entidad BloqueoEntidad.
     * 
     * @param dto el objeto BloqueoDTO que se desea convertir.
     * @return la entidad BloqueoEntidad correspondiente al DTO proporcionado.
     */
    public BloqueoEntidad convertir(BloqueoDTO dto) {
        ComputadoraNegocio cN = new ComputadoraNegocio();
        EstudianteNegocio eN = new EstudianteNegocio();
        BloqueoEntidad entidad = new BloqueoEntidad();
        
        entidad.setId(dto.getId());
        entidad.setFechaBloqueo(dto.getFechaBloqueo());
        entidad.setFechaLiberacion(dto.getFechaLiberacion());
        entidad.setMotivo(dto.getMotivo());
        entidad.setEstudiante(eN.convertir(dto.getEstudiante()));
        
        return entidad;
    }

    /**
     * Guarda un bloqueo en la base de datos.
     * 
     * @param b el objeto BloqueoDTO que se desea guardar.
     */
    public void guardarBloqueo(BloqueoDTO b) {
        bloqueoDAO.guardarBloqueo(convertir(b));
    }

    /**
     * Modifica un bloqueo existente en la base de datos.
     * 
     * @param b el objeto BloqueoDTO que contiene los datos actualizados del bloqueo.
     */
    public void modificarBloqueo(BloqueoDTO b) {
        bloqueoDAO.modificarBloqueo(convertir(b));
    }

    /**
     * Elimina un bloqueo de la base de datos.
     * 
     * @param b el objeto BloqueoDTO que se desea eliminar.
     */
    public void eliminarBloqueo(BloqueoDTO b) {
        bloqueoDAO.eliminarBloqueo(convertir(b));
    }

    /**
     * Busca un bloqueo específico por su identificador.
     * 
     * @param id el identificador único del bloqueo a buscar.
     * @return un objeto BloqueoDTO con los datos del bloqueo encontrado.
     */
    public BloqueoDTO buscarBloqueo(Long id) {
        BloqueoDTO bloqueo = new BloqueoDTO(bloqueoDAO.buscarUnBloqueo(id));
        return bloqueo;
    }

    /**
     * Obtiene una lista de todos los bloqueos registrados.
     * 
     * @return una lista de objetos BloqueoDTO que representa todos los bloqueos.
     *         Si no hay bloqueos, retorna null.
     */
    public List<BloqueoDTO> buscarBloqueos() {
        List<BloqueoDTO> bloqueos = new ArrayList<>();
        List<BloqueoEntidad> bE = new ArrayList<>();
        bE = bloqueoDAO.buscarTodosBloqueos();
        
        if (bloqueos != null) {
            for (BloqueoEntidad y : bE) {
                BloqueoDTO x = new BloqueoDTO(y);
                bloqueos.add(x);
            }
            return bloqueos;
        } else { 
            return null;
        }
    }
}
