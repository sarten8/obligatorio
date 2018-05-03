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
public class Jugador extends Usuario{
    private int saldo;

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public Jugador(String user, String pass, String nombre, int saldo) {
        super(user, pass, nombre);
        this.saldo = saldo;
    }
    
}
