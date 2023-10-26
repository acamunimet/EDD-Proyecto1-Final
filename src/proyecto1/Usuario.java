/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

/**
 *
 * @author User
 */
public class Usuario {
    public String nombre; 
    public Usuario sig; 
    public int numero;

    public Usuario(String nombre, int num) {
        this.nombre = nombre;
        this.sig = null;
        this.numero = num;
    }
}
