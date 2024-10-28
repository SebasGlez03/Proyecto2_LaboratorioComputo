package persistencia.Interfaces;

import java.util.List;
import persistencia.entidades.EstudianteEntidad;

/**
 * La interfaz {@code IEstudianteDAO} define los métodos para realizar
 * operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en la entidad
 * {@link EstudianteEntidad}.
 * <p>
 * Esta interfaz proporciona métodos para guardar, eliminar, modificar y buscar
 * registros de estudiantes en la base de datos.
 * </p>
 *
 * @author santi
 */
public interface IEstudianteDAO {

    /**
     * Guarda un nuevo registro de estudiante en la base de datos.
     *
     * @param estudiante El objeto {@link EstudianteEntidad} que se va a
     * guardar.
     */
    public void guardarEstudiante(EstudianteEntidad estudiante);

    /**
     * Elimina un registro de estudiante existente en la base de datos.
     *
     * @param estudiante El objeto {@link EstudianteEntidad} que se va a
     * eliminar.
     */
    public void eliminarEstudiante(EstudianteEntidad estudiante);

    /**
     * Modifica un registro de estudiante existente en la base de datos.
     *
     * @param estudiante El objeto {@link EstudianteEntidad} que se va a
     * modificar.
     */
    public void modificarEstudiante(EstudianteEntidad estudiante);

    /**
     * Busca un registro de estudiante en la base de datos por su ID.
     *
     * @param id El ID del estudiante que se va a buscar.
     * @return El objeto {@link EstudianteEntidad} encontrado, o {@code null} si
     * no se encuentra.
     */
    public EstudianteEntidad buscarUnEstudiante(Long id);

    /**
     * Busca todos los registros de estudiantes en la base de datos.
     *
     * @return Una lista de objetos {@link EstudianteEntidad} que representan
     * todos los estudiantes.
     */
    public List<EstudianteEntidad> buscarTodosEstudiante();
}
