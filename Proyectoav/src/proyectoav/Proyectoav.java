/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoav;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author Javier Reyes
 */
public class Proyectoav {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner proyecto = new Scanner(System.in);
        boolean salir = false;
        
        while (!salir){
            System.out.println("Menú de Juegos");
            System.out.println("1. Buscaminas");
            System.out.println("2. Laberinto");
            System.out.println("3. Salir");
            System.out.print("Selecciona el juego que deseas jugar (1 o 2): ");

            int opcion = proyecto.nextInt();

            switch (opcion) {
                case 1:
                    jugarBuscaminas();
                    break;
                case 2:
                    jugarLaberinto();
                    break;
                case 3:
                    System.out.println("Gracias por jugar");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");

            }
        }
    }

    public static void jugarBuscaminas() {
        Buscaminas buscaminas = new Buscaminas(5, 5, 5);
        buscaminas.jugar();
    }

    public static void jugarLaberinto() {
        Laberinto laberinto = new Laberinto();
        laberinto.jugar();
    }
    
}
