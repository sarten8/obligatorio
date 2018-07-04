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
public class DoblePar extends Figura {

    public DoblePar(){
        super("Doble Par", 2);
    }
    
    @Override
    public boolean soyFigura(ArrayList<Carta> cartas) {
        int cont = 0;
        for (int s = 0; s < cartas.size(); s++) {
            for (int j = 0; j < cartas.size(); j++) {
                if (s != j) {
                    if (cartas.get(s).getNumero() == cartas.get(j).getNumero()) {
                        cont++;
                    }
                }
            }
        }
        return (cont == 4 || cont == 8 || cont == 12);
    }
}
