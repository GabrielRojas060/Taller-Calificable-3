/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio4;

/**
 *
 * @author Emprendedor
 */

interface Llamable {

    void llamar(String numero);

    void colgar();

    default String funcion() {
        return "Llamadas";
    }
}


interface Fotografiable {

    void tomarFoto();

    int getMegapixeles();

    default String funcion() {
        
        return "Fotografia";
    }
}



abstract class Dispositivo {

    protected String marca;
    protected String modelo;
    
    protected double precio;

    public Dispositivo(String marca, String modelo, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        
    }

    
    public abstract void describir();
}


class Smartphone extends Dispositivo implements Llamable, Fotografiable {

    private int megapixeles;

    public Smartphone(String marca, String modelo, double precio, int megapixeles) {
        super(marca, modelo, precio);
        this.megapixeles = megapixeles;
    }

    @Override
    public void describir() {
        
        System.out.printf("Smartphone %s %s - $%,.0f - %s%n",
                marca, modelo, precio, funcion());
    }

    @Override
    public void llamar(String numero) {
        
        System.out.println(marca + " llamando a " + numero);
    }

    @Override
    public void colgar() {
        System.out.println(marca + " finalizo la llamada");
    }

    @Override
    public void tomarFoto() {
        
        System.out.println(marca + " tomo una foto de " + megapixeles + " MP");
    }

    @Override
    public int getMegapixeles() {
        return megapixeles;
    }

    
    
    @Override
    public String funcion() {
        return "Llamadas y fotografia";
    }
}

class Camara extends Dispositivo implements Fotografiable {
    

    private int megapixeles;

    public Camara(String marca, String modelo, double precio, int megapixeles) {
        super(marca, modelo, precio);
        this.megapixeles = megapixeles;
        
    }

    @Override
    public void describir() {
        System.out.printf("Camara %s %s - $%,.0f - %s%n",
                marca, modelo, precio, funcion());
    }

    
    @Override
    public void tomarFoto() {
        System.out.println(marca + " tomo una foto profesional de " + megapixeles + " MP");
    }

    @Override
    public int getMegapixeles() {
        return megapixeles;
        
    }
}


public class Main {

    public static void main(String[] args) {

        Dispositivo[] dispositivos = {
            
            
            new Smartphone("Samsung", "Galaxy S24", 3500000, 50),
            new Smartphone("Xiaomi", "14 Ultra", 5200000, 108),
            new Camara("Canon", "EOS R50", 4200000, 24)
        };

        
        int mayorResolucion = 0;
        

        for (Dispositivo d : dispositivos) {
            

            d.describir();

            if (d instanceof Fotografiable) {
                

                Fotografiable foto = (Fotografiable) d;

                foto.tomarFoto();
                

                if (foto.getMegapixeles() > mayorResolucion) {
                    mayorResolucion = foto.getMegapixeles();
                }
            }

            if (d instanceof Llamable) {

                Llamable telefono = (Llamable) d;

                telefono.llamar("3001234567");
                telefono.colgar();
            }

            System.out.println();
        }

        
        System.out.println("Mayor resolucion: " + mayorResolucion + " MP");
    }
}
