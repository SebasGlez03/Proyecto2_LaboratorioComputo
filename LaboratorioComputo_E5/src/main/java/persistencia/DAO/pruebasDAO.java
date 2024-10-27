/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package persistencia.DAO;

import persistencia.entidades.BloqueoEntidad;
import persistencia.entidades.CarreraEntidad;
import persistencia.entidades.CentroComputoEntidad;
import persistencia.entidades.ComputadoraEntidad;
import persistencia.entidades.EstudianteEntidad;
import persistencia.entidades.UnidadAcademicaEntidad;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import persistencia.entidades.ApartadoEntidad;

/**
 *
 * @author santi
 */
public class pruebasDAO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ApartadoDAO apartadoDAO = new ApartadoDAO();
        UnidadAcademicaDAO unidadAcademicaDAO = new UnidadAcademicaDAO();
        BloqueoDAO bloqueoDAO = new BloqueoDAO();
        EstudianteDAO estudianteDAO = new EstudianteDAO();
        ComputadoraDAO computadoraDAO = new ComputadoraDAO();
        CentroComputoDAO centroComputoDAO = new CentroComputoDAO();
        CarreraDAO carreraDAO = new CarreraDAO();

        List<String> sfwr = new ArrayList<>();
        sfwr.add("Photoshop");
        sfwr.add("Illustrator");
        sfwr.add("Netbeans");
        List<EstudianteEntidad> estudiantes = new ArrayList<>();

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

//        apartadoDAO.eliminarApartado(apartadoEntidad);
        unidadAcademicaDAO.guardarUnidadAcademica(uaEntidad);
        bloqueoDAO.guardarBloqueo(bloqueoEntidad);
        estudianteDAO.guardarEstudiante(estudianteEntidad);
        computadoraDAO.guardarComputadora(computadoraEntidad);
        centroComputoDAO.guardarCentroComputo(centroComputoEntidad);
        carreraDAO.guardarCarrera(caEntidad);

        System.out.println("Una = " + carreraDAO.buscarUnaCarrera(caEntidad.getIdCarrera()).toString());
        System.out.println("Todas = " + carreraDAO.buscarTodasCarrera().toString());
        System.out.println(bloqueoDAO.buscarUnBloqueo(bloqueoEntidad.getId()));
//          System.out.println(bloqueoDAO.buscarTodosBloqueos());

        System.out.println(centroComputoDAO.buscarCentrosPorUnidad(Long.parseLong("1")).toString());
        System.out.println(computadoraDAO.buscarComputadorasPorCentro(Long.parseLong("1")).toString());

    }

}
