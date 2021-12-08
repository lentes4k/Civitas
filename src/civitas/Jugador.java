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
public class Jugador implements Comparable<Jugador> {
    
    private String nombre;
    private ArrayList<CasillaCalle> propiedades;
    private int casillaActual;
    private float saldo;
    private boolean puedeComprar;
    
    private static float SaldoInicial = 7500;
    protected static float PasoPorSalida = 1000;
    protected static int CasasMax = 4;
    protected static int HotelesMax = 4;
    protected static int CasasPorHotel = 4;
    
    
    Jugador (String nombre) {
        
        this.nombre = nombre;
        propiedades = new ArrayList<CasillaCalle>();
        casillaActual = 0; //la de salida
        saldo = SaldoInicial;
        puedeComprar = true;
        
    }
    
    protected Jugador (Jugador otro) {
        
        nombre = otro.getNombre();
        propiedades = otro.getPropiedades();
        casillaActual = otro.getCasillaActual();
        saldo = otro.getSaldo();
        puedeComprar = otro.getPuedeComprar();
        
    }
    
    //método get
    public String getNombre() {
        
        return nombre;
        
    }
    
    protected ArrayList<CasillaCalle> getPropiedades () {
        
        return propiedades;
        
    }
    
    public ArrayList<CasillaCalle> getPropiedadesPub() {
        
       return getPropiedades(); 
        
    }
    
    int getCasillaActual() {
        
        return casillaActual;
        
    }
    
    public float getSaldo() {
        
        return saldo;
        
    }
    
    boolean getPuedeComprar() {
        
        return puedeComprar;
        
    }
    
    private float getPremioPasoPorSalida() {
        
        return PasoPorSalida;
        
    }
    
    private int getCasasMax() {
        
        return CasasMax;
        
    }
    
    private int getHotelesMax() {
        
        return HotelesMax;
        
    }
    
    int getCasasPorHotel() {
        
        return CasasPorHotel;
        
    }
    
    
    //RESTO DE MÉTODOS
    
    //comprueba el índice como índice válido en el vector
    //de propiedades
    private boolean existeLaPropiedad (int ip) {
        
        boolean salida;
        
        if (ip < propiedades.size())
            salida = true;
        else
            salida = false;
        
        return salida;
        
    }
    
    //modifica el atributo de puede comprar la casilla
    boolean puedeComprarCasilla() {
        
        puedeComprar = true;
        
        return puedeComprar;
        
    }
    
    //método para pagar
    float paga (float cantidad) {
        
        modificaSaldo(cantidad* -1);
        
        return cantidad;
        
    }
    
    //método para pagar el alquiler
    float pagaAlquiler (float cantidad) {
        
        return paga(cantidad);
        
    }
    
    //método para recibir dinero
    boolean recibe (float cantidad) {
        
        return modificaSaldo(cantidad);
        
    }
    
    //método que modifica el saldo
    boolean modificaSaldo (float cantidad) {
        
        float saldoAnterior = saldo;
        saldo = saldo + cantidad;
        
        String texto;
        texto = "El saldo del jugador " + nombre + " pasa de: " + saldoAnterior + " a: " + saldo;
        Diario.getInstance().ocurreEvento(texto);
        
        return true;
        
    }
    
    //método que cambio la casilla del jugador
    boolean moverACasilla (int c) {
        
        casillaActual = c;
        puedeComprar = false;
        
        String texto;
        texto = "El jugador " + nombre + " se mueve a " + casillaActual;
        Diario.getInstance().ocurreEvento(texto);
        
        return true;
        
    }
    
    //método para saber si tienes dinero para gastar
    private boolean puedoGastar (float precio) {
        
        boolean salida;
        
        if (saldo>=precio)
            salida = true;
        else
            salida = false;
                    
        return salida;
        
    }
    
    //método para saber si tenemos propieddes
    boolean tieneAlgoQueGestionar() {
        
        boolean salida;
        
        if (propiedades.size() > 0)
            salida = true;
        else
            salida = false;
        
        return salida;
        
    }
    
    //se aplica lo necesario al pasar por la casilla de salida
    boolean pasaPorSalida() {
        
        recibe(PasoPorSalida);
        
        String texto;
        texto = "El jugador " + nombre + " acaba de pasar por la casilla de salida y ha recibido " + PasoPorSalida + " euros";
        Diario.getInstance().ocurreEvento(texto);
        
        return true;
        
    }
    
    //método para comprar el saldo de dos jugadores
   public int compareTo (Jugador otro) {
        
       //0 si iguales
       //positivo si atributo1 > atributo2
       //negativo si atributo1 < atributo2
        return Float.compare(saldo, otro.getSaldo());
        
    }
    
    //devuelve la cantidad de propiedades en una casilla
    int cantidadCasasHoteles() {
        
        int cantidad = 0;
        for(CasillaCalle propiedad : propiedades){
            cantidad += propiedad.cantidadCasasHoteles();
        }
        
        return cantidad;
        
    }
    
    boolean enBancarrota() {
        
        boolean salida = true;
        
        if (saldo <= 0)
            salida= true;
        else
            salida = false;
        
        return salida;
        
    }
    
    //COmprueba si se puede eficiar una casa
    private boolean puedoEdificarCasa (CasillaCalle propiedad) {
        
        //habra que comprobar si la propiedad es suya???
        
        boolean puedoEdificar = false;
        
        float precio = propiedad.getPrecioEdificar();
        
        if (puedoGastar(precio)) {
            
            if (propiedad.getNumCasas() < getCasasMax())
                puedoEdificar = true;
            
        } //puedoGastar
        
        return puedoEdificar;
        
    }
    
    //comprueba si se puede edificar un hotelS
    private boolean puedoEdificarHotel (CasillaCalle propiedad) {
        
        boolean puedoEdificarHotel = false;
        float precio = propiedad.getPrecioEdificar();
        
        if (puedoGastar(precio)) {
                
            if (propiedad.getNumHoteles() < getHotelesMax()) {
                    
                if (propiedad.getNumCasas() >= getCasasPorHotel()) {
                    
                    puedoEdificarHotel = true;
                    
                } //casas
                    
            } //hoteles
                
        } //puedoGastar

        return puedoEdificarHotel;
        
        //habra que comprobar si la propiedad es suya???
        
    }
    
    public String toString () {
        
        String texto;
        
        texto = "El jugador " + nombre + " tiene las siguientes propiedades: \n";
        
        for (int i = 0; i < propiedades.size(); i++) {
            
            texto = texto + "- " + propiedades.get(i).getNombre() + "\n";
            
        }
                
        return texto;
        
    }
    
    //MÉTODOS QUE SE HARAN MÁS ADELANTE
    boolean comprar (CasillaCalle titulo) {
        
        boolean result = false;
        
        if (puedeComprar) {
            
            float precio = titulo.getPrecioCompra();
            
            if (puedoGastar(precio)) {
                
                result = titulo.comprar(this);
                propiedades.add(titulo);
                Diario.getInstance().ocurreEvento("El jugador " + nombre + " compra la propiedad " + titulo.toString());
                puedeComprar = false;
                
            } //puedoGastar
            else
                Diario.getInstance().ocurreEvento("El jugador" + nombre + " no tiene saldo para comprar " + titulo);
            
        } //puedeComprar
        
        return result;
        
    }
    
    boolean construirHotel (int ip) {
        
        boolean result = false;
        
        if(existeLaPropiedad(ip)) {
            
            CasillaCalle propiedad = propiedades.get(ip);
            boolean puedoEdificarHotel = puedoEdificarHotel(propiedad);
            
            if (puedoEdificarHotel) {
                
                result = propiedad.construirHotel(this);
                propiedad.derruirCasas(CasasPorHotel, this);
                Diario.getInstance().ocurreEvento("El jugador " + nombre + " construye hotel en la propiedad " + ip);
                
            } //puedoEdificar
            
        } //existeLaPropiedad
        
        return result;
        
    }
    
    boolean construirCasa (int ip) {
        
        boolean result = false;
        boolean existe = existeLaPropiedad(ip);
        
        if (existe) {
            
            CasillaCalle propiedad = propiedades.get(ip);
            boolean puedoEdificar = puedoEdificarCasa(propiedad);
            
            if (puedoEdificar) {
                
                result = propiedad.construirCasa(this);
                Diario.getInstance().ocurreEvento("El jugador " + nombre + " construye casa en la propiedad " + ip);
                
            } //puedoEdificar
            
        } //existe
        
        return result;
        
    }
    
    JugadorEspeculador convertir () {
        
        JugadorEspeculador jugadorEspeculador = new JugadorEspeculador (this);
        Diario.getInstance().ocurreEvento("El jugador " + nombre + " pasa a ser un jugador especulador");
        return jugadorEspeculador;
        
    }
}
