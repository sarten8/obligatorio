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
public class Mano {
    private Juego juego;
    private int pozo = 0;
    private Participante participanteGanador;
    private Mazo mazo;
    private ArrayList<Participante> participantes = new ArrayList<>();
    
    public Mano(Juego juego, Mazo mazo, ArrayList<Participante> participantes, int pozoParcial) {
        this.juego = juego;
        this.mazo = mazo;
        this.participantes = participantes;
        this.pozo = pozoParcial;
    }

    public int getPozo() {
        return pozo;
    }

    public void setPozo(int pozo) {
        this.pozo = pozo;
    }

    public Participante getParticipanteGanador() {
        return participanteGanador;
    }

    public void setParticipanteGanador(Participante participanteGanador) {
        this.participanteGanador = participanteGanador;
    }

    public Mazo getMazo() {
        return mazo;
    }

    public void setMazo(Mazo mazo) {
        this.mazo = mazo;
    }

    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(ArrayList<Participante> participantes) {
        this.participantes = participantes;
    }
    
    public void pasaronTodos(){
        this.juego.setPozoParcial(pozo);
    }

    public void acreditarGanador(){
        this.juego.setPozoParcial(0);
        this.participanteGanador.incrementarSaldo(pozo);
    }
    
}
