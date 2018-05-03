/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author sartre
 */
public class Fachada {
    SistemaUsuarios su = new SistemaUsuarios();
    SistemaJuego sj = new SistemaJuego();
    
    private static Fachada instancia = new Fachada();
    public static Fachada getInstancia() {
        return instancia;
    }

    public SistemaUsuarios getSu() {
        return su;
    }

    public SistemaJuego getSj() {
        return sj;
    }
    
    public Fachada() {
    }
    
    public Participante loginJugador(String user, String pass) throws PokerException{
        return su.loginJuador(user, pass);
    }

    public Participante ingresarParticipante(Jugador j) throws PokerException{
        return sj.ingresarParticipante(j);
    }
}
