/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package persistencia;

import entidades.BloqueoEntidad;
import entidades.CarreraEntidad;
import entidades.CentroComputoEntidad;
import entidades.ComputadoraEntidad;
import entidades.EstudianteEntidad;
import entidades.RentaEntidad;
import entidades.UnidadAcademicaEntidad;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *@deprecated
 * @author santi
 */
public class pruebasDAO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        RentaDAO rentaDAO = new RentaDAO();
        UnidadAcademicaDAO unidadAcademicaDAO = new UnidadAcademicaDAO();
        BloqueoDAO bloqueoDAO = new BloqueoDAO();
        
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
        CarreraEntidad caEntidad = new CarreraEntidad("Software", Date.from(Instant.now()), uaEntidad, estudiantes);

        List<BloqueoEntidad> bloqueos = new ArrayList<>();
        bloqueos.add(bloqueoEntidad);

        computadoraEntidad.setEstudiante(estudianteEntidad);

        estudianteEntidad.setComputadora(computadoraEntidad);
        estudianteEntidad.setCarrera(caEntidad);
        estudianteEntidad2.setCarrera(caEntidad);
        estudianteEntidad.setBloqueo(bloqueos);
        
//        RentaEntidad rentaEntidad = new RentaEntidad(Calendar.getInstance(), estudianteEntidad, computadoraEntidad);
//        rentaDAO.guardarRenta(rentaEntidad);
//        
//        rentaDAO.eliminarRenta(rentaEntidad);
//        unidadAcademicaDAO.guardarUnidadAcademica(uaEntidad);
        bloqueoDAO.guardarBloqueo(bloqueoEntidad);


        
    }
    
}
