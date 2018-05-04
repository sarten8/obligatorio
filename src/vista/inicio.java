/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import modelo.*;

/**
 *
 * @author sartre
 */
public class inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws PokerException {
        // TODO code application logic here
        
        Fachada f = Fachada.getInstancia();
        
        Palo pc = new Palo("Corazón", 1);
        Palo pd = new Palo("Diamanete", 2);
        Palo pt = new Palo("Trébol", 3);
        Palo pp = new Palo("Pique", 4);
        
        Carta ac = new Carta('A', pc, "utilidades/cards/ace_of_hearts.png");
        Carta kc = new Carta('K', pc, "utilidades/cards/ace_of_hearts.png");
        
        Mazo mazo = new Mazo();
        mazo.getCartas().add(ac);
        mazo.getCartas().add(kc);
        
        f.getSj().setMazo(mazo);
        
        f.getSj().setLuz(100);
        f.getSj().setMaxJugadores(3);
        
        Juego j = new Juego(f.getSj().getMaxJugadores(), f.getSj().getLuz(), mazo);
        
        f.getSj().getJuegos().add(j);
        Jugador jugador1 = new Jugador("a", "a", "Sultano", 600);
        f.getSu().agregarJugador(jugador1);
        f.getSu().agregarJugador(new Jugador("b", "b", "Fulano", 600));
        f.getSu().agregarJugador(new Jugador("c", "c", "Mengano", 800));
        f.getSu().agregarJugador(new Jugador("prueba", "prueba", "Sr. Prueba", 10));
        
        //j.ingresarParticipante(jugador1);
        //j.iniciar();
        
        //Juego j2 = new Juego(f.getSj().getMaxJugadores(), f.getSj().getLuz(), mazo);
        //f.getSj().getJuegos().add(j2);
        
        new InicioPantalla().setVisible(true);
        
        System.out.println("");
        System.out.println("~ Prueba Git ~");
        System.out.println("______________");
    }
}
