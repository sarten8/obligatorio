/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
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
        ParticipanteIngresado, ListarPartidas, TerminoJuego,ParticipanteSalio, ParticipanteRetirado, IniciaJuego, ActualizarSaldo, ParticipanteSinSaldo, ActualizarDatos;
    }
    
    public Fachada() {
    }
    
    protected void avisar(Object evento){
        setChanged();
        notifyObservers(evento);
    }
    
    public void AgregarSistemaJuego(SistemaJuego sistemaJuego){
        this.sj = sistemaJuego;
    }
    
    public void AgregarJugador(Jugador j){
        su.agregarJugador(j);
    }
    
    public void AgregarAdministrador(Administrador a){
        su.agregarAdministrador(a);
    }
    
    public void CrearJuego(){
        sj.crearJuego();
    }
    
    public int Verluz() {
       return sj.getLuz();
    }
    
    public int VerMaximo() {
       return sj.getMaxJugadores();
    }

    public void actualizarMaximoJugadores(int max) throws PokerException  {
        sj.actualziarMaxJugadores(max);
    }

    public void actualizarLuz(int luz)  throws PokerException {
        sj.actualziarLuz(luz);
    }
    
    public ArrayList<Juego> actualizarPartidas() {
        return  sj.JuegosActivos();
    }
    
    
    public Administrador loginAdmin(String user, String pass) throws PokerException {
       return  su.loginAdmin(user,pass);
    }
    
    public Juego ObtenerjuegoEnEspera(){
        return sj.obtenerJuegoEnEspera();
    }
    
    public Participante loginJugador(String user, String pass) throws PokerException{
        return su.loginJuador(user, pass);
    }

    public Participante ingresarParticipante(Jugador j) throws PokerException{
        return sj.ingresarParticipante(j);
    }
}
