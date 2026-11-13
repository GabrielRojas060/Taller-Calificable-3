/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio8;

/**
 *
 * @author Emprendedor
 */



import java.util.Scanner;

public class Main {
    

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CuentaBancaria cuenta = new CuentaBancaria("Gabriel", 500000);

        
        boolean salir = false;

        try {
            

            while (!salir) {
                

                System.out.println("\n1. Consultar");
                System.out.println("2. Depositar");
                System.out.println("3. Retirar");
                System.out.println("4. Salir");

                System.out.print("Opción: ");
                
                

                try {

                    int opcion = Integer.parseInt(sc.nextLine());

                    switch (opcion) {

                        
                        case 1:

                            System.out.println("Titular: " + cuenta.getTitular());
                            System.out.println("Saldo: $" + cuenta.getSaldo());

                            
                            
                            break;
                            

                            
                         
                        case 2:

                            
                            System.out.print("Monto a depositar: ");

                            double deposito = Double.parseDouble(sc.nextLine());

                            cuenta.depositar(deposito);

                            
                            System.out.println("Deposito realizado correctamente.");

                            break;

                        case 3:
                            

                            System.out.print("Monto a retirar: ");

                            double retiro = Double.parseDouble(sc.nextLine());

                            cuenta.retirar(retiro);

                            System.out.println("Retiro realizado correctamente.");

                            break;

                            
                        case 4:

                            salir = true;

                            System.out.println("Gracias por utilizar el cajero.");

                            break;

                            
                        default:

                            System.out.println("Opcion no valida.");
                    }

                    
                } catch (NumberFormatException e) {
                    

                    System.out.println("Error: debe ingresar un numero.");
                    

                } catch (MontoInvalidoException | SaldoInsuficienteException e) {
                    

                    System.out.println(e.getMessage());
                }
                
                
            }

        } finally {
            

            sc.close();
        }
    }
}
