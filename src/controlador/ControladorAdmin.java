/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import modelo.Administrador;
import modelo.Fachada;
import modelo.Juego;
import modelo.PokerException;

/**
 *
 * @author sartre
 */
public class ControladorAdmin implements Observer{
    private Fachada modelo = Fachada.getInstancia();
    private InterfaceAdmin vista;
    
    public ControladorAdmin(InterfaceAdmin vista,Administrador a){
        this.vista = vista;
        modelo.addObserver(this);
        vista.mostrarNombre(a.getNombre());
    }

    @Override
    public void update(Observable o, Object evento) {
        
        if(evento.equals(Fachada.Evento.ActualizarSaldo)){
            vista.mostrarListaJuegos(this.modelo.actualizarPartidas());
        }
        
        if(evento.equals(Fachada.Evento.ListarPartidas)){
            vista.mostrarListaJuegos(this.modelo.actualizarPartidas());
        }
      
        if(evento.equals(Fachada.Evento.TerminoJuego)){
            vista.BorrarParticipantes(); 
        }
         
          if(evento.equals(Fachada.Evento.ActualizarDatos)){
            vista.mostrarMaxJugadores(modelo.VerMaximo());
            vista.mostrarLuz(modelo.Verluz());
          }
    }

    public void ActualizarDatos() {
        int luz = modelo.Verluz();
        int maxjugadores = modelo.VerMaximo();
        vista.mostrarLuz(luz);
        vista.mostrarMaxJugadores(maxjugadores);
        vista.mostrarListaJuegos(this.modelo.actualizarPartidas());
    }

    public void actualizarMaximoJugadores(int max) {
        try{
            modelo.actualizarMaximoJugadores(max);
            vista.mostrarMaxJugadores(max);
            vista.mostrarmensaje("El maximo jugadores se actualizo corectamente");
        }catch(PokerException ex){
            vista.mostrarmensaje(ex.getMessage());
        }
    }

    public void actualizarLuz(int luz) {
        try{
            modelo.actualizarLuz(luz);
            vista.mostrarLuz(luz);
            vista.mostrarmensaje("La luz se actualizo corectamente");
        }catch(PokerException ex){
            vista.mostrarmensaje(ex.getMessage());
        }
    }

    public void listarParticipantes(int i) {
        if ( i >= 0 ){
            ArrayList<Juego> juegos = modelo.actualizarPartidas();
            vista.mostrarParticipantes(juegos.get(i).getParticipantes());
        }
        else{
            vista.mostrarmensaje("Debe seleccionar un juego");
        }
    }
}
