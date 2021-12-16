/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author josemanu
 */

import civitas.CivitasJuego;
import vistaTextualCivitas.VistaTextual;
import controladorCivitas.Controlador;

import java.util.ArrayList;

public class JuegoTexto {
    
    private static void jugar() {
        
        ArrayList<String> nombres = new ArrayList<String>();
        nombres.add("Jugador 1");
        nombres.add("Jugador 2");
        //nombres.add("Jugador 3");
        //nombres.add("Jugador 4");
        
        CivitasJuego juego = new CivitasJuego (nombres, true);
        
        VistaTextual vista= new VistaTextual(juego);
        
        Controlador controlador = new Controlador(juego, vista);
        
        controlador.juega();
        
    }
    
    public static void main (String[] args) {
        
        jugar();
        
    }
    
}
