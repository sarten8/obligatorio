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
    private int cantidadRespuestasApuestas;
    private int cantidadRespuestasNuevaMano;
    private int cantidadManos;
    private int luz;
    private Mazo mazo;
    private Mano mano;
    private ArrayList<Participante> participantes = new ArrayList<>();

    public void setCantidadRespuestas(int cantidadRespuestas) {
        this.cantidadRespuestas = cantidadRespuestas;
    }

    public void setCantidadRespuestasApuestas(int cantidadRespuestasApuestas) {
        this.cantidadRespuestasApuestas = cantidadRespuestasApuestas;
    }

    public void setCantidadRespuestasNuevaMano(int cantidadRespuestasNuevaMano) {
        this.cantidadRespuestasNuevaMano = cantidadRespuestasNuevaMano;
    }
    
    private Date fechaInicio;
    private int pozoTotal = 0;
    private Estado estado = Estado.EnEspera;


    public enum Estado{
                    EnEspera, Activo, Finalizado;
    }
    
    public enum Evento{
        CartasRepartidas, TerminoJuego, HayGanador, HayApuesta, PozoActualizado, PasaronTodos;
    }
    
    public boolean TeminoJuego(){
    
    if(this.obtenerParticipantesActivos().size()==1){
        this.estado=Estado.Finalizado;
        return true;
    }
    return false;
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
        if (this.cantidadRespuestas == 0) {
            this.iniciarMano();
        }
    }

    public void restablecerCantidadRespuestas() throws PokerException{
        this.cantidadRespuestas = obtenerParticipantesActivos().size();
    }
    
    public int getCantidadRespuestasApuestas() {
        return cantidadRespuestasApuestas;
    }

    public void restarCantidadRespuestasApuestas() throws PokerException {
        this.cantidadRespuestasApuestas --;
        if (this.cantidadRespuestasApuestas == 0) {
            this.getMano().acreditarGanador();
            this.avisar(Juego.Evento.HayGanador);
        }
    }

    public void restablecerCantidadRespuestasApuestas() throws PokerException{
        this.cantidadRespuestasApuestas = obtenerParticipantesActivos().size();
    }
    
   public int getCantidadRespuestasNuevaMano() {
        return cantidadRespuestasNuevaMano;
    }
    
    public void restarCantidadRespuestasNuevaMano() throws PokerException{
        this.cantidadRespuestasNuevaMano --;
        if (this.cantidadRespuestasNuevaMano == 0) {
            this.pozoTotal = 0;
            this.iniciarMano();
        }
    }
    
    public void restablecerCantidadRespuestasNuevaMano() throws PokerException{
        this.cantidadRespuestasNuevaMano = obtenerParticipantesActivos().size();
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
        Fachada.getInstancia().avisar(Fachada.Evento.IniciaJuego);
        Fachada.getInstancia().avisar(Fachada.Evento.ListarPartidas);
        this.iniciarMano();
        
    } 
    
    protected void iniciarMano() throws PokerException {
        System.out.println("POZO TOTAL antes de iniciar mano: $"+pozoTotal);
        retirarCartas();
        this.cantidadManos++;
        this.resetParticipantes();
        this.actualizarEstadoParticipantes();
        this.descontarLuz();
        ArrayList<Participante> participantesActivos = this.obtenerParticipantesActivos(); 
        this.restablecerCantidadRespuestas();
        this.restablecerCantidadRespuestasApuestas();
        this.restablecerCantidadRespuestasNuevaMano();
        this.mano = new Mano(this, this.mazo, participantesActivos);
        this.avisar(Evento.PozoActualizado);
        this.avisar(Evento.CartasRepartidas);
        System.out.println("POZO TOTAL despues de iniciar mano: $"+pozoTotal);
    }
    
    
    private void actualizarEstadoParticipantes() {
        for(Participante p: participantes){
            if(p.getJugador().getSaldo() < luz) p.setEstado(Participante.Estado.Inactivo);
            Fachada.getInstancia().avisar(Fachada.Evento.ParticipanteSinSaldo);
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
            if(p.getEstado()==Participante.Estado.Activo){
                p.descontar(luz);
            }
        }
    }
    
    public void quitarParticipanteDeLaMano(Participante p) throws PokerException {
        this.mano.quitarParticipante(p);
        restarCantidadRespuestasApuestas();
    }
    
    public void pasarParticipanteDeLaMano(Participante aThis) {
        if(verificarPasaronTodos()) this.avisar(Evento.PasaronTodos);
    }
    
    private boolean verificarPasaronTodos(){
        ArrayList<Participante> aux = this.obtenerParticipantesActivos();
        for(Participante p: aux){
            if(!p.isPaso()){
                return false;
            }
        }
        return true;
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
    
    private void resetParticipantes() {
        for(Participante p: participantes){
            p.setPaso(false);
            p.setAposto(false);
            p.setApuesta(0);
        }
    }
 
    protected void avisar(Object evento){
        setChanged();
        notifyObservers(evento);
    }
    
    private void retirarCartas(){
        for(Participante p: participantes){
            p.limpiarCartas();
        }
    }
    
        @Override
    public String toString() {
        
        return "Inicio Juego: " + this.fechaInicio + ", jugadores: " + this.participantes.size()+" total apostado:"+this.pozoTotal+" cantidad de manos: "+this.cantidadManos;
    }
}
