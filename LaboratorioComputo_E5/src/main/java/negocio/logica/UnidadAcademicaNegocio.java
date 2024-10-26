/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.logica;

import java.util.ArrayList;
import java.util.List;
import negocio.DTO.*;
import persistencia.DAO.UnidadAcademicaDAO;
import persistencia.entidades.*;
import persistencia.entidades.CentroComputoEntidad;

/**
 *
 * @author santi
 */
public class UnidadAcademicaNegocio {

    UnidadAcademicaDAO unidadAcademicaDAO;
    
    public UnidadAcademicaNegocio() {
        
        UnidadAcademicaDAO unidadAcademicaDAO = new UnidadAcademicaDAO();
        this.unidadAcademicaDAO = unidadAcademicaDAO;
        
    }
    
    public UnidadAcademicaEntidad convertir(UnidadAcademicaDTO dto){
    

        UnidadAcademicaEntidad entidad = new UnidadAcademicaEntidad();
        CentroComputoNegocio ccE = new CentroComputoNegocio();
        
        entidad.setId(dto.getId());
        entidad.setNombre(dto.getNombre());
        
//        List<CentroComputoEntidad> centrosComputo = new ArrayList<>();
//        for (CentroComputoDTO y : dto.getCentros()){
//            CentroComputoEntidad x = ccE.convertir(y);
//            centrosComputo.add(x);
//        }
//        entidad.setCentrosComputo(centrosComputo);
        entidad.setCentrosComputo(null);

        return entidad;
        
    }
    
    public void guardarUnidadAcademica(UnidadAcademicaDTO uaD){
        
        unidadAcademicaDAO.guardarUnidadAcademica(convertir(uaD));
        
    }
    
}
