/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio10;

/**
 *
 * @author Emprendedor
 */


import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Bitacora bitacora = new Bitacora("bitacora.txt");

        try {

            bitacora.registrar("Inicio del sistema");

               bitacora.registrar("ERROR al conectar con el servidor");

                   bitacora.registrar("Usuario inicio sesión");
            
                bitacora.registrar("ERROR: archivo no encontrado");
            
               System.out.println("Contenido de la bitacora:");

               for (String linea : bitacora.leer()) {

                System.out.println(linea);
            }
               
             System.out.println("Total de errores: "
                    + bitacora.contar("ERROR"));

               try {

                    new Bitacora("noexiste.txt").leer();
        
            } catch (FileNotFoundException e) {
                
                System.out.println(
                        
                            "No se pudo leer: el archivo noexiste.txt no existe.");
            }

        } catch (IOException e) {

            
               System.out.println("Error de entrada/salida: " + e.getMessage());
        }
    }
}

