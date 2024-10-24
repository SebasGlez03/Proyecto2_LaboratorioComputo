/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.ComputadoraEntidad;
import entidades.EstudianteEntidad;
import entidades.RentaEntidad;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 * La clase {@code RentaDAO} maneja las operaciones de persistencia relacionadas con la entidad {@code RentaEntidad}.
 * Esta clase implementa métodos para guardar, eliminar y modificar registros en la base de datos
 * utilizando JPA y {@code EntityManager}.
 * 
 * @author santi
 */
public class RentaDAO {

    EntityManager entityManager = null;
    EntityManagerFactory managerFactory = null;             
    EntityTransaction transaction = null;   

    /**
     * Constructor por defecto para inicializar un objeto {@code RentaDAO}.
     */
    public RentaDAO() {
        // Constructor vacío
    }

    /**
     * Guarda una nueva renta en la base de datos.
     * 
     * @param renta La entidad {@code RentaEntidad} que se desea persistir en la base de datos.
     */
    public void guardarRenta(RentaEntidad renta) {
        try {
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();    
            transaction = entityManager.getTransaction();
            transaction.begin();

            // Persistimos la entidad en la base de datos
            entityManager.persist(renta);

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
     * @param renta La entidad {@code RentaEntidad} que se desea eliminar de la base de datos.
     */
    public void eliminarRenta(RentaEntidad renta) {
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
     * @param renta La entidad {@code RentaEntidad} con los nuevos valores que se desean actualizar en la base de datos.
     */
    public void modificarRenta(RentaEntidad renta) {
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
}
