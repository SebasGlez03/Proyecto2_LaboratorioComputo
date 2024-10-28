package persistencia.Interfaces;

import java.util.List;
import persistencia.entidades.CentroComputoEntidad;

/**
 * La interfaz {@code ICentroComputoDAO} define los métodos para realizar
 * operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en la entidad
 * {@link CentroComputoEntidad}.
 * <p>
 * Esta interfaz proporciona métodos para guardar, eliminar, modificar y buscar
 * registros de centros de cómputo en la base de datos.
 * </p>
 *
 * @author santi
 */
public interface ICentroComputoDAO {

    /**
     * Guarda un nuevo registro de centro de cómputo en la base de datos.
     *
     * @param centroComputo El objeto {@link CentroComputoEntidad} que se va a
     * guardar.
     */
    public void guardarCentroComputo(CentroComputoEntidad centroComputo);

    /**
     * Elimina un registro de centro de cómputo existente en la base de datos.
     *
     * @param centroComputo El objeto {@link CentroComputoEntidad} que se va a
     * eliminar.
     */
    public void eliminarCentroComputo(CentroComputoEntidad centroComputo);

    /**
     * Modifica un registro de centro de cómputo existente en la base de datos.
     *
     * @param centroComputo El objeto {@link CentroComputoEntidad} que se va a
     * modificar.
     */
    public void modificarCentroComputo(CentroComputoEntidad centroComputo);

    /**
     * Busca un registro de centro de cómputo en la base de datos por su ID.
     *
     * @param id El ID del centro de cómputo que se va a buscar.
     * @return El objeto {@link CentroComputoEntidad} encontrado, o {@code null}
     * si no se encuentra.
     */
    public CentroComputoEntidad buscarUnCentroComputo(Long id);

    /**
     * Busca todos los registros de centros de cómputo en la base de datos.
     *
     * @return Una lista de objetos {@link CentroComputoEntidad} que representan
     * todos los centros de cómputo.
     */
    public List<CentroComputoEntidad> buscarTodosCentroComputo();
}
