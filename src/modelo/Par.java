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
public class Par extends Figura{
    
    public Par(){
        super("Par", 1);
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
        return (cont == 2 || cont == 6);
    }

    @Override
    public boolean soyGanador(ArrayList<Carta> cartas1, ArrayList<Carta> cartas2) {
        int i = 0;
        int valorC = 0;
        int j = 0;
        int valorC2 = 0;
        int valorC3 = 0;
        int valoraux = 0;

        // Mis cartas
        while (i < cartas1.size() && valorC == 0) {
            j = 0;
            while (j < cartas1.size() - 1 && valorC == 0) {
                j++;
                if (cartas1.get(i).getNumero() == cartas1.get(j).getNumero() && cartas1.get(i) != cartas1.get(j)) {
                    valorC = cartas1.get(i).getNumero();
                }
            }
            i++;
        }

        // Cartas contrincante 
        i = 0;
        j = 0;
        while (i < cartas2.size() && valorC2 == 0) {
            j = 0;
            while (j < cartas2.size() - 1 && valorC2 == 0) {
                j++;

                if (cartas2.get(i).getNumero() == cartas2.get(j).getNumero()) {
                    valorC2 = cartas2.get(i).getNumero();
                }
            }
            i++;
        }
        
        Carta cartaaux = null;
        if (valorC>valorC2) return true;
        if (valorC2 == valorC) {
            for (Carta c : cartas1) {
                if (c.getNumero() != valorC) {
                    if (c.getNumero() > valoraux) {
                        valorC3 = c.getNumero();
                    }
                    cartaaux = c;
                    valoraux = c.getNumero();
                }
            }
            int valoraux2 = 0;
            Carta cartaaux2 = null;
            int valorC4 = 0;
            for (Carta c : cartas2) {
                if (c.getNumero() != valorC2) {
                    if (c.getNumero() > valoraux2) {
                        valorC4 = c.getNumero();
                    }
                    cartaaux2 = c;
                }
            }
            if (valorC3 > valorC4) return true;
            if (valorC3 == valorC4) {
                if (cartaaux.getPalo().getValor() > cartaaux2.getPalo().getValor()) {
                    return true;
                } 
            }
        }
        return false;
    }
}
