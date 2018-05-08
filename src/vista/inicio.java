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
        
        //cartas corazones
        Carta ac = new Carta("A", pc, "utilidades/cards/ace_of_hearts.png");
        Carta kc = new Carta("K", pc, "utilidades/cards/king_of_hearts.png");
        Carta qc = new Carta("Q", pc, "utilidades/cards/queen_of_hearts.png");
        Carta jc = new Carta("J", pc, "utilidades/cards/jack_of_hearts.png");
        Carta diezc = new Carta("DIEZ", pc, "utilidades/cards/10_of_hearts.png");
        Carta nuevec = new Carta("NUEVE", pc, "utilidades/cards/9_of_hearts.png");
        Carta ochoc = new Carta("OCHO", pc, "utilidades/cards/8_of_hearts.png");
        Carta sietec = new Carta("SIETE", pc, "utilidades/cards/7_of_hearts.png");
        Carta seisc = new Carta("SEIS", pc, "utilidades/cards/6_of_hearts.png");
        Carta cincoc = new Carta("CINCO", pc, "utilidades/cards/5_of_hearts.png");
        Carta cuatroc = new Carta("CUATRO", pc, "utilidades/cards/4_of_hearts.png");
        Carta tresc = new Carta("TRES", pc, "utilidades/cards/3_of_hearts.png");
        Carta dosc = new Carta("DOS", pc, "utilidades/cards/2_of_hearts.png");
        
        //cartas diamante
        Carta ad = new Carta("A", pd, "utilidades/cards/ace_of_diamonds.png");
        Carta kd = new Carta("K", pd, "utilidades/cards/king_of_diamonds.png");
        Carta qd = new Carta("Q", pd, "utilidades/cards/queen_of_diamonds.png");
        Carta jd = new Carta("J", pd, "utilidades/cards/jack_of_diamonds.png");
        Carta diezd = new Carta("DIEZ", pd, "utilidades/cards/10_of_diamonds.png");
        Carta nueved = new Carta("NUEVE", pd, "utilidades/cards/9_of_diamonds.png");
        Carta ochod= new Carta("OCHO", pd, "utilidades/cards/8_of_diamonds.png");
        Carta sieted = new Carta("SIETE", pd, "utilidades/cards/7_of_diamonds.png");
        Carta seisd = new Carta("SEIS", pd, "utilidades/cards/6_of_diamonds.png");
        Carta cincod = new Carta("CINCO", pd, "utilidades/cards/5_of_diamonds.png");
        Carta cuatrod = new Carta("CUATRO", pd, "utilidades/cards/4_of_diamonds.png");
        Carta tresd = new Carta("TRES", pd, "utilidades/cards/3_of_diamonds.png");
        Carta dosd = new Carta("DOS", pd, "utilidades/cards/2_of_diamonds.png");
        
        //cartas pique
        Carta ap = new Carta("A", pp, "utilidades/cards/ace_of_spades.png");
        Carta kp = new Carta("K", pp, "utilidades/cards/king_of_spades.png");
        Carta qp = new Carta("Q", pp, "utilidades/cards/queen_of_spades.png");
        Carta jp = new Carta("J", pp, "utilidades/cards/jack_of_spades.png");
        Carta diezp = new Carta("DIEZ", pp, "utilidades/cards/10_of_spades.png");
        Carta nuevep = new Carta("NUEVE", pp, "utilidades/cards/9_of_spades.png");
        Carta ochop= new Carta("OCHO", pp, "utilidades/cards/8_of_spades.png");
        Carta sietep = new Carta("SIETE", pp, "utilidades/cards/7_of_spades.png");
        Carta seisp = new Carta("SEIS", pp, "utilidades/cards/6_of_spades.png");
        Carta cincop = new Carta("CINCO", pp, "utilidades/cards/5_of_spades.png");
        Carta cuatrop = new Carta("CUATRO", pp, "utilidades/cards/4_of_spades.png");
        Carta tresp = new Carta("TRES", pp, "utilidades/cards/3_of_spades.png");
        Carta dosp = new Carta("DOS", pp, "utilidades/cards/2_of_spades.png");
        
        //cartas trebol
        Carta at = new Carta("A", pt, "utilidades/cards/ace_of_clubs.png");
        Carta kt = new Carta("K", pt, "utilidades/cards/king_of_clubs.png");
        Carta qt = new Carta("Q", pt, "utilidades/cards/queen_of_clubs.png");
        Carta jt = new Carta("J", pt, "utilidades/cards/jack_of_clubs.png");
        Carta diezt = new Carta("DIEZ", pt, "utilidades/cards/10_of_clubs.png");
        Carta nuevet = new Carta("NUEVE", pt, "utilidades/cards/9_of_clubs.png");
        Carta ochot= new Carta("OCHO", pt, "utilidades/cards/8_of_clubs.png");
        Carta sietet = new Carta("SIETE", pt, "utilidades/cards/7_of_clubs.png");
        Carta seist = new Carta("SEIS", pt, "utilidades/cards/6_of_clubs.png");
        Carta cincot = new Carta("CINCO", pt, "utilidades/cards/5_of_clubs.png");
        Carta cuatrot = new Carta("CUATRO", pt, "utilidades/cards/4_of_clubs.png");
        Carta trest = new Carta("TRES", pt, "utilidades/cards/3_of_clubs.png");
        Carta dost = new Carta("DOS", pt, "utilidades/cards/2_of_clubs.png");
        
        
        Mazo mazo = new Mazo();
        mazo.agregarCarta(ac);
        mazo.agregarCarta(kc);
        mazo.agregarCarta(qc);
        mazo.agregarCarta(jc);
        mazo.agregarCarta(diezc);
        mazo.agregarCarta(nuevec);
        mazo.agregarCarta(ochoc);
        mazo.agregarCarta(sietec);
        mazo.agregarCarta(seisc);
        mazo.agregarCarta(cincoc);
        mazo.agregarCarta(cuatroc);
        mazo.agregarCarta(tresc);
        mazo.agregarCarta(dosc);
        mazo.agregarCarta(ad);
        mazo.agregarCarta(kd);
        mazo.agregarCarta(qd);
        mazo.agregarCarta(jd);
        mazo.agregarCarta(diezd);
        mazo.agregarCarta(nueved);
        mazo.agregarCarta(ochod);
        mazo.agregarCarta(sieted);
        mazo.agregarCarta(seisd);
        mazo.agregarCarta(cincod);
        mazo.agregarCarta(cuatrod);
        mazo.agregarCarta(tresd);
        mazo.agregarCarta(dosd);
        mazo.agregarCarta(ap);
        mazo.agregarCarta(kp);
        mazo.agregarCarta(qp);
        mazo.agregarCarta(jp);
        mazo.agregarCarta(diezp);
        mazo.agregarCarta(nuevep);
        mazo.agregarCarta(ochop);
        mazo.agregarCarta(sietep);
        mazo.agregarCarta(seisp);
        mazo.agregarCarta(cincop);
        mazo.agregarCarta(cuatrop);
        mazo.agregarCarta(tresp);
        mazo.agregarCarta(dosp);
        mazo.agregarCarta(at);
        mazo.agregarCarta(kt);
        mazo.agregarCarta(qt);
        mazo.agregarCarta(jt);
        mazo.agregarCarta(diezt);
        mazo.agregarCarta(nuevet);
        mazo.agregarCarta(ochot);
        mazo.agregarCarta(sietet);
        mazo.agregarCarta(seist);
        mazo.agregarCarta(cincot);
        mazo.agregarCarta(cuatrot);
        mazo.agregarCarta(trest);
        mazo.agregarCarta(dost);
        
        
        
        SistemaJuego sj = new SistemaJuego(mazo, 3, 100);
        
        f.AgregarSistemaJuego(sj);
        f.CrearJuego();
        /*Juego j = new Juego(f.getSj().getMaxJugadores(), f.getSj().getLuz(), mazo);
        
        f.getSj().getJuegos().add(j);*/

        f.AgregarJugador(new Jugador("a", "a", "Sultano", 600));
        f.AgregarJugador(new Jugador("s", "s", "Señor de la S", 15000));
        f.AgregarJugador(new Jugador("b", "b", "Fulano", 600));
        f.AgregarJugador(new Jugador("c", "c", "Mengano", 800));
        f.AgregarJugador(new Jugador("prueba", "prueba", "Sr. Prueba", 1000));
        
        f.AgregarAdministrador(new Administrador("z","z","zorro"));
        
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
