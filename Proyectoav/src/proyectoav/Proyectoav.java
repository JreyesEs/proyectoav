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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import proyectoav.Practical_labs_progra;

public class Proyectoav {
    private static ArrayList<Usuario> usuarios = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean nuevoUsuario = true;
        Usuario usuario = null;

        while (nuevoUsuario) {
            System.out.println("\n¿Desea ingresar con un nuevo usuario y ver la lista de usuarios? (no/si): ");
            String respuesta = scanner.nextLine().toLowerCase();

            if (respuesta.equals("no")) {
                nuevoUsuario = false;
                System.out.println("¡Hasta luego!");
            } else if (respuesta.equals("si")) {
                mostrarUsuarios();
                usuario = null; // Reiniciar el usuario actual para ingresar uno nuevo
            } else {
                System.out.println("Opción no válida. Por favor, ingrese 'no' para salir o 'si' para ingresar con un nuevo usuario y ver la lista de usuarios.");
            }

            if (usuario == null) {
                usuario = crearUsuario(scanner);
                usuarios.add(usuario);
            }

            // Mostrar el menú de juegos
            boolean salir = false;
            while (!salir) {
                System.out.println("Menú de Juegos");
                System.out.println("1. Buscaminas");
                System.out.println("2. Laberinto");
                System.out.println("3. Connect 4");
                System.out.println("4. Juego de cartas");
                System.out.println("5. Ajedrez");
                System.out.println("6. Salir");
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
                        jugarPracticalLabsProgra();
                        break;
                    case 6:
                        System.out.println("Gracias por jugar");
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            }

            System.out.println("\n¿Desea ingresar con un nuevo usuario? (s/n): ");
            respuesta = scanner.nextLine().toLowerCase();

            if (respuesta.equals("si")) {
                // No es necesario hacer nada, el ciclo continuará y preguntará al usuario si es existente
            } else if (respuesta.equals("no")) {
                nuevoUsuario = false;
                System.out.println("¡Hasta luego!");
            } else {
                System.out.println("Opción no válida. Por favor, ingrese 's' para un usuario existente o 'n' para un nuevo usuario.");
                nuevoUsuario = false; // Terminar el programa si la opción es inválida
            }
        }

        scanner.close();
    }

    public static Usuario crearUsuario(Scanner scanner) {
        System.out.println("¡Bienvenido! Crea tu usuario:");

        System.out.println("Ingrese su correo electrónico:");
        String correo = scanner.nextLine();

        // Verificar si el correo ya está registrado
        for (Usuario u : usuarios) {
            if (u.getCorreo().equals(correo)) {
                System.out.println("El correo ingresado ya está registrado. Por favor, inicia sesión.");
                return null;
            }
        }

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
    
    public static Usuario ingresarUsuario(Scanner scanner) {
        System.out.println("Ingrese su correo electrónico:");
        String correo = scanner.nextLine();

        System.out.println("Ingrese su contraseña:");
        String contrasena = scanner.nextLine();

        // Verificar si el usuario existe en la lista de usuarios
        for (Usuario u : usuarios) {
            if (u.getCorreo().equals(correo) && u.getContrasena().equals(contrasena)) {
                System.out.println("\n¡Inicio de sesión exitoso!");
                return u;
            }
        }

        System.out.println("Usuario o contraseña incorrectos. Por favor, inténtalo de nuevo.");
        return null;
    }
    
    public static void mostrarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            System.out.println("Lista de usuarios registrados:");
            for (Usuario u : usuarios) {
                System.out.println(u.getApodo());
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

    public static void jugarPracticalLabsProgra() {
        Practical_labs_progra labsProgra = new Practical_labs_progra();
        labsProgra.startGame();
    }
}


