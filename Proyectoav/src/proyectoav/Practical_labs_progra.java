/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoav;

import java.util.Scanner;

public class Practical_labs_progra {

    private final Tablero board; // Declaración de la variable board
    private final Scanner scanner;

    public Practical_labs_progra() {
        this.board = new Tablero();
        this.scanner = new Scanner(System.in);
    }

    public void startGame() {
        while (true) {
            board.imprimirTablero();
            System.out.println("Ingresa el movimiento (por ejemplo, 'a2 a4'): ");
            String move = scanner.nextLine();
            if (move.equals("exit")) {
                break;
            }
            if (!isValidInput(move)) {
                System.out.println("Entrada inválida. Por favor, intenta de nuevo.");
                continue;
            }
            int[] coordinates = parseMove(move);
            if (!isValidMoveFormat(coordinates)) {
                System.out.println("Formato de movimiento inválido. Por favor, intenta de nuevo.");
                continue;
            }
            int startX = coordinates[0];
            int startY = coordinates[1];
            int endX = coordinates[2];
            int endY = coordinates[3];
            if (!board.movimientoValido(startX, startY, endX, endY)) {
                System.out.println("Movimiento inválido. Por favor, intenta de nuevo.");
                continue;
            }
            board.moverPieza(startX, startY, endX, endY);
        }
        scanner.close();
    }

    private boolean isValidInput(String input) {
        // Validar el formato de entrada
        return input.matches("[a-h][1-8]\\s[a-h][1-8]");
    }

    private int[] parseMove(String move) {
        int[] coordinates = new int[4];
        coordinates[0] = move.charAt(0) - 'a';
        coordinates[1] = move.charAt(1) - '1';
        coordinates[2] = move.charAt(3) - 'a';
        coordinates[3] = move.charAt(4) - '1';
        return coordinates;
    }

    private boolean isValidMoveFormat(int[] coordinates) {
        // Validar el formato del movimiento
        for (int coordinate : coordinates) {
            if (coordinate < 0 || coordinate >= Tablero.getTamanioTablero()) {
                return false;
            }
        }
        return true;
    }
}
