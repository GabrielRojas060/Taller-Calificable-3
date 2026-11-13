/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio10;

/**
 *
 * @author Emprendedor
 */



import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Bitacora {

     private String ruta;

    private static final DateTimeFormatter FORMATO =
                      DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

     public Bitacora(String ruta) {
             this.ruta = ruta;
    }

    public void registrar(String mensaje) throws IOException {

        String fecha = LocalDateTime.now().format(FORMATO);
        
            
        try (PrintWriter salida = new PrintWriter(
                new OutputStreamWriter(
                                    new FileOutputStream(ruta, true),
                        StandardCharsets.UTF_8))) {

            
            salida.println("[" + fecha + "] " + mensaje);
        }
    }
    

    public List<String> leer() throws IOException {
        
        try (BufferedReader entrada = new BufferedReader(
                new InputStreamReader(
                          new FileInputStream(ruta),
                        StandardCharsets.UTF_8))) {

            return entrada.lines().toList();
        }
    }
    

    public int contar(String palabra) throws IOException {

        
         int contador = 0;

         
        for (String linea : leer()) {

            if (linea.toLowerCase().contains(palabra.toLowerCase())) {

                
                contador++;
            }
        }
        

        return contador;
    }
}
