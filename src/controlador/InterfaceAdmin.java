/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.Juego;
import modelo.Participante;

/**
 *
 * @author Usuario
 */
public interface InterfaceAdmin {
    
    public void mostrarmensaje(String msg);
    public void mostrarNombre(String nombre);
    public void mostrarLuz(int luz);
    public void mostrarMaxJugadores(int max);
    public void mostrarListaJuegos(ArrayList<Juego> juegos);
    public void mostrarParticipantes(ArrayList<Participante> participantes);
    public void BorrarParticipantes();
    
}
