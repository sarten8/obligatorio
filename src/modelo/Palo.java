/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author sartre
 */
public class Palo {
    private String nombre;
    private int valor;

    public Palo(String nombre, int valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
    
    
}
