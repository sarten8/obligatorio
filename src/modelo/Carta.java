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
public class Carta {
    private int numero;
    private Palo palo;
    private String imagen; 

    public String getImagen() {
        return imagen;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Palo getPalo() {
        return palo;
    }

    public void setPalo(Palo palo) {
        this.palo = palo;
    }

    public Carta(int numero, Palo palo, String imagen) {
        this.numero = numero;
        this.palo = palo;
        this.imagen = imagen;
    }
}
