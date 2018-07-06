/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.Carta;
import modelo.Figura;
import modelo.Participante;

/**
 *
 * @author sartre
 */
public interface InterfaceJuego {
    public void mostrarError(String mensaje);
    public void mostrarEspera(int faltantes);
    public void mostrarNombre(String nombre);
    public void mostrarFigura(String figura);
    public void actualizarListaParticipantes(ArrayList<Participante> participantes);
    public void iniciarJuego();
    public void actualizarPozo(int pozo);
    public void actualizarSaldo(int saldo);
    public void pasaronTodos(String nombreJugador);
    public void mostrarCartas(ArrayList<Carta> cartas);
    public void salir();
    public void salirPorFaltaSaldo(String nombre, int luz);
    public void mostrarApuesta(String nombre, int monto);
    public void esperarRespuesta();
    public void mostrarGanador(String ganador, int pozo, String figura, ArrayList<Carta> cartas);
    public void mostrarMensajAlGanador(int pozo, String figura);
    public void comenzarNuevaMano();
    public void mostrarTerminoJuego(int monto);
}
