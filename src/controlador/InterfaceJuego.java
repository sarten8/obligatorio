/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.Participante;

/**
 *
 * @author sartre
 */
public interface InterfaceJuego {
    public void mostrarError(String mensaje);
    public void mostrarEspera(int faltantes);
    public void actualizarListaParticipantes(ArrayList<Participante> participantes);
    public void iniciarJuego();
}
