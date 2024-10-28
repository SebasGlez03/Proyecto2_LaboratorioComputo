/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.DAO;

import persistencia.entidades.CarreraEntidad;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import persistencia.Interfaces.ICarreraDAO;

/**
 * La clase {@code CarreraDAO} maneja las operaciones de persistencia
 * relacionadas con la entidad {@code CarreraEntidad}. Esta clase implementa
 * métodos para guardar, eliminar y modificar registros en la base de datos
 * utilizando JPA y {@code EntityManager}.
 *
 * La clase se asegura de manejar las transacciones y cualquier error durante
 * las operaciones de persistencia, mostrando mensajes de error en una ventana
 * emergente mediante {@code JOptionPane} si es necesario.
 *
 * @author santi
 */
public class CarreraDAO implements ICarreraDAO {

    // Instancias para manejar el contexto de persistencia
    EntityManager entityManager = null;
    EntityManagerFactory managerFactory = null;
    EntityTransaction transaction = null;

    /**
     * Constructor por defecto para inicializar un objeto {@code CarreraDAO}.
     * Este constructor no requiere parámetros y se puede utilizar para crear
     * instancias de la clase.
     */
    public CarreraDAO() {
        // Constructor vacío
    }

    /**
     * Guarda una nueva carrera en la base de datos.
     *
     * Este método inicia una transacción, persiste la entidad
     * {@code CarreraEntidad} en la base de datos y confirma la transacción si
     * no ocurre ningún error. En caso de error, se realiza un rollback de la
     * transacción para deshacer los cambios.
     *
     * @param Carrera La entidad {@code CarreraEntidad} que se desea persistir
     * en la base de datos.
     */
    public void guardarCarrera(CarreraEntidad Carrera) {
        try {
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            // Persistimos la entidad en la base de datos
            entityManager.persist(Carrera);

            // Todo salió bien, se confirma la transacción
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                // En caso de error, se hace rollback de la transacción
                transaction.rollback();
                JOptionPane.showMessageDialog(null, "Error en Persistencia = " + e.getMessage());
            }
            e.printStackTrace(); // Imprime la traza del error en la consola
        } finally {
            if (entityManager != null) {
                // Cerramos el EntityManager
                entityManager.close();
            }
        }
    }

    /**
     * Elimina una carrera existente en la base de datos.
     *
     * Este método inicia una transacción, elimina la entidad
     * {@code CarreraEntidad} de la base de datos y confirma la transacción si
     * no ocurre ningún error. En caso de error, se realiza un rollback de la
     * transacción para deshacer los cambios.
     *
     * @param Carrera La entidad {@code CarreraEntidad} que se desea eliminar de
     * la base de datos.
     */
    public void eliminarCarrera(CarreraEntidad Carrera) {
        try {
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            // Eliminamos la entidad de la base de datos
            entityManager.remove(entityManager.contains(Carrera) ? Carrera : entityManager.merge(Carrera));

            // Todo salió bien, se confirma la transacción
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                // En caso de error, se hace rollback de la transacción
                transaction.rollback();
                JOptionPane.showMessageDialog(null, "Error en Persistencia = " + e.getMessage());
            }
            e.printStackTrace(); // Imprime la traza del error en la consola
        } finally {
            if (entityManager != null) {
                // Cerramos el EntityManager
                entityManager.close();
            }
        }
    }

    /**
     * Modifica una carrera existente en la base de datos.
     *
     * Este método inicia una transacción, actualiza la entidad
     * {@code CarreraEntidad} en la base de datos y confirma la transacción si
     * no ocurre ningún error. En caso de error, se realiza un rollback de la
     * transacción para deshacer los cambios.
     *
     * @param Carrera La entidad {@code CarreraEntidad} con los nuevos valores
     * que se desean actualizar en la base de datos.
     */
    public void modificarCarrera(CarreraEntidad Carrera) {
        try {
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            // Actualizamos la entidad en la base de datos
            entityManager.merge(Carrera);

            // Todo salió bien, se confirma la transacción
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                // En caso de error, se hace rollback de la transacción
                transaction.rollback();
                JOptionPane.showMessageDialog(null, "Error en Persistencia = " + e.getMessage());
            }
            e.printStackTrace(); // Imprime la traza del error en la consola
        } finally {
            if (entityManager != null) {
                // Cerramos el EntityManager
                entityManager.close();
            }
        }
    }

    /**
     * Busca un {@code CarreraEntidad} en la base de datos.
     *
     * Este método busca la entidad {@code CarreraEntidad}en la base de datos.
     *
     * @param id id de la carrera a buscar
     * @return carreraEntidad
     */
    public CarreraEntidad buscarUnaCarrera(Long id) {

        try {
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();

            // Buscamos la entidad en la base de datos
            CarreraEntidad carrera = entityManager.find(CarreraEntidad.class, id);

            // Regresamos la entidad
            return carrera;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en Persistencia = " + e.getMessage());
            return null;
        } finally {
            if (entityManager != null) {
                // Cerramos el EntityManager
                entityManager.close();
            }
        }

    }

    /**
     * Busca todos los {@code CarreraEntidad} en la base de datos.
     *
     * Este método busca la entidad {@code CarreraEntidad}en la base de datos.
     *
     * @return lista de todas las carreras
     */
    public List<CarreraEntidad> buscarTodasCarrera() {

        try {
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();

            // Buscamos las entidades en la base de datos
            TypedQuery<CarreraEntidad> query = entityManager.createQuery("SELECT a FROM CarreraEntidad a", CarreraEntidad.class);

            // Regresamos la entidad
            return query.getResultList();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en Persistencia = " + e.getMessage());
            return null;
        } finally {
            if (entityManager != null) {
                // Cerramos el EntityManager
                entityManager.close();
            }
        }
    }
}
