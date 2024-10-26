/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.logica;

import java.util.ArrayList;
import java.util.List;
import negocio.DTO.*;
import persistencia.DAO.UnidadAcademicaDAO;
import persistencia.entidades.*;

/**
 * Clase UnidadAcademicaNegocio
 * <p>
 * Esta clase gestiona la lógica de negocio para la entidad Unidad Académica, permitiendo realizar operaciones
 * CRUD (Crear, Leer, Actualizar, Eliminar) y gestionar la conversión entre objetos DTO y entidades de persistencia.
 * </p>
 * 
 * @autor santi
 */
public class UnidadAcademicaNegocio {

    UnidadAcademicaDAO unidadAcademicaDAO;

    /**
     * Constructor de UnidadAcademicaNegocio.
     * <p>
     * Inicializa un nuevo objeto UnidadAcademicaDAO para manejar la persistencia de los datos relacionados
     * con las unidades académicas.
     * </p>
     */
    public UnidadAcademicaNegocio() {
        UnidadAcademicaDAO unidadAcademicaDAO = new UnidadAcademicaDAO();
        this.unidadAcademicaDAO = unidadAcademicaDAO;
    }

    /**
     * Convierte un objeto UnidadAcademicaDTO a una entidad UnidadAcademicaEntidad.
     * 
     * @param dto el objeto UnidadAcademicaDTO que se desea convertir.
     * @return la entidad UnidadAcademicaEntidad correspondiente al DTO proporcionado.
     */
    public UnidadAcademicaEntidad convertir(UnidadAcademicaDTO dto) {
        UnidadAcademicaEntidad entidad = new UnidadAcademicaEntidad();
        CentroComputoNegocio ccE = new CentroComputoNegocio();

        entidad.setId(dto.getId());
        entidad.setNombre(dto.getNombre());

        // Inicialmente establece la lista de centros de cómputo como null.
        // Se puede descomentar el código para convertir la lista de centros de cómputo si es necesario.
        entidad.setCentrosComputo(null);

        return entidad;
    }

    /**
     * Guarda una unidad académica en la base de datos.
     * 
     * @param uaD el objeto UnidadAcademicaDTO que se desea guardar.
     */
    public void guardarUnidadAcademica(UnidadAcademicaDTO uaD) {
        unidadAcademicaDAO.guardarUnidadAcademica(convertir(uaD));
    }

    /**
     * Modifica una unidad académica existente en la base de datos.
     * 
     * @param uaD el objeto UnidadAcademicaDTO con los datos actualizados de la unidad académica.
     */
    public void modificarUnidadAcademica(UnidadAcademicaDTO uaD) {
        unidadAcademicaDAO.modificarUnidadAcademica(convertir(uaD));
    }

    /**
     * Elimina una unidad académica de la base de datos.
     * 
     * @param uaD el objeto UnidadAcademicaDTO que se desea eliminar.
     */
    public void eliminarUnidadAcademica(UnidadAcademicaDTO uaD) {
        unidadAcademicaDAO.eliminarUnidadAcademica(convertir(uaD));
    }

    /**
     * Busca una unidad académica específica por su identificador.
     * 
     * @param id el identificador único de la unidad académica a buscar.
     * @return un objeto UnidadAcademicaDTO con los datos de la unidad académica encontrada.
     */
    public UnidadAcademicaDTO buscarUnidadAcademica(Long id) {
        UnidadAcademicaDTO unidadAcademica = new UnidadAcademicaDTO(unidadAcademicaDAO.buscarUnaUnidadAcademica(id));
        return unidadAcademica;
    }

    /**
     * Obtiene una lista de todas las unidades académicas registradas.
     * 
     * @return una lista de objetos UnidadAcademicaDTO que representa todas las unidades académicas.
     *         Si no hay unidades académicas, retorna null.
     */
    public List<UnidadAcademicaDTO> buscarUnidadAcademica() {
        List<UnidadAcademicaDTO> unidadesAcademicas = new ArrayList<>();
        List<UnidadAcademicaEntidad> entidades = unidadAcademicaDAO.buscarTodasUnidadAcademica();

        if (unidadesAcademicas != null) {
            for (UnidadAcademicaEntidad entidad : entidades) {
                UnidadAcademicaDTO dto = new UnidadAcademicaDTO(entidad);
                unidadesAcademicas.add(dto);
            }
            return unidadesAcademicas;
        } else {
            return null;
        }
    }
}
