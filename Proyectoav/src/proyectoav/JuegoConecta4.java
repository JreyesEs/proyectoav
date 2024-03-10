/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoav;

/**
 *
 * @author Javier Reyes
 */
public class JuegoConecta4 {
    private final int FILAS = 6;
    private final int COLUMNAS = 7;
    private final char VACIO = '-';
    private char[][] tablero;
    private char jugadorActual;
    private boolean terminado;

    public JuegoConecta4() {
        tablero = new char[FILAS][COLUMNAS];
        jugadorActual = 'X'; // Empieza el jugador 'X'
        terminado = false;

        // Inicializar tablero
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tablero[i][j] = VACIO;
            }
        }
    }

    public void mostrarTablero() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("1 2 3 4 5 6 7");
    }

    public boolean validarMovimiento(int columna) {
        return columna >= 0 && columna < COLUMNAS && tablero[0][columna] == VACIO;
    }

    public void realizarMovimiento(int columna) {
        for (int i = FILAS - 1; i >= 0; i--) {
            if (tablero[i][columna] == VACIO) {
                tablero[i][columna] = jugadorActual;
                break;
            }
        }
        cambiarJugador();
        if (validarVictoria()) {
            terminado = true;
        } else if (tableroLleno()) {
            terminado = true;
        }
    }

    private void cambiarJugador() {
        jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
    }

    public boolean terminado() {
        return terminado;
    }

    public char getJugadorActual() {
        return jugadorActual;
    }

    private boolean validarVictoria() {
        return horizontal() || vertical() || diagonalPrincipal() || diagonalSecundaria();
    }

    private boolean horizontal() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j <= COLUMNAS - 4; j++) {
                if (tablero[i][j] == jugadorActual
                        && tablero[i][j] == tablero[i][j + 1]
                        && tablero[i][j] == tablero[i][j + 2]
                        && tablero[i][j] == tablero[i][j + 3]) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean vertical() {
        for (int i = 0; i <= FILAS - 4; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (tablero[i][j] == jugadorActual
                        && tablero[i][j] == tablero[i + 1][j]
                        && tablero[i][j] == tablero[i + 2][j]
                        && tablero[i][j] == tablero[i + 3][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean diagonalPrincipal() {
        for (int i = 0; i <= FILAS - 4; i++) {
            for (int j = 0; j <= COLUMNAS - 4; j++) {
                if (tablero[i][j] == jugadorActual
                        && tablero[i][j] == tablero[i + 1][j + 1]
                        && tablero[i][j] == tablero[i + 2][j + 2]
                        && tablero[i][j] == tablero[i + 3][j + 3]) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean diagonalSecundaria() {
        for (int i = 0; i <= FILAS - 4; i++) {
            for (int j = 3; j < COLUMNAS; j++) {
                if (tablero[i][j] == jugadorActual
                        && tablero[i][j] == tablero[i + 1][j - 1]
                        && tablero[i][j] == tablero[i + 2][j - 2]
                        && tablero[i][j] == tablero[i + 3][j - 3]) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean tableroLleno() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (tablero[i][j] == VACIO) {
                    return false;
                }
            }
        }
        return true;
    }

    public Character ganador() {
        if (validarVictoria()) {
            return jugadorActual;
        } else {
            return null;
        }
    }
}
