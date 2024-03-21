/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoav;

public class PiezaAjedrez {
    private char simbolo;

    public PiezaAjedrez(char simbolo) {
        this.simbolo = simbolo;
    }

    public char obtenerSimbolo() {
        return simbolo;
    }

    public void establecerSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }
    
}
