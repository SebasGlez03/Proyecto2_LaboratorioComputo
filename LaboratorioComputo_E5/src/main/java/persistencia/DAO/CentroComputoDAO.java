/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.DAO;

import persistencia.entidades.BloqueoEntidad;
import persistencia.entidades.CentroComputoEntidad;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import persistencia.Interfaces.ICentroComputoDAO;

/**
 * La clase {@code CentroComputoDAO} maneja las operaciones de persistencia
 * relacionadas con la entidad {@code CentroComputoEntidad}. 
 * Esta clase implementa métodos para guardar, eliminar y modificar registros
 * en la base de datos utilizando JPA y {@code EntityManager}.
 *
 * La clase se asegura de manejar las transacciones y cualquier error durante
 * las operaciones de persistencia, mostrando mensajes de error en una ventana
 * emergente mediante {@code JOptionPane} si es necesario.
 *
 * @author santi
 */
public class CentroComputoDAO implements ICentroComputoDAO{

    // Instancias para manejar el contexto de persistencia
    EntityManager entityManager = null;
    EntityManagerFactory managerFactory = null;
    EntityTransaction transaction = null;

    /**
     * Constructor por defecto para inicializar un objeto
     * {@code CentroComputoDAO}. Este constructor no requiere parámetros y se
     * puede utilizar para crear instancias de la clase.
     */
    public CentroComputoDAO() {
        // Constructor vacío
    }

    /**
     * Guarda un nuevo centro de cómputo en la base de datos.
     *
     * Este método inicia una transacción, persiste la entidad
     * {@code CentroComputoEntidad} en la base de datos y confirma la transacción
     * si no ocurre ningún error. En caso de error, se realiza un rollback de la
     * transacción para deshacer los cambios.
     *
     * @param CentroComputo La entidad {@code CentroComputoEntidad} que se desea
     * persistir en la base de datos.
     */
    public void guardarCentroComputo(CentroComputoEntidad CentroComputo) {
        try {
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            // Persistimos la entidad en la base de datos
            entityManager.persist(CentroComputo);

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
     * Elimina un centro de cómputo existente en la base de datos.
     *
     * Este método inicia una transacción, elimina la entidad
     * {@code CentroComputoEntidad} de la base de datos y confirma la transacción
     * si no ocurre ningún error. En caso de error, se realiza un rollback de la
     * transacción para deshacer los cambios.
     *
     * @param CentroComputo La entidad {@code CentroComputoEntidad} que se desea
     * eliminar de la base de datos.
     */
    public void eliminarCentroComputo(CentroComputoEntidad CentroComputo) {
        try {
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            // Eliminamos la entidad de la base de datos
            entityManager.remove(entityManager.contains(CentroComputo) ? CentroComputo : entityManager.merge(CentroComputo));

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
     * Modifica un centro de cómputo existente en la base de datos.
     *
     * Este método inicia una transacción, actualiza la entidad
     * {@code CentroComputoEntidad} en la base de datos y confirma la transacción
     * si no ocurre ningún error. En caso de error, se realiza un rollback de la
     * transacción para deshacer los cambios.
     *
     * @param CentroComputo La entidad {@code CentroComputoEntidad} con los nuevos
     * valores que se desean actualizar en la base de datos.
     */
    public void modificarCentroComputo(CentroComputoEntidad CentroComputo) {
        try {
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            // Actualizamos la entidad en la base de datos
            entityManager.merge(CentroComputo);

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
    public CentroComputoEntidad buscarUnCentroComputo(Long id) {

        try{
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();
            
            // Buscamos la entidad en la base de datos
            CentroComputoEntidad CentroComputo = entityManager.find(CentroComputoEntidad.class, id);

            // Regresamos la entidad
            return CentroComputo;     
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
    public List<CentroComputoEntidad> buscarTodosCentroComputo() {

        try{
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();
            
            // Buscamos las entidades en la base de datos
            TypedQuery<CentroComputoEntidad> query = entityManager.createQuery("SELECT a FROM CentroComputoEntidad a", CentroComputoEntidad.class);

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