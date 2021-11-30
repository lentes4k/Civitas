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
public abstract class Sorpresa {
    
    private String texto;
    private int valor;
    private MazoSorpresas mazo;
    
    Sorpresa (String texto, int valor) {
        
        this.texto = texto;
        this.valor = valor;
        mazo = new MazoSorpresas();
        
    }
    
    int getValor() {
        
        return valor;
        
    }
    
    //llama a los metodos hijos
    abstract void aplicarAJugador (int actual, ArrayList<Jugador> todos);
        
    void informe (int actual, ArrayList<Jugador> todos) {
        
        String texto;
        texto = "El jugador " + todos.get(actual).getNombre() + " se le aplica: " + this.toString();
        Diario.getInstance().ocurreEvento(texto);
        
    }
    
    public String toString() {
        
        return texto;
        
    }
    
}
