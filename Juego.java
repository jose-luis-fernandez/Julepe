import java.util.ArrayList;
import java.util.Random;
/**
 * Write a description of class Juego here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Juego
{
    // Mazo de cartas con el que se juega
    private Mazo mazo;
    // Nombres posibles para los jugadores
    private String[] nombresJugadores = {"Juan", "Maria", "Pedro", "Antonio", "Ana", "Jose", "Lidia","Fran", "Javier", "Sandra"};
    // Array que almacena los jugadores
    private Jugador[] jugadores;
    // Atributo que guarda el palo que pinta, que es la ultima carta repartida
    private int paloQuePinta;

    private Jugador jugadorHumano;

    /**
     * Constructor for objects of class Juego
     */
    public Juego(int numeroJugadores, String nombreJugadorHumano)
    {
        // initialise instance variables
        mazo = new Mazo();
        jugadores = new Jugador[numeroJugadores];
        jugadorHumano = new Jugador(nombreJugadorHumano);
        jugadores[0] = jugadorHumano;
        Random aleatorio = new Random();
        System.out.println("Bienvenido a esta partida de julepe, " + jugadores[0].verNombreJugador());
        System.out.println("Tus rivales son:");
        for (int i = 1;i < numeroJugadores;i++){
            int x = aleatorio.nextInt(10);
            if (nombresJugadores[x] != null){
                jugadores[i] = new Jugador(nombresJugadores[x]);
                nombresJugadores[x] = null;
            }
            else{
                i--;
            }
            System.out.println(jugadores[i].verNombreJugador());
        }
    }

    public int repartir()
    {
        mazo.barajar();
        int i = 0;
        Carta nuevaCarta = null;
        while (i < 5){
            int j = 0;
            while (j < jugadores.length){
                nuevaCarta = mazo.sacarCarta();
                jugadores[j].recibirCarta(nuevaCarta);
                j++;
            }
            i++;
        }
        paloQuePinta = nuevaCarta.getPalo();
        String textoPalo = "";
        switch (paloQuePinta){
            case 0: textoPalo = "Pintan oros";break;
            case 1: textoPalo = "Pintan copas";break;
            case 2: textoPalo = "Pintan espadas";break;
            case 3: textoPalo = "Pintan bastos";break;
        }
        System.out.println(textoPalo);
        System.out.println("#### Cartas De: " + jugadores[0].verNombreJugador() + " ####");
        jugadores[0].verCartasJugador();
        return paloQuePinta;
    }

    public void hacerTrampasYVerCartasDeJugador(String nombreJugador)
    {
        boolean buscando = true;
        int i = 0;
        while (i < jugadores.length && buscando){
            if (jugadores[i].verNombreJugador().equals(nombreJugador)){
                jugadores[i].verCartasJugador();
                buscando = false;
            }
            i++;
        }
    }

    public void verCartasJugadorHumano()
    {
        jugadores[0].verCartasJugador();
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
