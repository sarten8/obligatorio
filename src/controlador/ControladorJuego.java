/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.Observable;
import java.util.Observer;
import modelo.Fachada;
import modelo.Juego;
import modelo.Participante;

/**
 *
 * @author sartre
 */
public class ControladorJuego implements Observer{
    private Fachada modelo = Fachada.getInstancia();
    private InterfaceJuego vista;
    private Participante participante;
    
    public ControladorJuego(InterfaceJuego vista, Participante p){
        this.vista = vista;
        this.participante=p;
        modelo.addObserver(this);
        p.getJuego().addObserver(this);
        
        // Se actualiza el mismo la vista cuando ingresa 
        int faltantes = this.participante.getJuego().jugadoresFaltantes();
        
        if (faltantes>=1) {
            vista.mostrarEspera(faltantes);
            vista.actualizarListaParticipantes(this.participante.getJuego().obtenerParticipantesActivos());
        }
        
        if (this.participante.getJuego().getEstado().equals(Juego.Estado.Activo)){
            vista.actualizarListaParticipantes(this.participante.getJuego().obtenerParticipantesActivos());
            vista.iniciarJuego();
            vista.actualizarPozo(this.participante.getJuego().getPozoTotal());
            vista.actualizarSaldo(this.participante.getJugador().getSaldo());
        }
    }

    @Override
    public void update(Observable o, Object evento) {
        int faltantes = this.participante.getJuego().jugadoresFaltantes();
        
        if(evento.equals(Fachada.Evento.ParticipanteIngresado)){
            if (faltantes>=1) {
                vista.mostrarEspera(faltantes);
            }
            vista.actualizarListaParticipantes(this.participante.getJuego().obtenerParticipantesActivos());
        }
        
        if(evento.equals(Fachada.Evento.ParticipanteSalio)){
            if (faltantes>=1) vista.mostrarEspera(faltantes);
            vista.actualizarListaParticipantes(this.participante.getJuego().obtenerParticipantesActivos());
        }
        
        if(evento.equals(Fachada.Evento.ParticipanteRetirado)) 
            vista.actualizarListaParticipantes(this.participante.getJuego().obtenerParticipantesActivos());
        
        if(evento.equals(Fachada.Evento.IniciaJuego)){
            vista.iniciarJuego();
        }
        
        if(evento.equals(Juego.Evento.PozoActualizado)){
            vista.actualizarPozo(this.participante.getJuego().getPozoTotal());
            vista.actualizarSaldo(this.participante.getJugador().getSaldo());
        }
        
        if(evento.equals(Juego.Evento.PasaronTodos)){
            vista.pasaronTodos();
            vista.actualizarSaldo(this.participante.getJugador().getSaldo());
        }
        
        if(evento.equals(Juego.Evento.ParticipanteSinSaldo)){
            if(!this.participante.validarSaldo()) salirDelJuego();
        }
        
        if(evento.equals(Juego.Evento.ActualizarSaldo)){
            vista.actualizarSaldo(this.participante.getJugador().getSaldo());
        }
    }
    
    public void salirDelJuego(){
        this.participante.salirDelJuego();
        modelo.deleteObserver(this);
        this.participante.getJuego().deleteObserver(this);
        vista.salir();
    }

    public void pasar() {
       this.participante.pasar();
       vista.actualizarSaldo(this.participante.getJugador().getSaldo());
    }
    
    public void apostar(int monto){
       try{
           this.participante.apostar(monto);
           vista.actualizarSaldo(this.participante.getJugador().getSaldo());
       }catch(Exception ex){
          vista.mostrarError(ex.getMessage());
       }
    }
}
