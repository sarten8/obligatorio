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
public class DoblePar extends Figura{

    public DoblePar(ArrayList<Carta> cartas) {
        super(cartas);
    }

    @Override
    public int obtenerGerarquia() {
        return 2;
    }
    
}
