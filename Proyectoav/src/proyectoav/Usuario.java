/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoav;

/**
 *
 * @author Javier Reyes
 */
public class Usuario {
    private String correo;
    private String contrasena;
    private String apodo;
    private int numeroAleatorio;

    public Usuario(String correo, String contrasena, String apodo, int numeroAleatorio) {
        this.correo = correo;
        this.contrasena = contrasena;
        this.apodo = apodo;
        this.numeroAleatorio = numeroAleatorio;
    }

    @Override
    public String toString() {
        return "Correo: " + correo + "\nContraseña: " + contrasena + "\nApodo: " + apodo +
                "\nNúmero Aleatorio: " + numeroAleatorio;
    }
}
