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
    
   
    public void actualizarListaJuegos(ArrayList<Juego> juegos);
    public void actualizarLuz(int luz);
    public void actualizaMax(int max);
    public void mostrarmensaje(String msg);

    public void listarParticipantes(ArrayList<Participante> participantes);

    public void BorrarParticipantes();

    public void mostrarNombre(String nombre);

   
     
}
