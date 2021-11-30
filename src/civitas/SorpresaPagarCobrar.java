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
public class SorpresaPagarCobrar extends Sorpresa {
    
    SorpresaPagarCobrar (String texto, int valor) {
        
        super (texto, valor);
         
    }
    
    @Override
    void aplicarAJugador (int actual, ArrayList<Jugador> todos) {
        
        this.informe (actual, todos);
        todos.get(actual).modificaSaldo(getValor());
        
    }
    
}
