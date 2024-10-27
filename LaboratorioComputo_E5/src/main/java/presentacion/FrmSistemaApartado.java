/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

/**
 *
 * @author santi
 */

import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import negocio.DTO.ComputadoraDTO;
import negocio.logica.ComputadoraNegocio;

public class FrmSistemaApartado extends JFrame {
    
    ComputadoraNegocio computadoraNegocio;

    public FrmSistemaApartado(Long idcC, Long idE) {
        // Configuración básica del JFrame
                
        setTitle("Selecciona una computadora");
        setSize(1000, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        //Inicializamos negocio
        ComputadoraNegocio computadoraNegocio = new ComputadoraNegocio();
        this.computadoraNegocio = computadoraNegocio;
        
        List<ComputadoraDTO> computadoras = new ArrayList<>();
        
        computadoras = computadoraNegocio.buscarComputadorasPorCentro(idcC);
        
        int[] filasColumnas = new int[1];
        filasColumnas = calcularFilasColumnas(computadoras.size());
        int filas = filasColumnas[0];
        int columnas = filasColumnas[1];
        // Crear un JPanel con GridLayout
        JPanel panel = new JPanel(new GridLayout(filas, columnas));
        
        // Crear e insertar botones en cada celda
        int numComputadora = 1;
        String nombreComputadora;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                nombreComputadora =  String.valueOf(numComputadora);
                if(numComputadora <= computadoras.size()){
                JButton boton = new JButton(nombreComputadora);
                
                boton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Botón presionado: " + boton.getText());
                        
                        System.out.println(computadoraNegocio.buscarComputadora(Long.parseLong(boton.getText())));
                    }
                
                }
                );
                
                numComputadora++;
                panel.add(boton);
                }
            }
        }
        
        
        // Añadir el panel al JFrame
        add(panel);
    }
    
    /**
     * Calcula el número de filas y columnas que se asemejan a un cuadrado,
     * para que el producto de filas y columnas sea igual a la cantidad de entradas.
     *
     * @param cantidadEntradas La cantidad total de entradas.
     * @return Un arreglo con el número de filas y columnas.
     */
    public static int[] calcularFilasColumnas(int cantidadEntradas) {
        int filas = (int) Math.sqrt(cantidadEntradas); // Obtener la raíz cuadrada para filas
        int columnas = filas; // Inicializar columnas con el mismo valor

        // Ajustar filas y columnas si el producto es menor que la cantidad de entradas
        while (filas * columnas < cantidadEntradas) {
            columnas++; // Incrementar columnas
        }

        // En caso de que las filas y columnas no sean suficientes
        // podemos ajustar filas en base a columnas
        while (filas * columnas < cantidadEntradas) {
            filas++; // Incrementar filas
        }

        return new int[] { filas, columnas };
    }

}


