/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Calendar;
import java.time.Instant;
import java.util.Date;

/**
 *
 * @author PC
 */
public class Pruebas {

    public static void main(String[] args) {
        // CREAMOS UNA FACTORY DE ENTITY MANAGERS
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
        // CREAMOS UN OBJETO EM QUE REPRESENTA A LA BD EN CÓDIGO
        EntityManager entityManager = managerFactory.createEntityManager();
        //INICIAMOS LA TRANSACCION
        entityManager.getTransaction().begin();

        List<String> sfwr = new ArrayList<>();
        sfwr.add("Photoshop");
        sfwr.add("Illustrator");
        sfwr.add("Netbeans");
        List<EstudianteEntidad> estudiantes = new ArrayList<>();

        UnidadAcademicaEntidad uaEntidad = new UnidadAcademicaEntidad("Nainari");
        EstudianteEntidad estudianteEntidad = new EstudianteEntidad("Pedro", "Ramirez", "Lopez", "123est321", "Inscrito");
        EstudianteEntidad estudianteEntidad2 = new EstudianteEntidad("Juan", "Ramirez", "Lopez", "123est321", "Inscrito");
        CentroComputoEntidad centroComputoEntidad = new CentroComputoEntidad("Cisco", "10cntro01comp1209", new GregorianCalendar(0, 0, 0, 14, 30, 0), new GregorianCalendar(0, 0, 0, 19, 30, 0), uaEntidad);
        ComputadoraEntidad computadoraEntidad = new ComputadoraEntidad(false, centroComputoEntidad, estudianteEntidad, "192.168.0.1", sfwr, 1);
        BloqueoEntidad bloqueoEntidad = new BloqueoEntidad("Ladrón", Calendar.getInstance(), Calendar.getInstance(), estudianteEntidad);
        RentaEntidad rentaEntidad = new RentaEntidad(Calendar.getInstance(), Calendar.getInstance(), estudianteEntidad, computadoraEntidad);

        estudiantes.add(estudianteEntidad);
        estudiantes.add(estudianteEntidad2);
        CarreraEntidad caEntidad = new CarreraEntidad("Software", Date.from(Instant.now()), uaEntidad, estudiantes);

        List<BloqueoEntidad> bloqueos = new ArrayList<>();
        bloqueos.add(bloqueoEntidad);

        computadoraEntidad.setEstudiante(estudianteEntidad);

        estudianteEntidad.setComputadora(computadoraEntidad);
        estudianteEntidad.setCarrera(caEntidad);
        estudianteEntidad2.setCarrera(caEntidad);
        estudianteEntidad.setBloqueo(bloqueos);

        entityManager.persist(estudianteEntidad);
        entityManager.persist(uaEntidad);
        entityManager.persist(centroComputoEntidad);
        entityManager.persist(computadoraEntidad);
        entityManager.persist(rentaEntidad);

        //MANDAMOS A EJECUTAR LA TRANSACCION
        entityManager.getTransaction().commit();
        //CERRAMOS
        entityManager.close();
        managerFactory.close();

    }
}
