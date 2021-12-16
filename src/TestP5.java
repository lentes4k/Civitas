/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;

import civitas.CivitasJuego;
import controladorCivitas.Controlador;
import GUI.*;

/**
 *
 * @author josemanu
 */
public class TestP5 {
    
    public static void main(String[] args) {
        
        CivitasView vista = new CivitasView();
        CapturaNombres captura = new CapturaNombres(vista, true);
        
        ArrayList<String> nombres = new ArrayList<>();
        nombres = captura.getNombres();
        
        CivitasJuego juego = new CivitasJuego (nombres, false);
        
        Controlador controlador = new Controlador (juego, vista);
        
        vista.setCivitasJuego(juego);
        controlador.juega();
    }
    
}
