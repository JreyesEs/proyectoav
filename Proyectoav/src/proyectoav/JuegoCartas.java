/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoav;

import java.util.Random;
import java.util.Scanner;

public class JuegoCartas {
    private Carta[] cartas = {
        new Carta("Fuego", 8),
        new Carta("Hielo", 6),
        new Carta("Agua", 7)
    };

    private Carta[] manoUsuario = new Carta[3];
    private Carta[] manoComputadora = new Carta[3];
    private Random random = new Random();
    private Scanner scanner;

    public JuegoCartas(Scanner scanner) {
        this.scanner = scanner;
    }

    public void jugar() {
        System.out.println("Bienvenido al juego de Fuego, Hielo y Agua");

        for (int i = 0; i < 3; i++) {
            System.out.print("Elige tu carta (Fuego, Hielo o Agua): ");
            String seleccionUsuario = scanner.nextLine();
            manoUsuario[i] = buscarCarta(seleccionUsuario);

            int indexComputadora = random.nextInt(cartas.length);
            manoComputadora[i] = cartas[indexComputadora];

            System.out.println("Computadora elige: " + manoComputadora[i].getNombre());
            System.out.println("Resultado: " + determinarGanador(manoUsuario[i], manoComputadora[i]));
            System.out.println();
        }
    }

    private Carta buscarCarta(String nombre) {
        for (Carta carta : cartas) {
            if (carta.getNombre().equalsIgnoreCase(nombre)) {
                return carta;
            }
        }
        return null;
    }

    private String determinarGanador(Carta cartaUsuario, Carta cartaComputadora) {
        if (cartaUsuario.getNivelPoder() > cartaComputadora.getNivelPoder()) {
            return "Ganaste";
        } else if (cartaUsuario.getNivelPoder() < cartaComputadora.getNivelPoder()) {
            return "Perdiste";
        } else {
            return "Empate";
        }
    }

    private static class Carta {
        private String nombre;
        private int nivelPoder;

        public Carta(String nombre, int nivelPoder) {
            this.nombre = nombre;
            this.nivelPoder = nivelPoder;
        }

        public String getNombre() {
            return nombre;
        }

        public int getNivelPoder() {
            return nivelPoder;
        }
    }
}