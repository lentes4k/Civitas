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
//Esta clase representará las casillas del juego
public class Casilla {

    private String nombre; //nombre de la casilla, ej: calle juan


    //Constructores
    Casilla(String nombre) {

        this.nombre = nombre;

    }
    

    //Consultores
    String getNombre() {

        return nombre;

    }
    
    public String getNombrePub() {
        
        return getNombre();
        
    }
    
    //Informa al diario sobre el jugador que cae en la casilla
    void informe (int actual, ArrayList<Jugador> todos) {
        
        String texto;
        texto = "El jugador " + todos.get(actual).getNombre() + " está en la casilla: " + this.toString();
        Diario.getInstance().ocurreEvento(texto);
        
    }

    // COnvertirá los datos a String (para que sea legible)
    public String toString() {

        String salida = "";

        salida = "Casilla de descanso. Relajate un ratito\n";

        return salida;

    }
    
    void recibeJugador (int actual, ArrayList<Jugador> todos) {
        
            informe(actual, todos);
        
    }

}
