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

public class Civitas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        //1
        int jugadores = 4;
        int turnoDe = 0;
        int contadorCero = 0;
        int contadorUno = 0;
        int contadorDos = 0;
        int contadorTres = 0;
        for (int i = 0; i < 100; i++) {
            
            turnoDe = Dado.getInstance().quienEmpieza(jugadores);
            if (turnoDe == 0)
                contadorCero++;
            if (turnoDe == 1)
                contadorUno++;
            if (turnoDe == 2)
                contadorDos++;
            if (turnoDe == 3)
                contadorTres++;
            //System.out.println("Es el turno del jugador:" + turnoDe);           
         
        }
        
        System.out.println("Veces 0 = " + contadorCero + "\nVeces 1 = " + contadorUno + "\nVeces 2 = " + contadorDos + "\nVeces 3 = " + contadorTres);
        
        //2
        Dado.getInstance().setDebug(true);
        for (int i = 0; i < 10; i++) {
            
            int tirada = Dado.getInstance().tirar();
            System.out.println("Estoy en modo debug.\nEl dado muestra: " + tirada);
        
        }
        
        Dado.getInstance().setDebug(false);
        for (int i = 0; i < 10; i++) {
            
            int tirada = Dado.getInstance().tirar();
            System.out.println("El dado muestra: " + tirada);
        
        }
        
        //3
        int ultimaTirada;
        ultimaTirada = Dado.getInstance().getUltimoResultado();
        System.out.println("El ultimo digito del dado fue:" + ultimaTirada);
        
        //4
        System.out.println("Un dato del enumerado de las casillas: " + TipoCasilla.CALLE);
        System.out.println("Un dato del enuerado del tipo de las sorpresas: " + TipoSorpresa.PORCASAHOTEL);
        
        //5
        Tablero tablero_pruebas = new Tablero();
        Casilla casilla1 = new Casilla (TipoCasilla.CALLE, "Camino de Ronda", 500000, 10000, 1000);
        Casilla casilla2 = new Casilla (TipoCasilla.DESCANSO, "Parking", 0, 0, 0);
        Casilla casilla3 = new Casilla (TipoCasilla.SORPRESA, "SORPRESA", 0, 0, 0);
        tablero_pruebas.añadeCasilla(casilla1);
        tablero_pruebas.añadeCasilla(casilla2);
        tablero_pruebas.añadeCasilla(casilla3);
        
        System.out.println ("Casilla 1: " + tablero_pruebas.getCasilla(1).toString());
        System.out.println ("Casilla 2: " + tablero_pruebas.getCasilla(2).toString());
        System.out.println ("Casilla 3: " + tablero_pruebas.getCasilla(3).toString());
        
        //6
        // No lo hago 
        
        //7
        System.out.println(Diario.getInstance().leerEvento());
    
        //8
        int tirada = 1;
        int casillaActual = 0;
        
        System.out.println("Estoy en la casilla: " + tablero_pruebas.getCasilla(tablero_pruebas.nuevaPosicion(casillaActual, tirada)));
        */
    }
    
}
