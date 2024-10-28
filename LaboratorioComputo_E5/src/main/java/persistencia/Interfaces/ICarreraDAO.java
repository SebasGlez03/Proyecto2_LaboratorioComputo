package persistencia.Interfaces;

import java.util.List;
import persistencia.entidades.CarreraEntidad;

/**
 * La interfaz {@code ICarreraDAO} define los métodos para realizar operaciones
 * CRUD (Crear, Leer, Actualizar, Eliminar) en la entidad
 * {@link CarreraEntidad}.
 * <p>
 * Esta interfaz proporciona métodos para guardar, eliminar, modificar y buscar
 * registros de carreras en la base de datos.
 * </p>
 *
 * @author santi
 */
public interface ICarreraDAO {

    /**
     * Guarda un nuevo registro de carrera en la base de datos.
     *
     * @param carrera El objeto {@link CarreraEntidad} que se va a guardar.
     */
    public void guardarCarrera(CarreraEntidad carrera);

    /**
     * Elimina un registro de carrera existente en la base de datos.
     *
     * @param carrera El objeto {@link CarreraEntidad} que se va a eliminar.
     */
    public void eliminarCarrera(CarreraEntidad carrera);

    /**
     * Modifica un registro de carrera existente en la base de datos.
     *
     * @param carrera El objeto {@link CarreraEntidad} que se va a modificar.
     */
    public void modificarCarrera(CarreraEntidad carrera);

    /**
     * Busca un registro de carrera en la base de datos por su ID.
     *
     * @param id El ID de la carrera que se va a buscar.
     * @return El objeto {@link CarreraEntidad} encontrado, o {@code null} si no
     * se encuentra.
     */
    public CarreraEntidad buscarUnaCarrera(Long id);

    /**
     * Busca todos los registros de carreras en la base de datos.
     *
     * @return Una lista de objetos {@link CarreraEntidad} que representan todas
     * las carreras.
     */
    public List<CarreraEntidad> buscarTodasCarrera();
}
