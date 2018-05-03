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
public class Participante {
    private Jugador jugador;
    private Juego juego;
    private ArrayList<Carta> cartas = new ArrayList<>();
    private int saldoInicial;
    private int saldoApostado = 0;
    private int saldoGastado = 0;
    private Estado estado;
    public enum Estado{
        Activo, Inactivo;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    public int getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(int saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public int getSaldoApostado() {
        return saldoApostado;
    }

    public void setSaldoApostado(int saldoApostado) {
        this.saldoApostado = saldoApostado;
    }

    public int getSaldoGastado() {
        return saldoGastado;
    }

    public void setSaldoGastado(int saldoGastado) {
        this.saldoGastado = saldoGastado;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    

    public Participante(Jugador jugador, Juego juego, int saldoInicial) {
        this.jugador = jugador;
        this.juego = juego;
        this.saldoInicial = saldoInicial;
        this.estado = Estado.Activo;
    }
    
    
    public int apostar(int monto){
        this.jugador.setSaldo(this.jugador.getSaldo() - monto);
        this.saldoApostado += monto;
        return monto;
    }
    
    public boolean validarApuesta(int monto){
        return (this.jugador.getSaldo() >= monto);        
    }
}
