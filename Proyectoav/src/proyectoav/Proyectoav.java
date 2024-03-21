/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/*
Proyecto de 
Javier Reyes 12111252 
Jose Alvarez 12341120
*/
package proyectoav;
import java.util.Scanner;
import java.util.Random;

public class Proyectoav {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Crear usuario
        Usuario usuario = crearUsuario(scanner);

        // Mostrar el menú de juegos
        boolean salir = false;
        while (!salir) {
            System.out.println("Menú de Juegos");
            System.out.println("1. Buscaminas");
            System.out.println("2. Laberinto");
            System.out.println("3. Connect 4");
            System.out.println("4. Juego de cartas");
            System.out.println("5. Salir");
            System.out.print("Selecciona el juego que deseas jugar: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después del número

            switch (opcion) {
                case 1:
                    jugarBuscaminas();
                    break;
                case 2:
                    jugarLaberinto();
                    break;
                case 3:
                    connect();
                    break;
                case 4:
                    jugarJuegoDeCartas(scanner);
                    break;
                case 5:
                    System.out.println("Gracias por jugar");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }

    public static Usuario crearUsuario(Scanner scanner) {
        System.out.println("¡Bienvenido! Crea tu usuario:");

        System.out.println("Ingrese su correo electrónico:");
        String correo = scanner.nextLine();

        System.out.println("Ingrese su contraseña:");
        String contrasena = scanner.nextLine();

        System.out.println("Ingrese un apodo único:");
        String apodo = scanner.nextLine();

        Random random = new Random();
        int numeroAleatorio = random.nextInt(20) + 1;

        Usuario usuario = new Usuario(correo, contrasena, apodo, numeroAleatorio);
        System.out.println("\n¡Usuario creado con éxito!");
        System.out.println(usuario);

        return usuario;
    }

    public static void jugarBuscaminas() {
        Buscaminas buscaminas = new Buscaminas(5, 5, 5);
        buscaminas.jugar();
    }

    public static void jugarLaberinto() {
        Laberinto laberinto = new Laberinto();
        laberinto.jugar();
    }

    public static void connect() {
        Scanner scanner = new Scanner(System.in);
        JuegoConecta4 juego = new JuegoConecta4();

        while (!juego.terminado()) {
            juego.mostrarTablero();
            System.out.print("Jugador " + juego.getJugadorActual() + " ingrese una columna (del 1 al 7): ");
            int columna = scanner.nextInt() - 1;

            if (juego.validarMovimiento(columna)) {
                juego.realizarMovimiento(columna);
            } else {
                System.out.println("Movimiento inválido. Por favor, ingrese otra columna.");
            }
        }

        juego.mostrarTablero();
        if (juego.ganador() != null) {
            System.out.println("El jugador " + juego.ganador() + " ha ganado");
        } else {
            System.out.println("Hay un empate");
        }
    }

    public static void jugarJuegoDeCartas(Scanner scanner) {
        JuegoCartas juegoCartas = new JuegoCartas(scanner);
        juegoCartas.jugar();
    }
   
    /*public static void jugarAjedrez() {
        Practical_labs_progra juegoAjedrez = new Practical_labs_progra();
        juegoAjedrez.startGame();
    }*/
}

