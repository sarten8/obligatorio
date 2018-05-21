/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import modelo.Juego;
import modelo.Participante;

/**
 *
 * @author sartre
 */
public interface InterfaceLoginJugador {
    public void mostrarError(String mensaje); 
    public void mostrarParticipante(Participante p);
}