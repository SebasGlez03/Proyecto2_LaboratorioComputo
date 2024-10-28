/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package negocio.logica;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import negocio.DTO.ApartadoDTO;
import negocio.DTO.CarreraDTO;
import negocio.DTO.CentroComputoDTO;
import negocio.DTO.UnidadAcademicaDTO;
import persistencia.DAO.ApartadoDAO;
import persistencia.DAO.BloqueoDAO;
import persistencia.DAO.CarreraDAO;
import persistencia.DAO.CentroComputoDAO;
import persistencia.DAO.ComputadoraDAO;
import persistencia.DAO.EstudianteDAO;
import persistencia.DAO.UnidadAcademicaDAO;
import persistencia.entidades.ApartadoEntidad;
import persistencia.entidades.BloqueoEntidad;
import persistencia.entidades.CarreraEntidad;
import persistencia.entidades.CentroComputoEntidad;
import persistencia.entidades.ComputadoraEntidad;
import persistencia.entidades.EstudianteEntidad;
import persistencia.entidades.UnidadAcademicaEntidad;

/**
 * Clase de pruebas para realizar distintas operaciones de negocio relacionadas
 * con entidades de estudiantes, apartados, carreras, y otros componentes de un
 * sistema de gestión.
 *
 * @version 1.0
 * @since 2024-10-28
 */
public class pruebasNegocio {

    /**
     * Método principal para ejecutar pruebas de negocio.
     *
     * @param args los argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {

        // Instancias de las clases de negocio para realizar operaciones CRUD
        ApartadoNegocio apartadoN = new ApartadoNegocio();
        CarreraNegocio carreraN = new CarreraNegocio();
        UnidadAcademicaNegocio unidadAcademicaN = new UnidadAcademicaNegocio();
        CentroComputoNegocio centroComputoN = new CentroComputoNegocio();
        ComputadoraNegocio computadoraN = new ComputadoraNegocio();
        EstudianteNegocio estudianteN = new EstudianteNegocio();

        // Lista de software para la configuración de una computadora
        List<String> sfwr = new ArrayList<>();
        sfwr.add("Photoshop");
        sfwr.add("Illustrator");
        sfwr.add("Netbeans");

        // Creación de entidades de estudiantes
        List<EstudianteEntidad> estudiantes = new ArrayList<>();
        UnidadAcademicaEntidad uaEntidad = new UnidadAcademicaEntidad("Nainari");
        EstudianteEntidad estudianteEntidad = new EstudianteEntidad("Pedro", "Ramirez", "Lopez", "123est321", "Inscrito");
        EstudianteEntidad estudianteEntidad2 = new EstudianteEntidad("Juan", "Ramirez", "Lopez", "123est321", "Inscrito");

        // Configuración de una entidad de centro de cómputo con horario y asignación a la unidad académica
        CentroComputoEntidad centroComputoEntidad = new CentroComputoEntidad("Cisco", "10cntro01comp1209", new GregorianCalendar(0, 0, 0, 14, 30, 0), new GregorianCalendar(0, 0, 0, 19, 30, 0), uaEntidad);

        // Configuración de una entidad de computadora con dirección IP y lista de software
        ComputadoraEntidad computadoraEntidad = new ComputadoraEntidad(false, centroComputoEntidad, "192.168.0.1", sfwr, 1);

        // Creación de un bloqueo de estudiante y asignación a la computadora
        BloqueoEntidad bloqueoEntidad = new BloqueoEntidad("Ladrón", Calendar.getInstance(), Calendar.getInstance(), estudianteEntidad);
        List<BloqueoEntidad> bloqueos = new ArrayList<>();
        bloqueos.add(bloqueoEntidad);
        computadoraEntidad.setCentroComputoEntidad(centroComputoEntidad);
        estudianteEntidad.setBloqueo(bloqueos);

        // Agregación de estudiantes a una entidad de carrera
        estudiantes.add(estudianteEntidad);
        estudiantes.add(estudianteEntidad2);
        CarreraEntidad caEntidad = new CarreraEntidad("Software", Date.from(Instant.now()), estudiantes);

        // Configuración de un apartado de una computadora para un estudiante
        ApartadoEntidad apartadoEntidad = new ApartadoEntidad(Calendar.getInstance(), Calendar.getInstance(), estudianteEntidad, computadoraEntidad);

        // Ejemplo de consulta de centros de cómputo
        System.out.println(centroComputoN.buscarCentrosComputos().toString());
    }
}
