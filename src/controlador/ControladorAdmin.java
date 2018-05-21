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
import modelo.PokerException;

/**
 *
 * @author sartre
 */
public class ControladorAdmin implements Observer{
    private Fachada modelo = Fachada.getInstancia();
    private InterfaceAdmin vista;
    
    
    public ControladorAdmin(InterfaceAdmin vista){
        this.vista = vista;
       
        modelo.addObserver(this);
       
       
    }

    @Override
    public void update(Observable o, Object evento) {
       
        
        if(evento.equals(Fachada.Evento.ListarPartidas)){
           
            vista.actualizarListaJuegos(this.modelo.actualizarPartidas());
        }
      
     
     
    }

    public void ActualizarDatos() {
        int luz =modelo.Verluz();
        int maxjugadores=modelo.VerMaximo();
        vista.actualizarLuz(luz);
        vista.actualizaMax(maxjugadores);
        vista.actualizarListaJuegos(this.modelo.actualizarPartidas());
        
    }

    public void SetearMaximo(int max) {
        try{
        modelo.SetearMaximo(max);
        vista.actualizaMax(max);
        vista.mostrarmensaje("El maximo jugadores se actualizo corectamente");
        
        }catch(PokerException ex){vista.mostrarmensaje(ex.getMessage());}
    }

    public void SetearLuz(int luz) {
        try{
       modelo.setearLuz(luz);
       vista.actualizarLuz(luz);
        vista.mostrarmensaje("La luz se actualizo corectamente");
       }catch(PokerException ex){vista.mostrarmensaje(ex.getMessage());
    }
    }

    public void listarParticipantes(Juego j) {
        if (j!=null){
        vista.listarParticipantes(j.getParticipantes());
        }else
        {
            vista.mostrarmensaje("Debe seleccionar un juego");
        }
    }
  
    
  
}
