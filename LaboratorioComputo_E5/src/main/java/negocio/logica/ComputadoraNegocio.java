/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.logica;

import java.util.ArrayList;
import java.util.List;
import negocio.DTO.ApartadoDTO;
import negocio.DTO.CentroComputoDTO;
import negocio.DTO.ComputadoraDTO;
import persistencia.DAO.ComputadoraDAO;
import persistencia.entidades.ApartadoEntidad;
import persistencia.entidades.CentroComputoEntidad;
import persistencia.entidades.ComputadoraEntidad;

/**
 * Clase ComputadoraNegocio
 * <p>
 * Esta clase proporciona la lógica de negocio para la gestión de computadoras,
 * permitiendo realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre
 * computadoras y gestionar la conversión entre objetos DTO y entidades de persistencia.
 * </p>
 * 
 * @autor santi
 */
public class ComputadoraNegocio {

    ComputadoraDAO computadoraDAO;

    /**
     * Constructor de ComputadoraNegocio.
     * <p>
     * Inicializa un nuevo objeto ComputadoraDAO para manejar la persistencia de los datos
     * relacionados con las computadoras.
     * </p>
     */
    public ComputadoraNegocio() {
        ComputadoraDAO computadoraDAO = new ComputadoraDAO();
        this.computadoraDAO = computadoraDAO;
    }

    /**
     * Convierte un objeto ComputadoraDTO a una entidad ComputadoraEntidad.
     * 
     * @param dto el objeto ComputadoraDTO que se desea convertir.
     * @return la entidad ComputadoraEntidad correspondiente al DTO proporcionado.
     */
    public ComputadoraEntidad convertir(ComputadoraDTO dto) {
        EstudianteNegocio eN = new EstudianteNegocio();
        CentroComputoNegocio ccN = new CentroComputoNegocio();
        ComputadoraEntidad computadora = new ComputadoraEntidad();

        computadora.setIdComputadora(dto.getId());
        computadora.setIp(dto.getIp());
        computadora.setNumMaquina(dto.getNumComputadora());
        computadora.setEsAdmin(dto.isEsAdmin());
        computadora.setSoftware(dto.getSoftware());
        computadora.setCentroComputoEntidad(ccN.convertir(dto.getCentroComputo()));

        return computadora;
    }

    /**
     * Guarda una computadora en la base de datos.
     * 
     * @param c el objeto ComputadoraDTO que se desea guardar.
     */
    public void guardarComputadora(ComputadoraDTO c) {
        computadoraDAO.guardarComputadora(convertir(c));
    }

    /**
     * Modifica una computadora existente en la base de datos.
     * 
     * @param c el objeto ComputadoraDTO con los datos actualizados de la computadora.
     */
    public void modificarComputadora(ComputadoraDTO c) {
        computadoraDAO.modificarComputadora(convertir(c));
    }

    /**
     * Elimina una computadora de la base de datos.
     * 
     * @param c el objeto ComputadoraDTO que se desea eliminar.
     */
    public void eliminarComputadora(ComputadoraDTO c) {
        computadoraDAO.eliminarComputadora(convertir(c));
    }

    /**
     * Busca una computadora específica por su identificador.
     * 
     * @param id el identificador único de la computadora a buscar.
     * @return un objeto ComputadoraDTO con los datos de la computadora encontrada.
     */
    public ComputadoraDTO buscarComputadora(Long id) {
        ComputadoraDTO computadora = new ComputadoraDTO(computadoraDAO.buscarUnaComputadora(id));
        return computadora;
    }

    /**
     * Obtiene una lista de todas las computadoras registradas.
     * 
     * @return una lista de objetos ComputadoraDTO que representa todas las computadoras.
     *         Si no hay computadoras, retorna null.
     */
    public List<ComputadoraDTO> buscarComputadora() {
        List<ComputadoraDTO> computadoras = new ArrayList<>();
        List<ComputadoraEntidad> bE = new ArrayList<>();
        bE = computadoraDAO.buscarTodosComputadora();

        if (computadoras != null) {
            for (ComputadoraEntidad y : bE) {
                ComputadoraDTO x = new ComputadoraDTO(y);
                computadoras.add(x);
            }
            return computadoras;
        } else {
            return null;
        }
    }
    
    /**
     * Obtiene una lista de todos los PC de cómputo registrados en la CC.
     * 
     * @return una lista de objetos Computadoras de la unidad.
     *         Si no hay Computadoras, retorna null.
     */
    public List<ComputadoraDTO> buscarComputadorasPorCentro(Long id) {
        List<ComputadoraDTO> computadoras = new ArrayList<>();
        List<ComputadoraEntidad> bE = new ArrayList<>();
        bE = computadoraDAO.buscarComputadorasPorCentro(id);
        
        if (computadoras != null) {
            for (ComputadoraEntidad y : bE) {
                ComputadoraDTO x = new ComputadoraDTO(y);
                computadoras.add(x);
            }
            return computadoras;
        } else { 
            return null;
        }
    }
    /**
     * Obtiene una lista de todos los PC por IP.
     * 
     * @return una lista de objetos 
     */
    public List<ComputadoraDTO> buscarComputadorasPorIP(String ip) {
        List<ComputadoraDTO> computadoras = new ArrayList<>();
        List<ComputadoraEntidad> bE = new ArrayList<>();
        bE = computadoraDAO.buscarComputadorasPorIP(ip);
        
        if (computadoras != null) {
            for (ComputadoraEntidad y : bE) {
                ComputadoraDTO x = new ComputadoraDTO(y);
                computadoras.add(x);
            }
            return computadoras;
        } else { 
            return null;
        }
    }
}
