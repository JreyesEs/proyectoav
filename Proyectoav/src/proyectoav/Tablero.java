/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoav;


public class Tablero {
    
    private static final int TAMAN0_TABLERO = 8;
    private char[][] tablero;

    public Tablero() {
        tablero = new char[TAMAN0_TABLERO][TAMAN0_TABLERO];
        inicializarTablero();
    }
    
    private void inicializarTablero() {
        for (int i = 0; i < TAMAN0_TABLERO; i++) {
            for (int j = 0; j < TAMAN0_TABLERO; j++) {
                tablero[i][j] = ' ';
            }
        }

        // Colocar peones
        for (int i = 0; i < TAMAN0_TABLERO; i++) {
            tablero[1][i] = 'P';
            tablero[6][i] = 'p';
        }

        // Colocar torres, caballos, alfiles y reina
        tablero[0][0] = 'T';
        tablero[0][1] = 'C';
        tablero[0][2] = 'A';
        tablero[0][3] = 'D';
        tablero[0][4] = 'R';
        tablero[0][5] = 'A';
        tablero[0][6] = 'C';
        tablero[0][7] = 'T';

        // Colocar torres, caballos, alfiles y reina para el otro jugador
        tablero[7][0] = 't';
        tablero[7][1] = 'c';
        tablero[7][2] = 'a';
        tablero[7][3] = 'd';
        tablero[7][4] = 'r';
        tablero[7][5] = 'a';
        tablero[7][6] = 'c';
        tablero[7][7] = 't';
    }

    public void imprimirTablero() {
        for (int i = 0; i < TAMAN0_TABLERO; i++) {
            for (int j = 0; j < TAMAN0_TABLERO; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean movimientoValido(int x, int y, int finX, int finY) {
        return (x >= 0 && x < TAMAN0_TABLERO && y >= 0 && y < TAMAN0_TABLERO
                && finX >= 0 && finX < TAMAN0_TABLERO && finY >= 0 && finY < TAMAN0_TABLERO);
    }

    public void moverPieza(int x, int y, int finX, int finY) {
        if (movimientoValido(x, y, finX, finY)) {
            char pieza = tablero[x][y];
            tablero[x][y] = ' ';
            tablero[finX][finY] = pieza;
        } else {
            System.out.println("Movimiento inválido.");
        }
    }
    
    public static int getTamanioTablero() {
        return TAMAN0_TABLERO;
    }
}

