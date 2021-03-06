/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import persistencia.MapeadorJugador;
import persistencia.Persistencia;

/**
 *
 * @author sartre
 */
public class Participante {
    private Jugador jugador;
    private Juego juego;
    private ArrayList<Carta> cartas = new ArrayList<>();
    private Figura figura;
    private int saldoInicial;
    private int saldoApostado = 0;
    private int saldoGanado = 0;
    private boolean paso = false;
    private boolean aposto = false;
    private boolean respondio = false;
    private int apuesta = 0;
    private Estado estado; 
    public enum Estado{
        Activo, Inactivo;
    }

    public boolean isRespondio() {
        return respondio;
    }

    public void setRespondio(boolean respondio) {
        this.respondio = respondio;
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
    
    public Figura getFigura(){
        return figura;
    }
    
    public void setFigura(Figura iFigura){
        this.figura = iFigura;
    }
    
    //Auxiliar
    public String mostrarFigura(){
        if(figura == null){
            return "Sin figura";
        }else{
            return figura.getNombre();
        }
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
    
    public Participante(){}

    public Participante(Jugador jugador, Juego juego, int saldoInicial) {
        this.jugador = jugador;
        this.juego = juego;
        this.saldoInicial = saldoInicial;
        this.estado = Estado.Activo;
    }
    
    public void descontar(int monto){
        this.jugador.descontarSaldo(monto);
        this.actualizaSaldoPersistencia();
        this.saldoApostado += monto;
        this.juego.incrementarPozo(monto);
        this.juego.setTotalApostado(monto);
        // Utilizo en fachada este evento para actualizar en otros juegos que el jugador este y se le actualice el saldo
        Fachada.getInstancia().avisar(Fachada.Evento.ActualizarSaldo);
    }

    public void apostar(int monto) throws PokerException{
        this.validarApuesta(monto);
        descontar(monto);
        this.juego.crearApuesta();
        aposto = true;
        apuesta = monto;
        this.juego.avisar(Juego.Evento.HayApuesta);
    }
    
    
    public void incrementarSaldo(int monto) {
        this.jugador.incrementarSaldo(monto);
        this.actualizaSaldoPersistencia();
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
            
            if(juego.getApuesta() == null){
                this.juego.setCantidadRespuestasApuestas(juego.obtenerParticipantesActivos().size());
                //this.juego.setCantidadRespuestas(juego.obtenerParticipantesActivos().size());
                //this.juego.setCantidadRespuestasNuevaMano(juego.obtenerParticipantesActivos().size());
            }else{
                this.juego.restarCantidadRespuestasApuestas();
            }
            
            if(this.juego.getMano().getParticipanteGanador() != null){
                this.juego.restarCantidadRespuestasNuevaMano();
            }
            
            this.juego.pasarParticipanteDeLaMano();
            
            
            if(juego.TeminoJuego()){
               
            juego.avisar(Juego.Evento.TerminoJuego);
            
            Fachada.getInstancia().avisar(Fachada.Evento.ListarPartidas);
            Fachada.getInstancia().avisar(Fachada.Evento.TerminoJuego);
            }  
        }
    }
    
    public boolean validarSaldo(){
        return (this.getJugador().getSaldo() >= this.juego.getLuz() + 1);
    }
    
    public void pasar(){
        this.paso = true;
        this.juego.pasarParticipanteDeLaMano();
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
    
    @Override
    public String toString(){
        return jugador.toString();
    }
    
    public void pedirFigura() {
        this.figura = Fachada.getInstancia().obtenerFigura(cartas);
    }
    
    public int valorFigura() {
        if (figura != null) {
            return figura.getValor();
        }
        return 0;
    }
    
    public boolean soyGanador(ArrayList<Carta> cartas1, ArrayList<Carta> cartas2){
        return figura.soyGanador(cartas1, cartas2);
    }
    
    public void actualizaSaldoPersistencia(){
        Persistencia.getInstancia().guardar(new MapeadorJugador(this.jugador));
    }
}
