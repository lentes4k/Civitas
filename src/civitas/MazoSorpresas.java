/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author josemanu
 */
public class MazoSorpresas {
    
    private ArrayList<Sorpresa> sorpresas;
    private boolean barajada;
    private int usadas;
    private boolean debug;
    
    private void init() {
        
        sorpresas = new ArrayList<>();
        barajada = false;
        usadas = 0;
        
    }
    
    MazoSorpresas(boolean debug) {
        
        debug = true;
        init();
        Diario.getInstance().ocurreEvento("ACTIVADO el modo debug del mazo de sorpresas");
        
    }
    
    MazoSorpresas() {
        
        debug = false;
        init();
        
    }
    
    void alMazo (Sorpresa s) {
        
        if (!barajada) {
            
            sorpresas.add(s);
            
        }
        
    }
    
    Sorpresa siguiente() {
        
        if ((!barajada || usadas == sorpresas.size()) && (!debug)) {
            
            Collections.shuffle(sorpresas);
            usadas = 0;
            barajada = true;
            
        }
        
        Sorpresa sorpresita = sorpresas.get(usadas);
        sorpresas.add(sorpresita);
        sorpresas.remove(usadas);
        usadas++;
        
        return sorpresita;
        
    }
    
}
