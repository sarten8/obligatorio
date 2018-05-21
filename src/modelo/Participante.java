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
public class Participante {
    private Jugador jugador;
    private Juego juego;
    private ArrayList<Carta> cartas = new ArrayList<>();
    private int saldoInicial;
    private int saldoApostado = 0;
    private int saldoGanado = 0;
    private boolean paso = false;
    private boolean aposto = false;
    private int apuesta = 0;
    private Estado estado;
    public enum Estado{
        Activo, Inactivo;
    }

    public void setPaso(boolean paso) {
        this.paso = paso;
    }

    public boolean isPaso() {
        return paso;
    }
    
    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    public int getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(int saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public int getSaldoApostado() {
        return saldoApostado;
    }

    public void setSaldoApostado(int saldoApostado) {
        this.saldoApostado = saldoApostado;
    }

    public int getSaldoGanado() {
        return saldoGanado;
    }

    public void setSaldoGanado(int saldoGanado) {
        this.saldoGanado = saldoGanado;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public boolean isAposto() {
        return aposto;
    }

    public void setAposto(boolean aposto) {
        this.aposto = aposto;
    }

    public int getApuesta() {
        return apuesta;
    }

    public void setApuesta(int apuesta) {
        this.apuesta = apuesta;
    }
    

    public Participante(Jugador jugador, Juego juego, int saldoInicial) {
        this.jugador = jugador;
        this.juego = juego;
        this.saldoInicial = saldoInicial;
        this.estado = Estado.Activo;
    }
    
    public void descontar(int monto){
        this.jugador.descontarSaldo(monto);
        this.saldoApostado += monto;
        this.juego.incrementarPozo(monto);
        // Utilizo en fachada este evento para actualizar en otros juegos que el jugador este y se le actualice el saldo
        Fachada.getInstancia().avisar(Fachada.Evento.ActualizarSaldo);
    }

    public void apostar(int monto) throws PokerException{
            this.validarApuesta(monto);
            descontar(monto);
            aposto = true;
            apuesta = monto;
            this.juego.avisar(Juego.Evento.HayApuesta);
            Fachada.getInstancia().avisar(Fachada.Evento.ActualizarSaldo);
    }
    
    public void incrementarSaldo(int monto) {
        this.jugador.incrementarSaldo(monto);
        this.saldoGanado += monto;
        Fachada.getInstancia().avisar(Fachada.Evento.ActualizarSaldo);
    }
    
    private void validarApuesta(int monto) throws PokerException{
        if(monto <= 0) throw new PokerException("La apuesta debe ser entero mayor a cero");
        
        if (this.jugador.getSaldo() < monto) throw new PokerException("Saldo insuficiente"); 
        
        int apuestaMaxima = this.juego.apuestaMaxima();
        if (apuestaMaxima < monto) throw new PokerException("La apuesta sobrepasa el máximo permitido. Debe de apostar menor o igual a " + apuestaMaxima);
    }
    
    public void salirDelJuego() throws PokerException {
        if(this.juego.getEstado()== Juego.Estado.EnEspera) {
            this.juego.getParticipantes().remove(this);
            Fachada.getInstancia().avisar(Fachada.Evento.ParticipanteSalio);
        }
        else{
            
            this.estado = Estado.Inactivo;          
            Fachada.getInstancia().avisar(Fachada.Evento.ParticipanteRetirado);
            if(juego.TeminoJuego()){
            juego.avisar(Juego.Evento.TerminoJuego);
            Fachada.getInstancia().avisar(Fachada.Evento.ListarPartidas);
            }
            
        }
    }
    
    public boolean validarSaldo(){
        return (this.getJugador().getSaldo() >= this.juego.getLuz());
    }
    
    public void pasar(){
        this.paso = true;
        this.getJuego().pasarParticipanteDeLaMano(this);
    }
    
  @Override
    public String toString() {
        //return this.jugador.toString()+" -total apostado:"+this.saldoApostado+" saldo iniical:"+this.saldoInicial+" total ganado:"+this.saldoGanado;
        return jugador.toString();
    }
    
    public void limpiarCartas(){
        this.cartas.clear();
    }
    
    public Carta mejorCarta(){
        Carta aux = new Carta(1, null, "");
        for (Carta c: cartas){
            if(c.getNumero() > aux.getNumero()){
                aux = c;
            }
            else if(c.getNumero() == aux.getNumero()){
                if(c.getPalo().getValor() > aux.getPalo().getValor()){
                    aux = c;
                }
            }
        }
        return aux;
    }
}
