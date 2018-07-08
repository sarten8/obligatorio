/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import modelo.Carta;
import modelo.Fachada;
import modelo.Juego;
import modelo.Participante;
import modelo.PokerException;

/**
 *
 * @author sartre
 */
public class ControladorJuego implements Observer{
    private Fachada modelo = Fachada.getInstancia();
    private InterfaceJuego vista;
    private Participante participante;

    public Participante getParticipante() {
        return participante;
    }
    
    public ControladorJuego(InterfaceJuego vista, Participante p){
        this.vista = vista;
        this.participante=p;
        modelo.addObserver(this);
        p.getJuego().addObserver(this);
        
        // Se actualiza el mismo la vista cuando ingresa 
        vista.mostrarNombre(p.getJugador().getNombre());
        
        int faltantes = this.participante.getJuego().jugadoresFaltantes();
        
        if (faltantes>=1) {
            vista.mostrarEspera(faltantes);
            vista.actualizarListaParticipantes(obtenerContrincantes());
        }
        
        if (this.participante.getJuego().getEstado().equals(Juego.Estado.Activo)){
            vista.actualizarListaParticipantes(obtenerContrincantes());
            vista.iniciarJuego();
            vista.actualizarPozo(this.participante.getJuego().getPozoTotal());
            vista.actualizarSaldo(this.participante.getJugador().getSaldo());
            vista.mostrarCartas(participante.getCartas());
            vista.mostrarFigura(this.participante.mostrarFigura());
        }
    }

    @Override
    public void update(Observable o, Object evento) {
        int faltantes = this.participante.getJuego().jugadoresFaltantes();
        
        if(evento.equals(Fachada.Evento.ParticipanteIngresado)){
            if (faltantes>=1) {
                vista.mostrarEspera(faltantes);
            }
            vista.actualizarListaParticipantes(obtenerContrincantes());
        }
        
        if(evento.equals(Fachada.Evento.ParticipanteSalio)){
            if (faltantes>=1) vista.mostrarEspera(faltantes);
            vista.actualizarListaParticipantes(obtenerContrincantes());
        }
        if(evento.equals(Juego.Evento.TerminoJuego)){
            if(this.participante.getEstado()==Participante.Estado.Activo){
                vista.mostrarTerminoJuego(participante.getSaldoGanado());
            }
        }
        
        if(evento.equals(Fachada.Evento.ParticipanteRetirado)) 
            vista.actualizarListaParticipantes(obtenerContrincantes());
        
        if(evento.equals(Fachada.Evento.IniciaJuego)){
            vista.iniciarJuego();
        }
        
        if(evento.equals(Juego.Evento.PozoActualizado)){
            vista.actualizarPozo(this.participante.getJuego().getPozoTotal());
        }
             
        if(evento.equals(Juego.Evento.PasaronTodos)){
            vista.pasaronTodos(this.participante.getJugador().getNombre());
            vista.actualizarSaldo(this.participante.getJugador().getSaldo());
            vista.actualizarPozo(this.participante.getJuego().getPozoTotal());
        }
        
        if(evento.equals(Fachada.Evento.ParticipanteSinSaldo)){
            if(!this.participante.validarSaldo()) salirPorFaltaSaldo();
        }
        
        if(evento.equals(Fachada.Evento.ActualizarSaldo)){
            vista.actualizarSaldo(this.participante.getJugador().getSaldo());
        }
        
        if(evento.equals(Juego.Evento.CartasRepartidas)){
            vista.mostrarCartas(participante.getCartas());
            vista.mostrarFigura(this.participante.mostrarFigura());
            vista.iniciarJuego();
        }
        
        if(evento.equals(Juego.Evento.HayApuesta)){
            if(participante.isAposto()) {
                vista.esperarRespuesta();
                vista.mostrarError("Esperando respuestas");
            }
            else {
                Participante apostador = participante.getJuego().getMano().quienAposto();
                vista.mostrarApuesta(apostador.getJugador().getNombre(), apostador.getApuesta());
            }
        }
        
        if(evento.equals(Juego.Evento.HayGanador)){
            if(participante.equals(participante.getJuego().getMano().getParticipanteGanador())){
                vista.mostrarMensajAlGanador(participante.getJuego().getPozoTotal(), participante.getJuego().getMano().getParticipanteGanador().mostrarFigura());
            }else{
                ArrayList<Carta> cartasGanadoras = participante.getJuego().getMano().getParticipanteGanador().getCartas();
                String ganador = participante.getJuego().getMano().getParticipanteGanador().getJugador().getNombre();
                int ganado = participante.getJuego().getPozoTotal();
                String figura = participante.getJuego().getMano().getParticipanteGanador().mostrarFigura();
                vista.mostrarGanador(ganador, ganado, figura, cartasGanadoras);
            }
            vista.comenzarNuevaMano();
        }
        
        if(evento.equals(Juego.Evento.Contar)){
            if(!participante.isAposto() && !participante.isRespondio()){
                Participante apostador = participante.getJuego().getMano().quienAposto();
                String nom = apostador.getJugador().getNombre();
                int mon = apostador.getApuesta();
                vista.mostrarError(nom + " apostó $ " + mon + " ||| Tiempo de respesta en segundos: " + participante.getJuego().getApuesta().getTiempoMax());
            }
            if(participante.isAposto()){
                vista.mostrarError("Esperando respuesta - faltan: " + participante.getJuego().getApuesta().getTiempoMax() + " segundos");
            }
        }
        
        if(evento.equals(Juego.Evento.FinalizoTiempo)) {
            if(!participante.isAposto() && !participante.isRespondio()){
                try{
                    quitarParticipanteDeLaMano();
                }catch(Exception ex){
                    vista.mostrarError(ex.getMessage());
                }
            }
        }
    }
    
    // metodo auxiliar para pasar los participantes menos el participante mismo.
    private ArrayList<Participante> obtenerContrincantes(){
        ArrayList<Participante> aux = this.participante.getJuego().obtenerParticipantesActivos();
        aux.remove(this.participante);
        return aux;
    }
    
    private void salir() throws PokerException{
        this.participante.salirDelJuego();
        modelo.deleteObserver(this);
        this.participante.getJuego().deleteObserver(this);
    }
    
    private void salirPorFaltaSaldo() {
        try{
            salir();
            vista.salirPorFaltaSaldo(participante.getJugador().getNombre(), participante.getJuego().getLuz());
        }catch(Exception ex){
            vista.mostrarError(ex.getMessage());
        }
    }
    
    public void salirDelJuego(){
        try{
            salir();
            vista.salir();
        }catch(Exception ex){
            vista.mostrarError(ex.getMessage());
        }
    }
    
    public void incrementarRespuesta() {
        try{
            this.participante.getJuego().restarCantidadRespuestas();
        }catch(Exception ex){
            vista.mostrarError(ex.getMessage());
        }   
    }
    
    public void incrementarRespuestaApuestas() {
        try{
            this.participante.getJuego().restarCantidadRespuestasApuestas();
        }catch(Exception ex){
            vista.mostrarError(ex.getMessage());
        }   
    }

    public void pasar() {
       this.participante.pasar();
    }
    
    public void descontarApuesta(int monto){
        this.participante.setRespondio(true);
        incrementarRespuestaApuestas();
        this.participante.descontar(monto);
    }
    
    public void apostar(int monto){
       try{
           this.participante.apostar(monto);
           this.incrementarRespuestaApuestas();
       }catch(Exception ex){
          vista.mostrarError(ex.getMessage());
       }
    }
    
    public void quitarParticipanteDeLaMano() throws PokerException{
        this.participante.setRespondio(true);
        participante.getJuego().quitarParticipanteDeLaMano(participante);
    }

    public void incrementarRespuestaNuevaMano() {
        try{
            this.participante.getJuego().restarCantidadRespuestasNuevaMano();
        }catch(Exception ex){
            vista.mostrarError(ex.getMessage());
        }   
    }
}
