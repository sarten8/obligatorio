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
public class Color extends Figura{

    public Color(){
        super("Color", 3);
    }
    
    @Override
    public boolean soyFigura(ArrayList<Carta> cartas) {
        boolean color=true;
        for (int i=0; i<(cartas.size()-1); i++) {
            if (!(cartas.get(i).getPalo().getValor() == cartas.get(i+1).getPalo().getValor())) {
                color=false;
            }
        }
        return color;
    }

    @Override
    public boolean soyGanador(ArrayList<Carta> cartas1, ArrayList<Carta> cartas2) {
        return  cartas1.get(1).getPalo().getValor() > cartas2.get(1).getPalo().getValor();
    }
}
