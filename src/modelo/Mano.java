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
    private Participante participanteGanador;
    private Mazo mazo;
    private ArrayList<Participante> participantes = new ArrayList<>();
    
    public Mano(Juego juego, Mazo mazo, ArrayList<Participante> participantes) {
        this.juego = juego;
        this.mazo = mazo;
        this.participantes = participantes;
        this.repartirCartas();
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

    public void acreditarGanador(){
        this.juego.setPozoTotal(0);
        this.participanteGanador.incrementarSaldo(this.juego.getPozoTotal());
    }

    public void quitarParticipante(Participante p) {
        this.participantes.remove(p);
    }
    
    public boolean verificarPasaronTodos(){
        ArrayList<Participante> aux = juego.obtenerParticipantesActivos();
        for(Participante p: aux){
            if(!p.isPaso()){
                return false;
            }
        }
        return true;
    }

    private void repartirCartas(){
        ArrayList<Carta> cartas = mazo.repartir(participantes.size());
        int pos = 0;
        for (Participante p: participantes){
            int top = pos;
            for (int i = pos; i < top+5; i++){
                p.getCartas().add(cartas.get(i));
                pos++;
            }
        }
    }
}
