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

    @Override
    public boolean soyGanador(ArrayList<Carta> cartas1, ArrayList<Carta> cartas2) {
        int i = 0;
        int valorC = 0;
        int j = 0;
        int valorC2 = 0;
        int valorC3 = 0;
        int valorC4 = 0;

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

        i = 0;
        j = 0;
        while (i < cartas1.size() && valorC2 == 0) {
            j = 0;
            while (j < cartas1.size() - 1 && valorC2 == 0) {
                j++;

                if (cartas2.get(i).getNumero() != valorC && cartas2.get(i).getNumero() == cartas2.get(j).getNumero() && cartas2.get(i) != cartas2.get(j)) {
                    valorC2 = cartas1.get(i).getNumero();
                }
            }
            i++;
        }

        int valorA = 0;
        int valorB = 0;

        if (valorC <= valorC2) {
            valorA = valorC;
            valorB = valorC2;
        } else {
            valorA = valorC2;
            valorB = valorC;
        }

        i = 0;
        j = 0;

        while (i < cartas2.size() && valorC3 == 0) {
            j = 0;
            while (j < cartas2.size() - 1 && valorC3 == 0) {
                j++;

                if (cartas2.get(i).getNumero() == cartas2.get(j).getNumero() && cartas2.get(i) != cartas2.get(j)) {
                    valorC3 = cartas1.get(i).getNumero();
                }
            }
            i++;
        }

        i = 0;
        j = 0;
        while (i < cartas2.size() && valorC4 == 0) {
            j = 0;
            while (j < cartas2.size() - 1 && valorC4 == 0) {
                j++;

                if (cartas2.get(i).getNumero() != valorC && cartas2.get(i).getNumero() == cartas2.get(j).getNumero() && cartas2.get(i) != cartas2.get(j)) {
                    valorC4 = cartas2.get(i).getNumero();
                }
            }
            i++;
        }
        int valorB2 = 0;
        int valorA2 = 0;

        if (valorC3 >= valorC4) {
            valorA2 = valorC3;
            valorB2 = valorC4;
        } else {
            valorA2 = valorC4;
            valorB2 = valorC3;
        }

        if (valorA == valorA2) {
            if (valorB == valorB2) {
                Carta cartaaux = null;
                Carta cartaaux2 = null;
                for (Carta c : cartas1) {
                    if (c.getNumero() != valorA && c.getNumero() != valorB) {
                        cartaaux = c;
                    }
                }

                for (Carta c : cartas2) {
                    if (c.getNumero() != valorA2 && c.getNumero() != valorB2) {
                        cartaaux2 = c;
                    }
                }

                if (cartaaux.getNumero() > cartaaux2.getNumero()) {
                    return true;
                }
                else if(cartaaux.getNumero() == cartaaux2.getNumero()){
                    if (cartaaux.getPalo().getValor() > cartaaux2.getPalo().getValor()) {
                        return true;
                    } else {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }
            else if(valorB > valorB2){
                return true;
            }
            else{
                return false;
            }
        }
        else if(valorA > valorA2){
            return true;
        }
        else{
            return false;
        }
    } 
}
