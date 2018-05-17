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
    private int cantidadRespuestas;

    private int luz;
    private Mazo mazo;
    private Mano mano;
    private ArrayList<Participante> participantes = new ArrayList<>();
    
    private Date fechaInicio;
    private int pozoTotal = 0;
    private int pozoParcial = 0;
    private Estado estado = Estado.EnEspera;

    public enum Estado{
                    EnEspera, Activo, Finalizado;
    }
    
    public enum Evento{
        HayGanador, HayApuesta, PozoActualizado, PasaronTodos, ParticipanteSinSaldo;
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
    public int getCantidadRespuestas() {
        return cantidadRespuestas;
    }

    public void restarCantidadRespuestas() throws PokerException {
        this.cantidadRespuestas --;
        if (this.cantidadRespuestas == 0) this.iniciarMano();
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
  
    public Mano getMano() {
        return mano;
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

    public void iniciar() throws PokerException {
        this.estado = Estado.Activo;
        this.fechaInicio = new Date();
        // Iniciamos el juego con la primer mano
        this.pozoTotal = maxJugadores * luz;
        Fachada.getInstancia().avisar(Fachada.Evento.IniciaJuego);
        this.iniciarMano();
        
    } 
    
    protected void iniciarMano() throws PokerException {
        this.pozoTotal += this.pozoParcial;
        this.actualizarPasaronParticipantes();
        this.actualizarEstadoParticipantes();
        this.descontarLuz();
        ArrayList<Participante> participantesActivos = this.obtenerParticipantesActivos(); 
        this.cantidadRespuestas = participantesActivos.size();
        this.mano = new Mano(this, this.mazo, participantesActivos);
        this.pozoParcial = 0;
        this.avisar(Evento.PozoActualizado);
    }
    
    
    private void actualizarEstadoParticipantes() {
        for(Participante p: participantes){
            if(p.getJugador().getSaldo() < luz) p.setEstado(Participante.Estado.Inactivo);
            this.avisar(Evento.ParticipanteSinSaldo);
        }
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
      
    private void descontarLuz() throws PokerException {
        // Se les quita al valor de la luz a cada jugador
        for(Participante p: participantes){
            if(p.getEstado()==Participante.Estado.Activo) p.descontar(luz);
        }
    }
    
    public void quitarParticipanteDeLaMano(Participante p) {
        this.mano.quitarParticipante(p);
        if (this.mano.verificarPasaronTodos()){
            this.pozoParcial = pozoTotal;
            
            this.avisar(Evento.PasaronTodos);
        }
    }
    
    public int apuestaMaxima(){
        int minimo = Integer.MAX_VALUE;
        for(Participante p: participantes){
            if(p.getEstado().equals(Participante.Estado.Activo) && p.getJugador().getSaldo() <= minimo) minimo = p.getJugador().getSaldo();
        }
        return minimo;
    }
    
    public void incrementarPozo(int monto){
        this.pozoTotal += monto;
        avisar(Evento.PozoActualizado);
    }
    
    private void actualizarPasaronParticipantes() {
        for(Participante p: participantes){
            p.setPaso(false);
        }
    }
    
    protected void avisar(Object evento){
        setChanged();
        notifyObservers(evento);
    }
}
