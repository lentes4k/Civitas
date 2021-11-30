/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import java.util.ArrayList;

/**
 *
 * @author josemanu
 */
public class TestP4 {
    
    public static void main (String[] args) {
      
        Jugador jugador = new Jugador ("Juan");
        Jugador jugador2 = new Jugador ("Pepe");
        ArrayList<Jugador> array = new ArrayList<>();
        array.add(jugador);
        CasillaCalle propiedad = new CasillaCalle ("Calle chula", 1000, 50, 25);
        SorpresaConvertirme sorpresita = new SorpresaConvertirme ("Eres especulador", 0);
        
        jugador.comprar(propiedad);
        
        System.out.println("Antes de convertir " + propiedad.getPropietarioInfo());
        
        sorpresita.aplicarAJugador(0, array);
        //jugador.convertir();
        
        System.out.println("Depsues de convertir " + propiedad.getPropietarioInfo());
    }
    
}
