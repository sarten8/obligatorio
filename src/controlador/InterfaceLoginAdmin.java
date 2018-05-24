/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Administrador;

/**
 *
 * @author Usuario
 */
public interface InterfaceLoginAdmin {
    public void mostrarError(String mensaje); 

    public void MostrarMonitor(Administrador a);
}
