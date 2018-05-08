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
        
        // Se actualiza el mismo la vista cuando ingresa 
        int faltantes = this.participante.getJuego().jugadoresFaltantes();
        if (faltantes>=1) {
            vista.mostrarEspera(faltantes);
            vista.actualizarListaParticipantes(this.participante.getJuego().obtenerParticipantesActivos());
        }
        System.out.println(this.participante.getJuego().getEstado());
        if (this.participante.getJuego().getEstado().equals(Juego.Estado.Activo)){
            vista.iniciarJuego();
        }
    }

    @Override
    public void update(Observable o, Object evento) {
        int faltantes = this.participante.getJuego().jugadoresFaltantes();
        
        if(evento.equals(Fachada.Evento.ParticipanteIngresado)){
            if (faltantes>=1) {
                vista.mostrarEspera(faltantes);
                vista.actualizarListaParticipantes(this.participante.getJuego().obtenerParticipantesActivos());
            }
        }
        
        if(evento.equals(Fachada.Evento.ParticipanteSalio)){
            if (faltantes>=1) vista.mostrarEspera(faltantes);
            vista.actualizarListaParticipantes(this.participante.getJuego().obtenerParticipantesActivos());
        }
        
        if(evento.equals(Fachada.Evento.ParticipanteRetirado)) 
            vista.actualizarListaParticipantes(this.participante.getJuego().obtenerParticipantesActivos());
        
        if(evento.equals(Fachada.Evento.IniciaJuego)){
            vista.iniciarJuego();
            modelo.CrearJuego();
        }   
    }
}
