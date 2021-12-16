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
public class CasillaSorpresa extends Casilla{
    
    private MazoSorpresas mazo;
    
    CasillaSorpresa(String nombre, MazoSorpresas mazo) {
        
        super(nombre);
        this.mazo = mazo;
        
    }
    
    //consultor de nombre se puede acceder desde la clase papaito
    
    @Override
    public String toString() {
        
        String salida = "";
        
        salida = "Casilla de tipo sorpresa\n";
        
        return salida;
        
    }
    
    @Override
    void recibeJugador (int actual, ArrayList<Jugador> todos) {
        
        Sorpresa sorpresa = mazo.siguiente();
        this.informe(actual, todos);
        Diario.getInstance().ocurreEvento(sorpresa.toString());
        sorpresa.aplicarAJugador(actual, todos);
        
    }
    
}
