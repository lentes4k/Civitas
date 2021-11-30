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
public class CivitasJuego {
    
    private int indiceJugadorActual;
    private MazoSorpresas mazo;
    private Tablero tablero;
    private ArrayList<Jugador> jugadores;
    private EstadoJuego estado; 
    private GestorEstados gestorEstados;
    
    public CivitasJuego (ArrayList<String> jugadores, boolean debug) {
        
        this.jugadores = new ArrayList<>();
        
        for (int i = 0; i < jugadores.size(); i++) {
            
            Jugador jugador = new Jugador (jugadores.get(i));
            this.jugadores.add(jugador);
            
        }
        
        gestorEstados = new GestorEstados();
        estado = gestorEstados.estadoInicial();

        Dado.getInstance().setDebug(debug);
        
        indiceJugadorActual = Dado.getInstance().quienEmpieza(jugadores.size());
        
        mazo = new MazoSorpresas (debug);
        
        tablero = new Tablero();
        inicializaTablero(mazo);
        
        inicializaMazoSopresas(tablero);
        
    }
    
    //métodos get   
    public Jugador getJugadorActual() {
       
        return jugadores.get(indiceJugadorActual);
        
    }
    
    public int getIndiceJugadorActual() {
        
        return indiceJugadorActual;
        
    }
    
    public ArrayList<Jugador> getJugadores() {
        
        return jugadores;
        
    }
    
    public Tablero getTablero() {
        
        return tablero;
        
    }
    
    public Casilla getCasilla() {
        
        return tablero.getCasilla(getJugadorActual().getCasillaActual());
        
    }
    
    private void inicializaTablero (MazoSorpresas mazo) {
        
        //0 añadida por defecto en el constructor
        tablero.añadeCasilla(new CasillaCalle ("Calle Doctor Juan Sanchez", 1000, 50, 25)); //1
        tablero.añadeCasilla(new CasillaCalle ("Calle Montalban", 1500, 60, 30)); //2
        tablero.añadeCasilla(new CasillaSorpresa ("SORPRESA", mazo)); //3
        tablero.añadeCasilla(new CasillaCalle ("Calle Doctor Fleming", 2000, 75, 35)); //4
        tablero.añadeCasilla(new CasillaCalle ("Calle Arroquia Martínez", 2500, 90, 45)); //5
        tablero.añadeCasilla(new CasillaCalle ("Calle Virgen de la Fuensanta", 3000, 100, 50)); //6
        tablero.añadeCasilla(new CasillaSorpresa ("SORPRESA", mazo)); //7
        tablero.añadeCasilla(new CasillaCalle ("Calle Sierra Mágina", 3000, 100, 50)); //8
        tablero.añadeCasilla(new CasillaCalle ("Calle Sierra de Cazorla", 3000, 100, 50)); //9
        tablero.añadeCasilla(new Casilla ("Parking")); //10
        tablero.añadeCasilla(new CasillaCalle ("Calle Jaén", 3250, 110, 55)); //11
        tablero.añadeCasilla(new CasillaSorpresa ("SORPRESA", mazo)); //12
        tablero.añadeCasilla(new CasillaCalle ("Calle Jódar", 3400, 120, 60)); //13
        tablero.añadeCasilla(new CasillaCalle ("Calle Huelma", 3500, 125, 65)); //14
        tablero.añadeCasilla(new CasillaCalle ("Calle Granada", 3600, 135, 70)); //15
        tablero.añadeCasilla(new CasillaSorpresa ("SORPRESA", mazo)); //16
        tablero.añadeCasilla(new CasillaCalle ("Calle Infanta Beatriz", 3700, 140, 75)); //17
        tablero.añadeCasilla(new CasillaCalle("Avenida Emperatriz Eugenia", 3800, 145, 80)); //18
        tablero.añadeCasilla(new CasillaCalle ("Calle Altozano", 4000, 150, 125)); //19
    
    }
    
    private void inicializaMazoSopresas (Tablero tablero) {
        
        mazo.alMazo(new SorpresaPagarCobrar("Ganas la loteria. 3000 pavitos para ti", 3000));
        mazo.alMazo(new SorpresaPagarCobrar("Ibas por la calle y te roban la cartera. ¿Quién sale con tanto efectivo?... Pierdes 1000 monedas", -1000));
        mazo.alMazo(new SorpresaPagarCobrar("La herencia por ser sobrino del emperador de Nigeria. Lamentablemente no te quería mucho. Ganas 1000 monedas guineanas", 1000));
        mazo.alMazo(new SorpresaPagarCobrar("Pensabas que Andorra te salvaría...Hacienda cae sobre ti. Pagas 3000€ para construir carreteras", -3000));
        mazo.alMazo(new SorpresaPagarCobrar("Limpias el salón. Entre los cojines vas encontrando monedas. Al final eran 2000 euros. Vaya mierda de bolsillos tienes", 2000));
        mazo.alMazo(new SorpresaPagarCobrar("Tienes un Bugatti, pero sin seguro. Te chocas y a pagar broder. 2000€ te ha costado el faro nuevo", -2000));
        mazo.alMazo(new SorpresaPorCasaHotel("Compraste suelo en 2002 y ahora no vale na lo que construiste ahí. Pagas 100 por cada edificación", 100));
        mazo.alMazo(new SorpresaPorCasaHotel("Genio de los negocios. Has construído en las mejores calles de la ciudad. Ganas 100 por cada edificio", 100));
        mazo.alMazo(new SorpresaPorCasaHotel("Pero quién hace hoteles ahí, si no pasan forasteros desde 1956. Pagas 400 por cada hotel", -400));
        mazo.alMazo(new SorpresaPorCasaHotel("Que se joda airbnb, la gente prefiere tus hoteles. Ganas 300 por hotel", 300));  
        mazo.alMazo(new SorpresaConvertirme("Enhorabuena, eres el jugador especulador!",0));
        
    }
            
    private void contabilizarPasosPorSalida (Jugador jugadorActual) {
        
        if (tablero.computarPasoPorSalida())
            jugadorActual.pasaPorSalida();
        
    }
    
    /*private*/public void pasarTurno() {
        
        indiceJugadorActual++;
        indiceJugadorActual = indiceJugadorActual%jugadores.size(); //hace el módulo para que en casa de ser el ultimo jugador se ponga a 0
        
    }
    
    public void siguientePasoCompletado (OperacionJuego operacion) {
        
        estado = gestorEstados.siguienteEstado(jugadores.get(indiceJugadorActual), estado, operacion);
        
    }
    
    public boolean construirCasa (int ip) {
        
        return(jugadores.get(indiceJugadorActual).construirCasa(ip));
           
    }
    
    public boolean construirHotel(int ip) {
        
        return(jugadores.get(indiceJugadorActual).construirHotel(ip));
        
    }
    
    public boolean finalDelJuego () {
        
        boolean fin = false;
        
        for (int i = 0; i < jugadores.size() && !fin; i++) {
            
            if (jugadores.get(i).enBancarrota())
                fin = true;
            
        }
        
        return fin;
        
    }
    
    ArrayList<Jugador> ranking() {
        
        ArrayList<Jugador> array = new ArrayList();
        array = jugadores;
        
        for (int i = 0; i < jugadores.size() - 1; i++) {
            
            for (int j = 0; j < jugadores.size () - i - 1; j++) { 
            
                if (jugadores.get(j).compareTo(jugadores.get(j+1)) == 1) {
                                  
                Jugador aux = new Jugador (jugadores.get(j));
                array.add(j, array.get(j+1));
                array.add(j+1, aux);
                
                } //if
                
            } // for j
            
        } // for i
        
        return array;
              
    }
    
    public ArrayList<Jugador> ranking_pub() {
        
        return ranking();
        
    }
    
    private void contabilizarPasosPorSalida() {
        
        if(tablero.computarPasoPorSalida())
            jugadores.get(indiceJugadorActual).pasaPorSalida();
        
    }
    
    /*private*/public void avanzaJugador() {
        
        Jugador jugadorActual = getJugadorActual();
        int posicionActual = jugadorActual.getCasillaActual();
        int tirada = Dado.getInstance().tirar();
        int posicionNueva = tablero.nuevaPosicion(posicionActual, tirada);
        Casilla casilla = tablero.getCasilla(posicionNueva);
        contabilizarPasosPorSalida(jugadorActual);
        jugadorActual.moverACasilla(posicionNueva);
        casilla.recibeJugador(indiceJugadorActual, jugadores);
        
    }
    
    public OperacionJuego siguientePaso() {
        
        Jugador jugadorActual = getJugadorActual();
        OperacionJuego operacion = gestorEstados.siguienteOperacion(jugadorActual, estado);
        
        if (operacion == OperacionJuego.PASAR_TURNO) {
            
            pasarTurno();
            siguientePasoCompletado(operacion);
            
        }
        
        if (operacion == OperacionJuego.AVANZAR) {
            
            avanzaJugador();
            siguientePasoCompletado(operacion);
            
        }
        
        return operacion;
        
    }
    
    public boolean comprar() {
        
        boolean res;
        
        Jugador jugadorActual = getJugadorActual();
        int numCasillaActual = jugadorActual.getCasillaActual();
        Casilla casilla = tablero.getCasilla(numCasillaActual);
        res = jugadorActual.comprar(casilla);
        
        return res;
        
    }    
}
