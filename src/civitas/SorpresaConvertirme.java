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
public class SorpresaConvertirme extends Sorpresa {
    
    SorpresaConvertirme (String texto, int valor /*valor sera 0*/) {
        
        super (texto, valor);
        
    }
    
    @Override
    void aplicarAJugador (int actual, ArrayList<Jugador> todos) {
        
        this.informe(actual, todos);;
        JugadorEspeculador jugadorNuevo = todos.get(actual).convertir();
        todos.remove(actual);
        todos.add(actual, jugadorNuevo);
       
    }
    
}
