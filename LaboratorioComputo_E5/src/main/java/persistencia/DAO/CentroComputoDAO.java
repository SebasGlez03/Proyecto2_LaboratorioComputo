/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.DAO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
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
    
    /**
     *  Retorna una lista con todas las computadoras asociadas a un centroDeComputoespecífico.
     * 
     * @param uaID
     * @return
     */
    public List<CentroComputoEntidad> buscarCentrosPorUnidad(Long uaID) {
        managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
        entityManager = managerFactory.createEntityManager();
        
        TypedQuery<CentroComputoEntidad> query = entityManager.createQuery(
                "SELECT a FROM CentroComputoEntidad a LEFT JOIN a.unidadAcademica p WHERE p.id = :uaID", CentroComputoEntidad.class);
        query.setParameter("uaID", uaID);
        List<CentroComputoEntidad> ccE = query.getResultList();

        entityManager.close();
        return ccE;
    }
    
        /**
         * Retorna un reporte de uso en un centro de cómputo, incluyendo la cantidad de alumnos,
         * minutos de uso y minutos de inactividad de las computadoras asociadas.
         * 
         * @param nombresCentrosComputo Lista de nombres de centros de cómputo a incluir en el reporte.
         * @param fechaInicio           Fecha de inicio del rango.
         * @param fechaFin              Fecha de fin del rango.
         * @return                      Lista de registros con información del centro de cómputo y uso.
         */
//        public List<Object[]> obtenerReporteCentroComputo(List<String> nombresCarreras,List<String> nombresCentrosComputo, Calendar fechaInicio, Calendar fechaFin) {
//           
//                    managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
//                    entityManager = managerFactory.createEntityManager();
//        
//            
//    String jpql = "SELECT cc.nombre, comp.numMaquina, COUNT(e), SUM(TIMESTAMPDIFF(MINUTE, u.fechaInicio, u.fechaFin)) " +
//                  "FROM ComputadoraEntidad comp " +
//                  "JOIN comp.centroComputoEntidad cc " +
//                  "JOIN comp.apartado u " +
//                  "JOIN u.estudiante e " +
//                  "JOIN e.carrera c " + 
//                  "WHERE cc.nombre IN :nombresCentrosComputo " +
//                  "AND c.nombre IN :nombresCarreras " +
//                  "AND u.fechaInicio BETWEEN :fechaInicio AND :fechaFin " +
//                  "GROUP BY cc.nombre, comp.numMaquina";
//
//            TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
//            query.setParameter("nombresCarreras", nombresCarreras);
//            query.setParameter("nombresCentrosComputo", nombresCentrosComputo);
//            query.setParameter("fechaInicio", fechaInicio);
//            query.setParameter("fechaFin", fechaFin);
//
//            List<Object[]> reporte = new ArrayList<>();
//                    
//            reporte = query.getResultList();
//            entityManager.close();
//            
//            
//            return reporte;
//        }

    public List<Object[]> obtenerReporteCentroComputo(List<String> nombresCarreras, List<String> nombresCentrosComputo, Calendar fechaInicio, Calendar fechaFin) {
    
    managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
    entityManager = managerFactory.createEntityManager();

    String jpql = "SELECT  comp.numMaquina, COUNT(e) " +
                  "FROM ComputadoraEntidad comp " +
                  "JOIN comp.centroComputoEntidad cc " +
                  "JOIN comp.apartado u " +
                  "JOIN u.estudiante e " +
                  "JOIN e.carrera c " + 
                  "WHERE cc.nombre IN :nombresCentrosComputo " +
                  "AND c.nombre IN :nombresCarreras " +
                  "AND u.fechaInicio BETWEEN :fechaInicio AND :fechaFin " +
                  "GROUP BY comp.numMaquina";

    TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
    query.setParameter("nombresCarreras", nombresCarreras);
    query.setParameter("nombresCentrosComputo", nombresCentrosComputo);
    query.setParameter("fechaInicio", fechaInicio);
    query.setParameter("fechaFin", fechaFin);

    List<Object[]> reporte = query.getResultList();
    entityManager.close();
    
    // Calcular minutos de uso
    List<Object[]> reporteConMinutosUso = new ArrayList<>();
    for (Object[] row : reporte) {
        String nombreCentro = (String) row[0];
        String numMaquina = (String) row[1];
        Long cantidadAlumnos = (Long) row[2];
        Calendar fechaInicioUso = (Calendar) row[3];
        Calendar fechaFinUso = (Calendar) row[4];

        // Calcular la diferencia en minutos
        long minutosUso = (fechaFinUso.getTimeInMillis() - fechaInicioUso.getTimeInMillis()) / (60 * 1000);

        // Agregar al nuevo reporte
        reporteConMinutosUso.add(new Object[] { nombreCentro, numMaquina, cantidadAlumnos, minutosUso });
    }
    
    return reporteConMinutosUso;
}
    public List<Object[]> obtenerReporteCentroComputoSinFiltro(Calendar fechaInicio, Calendar fechaFin) {
    
    managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
    entityManager = managerFactory.createEntityManager();

    String jpql = "SELECT  cc.nombre, comp.numMaquina, COUNT(e), SUM(u.minutosActivo)" +
                  "FROM ComputadoraEntidad comp " +
                  "JOIN comp.centroComputoEntidad cc " +
                  "JOIN comp.apartado u " +
                  "JOIN u.estudiante e " +
                  "JOIN e.carrera c " +
                  "WHERE u.fechaInicio BETWEEN :fechaInicio AND :fechaFin " +
                  "GROUP BY cc.nombre, comp.numMaquina";

    TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);

    query.setParameter("fechaInicio", fechaInicio);
    query.setParameter("fechaFin", fechaFin);

    List<Object[]> reporte = query.getResultList();
    entityManager.close();

    
    return reporte;
}

    
}
