/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoav;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author Javier Reyes
 */
public class Buscaminas {
    private char[][] tablero;
    private boolean[][] minas;
    private int filas;
    private int columnas;
    private int minasRestantes;
    private static final char CASILLA_NO_DESCUBIERTA = '-';
    private static final char MINA = '*';
   
    //private static final char
    //Define una variable privada constante de tipo char que es compartida por
    //todas las instancias de la clase y cuyo valor no puede ser cambiado después de su inicialización.
    
    public Buscaminas(int filas, int columnas, int numMinas) {
        this.filas = filas;
        this.columnas = columnas;
        this.minasRestantes = numMinas;
        this.tablero = new char[filas][columnas];
        this.minas = new boolean[filas][columnas];
        inicializarTablero();
        colocarminas(numMinas);
}
    
    private void inicializarTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = CASILLA_NO_DESCUBIERTA;
            }
        }
    }

    private void colocarminas(int numMinas) {
        Random rand = new Random();
        int minasColocadas = 0;
        while (minasColocadas < numMinas) {
            int fila = rand.nextInt(filas);
            int columna = rand.nextInt(columnas);
            if (!minas[fila][columna]) {
                minas[fila][columna] = true;
                minasColocadas++;
            }
        }
    }

    private void imprimirtablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean estaEnTablero(int fila, int columna) {
        return fila >= 0 && fila < filas && columna >= 0 && columna < columnas;
    }

    private int cminasalrededor(int fila, int columna) { //contar las minas de alrededor
        int contador = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i != 0 || j != 0) {
                    int nuevaFila = fila + i;
                    int nuevaColumna = columna + j;
                    if (estaEnTablero(nuevaFila, nuevaColumna) && minas[nuevaFila][nuevaColumna]) {
                        contador++;
                    }
                }
            }
        }
        return contador;
    }

    private void descubrirCasilla(int fila, int columna) {
        if (!estaEnTablero(fila, columna) || tablero[fila][columna] != CASILLA_NO_DESCUBIERTA) {
            return;
        }

        if (minas[fila][columna]) {
            System.out.println("¡Has perdido!");
            tablero[fila][columna] = MINA;
            imprimirtablero();
            System.exit(0);
        } else {
            int minasAlrededor = cminasalrededor(fila, columna);
            tablero[fila][columna] = (char) (minasAlrededor + '0');

            if (minasAlrededor == 0) {
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        descubrirCasilla(fila + i, columna + j);
                    }
                }
            }
        }
    }

    public void jugar() {
        Scanner ex_mine = new Scanner(System.in); //ex_ mine = mina explosiva

        while (minasRestantes > 0) {
            imprimirtablero();
            System.out.print("Introduce la fila: ");
            int fila = ex_mine.nextInt();
            System.out.print("Introduce la columna: ");
            int columna = ex_mine.nextInt();

            if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas) {
                System.out.println("Posición fuera del tablero.");
                continue;
            }

            if (tablero[fila][columna] != CASILLA_NO_DESCUBIERTA) {
                System.out.println("Casilla ya descubierta.");
                continue;
            }

            descubrirCasilla(fila, columna);
        }

        System.out.println("¡Has ganado!");
    }
}