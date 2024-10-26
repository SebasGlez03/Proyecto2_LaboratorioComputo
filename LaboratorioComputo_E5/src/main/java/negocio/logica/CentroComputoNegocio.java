/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.logica;

import java.util.ArrayList;
import java.util.List;
import negocio.DTO.ApartadoDTO;
import negocio.DTO.BloqueoDTO;
import negocio.DTO.CentroComputoDTO;
import negocio.DTO.EstudianteDTO;
import negocio.DTO.UnidadAcademicaDTO;
import persistencia.DAO.CentroComputoDAO;
import persistencia.entidades.ApartadoEntidad;
import persistencia.entidades.BloqueoEntidad;
import persistencia.entidades.CentroComputoEntidad;
import persistencia.entidades.ComputadoraEntidad;
import persistencia.entidades.EstudianteEntidad;

/**
 * Clase CentroComputoNegocio
 * <p>
 * Esta clase proporciona la lógica de negocio para la gestión de centros de cómputo,
 * permitiendo realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre
 * centros de cómputo y gestionar la conversión entre objetos DTO y entidades de persistencia.
 * </p>
 * 
 * @author santi
 */
public class CentroComputoNegocio {

    CentroComputoDAO centroComputoDAO;

    /**
     * Constructor de CentroComputoNegocio
     * <p>
     * Inicializa un nuevo objeto CentroComputoDAO para manejar la persistencia de los datos
     * relacionados con los centros de cómputo.
     * </p>
     */
    public CentroComputoNegocio() {
        CentroComputoDAO centroComputoDAO = new CentroComputoDAO();
        this.centroComputoDAO = centroComputoDAO;
    }

    /**
     * Convierte un objeto CentroComputoDTO a una entidad CentroComputoEntidad.
     * 
     * @param dto el objeto CentroComputoDTO que se desea convertir.
     * @return la entidad CentroComputoEntidad correspondiente al DTO proporcionado.
     */
    public CentroComputoEntidad convertir(CentroComputoDTO dto) {
        UnidadAcademicaNegocio uaE = new UnidadAcademicaNegocio();
        CentroComputoEntidad entidad = new CentroComputoEntidad();
        
        entidad.setId(dto.getId());
        entidad.setNombre(dto.getNombre());
        entidad.setContraseniaMaestra(dto.getContraseniaMaestra());
        entidad.setHoraInicioServicio(dto.getHoraInicioServicio());
        entidad.setHoraFinServicio(dto.getHoraFinServicio());
        entidad.setUnidadAcademica(uaE.convertir(dto.getUnidad()));

        return entidad;
    }

    /**
     * Guarda un centro de cómputo en la base de datos.
     * 
     * @param cCD el objeto CentroComputoDTO que se desea guardar.
     */
    public void guardarCentroComputo(CentroComputoDTO cCD) {
        centroComputoDAO.guardarCentroComputo(convertir(cCD));
    }

    /**
     * Modifica un centro de cómputo existente en la base de datos.
     * 
     * @param cCD el objeto CentroComputoDTO con los datos actualizados del centro de cómputo.
     */
    public void modificarCentroComputo(CentroComputoDTO cCD) {
        centroComputoDAO.modificarCentroComputo(convertir(cCD));
    }

    /**
     * Elimina un centro de cómputo de la base de datos.
     * 
     * @param cCD el objeto CentroComputoDTO que se desea eliminar.
     */
    public void eliminarCentroComputo(CentroComputoDTO cCD) {
        centroComputoDAO.eliminarCentroComputo(convertir(cCD));
    }

    /**
     * Busca un centro de cómputo específico por su identificador.
     * 
     * @param id el identificador único del centro de cómputo a buscar.
     * @return un objeto CentroComputoDTO con los datos del centro de cómputo encontrado.
     */
    public CentroComputoDTO buscarCentroComputo(Long id) {
        CentroComputoDTO centro = new CentroComputoDTO(centroComputoDAO.buscarUnCentroComputo(id));
        return centro;
    }

    /**
     * Obtiene una lista de todos los centros de cómputo registrados.
     * 
     * @return una lista de objetos CentroComputoDTO que representa todos los centros de cómputo.
     *         Si no hay centros de cómputo, retorna null.
     */
    public List<CentroComputoDTO> buscarCentrosComputos() {
        List<CentroComputoDTO> centros = new ArrayList<>();
        List<CentroComputoEntidad> bE = new ArrayList<>();
        bE = centroComputoDAO.buscarTodosCentroComputo();
        
        if (centros != null) {
            for (CentroComputoEntidad y : bE) {
                CentroComputoDTO x = new CentroComputoDTO(y);
                centros.add(x);
            }
            return centros;
        } else { 
            return null;
        }
    }
}
