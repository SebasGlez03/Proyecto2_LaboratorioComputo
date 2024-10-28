package persistencia.entidades;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Calendar;
import java.util.Date;

public class Pruebas {

    public static void main(String[] args) {
        // CREAMOS UNA FACTORY DE ENTITY MANAGERS
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
        // CREAMOS UN OBJETO EM QUE REPRESENTA A LA BD EN CÓDIGO
        EntityManager entityManager = managerFactory.createEntityManager();
        // INICIAMOS LA TRANSACCION
        entityManager.getTransaction().begin();

        // Crear Unidades Académicas
        UnidadAcademicaEntidad unidadNainari = new UnidadAcademicaEntidad("Náinari");
        UnidadAcademicaEntidad unidadNavojoa = new UnidadAcademicaEntidad("Navojoa");
        UnidadAcademicaEntidad unidadCIT = new UnidadAcademicaEntidad("CIT");
        
        entityManager.persist(unidadNainari);
        entityManager.persist(unidadNavojoa);
        entityManager.persist(unidadCIT);

        // Crear Carreras de Licenciatura
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        
        // Sumar 2 horas al objeto Calendar
        calendar.add(Calendar.HOUR_OF_DAY, 2); // Cambiado a add

        // Obtener el objeto Date resultante
        Date dateWithTwoHours = calendar.getTime();
        
        
     
        Long id = Long.parseLong("1");

        CarreraEntidad carrera = new CarreraEntidad("Ingeniería en Sistemas", dateWithTwoHours);
        carrera.setIdCarrera(id);
        entityManager.persist(carrera);
        entityManager.persist(new CarreraEntidad("Licenciatura en Administración", dateWithTwoHours));
        entityManager.persist(new CarreraEntidad("Licenciatura en Diseño Gráfico", dateWithTwoHours));
        entityManager.persist(new CarreraEntidad("Ingeniería Industrial", dateWithTwoHours));
        entityManager.persist(new CarreraEntidad("Licenciatura en Psicología", dateWithTwoHours));

        // Crear Laboratorios y agregar computadoras
        String[] nombresLaboratorios = {"Laboratorio 1", "Laboratorio 2", "Laboratorio 3", "Laboratorio 4"};

        for (String nombre : nombresLaboratorios) {
            CentroComputoEntidad laboratorio = new CentroComputoEntidad(nombre, "192.168.0." + (nombresLaboratorios.length + 1), 
                new GregorianCalendar(0, 0, 0, 8, 0, 0), 
                new GregorianCalendar(0, 0, 0, 20, 0, 0), 
                unidadNainari); // Asignar Náinari
            
            entityManager.persist(laboratorio);

            for (int i = 1; i <= 8; i++) {
                List<String> sfwr = new ArrayList<>(List.of("Software " + i));
                ComputadoraEntidad computadora = new ComputadoraEntidad(false, laboratorio, "192.168.0." + (nombresLaboratorios.length + 1) + "." + i, sfwr, i);
                entityManager.persist(computadora);
            }
        }


        
        // Crear 20 estudiantes, 5 por carrera
        String[] nombres = {"Pedro", "Juan", "María", "Luis", "Ana", "José", "Sara", "Carlos", "Laura", "Mónica",
                            "Fernando", "Javier", "Sofia", "David", "Patricia", "Diego", "Valeria", "Andrés", "Clara", "Luis"};

        for (int i = 0; i < 20; i++) {
            EstudianteEntidad estudiante = new EstudianteEntidad(nombres[i], "Apellido" + (i + 1), "Apellido2" + (i + 1), "ID" + (i + 1), "Inscrito");
            estudiante.setCarrera(carrera); // Asignar carrera de forma cíclica
            entityManager.persist(estudiante);
        }

        // MANDAMOS A EJECUTAR LA TRANSACCION
        entityManager.getTransaction().commit();
        // CERRAMOS
        entityManager.close();
        managerFactory.close();
    }
}
