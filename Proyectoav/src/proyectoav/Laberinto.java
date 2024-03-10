/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoav;
import java.util.Scanner;
/**
 *
 * @author Javier Reyes
 */
public class Laberinto {
    private char[][] mapa;
    private int jugadorX;
    private int jugadorY;

    public Laberinto() {
        // Definir el mapa del laberinto
        this.mapa = new char[][] {
                {'#', '#', '#', '#', '#', '#', '#', '#', '#'},
                {'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#'},
                {'#', ' ', '#', '#', '#', '#', '#', ' ', '#'},
                {'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#'},
                {'#', '#', '#', ' ', '#', ' ', '#', '#', '#'},
                {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
                {'#', ' ', '#', '#', '#', '#', '#', '#', '#'},
                {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
                {'#', '#', '#', '#', '#', '#', '#', '#', '#'}
        };

        // Posición inicial del jugador
        this.jugadorX = 1;
        this.jugadorY = 1;
    }
    
    public void jugar() {
        Scanner lab = new Scanner(System.in);
        boolean haGanado = false;

        while (!haGanado) {
            dmapa();

            // Comprobar si el jugador ha llegado a la salida
            if (jugadorX == 7 && jugadorY == 7) {
                System.out.println("¡Has ganado!");
                haGanado = true;
                break;
            }

            // Movimiento del jugador
            System.out.print("Introduce tu movimiento (WASD): ");
            String movimiento = lab.next();

            switch (movimiento.toLowerCase()) {
                case "w":
                    if (mapa[jugadorY - 1][jugadorX] != '#') {
                        jugadorY--;
                    }
                    break;
                case "a":
                    if (mapa[jugadorY][jugadorX - 1] != '#') {
                        jugadorX--;
                    }
                    break;
                case "s":
                    if (mapa[jugadorY + 1][jugadorX] != '#') {
                        jugadorY++;
                    }
                    break;
                case "d":
                    if (mapa[jugadorY][jugadorX + 1] != '#') {
                        jugadorX++;
                    }
                    break;
                default:
                    System.out.println("Movimiento no válido.");
            }
        }
    }

    private void dmapa() {
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                if (i == jugadorY && j == jugadorX) {
                    System.out.print('P'); // Jugador
                } else {
                    System.out.print(mapa[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println(); 
    }
}