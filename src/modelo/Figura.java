/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author sartre
 */
public abstract class Figura{
    
    private String nombre;
    private int valor;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Figura(String nombre, int valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public abstract boolean soyFigura(ArrayList<Carta> cartas);
    public abstract boolean soyGanador(ArrayList<Carta> cartas1, ArrayList<Carta> cartas2);
    
}
