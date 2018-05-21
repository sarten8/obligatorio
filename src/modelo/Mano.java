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
        buscarGanador();
        this.participanteGanador.incrementarSaldo(this.juego.getPozoTotal());
        //this.juego.avisar(Juego.Evento.HayGanador);
        //this.juego.setPozoTotal(0);
    }
    
    private void buscarGanador(){
        if(participantes.size() == 1) this.participanteGanador = participantes.get(0);
        else{
            Participante p_aux = participantes.get(0);
            for(Participante p: participantes){
                if(p.mejorCarta().getNumero() > p_aux.mejorCarta().getNumero()){
                    p_aux = p;
                }
                else if(p.mejorCarta().getNumero() == p_aux.mejorCarta().getNumero()){
                    if(p.mejorCarta().getPalo().getValor() > p_aux.mejorCarta().getPalo().getValor()){
                        p_aux = p;
                    }
                }
            }
            this.participanteGanador = p_aux;
        }
    }

    public void quitarParticipante(Participante p) {
        this.participantes.remove(p);
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
    
    public Participante quienAposto(){
        for(Participante p: participantes){
            if(p.isAposto()) return p;
        }
        return null;
    }
}
