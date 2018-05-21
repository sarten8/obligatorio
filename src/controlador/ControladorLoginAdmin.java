/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Fachada;
import modelo.PokerException;

/**
 *
 * @author Usuario
 */
public class ControladorLoginAdmin {

    public ControladorLoginAdmin(InterfaceLoginAdmin vista) {
        this.vista = vista;
    }
     private Fachada modelo = Fachada.getInstancia();
     private InterfaceLoginAdmin vista;
     
      public void loginAdmin(String user, String pass) {
          try{
       if(modelo.loginAdmin(user,pass)){
           vista.MostrarMonitor();
        }

        }catch(PokerException ex){
            vista.mostrarError(ex.getMessage());
        }
    }
    
}
