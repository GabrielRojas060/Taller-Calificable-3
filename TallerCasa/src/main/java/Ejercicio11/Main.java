/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio11;

/**
 *
 * @author Emprendedor
 */



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        int procesados = 0;
        int errores = 0;
        int numeroLinea = 1;

        Path archivoEntrada = Path.of("notas.csv");
        Path archivoSalida = Path.of("reporte.csv");

        try (
            BufferedReader lector = Files.newBufferedReader(
                archivoEntrada, StandardCharsets.UTF_8
            );

            BufferedWriter escritor = Files.newBufferedWriter(
                archivoSalida, StandardCharsets.UTF_8
            )
        ) {

          
            String encabezado = lector.readLine();

            if (encabezado == null) {
                System.out.println("El archivo está vacio.");
                return;
            }

           
            escritor.write("codigo,nombre,promedio,estado");
            escritor.newLine();

            String linea;

            while ((linea = lector.readLine()) != null) {

                numeroLinea++;

                try {

                    String[] datos = linea.split(",", -1);

                    if (datos.length != 5) {
                        throw new IllegalArgumentException(
                            "La linea debe tener 5 columnas."
                        );
                    }

                    String codigo = datos[0].trim();
                    String nombre = datos[1].trim();

          
                    double nota1 = Double.parseDouble(datos[2].trim());
                    double nota2 = Double.parseDouble(datos[3].trim());
                    
                    double nota3 = Double.parseDouble(datos[4].trim());

                    
                    
                    if (!Double.isFinite(nota1)
                            || !Double.isFinite(nota2)
                            || !Double.isFinite(nota3)) {
                        throw new IllegalArgumentException(
                            "Las notas deben ser numeros validos."
                        );
                    }

                
                    double promedio = (nota1 + nota2 + nota3) / 3;

                  
                    String estado;

                    if (promedio >= 3.0) {
                        estado = "APROBADO";
                    } else {
                        estado = "REPROBADO";
                    }

                    
                    escritor.write(
                        codigo + "," + nombre + ","
                        + String.format(Locale.US, "%.2f", promedio)
                        + "," + estado
                    );

                    escritor.newLine();

                    procesados++;

                } catch (IllegalArgumentException e) {

                    errores++;

                    System.out.println(
                        "Error en la linea " + numeroLinea
                        + ": " + e.getMessage()
                    );
                }
            }

        } catch (IOException e) {

            System.out.println(
                "Error al trabajar con los archivos: " + e.getMessage()
            );
        }

     
        System.out.println("\n----- RESUMEN -----");
        System.out.println("Registros procesados: " + procesados);
        System.out.println("Registros con error: " + errores);
        System.out.println("Reporte generado en reporte.csv");
    }
}

