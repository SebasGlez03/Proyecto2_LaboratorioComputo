/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.DAO;

import persistencia.entidades.ComputadoraEntidad;
import persistencia.entidades.EstudianteEntidad;
import persistencia.entidades.ApartadoEntidad;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import persistencia.Interfaces.IApartadoDAO;

/**
 * La clase {@code ApartadoDAO} maneja las operaciones de persistencia
 * relacionadas con la entidad {@code ApartadoEntidad}. Esta clase implementa
 * métodos para guardar, eliminar y modificar registros en la base de datos
 * utilizando JPA y {@code EntityManager}.
 *
 * @author santi
 */
public class ApartadoDAO implements IApartadoDAO {

    EntityManager entityManager = null;
    EntityManagerFactory managerFactory = null;
    EntityTransaction transaction = null;
    EstudianteDAO estudianteDAO = new EstudianteDAO();

    /**
     * Constructor por defecto para inicializar un objeto {@code RentaDAO}.
     */
    public ApartadoDAO() {
        // Constructor vacío
    }

    /**
     * Guarda una nueva renta en la base de datos.
     *
     * @param apartado La entidad {@code ApartadoEntidad} que se desea persistir
     * en la base de datos.
     */
    public void guardarApartado(ApartadoEntidad apartado) {
        try {
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            // Persistimos la entidad en la base de datos
            entityManager.persist(apartado);

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
     * Elimina una renta existente en la base de datos.
     *
     * @param renta La entidad {@code ApartadoEntidad} que se desea eliminar de
     * la base de datos.
     */
    public void eliminarApartado(ApartadoEntidad renta) {
        try {
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            // Eliminamos la entidad de la base de datos
            entityManager.remove(renta);

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
     * Modifica una renta existente en la base de datos.
     *
     * @param renta La entidad {@code ApartadoEntidad} con los nuevos valores
     * que se desean actualizar en la base de datos.
     */
    public void modificarApartado(ApartadoEntidad renta) {
        try {
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            // Actualizamos la entidad en la base de datos
            entityManager.merge(renta);

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
     * Busca un objeto de la tabla respectiva en la base de datos.
     *
     * @param id id del apartado a buscar
     * @return El apartado buscado
     */
    public ApartadoEntidad buscarUnApartado(Long id) {

        try {
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();

            // Buscamos la entidad en la base de datos
            ApartadoEntidad Renta = entityManager.find(ApartadoEntidad.class, id);

            // Regresamos la entidad
            return Renta;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en Persistencia = " + e.getMessage());
            return null;
        } finally {
            if (entityManager != null) {
                // Cerramos el EntityManager
                System.out.println("cierras");
                entityManager.close();
            }
        }

    }

    /**
     * Busca todos los objetos de la tabla respectiva en la base de datos.
     *
     * @return lista de todos los apartados
     */
    public List<ApartadoEntidad> buscarTodosApartados() {

        try {
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();

            // Buscamos las entidades en la base de datos
            TypedQuery<ApartadoEntidad> query = entityManager.createQuery("SELECT a FROM RentaEntidad a", ApartadoEntidad.class);

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

    /**
     * Metodo que busca un apartado por estudiante
     *
     * @param idE idEstudiante
     * @param idC idComputadora
     * @return apartad
     */
    public List<ApartadoEntidad> buscarApartadoPorEstudiante(Long idE, Long idC) {

        managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
        entityManager = managerFactory.createEntityManager();

        TypedQuery<ApartadoEntidad> query = entityManager.createQuery(
                "SELECT a FROM ApartadoEntidad a LEFT JOIN a.estudiante p LEFT JOIN a.computadora c WHERE p.idEstudiante = :idE AND c.idComputadora = :idC", ApartadoEntidad.class);
        query.setParameter("idE", idE);
        query.setParameter("idC", idC);
        List<ApartadoEntidad> ccE = query.getResultList();

        entityManager.close();
        return ccE;

    }
}
