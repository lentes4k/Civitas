/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

/**
 *
 * @author josemanu
 */
public class JugadorEspeculador extends Jugador {
    
    protected static int FactorEspeculador = 2;
    
    private static int CasasMax = 4*FactorEspeculador;
    private static int HotelesMax = 4*FactorEspeculador;
    
    protected JugadorEspeculador (Jugador otro) {
        
        super(otro);
        actualizaPropiedadesPorConversion();
       
    }
    
    void actualizaPropiedadesPorConversion() {
        
        for (int i = 0; i < this.getPropiedades().size(); i++) {
            
            ((CasillaCalle) this.getPropiedades().get(i)).actualizaPropietarioPorConversion(this);
            
        }
        
    }
    
    protected int getCasasMax() {
        
        return CasasMax;
        
    }
    
    protected int HotelesMax() {
        
        return HotelesMax;
        
    }
    
    @Override
    public String toString () {
        
        String texto;
        
        texto = "El jugador " + getNombre() + " es especulador y tiene las siguientes propiedades: \n";
        
        for (int i = 0; i < getPropiedades().size(); i++) {
            
            texto = texto + "- " + getPropiedades().get(i).getNombre() + "\n";
            
        }
                
        return texto;
        
    }
    
    @Override
    boolean paga (float cantidad) {
        
        return modificaSaldo((cantidad* -1)/FactorEspeculador);
        
    }
    
    @Override
    JugadorEspeculador convertir() {
        
        return this;
        
    }
    
    int getFactorEspeculador() {
        
        return FactorEspeculador;
        
    }
    
}
