package vistaTextualCivitas;

import civitas.Casilla;
import civitas.CivitasJuego;
import civitas.Diario;
import civitas.OperacionJuego;
import controladorCivitas.Respuesta;
import civitas.OperacionInmobiliaria;
import civitas.Jugador;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class VistaTextual implements Vista {
  
    
  private static String separador = "=====================";
  
  private Scanner in;
  
  private CivitasJuego juegoModel;
  private int iPropiedad;
  private int iGestion;
  
  
  public VistaTextual (CivitasJuego juegoModel) {
    in = new Scanner (System.in);
    this.juegoModel=juegoModel;
    this.iPropiedad = -1;
    this.iGestion = -1;
  }
  
  
  public void actualiza() {
      
      if (!juegoModel.finalDelJuego()) {
          
          System.out.println(juegoModel.getJugadorActual().toString());
          System.out.println(juegoModel.getCasilla().toString());
          
      }
      
      else {
          
              System.out.println(juegoModel.getJugadores().toString());
          
      }
      
  }
  
           
 public  void pausa() {
    System.out.print ("\nPulsa una tecla");
    in.nextLine();
  }

  int leeEntero (int max, String msg1, String msg2) {
    Boolean ok;
    String cadena;
    int numero = -1;
    do {
      System.out.print (msg1);
      cadena = in.nextLine();
      try {  
        numero = Integer.parseInt(cadena);
        ok = true;
      } catch (NumberFormatException e) { // No se ha introducido un entero
        System.out.println (msg2);
        ok = false;  
      }
      if (ok && (numero < 0 || numero >= max)) {
        System.out.println (msg2);
        ok = false;
      }
    } while (!ok);

    return numero;
  }

  int menu (String titulo, ArrayList<String> lista) {
    String tab = "  ";
    int opcion;
    System.out.println (titulo);
    for (int i = 0; i < lista.size(); i++) {
      System.out.println (tab+i+"-"+lista.get(i));
    }

    opcion = leeEntero(lista.size(),
                          "\n"+tab+"Elige una opción: ",
                          tab+"Valor erróneo");
    return opcion;
  }

  public Respuesta comprar() {
        
       ArrayList<String> respuestas = new ArrayList (); //aqui guardo las respuestas que se le dan al user
       respuestas.add("SI -> Pulsa 0");
       respuestas.add("NO -> Pulsa 1");
       int respuesta; //aqui guardo la opcion
        
       respuesta = menu ("¿Desea comprar la calle?", respuestas); 
       
       Respuesta salida = Respuesta.NO;
       
       if (respuesta == 0)
           salida = Respuesta.SI;
       
       if (respuesta == 1)
           salida = Respuesta.NO;
       
       return salida;
       
  }
  
  public OperacionInmobiliaria elegirOperacion() {
      
      ArrayList<String> respuestas = new ArrayList (); //aqui guardo las respuestas que se le dan al user
      respuestas.add("Construir casa");
      respuestas.add("Construir hotel");
      respuestas.add("Terminar turno");
      int respuesta; //aqui guardo la opcion
      
      respuesta = menu ("¿Que quieres hacer", respuestas);
      
      OperacionInmobiliaria salida = OperacionInmobiliaria.TERMINAR;
       
      if (respuesta == 0)
           salida = OperacionInmobiliaria.CONSTRUIR_CASA;
       
      if (respuesta == 1)
           salida = OperacionInmobiliaria.CONSTRUIR_HOTEL;
       
      if (respuesta == 2)
          salida = OperacionInmobiliaria.TERMINAR;
      
      return salida;
      
  }
  
  public int elegirPropiedad() {
      
      juegoModel.getJugadorActual();
      
      int salida;
      ArrayList<String> respuestas = new ArrayList<> ();
      ArrayList<Casilla> propiedades = juegoModel.getJugadorActual().getPropiedadesPub();
      for (int i = 0; i < propiedades.size(); i++) {
          
        respuestas.add(propiedades.get(i).getNombrePub());
        
      }
      
      salida = menu ("¿En que propiedad quieres realizar la gestión?", respuestas);
      
      return salida; //resto el 1 que se lo sumo al indice en el menu
      
  }
  
  public void mostrarSiguienteOperacion(OperacionJuego operacion) {
      
      System.out.println("Lo siguiente que se hará será: " + operacion.toString());
      
  }
  
  public void mostrarEventos() {
      
      while (Diario.getInstance().eventosPendientes()) {
          
          System.out.println(Diario.getInstance().leerEvento());
          
      }
      
  }
  
  public void mostrarEstado() {
      
      if (!juegoModel.finalDelJuego()) {
          
          System.out.println(juegoModel.getJugadorActual().toString());
          System.out.println(juegoModel.getCasilla().toString());
          
      }
      
      else {
          
              System.out.println(juegoModel.getJugadores().toString());
          
      }
      
  }
  
}
