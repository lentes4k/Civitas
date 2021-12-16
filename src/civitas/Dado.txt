/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import java.util.Random;

/**
 *
 * @author josemanu
 */
public class Dado {
    
    private Random random;
    private int ultimoResultado;
    private boolean debug;
    
    private static Dado instance = new Dado(); //solo habra una instancia
    
    private static int VALORDEBUG = 1;
    private static int VALORDADO = 6;
    
    
    public Dado() {
        
        random = new Random();
        ultimoResultado = 0; 
        debug = false;
        
    }
        
    static public Dado getInstance() {
        
        return instance;
        
    }
    
    int tirar () {
        
        if (!debug) {
            ultimoResultado = random.nextInt(VALORDADO)+1; //entre 0 y 5, de ahí el +1
        }
         
        else {
           
            ultimoResultado = VALORDEBUG;
            
        }
        
        return ultimoResultado;
        
    }
    
    int quienEmpieza (int n) {
        
        int tuEmpiezas;
        tuEmpiezas = random.nextInt(n); //ya que n no inclusive y jugadores van de 0....n-1
        
        return tuEmpiezas;
        
    }
    
    void setDebug (boolean d) {
        
        debug = d;
        if (debug) {
            Diario.getInstance().ocurreEvento ("Modo debug del dado ACTIVADO");
        
        }
        
        else {
            
            Diario.getInstance().ocurreEvento ("Modo debug del dado DESACTIVADO");
            
        }
    }
    
    int getUltimoResultado() {
        
        return ultimoResultado;
        
    }
    
}
