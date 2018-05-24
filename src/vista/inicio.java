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
        
        Palo pc = new Palo("Corazón", 4);
        Palo pd = new Palo("Diamanete", 3);
        Palo pt = new Palo("Trébol", 2);
        Palo pp = new Palo("Pique", 1);
        
        //cartas corazones
        Carta ac = new Carta(14, pc, "utilidades/cards/ace_of_hearts.png");
        Carta kc = new Carta(13, pc, "utilidades/cards/king_of_hearts.png");
        Carta qc = new Carta(12, pc, "utilidades/cards/queen_of_hearts.png");
        Carta jc = new Carta(11, pc, "utilidades/cards/jack_of_hearts.png");
        Carta diezc = new Carta(10, pc, "utilidades/cards/10_of_hearts.png");
        Carta nuevec = new Carta(9, pc, "utilidades/cards/9_of_hearts.png");
        Carta ochoc = new Carta(8, pc, "utilidades/cards/8_of_hearts.png");
        Carta sietec = new Carta(7, pc, "utilidades/cards/7_of_hearts.png");
        Carta seisc = new Carta(6, pc, "utilidades/cards/6_of_hearts.png");
        Carta cincoc = new Carta(5, pc, "utilidades/cards/5_of_hearts.png");
        Carta cuatroc = new Carta(4, pc, "utilidades/cards/4_of_hearts.png");
        Carta tresc = new Carta(3, pc, "utilidades/cards/3_of_hearts.png");
        Carta dosc = new Carta(2, pc, "utilidades/cards/2_of_hearts.png");
        
        //cartas diamante
        Carta ad = new Carta(14, pd, "utilidades/cards/ace_of_diamonds.png");
        Carta kd = new Carta(13, pd, "utilidades/cards/king_of_diamonds.png");
        Carta qd = new Carta(12, pd, "utilidades/cards/queen_of_diamonds.png");
        Carta jd = new Carta(11, pd, "utilidades/cards/jack_of_diamonds.png");
        Carta diezd = new Carta(10, pd, "utilidades/cards/10_of_diamonds.png");
        Carta nueved = new Carta(9, pd, "utilidades/cards/9_of_diamonds.png");
        Carta ochod= new Carta(8, pd, "utilidades/cards/8_of_diamonds.png");
        Carta sieted = new Carta(7, pd, "utilidades/cards/7_of_diamonds.png");
        Carta seisd = new Carta(6, pd, "utilidades/cards/6_of_diamonds.png");
        Carta cincod = new Carta(5, pd, "utilidades/cards/5_of_diamonds.png");
        Carta cuatrod = new Carta(4, pd, "utilidades/cards/4_of_diamonds.png");
        Carta tresd = new Carta(3, pd, "utilidades/cards/3_of_diamonds.png");
        Carta dosd = new Carta(2, pd, "utilidades/cards/2_of_diamonds.png");
        
        //cartas pique
        Carta ap = new Carta(14, pp, "utilidades/cards/ace_of_spades.png");
        Carta kp = new Carta(13, pp, "utilidades/cards/king_of_spades.png");
        Carta qp = new Carta(12, pp, "utilidades/cards/queen_of_spades.png");
        Carta jp = new Carta(11, pp, "utilidades/cards/jack_of_spades.png");
        Carta diezp = new Carta(10, pp, "utilidades/cards/10_of_spades.png");
        Carta nuevep = new Carta(9, pp, "utilidades/cards/9_of_spades.png");
        Carta ochop= new Carta(8, pp, "utilidades/cards/8_of_spades.png");
        Carta sietep = new Carta(7, pp, "utilidades/cards/7_of_spades.png");
        Carta seisp = new Carta(6, pp, "utilidades/cards/6_of_spades.png");
        Carta cincop = new Carta(5, pp, "utilidades/cards/5_of_spades.png");
        Carta cuatrop = new Carta(4, pp, "utilidades/cards/4_of_spades.png");
        Carta tresp = new Carta(3, pp, "utilidades/cards/3_of_spades.png");
        Carta dosp = new Carta(2, pp, "utilidades/cards/2_of_spades.png");
        
        //cartas trebol
        Carta at = new Carta(14, pt, "utilidades/cards/ace_of_clubs.png");
        Carta kt = new Carta(13, pt, "utilidades/cards/king_of_clubs.png");
        Carta qt = new Carta(12, pt, "utilidades/cards/queen_of_clubs.png");
        Carta jt = new Carta(11, pt, "utilidades/cards/jack_of_clubs.png");
        Carta diezt = new Carta(10, pt, "utilidades/cards/10_of_clubs.png");
        Carta nuevet = new Carta(9, pt, "utilidades/cards/9_of_clubs.png");
        Carta ochot= new Carta(8, pt, "utilidades/cards/8_of_clubs.png");
        Carta sietet = new Carta(7, pt, "utilidades/cards/7_of_clubs.png");
        Carta seist = new Carta(6, pt, "utilidades/cards/6_of_clubs.png");
        Carta cincot = new Carta(5, pt, "utilidades/cards/5_of_clubs.png");
        Carta cuatrot = new Carta(4, pt, "utilidades/cards/4_of_clubs.png");
        Carta trest = new Carta(3, pt, "utilidades/cards/3_of_clubs.png");
        Carta dost = new Carta(2, pt, "utilidades/cards/2_of_clubs.png");
        
        
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

        f.AgregarJugador(new Jugador("a", "a", "Sultano", 600));
        f.AgregarJugador(new Jugador("s", "s", "Señor de la S", 15000));
        f.AgregarJugador(new Jugador("b", "b", "Fulano", 600));
        f.AgregarJugador(new Jugador("c", "c", "Mengano", 800));
        f.AgregarJugador(new Jugador("prueba", "prueba", "Sr. Prueba", 1000));
        f.AgregarJugador(new Jugador("sarten", "sarten", "Filo de sarten", 299));
        
        f.AgregarAdministrador(new Administrador("z","z","zorro"));
        f.AgregarAdministrador(new Administrador("x","x","pepe"));

        
        new InicioPantalla().setVisible(true);
        
        System.out.println("");
        System.out.println("~ Prueba Git ~");
        System.out.println("______________");
    }
}
