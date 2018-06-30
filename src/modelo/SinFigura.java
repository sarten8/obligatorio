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
public class SinFigura extends Figura{

    public SinFigura(ArrayList<Carta> cartas) {
        super(cartas);
    }

    @Override
    public int obtenerGerarquia() {
        return 0;
    }
    
}
