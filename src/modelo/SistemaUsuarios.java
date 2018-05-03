/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author sartre
 */
public class SistemaUsuarios {
    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private ArrayList<Administrador> administradores = new ArrayList<>();

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public ArrayList<Administrador> getAdministradores() {
        return administradores;
    }
    
    public void agregarJugador(Jugador j){
        jugadores.add(j);
    }
    
    public void agregarAdministrador(Administrador a){
        administradores.add(a);
    }
    
    public Participante loginJuador(String user,String pass) throws PokerException{
        for(Jugador j:jugadores){
            if(j.getUser().equals(user) && j.getPass().equals(pass)){
                    // aca pivoteo con SistemaJuego para traer al particiapante o no
                    Participante p = Fachada.getInstancia().ingresarParticipante(j);
                    return p;
                }
            }
        throw new PokerException("Usuario y/o Password incorrectos");
    }
}
