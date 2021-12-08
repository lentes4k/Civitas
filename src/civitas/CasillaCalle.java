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
public class CasillaCalle extends Casilla {
    
    private float precioCompra;
    private float precioEdificar;
    private float precioBaseAlquiler;
    private int numCasas;
    private int numHoteles;
    private Jugador propietario;
    
    private static float FACTORALQUILERCALLE = 1.0f;
    private static float FACTORALQUILERCASA = 1.0f;
    private static float FACTORALQUILERHOTEL = 4.0f;
    
    CasillaCalle(String titulo, float precioCompra, float precioEdificar, float precioBaseAlquiler) {

        super(titulo);
        this.precioCompra = precioCompra;
        this.precioEdificar = precioEdificar;
        this.precioBaseAlquiler = precioBaseAlquiler;
        numCasas = 0;
        numHoteles = 0;
        propietario = null;
        
    }
    
    //metodos get
    //no habra un getNombre ya que esta en casilla padre
    
    public float getPrecioCompra() {

        return precioCompra;

    }

    float getPrecioEdificar() {

        return precioEdificar;

    }

    public int getNumCasas() {

        return (numCasas);

    }

    public int getNumHoteles() {

        return (numHoteles);

    }
    
    public Jugador getPropietario() {
        
        return propietario;
        
    }
    
    public String getPropietarioInfo() {
        
        return propietario.toString();
        
    }

    float getPrecioAlquilerCompleto() {

        float precioAlquilerCompleto = precioBaseAlquiler * (FACTORALQUILERCALLE + FACTORALQUILERCASA * numCasas + FACTORALQUILERHOTEL * numHoteles);

        return (precioAlquilerCompleto);

    }
    
    //devuelve la suma de construcciones en la casilla
    public int cantidadCasasHoteles() {
        
        return numCasas + numHoteles;
        
    }
    
    //si el jugador passado es propietario de la casilla
    // y además hay casas u hoteles, se destruyen n propiedades
    boolean derruirCasas (int n, Jugador jugador) {
        
        boolean salida = false;
        
        if (esEsteElPropietario(jugador) && getNumCasas() >= n) {
            
          numCasas = numCasas - n;
          salida = true;
            
        }
        
        return salida;
        
    }
    
    // método para ver si el jugador pasado es el propietario
    // de la casilla
    public boolean esEsteElPropietario (Jugador jugador) {
        
        boolean salida;
        
        if (jugador == propietario)
            salida = true;
        else
            salida = false;
        
        return salida;
        
    }
    
    public boolean tienePropietario () {
        
        boolean salida;
        
        if (propietario != null)
            salida = true;
        else
            salida = false;
        
        return salida;
        
    }
    
    //método que tramita el pago del alquiler en caso de que
    //la casilla tenga propietario y el jugador que ha caido 
    //no sea el dueño
    public void tramitarAlquiler(Jugador jugador) {
        
       if (tienePropietario() && !esEsteElPropietario(jugador)) {
           
           float precio;
           
           precio = jugador.pagaAlquiler(this.getPrecioAlquilerCompleto());
           
           propietario.recibe(precio);
           
       }
        
    }
    
    boolean comprar (Jugador jugador) {
        
        propietario = jugador;
        propietario.paga(precioCompra);
        
        return true;
        
    }
    
    boolean construirCasa (Jugador jugador) {
        
        //necesario lo comentado ?????
        
        //if (propietario == jugador) {
            
            jugador.paga(precioEdificar);
            numCasas++;
        
            return true;
            
        /*}
        
        else
            return false;*/
        
    }
    
    boolean construirHotel (Jugador jugador) {
        
        //necesario lo comentado ????
        
        //if (propietario == jugador) {
            
            jugador.paga(precioEdificar);
            numHoteles++;
        
            return true;
            
        /*}
        
        else
            return false;*/
        
    }
    
    @Override
    public String toString() {
        
        String salida = "";
        
        if (propietario!=null) {
                
                salida = this.getNombre() + " su propietario es " + propietario.getNombre() + " y tiene: \nCasas construidas = " + numCasas + ".\nHoteles construidos = " + numHoteles;;
                
            }
            
            else {

                salida = this.getNombre() + ".\nPrecio de compra =" + precioCompra + ".\nCoste edificar =" + precioEdificar + ".\nCoste alquiler =" + precioBaseAlquiler + ".\nCasas construidas = " + numCasas + ".\nHoteles construidos = " + numHoteles;
                
            }
        
        return salida;
        
    }
    
    @Override
    void recibeJugador (int actual, ArrayList<Jugador> todos) {
        
        this.informe (actual, todos);
        Jugador jugador = todos.get(actual);
        
        if (!tienePropietario())
            jugador.puedeComprarCasilla();
        else
            tramitarAlquiler(jugador);
  
    }
    
    void actualizaPropietarioPorConversion (JugadorEspeculador jugador) {
        
        this.propietario = jugador;
        
    }
    
}
