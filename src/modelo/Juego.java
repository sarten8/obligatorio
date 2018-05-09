/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;

/**
 *
 * @author sartre
 */
public class Juego extends Observable{
    private int maxJugadores;
    private int luz;
    private Mazo mazo;
    private ArrayList<Mano> manos = new ArrayList<>();
    private ArrayList<Participante> participantes = new ArrayList<>();
    
    private Date fechaInicio;
    private int pozoTotal = 0;
    private int pozoParcial = 0;
    private Estado estado = Estado.EnEspera;
    public enum Estado{
                    EnEspera, Activo, Finalizado;
    }
    
    public enum Evento{
        PasaronTodos;
    }
    
    public Juego(int maxJugadores, int luz, Mazo mazo){
        this.maxJugadores = maxJugadores;
        this.luz = luz;
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

    public void setMazo(Mazo mazo) {
        this.mazo = mazo;
    }

    public Mazo getMazo() {
        return mazo;
    }
  
    public ArrayList<Mano> getManos() {
        return manos;
    }

    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public int getPozoTotal() {
        return pozoTotal;
    }

    public void setPozoTotal(int pozoTotal) {
        this.pozoTotal = pozoTotal;
    }

    public int getPozoParcial() {
        return pozoParcial;
    }

    public void setPozoParcial(int pozoParcial) {
        this.pozoParcial = pozoParcial;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    // -------------------------------------------------------------------------
    // -------------------------------------------------------------------------
    
    public int jugadoresFaltantes() {
        return this.maxJugadores - participantes.size();
    }

    public void iniciar() {
        this.estado = Estado.Activo;
        this.fechaInicio = new Date();
        // Iniciamos el juego con la primer mano
        this.pozoParcial = maxJugadores * luz;
        Fachada.getInstancia().avisar(Fachada.Evento.IniciaJuego);
        this.iniciarMano();
        
    } 
    
    private void iniciarMano() {
        ArrayList<Participante> participantesActivos = obtenerParticipantesActivos();
        this.descontarLuz();
        this.pozoParcial += participantesActivos.size() * luz;
        Mano m = new Mano(this, this.mazo, participantesActivos, this.pozoParcial);
        this.manos.add(m);
        this.pozoParcial = 0;
        this.actualizarPozo(participantesActivos.size()*luz);
        Fachada.getInstancia().avisar(Fachada.Evento.ActualizarPozo);
    }
    
    public ArrayList<Participante> obtenerParticipantesActivos(){
        ArrayList<Participante> aux = new ArrayList<>();
        for(Participante p: participantes){
            if(p.getEstado().equals(Participante.Estado.Activo)) aux.add(p);
        }
        return aux;
    }
    
    public Participante ingresarParticipante(Jugador j) throws PokerException{
        if(buscarJugadorEnParticipantes(j)) throw new PokerException(j.getNombre() + " se encuentra para el próximo juego");
        if(j.getSaldo() < luz*maxJugadores) throw new PokerException("Saldo insuficiente para este juego");
        Participante p = new Participante(j, this, j.getSaldo());
        participantes.add(p);

        Fachada.getInstancia().avisar(Fachada.Evento.ParticipanteIngresado);
        if(participantes.size() == maxJugadores) iniciar();
       
        return p; 
    }
    
    private boolean buscarJugadorEnParticipantes(Jugador j){
        for(Participante p: participantes){
            if(p.getJugador() == j) return true;
        }
        return false;
    }
      
    private void descontarLuz() {
        // Se les quita al valor de la luz a cada jugador
        for(Participante p: participantes){
            p.apostar(luz);
        }
    }
    
    private void actualizarPozo(int monto){
        this.pozoTotal += monto;        
    }
    
    public int pozoActual() {
        return this.manos.get(manos.size()-1).getPozo();
    }
    
    protected void avisar(Object evento){
        setChanged();
        notifyObservers(evento);
    }
}
