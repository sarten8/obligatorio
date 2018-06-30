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
public abstract class Figura implements IFigura{
    private ArrayList<Carta> cartas = new ArrayList<>();

    public Figura(ArrayList<Carta> cartas){
        this.cartas = cartas;
    }   
}
