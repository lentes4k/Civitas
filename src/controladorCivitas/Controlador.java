/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorCivitas;

import civitas.CivitasJuego;
import civitas.OperacionJuego;
import vistaTextualCivitas.Vista;
import vistaTextualCivitas.VistaTextual;
import civitas.OperacionInmobiliaria;
import civitas.GestionInmobiliaria;

/**
 *
 * @author josemanu
 */
public class Controlador {
    
    private CivitasJuego juego;
    private VistaTextual vista;
    
    public Controlador (CivitasJuego juego, VistaTextual vista) {
        
        this.juego = juego;
        this.vista = vista;
        
    }
    
    public void juega() {
        
        while (!juego.finalDelJuego()) {
            
            vista.mostrarEstado();
            vista.pausa();
            OperacionJuego operacion = juego.siguientePaso();
            vista.mostrarSiguienteOperacion(operacion);
            
            if (operacion!=OperacionJuego.PASAR_TURNO) {
                
                vista.mostrarEventos();
                
            }
            
            boolean haTerminado = juego.finalDelJuego();
            
            if (!haTerminado) {
                
                
                if(operacion == OperacionJuego.COMPRAR)  {
                    
                    Respuesta respuesta = vista.comprar();
                    if (respuesta == Respuesta.SI)
                        juego.comprar();
                    
                    juego.siguientePasoCompletado(operacion);
                }
                
                if(operacion == OperacionJuego.GESTIONAR) {
                    
                    OperacionInmobiliaria op_in = vista.elegirOperacion();
                    if (op_in != OperacionInmobiliaria.TERMINAR) {
                        
                        int propiedad = vista.elegirPropiedad();
                        GestionInmobiliaria gestion = new GestionInmobiliaria(op_in, propiedad);
                        
                        if (gestion.getOperacion() == OperacionInmobiliaria.CONSTRUIR_CASA)
                            juego.construirCasa(propiedad);
                        
                        if (gestion.getOperacion() == OperacionInmobiliaria.CONSTRUIR_HOTEL)
                            juego.construirHotel(propiedad);
                        
                    }
                    
                    if (op_in == OperacionInmobiliaria.TERMINAR)
                        juego.siguientePasoCompletado(operacion);
                    
                }
                
            }
        }
        
        juego.ranking_pub();
        vista.mostrarEstado();
        
    }
    
}
