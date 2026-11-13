/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio7;

/**
 *
 * @author Emprendedor
 */

import java.util.Scanner;

public class Maun {

    public static double promedio(double[] notas) {
        

        if (notas == null || notas.length == 0) {
            
            throw new IllegalArgumentException("Debe ingresar al menos una nota");
        
        }

        double suma = 0;

        
        
        for (int i = 0; i < notas.length; i++) {

            if (notas[i] < 0 || notas[i] > 5) {
                throw new IllegalArgumentException("Las notas deben estar entre 0 y 5");
            }

            
            suma += notas[i];
        }

        return suma / notas.length;
    }
    

    public static void main(String[] args) {
    
        
        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("¿Cuantas notas? ");

            
            int n = Integer.parseInt(sc.nextLine());
            

            if (n <= 0) {
                System.out.println("Debe ingresar una cantidad mayor que cero");
                return;
            }

            
            double[] notas = new double[n];

            for (int i = 0; i < n; i++) {
                

                System.out.print("Ingrese la nota " + (i + 1) + ": ");

                notas[i] = Double.parseDouble(sc.nextLine().replace(',', '.'));

                if (notas[i] < 0 || notas[i] > 5) {
                    
                    throw new IllegalArgumentException("La nota debe estar entre 0 y 5");
                }
            }

            System.out.printf("Promedio: %.2f%n", promedio(notas));

            
        } catch (NumberFormatException e) {

            System.out.println("Dato invalido: debe ingresar un numero");

        } catch (IllegalArgumentException e) {
            

            System.out.println("Error: " + e.getMessage());

            
        }
    }
}
