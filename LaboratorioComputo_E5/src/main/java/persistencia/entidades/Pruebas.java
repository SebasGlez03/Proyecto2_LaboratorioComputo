/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.entidades;

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
 * a
 * @hidden
 */
public class Pruebas {

    /**
     * Método principal que ejecuta las operaciones de prueba.
     *
     * @param args argumentos de línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        // CREAMOS UNA FACTORY DE ENTITY MANAGERS
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
        // CREAMOS UN OBJETO EM QUE REPRESENTA A LA BD EN CÓDIGO
        EntityManager entityManager = managerFactory.createEntityManager();
        // INICIAMOS LA TRANSACCION
        entityManager.getTransaction().begin();

        // Crear Unidades Académicas
        List<UnidadAcademicaEntidad> unidades = new ArrayList<>();
        unidades.add(new UnidadAcademicaEntidad("Náinari"));
        unidades.add(new UnidadAcademicaEntidad("Navojoa"));
        unidades.add(new UnidadAcademicaEntidad("CIT"));

        // Crear Carreras de Licenciatura
        List<CarreraEntidad> carreras = new ArrayList<>();
        carreras.add(new CarreraEntidad("Ingeniería en Sistemas", Date.from(Instant.now())));
        carreras.add(new CarreraEntidad("Licenciatura en Administración", Date.from(Instant.now())));
        carreras.add(new CarreraEntidad("Licenciatura en Diseño Gráfico", Date.from(Instant.now())));
        carreras.add(new CarreraEntidad("Ingeniería Industrial", Date.from(Instant.now())));
        carreras.add(new CarreraEntidad("Licenciatura en Psicología", Date.from(Instant.now())));

        // Crear Laboratorios y agregar computadoras
        List<CentroComputoEntidad> laboratorios = new ArrayList<>();
        String[] nombresLaboratorios = {"Laboratorio 1", "Laboratorio 2", "Laboratorio 3", "Laboratorio 4"};

        for (String nombre : nombresLaboratorios) {
            // Crear una nueva instancia de laboratorio
            CentroComputoEntidad laboratorio = new CentroComputoEntidad(nombre, "192.168.0." + (laboratorios.size() + 1),
                    new GregorianCalendar(0, 0, 0, 8, 0, 0),
                    new GregorianCalendar(0, 0, 0, 20, 0, 0),
                    unidades.get(0)); // Asignar Náinari
            // Crear y persistir computadoras en el laboratorio
            for (int i = 1; i <= 8; i++) {
                List<String> sfwr = new ArrayList<>(List.of("Software " + i));
                ComputadoraEntidad computadora = new ComputadoraEntidad(false, laboratorio, "192.168.0." + (laboratorios.size() + 1) + "." + i, sfwr, i);
                entityManager.persist(computadora);
            }
            laboratorios.add(laboratorio);
            entityManager.persist(laboratorio);
        }

        // Crear 20 estudiantes, 5 por carrera
        List<EstudianteEntidad> estudiantes = new ArrayList<>();
        String[] nombres = {"Pedro", "Juan", "María", "Luis", "Ana", "José", "Sara", "Carlos", "Laura", "Mónica",
            "Fernando", "Javier", "Sofia", "David", "Patricia", "Diego", "Valeria", "Andrés", "Clara", "Luis"};

        for (int i = 0; i < 20; i++) {
            // Crear un nuevo estudiante y asignar carrera de forma cíclica
            EstudianteEntidad estudiante = new EstudianteEntidad(nombres[i], "Apellido" + (i + 1), "Apellido2" + (i + 1), "ID" + (i + 1), "Inscrito");
            estudiante.setCarrera(carreras.get(i % carreras.size())); // Asignar carrera de forma cíclica
            estudiantes.add(estudiante);
            entityManager.persist(estudiante);
        }

        // MANDAMOS A EJECUTAR LA TRANSACCION
        entityManager.getTransaction().commit();
        // CERRAMOS
        entityManager.close();
        managerFactory.close();
    }
}
