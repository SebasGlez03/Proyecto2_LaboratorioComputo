/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.logica;

import java.util.ArrayList;
import java.util.List;
import negocio.DTO.ApartadoDTO;
import persistencia.DAO.ApartadoDAO;
import persistencia.entidades.ApartadoEntidad;

/**
 * Clase que contiene la lógica de negocio relacionada con los apartados.
 * Gestiona la creación, modificación, eliminación y búsqueda de apartados en el sistema.
 * Se utiliza para convertir datos de entidad a DTO y viceversa, y para interactuar
 * con el DAO de Apartado.
 * 
 * @author santi
 */
public class ApartadoNegocio {

    // DAO que permite la interacción con la base de datos para los apartados.
    ApartadoDAO apartadoDAO = null;
    
    /**
     * Constructor de ApartadoNegocio.
     * Inicializa el DAO de Apartado para permitir la gestión de apartados.
     */
    public ApartadoNegocio() {
        ApartadoDAO apartadoDAO = new ApartadoDAO(); 
        this.apartadoDAO = apartadoDAO;
    }
    
    /**
     * Convierte un objeto de tipo ApartadoDTO en una entidad ApartadoEntidad.
     * 
     * @param dto el DTO de Apartado que se convertirá.
     * @return la entidad de Apartado convertida.
     */
    public ApartadoEntidad convertir(ApartadoDTO dto){
        ComputadoraNegocio cN = new ComputadoraNegocio();
        EstudianteNegocio eN = new EstudianteNegocio();
        ApartadoEntidad entidad = new ApartadoEntidad();
        
        entidad.setId(dto.getId());
        entidad.setFechaInicio(dto.getFechaInicio());
        entidad.setFechaFin(dto.getFechaFin());
        
        // Convertir y asignar la computadora y el estudiante asociados al apartado.
        entidad.setComputadora(cN.convertir(dto.getComputadora()));
        entidad.setEstudiante(eN.convertir(dto.getEstudiante()));
        
        return entidad;
    }
    
    /**
     * Guarda un nuevo apartado en la base de datos.
     * 
     * @param ap el DTO de Apartado a guardar.
     */
    public void guardarApartado(ApartadoDTO ap){
        apartadoDAO.guardarApartado(convertir(ap));
    }
    
    /**
     * Modifica un apartado existente en la base de datos.
     * 
     * @param ap el DTO de Apartado a modificar.
     */
    public void modificarApartado(ApartadoDTO ap){
        apartadoDAO.modificarApartado(convertir(ap));
    }
    
    /**
     * Elimina un apartado existente en la base de datos.
     * 
     * @param ap el DTO de Apartado a eliminar.
     */
    public void eliminarApartado(ApartadoDTO ap){
        apartadoDAO.eliminarApartado(convertir(ap));
    }
 
    /**
     * Busca un apartado en la base de datos por su identificador.
     * 
     * @param id el identificador del apartado a buscar.
     * @return el DTO de Apartado encontrado.
     */
    public ApartadoDTO buscarApartado(Long id){
        ApartadoDTO ap = new ApartadoDTO(apartadoDAO.buscarUnApartado(id));
        return ap;
    }
    
    /**
     * Busca todos los apartados en la base de datos.
     * 
     * @return una lista de DTOs de Apartado.
     */
    public List<ApartadoDTO> buscarTodosApartados(){
        List<ApartadoDTO> apartados = new ArrayList<>();
        List<ApartadoEntidad> aE = new ArrayList<>();
        aE = apartadoDAO.buscarTodosApartados();
        // Convertir cada entidad encontrada en la base de datos a un DTO.
        if (aE != null){
        for (ApartadoEntidad y : aE){
            ApartadoDTO x = new ApartadoDTO(y);
            apartados.add(x);
        }
        
        return apartados;
        }
        else{ return null;}
    }
}
