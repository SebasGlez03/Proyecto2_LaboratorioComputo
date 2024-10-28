package persistencia.Interfaces;

import java.util.List;
import persistencia.entidades.UnidadAcademicaEntidad;

/**
 * La interfaz {@code IUnidadAcademicaDAO} define los métodos para realizar
 * operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en la entidad
 * {@link UnidadAcademicaEntidad}.
 * <p>
 * Esta interfaz proporciona métodos para guardar, eliminar, modificar y buscar
 * registros de unidades académicas en la base de datos.
 * </p>
 *
 * @author santi
 */
public interface IUnidadAcademicaDAO {

    /**
     * Guarda un nuevo registro de unidad académica en la base de datos.
     *
     * @param unidadAcademica El objeto {@link UnidadAcademicaEntidad} que se va
     * a guardar.
     */
    public void guardarUnidadAcademica(UnidadAcademicaEntidad unidadAcademica);

    /**
     * Elimina un registro de unidad académica existente en la base de datos.
     *
     * @param unidadAcademica El objeto {@link UnidadAcademicaEntidad} que se va
     * a eliminar.
     */
    public void eliminarUnidadAcademica(UnidadAcademicaEntidad unidadAcademica);

    /**
     * Modifica un registro de unidad académica existente en la base de datos.
     *
     * @param unidadAcademica El objeto {@link UnidadAcademicaEntidad} que se va
     * a modificar.
     */
    public void modificarUnidadAcademica(UnidadAcademicaEntidad unidadAcademica);

    /**
     * Busca un registro de unidad académica en la base de datos por su ID.
     *
     * @param id El ID de la unidad académica que se va a buscar.
     * @return El objeto {@link UnidadAcademicaEntidad} encontrado, o
     * {@code null} si no se encuentra.
     */
    public UnidadAcademicaEntidad buscarUnaUnidadAcademica(Long id);

    /**
     * Busca todos los registros de unidades académicas en la base de datos.
     *
     * @return Una lista de objetos {@link UnidadAcademicaEntidad} que
     * representan todas las unidades académicas.
     */
    public List<UnidadAcademicaEntidad> buscarTodasUnidadAcademica();
}
