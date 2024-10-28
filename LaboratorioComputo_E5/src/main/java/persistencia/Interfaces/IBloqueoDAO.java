package persistencia.Interfaces;

import persistencia.entidades.BloqueoEntidad;
import java.util.List;

/**
 * La interfaz {@code IBloqueoDAO} define los métodos para realizar operaciones
 * CRUD (Crear, Leer, Actualizar, Eliminar) en la entidad
 * {@link BloqueoEntidad}.
 * <p>
 * Esta interfaz proporciona métodos para guardar, eliminar, modificar y buscar
 * registros de bloqueos en la base de datos.
 * </p>
 *
 * @author santi
 */
public interface IBloqueoDAO {

    /**
     * Guarda un nuevo registro de bloqueo en la base de datos.
     *
     * @param bloqueo El objeto {@link BloqueoEntidad} que se va a guardar.
     */
    public void guardarBloqueo(BloqueoEntidad bloqueo);

    /**
     * Elimina un registro de bloqueo existente en la base de datos.
     *
     * @param bloqueo El objeto {@link BloqueoEntidad} que se va a eliminar.
     */
    public void eliminarBloqueo(BloqueoEntidad bloqueo);

    /**
     * Modifica un registro de bloqueo existente en la base de datos.
     *
     * @param bloqueo El objeto {@link BloqueoEntidad} que se va a modificar.
     */
    public void modificarBloqueo(BloqueoEntidad bloqueo);

    /**
     * Busca un registro de bloqueo en la base de datos por su ID.
     *
     * @param id El ID del bloqueo que se va a buscar.
     * @return El objeto {@link BloqueoEntidad} encontrado, o {@code null} si no
     * se encuentra.
     */
    public BloqueoEntidad buscarUnBloqueo(Long id);

    /**
     * Busca todos los registros de bloqueos en la base de datos.
     *
     * @return Una lista de objetos {@link BloqueoEntidad} que representan todos
     * los bloqueos.
     */
    public List<BloqueoEntidad> buscarTodosBloqueos();
}
