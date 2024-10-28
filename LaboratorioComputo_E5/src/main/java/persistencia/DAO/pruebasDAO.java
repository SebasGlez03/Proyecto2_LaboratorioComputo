/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package persistencia.DAO;

import java.sql.Timestamp;
import persistencia.entidades.BloqueoEntidad;
import persistencia.entidades.CarreraEntidad;
import persistencia.entidades.CentroComputoEntidad;
import persistencia.entidades.ComputadoraEntidad;
import persistencia.entidades.EstudianteEntidad;
import persistencia.entidades.UnidadAcademicaEntidad;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import persistencia.entidades.ApartadoEntidad;

/**
 * Clase de pruebas para la capa de acceso a datos (DAO). Realiza diversas
 * operaciones de prueba en entidades y tablas de la base de datos.
 *
 * @version 1.0
 * @since 2024-10-28
 * @author sebas
 */
public class pruebasDAO {

    /**
     * Método principal para ejecutar las pruebas de operaciones CRUD en las
     * entidades.
     *
     * @param args Argumentos de línea de comandos
     */
    public static void main(String[] args) {
        // Instancias de DAOs para manejar operaciones en cada entidad
        ApartadoDAO apartadoDAO = new ApartadoDAO();
        UnidadAcademicaDAO unidadAcademicaDAO = new UnidadAcademicaDAO();
        BloqueoDAO bloqueoDAO = new BloqueoDAO();
        EstudianteDAO estudianteDAO = new EstudianteDAO();
        ComputadoraDAO computadoraDAO = new ComputadoraDAO();
        CentroComputoDAO centroComputoDAO = new CentroComputoDAO();
        CarreraDAO carreraDAO = new CarreraDAO();

        // Lista de software instalada en las computadoras
        List<String> sfwr = new ArrayList<>();
        sfwr.add("Photoshop");
        sfwr.add("Illustrator");
        sfwr.add("Netbeans");
        List<EstudianteEntidad> estudiantes = new ArrayList<>();

        // Descomentar para inicializar objetos de entidades
        /*
        UnidadAcademicaEntidad uaEntidad = new UnidadAcademicaEntidad("Nainari");
        EstudianteEntidad estudianteEntidad = new EstudianteEntidad("Pedro", "Ramirez", "Lopez", "123est321", "Inscrito");
        EstudianteEntidad estudianteEntidad2 = new EstudianteEntidad("Juan", "Ramirez", "Lopez", "123est321", "Inscrito");
        CentroComputoEntidad centroComputoEntidad = new CentroComputoEntidad("Cisco", "10cntro01comp1209", new GregorianCalendar(0, 0, 0, 14, 30, 0), new GregorianCalendar(0, 0, 0, 19, 30, 0), uaEntidad);
        ComputadoraEntidad computadoraEntidad = new ComputadoraEntidad(false, centroComputoEntidad, "192.168.0.1", sfwr, 1);
        BloqueoEntidad bloqueoEntidad = new BloqueoEntidad("Ladrón", Calendar.getInstance(), Calendar.getInstance(), estudianteEntidad);

        estudiantes.add(estudianteEntidad);
        estudiantes.add(estudianteEntidad2);
        CarreraEntidad caEntidad = new CarreraEntidad("Software", Date.from(Instant.now()), estudiantes);

        List<BloqueoEntidad> bloqueos = new ArrayList<>();
        bloqueos.add(bloqueoEntidad);

        estudianteEntidad.setCarrera(caEntidad);
        estudianteEntidad2.setCarrera(caEntidad);
        estudianteEntidad.setBloqueo(bloqueos);

        ApartadoEntidad apartadoEntidad = new ApartadoEntidad(Calendar.getInstance(), Calendar.getInstance(), estudianteEntidad, computadoraEntidad);
        apartadoDAO.guardarApartado(apartadoEntidad);

        // Guardado de entidades en la base de datos
        unidadAcademicaDAO.guardarUnidadAcademica(uaEntidad);
        bloqueoDAO.guardarBloqueo(bloqueoEntidad);
        estudianteDAO.guardarEstudiante(estudianteEntidad);
        computadoraDAO.guardarComputadora(computadoraEntidad);
        centroComputoDAO.guardarCentroComputo(centroComputoEntidad);
        carreraDAO.guardarCarrera(caEntidad);
         */
        // Pruebas de búsqueda de entidades
//        System.out.println("Una = " + carreraDAO.buscarUnaCarrera(caEntidad.getIdCarrera()).toString());
//        System.out.println("Todas = " + carreraDAO.buscarTodasCarrera().toString());
//        System.out.println(bloqueoDAO.buscarUnBloqueo(bloqueoEntidad.getId()));
        // Listas de filtros para centros y carreras
        List<String> carreras = new ArrayList<>();
        carreras.add("Software");
        List<String> centro = new ArrayList<>();
        centro.add("Cisco");

        // Inicialización de fechas para el reporte
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(1924, Calendar.OCTOBER, 28); // Fecha de inicio del reporte
        Calendar calendar2 = (Calendar) calendar1.clone();
        calendar2.add(Calendar.YEAR, 150); // Fecha de fin del reporte (150 años después)

        // Generación del reporte sin filtros específicos de centros y carreras
        List<Object[]> reporte = centroComputoDAO.obtenerReporteCentroComputoSinFiltro(calendar1, calendar2);

        // Procesamiento y salida del reporte
        for (Object[] row : reporte) {
            String centronombre = (String) row[0];
            int numMaquina = (int) row[1];
            Long cantidadAlumnos = (Long) row[2];
            int minutosActivos = (int) row[3];

            System.out.println(centronombre);
            System.out.println(numMaquina);
            System.out.println(cantidadAlumnos);
            System.out.println(minutosActivos);
        }
    }
}
