package persistencia.Interfaces;

import java.util.List;
import persistencia.entidades.ComputadoraEntidad;

/**
 * La interfaz {@code IComputadoraDAO} define los métodos para realizar
 * operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en la entidad
 * {@link ComputadoraEntidad}.
 * <p>
 * Esta interfaz proporciona métodos para guardar, eliminar, modificar y buscar
 * registros de computadoras en la base de datos.
 * </p>
 *
 * @author santi
 */
public interface IComputadoraDAO {

    /**
     * Guarda un nuevo registro de computadora en la base de datos.
     *
     * @param computadora El objeto {@link ComputadoraEntidad} que se va a
     * guardar.
     */
    public void guardarComputadora(ComputadoraEntidad computadora);

    /**
     * Elimina un registro de computadora existente en la base de datos.
     *
     * @param computadora El objeto {@link ComputadoraEntidad} que se va a
     * eliminar.
     */
    public void eliminarComputadora(ComputadoraEntidad computadora);

    /**
     * Modifica un registro de computadora existente en la base de datos.
     *
     * @param computadora El objeto {@link ComputadoraEntidad} que se va a
     * modificar.
     */
    public void modificarComputadora(ComputadoraEntidad computadora);

    /**
     * Busca un registro de computadora en la base de datos por su ID.
     *
     * @param id El ID de la computadora que se va a buscar.
     * @return El objeto {@link ComputadoraEntidad} encontrado, o {@code null}
     * si no se encuentra.
     */
    public ComputadoraEntidad buscarUnaComputadora(Long id);

    /**
     * Busca todos los registros de computadoras en la base de datos.
     *
     * @return Una lista de objetos {@link ComputadoraEntidad} que representan
     * todas las computadoras.
     */
    public List<ComputadoraEntidad> buscarTodosComputadora();
}
