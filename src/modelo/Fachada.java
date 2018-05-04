/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Observable;

/**
 *
 * @author sartre
 */
public class Fachada extends Observable{
    SistemaUsuarios su = new SistemaUsuarios();
    SistemaJuego sj = new SistemaJuego();
    
    private static Fachada instancia = new Fachada();
    public static Fachada getInstancia() {
        return instancia;
    }
    
    // El Evento ParticipanteSalio es por si el participante se retira antes de 
    // que el juego haya iniciado. El Participante se quita de Array de participantes
    public enum Evento{
        ParticipanteIngresado, ParticipanteSalio, ParticipanteRetirado, IniciaJuego;
    }

    public SistemaUsuarios getSu() {
        return su;
    }

    public SistemaJuego getSj() {
        return sj;
    }
    
    public Fachada() {
    }
    
    public void avisar(Object evento){
        setChanged();
        notifyObservers(evento);
    }
    
    public Participante loginJugador(String user, String pass) throws PokerException{
        return su.loginJuador(user, pass);
    }

    public Participante ingresarParticipante(Jugador j) throws PokerException{
        return sj.ingresarParticipante(j);
    }
}
