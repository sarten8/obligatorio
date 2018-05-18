/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author sartre
 */
public class Mazo {
    private ArrayList<Carta> cartas = new ArrayList<>();

    public ArrayList<Carta> getCartas() {
        return cartas;
    }
    
    public Mazo() {
    }
    
    private ArrayList<Carta> barajar(){
        ArrayList<Carta> aux = cartas;
        Collections.shuffle(aux);
        return aux;
    }
    
    public ArrayList<Carta> repartir(int cantidadJugadores){
        ArrayList<Carta> aux = new ArrayList<>();
        ArrayList<Carta> cartasBarajadas = barajar();
        int cantidad = cantidadJugadores * 5;
        for( int i = 0; i < cantidad; i++){
            aux.add(cartasBarajadas.get(i));
        }
        return aux;
    }
    
    public void agregarCarta(Carta c)
    {
        cartas.add(c);
    }
}
