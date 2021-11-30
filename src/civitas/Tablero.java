/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import java.util.ArrayList; // import the ArrayList class

/**
 *
 * @author josemanu
 */

// Esta clase representa el tablero, vaya, el cartón donde ponemos las fichas
public class Tablero {
    
    private ArrayList<Casilla> casillas; //lista de casillas
    boolean porSalida; //variable que guardará si se ha pasado por salida en el turno
    
    //Constructor
    Tablero () {
        
        casillas = new ArrayList();
        Casilla Salida = new Casilla ("salida");
        casillas.add(Salida);
        porSalida = false;
        
    }
    
    //Métodos
    private boolean correcto (int numCasilla) {
        
       boolean soy_correcto = false;
       
       if (numCasilla < casillas.size()) {
           
          soy_correcto = true;
           
       }
       
       return soy_correcto;
        
    }
    
    boolean computarPasoPorSalida () {
        
        boolean aux_salida = porSalida;
        porSalida = false;
        
        return aux_salida;
        
    }
    
    void añadeCasilla (Casilla casilla) {
        
        casillas.add(casilla);
        
    }
    
    Casilla getCasilla (int numCasilla) {
        
        Casilla casilla_consultada;
        
        if (correcto(numCasilla)) {
            
            casilla_consultada = casillas.get(numCasilla); //puede ser -1 
            
        }
        
        else {
            
            casilla_consultada = null;
            
        }
        
        return casilla_consultada;
        
    }
    
    ArrayList<Casilla> getCasillas () {
        
        return casillas;
        
    }
    
    int nuevaPosicion (int actual, int tirada) {
        
        int nueva_posicion;
        int suma_casillas;
        
        suma_casillas = actual + tirada;
        nueva_posicion = (suma_casillas) % casillas.size();
        
        if (suma_casillas != nueva_posicion) {
            
            porSalida = true;
            
        }
        
        return nueva_posicion;
        
    }
    
}
