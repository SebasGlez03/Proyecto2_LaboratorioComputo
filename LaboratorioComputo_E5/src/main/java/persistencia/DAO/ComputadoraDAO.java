/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.DAO;

import persistencia.entidades.CentroComputoEntidad;
import persistencia.entidades.ComputadoraEntidad;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import persistencia.Interfaces.IComputadoraDAO;

/**
 * La clase {@code ComputadoraDAO} maneja las operaciones de persistencia
 * relacionadas con la entidad {@code ComputadoraEntidad}.
 * Esta clase implementa métodos para guardar, eliminar y modificar registros
 * en la base de datos utilizando JPA y {@code EntityManager}.
 * 
 * La clase se asegura de manejar las transacciones y cualquier error durante las
 * operaciones de persistencia, mostrando mensajes de error en una ventana emergente
 * mediante {@code JOptionPane} si es necesario.
 * 
 * @author santi
 */
public class ComputadoraDAO implements IComputadoraDAO{

    // Instancias para manejar el contexto de persistencia
    EntityManager entityManager = null;
    EntityManagerFactory managerFactory = null;
    EntityTransaction transaction = null;

    /**
     * Constructor por defecto para inicializar un objeto {@code ComputadoraDAO}.
     * Este constructor no requiere parámetros y se puede utilizar para crear instancias
     * de la clase.
     */
    public ComputadoraDAO() {
        // Constructor vacío
    }

    /**
     * Guarda una nueva computadora en la base de datos.
     * 
     * Este método inicia una transacción, persiste la entidad {@code ComputadoraEntidad}
     * en la base de datos y confirma la transacción si no ocurre ningún error.
     * En caso de error, se realiza un rollback de la transacción para deshacer los cambios.
     * 
     * @param Computadora La entidad {@code ComputadoraEntidad} que se desea persistir en la base de datos.
     */
    public void guardarComputadora(ComputadoraEntidad Computadora) {
        try {
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            // Persistimos la entidad en la base de datos
            entityManager.persist(Computadora);

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
     * Elimina una computadora existente en la base de datos.
     * 
     * Este método inicia una transacción, elimina la entidad {@code ComputadoraEntidad}
     * de la base de datos y confirma la transacción si no ocurre ningún error.
     * En caso de error, se realiza un rollback de la transacción para deshacer los cambios.
     * 
     * @param Computadora La entidad {@code ComputadoraEntidad} que se desea eliminar de la base de datos.
     */
    public void eliminarComputadora(ComputadoraEntidad Computadora) {
        try {
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            // Eliminamos la entidad de la base de datos
            entityManager.remove(entityManager.contains(Computadora) ? Computadora : entityManager.merge(Computadora));

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
     * Modifica una computadora existente en la base de datos.
     * 
     * Este método inicia una transacción, actualiza la entidad {@code ComputadoraEntidad}
     * en la base de datos y confirma la transacción si no ocurre ningún error.
     * En caso de error, se realiza un rollback de la transacción para deshacer los cambios.
     * 
     * @param Computadora La entidad {@code ComputadoraEntidad} con los nuevos valores que se desean actualizar en la base de datos.
     */
    public void modificarComputadora(ComputadoraEntidad Computadora) {
        try {
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            // Actualizamos la entidad en la base de datos
            entityManager.merge(Computadora);

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
    public ComputadoraEntidad buscarUnaComputadora(Long id) {

        try{
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();
            
            // Buscamos la entidad en la base de datos
            ComputadoraEntidad Computadora = entityManager.find(ComputadoraEntidad.class, id);

            // Regresamos la entidad
            return Computadora;     
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
    public List<ComputadoraEntidad> buscarTodosComputadora() {

        try{
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();
            
            // Buscamos las entidades en la base de datos
            TypedQuery<ComputadoraEntidad> query = entityManager.createQuery("SELECT a FROM ComputadoraEntidad a", ComputadoraEntidad.class);

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
    
    /**
     *  Retorna una lista con todas las computadoras asociadas a un centroDeComputoespecífico.
     * 
     * @param cID
     * @return
     */
    public List<ComputadoraEntidad> buscarComputadorasPorCentro(Long cID) {
        
        managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
        entityManager = managerFactory.createEntityManager();
        TypedQuery<ComputadoraEntidad> query = entityManager.createQuery(
                "SELECT a FROM ComputadoraEntidad a JOIN a.centroComputoEntidad p  WHERE p.id = :cID", ComputadoraEntidad.class);
        query.setParameter("cID", cID);
        List<ComputadoraEntidad> cE = query.getResultList();
        
        entityManager.close();

        return cE;
    }
    
    /**
     *  Retorna una lista con todas las computadoras asociadas a un IP.
     * 
     * @param ip
     * @return
     */
    public List<ComputadoraEntidad> buscarComputadorasPorIP(String ip) {
        
        managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
        entityManager = managerFactory.createEntityManager();
        TypedQuery<ComputadoraEntidad> query = entityManager.createQuery(
                "SELECT a FROM ComputadoraEntidad a WHERE a.ip = :cID", ComputadoraEntidad.class);
        query.setParameter("cID", ip);
        List<ComputadoraEntidad> cE = query.getResultList();
        
        entityManager.close();

        return cE;
    }
}
