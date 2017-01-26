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

    /**
     * Constructor for objects of class Juego
     */
    public Juego(int numeroJugadores)
    {
        // initialise instance variables
       mazo = new Mazo();
       jugadores = new Jugador[numeroJugadores];
       Random aleatorio = new Random();
       for (int i = 0;i < numeroJugadores;i++){
           int x = aleatorio.nextInt(10);
           if (nombresJugadores[x] != null){
               jugadores[i] = new Jugador(nombresJugadores[x]);
               nombresJugadores[x] = null;
           }
           else{
               i--;
           } 
        }
    }
    
    public void repartir()
    {
        mazo.barajar();
        int i = 0;
        Carta cartaQuePinta = null;
        while (i < 5){
            int j = 0;
            while (j < jugadores.length){
                
                if (i == 4 && j == (jugadores.length - 1)){
                    cartaQuePinta = mazo.sacarCarta();
                    jugadores[j].recibirCarta(cartaQuePinta);
                }
                else{
                    jugadores[j].recibirCarta(mazo.sacarCarta());
                }
                j++;
            }
            i++;
        }
        paloQuePinta = cartaQuePinta.getPalo();
    }
    
    public void verCartasJugador(String nombreJugador)
    {
        for (int i = 0;i < jugadores.length;i++){
            if (jugadores[i].verNombreJugador().equals(nombreJugador)){
                jugadores[i].verCartasJugador();
            }
        }
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
