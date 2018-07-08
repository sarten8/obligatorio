/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Usuario
 */
public class Apuesta implements Runnable {

  
    private Jugador apostador;
    private Thread hilo;
    private int tiempoMax=10;
    private boolean contar;
    private boolean pasar;
    private boolean finalizado;

    public void setTiempoMax(int tiempoMax) {
        this.tiempoMax = tiempoMax;
    }

    public int getTiempoMax() {
        return tiempoMax;
    }

    
    public Apuesta() {
        iniciar();
    }
      
    @Override
    public void run() {
        for(int x = tiempoMax; x > 0 && contar; x--){
            try {
                Thread.currentThread().sleep(1000);
                tiempoMax = x;
                Fachada.getInstancia().avisar(Juego.Evento.Contar);
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
        contar = false;
        pasar = true;
        finalizar();
        Fachada.getInstancia().avisar(Juego.Evento.FinalizoTiempo);
    }
    


    public void iniciar(){
        if(!contar && !finalizado){
            hilo = new Thread(this);
            contar = true;
            hilo.start();
        }
    }


 public void finalizar(){
        pausa();
        finalizado = true;
    }
 
 
  public void pausa(){
        if(contar){
            contar = false;
            hilo.interrupt();
        }
    }
}