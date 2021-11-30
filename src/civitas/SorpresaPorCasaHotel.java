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
public class SorpresaPorCasaHotel extends Sorpresa{
    
    SorpresaPorCasaHotel(String texto, int valor) {
        
        super(texto, valor);
        
    }
    
    @Override
    void aplicarAJugador (int actual, ArrayList<Jugador> todos) {
        
        informe (actual, todos);
        Jugador jugador = new Jugador(todos.get(actual));
        if (jugador.cantidadCasasHoteles() > 0);
            jugador.modificaSaldo(getValor() * jugador.cantidadCasasHoteles());
        
    }
    
}
