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
public class SistemaJuego {
    private ArrayList<Juego> juegos = new ArrayList<>();
    private Mazo mazo;
    private int maxJugadores;
    private int luz;

    public ArrayList<Juego> getJuegos() {
        return juegos;
    }

    public void setJuegos(ArrayList<Juego> juegos) {
        this.juegos = juegos;
    }

    public Mazo getMazo() {
        return mazo;
    }

    public void setMazo(Mazo mazo) {
        this.mazo = mazo;
    }

    public int getMaxJugadores() {
        return maxJugadores;
    }

    public void setMaxJugadores(int maxJugadores) {
        this.maxJugadores = maxJugadores;
    }

    public int getLuz() {
        return luz;
    }

    public void setLuz(int luz) {
        this.luz = luz;
    }
    
    public SistemaJuego(Mazo mazo, int maxJugadores, int luz) {
        this.mazo = mazo;
        this.maxJugadores = maxJugadores;
        this.luz = luz;
    }
        
    public SistemaJuego(){}
        
    public void actualizarLuz(int luz) {
        this.luz = luz;
    }

    public void crearJuego() {

    }

    public static boolean validarLuz(int luz) {
        return (luz > 0);
    }

    public static boolean validarMaxJuagadores(int max) {
        return (max >= 2 && max <= 5);
    }

    public Participante ingresarParticipante(Jugador j) throws PokerException{
        if(juegos.size() <= 0) throw new PokerException("Aún no existe ningún juego");
        return juegos.get(juegos.size() - 1).ingresarParticipante(j);
    }
}
