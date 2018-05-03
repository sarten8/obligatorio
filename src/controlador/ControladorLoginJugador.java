/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Fachada;
import modelo.Participante;
import modelo.PokerException;

/**
 *
 * @author sartre
 */
public class ControladorLoginJugador {
    private Fachada modelo = Fachada.getInstancia();
    private InterfaceLoginJugador vista;

    public ControladorLoginJugador(InterfaceLoginJugador vista) {
        this.vista = vista;
    }

    public void login(String user, String pass) {
        try{
            Participante p = modelo.loginJugador(user, pass);
            if(p == null) vista.mostrarError("Error al traer Participante") ;
            else vista.mostrarParticipante(p);
        }catch(PokerException ex){
            vista.mostrarError(ex.getMessage());
        }
    }
}
