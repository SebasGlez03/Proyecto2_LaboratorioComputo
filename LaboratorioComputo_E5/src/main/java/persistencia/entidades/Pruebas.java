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
 *
 * @author PC
 */
public class Pruebas {

    public static void main(String[] args) {
            // CREAMOS UNA FACTORY DE ENTITY MANAGERS
            EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            // CREAMOS UN OBJETO EM QUE REPRESENTA A LA BD EN CÓDIGO
            EntityManager entityManager = managerFactory.createEntityManager();
            // INICIAMOS LA TRANSACCION
            entityManager.getTransaction().begin();

    
            
            entityManager.close();
            managerFactory.close();

    }
}
