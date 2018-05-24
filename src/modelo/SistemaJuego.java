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
public class SistemaJuego
{
    private ArrayList<Juego> juegos = new ArrayList<>();
    private Mazo mazo;
    private int maxJugadores;
    private int luz;

    public ArrayList<Juego> getJuegos() {
        return juegos;
    }

    public void setJuegos(ArrayList<Juego> juegos) {
        this.juegos = juegos;
    }

    public Mazo getMazo() {
        return mazo;
    }

    public void setMazo(Mazo mazo) {
        this.mazo = mazo;
    }

    public int getMaxJugadores() {
        return maxJugadores;
    }

    public int getLuz() {
        return luz;
    }

    
    public SistemaJuego(Mazo mazo, int maxJugadores, int luz) {
        this.mazo = mazo;
        this.maxJugadores = maxJugadores;
        this.luz = luz;
    }
        
    public SistemaJuego(){}

    
    public void crearJuego() {
        Juego j = new Juego(this.maxJugadores, this.luz, this.mazo);
        this.juegos.add(j);
    }

    private boolean validarLuz(int luz) {
        return (luz > 0);
    }

    private boolean validarMaxJuagadores(int max) {
        return (max >= 2 && max <= 5);
    }

    public Participante ingresarParticipante(Jugador j) throws PokerException{
        if(juegos.size() <= 0) throw new PokerException("Aún no existe ningún juego");
        Participante p = juegos.get(juegos.size() - 1).ingresarParticipante(j);
        if (juegos.get(juegos.size()-1).getParticipantes().size() == this.maxJugadores) crearJuego();
        return p;
    }

    public Juego obtenerJuegoEnEspera() {
        return juegos.get(juegos.size()-1);
    } 
   
    public ArrayList<Juego> JuegosActivos() {
        ArrayList<Juego> listajuegos=new ArrayList();
        for(Juego j: juegos){
            if(j.getEstado()==Juego.Estado.Activo)
            {
                listajuegos.add(j);
            }
        }
        return listajuegos;
    }
      
      
      
      
    // ----------------- ************************ ----------------- ************************ ----------------- ************************ 
    // ----------------- ************************ ----------------- ************************ ----------------- ************************ 
    // ----------------- ************************ ----------------- ************************ ----------------- ************************ 
    // ----------------- ************************ ----------------- ************************ ----------------- ************************ 
      
    public void actualziarLuz(int luz) throws PokerException{
        if( !validarLuz(luz) ) throw new PokerException("El valor debe ser entero mayor que 0");
        this.luz = luz;
        Juego juegoEnEspera = obtenerJuegoEnEspera();
        if(juegoEnEspera.getParticipantes().isEmpty()) juegoEnEspera.setLuz(luz);
        Fachada.getInstancia().avisar(Fachada.Evento.ActualizarDatos);
    }
    
    // ------------------------------------------------------


    public void actualziarMaxJugadores(int max) throws PokerException{
        if( !validarMaxJuagadores(max) ) throw new PokerException("El valor debe ser entero y entre 2 y 5");
        
        this.maxJugadores = max;
        
        Juego juegoEnEspera = obtenerJuegoEnEspera();
        
        if(juegoEnEspera.getParticipantes().size() <= max) {
            juegoEnEspera.setMaxJugadores(max);
            Fachada.getInstancia().avisar(Fachada.Evento.ParticipanteIngresado);
        }
         
        if(juegoEnEspera.getParticipantes().size() == max) {
            juegoEnEspera.setMaxJugadores(max);
            crearJuego();
            juegoEnEspera.iniciar(); //Se avisa en Juego, acá no necesito avisar.
        }
    }
}
