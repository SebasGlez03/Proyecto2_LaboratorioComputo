/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.BloqueoEntidad;
import entidades.ComputadoraEntidad;
import entidades.EstudianteEntidad;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

/**
 * La clase {@code EstudianteDAO} maneja las operaciones de persistencia
 * relacionadas con la entidad {@code EstudianteEntidad}.
 * Esta clase implementa métodos para guardar, eliminar y modificar registros
 * en la base de datos utilizando JPA y {@code EntityManager}.
 * 
 * La clase se asegura de manejar las transacciones y cualquier error durante las
 * operaciones de persistencia, mostrando mensajes de error en una ventana emergente
 * mediante {@code JOptionPane} si es necesario.
 * 
 * @author santi
 */
public class EstudianteDAO {

    // Instancias para manejar el contexto de persistencia
    EntityManager entityManager = null;
    EntityManagerFactory managerFactory = null;
    EntityTransaction transaction = null;

    /**
     * Constructor por defecto para inicializar un objeto {@code EstudianteDAO}.
     * Este constructor no requiere parámetros y se puede utilizar para crear instancias
     * de la clase.
     */
    public EstudianteDAO() {
        // Constructor vacío
    }

    /**
     * Guarda un nuevo estudiante en la base de datos.
     * 
     * Este método inicia una transacción, persiste la entidad {@code EstudianteEntidad}
     * en la base de datos y confirma la transacción si no ocurre ningún error.
     * En caso de error, se realiza un rollback de la transacción para deshacer los cambios.
     * 
     * @param estudiante La entidad {@code EstudianteEntidad} que se desea persistir en la base de datos.
     */
    public void guardarEstudiante(EstudianteEntidad estudiante) {
        try {
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            // Persistimos la entidad en la base de datos
            entityManager.persist(estudiante);

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
     * Elimina un estudiante existente en la base de datos.
     * 
     * Este método inicia una transacción, elimina la entidad {@code EstudianteEntidad}
     * de la base de datos y confirma la transacción si no ocurre ningún error.
     * En caso de error, se realiza un rollback de la transacción para deshacer los cambios.
     * 
     * @param estudiante La entidad {@code EstudianteEntidad} que se desea eliminar de la base de datos.
     */
    public void eliminarEstudiante(EstudianteEntidad estudiante) {
        try {
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            // Eliminamos la entidad de la base de datos
            entityManager.remove(entityManager.contains(estudiante) ? estudiante : entityManager.merge(estudiante));

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
     * Modifica un estudiante existente en la base de datos.
     * 
     * Este método inicia una transacción, actualiza la entidad {@code EstudianteEntidad}
     * en la base de datos y confirma la transacción si no ocurre ningún error.
     * En caso de error, se realiza un rollback de la transacción para deshacer los cambios.
     * 
     * @param estudiante La entidad {@code EstudianteEntidad} con los nuevos valores que se desean actualizar en la base de datos.
     */
    public void modificarEstudiante(EstudianteEntidad estudiante) {
        try {
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            // Actualizamos la entidad en la base de datos
            entityManager.merge(estudiante);

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
     * @param Long id
     */
    public EstudianteEntidad buscarUnEstudiante(Long id) {

        try{
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();
            
            // Buscamos la entidad en la base de datos
            EstudianteEntidad Estudiante = entityManager.find(EstudianteEntidad.class, id);

            // Regresamos la entidad
            return Estudiante;     
        } catch (Exception e){
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
     * 
     * 
     */
    public List<EstudianteEntidad> buscarTodosEstudiante() {

        try{
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();
            
            // Buscamos las entidades en la base de datos
            TypedQuery<EstudianteEntidad> query = entityManager.createQuery("SELECT a FROM EstudianteEntidad a", EstudianteEntidad.class);

            // Regresamos la entidad
            return query.getResultList();
            } catch (Exception e){
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
