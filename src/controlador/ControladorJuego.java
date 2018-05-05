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

/**
 *
 * @author sartre
 */
public class ControladorJuego implements Observer{
    private Fachada modelo = Fachada.getInstancia();
    private InterfaceJuego vista;
    
    public ControladorJuego(InterfaceJuego vista){
        this.vista = vista;
        modelo.addObserver(this);
    }

    @Override
    public void update(Observable o, Object evento) {
        Juego juegoEnEspera = modelo.getSj().getJuegos().get(modelo.getSj().getJuegos().size()-1);

        if(evento.equals(Fachada.Evento.ParticipanteIngresado) || evento.equals(Fachada.Evento.ParticipanteSalio)){
            int faltantes = juegoEnEspera.getMaxJugadores() - juegoEnEspera.getParticipantes().size();
            vista.mostrarEspera(faltantes);
            vista.actualizarListaParticipantes(juegoEnEspera.obtenerParticipantesActivos());
        }
        
        if(evento.equals(Fachada.Evento.ParticipanteRetirado)) 
            vista.actualizarListaParticipantes(juegoEnEspera.obtenerParticipantesActivos());
        
        if(evento.equals(Fachada.Evento.IniciaJuego)){
            vista.iniciarJuego();
            vista.actualizarListaParticipantes(juegoEnEspera.obtenerParticipantesActivos());
        }   
    }
}
