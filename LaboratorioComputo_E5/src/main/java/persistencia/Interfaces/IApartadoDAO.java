package persistencia.Interfaces;

import java.util.List;
import persistencia.entidades.ApartadoEntidad;

/**
 * La interfaz {@code IApartadoDAO} define los métodos para realizar operaciones
 * CRUD (Crear, Leer, Actualizar, Eliminar) en la entidad
 * {@link ApartadoEntidad}.
 * <p>
 * Esta interfaz proporciona métodos para guardar, eliminar, modificar y buscar
 * registros de apartados en la base de datos.
 * </p>
 *
 * @author santi
 */
public interface IApartadoDAO {

    /**
     * Guarda un nuevo registro de apartado en la base de datos.
     *
     * @param renta El objeto {@link ApartadoEntidad} que se va a guardar.
     */
    public void guardarApartado(ApartadoEntidad renta);

    /**
     * Elimina un registro de apartado existente en la base de datos.
     *
     * @param renta El objeto {@link ApartadoEntidad} que se va a eliminar.
     */
    public void eliminarApartado(ApartadoEntidad renta);

    /**
     * Modifica un registro de apartado existente en la base de datos.
     *
     * @param renta El objeto {@link ApartadoEntidad} que se va a modificar.
     */
    public void modificarApartado(ApartadoEntidad renta);

    /**
     * Busca un registro de apartado en la base de datos por su ID.
     *
     * @param id El ID del apartado que se va a buscar.
     * @return El objeto {@link ApartadoEntidad} encontrado, o {@code null} si
     * no se encuentra.
     */
    public ApartadoEntidad buscarUnApartado(Long id);

    /**
     * Busca todos los registros de apartados en la base de datos.
     *
     * @return Una lista de objetos {@link ApartadoEntidad} que representan
     * todos los apartados.
     */
    public List<ApartadoEntidad> buscarTodosApartados();
}
