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
 *
 * @author santi
 */
public class pruebasNegocio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ApartadoNegocio apartadoN = new ApartadoNegocio();
        CarreraNegocio carreraN = new CarreraNegocio();
        UnidadAcademicaNegocio unidadAcademicaN = new UnidadAcademicaNegocio();
        CentroComputoNegocio centroComputoN = new CentroComputoNegocio();
 
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

        estudiantes.add(estudianteEntidad);
        estudiantes.add(estudianteEntidad2);
        CarreraEntidad caEntidad = new CarreraEntidad("Software", Date.from(Instant.now()), estudiantes);

        List<BloqueoEntidad> bloqueos = new ArrayList<>();
        bloqueos.add(bloqueoEntidad);

        computadoraEntidad.setEstudiante(estudianteEntidad);
        computadoraEntidad.setCentroComputoEntidad(centroComputoEntidad);

        estudianteEntidad.setComputadora(computadoraEntidad);
        estudianteEntidad.setCarrera(caEntidad);
        estudianteEntidad2.setCarrera(caEntidad);
        estudianteEntidad.setBloqueo(bloqueos);
        
        
        
//        ApartadoEntidad apartadoEntidad = new ApartadoEntidad(Calendar.getInstance(), Calendar.getInstance(), estudianteEntidad, computadoraEntidad);
//        
//        ApartadoDTO apN = new ApartadoDTO(apartadoEntidad);
//        
//        apartadoN.guardarApartado(apN);
//        System.out.println(apartadoN.buscarTodosApartados().toString());
//
        CarreraDTO carreraDTO = new CarreraDTO(caEntidad);
        
        carreraN.guardarCarrera(carreraDTO);
//
        UnidadAcademicaDTO unidadAcademicaDTO = new UnidadAcademicaDTO(uaEntidad);
        
        unidadAcademicaN.guardarUnidadAcademica(unidadAcademicaDTO);

        CentroComputoDTO centroComputoDTO = new CentroComputoDTO(centroComputoEntidad);
        
        centroComputoN.guardarCentroComputo(centroComputoDTO);
        
    }
    
}
