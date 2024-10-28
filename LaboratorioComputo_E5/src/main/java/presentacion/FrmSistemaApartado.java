/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import negocio.DTO.ComputadoraDTO;
import negocio.logica.ComputadoraNegocio;

/**
 * Clase que representa un sistema de apartado de computadoras en una interfaz
 * gráfica.
 * <p>
 * Muestra una ventana que permite seleccionar una computadora específica de una
 * lista, en función del centro al que pertenece. Al seleccionar una
 * computadora, se abre una nueva ventana con los detalles del apartado.
 * </p>
 * <p>
 * Usa la clase {@link ComputadoraNegocio} para realizar búsquedas de
 * computadoras y crea botones de manera dinámica para cada computadora
 * disponible.
 * </p>
 *
 * @author santi
 */
public class FrmSistemaApartado extends JFrame {

    // Instancia del negocio para manejar operaciones de computadoras
    ComputadoraNegocio computadoraNegocio;
    Long idE; // Identificador de la entidad o evento relacionado
    Long idcC; // Identificador del centro de computadoras

    /**
     * Constructor que inicializa la ventana de selección de computadoras.
     * Configura el título, tamaño, y establece una disposición de botones para
     * cada computadora disponible en el centro especificado.
     *
     * @param idcC Identificador del centro de computadoras.
     * @param idE Identificador de la entidad o evento relacionado.
     */
    public FrmSistemaApartado(Long idcC, Long idE) {
        // Configuración básica del JFrame
        this.idE = idE;
        this.idcC = idcC;

        setTitle("Selecciona una computadora");
        setSize(1000, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Inicializamos el negocio de computadoras
        ComputadoraNegocio computadoraNegocio = new ComputadoraNegocio();
        this.computadoraNegocio = computadoraNegocio;

        // Obtener la lista de computadoras disponibles en el centro
        List<ComputadoraDTO> computadoras = new ArrayList<>();
        computadoras = computadoraNegocio.buscarComputadorasPorCentro(idcC);

        // Calcular el número de filas y columnas para la disposición de botones
        int[] filasColumnas = calcularFilasColumnas(computadoras.size());
        int filas = filasColumnas[0];
        int columnas = filasColumnas[1];

        // Crear un JPanel con un diseño de cuadrícula (GridLayout)
        JPanel panel = new JPanel(new GridLayout(filas, columnas));

        // Crear e insertar botones en cada celda para representar cada computadora
        int numComputadora = 1;
        String nombreComputadora;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                nombreComputadora = String.valueOf(numComputadora);
                if (numComputadora <= computadoras.size()) {
                    JButton boton = new JButton(nombreComputadora);

                    // Asignar una acción al botón para abrir detalles de la computadora
                    boton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Long idC = computadoraNegocio.buscarComputadora(Long.parseLong(boton.getText())).getId();
                            new FrmDetallesApartado(idC, idE, idcC).setVisible(true);
                            cerrar();
                        }
                    });

                    numComputadora++;
                    panel.add(boton);
                }
            }
        }

        // Añadir el panel con botones al JFrame
        add(panel);
    }

    /**
     * Calcula el número de filas y columnas de manera que el producto de ambos
     * sea igual a la cantidad de entradas, y que formen una disposición
     * cuadrada o casi cuadrada.
     *
     * @param cantidadEntradas La cantidad total de entradas (computadoras) a
     * mostrar.
     * @return Un arreglo de enteros donde [0] es el número de filas y [1] el
     * número de columnas.
     */
    public static int[] calcularFilasColumnas(int cantidadEntradas) {
        int filas = (int) Math.sqrt(cantidadEntradas); // Calcular raíz cuadrada para filas
        int columnas = filas; // Inicializar columnas con el mismo valor

        // Incrementar columnas hasta alcanzar la cantidad de entradas
        while (filas * columnas < cantidadEntradas) {
            columnas++;
        }

        // Incrementar filas en caso de ser necesario
        while (filas * columnas < cantidadEntradas) {
            filas++;
        }

        return new int[]{filas, columnas};
    }

    /**
     * Cierra la ventana actual.
     */
    public void cerrar() {
        this.dispose();
    }

}
