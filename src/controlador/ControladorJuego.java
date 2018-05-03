/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Fachada;

/**
 *
 * @author sartre
 */
public class ControladorJuego {
    private Fachada modelo = Fachada.getInstancia();
    private InterfaceJuego vista;
    
    public ControladorJuego(InterfaceJuego vista){
        this.vista = vista;
    }
}
